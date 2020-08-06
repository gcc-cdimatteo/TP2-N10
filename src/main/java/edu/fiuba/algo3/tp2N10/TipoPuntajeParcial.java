package edu.fiuba.algo3.tp2N10;

import java.util.List;

public class TipoPuntajeParcial implements TipoPuntaje {

    public Integer puntuar(List<Integer> evaluacion) {
        return evaluacion.get(1) == 0 ? evaluacion.get(0) : 0;
    }
}