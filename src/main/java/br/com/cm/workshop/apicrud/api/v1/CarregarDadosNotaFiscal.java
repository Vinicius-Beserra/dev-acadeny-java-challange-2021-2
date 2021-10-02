package br.com.cm.workshop.apicrud.api.v1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import br.com.cm.workshop.apicrud.api.v1.enums.TipoNotaFiscal;
import br.com.cm.workshop.apicrud.api.v1.model.NotaFiscal;
import br.com.cm.workshop.apicrud.api.v1.repository.NotaFiscalRepository;


@Configuration
public class CarregarDadosNotaFiscal {
   
    private static final Logger log = 
        LoggerFactory.getLogger(CarregarDadosNotaFiscal.class);

    @Bean
    CommandLineRunner initDB(NotaFiscalRepository repository) {
        return args -> {
            NotaFiscal n;
            for (int i = 1; i < 2; i++) {
               n = new NotaFiscal();
                n.setNomeCliente("JOSE FRANCISCO");
                n.setEndereco("Rua A, 500");
                n.setTelefone("8532795578");
                n.setFrete(2.50);
                n.setStatus(TipoNotaFiscal.randomTipoNotaFiscal());
                n.setItems1("[");

                    n.setDescricao1("Refri");
                    n.setPrecoUnitario1(5.5);
                    n.setQuantidade1(1);
                    n.setValorTotalItem1(n.getPrecoUnitario1() *n.getQuantidade1());
                 
                    n.setDescricao2("Coxinha");
                    n.setPrecoUnitario2(3.0);
                    n.setQuantidade2(1);
                    n.setValorTotalItem2(n.getPrecoUnitario2() *n.getQuantidade2());
               
                    n.setDescricao3("Batatinha");
                    n.setPrecoUnitario3(5.0);
                    n.setQuantidade3(1);
                    n.setValorTotalItem3(n.getPrecoUnitario3() *n.getQuantidade3());
                  
                   n.setItems2("]"); 
                 n.setValorTotalProdutos(n.getValorTotalItem1() + n.getValorTotalItem2() + n.getValorTotalItem3());
                 n.setValorTotal(n.getValorTotalProdutos() + n.getFrete()); 
                log.info("Cadastrando Notas Fiscais... " + repository.save(n));
            }

            
        
        };
    }
}

