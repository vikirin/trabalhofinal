package com.example.trabalhofinal;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GeralController implements Initializable {

    @FXML
    private Label bemvindoLabel;

    @FXML
    private Button botaoCliente;

    @FXML
    private Button botaoFechar;

    @FXML
    private Button botaoFuncionario;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private ImageView pizzaImagem;

    @FXML
    private Label pizzaLabel;

    @FXML
    private AnchorPane retanguloCima;

    @FXML
    private AnchorPane retnaguloFC;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botaoFechar.setOnMouseClicked((event)->{
            PrincipalGeral.getStage().close();
        });

        botaoCliente.setOnMouseClicked((event)->{
            PrincipalLoginCliente principalLoginCliente = new PrincipalLoginCliente();
            PrincipalGeral.getStage().close();
            try{
                principalLoginCliente.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoFuncionario.setOnMouseClicked((event)->{
            PrincipalLoginFuncionario principalLoginFuncionario = new PrincipalLoginFuncionario();
            PrincipalGeral.getStage().close();
            try{
                principalLoginFuncionario.start(new Stage());
            }catch (Exception e){

            }
        });
    }
}