package com.example.trabalhofinal;

import dao.Pre_pedidobebidaDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import model.pizza;
import dao.PizzaDAO;
import model.pre_pedidobebida;
import model.pre_pedidopizza;
import dao.Pre_pedidopizzaDAO;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CardapioClienteController implements Initializable {

    @FXML
    private Button anterior;

    @FXML
    private Button botaoBebidas;

    @FXML
    private Button botaoCaarrinho;

    @FXML
    private Button botaoEnviar;

    @FXML
    private Button botaoFechar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Label carrinhoLabel;

    @FXML
    private Circle circulo;

    @FXML
    private ToggleGroup essapizza;

    @FXML
    private ImageView imaagemPizzaGrande;

    @FXML
    private ImageView imagemBolsa;

    @FXML
    private ImageView imagemCopo;

    @FXML
    private ImageView imagemPizza;

    @FXML
    private ImageView imagemPizza1;

    @FXML
    private ImageView imagemPizza2;

    @FXML
    private ImageView imagemPizza3;

    @FXML
    private ImageView imagemPizza4;

    @FXML
    private ImageView imagemPrincipal;

    @FXML
    private ImageView imagemVoltar;

    @FXML
    private Line linhaCarrinho;

    @FXML
    private Line linhaDoMeio;

    @FXML
    private Line linhaTamanho;

    @FXML
    private Label nomepizza1;

    @FXML
    private Label nomepizza2;

    @FXML
    private Label nomepizza3;

    @FXML
    private Label nomepizza4;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private RadioButton pizza1;

    @FXML
    private RadioButton pizza2;

    @FXML
    private RadioButton pizza3;

    @FXML
    private RadioButton pizza4;

    @FXML
    private Label pizzasDaCasaLabel;

    @FXML
    private Button proximo;

    @FXML
    private AnchorPane quadradoPizza;

    @FXML
    private RadioButton radioGrande;

    @FXML
    private RadioButton radioMedio;

    @FXML
    private RadioButton radioPequeno;

    @FXML
    private AnchorPane retanguloCarrinho;

    @FXML
    private AnchorPane retanguloCima;

    @FXML
    private AnchorPane retanguloDeCima;

    @FXML
    private AnchorPane retanguloPort1;

    @FXML
    private AnchorPane retanguloPort2;

    @FXML
    private AnchorPane retanguloPort3;

    @FXML
    private AnchorPane retanguloPort4;

    @FXML
    private ToggleGroup selecionar;

    @FXML
    private Label tamanhoLabel;

    @FXML
    private Label valorPizza1;

    @FXML
    private Label valorPizza2;

    @FXML
    private Label valorPizza3;

    @FXML
    private Label valorPizza4;

    int proximos = 0;
    int listaPizzaant = 0;
    int total =0;
    int posicao =1;
    int com=0;
    int quantidade=0;
    int listaPizza = 1;
    long idpizza1=0l,idpizza2=0l,idpizza3=0l,idpizza4=0l;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        circulo.setOpacity(0);
        pre_pedidobebida prePedidobebida = new pre_pedidobebida();
        Pre_pedidobebidaDAO pre_PedidobebidaDAO = new Pre_pedidobebidaDAO();
        List<pre_pedidobebida> prePedidobebidaList = pre_PedidobebidaDAO.findall();

        pre_pedidopizza prepedidopizza = new pre_pedidopizza();
        Pre_pedidopizzaDAO pre_PedidopizzaDAO = new Pre_pedidopizzaDAO();
        List<pre_pedidopizza> prePedidopizzaList = pre_PedidopizzaDAO.findall();

        for (pre_pedidopizza p : prePedidopizzaList){
            if (p.getIdcliente()==LoginClienteController.getIdcliente()) {
                circulo.setOpacity(100);
            }
        }
        for (pre_pedidobebida b : prePedidobebidaList){
            if (b.getIdclinte()==LoginClienteController.getIdcliente()) {
                circulo.setOpacity(100);
            }
        }

        nomepizza1.setText(null);
        valorPizza1.setText(null);
        imagemPizza1.setImage(null);
        pizza1.setOpacity(0);

        nomepizza2.setText(null);
        valorPizza2.setText(null);
        imagemPizza2.setImage(null);
        pizza2.setOpacity(0);

        nomepizza3.setText(null);
        valorPizza3.setText(null);
        imagemPizza3.setImage(null);
        pizza3.setOpacity(0);

        nomepizza4.setText(null);
        valorPizza4.setText(null);
        imagemPizza4.setImage(null);
        pizza4.setOpacity(0);


        pizza Pizza =new pizza();
        PizzaDAO PizzaDAO = new PizzaDAO();
        List<pizza> pizzaList = PizzaDAO.findall();

        for (pizza p : pizzaList){
            posicao= posicao+1;
            if (listaPizza == 1){
                nomepizza1.setText(p.getNomeProduto());
                valorPizza1.setText(p.getValor().toString());
                imagemPizza1.setImage(new Image(p.getImagem().toString()));
                pizza1.setOpacity(100);
                idpizza1=p.getIdPizza();
                listaPizza = listaPizza + 1;
            }else {
                if (listaPizza == 2){
                    nomepizza2.setText(p.getNomeProduto());
                    valorPizza2.setText(p.getValor().toString());
                    imagemPizza2.setImage(new Image(p.getImagem().toString()));
                    pizza2.setOpacity(100);
                    idpizza2=p.getIdPizza();
                    listaPizza = listaPizza + 1;
                }else {
                    if (listaPizza == 3){
                        nomepizza3.setText(p.getNomeProduto());
                        valorPizza3.setText(p.getValor().toString());
                        imagemPizza3.setImage(new Image(p.getImagem().toString()));
                        pizza3.setOpacity(100);
                        idpizza3=p.getIdPizza();
                        listaPizza = listaPizza + 1;
                    }else {
                        if (listaPizza == 4){
                            nomepizza4.setText(p.getNomeProduto());
                            valorPizza4.setText(p.getValor().toString());
                            imagemPizza4.setImage(new Image(p.getImagem().toString()));
                            pizza4.setOpacity(100);
                            idpizza4=p.getIdPizza();
                            proximos = 4;
                            listaPizza = listaPizza + 1;
                        }
                    }
                }
            }
        }


        proximo.setOnMouseClicked((event)->{
            System.out.println("pro "+proximos+" pos"+posicao);
            if (proximos+1<posicao) {
                listaPizza =0;
                proximos = proximos+4;
                nomepizza1.setText(null);
                valorPizza1.setText(null);
                imagemPizza1.setImage(null);
                pizza1.setOpacity(0);
                nomepizza2.setText(null);
                valorPizza2.setText(null);
                imagemPizza2.setImage(null);
                pizza2.setOpacity(0);
                nomepizza3.setText(null);
                valorPizza3.setText(null);
                imagemPizza3.setImage(null);
                pizza3.setOpacity(0);
                nomepizza4.setText(null);
                valorPizza4.setText(null);
                imagemPizza4.setImage(null);
                pizza4.setOpacity(0);
                for (pizza p : pizzaList) {
                    if (listaPizza == proximos - 3) {
                        nomepizza1.setText(p.getNomeProduto());
                        valorPizza1.setText(p.getValor().toString());
                        imagemPizza1.setImage(new Image(p.getImagem().toString()));
                        pizza1.setOpacity(100);
                        idpizza1=p.getIdPizza();
                    } else {
                        if (listaPizza == proximos - 2) {
                            nomepizza2.setText(p.getNomeProduto());
                            valorPizza2.setText(p.getValor().toString());
                            imagemPizza2.setImage(new Image(p.getImagem().toString()));
                            pizza2.setOpacity(100);
                            idpizza2=p.getIdPizza();
                        } else {
                            if (listaPizza == proximos - 1) {
                                nomepizza3.setText(p.getNomeProduto());
                                valorPizza3.setText(p.getValor().toString());
                                imagemPizza3.setImage(new Image(p.getImagem().toString()));
                                pizza3.setOpacity(100);
                                idpizza3=p.getIdPizza();
                            } else {
                                if (listaPizza == proximos) {
                                    nomepizza4.setText(p.getNomeProduto());
                                    valorPizza4.setText(p.getValor().toString());
                                    imagemPizza4.setImage(new Image(p.getImagem().toString()));
                                    pizza4.setOpacity(100);
                                    idpizza4=p.getIdPizza();
                                }
                            }
                        }
                    }
                    listaPizza = listaPizza + 1;
                }
            }
        });


        anterior.setOnMouseClicked((event)->{
            if (proximos >4) {
                listaPizza =0;
                proximos = proximos-4;
                nomepizza1.setText(null);
                valorPizza1.setText(null);
                imagemPizza1.setImage(null);
                pizza1.setOpacity(0);
                nomepizza2.setText(null);
                valorPizza2.setText(null);
                imagemPizza2.setImage(null);
                pizza2.setOpacity(0);
                nomepizza3.setText(null);
                valorPizza3.setText(null);
                imagemPizza3.setImage(null);
                pizza3.setOpacity(0);
                nomepizza4.setText(null);
                valorPizza4.setText(null);
                imagemPizza4.setImage(null);
                pizza4.setOpacity(0);

                for (pizza p : pizzaList) {
                    if (listaPizza == proximos-4) {
                        nomepizza1.setText(p.getNomeProduto());
                        valorPizza1.setText(p.getValor().toString());
                        imagemPizza1.setImage(new Image(p.getImagem().toString()));
                        pizza1.setOpacity(100);
                        idpizza1=p.getIdPizza();
                    } else {
                        if (listaPizza == proximos-3) {
                            nomepizza2.setText(p.getNomeProduto());
                            valorPizza2.setText(p.getValor().toString());
                            imagemPizza2.setImage(new Image(p.getImagem().toString()));
                            pizza2.setOpacity(100);
                            idpizza2=p.getIdPizza();
                        } else {
                            if (listaPizza == proximos-2) {
                                nomepizza3.setText(p.getNomeProduto());
                                valorPizza3.setText(p.getValor().toString());
                                imagemPizza3.setImage(new Image(p.getImagem().toString()));
                                pizza3.setOpacity(100);
                                idpizza3=p.getIdPizza();
                            } else {
                                if (listaPizza == proximos-1) {
                                    nomepizza4.setText(p.getNomeProduto());
                                    valorPizza4.setText(p.getValor().toString());
                                    imagemPizza4.setImage(new Image(p.getImagem().toString()));
                                    pizza4.setOpacity(100);
                                    idpizza4=p.getIdPizza();
                                }
                            }
                        }
                    }
                    listaPizza = listaPizza + 1;
                }
            }
        });

        botaoEnviar.setOnMouseClicked((event)->{
            pre_pedidopizza pre_pedidopizza = new pre_pedidopizza();
            Pre_pedidopizzaDAO pre_pedidopizzaDAO = new Pre_pedidopizzaDAO();
            if(pizza1.isSelected()){
                pre_pedidopizza.setValortotal(Float.valueOf(valorPizza1.getText()));
                pre_pedidopizza.setSabor(nomepizza1.getText());
                pre_pedidopizza.setIdPizza(idpizza1);
            }else {
                if(pizza2.isSelected()){
                    pre_pedidopizza.setValortotal(Float.valueOf(valorPizza2.getText()));
                    pre_pedidopizza.setSabor(nomepizza2.getText());
                    pre_pedidopizza.setIdPizza(idpizza2);
                }else {
                    if(pizza3.isSelected()){
                        pre_pedidopizza.setValortotal(Float.valueOf(valorPizza3.getText()));
                        pre_pedidopizza.setSabor(nomepizza3.getText());
                        pre_pedidopizza.setIdPizza(idpizza3);
                    }else {
                        if(pizza4.isSelected()){
                            pre_pedidopizza.setValortotal(Float.valueOf(valorPizza4.getText()));
                            pre_pedidopizza.setSabor(nomepizza4.getText());
                            pre_pedidopizza.setIdPizza(idpizza4);
                        }
                    }
                }
            }
            if (radioPequeno.isSelected()){
                pre_pedidopizza.setTamanho(radioPequeno.getText());
            }
            if (radioMedio.isSelected()){
                pre_pedidopizza.setTamanho(radioMedio.getText());
            }
            if (radioGrande.isSelected()){
                pre_pedidopizza.setTamanho(radioGrande.getText());
            }
            pre_pedidopizza.setIdcliente(LoginClienteController.getIdcliente());
            pre_pedidopizzaDAO.create(pre_pedidopizza);
            PrincipalCardapioCliente principalCardapioCliente = new PrincipalCardapioCliente();
            PrincipalCardapioCliente.getStage().close();
            try {
                principalCardapioCliente.start(new Stage());
            }catch (Exception e){

            }
        });

        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalGeral principalGeral = new PrincipalGeral();
            PrincipalCardapioCliente.getStage().close();
            try{
                principalGeral.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoBebidas.setOnMouseClicked((event)->{
            PrincipalBebidasCliente principalBebidasCliente = new PrincipalBebidasCliente();
            PrincipalCardapioCliente.getStage().close();
            try{
                principalBebidasCliente.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoCaarrinho.setOnMouseClicked((event)->{
            PrincipalCarrinhoCliente principalCarrinhoCliente = new PrincipalCarrinhoCliente();
            PrincipalCardapioCliente.getStage().close();
            try{
                principalCarrinhoCliente.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoFechar.setOnMouseClicked((event)->{
            PrincipalCardapioCliente.getStage().close();
        });

    }
}
