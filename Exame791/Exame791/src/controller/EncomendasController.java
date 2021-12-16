package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MySQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EncomendasController {

    @FXML
    private Button btnFechar;

    @FXML
    private TextField txID;

    @FXML
    private TextField txNome;

    @FXML
    private TextField txPreço;

    @FXML
    private TextField txQuant;

    private MySQLConnection connection;

    public void getID(String id) {
        connection = new MySQLConnection();
        ResultSet result = connection.getDetalhe(id);
        try {
            while (result.next()) {
                String ID = result.getString(1);
                String nome = result.getString(2);
                String preco = result.getString(3);
                String quant = result.getString(4);


                this.txID.setText(ID);
                this.txNome.setText(nome);
                this.txPreço.setText(preco);
                this.txQuant.setText(quant);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @FXML
    void sair(ActionEvent event) {
        Stage stage = (Stage) this.btnFechar.getScene().getWindow();
        stage.close();
    }
}