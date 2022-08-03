package project;

import java.sql.*;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;


public class SearchController extends Main{

	@FXML
    private ComboBox<?> Adults;

    @FXML
    private DatePicker Date;
    
    @FXML
    private DatePicker Going_Date;

    @FXML
    public ComboBox<String> From;

    @FXML
    private ComboBox<?> Kids;

    @FXML
    private RadioButton RoundTrip;

    @FXML
    private Button Search;

    @FXML
    private ComboBox<String> To;

    @FXML
    private ToggleGroup tgway;
	@FXML
	private Button btn5;

	@FXML
	private ComboBox<String> combos;

    public void onewayflights() {
		Connection con = null;
	Date.setVisible(false);
		combos.setVisible(false);
		btn5.setVisible(false);


		try {
			ObservableList<String> listacombo = FXCollections.observableArrayList();
			ObservableList<String> listacomboo = FXCollections.observableArrayList();

			String consulta = "SELECT destination,origin FROM flight";

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/project2413", "root", "");
			PreparedStatement ps = con.prepareStatement(consulta);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				listacombo.add(rs.getString("destination"));
				listacomboo.add(rs.getString("origin"));


			}
			To.setItems(listacombo);
			From.setItems(listacomboo);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
public void twowayflights(){
	Date.setVisible(true);
//	String to = To.getSelectionModel().getSelectedItem();
//	String from = From.getSelectionModel().getSelectedItem();
//
//	System.out.println(from+to);

}
//
//			ResultSet rs = con.createStatement().executeQuery("select *from Project2413");
//			ObservableList data = FXCollections.observableArrayList();
//
//			while (rs.next()) {
//				data.add(new String(rs.getString(1)));
//			}
//			From.setItems(data);

//			data = FXCollections.observableArrayList();
//			// Execute query and store result in a resultset
//			ResultSet rs = conn.createStatement().executeQuery("SELECT origin FROM flight");
//			while (rs.next()) {
//				//get string from db,whichever way
//				data.add(new User(rs.getString("username")));
//   	}
//    	catch (Exception e) {
//    		e.printStackTrace();
//    	}
//
//    }
//
	//Disable date when one way is clicked.
//	public void DisableDate() throws IOException {
//		DatePicker Date = new DatePicker(LocalDate.now());
//		Date.getEditor().setDisable(true);
//		Date.getEditor().setOpacity(1);
//	}

		/**Sends the application to the creation a flight scene.*/
		public void goToFlight ()
		{
combos.setVisible(true);
btn5.setVisible(true);
			String to = To.getSelectionModel().getSelectedItem();
			String from = From.getSelectionModel().getSelectedItem();
			LocalDate localDate =Going_Date.getValue();
//			FlightsController user = new FlightsController();
//			FlightsController user2 = new FlightsController();
//			FlightsController user3 = new FlightsController();
//			user.setName(to);
//			user2.setName2(from);
//			user3.setame3(localDate);

			Connection con = null;
			try {
			ObservableList<String> listacomboo = FXCollections.observableArrayList();

			String consulta = "SELECT flightDate,flightNumber,origin,destination FROM flight where origin='"+from+"' AND destination='"+to+"'AND flightDate='"+localDate+"'";
//				String consulta = "SELECT * FROM flight";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/project2413", "root", "");
				System.out.println(consulta);
			PreparedStatement ps = con.prepareStatement(consulta);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				listacomboo.add(rs.getString("flightDate"));
				listacomboo.add(rs.getString("flightNumber"));
				listacomboo.add(rs.getString("origin"));
				listacomboo.add(rs.getString("destination"));






			}
			String abc= String.valueOf(listacomboo);
				ObservableList<String> listacombo = FXCollections.observableArrayList();
listacombo.add(abc);
//				System.out.println(abc);

		combos.setItems(listacombo);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		}
//	AND flightDate='"+localDate+"

	public void openpassenger(ActionEvent actionEvent) {
		changeScene("Passengerinfo");
	}
}


//	public void setName(String to) {
//		System.out.println(to);
//	}
//
//	public void setName2(String from) {
//		System.out.println(from);
//
//	}
//
//	public void setame3(LocalDate localDate) {
//		System.out.println(localDate);
//
//	}
