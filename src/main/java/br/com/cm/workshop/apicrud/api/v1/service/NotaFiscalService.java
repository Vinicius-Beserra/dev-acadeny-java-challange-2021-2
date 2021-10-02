package br.com.cm.workshop.apicrud.api.v1.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cm.workshop.apicrud.api.v1.model.NotaFiscal;
import br.com.cm.workshop.apicrud.api.v1.repository.NotaFiscalRepository;

@Service
public class NotaFiscalService {
   
    @Autowired
    private NotaFiscalRepository repository;

    public List<NotaFiscal> listaTodos() {
        return repository.findAll();
    }

     public Optional<NotaFiscal> findById(Long id){     
        return repository.findById(id);
    }

     public List<NotaFiscal> buscaPorNome(String nomeCliente){
        return repository.findByNomeClienteContains(nomeCliente);
    }

    public List<NotaFiscal> listaPorDescricao(String descricao){
        return repository.findByEndereco(descricao);
    }

      public NotaFiscal save(NotaFiscal notafiscal) {
        return repository.saveAndFlush(notafiscal);
    }

      public void remove(Long id) {
        repository.deleteById(id);
    }


     public NotaFiscal update(Long id, NotaFiscal notafiscal){
        if(repository.existsById(id)) {
            if(id.equals(notafiscal.getId())) {
                return repository.saveAndFlush(notafiscal);
            }
             
            else
                throw new UnsupportedOperationException("Id informado é diferente do id da bebida");
        } else
            throw new EntityNotFoundException("Bebida não encontrada");
    }
    

    
}
