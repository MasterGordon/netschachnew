package schach;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;

import schach.server.figuren.Knight;

public class MainTest {
	private static Connection conn;

	public MainTest() {
		try {
			System.out.println(getClass().getResource("/resources/white_b.png").toURI());
			ImageIO.read(new File(getClass().getResource("/resources/white_b.png").toURI()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MainTest();
		
		
        System.out.println(SchachUtil.hash("pw1"));
        System.out.println(SchachUtil.hash("pwdwa1"));
        System.out.println(SchachUtil.hash("pwdwa1"));
        System.out.println(SchachUtil.hash("pwdwa2"));
        System.out.println(SchachUtil.hash("pwdwa1 "));
        try {
        	String path = System.getenv("USERPROFILE");
			conn =  DriverManager.getConnection("jdbc:sqlite:"+path+"/Documents/schachuser.db");
			//String createDatabase = "CREATE DATABASE 'schach';";
			String createUsers = "create table if not exists users ( `username` TEXT NOT NULL , `password` TEXT NOT NULL , `elo` INT NOT NULL , `id` INTEGER PRIMARY KEY AUTOINCREMENT, `friends` TEXT NOT NULL);";
			Statement stat;
			try {
				 stat = conn.createStatement();
				 //stat.executeUpdate(createDatabase);
				 stat.executeUpdate(createUsers);
				 
				 ResultSet rs = stat.executeQuery("select * from users WHERE 'username' = 'Gordon';");
				 
				 System.out.println(rs.next());
				 while (rs.next()) {
			            System.out.println("name = " + rs.getString("username"));
			            System.out.println("job = " + rs.getString("id"));
			        }
			        rs.close();
					String username = "GordonDaFreeman";
					String hashedPassword = "a2230562132da27a24d4b623c4af65ca";
					stat.executeUpdate("insert into users values ('"+username+"', '"+hashedPassword+"', "+1000+", null,'');");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
