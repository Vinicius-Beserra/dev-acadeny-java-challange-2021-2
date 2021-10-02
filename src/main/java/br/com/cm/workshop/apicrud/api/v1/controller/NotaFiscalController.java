package br.com.cm.workshop.apicrud.api.v1.controller;
 

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cm.workshop.apicrud.api.v1.model.NotaFiscal;
import br.com.cm.workshop.apicrud.api.v1.service.NotaFiscalService;




@RestController
@RequestMapping(path = "/api/v1/Notas-Fiscais")
public class NotaFiscalController {
   
    
    @Autowired
    private NotaFiscalService service;
   
    @GetMapping
    public List<NotaFiscal> listaTodos(){ 
        return service.listaTodos();
    }

    @GetMapping("/{id}")
    public Optional<NotaFiscal> getById(@PathVariable Long id){
        return service.findById(id);
    }

   @RequestMapping(method = RequestMethod.GET, path = "/buscaPorNome")
    public List<NotaFiscal> listarPorNome(@RequestParam String nomeCliente){
        return service.buscaPorNome(nomeCliente);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/buscaPorEndereco")
    public List<NotaFiscal> listaPorEndereco(@RequestParam String endereco){
        return service.listaPorDescricao(endereco);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public NotaFiscal salvar(@Valid @RequestBody NotaFiscal notafiscal) {
        return service.save(notafiscal);
    }

     @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }
     
    @PutMapping("/{id}")
    public NotaFiscal atualiza(@PathVariable Long id, @RequestBody NotaFiscal notafiscal) {
        return service.update(id, notafiscal);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public void unsupported() {}    


    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public void notFound() {}

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    

    




}
