package project;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javax.swing.*;
import java.awt.*;
import java.net.FileNameMap;
import java.sql.*;
import java.time.LocalDate;

public class PassengerInfoController extends Main {
//public TextField FName ,LName,PassNum;

    //    @FXML
//    private TextField FName;
//    @FXML
//    private TextField LName;
//    @FXML
//    private TextField PassNum;
    @FXML
    private javafx.scene.control.Button AddMember;

    @FXML
    private DatePicker DOB;

    @FXML
    private javafx.scene.control.TextField FName;

    @FXML
    private javafx.scene.control.TextField LName;

    @FXML
    private javafx.scene.control.TextField PassNum;

    @FXML
    private javafx.scene.control.Label errorMessage;

    @FXML
    private Label incompleteFields;

    @FXML
    private javafx.scene.control.Button back;

    @FXML
    private void AddPassenger(ActionEvent actionEvent) {
        Connection con = null;
        String a = FName.getText();
        String b = LName.getText();
        String c = PassNum.getText();
        LocalDate localDate = DOB.getValue();
if(FName.getText().equals("")|| LName.getText().equals("")||PassNum.getText().equals("")||DOB.getValue().equals("")){
    errorMessage.setText("Fill ALL TextFIelds");
    Alert d = new Alert(Alert.AlertType.NONE);

 


}
    else
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/project2413", "root", "");

//            Statement stmt = conn.createStatement() ;

//            String query ="INSERT INTO `passenger`(`firstName`, `lastName`, `passPortNo`, `DOB`) VALUES ("+FName+"', '"+LName+"','"+PassNum+"','"+DOB+"')";
//ResultSet rs = stmt.executeQuery(query) ;
            Statement stm = con.createStatement();
            String sql = "INSERT INTO  passenger VALUES('" + a + "','" + b + "','" + c + "','" + localDate + "')";
            stm.execute(sql);
            System.out.println("Sucessfull");
            errorMessage.setText("Data Inserted SucessFully");







        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                errorMessage.setText("Existing User");
            }
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(e);
//            Alert alert=new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("ALert");
//            alert.setContentText("Fill All required Fields Correctly");

        }
    }

        public void Back(ActionEvent event) {
        changeScene("Search");



    }
}

