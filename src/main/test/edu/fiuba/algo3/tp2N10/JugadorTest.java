package edu.fiuba.algo3.tp2N10;

import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.Jugador;
import edu.fiuba.algo3.tp2N10.Modelo.Excepciones.PowerUpNoDisponibleException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JugadorTest {

    @Test
    public void test01JugadorRecienCreadoDevuelve0PuntosYSuNombre(){
        Jugador jugador = new Jugador("Wenceslao");

        assertEquals("Wenceslao", jugador.nombre());
        assertEquals(0,jugador.puntaje());
    }

    @Test
    public void test02JugadorEsPuntuadoPositivamenteYDevuelveSusPuntos(){
        Jugador jugador = new Jugador("Ofelia");
        jugador.puntuar(10);
        assertEquals(10, jugador.puntaje());
    }

    @Test
    public void test03JugadorEsPuntuadoNegativamenteYDevuelveSusPuntos(){
        Jugador jugador = new Jugador("Yolanda");

        jugador.puntuar(-8);

        assertEquals(-8, jugador.puntaje());
    }

    @Test
    public void test04JugadorEsPuntuadoVariasVeces(){
        Jugador jugador = new Jugador("Velasco");

        jugador.puntuar(-1);
        jugador.puntuar(10);
        jugador.puntuar(-3);
        jugador.puntuar(-2);
        jugador.puntuar(1);

        assertEquals(5, jugador.puntaje());
    }

    @Test
    public void test05JugadorSoloPuedeUsarExclusividadDePuntaje2Veces(){
        Jugador jugador = new Jugador("Casimiro");

        jugador.usarExclusividad();
        jugador.usarExclusividad();

        assertThrows(PowerUpNoDisponibleException.class, jugador::usarExclusividad);
    }

}
