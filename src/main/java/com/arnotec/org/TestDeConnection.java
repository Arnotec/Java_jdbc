package com.arnotec.org;

import com.arnotec.org.entities.Joueur;
import com.arnotec.org.repository.JoueurRepositoryImpl;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.List;

public class TestDeConnection {
    public static void main(String... args){
        JoueurRepositoryImpl joueurRepository = new JoueurRepositoryImpl();
        List<Joueur> liste = joueurRepository.list();

        for(Joueur joueur : liste){
            System.out.println(joueur.getPrenom()+" "+joueur.getNom());
        }
    }
}

