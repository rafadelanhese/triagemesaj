package br.com.delanhese.triagemesaj.controller;

import br.com.delanhese.triagemesaj.model.PalavraChave;
import br.com.delanhese.triagemesaj.model.Processo;
import java.io.FileNotFoundException;
import java.io.FileReader;


import br.com.delanhese.triagemesaj.service.ArquivoService;
import com.opencsv.bean.CsvToBeanBuilder;
import java.util.List;

public class ArquivoController {

    private static final File diretorioTriagem = new File("c:\\triagem");
    private ArquivoService arquivoService;
    private List<Processo> listaProcesso;
    private List<PalavraChave> listaPalavraChave;    
    
    public ArquivoController(String triagem, String banco) throws FileNotFoundException {        
        this.listaProcesso = new CsvToBeanBuilder(new FileReader(triagem)).withType(Processo.class).withSkipLines(1).withSeparator(';').build().parse();
        this.listaPalavraChave = new CsvToBeanBuilder(new FileReader(banco)).withType(PalavraChave.class).withSkipLines(1).withSeparator(';').build().parse();
        this.arquivoService = new ArquivoService();
    }   

    public static boolean diretorioTriagemExiste(){        
        return diretorioTriagem.exists();
    }

    public static void criarDiretorioTriagem(){        
        diretorioTriagem.mkdirs();
    }

    public void triarArquivo() {
        arquivoService.executarTriagem(listaProcesso, listaPalavraChave);
    }
}
