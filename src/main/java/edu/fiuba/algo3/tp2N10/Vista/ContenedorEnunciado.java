package edu.fiuba.algo3.tp2N10.Vista;

import edu.fiuba.algo3.tp2N10.Controlador.EventHandlers.BotonComenzarTurno;
import edu.fiuba.algo3.tp2N10.Modelo.AlgoKahoot.AlgoKahoot;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.util.Timer;
import java.util.TimerTask;

public class ContenedorEnunciado extends BorderPane {


    public ContenedorEnunciado(AlgoKahoot algoKahoot, Timer temporizador) {
        //Barra superior
        BorderPane bpHeader = new BorderPane();
        bpHeader.setStyle("-fx-background-color: cornflowerblue");
        bpHeader.setMinHeight(50);

        //Contenido
        Label labelJugador = new Label("Turno de "+algoKahoot.jugadorNombre());
        labelJugador.setFont(Font.font("Tahoma", 30));

        Label labelEnunciadoPregunta = new Label(algoKahoot.preguntaEnunciado());
        labelEnunciadoPregunta.setWrapText(true);
        labelEnunciadoPregunta.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
        labelEnunciadoPregunta.setTextAlignment(TextAlignment.CENTER);

        Label labelTipoPregunta = new Label("Tipo: " + algoKahoot.preguntaActual());
        labelTipoPregunta.setFont(Font.font("Tahoma", 30));

        VBox vbPregunta = new VBox(labelJugador, labelEnunciadoPregunta, labelTipoPregunta);
        vbPregunta.setAlignment(Pos.CENTER);
        vbPregunta.setSpacing(100);

        //Barra Inferior
        Button botonContinuar = new Button();
        botonContinuar.setText("Continuar");
        botonContinuar.setOnAction(new BotonComenzarTurno(algoKahoot,temporizador));

        BorderPane bpContinuar = new BorderPane();
        bpContinuar.setStyle("-fx-background-color: cornflowerblue");
        bpContinuar.setMinHeight(50);
        bpContinuar.setCenter(botonContinuar);

        //Posiciones
        setTop(bpHeader);
        setCenter(vbPregunta);
        setBottom(bpContinuar);

        //Timer
        Label labelTemporizador = new Label("16");
        labelTemporizador.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        labelTemporizador.setTextFill(Color.rgb(255, 255, 255));
        bpHeader.setCenter(labelTemporizador);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    int contador = Integer.parseInt(labelTemporizador.getText()) - 1;
                    labelTemporizador.setText(Integer.toString(contador));
                    if (contador == 0) {
                        botonContinuar.fire();
                    }
                });
            }
        };
        temporizador.schedule(task, 0, 1000L);
    }
}
