package sun.ajaxJava.practice.fetchData;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class FetchData {

		private static Connection connection = null;
		
		public static Connection getConnection(){
			if(connection!=null)
				return connection;
			try {
				Properties properties = new Properties();
				InputStream inputStream = FetchData.class.getClassLoader().getResourceAsStream("sun\\ajaxJava\\practice\\fetchData\\db.properties");
				properties.load(inputStream);
				String driver = properties.getProperty("driver");
				String url = properties.getProperty("url");
				String user = properties.getProperty("user");
				String password = properties.getProperty("password");
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}
		
		public static ArrayList<Country> getAllCountry(){
			connection = FetchData.getConnection();
			ArrayList<Country> countryList = new ArrayList<Country>();
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from country limit 10");
				
				while(rs.next()){
					Country country = new Country();
					country.setRecNo(Long.parseLong(rs.getString("recNo")));
					country.setCapital(rs.getString("capital"));
					country.setCode(rs.getString("code"));
					country.setContinent(rs.getString("continent"));
					country.setName(rs.getString("name"));
					country.setPopulation(Long.parseLong(rs.getString("population")));
					country.setRegion(rs.getString("region"));
					countryList.add(country);
				}
			} catch (NumberFormatException | SQLException e) {
				e.printStackTrace();
			}
			return countryList;
		}
}
