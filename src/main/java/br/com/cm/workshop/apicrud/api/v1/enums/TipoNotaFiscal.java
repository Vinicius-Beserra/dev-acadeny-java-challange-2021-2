package br.com.cm.workshop.apicrud.api.v1.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import lombok.Getter;

@Getter
public enum TipoNotaFiscal {

    Cancelada("Cancelada."),
    Processando("Processando"),
    Pendente("Pendente"),
    Autorizada("Autorizada");

    private static final List<TipoNotaFiscal> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    private String status;

    TipoNotaFiscal(String status){
        this.status = status;
    }

    public static TipoNotaFiscal randomTipoNotaFiscal()  {
      return VALUES.get(RANDOM.nextInt(SIZE));
    }
    

}

