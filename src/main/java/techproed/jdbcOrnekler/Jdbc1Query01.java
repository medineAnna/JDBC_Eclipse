package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. Ilgili Drivery yuklemeliyiz. Tv'nin fisini tak, baska alet calismasin, ne
		// calisacagini bilsin

		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2. baglanti olusturmaliyiz

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root",
				"insallah64");

		//3. SQL komutlari icin bir statement nesnesi olustur
		
		Statement st=con.createStatement();
		
		//SQL ifadeleri yazabilir ve calistirabiliz, kumanda da 1 e basarim trt1 gelir
		
		ResultSet veri= st.executeQuery("SELECT isim, maas FROM personel where id=123456789");
		 
		//5. sonuclari aldik ve isledik
		
		while(veri.next()) {
			System.out.println(veri.getString("isim") + veri.getInt("maas"));
			System.out.println("Personel Adi: " + veri.getString(1) + " Maas" + veri.getInt(2));
		}
		//6. olusturulan baglantiyi SQL'den kapattik
		
		con.close();
		st.close();
		veri.close();
		
	}
}
