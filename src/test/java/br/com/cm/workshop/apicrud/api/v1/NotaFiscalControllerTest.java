package br.com.cm.workshop.apicrud.api.v1;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.cm.workshop.apicrud.api.v1.enums.TipoNotaFiscal;
import br.com.cm.workshop.apicrud.api.v1.model.NotaFiscal;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;



@SpringBootTest
public class NotaFiscalControllerTest {
    
    @Value("${server.port}")
    private int porta;
   
    private RequestSpecification requisicao;

    private ObjectMapper objectMapper = new ObjectMapper();


     @BeforeEach
    private void preparaRequisicao() {
        requisicao = new RequestSpecBuilder()
        .setBasePath("/api/v1/Notas-Fiscais")
        .setPort(porta)
        .setAccept(ContentType.JSON)
        .setContentType(ContentType.JSON)
        .log(LogDetail.ALL)
        .build();
    }

     @Test
    public void deveriaBuscarNotasFiscaisComSucesso() {
        given()
            .spec(requisicao)
        .expect()
            .statusCode(HttpStatus.SC_OK)
        .when()
            .get();
    }

     @Test
    public void deveriaCriarUmaNotaComSucesso() throws JsonProcessingException {
        
        NotaFiscal notaCriada = 
        given()
            .spec(requisicao)
            .body(objectMapper.writeValueAsString(dadoUmaNotaPadrao()))
        .when()
            .post()
        .then()
            .statusCode(HttpStatus.SC_CREATED)
        .extract()
            .as(NotaFiscal.class);

        assertNotNull(notaCriada);
        assertNotNull(notaCriada.getId());
        assertEquals("Antonio Marcos", notaCriada.getNomeCliente());

    }

      private NotaFiscal dadoUmaNotaPadrao(){
        NotaFiscal nota = new NotaFiscal();
        nota.setNomeCliente("Antonio Marcos");
        nota.setStatus(TipoNotaFiscal.Autorizada);
        return nota;
    }


      private NotaFiscal dadoUmaNotaSemNome(){
        NotaFiscal nota = new NotaFiscal();
        nota.setNomeCliente("nomeCliente");
        nota.setDescricao1("Descricao 1");
        nota.setStatus(TipoNotaFiscal.Autorizada);
        return nota;
    }

    @Test
    public void deveriaValidarNotaSemNome() throws JsonProcessingException {
        given()
            .spec(requisicao)
            .body(objectMapper.writeValueAsString(dadoUmaNotaSemNome()))
        .when()
            .post()
        .then()
            .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    
}
