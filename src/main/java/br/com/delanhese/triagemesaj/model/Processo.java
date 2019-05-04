package br.com.delanhese.triagemesaj.model;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import com.opencsv.bean.CsvDate;
import java.util.Date;

/**
 *
 * @author Rafael Delanhese
 */
public class Processo {

    @CsvBindByPosition(position = 0)
    private String numeroProcesso;
    
    @CsvBindByPosition(position = 1)
    private String foro;
    
    @CsvBindByPosition(position = 2)
    private String vara;
    
    @CsvBindByPosition(position = 3)
    private String disponibilizacao;
    
    @CsvBindByPosition(position = 4)    
    private String prazoProcessual;
    
    @CsvBindByPosition(position = 5)
    private String movimentacao;
    
    @CsvBindByPosition(position = 6)
    private String teor;
    
    @CsvBindByPosition(position = 7)
    private String classe;
    
    @CsvBindByPosition(position = 8)
    private String assunto;
    
    @CsvBindByPosition(position = 9)
    private String situacao;

    public Processo() {
    }

    public Processo(String numeroProcesso, String foro, String vara, String disponibilizacao, String prazoProcessual, String movimentacao, String teor, String classe, String assunto, String situacao) {
        this.numeroProcesso = numeroProcesso;
        this.foro = foro;
        this.vara = vara;
        this.disponibilizacao = disponibilizacao;
        this.prazoProcessual = prazoProcessual;
        this.movimentacao = movimentacao;
        this.teor = teor;
        this.classe = classe;
        this.assunto = assunto;
        this.situacao = situacao;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public String getForo() {
        return foro;
    }

    public void setForo(String foro) {
        this.foro = foro;
    }

    public String getVara() {
        return vara;
    }

    public void setVara(String vara) {
        this.vara = vara;
    }

    public String getDisponibilizacao() {
        return disponibilizacao;
    }

    public void setDisponibilizacao(String disponibilizacao) {
        this.disponibilizacao = disponibilizacao;
    }

    public String getPrazoProcessual() {
        return prazoProcessual;
    }

    public void setPrazoProcessual(String prazoProcessual) {
        this.prazoProcessual = prazoProcessual;
    }

    public String getMovimentacao() {
        return movimentacao;
    }

    public void setMovimentacao(String movimentacao) {
        this.movimentacao = movimentacao;
    }

    public String getTeor() {
        return teor;
    }

    public void setTeor(String teor) {
        this.teor = teor;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

   
    
}
