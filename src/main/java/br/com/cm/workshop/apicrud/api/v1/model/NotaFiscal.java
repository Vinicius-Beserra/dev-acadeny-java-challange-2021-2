package br.com.cm.workshop.apicrud.api.v1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.com.cm.workshop.apicrud.api.v1.enums.TipoNotaFiscal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotaFiscal implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "nome é obrigatório")
    private String nomeCliente;
    
    @NotEmpty
    @Size(max = 100, min = 8, message = "O Endereco deve ter tamanho minimo de 8 de tamanho máximo de 10 caracteres")
    private String endereco;
    
    @NotEmpty
    @Size(max = 100, min = 5, message = "a marca deve ter tamanho minimo de 5 de tamanho máximo de 10 caracteres")
    private String telefone;
    
    private Double valorTotalProdutos;
    private Double frete;
    private Double valorTotal;
    
    @Enumerated(EnumType.STRING)
    private TipoNotaFiscal status;
    
    private String items1;

    @NotEmpty(message = "Item nao pode ter descricao vazio e/ou Nulo!")
    private String descricao1;
    
    @Min(value = 1, message = "Item nao pode ter valor vazio e/ou Nulo!")
    private Double precoUnitario1;

    @Min(value = 1, message = "Item nao pode ter quantidade vazio e/ou Nulo!")
    private int quantidade1;
    private Double valorTotalItem1;

  
    private String descricao2;
 
    private Double precoUnitario2;

    private int quantidade2;
    private Double valorTotalItem2;

 
    private String descricao3;
  
    private Double precoUnitario3;
    private int quantidade3;
    private Double valorTotalItem3;

    private String items2;

}
