package br.com.delanhese.triagemesaj;

import javax.swing.JOptionPane;

import br.com.delanhese.triagemesaj.controller.ArquivoController;
import java.io.FileNotFoundException;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Rafael Delanhese
 */
public class TriagemEsajMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String caminhoArquivoTriagem = "C:\\triagem\\triagem.csv";//JOptionPane.showInputDialog(null, "Insira o caminho do arquivo a ser triado");
        String caminhoBancoDeDados = "C:\\triagem\\banco-de-dados.csv";//JOptionPane.showInputDialog(null, "Insira o caminho do banco de dados");

        //caminhoArquivoTriagem = caminhoArquivoTriagem.replace("\\", "\\\\");
        //caminhoBancoDeDados = caminhoBancoDeDados.replace("\\", "\\\\");
        
        System.out.println(caminhoArquivoTriagem);
        if (caminhoArquivoTriagem.isEmpty() || caminhoBancoDeDados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum caminho foi informado");
        } else {
            try {
                ArquivoController arquivoController = new ArquivoController(caminhoArquivoTriagem, caminhoBancoDeDados);
                arquivoController.triarArquivo();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo");
            }
        }

    }

}
