package br.com.delanhese.triagemesaj;

import br.com.delanhese.triagemesaj.CSV.LerArquivoCSV;

/**
 *
 * @author Rafael Delanhese
 */
public class TriagemEsajMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        LerArquivoCSV ler = new LerArquivoCSV();
        ler.lendoCSV();
    }
    
}
