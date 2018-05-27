
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class JDBCTestV1 {
    static String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";
    static String usr = "student1";
    static String psw = "student1";
    
      public static void main(String[] args) {
 izvuciIzTabele("select sifrazap, ime, prezime from zaposleni order by sifrazap");
 }
    
    
    public static void izvuciIzTabele(String upit){
        
        
    try(Connection myConn = DriverManager.getConnection(dbUrl, usr, psw);
    Statement stat = myConn.createStatement();
    ResultSet rs = stat.executeQuery(upit);
    )
    {
        while(rs.next()){
        int sifraZap = rs.getInt(1);
        String ime = rs.getString("ime");
        String prezime = rs.getString("prezime");
        
//            System.out.println("test");
        System.out.println("Sifra zaposlenog: " + sifraZap +
                ", ime: " + ime + ", prezime: " + prezime + ".");
        }
         
}   catch(SQLException ex) {
    Logger.getLogger(JDBCTestV1.class.getName()).log(Level.SEVERE, null, ex);
}
}
    
    static public void dodajUBazu(){
        
    }
    
    
  
}
