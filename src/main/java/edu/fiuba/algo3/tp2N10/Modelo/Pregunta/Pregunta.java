package edu.fiuba.algo3.tp2N10.Modelo.Pregunta;

import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;

import java.util.ArrayList;
import java.util.List;

public abstract class Pregunta {

    protected String enunciado;
    protected List<String> opciones;
    protected Respuesta respuestaCorrecta;

    public List<Integer> responder(List<Respuesta> respuestasUsuario) {
        List<Integer> puntos = new ArrayList<>();
        for (Respuesta respuesta : respuestasUsuario) {
            puntos.add(respuestaCorrecta.evaluar(respuesta));
        }
        return puntos;
    }

    public String getEnunciado() {
        return this.enunciado;
    }

    public List<String> getOpciones() {
        return this.opciones;
    }

}