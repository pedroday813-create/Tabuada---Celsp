package br.senai.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    TextField textFieldmultiplicando;
    TextField textFieldMenorMultiplicador;
    TextField textFieldMaiorMultiplicador;
    ListView listaTabuada;

    @Override
    public void start(Stage stage) throws IOException {

        //Definir o tamanho da tela
        stage.setWidth(500);
        stage.setHeight(500);

        // Componente principal da tela
        VBox root = new VBox();
        Scene scene = new Scene(root);

        //cabecalho da tela
        VBox header = new VBox();
        header.setStyle("-fx-padding: 10;-fx-background-color: #1653bd");

        //Adicionar um label ao header
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setStyle("-fx-text-fill: white;-fx-font-size: 30;-fx-font-weight: Bold");
        Label labelSubtitulo = new Label("Construa tabuadas sem limites");
        labelSubtitulo.setStyle("-fx-text-fill: white;-fx-font-size: 14");



        header.getChildren().add(labelTitulo);
        header.getChildren().add(labelSubtitulo);


        //Colocar o header no root

        //Criar o multiplicando
        //HBox multiplicando = new HBox();

        //Criar o Multiplicando
        GridPane gridFormulario = new GridPane();
        Label labelMultiplicando = new Label("Multiplicando");
        textFieldmultiplicando = new TextField();

        Label labelMenorMultiplicador = new Label("Menor Multiplicador");
        textFieldMenorMultiplicador = new TextField();

        Label labelMaiorMultiplicador = new Label("Maior Multiplicador");
        textFieldMaiorMultiplicador = new TextField();

        gridFormulario.add(labelMultiplicando, 0, 0);
        gridFormulario.add(textFieldmultiplicando, 1, 0);
        gridFormulario.add(labelMenorMultiplicador, 0, 1);
        gridFormulario.add(textFieldMenorMultiplicador, 1, 1);
        gridFormulario.add(labelMaiorMultiplicador, 0, 2);
        gridFormulario.add(textFieldMaiorMultiplicador, 1, 2);

        //Criar componentes de botões
        HBox hBoxBotoes = new HBox();
        Button btnCalcular = new Button("Calcular");
        btnCalcular.setOnAction(e -> {

        });



        Button btnLimpar = new Button("Limpar");
        Button btnSair = new Button("Sair");

        //Adicionar os Botões na boxBotões
        hBoxBotoes.getChildren().addAll(btnCalcular, btnLimpar, btnSair);

        //Adicionar um componente ListView
        VBox boxResultado = new VBox();
        Label labelResultado = new Label("Resultado");
        labelResultado.setStyle("-fx-text-fill: rgb(0,255,13);-fx-font-size: 18;-fx-font-weight: bold");

        //Adicionar o ListView
        listaTabuada = new ListView();

        //Adicionar o label ao boxResultado
        boxResultado.getChildren().add(labelResultado);
        boxResultado.getChildren().add(listaTabuada);


        //Adicionar componentes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(hBoxBotoes);
        root.getChildren().add(boxResultado);



        stage.setScene(scene);
        stage.setTitle("Tabuada");
        stage.show();
    }

    public void calcularTabuada() {

        int multiplicando = Integer.parseInt(textFieldmultiplicando.getText());
        int menorMultiplicador = Integer.parseInt(textFieldMenorMultiplicador.getText());
        int maiorMultiplicador = Integer.parseInt(textFieldMaiorMultiplicador.getText());

        if (menorMultiplicador > maiorMultiplicador) {
            int auxiliar = menorMultiplicador;
            menorMultiplicador = maiorMultiplicador;
            maiorMultiplicador = auxiliar;
        }

        int tamanho = maiorMultiplicador - menorMultiplicador + 1;
        String[] tabuada = new String[tamanho];

        int contador = 0;
        while (contador < tamanho) {
            double produto = multiplicando * menorMultiplicador;
            tabuada[contador] = multiplicando + " X " + menorMultiplicador + " = " + produto;
            contador++;
            menorMultiplicador++;

        }

        listaTabuada.getItems().clear();
        listaTabuada.getItems().addAll(tabuada);


    }
}
