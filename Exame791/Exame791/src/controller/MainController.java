package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Encomenda;
import model.MySQLConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController {

    @FXML
    private Button btnProcurar;

    @FXML
    private TextField txNumero;

    private MySQLConnection connection;

    public void initialize() {
        connection = new MySQLConnection();
    }

    @FXML
    public void detalhes(ActionEvent event){
        String id = this.txNumero.getText();

        if(id == null){
            alerta(Alert.AlertType.ERROR, "Deve escrever um ID...\n Tente novamente", "ERRO");
        } else {
            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/viewEncomenda.fxml"));
                Parent root = loader.load();

                EncomendasController controller = loader.getController();

                controller.getID(id);
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void alerta(Alert.AlertType tipo, String txt, String titulo) {
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setTitle(titulo);
        alerta.setContentText(txt);
        alerta.showAndWait();
    }

}