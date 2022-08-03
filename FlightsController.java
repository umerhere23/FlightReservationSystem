package project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.sql.*;
import java.time.LocalDate;

public class FlightsController extends Main {
	@FXML
	private Button Next;
String array[]=new String[2];
// String TOO,FROM,DATE;

	@FXML
	private ComboBox<String> shed;
	public String setName(String to) {

//	array[0]=to;
		return to;
//	System.out.println(TOO);
	}

	public static void setName2(String from) {
//		array[1]=from;

		System.out.println(from);


	}

	public static void setame3(LocalDate localDate) {
//		array[2]= String.valueOf(localDate);

		System.out.println(localDate);
//		for(int b=0 ;b<=array.length;b++){
//			System.out.println(array[b]);}
		}




	public void goToShedule() {
		changeScene("Search");
//		public void setName2(String from) {
//			System.out.println(from);
//
//		}
		Connection con = null;
	SearchController n= new SearchController();
	n.goToFlight();


//		try {
//			ObservableList<String> listacomboo = FXCollections.observableArrayList();
//
//			String consulta = "SELECT destination,origin,flightdate FROM flight where ";
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			con = DriverManager.getConnection("jdbc:mysql://localhost/project2413", "root", "");
//			PreparedStatement ps = con.prepareStatement(consulta);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//
//				listacomboo.add(rs.getString("origin"));
//
//			}
//			shed.setItems(listacomboo);
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		}

	}

	public void goToPassInfo()
	{
	    changeScene("PassengerInfo");
	}
	public void goToSearch() {
		changeScene("Search");


}}



