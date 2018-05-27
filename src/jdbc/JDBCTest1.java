package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCTest1 {
 public static void main(String[] args) {
 nadjiOdeljenja();
 }

 public static void nadjiOdeljenja(){
 String url = "jdbc:oracle:thin:@localhost:1521:orcl";
 String upit = "select * from odeljenje";

 try(Connection conn = DriverManager.getConnection(url,
"student1", "student1");
 Statement stat = conn.createStatement();
 ResultSet rs = stat.executeQuery(upit)
 ) {

 while (rs.next()) {
 int sifra = rs.getInt(1);
 String naziv = rs.getString("nazivodelj");
 String grad = rs.getString(3);

 System.out.println("Sifra: " + sifra
 + ", Naziv: " + naziv
+ ", Grad: " + grad);
 }

 } catch (SQLException ex) {

Logger.getLogger(JDBCTest1.class.getName()).log(Level.SEVERE,
null, ex);
 }
 }
}