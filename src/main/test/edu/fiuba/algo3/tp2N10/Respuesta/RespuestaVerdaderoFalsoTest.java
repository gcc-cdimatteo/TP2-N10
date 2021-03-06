package edu.fiuba.algo3.tp2N10.Respuesta;

import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.RespuestaIncompatibleException;
import edu.fiuba.algo3.tp2N10.Modelo.Puntaje.PuntajeClasico;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaOrderedChoice;
import edu.fiuba.algo3.tp2N10.Modelo.Respuesta.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RespuestaVerdaderoFalsoTest {

    private RespuestaVerdaderoFalso respuestaCorrecta;

    public void setupRespuestaCorrecta() {
        this.respuestaCorrecta = RespuestaVerdaderoFalso.ConPuntaje(true, PuntajeClasico.ParaVerdaderoFalso());
    }

    @Test
    public void test01DosRespuestasVerdaderoFalsoSonIgualesSiAmbasSonVerdadero() {
        setupRespuestaCorrecta();
        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso(true);
        assertTrue(respuestaCorrecta.equals(respuesta));
    }

    @Test
    public void test02UnaRespuestaVerdaderoFalsoCorrectaValeUnPunto() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaVerdaderoFalso(true);
        assertEquals(1, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test03UnaRespuestaVerdaderoFalsoIncorrectaValeCeroPuntosSinPenalidad() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaVerdaderoFalso(false);
        assertEquals(0, respuestaCorrecta.evaluar(respuesta));
    }

    @Test
    public void test04SiSeIngresaUnaRespuestaIncompatibleSeLanzaUnaExcepcion() {
        setupRespuestaCorrecta();
        Respuesta respuesta = new RespuestaOrderedChoice(Arrays.asList(1, 2, 3));
        assertThrows(RespuestaIncompatibleException.class, () -> respuestaCorrecta.evaluar(respuesta));
    }
}
