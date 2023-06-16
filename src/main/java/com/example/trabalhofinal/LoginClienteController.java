package com.example.trabalhofinal;

import auxiliares.CriarSenha;
import dao.ClienteDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.cliente;


import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.ResourceBundle;

public class LoginClienteController implements Initializable {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoEntrar;

    @FXML
    private Button botaoFechar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Label erroLabel;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private ImageView pessoaImagem;

    @FXML
    private TextField textNome;

    @FXML
    private PasswordField textSenha;

    private static long idcliente;

    public static long getIdcliente() {
        return idcliente;
    }

    public static void setIdcliente(long idcliente) {
        LoginClienteController.idcliente = idcliente;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botaoCadastrar.setOnMouseClicked((event)->{
            PrincipalCadastroCliente principalCadastroCliente = new PrincipalCadastroCliente();
            PrincipalLoginCliente.getStage().close();
            try{
                principalCadastroCliente.start(new Stage());
            }catch(Exception e){

            }
        });

        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalGeral principalGeral = new PrincipalGeral();
            PrincipalLoginCliente.getStage().close();
            try{
                principalGeral.start(new Stage());
            }catch (Exception e){

            }
        });
        botaoEntrar.setOnMouseClicked((event)->{
            erroLabel.setText(null);
            cliente cliente= new cliente();
            ClienteDAO clienteDAO = new ClienteDAO();
            List<cliente> clienteList = clienteDAO.findall();
            String senha=textSenha.getText();
            CriarSenha criarSenha = new CriarSenha();
            PrincipalCardapioCliente cardapios = new PrincipalCardapioCliente();
            PrincipalLoginCliente loginC = new PrincipalLoginCliente();
            try {
                criarSenha.criarsenha(senha);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            for (cliente c : clienteList){
                if (c.getNomeconta().equals(textNome.getText())&& c.getSenha().equals(criarSenha.getSenhahex())){
                    setIdcliente(c.getIdCliente());
                    PrincipalCardapioCliente principalCardapioCliente = new PrincipalCardapioCliente();
                    PrincipalLoginCliente.getStage().close();
                    try{
                        principalCardapioCliente.start(new Stage());
                    }catch(Exception e){

                    }
                }else {
                    erroLabel.setText("Nome ou Senha incorreto!");
                }
            }

        });

        botaoFechar.setOnMouseClicked((event)->{
            PrincipalLoginCliente.getStage().close();
        });
    }
}

