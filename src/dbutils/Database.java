package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Database {

    private String server;
    private String database;
    private String username;
    private String password;

    protected Connection con;
    protected Statement statement;
    protected PreparedStatement prStatement;
    protected ResultSet rs;

    public Database() {

        database = "psms";
        server = "jdbc:mysql://localhost/" + database + "?useSSL=false&serverTimeZone=Europe/Athens";
        username = "root";
        password = "54298346Ik";

        try {
            con = DriverManager.getConnection(server, username, password);
            System.out.println("Connected!");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
