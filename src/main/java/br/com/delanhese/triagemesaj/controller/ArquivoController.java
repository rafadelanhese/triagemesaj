package br.com.delanhese.triagemesaj.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.opencsv.CSVReader;

import br.com.delanhese.triagemesaj.service.ArquivoService;

public class ArquivoController {

    private ArquivoService arquivoService;
    private CSVReader triagemCSV;
    private CSVReader bancoCSV;

    public ArquivoController() {
    }

    public ArquivoController(String triagem, String banco) throws FileNotFoundException {        
        this.triagemCSV = new CSVReader(new FileReader(triagem), ';');
        this.bancoCSV = new CSVReader(new FileReader(banco), ';');
        this.arquivoService = new ArquivoService();
    }

    public void lerArquivoCSV(){    
        arquivoService.validarArquivo(triagemCSV, bancoCSV);
    }
}