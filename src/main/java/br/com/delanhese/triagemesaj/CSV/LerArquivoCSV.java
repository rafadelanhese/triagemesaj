package br.com.delanhese.triagemesaj.CSV;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author Rafael Delanhese
 */
public class LerArquivoCSV {

    private static final String TRIAGEM_PATH = "c:\\triagem\\triagem.csv";
    private static final String BANCO_PATH = "c:\\triagem\\banco-de-dados.csv";
    private static final String TESTE_PATH = "c:\\triagem\\teste.csv";

    public LerArquivoCSV() {
    }

    
    public void lendoCSV() {

        try {
            CSVReader bancoDeDados = new CSVReader(new FileReader(BANCO_PATH), ';');

            //GRAVAÇÃO
            CSVWriter writer = new CSVWriter(new FileWriter(TESTE_PATH), ';');

            String[] parametro;
            parametro = bancoDeDados.readNext();
            while ((parametro = bancoDeDados.readNext()) != null) {
                CSVReader triagem = new CSVReader(new FileReader(TRIAGEM_PATH), ';');
                
                
                
                String[] teor;
                teor = triagem.readNext();
                
                while ((teor = triagem.readNext()) != null) {
                    if (teor[6].contains(parametro[0])) {                        
                        writer.writeNext(copiaDados(parametro, teor));
                    }
                }
                triagem.close();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Mensagem: " + e.getMessage() + e.getCause());
        }        
    }  
    
    private String[] copiaDados(String[] parametro, String[] teor){
        String[] teste = new String[teor.length + parametro.length-1];
        
        for (int i = 0; i < teor.length; i++) {
            teste[i] = teor[i];
        }
        
        int i,j;
        for (i = teor.length,j=1; i < teste.length; i++,j++) {
            teste[i] = parametro[j].toUpperCase();
        }
        
        return teste;
    }
}
