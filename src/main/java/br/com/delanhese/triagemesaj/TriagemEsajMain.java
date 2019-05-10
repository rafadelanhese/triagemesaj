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
        if(!ArquivoController.diretorioTriagemExiste()){
            int opcaoUsuario = JOptionPane.showConfirmDialog(null, "Diretório triagem não está criado no C: - deseja criar diretório?", JOptionPane.YES_NO_OPTION);

            if(opcaoUsuario == JOptionPane.YES_OPTION){
                ArquivoController.criarDiretorioTriagem();
            } else {
                JOptionPane.showMessageDialog(null, "O programa será encerrado");
            }
        } else {
            JOptionPane.showInputDialog(null, "Insira o caminho do arquivo de processos a ser triado");
            JOptionPane.showInputDialog(null, "Insira o caminho do banco de dados");
            //String caminhoArquivoTriagem = "C:\\triagem\\triagem.csv";
            //String caminhoBancoDeDados = "C:\\triagem\\banco-de-dados.csv";

            caminhoArquivoTriagem = caminhoArquivoTriagem.replace("\\", "\\\\");
            caminhoBancoDeDados = caminhoBancoDeDados.replace("\\", "\\\\");
                
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
}
