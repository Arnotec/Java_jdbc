package com.arnotec.org;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class TestDeConnection {
    public static void main(String... args){
        Connection conn = null;
        try {
            //MySQL using dataSource
            MysqlDataSource dataSource = new MysqlDataSource();

            //dataSource.setUrl("jdbc:mysql://localhost:3306/tennis?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=Europe/Paris");
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("tennis");
            dataSource.setUseSSL(false);
            dataSource.setUser("root");
            dataSource.setPassword("root");

            conn = dataSource.getConnection();

//            conn.setAutoCommit(false);
//
//            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO JOUEUR (NOM,PRENOM,SEXE) VALUES (?,?,?)");
//
//            String nom = "Capriati";
//            String prenom = "Jennifer";
//            String sexe = "F";
//            preparedStatement.setString(1, nom);
//            preparedStatement.setString(2, prenom);
//            preparedStatement.setString(3, sexe);
//
//            preparedStatement.executeUpdate();
//
//            nom = "Johannson";
//            prenom = "Thomas";
//            sexe = "M";
//            preparedStatement.setString(1, nom);
//            preparedStatement.setString(2, prenom);
//            preparedStatement.setString(3, sexe);
//
//            preparedStatement.executeUpdate();
//
//            conn.commit();

            System.out.println("success "+conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    if(conn!=null) conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}

