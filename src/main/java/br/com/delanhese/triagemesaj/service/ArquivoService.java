package br.com.delanhese.triagemesaj.service;

import javax.swing.JOptionPane;

import com.opencsv.CSVReader;

public class ArquivoService {

    public ArquivoService(){        
    }

    public void validarArquivo(CSVReader arquivoTriagem, CSVReader arquivoBancoDeDados){
        if(!arquivoTriagem.verifyReader())
            JOptionPane.showMessageDialog(null, "Não é possível ler o arquivo");
    }
}