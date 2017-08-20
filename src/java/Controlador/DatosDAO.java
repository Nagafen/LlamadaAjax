/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Datos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import util.Conexion;

/**
 *
 * @author crist
 */
public class DatosDAO {
    private Connection conexion;
    
    public DatosDAO(){
        Conexion db = Conexion.getConexion();
        this.conexion = db.getConnection();
    }
    
    public LinkedList<Datos> Listar() {

        LinkedList<Datos> a = new LinkedList<>();

        String query = "SELECT * FROM Datos";

        try {
           Statement statement =
                    this.conexion.createStatement();

            ResultSet rs = 
                    statement.executeQuery(query);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int numero = rs.getInt("numero");
                
                Datos pro = new Datos(nombre,numero);
                a.add(pro);
            }
            System.out.println(a);

        } catch (SQLException e) {
            System.out.println("Failed to make update!");
            e.printStackTrace();
        }

        return a;
    }
}