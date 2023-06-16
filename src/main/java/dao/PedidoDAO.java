package dao;

import inter.ipedidoDAO;
import model.pedido;
import config.connectionFactory;
import inter.ipedidoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoDAO implements ipedidoDAO {

    @Override
    public pedido create(pedido pedido) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "INSERT INTO pre-pedido"
                    +"(tamanho,sabor,valorTotal,bebida,nomeCliente)"+
                    " VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,pedido.getTamanho());
            statement.setString(2,pedido.getSabor());
            statement.setFloat(3,pedido.getValortotal());
            statement.setString(4,pedido.getBebida());
            statement.setString(5,pedido.getNomeCliente());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            long idPedidoGerado = resultSet.getLong(1);
            pedido.setIdPedido(idPedidoGerado);
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return pedido;
    }

    @Override
    public pedido update(pedido pedido) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "UPDATE pedido SET "
                    +"tamanho = ?,sabor = ?,valorTotal = ?," +
                    "bebida = ?,nomeCliente = ? "+
                    "WHERE idPedido = ? ;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,pedido.getTamanho());
            statement.setString(2,pedido.getSabor());
            statement.setFloat(3,pedido.getValortotal());
            statement.setString(4,pedido.getBebida());
            statement.setString(5,pedido.getNomeCliente());
            statement.setLong(6,pedido.getIdPedido());
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return pedido;
    }

    @Override
    public void delete(Long idPedido) {
        try(Connection connection = connectionFactory.getConnection()){
            String query = "DELETE FROM pedido WHERE idPedido = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idPedido);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public List<pedido> findall() {
        String query = "SElECT * FROM pedido";
        List<pedido> lista = new ArrayList<>();
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                pedido pedido=new pedido();
                pedido.setTamanho(rs.getString("tamanho"));
                pedido.setSabor(rs.getString("sabor"));
                pedido.setValortotal(rs.getFloat("valortotal"));
                pedido.setIdPedido(rs.getLong("idPedido"));
                pedido.setBebida(rs.getString("bebida"));
                pedido.setNomeCliente(rs.getString("nomeCliente"));
                lista.add(pedido);
            }
        }catch (SQLException e){
            throw new RuntimeException();
        }
        return lista;
    }

    @Override
    public Optional<pedido> findbyID(Long idPedido) {
        String query = "SELECT * FROM produto WHERE idPedido = ?;";
        pedido pedido;
        try(Connection connection = connectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,idPedido);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            rs.next();
            pedido = new pedido(
                    rs.getString("tamanho"),
                    rs.getString("sabor"),
                    rs.getFloat("valortotal"),
                    rs.getLong("idPedido"),
                    rs.getString("bebida"),
                    rs.getString("nomeCliente")
            );

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(pedido);
    }
}
