package br.com.delanhese.triagemesaj.service;

import br.com.delanhese.triagemesaj.model.PalavraChave;
import br.com.delanhese.triagemesaj.model.Processo;
import br.com.delanhese.triagemesaj.model.ProcessoClassificado;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ArquivoService {
    
    private static final String ARQUIVO_TRIADO_PATH = "c:\\triagem\\processos-triado.csv";
    private static final String ARQUIVO_NAO_TRIADO_PATH = "c:\\triagem\\processos-nao-triado.csv";

    public ArquivoService() {
    }    

    public void executarTriagem(List<Processo> listaProcesso, List<PalavraChave> listaPalavraChave) {
        List<ProcessoClassificado> listaProcClassificado = new ArrayList<ProcessoClassificado>();
        List<Processo> listaProcNaoClassificado = new ArrayList<Processo>();
        boolean classificado;
        for (Processo processo : listaProcesso) {
            for (PalavraChave palavra : listaPalavraChave) {
                if (processo.getTeor().contains(palavra.getParametro()) && !classificado) {                    
                    listaProcClassificado.add(new ProcessoClassificado(processo.getNumeroProcesso(),
                            processo.getForo(),
                            processo.getVara(),
                            processo.getDisponibilizacao(),
                            processo.getPrazoProcessual(),
                            processo.getMovimentacao(),
                            processo.getTeor(),
                            processo.getClasse(),
                            processo.getAssunto(),
                            processo.getSituacao(),
                            palavra.getModalidade(),
                            palavra.getRepercussao(),
                            palavra.getPrazo(),
                            palavra.getEtiqueta()));

                            classificado = !classificado;

                }
            }

            if(!classificado)
                listaProcNaoClassificado.add(processo);
        }
        if (!listaProcClassificado.isEmpty()){
            gravaListaNoArquivoTriado(listaProcClassificado);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum processo foi classificado");
        }

        if (!listaProcNaoClassificado.isEmpty()) {
            gravaListaNoArquivoNaoTriado(listaProcNaoClassificado)
        } else {
            JOptionPane.showMessageDialog(null, "Não há processo não classificados");
        }        
    }
    private void gravaListaNoArquivoTriado(List<ProcessoClassificado> listaProcClassificado){        
        try {
            Writer writer = new FileWriter(ARQUIVO_TRIADO_PATH);
            writer.write("Número do processo;Foro;Vara;Disponibilização;Prazo processual;Movimentação;Teor da intimação;Classe principal;Assunto principal;Situação;MODALIDADE;REPERCUSSÃO;PRAZO;ETIQUETA\n");
            for (ProcessoClassificado pc : listaProcClassificado) {
                writer.write(pc.toString());
            }
            writer.close();
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar no arquivo de processos classificados");
        } 
    }

    private void gravaListaNoArquivoNaoTriado(List<Processo> listaProcNaoClassificado){        
        try {
            Writer writer = new FileWriter(ARQUIVO_NAO_TRIADO_PATH);
            writer.write("Número do processo;Foro;Vara;Disponibilização;Prazo processual;Movimentação;Teor da intimação;Classe principal;Assunto principal;Situação\n");
            for (Processo processo : listaProcNaoClassificado) {
                writer.write(processo.toString());
            }
            writer.close();
        } catch (IOException io) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar no arquivo de processos não classificados");
        }         
    }    
}
