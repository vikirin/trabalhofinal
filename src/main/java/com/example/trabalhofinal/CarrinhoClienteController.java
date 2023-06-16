package com.example.trabalhofinal;

import dao.Pre_pedidobebidafinalDAO;
import dao.Pre_pedidopizzafinalDAO;
import jasper.jaspercontroller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import dao.Pre_pedidobebidaDAO;
import dao.Pre_pedidopizzaDAO;
import model.pre_pedidobebida;
import model.pre_pedidobebidafinal;
import model.pre_pedidopizza;
import model.pre_pedidopizzafinal;
import net.sf.jasperreports.engine.JRException;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CarrinhoClienteController implements Initializable {

    @FXML
    private Label bebida;

    @FXML
    private Button botaoBebidas;

    @FXML
    private Button botaoEditarPedido;

    @FXML
    private Button botaoFechar;

    @FXML
    private Button botaoFinalizar;

    @FXML
    private Button botaoPizza;

    @FXML
    private Button botaoVoltar;

    @FXML
    private ImageView imagemCarrinho;

    @FXML
    private ImageView imagemCopo;

    @FXML
    private ImageView imagemPizza;

    @FXML
    private ImageView imagemVoltar;

    @FXML
    private Label listabebida;

    @FXML
    private Label listapizza;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private Label pizza;

    @FXML
    private AnchorPane retanguloCima;

    @FXML
    private AnchorPane retanguloGrande;

    @FXML
    private ScrollPane scrollbebida;

    @FXML
    private ScrollPane scrollpiizza;

    @FXML
    private Label tituloLabel;

    @FXML
    private Label totalLabel;

    @FXML
    private Label valortotal;

    float total=0f;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pre_pedidobebida prePedidobebida = new pre_pedidobebida();
        Pre_pedidobebidaDAO pre_PedidobebidaDAO = new Pre_pedidobebidaDAO();
        List<pre_pedidobebida> prePedidobebidaList = pre_PedidobebidaDAO.findall();

        pre_pedidopizza prepedidopizza = new pre_pedidopizza();
        Pre_pedidopizzaDAO pre_PedidopizzaDAO = new Pre_pedidopizzaDAO();
        List<pre_pedidopizza> prePedidopizzaList = pre_PedidopizzaDAO.findall();

        for (pre_pedidopizza p : prePedidopizzaList){
            if (p.getIdcliente()==LoginClienteController.getIdcliente()) {
                listapizza.setText(listapizza.getText() + "Pizza de " + p.getSabor() + " de tamanho " + p.getTamanho() + " de valor " + p.getValortotal() + "\n");
                total = p.getValortotal() + total;
            }
        }
        for (pre_pedidobebida b : prePedidobebidaList){
            if (b.getIdclinte()==LoginClienteController.getIdcliente()) {
                listabebida.setText(listabebida.getText() + "" + b.getNomebebida() + " de valor " + b.getValortotal() + " quantidade " + b.getQuantidade() + "\n");
                total = b.getValortotal() + total;
            }
        }

        valortotal.setText(String.valueOf(total));

        pre_pedidobebidafinal prePedidobebidafinal = new pre_pedidobebidafinal();
        Pre_pedidobebidafinalDAO pre_PedidobebidafinalDAO = new Pre_pedidobebidafinalDAO();
        List<pre_pedidobebidafinal> prePedidobebidafinalList = pre_PedidobebidafinalDAO.findall();

        pre_pedidopizzafinal prepedidopizzafinal = new pre_pedidopizzafinal();
        Pre_pedidopizzafinalDAO pre_PedidopizzafinalDAO = new Pre_pedidopizzafinalDAO();
        List<pre_pedidopizzafinal> prePedidopizzafinalList = pre_PedidopizzafinalDAO.findall();

        botaoFinalizar.setOnMouseClicked((event)->{
            for (pre_pedidopizza p : prePedidopizzaList){
                if (p.getIdcliente()==LoginClienteController.getIdcliente()) {
                    prepedidopizzafinal.setValortotal(p.getValortotal());
                    prepedidopizzafinal.setIdcliente(p.getIdcliente());
                    prepedidopizzafinal.setTamanho(p.getTamanho());
                    prepedidopizzafinal.setIdPizza(p.getIdPizza());
                    prepedidopizzafinal.setSabor(p.getSabor());
                    pre_PedidopizzafinalDAO.create(prepedidopizzafinal);

                }
            }




            for (pre_pedidobebida b : prePedidobebidaList){
                if (b.getIdclinte()==LoginClienteController.getIdcliente()) {
                    prePedidobebidafinal.setIdclinte(b.getIdclinte());
                    prePedidobebidafinal.setIdbebida(b.getIdbebida());
                    prePedidobebidafinal.setQuantidade(b.getQuantidade());
                    prePedidobebidafinal.setValortotal(b.getValortotal());
                    prePedidobebidafinal.setNomebebida(b.getNomebebida());
                    pre_PedidobebidafinalDAO.create(prePedidobebidafinal);
                }
            }
            jaspercontroller controller;
            controller =new jaspercontroller();
            try {
                controller.gerarRelatorio();
            } catch (JRException e) {
                throw new RuntimeException(e);
            }
            /*for (pre_pedidopizza p : prePedidopizzaList){
                if (p.getIdcliente()==LoginClienteController.getIdcliente()) {
                    pre_PedidopizzaDAO.delete(p.getIdPedido());
                }
            }
            for (pre_pedidobebida b : prePedidobebidaList){
                if (b.getIdclinte()==LoginClienteController.getIdcliente()) {
                    pre_PedidobebidaDAO.delete(b.getIdpedido());
                }
            }*/
            PrincipalCarrinhoCliente principalCarrinhoCliente = new PrincipalCarrinhoCliente();
            PrincipalCarrinhoCliente.getStage().close();
            try{
                principalCarrinhoCliente.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalCardapioCliente principalCardapioCliente = new PrincipalCardapioCliente();
            PrincipalCarrinhoCliente.getStage().close();
            try{
                principalCardapioCliente.start(new Stage());
            }catch(Exception e){

            }
        });


        botaoBebidas.setOnMouseClicked((event)->{
            PrincipalBebidasCliente principalBebidasCliente = new PrincipalBebidasCliente();
            PrincipalCarrinhoCliente.getStage().close();
            try{
                principalBebidasCliente.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoPizza.setOnMouseClicked((event)->{
            PrincipalCardapioCliente principalCardapioCliente = new PrincipalCardapioCliente();
            PrincipalCarrinhoCliente.getStage().close();
            try{
                principalCardapioCliente.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoEditarPedido.setOnMouseClicked((event)->{
            for (pre_pedidopizza p : prePedidopizzaList){
                if (p.getIdcliente()==LoginClienteController.getIdcliente()) {
                    pre_PedidopizzaDAO.delete(p.getIdPedido());
                }
            }
            for (pre_pedidobebida b : prePedidobebidaList){
                if (b.getIdclinte()==LoginClienteController.getIdcliente()) {
                    pre_PedidobebidaDAO.delete(b.getIdpedido());
                }
            }
            PrincipalCardapioCliente principalCardapioCliente = new PrincipalCardapioCliente();
            PrincipalCarrinhoCliente.getStage().close();
            try{
                principalCardapioCliente.start(new Stage());
            }catch(Exception e){

            }
        });
    }
}

