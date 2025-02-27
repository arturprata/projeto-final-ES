package DAO;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexaoDAO {

    public Connection conectaBD(){
        Connection conn = null;

        try{
            String url = "jdbc:mysql://localhost:3306/biblioteca?user=root&password=gbstudio";
            conn = java.sql.DriverManager.getConnection(url);
        }

        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ConexaoDAO" + e.getMessage());
        }

        return conn;
    }

}