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
    
    private static final String ARQUIVO_TRIADO_PATH = "c:\\triagem\\arquivo-triado.csv";

    public ArquivoService() {
    }

    public void executarTriagem(List<Processo> listaProcesso, List<PalavraChave> listaPalavraChave) {
        List<ProcessoClassificado> listaProcClassificado = new ArrayList<ProcessoClassificado>();
        
        for (Processo processo : listaProcesso) {
            for (PalavraChave palavra : listaPalavraChave) {
                if (processo.getTeor().contains(palavra.getParametro())) {
                    //FALTA VERIFICAR SE O PROCESSO FOI TRIADO MAIS DE UMA VEZ
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

                }
            }
        }
        gravaListaNoArquivoTriado(listaProcClassificado);
        
    }
    private void gravaListaNoArquivoTriado(List<ProcessoClassificado> listaProcClassificado){
        if (!listaProcClassificado.isEmpty()) {
            try {
                Writer writer = new FileWriter(ARQUIVO_TRIADO_PATH);
                writer.write("Número do processo;Foro;Vara;Disponibilização;Prazo processual;Movimentação;Teor da intimação;Classe principal;Assunto principal;Situação;MODALIDADE;REPERCUSSÃO;PRAZO;ETIQUETA\n");
                for (ProcessoClassificado pc : listaProcClassificado) {
                    writer.write(formataStringDeGravacaoNoArquivoClassificado(pc));
                }
                writer.close();
            } catch (IOException io) {
                JOptionPane.showMessageDialog(null, "Erro ao gravar no arquivo de processos classificados");
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum processo foi classificado");
        }
    }
    private String formataStringDeGravacaoNoArquivoClassificado(ProcessoClassificado pc){
        return pc.getNumeroProcesso()+ ";"
                            +pc.getForo() + ";"
                            +pc.getVara()+ ";"
                            +pc.getDisponibilizacao()+ ";"
                            +pc.getPrazoProcessual()+ ";"
                            +pc.getMovimentacao()+ ";"
                            +pc.getTeor()+ ";"
                            +pc.getClasse()+ ";"
                            +pc.getAssunto()+ ";"
                            +pc.getSituacao()+ ";"
                            +pc.getModalidade()+ ";"
                            +pc.getRepercussao()+ ";"
                            +pc.getPrazo()+ ";"
                            +pc.getEtiqueta()+"\n";
    }
}
