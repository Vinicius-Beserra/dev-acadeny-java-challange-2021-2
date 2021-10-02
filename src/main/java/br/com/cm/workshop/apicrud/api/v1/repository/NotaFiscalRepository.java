package br.com.cm.workshop.apicrud.api.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cm.workshop.apicrud.api.v1.model.NotaFiscal;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {
    List<NotaFiscal> findByNomeClienteContains(String nomeCliente);

    @Query("SELECT n FROM NotaFiscal n where n.endereco like %?1% ")
    List<NotaFiscal> findByEndereco(String endereco); 

}