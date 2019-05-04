package br.com.delanhese.triagemesaj.model;

import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author Rafael Delanhese
 */
public class PalavraChave {

    @CsvBindByPosition(position = 0)
    private String parametro;
    
    @CsvBindByPosition(position = 1)
    private String modalidade;
    
    @CsvBindByPosition(position = 2)
    private String repercussao;
    
    @CsvBindByPosition(position = 3)
    private int prazo;
    
    @CsvBindByPosition(position = 4)
    private String etiqueta;

    public PalavraChave() {
    }

    public PalavraChave(String parametro, String modalidade, String repercussao, int prazo, String etiqueta) {
        this.parametro = parametro;
        this.modalidade = modalidade;
        this.repercussao = repercussao;
        this.prazo = prazo;
        this.etiqueta = etiqueta;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
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
    
    
}
