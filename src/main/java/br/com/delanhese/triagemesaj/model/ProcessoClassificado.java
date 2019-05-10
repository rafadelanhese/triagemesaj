package br.com.delanhese.triagemesaj.model;

import com.opencsv.bean.CsvBindByPosition;
import java.util.Date;

/**
 *
 * @author Rafael Delanhese
 */
public class ProcessoClassificado extends Processo {

    private String modalidade;

    private String repercussao;

    private int prazo;

    private String etiqueta;

    public ProcessoClassificado() {
    }

    public ProcessoClassificado(String numeroProcesso, String foro, String vara, String disponibilizacao, String prazoProcessual, String movimentacao, String teor, String classe, String assunto, String situacao, String modalidade, String repercussao, int prazo, String etiqueta) {
        super(numeroProcesso, foro, vara, disponibilizacao, prazoProcessual, movimentacao, teor, classe, assunto, situacao);
        this.modalidade = modalidade;
        this.repercussao = repercussao;
        this.prazo = prazo;
        this.etiqueta = etiqueta;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getRepercussao() {
        return repercussao;
    }

    public void setRepercussao(String repercussao) {
        this.repercussao = repercussao;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }   

    @Override
    public String toString(){
        return this.numeroProcesso+ ";"
                +this.foro + ";"
                +this.vara+ ";"
                +this.disponibilizacao+ ";"
                +this.prazoProcessual+ ";"
                +this.movimentacao+ ";"
                +this.teor+ ";"
                +this.classe+ ";"
                +this.assunto+ ";"
                +this.situacao+ ";"
                +this.modalidade+ ";"
                +this.repercussao+ ";"
                +this.prazo+ ";"
                +this.etiqueta+"\n";
    }
}
