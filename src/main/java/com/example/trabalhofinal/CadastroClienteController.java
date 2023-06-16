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
import java.util.ResourceBundle;

public class CadastroClienteController implements Initializable {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Label erraConfirmarSenha;

    @FXML
    private Label erroNome;

    @FXML
    private Label erroSenha;

    @FXML
    private Label erroUsusario;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private AnchorPane retangulo;

    @FXML
    private AnchorPane retanguloBaixo;

    @FXML
    private ImageView segurancaImagem;

    @FXML
    private PasswordField textConfirmarSenha;

    @FXML
    private TextField textNome;

    @FXML
    private PasswordField textSenha;

    @FXML
    private TextField textUsuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botaoCadastrar.setOnMouseClicked((event)->{
            cliente cliente= new cliente();
            ClienteDAO clienteDAO = new ClienteDAO();
            int criar = 0;
            erroNome.setText(null);
            erroSenha.setText(null);
            erroUsusario.setText(null);
            erraConfirmarSenha.setText(null);
            if (textNome.getText().isEmpty()){
                criar = 1;
                erroNome.setText("Colocar o Nome!");
            }else {
                cliente.setNome(textNome.getText());
            }
            if (textUsuario.getText().isEmpty()){
                criar = 1;
                erroUsusario.setText("Colocar o Nome de Usuário!");
            }else {
                cliente.setNomeconta(textUsuario.getText());
            }
            if (textSenha.getText().isEmpty()){
                criar = 1;
                erroSenha.setText("Colocar a Senha!");
            }else {
                if (textSenha.getText().equals(textConfirmarSenha.getText())){
                    String senha=textSenha.getText();
                    CriarSenha criarSenha = new CriarSenha();
                    try {
                        criarSenha.criarsenha(senha);
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(criarSenha.getSenhahex());
                    cliente.setSenha(criarSenha.getSenhahex());
                }else {
                    erraConfirmarSenha.setText("Senhas não iguais!");
                    criar = 1;
                }
            }
            if (criar==0){
                clienteDAO.create(cliente);
                PrincipalLoginCliente principalLoginCliente = new PrincipalLoginCliente();
                PrincipalCadastroCliente.getStage().close();
                try{
                    principalLoginCliente.start(new Stage());
                }catch (Exception e){

                }
            }else {
                criar = 0;
            }

        });
        botaoVoltar.setOnMouseClicked((event)->{
            PrincipalLoginCliente principalLoginCliente = new PrincipalLoginCliente();
            PrincipalCadastroCliente.getStage().close();
            try{
                principalLoginCliente.start(new Stage());
            }catch (Exception e){

            }
        });
    }
}

