package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class JDBCTest2 {
 public static void main(String[] args) {
 dodajOdeljenje(151, "Proba", "Smederevo");
 }
 public static void dodajOdeljenje(int sifra, String naziv,
String grad) {
 String url = "jdbc:oracle:thin:@localhost:1521:orcl";
 String upit = "insert into odeljenje values (?,?,?)";

 try (Connection conn = DriverManager.getConnection(url,
"student1", "student1");
 PreparedStatement stat =
conn.prepareStatement(upit)) {
 conn.setAutoCommit(false);

 stat.setInt(1, sifra);
 stat.setString(2, naziv);
 stat.setString(3, grad);

 int count = stat.executeUpdate();

 if(count > 0){
 conn.commit();
 }else{
 conn.rollback();
 }

 } catch (SQLException ex) {

Logger.getLogger(JDBCTest2.class.getName()).log(Level.SEVERE,
null, ex);
 }
 }
}