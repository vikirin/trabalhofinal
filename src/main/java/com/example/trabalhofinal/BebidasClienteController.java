package com.example.trabalhofinal;

import dao.BebidaDAO;
import dao.Pre_pedidopizzaDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import model.bebida;
import model.pre_pedidobebida;
import dao.Pre_pedidobebidaDAO;
import model.pre_pedidopizza;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BebidasClienteController implements Initializable {

    @FXML
    private Button anterior;

    @FXML
    private CheckBox bebida1;

    @FXML
    private CheckBox bebida2;

    @FXML
    private CheckBox bebida3;

    @FXML
    private CheckBox bebida4;

    @FXML
    private Button botaoCaarrinho;

    @FXML
    private Button botaoEnviarPedido;

    @FXML
    private Button botaoPizza;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Label carrinhoLabel;

    @FXML
    private Circle ciruculo;

    @FXML
    private ImageView imagemBebe;

    @FXML
    private ImageView imagemBebida;

    @FXML
    private ImageView imagemBebidas;

    @FXML
    private ImageView imagemBolsa;

    @FXML
    private ImageView imagemPizza;

    @FXML
    private ImageView imagemVoltar;

    @FXML
    private ImageView imagembebida1;

    @FXML
    private ImageView imagembebida2;

    @FXML
    private ImageView imagembebida3;

    @FXML
    private ImageView imagembebida4;

    @FXML
    private Line linhaCarrinho;

    @FXML
    private Line linhaCentral;

    @FXML
    private Button mais1;

    @FXML
    private Button mais2;

    @FXML
    private Button mais3;

    @FXML
    private Button mais4;

    @FXML
    private Button menos1;

    @FXML
    private Button menos2;

    @FXML
    private Button menos3;

    @FXML
    private Button menos4;

    @FXML
    private Label nomebebida1;

    @FXML
    private Label nomebebida2;

    @FXML
    private Label nomebebida3;

    @FXML
    private Label nomebebida4;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private Button proximo;

    @FXML
    private AnchorPane quadradoBebe;

    @FXML
    private AnchorPane quadradoBebidaMaior;

    @FXML
    private Label quntidade1;

    @FXML
    private Label quntidade2;

    @FXML
    private Label quntidade3;

    @FXML
    private Label quntidade4;

    @FXML
    private AnchorPane retangulo1;

    @FXML
    private AnchorPane retangulo2;

    @FXML
    private AnchorPane retangulo3;

    @FXML
    private AnchorPane retangulo4;

    @FXML
    private AnchorPane retanguloCarrinho;

    @FXML
    private AnchorPane retanguloMaior;

    @FXML
    private AnchorPane retanguloTitulo;

    @FXML
    private Label tituloLabel;

    @FXML
    private Label valor1;

    @FXML
    private Label valor2;

    @FXML
    private Label valor3;

    @FXML
    private Label valor4;

    int proximos = 0;
    int listabebidaant = 0;
    int total =0;
    int posicao =0;
    int com=0;
    int quantidade=0;
    int listabebida = 1;
    int quan1 = 0, quan2 = 0, quan3 = 0, quan4 = 0;

    long idbebida1=0l,idbebida2=0l,idbebida3=0l,idbebida4=0l;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ciruculo.setOpacity(0);
        pre_pedidobebida prePedidobebida = new pre_pedidobebida();
        Pre_pedidobebidaDAO pre_PedidobebidaDAO = new Pre_pedidobebidaDAO();
        List<pre_pedidobebida> prePedidobebidaList = pre_PedidobebidaDAO.findall();

        pre_pedidopizza prepedidopizza = new pre_pedidopizza();
        Pre_pedidopizzaDAO pre_PedidopizzaDAO = new Pre_pedidopizzaDAO();
        List<pre_pedidopizza> prePedidopizzaList = pre_PedidopizzaDAO.findall();

        for (pre_pedidopizza p : prePedidopizzaList){
            if (p.getIdcliente()==LoginClienteController.getIdcliente()) {
                ciruculo.setOpacity(100);
            }
        }
        for (pre_pedidobebida b : prePedidobebidaList){
            if (b.getIdclinte()==LoginClienteController.getIdcliente()) {
                ciruculo.setOpacity(100);
            }
        }


        nomebebida1.setText(null);
        valor1.setText(null);
        imagembebida1.setImage(null);
        bebida1.setOpacity(0);
        menos1.setOpacity(0);
        mais1.setOpacity(0);
        quntidade1.setText(null);
        retangulo1.setOpacity(0);

        nomebebida2.setText(null);
        valor2.setText(null);
        imagembebida2.setImage(null);
        bebida2.setOpacity(0);
        menos2.setOpacity(0);
        mais2.setOpacity(0);
        quntidade2.setText(null);
        retangulo2.setOpacity(0);

        nomebebida3.setText(null);
        valor3.setText(null);
        imagembebida3.setImage(null);
        bebida3.setOpacity(0);
        menos3.setOpacity(0);
        mais3.setOpacity(0);
        quntidade3.setText(null);
        retangulo3.setOpacity(0);

        nomebebida4.setText(null);
        valor4.setText(null);
        imagembebida4.setImage(null);
        bebida4.setOpacity(0);
        menos4.setOpacity(0);
        mais4.setOpacity(0);
        quntidade4.setText(null);
        retangulo4.setOpacity(0);

        bebida bebidas = new bebida();
        BebidaDAO bebidaDAO = new BebidaDAO();
        List<bebida> bebidaList = bebidaDAO.findall();

        for(bebida b : bebidaList){
            posicao= posicao+1;
            proximos = 4;
            if (listabebida == 1){
                nomebebida1.setText(b.getNomeProduto());
                valor1.setText(b.getValor().toString());
                imagembebida1.setImage(new Image(b.getImagem().toString()));
                bebida1.setOpacity(100);
                menos1.setOpacity(100);
                mais1.setOpacity(100);
                quntidade1.setText("0");
                retangulo1.setOpacity(100);
                idbebida1 = b.getIdBebida();
                listabebida =listabebida + 1;
            }else {
                if (listabebida == 2){
                    nomebebida2.setText(b.getNomeProduto());
                    valor2.setText(b.getValor().toString());
                    imagembebida2.setImage(new Image(b.getImagem().toString()));
                    bebida2.setOpacity(100);
                    menos2.setOpacity(100);
                    mais2.setOpacity(100);
                    quntidade2.setText("0");
                    retangulo2.setOpacity(100);
                    idbebida2 = b.getIdBebida();
                    listabebida =listabebida + 1;
                }else {
                    if (listabebida == 3){
                        nomebebida3.setText(b.getNomeProduto());
                        valor3.setText(b.getValor().toString());
                        imagembebida3.setImage(new Image(b.getImagem().toString()));
                        bebida3.setOpacity(100);
                        menos3.setOpacity(100);
                        mais3.setOpacity(100);
                        quntidade3.setText("0");
                        retangulo3.setOpacity(100);
                        idbebida3 = b.getIdBebida();
                        listabebida =listabebida + 1;
                    }else {
                        if (listabebida == 4){
                            nomebebida4.setText(b.getNomeProduto());
                            valor4.setText(b.getValor().toString());
                            imagembebida4.setImage(new Image(b.getImagem().toString()));
                            bebida4.setOpacity(100);
                            menos4.setOpacity(100);
                            mais4.setOpacity(100);
                            quntidade4.setText("0");
                            retangulo4.setOpacity(100);
                            idbebida4 = b.getIdBebida();
                            listabebida =listabebida + 1;
                        }
                    }
                }
            }
        }
        proximo.setOnMouseClicked((event)->{
            if (proximos<posicao) {
                listabebida = 0;
                proximos = proximos+4;
                nomebebida1.setText(null);
                valor1.setText(null);
                imagembebida1.setImage(null);
                bebida1.setOpacity(0);
                menos1.setOpacity(0);
                mais1.setOpacity(0);
                quntidade1.setText(null);
                retangulo1.setOpacity(0);

                nomebebida2.setText(null);
                valor2.setText(null);
                imagembebida2.setImage(null);
                bebida2.setOpacity(0);
                menos2.setOpacity(0);
                mais2.setOpacity(0);
                quntidade2.setText(null);
                retangulo2.setOpacity(0);

                nomebebida3.setText(null);
                valor3.setText(null);
                imagembebida3.setImage(null);
                bebida3.setOpacity(0);
                menos3.setOpacity(0);
                mais3.setOpacity(0);
                quntidade3.setText(null);
                retangulo3.setOpacity(0);

                nomebebida4.setText(null);
                valor4.setText(null);
                imagembebida4.setImage(null);
                bebida4.setOpacity(0);
                menos4.setOpacity(0);
                mais4.setOpacity(0);
                quntidade4.setText(null);
                retangulo4.setOpacity(0);


                for (bebida b : bebidaList) {
                    listabebida = listabebida + 1;
                    if (listabebida == proximos - 3) {
                        nomebebida1.setText(b.getNomeProduto());
                        valor1.setText(b.getValor().toString());
                        imagembebida1.setImage(new Image(b.getImagem().toString()));
                        bebida1.setOpacity(100);
                        menos1.setOpacity(100);
                        mais1.setOpacity(100);
                        quntidade1.setText("0");
                        retangulo1.setOpacity(100);
                        idbebida1 = b.getIdBebida();

                    } else {
                        if (listabebida == proximos - 2) {
                            nomebebida2.setText(b.getNomeProduto());
                            valor2.setText(b.getValor().toString());
                            imagembebida2.setImage(new Image(b.getImagem().toString()));
                            bebida2.setOpacity(100);
                            menos2.setOpacity(100);
                            mais2.setOpacity(100);
                            quntidade2.setText("0");
                            retangulo2.setOpacity(100);
                            idbebida2 = b.getIdBebida();

                        } else {
                            if (listabebida == proximos - 1) {
                                nomebebida3.setText(b.getNomeProduto());
                                valor3.setText(b.getValor().toString());
                                imagembebida3.setImage(new Image(b.getImagem().toString()));
                                bebida3.setOpacity(100);
                                menos3.setOpacity(100);
                                mais3.setOpacity(100);
                                quntidade3.setText("0");
                                retangulo3.setOpacity(100);
                                idbebida3 = b.getIdBebida();

                            } else {
                                if (listabebida == proximos) {
                                    nomebebida4.setText(b.getNomeProduto());
                                    valor4.setText(b.getValor().toString());
                                    imagembebida4.setImage(new Image(b.getImagem().toString()));
                                    bebida4.setOpacity(100);
                                    menos4.setOpacity(100);
                                    mais4.setOpacity(100);
                                    quntidade4.setText("0");
                                    retangulo4.setOpacity(100);
                                    idbebida4 = b.getIdBebida();
                                }
                            }
                        }
                    }

                }
            }
        });

        anterior.setOnMouseClicked((event)->{
            if (proximos >4) {
                listabebida = 0;
                proximos = proximos-4;
                nomebebida1.setText(null);
                valor1.setText(null);
                imagembebida1.setImage(null);
                bebida1.setOpacity(0);
                menos1.setOpacity(0);
                mais1.setOpacity(0);
                quntidade1.setText(null);
                retangulo1.setOpacity(0);

                nomebebida2.setText(null);
                valor2.setText(null);
                imagembebida2.setImage(null);
                bebida2.setOpacity(0);
                menos2.setOpacity(0);
                mais2.setOpacity(0);
                quntidade2.setText(null);
                retangulo2.setOpacity(0);

                nomebebida3.setText(null);
                valor3.setText(null);
                imagembebida3.setImage(null);
                bebida3.setOpacity(0);
                menos3.setOpacity(0);
                mais3.setOpacity(0);
                quntidade3.setText(null);
                retangulo3.setOpacity(0);

                nomebebida4.setText(null);
                valor4.setText(null);
                imagembebida4.setImage(null);
                bebida4.setOpacity(0);
                menos4.setOpacity(0);
                mais4.setOpacity(0);
                quntidade4.setText(null);
                retangulo4.setOpacity(0);

                for (bebida b : bebidaList) {
                    if (listabebida == proximos - 4) {
                        nomebebida1.setText(b.getNomeProduto());
                        valor1.setText(b.getValor().toString());
                        imagembebida1.setImage(new Image(b.getImagem().toString()));
                        bebida1.setOpacity(100);
                        menos1.setOpacity(100);
                        mais1.setOpacity(100);
                        quntidade1.setText("0");
                        retangulo1.setOpacity(100);
                        idbebida1 = b.getIdBebida();
                    } else {
                        if (listabebida == proximos - 3) {
                            nomebebida2.setText(b.getNomeProduto());
                            valor2.setText(b.getValor().toString());
                            imagembebida2.setImage(new Image(b.getImagem().toString()));
                            bebida2.setOpacity(100);
                            menos2.setOpacity(100);
                            mais2.setOpacity(100);
                            quntidade2.setText("0");
                            retangulo2.setOpacity(100);
                            idbebida2 = b.getIdBebida();
                        } else {
                            if (listabebida == proximos - 2) {
                                nomebebida3.setText(b.getNomeProduto());
                                valor3.setText(b.getValor().toString());
                                imagembebida3.setImage(new Image(b.getImagem().toString()));
                                bebida3.setOpacity(100);
                                menos3.setOpacity(100);
                                mais3.setOpacity(100);
                                quntidade3.setText("0");
                                retangulo3.setOpacity(100);
                                idbebida3 = b.getIdBebida();
                            } else {
                                if (listabebida == proximos - 1) {
                                    nomebebida4.setText(b.getNomeProduto());
                                    valor4.setText(b.getValor().toString());
                                    imagembebida4.setImage(new Image(b.getImagem().toString()));
                                    bebida4.setOpacity(100);
                                    menos4.setOpacity(100);
                                    mais4.setOpacity(100);
                                    quntidade4.setText("0");
                                    retangulo4.setOpacity(100);
                                    idbebida4 = b.getIdBebida();
                                }
                            }
                        }
                    }
                    listabebida = listabebida + 1;
                }
            }
        });

        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalCardapioCliente principalCardapioCliente = new PrincipalCardapioCliente();
            PrincipalBebidasCliente.getStage().close();
            try{
                principalCardapioCliente.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoPizza.setOnMouseClicked((event)->{
            PrincipalCardapioCliente principalCardapioCliente = new PrincipalCardapioCliente();
            PrincipalBebidasCliente.getStage().close();
            try{
                principalCardapioCliente.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoCaarrinho.setOnMouseClicked((event)->{
            PrincipalCarrinhoCliente principalCarrinhoCliente = new PrincipalCarrinhoCliente();
            PrincipalBebidasCliente.getStage().close();
            try{
                principalCarrinhoCliente.start(new Stage());
            }catch(Exception e){

            }
        });

        mais1.setOnMouseClicked((event)->{
            quan1=quan1+1;
            quntidade1.setText(String.valueOf(quan1));
        });

        menos1.setOnMouseClicked((event)->{
            if (quan1>0) {
                quan1 = quan1 - 1;
            }
            quntidade1.setText(String.valueOf(quan1));
        });

        mais2.setOnMouseClicked((event)->{
            quan2=quan2+1;
            quntidade2.setText(String.valueOf(quan2));
        });

        menos2.setOnMouseClicked((event)->{
            if (quan2>0) {
                quan2 = quan2 - 1;
            }
            quntidade2.setText(String.valueOf(quan2));
        });

        mais3.setOnMouseClicked((event)->{
            quan3=quan3+1;
            quntidade3.setText(String.valueOf(quan3));
        });

        menos3.setOnMouseClicked((event)->{
            if (quan3>0) {
                quan3 = quan3 - 1;
            }
            quntidade3.setText(String.valueOf(quan3));
        });

        mais4.setOnMouseClicked((event)->{
            quan4=quan4+1;
            quntidade4.setText(String.valueOf(quan4));
        });

        menos4.setOnMouseClicked((event)->{
            if (quan4>0){
                quan4=quan4-1;
            }
            quntidade4.setText(String.valueOf(quan4));
        });

        botaoEnviarPedido.setOnMouseClicked((event)->{
            Pre_pedidobebidaDAO prePedidobebidaDAO = new Pre_pedidobebidaDAO();
            if(bebida1.isSelected()){
                prePedidobebida.setValortotal(Float.valueOf(valor1.getText())*Float.valueOf(quntidade1.getText()));
                prePedidobebida.setNomebebida(nomebebida1.getText());
                prePedidobebida.setQuantidade(Long.valueOf(quntidade1.getText()));
                prePedidobebida.setIdbebida(idbebida1);
            }else {
                if(bebida2.isSelected()){
                    prePedidobebida.setValortotal(Float.valueOf(valor2.getText())*Float.valueOf(quntidade2.getText()));
                    prePedidobebida.setNomebebida(nomebebida2.getText());
                    prePedidobebida.setQuantidade(Long.valueOf(quntidade2.getText()));
                    prePedidobebida.setIdbebida(idbebida2);
                }else {
                    if(bebida3.isSelected()){
                        prePedidobebida.setValortotal(Float.valueOf(valor3.getText())*Float.valueOf(quntidade3.getText()));
                        prePedidobebida.setNomebebida(nomebebida3.getText());
                        prePedidobebida.setQuantidade(Long.valueOf(quntidade3.getText()));
                        prePedidobebida.setIdbebida(idbebida3);
                    }else {
                        if(bebida4.isSelected()){
                            prePedidobebida.setValortotal(Float.valueOf(valor4.getText())*Float.valueOf(quntidade4.getText()));
                            prePedidobebida.setNomebebida(nomebebida4.getText());
                            prePedidobebida.setQuantidade(Long.valueOf(quntidade4.getText()));
                            prePedidobebida.setIdbebida(idbebida4);
                        }
                    }
                }
            }
            prePedidobebida.setIdclinte(LoginClienteController.getIdcliente());
            prePedidobebidaDAO.create(prePedidobebida);

            PrincipalBebidasCliente principalBebidasCliente = new PrincipalBebidasCliente();
            PrincipalBebidasCliente.getStage().close();
            try{
                principalBebidasCliente.start(new Stage());
            }catch(Exception e){

            }
        });

    }
}

