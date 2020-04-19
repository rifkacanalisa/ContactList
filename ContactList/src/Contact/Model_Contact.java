package Contact;

import javax.swing.*;
import java.sql.*;

public class Model_Contact {
    static final String driver = "com.mysql.jdbc.Driver";
    static final String dbURL = "jdbc:mysql://localhost/dbcontact";
    static final String user = "root";
    static final String pass = "";

    Connection connection;
    Statement statement;

    public Model_Contact(){
        try{
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(dbURL,user,pass);
            System.out.println("Koneksi Berhasil!!");
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Gagal Koneksi Database!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null,"Driver Tidak Ditemukan!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void InsertContact(String Nama, String NoHp, String Umur, String Email){
        try{
            String query = "insert into `contact` values ('"+Nama+"','"+NoHp+"','"+Umur+"','"+Email+"')";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Contact Berhasil Disimpan!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Contact Gagal Disimpan!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public String[][] ReadContact(){
        try{
            int jmlhContact = 0;
            String contact[][] = new String[getBanyakContact()][4];
            String query = "select * from `contact`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                contact[jmlhContact][0] = resultSet.getString("nama");
                contact[jmlhContact][1] = resultSet.getString("no_hp");
                contact[jmlhContact][2] = resultSet.getString("umur");
                contact[jmlhContact][3] = resultSet.getString("email");
                jmlhContact++;
            }
            return contact;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Contact Gagal Ditayangkan!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public int getBanyakContact(){
        int jmlhContact = 0;
        try{
            statement = connection.createStatement();
            String query = "select * from `contact`";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlhContact++;
            }
            return jmlhContact;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Contact Gagal Dihitung!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public void deleteContact (String NoHP) {
        try{
            String query = "DELETE FROM `contact` WHERE `no_hp` = '"+NoHP+"'";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Contact Berhasil Dihapus!");
        }catch(SQLException sql) {
            JOptionPane.showMessageDialog(null,"Contact Gagal Dihapus!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void UpdateContact(String NoHPA,String NoHP, String Nama, String Umur, String Email){
        try {
            String query = "update `contact` set `nama` = '"+Nama+"',`no_hp` = '"+NoHP+"'," +
                    "`umur` = '"+Umur +"', `email` = '"+Email+"'  where `no_hp` = '"+NoHPA+"'";
            statement = (Statement) connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Contact Berhasil Disimpan!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Contact Gagal Disimpan!", "Hasil",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void resetData() {
        try{
            String query = "DELETE FROM `contact`";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Reset Contact Berhasil!");
        }catch(SQLException sql) {
            JOptionPane.showMessageDialog(null,"Reset Contact Gagal!",
                    "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

}
