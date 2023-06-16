package inter;

import model.pedido;

import java.util.List;
import java.util.Optional;

public interface ipedidoDAO {
    pedido create (pedido pedido);
    pedido update (pedido pedido);
    void delete (Long idPedido);
    List<pedido> findall();
    Optional<pedido> findbyID (Long idPedido);
}
