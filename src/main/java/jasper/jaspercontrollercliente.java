package jasper;

import dao.ClienteDAO;
import model.cliente;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.List;

public class jaspercontrollercliente {
    public void gerarRelatorio() throws JRException{
        ClienteDAO clienteDAO = new ClienteDAO();
        List<cliente> clienteList = clienteDAO.findall();

        //Criação do PDF com o Jasper
        JasperReport relatorioAula10 = JasperCompileManager.compileReport(
                        "src/main/resources/relatorioCliente.jrxml");

        JasperPrint relatorio = JasperFillManager.fillReport(relatorioAula10,
                null, new JRBeanCollectionDataSource(clienteList));


        /*//SWING para mostrar a tela PDF
        JDialog tela = new JDialog( new JDialog(),
                "Relatorio Pessoas", true);
        tela.setSize(800, 600);
        JRViewer painel = new JRViewer(relatorio);
        //JRViewer painel1 = new JRViewer(relatorio1);
        tela.getContentPane().add(painel);
        tela.setVisible(true);*/

    }
}

