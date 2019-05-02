package br.com.delanhese.triagemesaj;

import javax.swing.JOptionPane;

import br.com.delanhese.triagemesaj.CSV.LerArquivoCSV;
import br.com.delanhese.triagemesaj.controller.ArquivoController;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Delanhese
 */
public class TriagemEsajMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String caminhoArquivoTriagem = JOptionPane.showInputDialog(null, "Insira o caminho do arquivo a ser triado");
        String caminhoBancoDeDados = JOptionPane.showInputDialog(null, "Insira o caminho do banco de dados");

        if (caminhoArquivoTriagem.isEmpty() || caminhoBancoDeDados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum caminho foi informado");
        } else {
            try {
                ArquivoController arquivoController = new ArquivoController(caminhoArquivoTriagem, caminhoBancoDeDados);
                arquivoController.lerArquivoCSV();
                //System.out.println(caminhoArquivoTriagem);
                //System.out.println(caminhoBancoDeDados);
                /*LerArquivoCSV ler = new LerArquivoCSV();
            ler.lendoCSV();*/
            } catch (FileNotFoundException ex) {
                Logger.getLogger(TriagemEsajMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
