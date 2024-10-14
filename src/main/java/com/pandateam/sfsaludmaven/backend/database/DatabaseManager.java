/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author santi
 */
public class DatabaseManager {

    private static DatabaseManager instance;
    private Connection connection;

    private DatabaseManager() {

        //CONSULTAR SOBRE INFORMACIÓN DE USUARIO Y CONTRASEÑA EN EL CÓDIGO
        String url = "jdbc:mysql://localhost:3306/cuidadosdb";
        String user = "root";
        String password = "admin";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            crearTablas();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    private void crearTablas() throws SQLException {

        Statement stmt = connection.createStatement();

        // Crear la tabla Personas
        stmt.execute("CREATE TABLE IF NOT EXISTS Personas (\n"
                + "    Per_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    Per_Nombre VARCHAR(255) NOT NULL,\n"
                + "    Per_Apellido VARCHAR(255) NOT NULL,\n"
                + "    Per_NumeroDocumento VARCHAR(20) NOT NULL,\n"
                + "    Per_FechaNacimiento DATE NOT NULL,\n"
                + "    Per_Telefono VARCHAR(20) NOT NULL,\n"
                + "    Per_Correo VARCHAR(255) NOT NULL\n"
                + ");");

        // Crear la tabla Pacientes
        stmt.execute("CREATE TABLE IF NOT EXISTS Pacientes (\n"
                + "    Per_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    P_TieneSuscripcion VARCHAR(8) NOT NULL,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Personas(Per_ID)\n"
                + ");");

        // Crear la tabla Cuidadores
        stmt.execute("CREATE TABLE IF NOT EXISTS Cuidadores (\n"
                + "    Per_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    C_Profesion VARCHAR(255) NOT NULL,\n"
                + "    C_Experiencia VARCHAR(255) NOT NULL,\n"
                + "    C_Categoria VARCHAR(255) NOT NULL,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Personas(Per_ID)\n"
                + ");");

        stmt.execute("CREATE TABLE IF NOT EXISTS Socios (\n"
                + "    Per_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    S_NumeroSocio VARCHAR(20) NOT NULL,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Pacientes(Per_ID)\n"
                + ");");

        stmt.execute("CREATE TABLE IF NOT EXISTS NoSocios (\n"
                + "    Per_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Pacientes(Per_ID)\n"
                + ");");

        stmt.execute("CREATE TABLE IF NOT EXISTS Suscripcion (\n"
                + "    S_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    S_FechaInicio DATE NOT NULL,\n"
                + "    S_Descuento DECIMAL(5, 2) NOT NULL,\n"
                + "    S_Estado VARCHAR(30) NOT NULL\n"
                + ");");

        stmt.execute("ALTER TABLE Socios ADD CONSTRAINT FK_SocioSuscripcion\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Suscripcion(S_ID);");

        stmt.execute("CREATE TABLE IF NOT EXISTS DeclaracionJurada (\n"
                + "    DJ_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    DJ_Enfermedades TEXT,\n"
                + "    DJ_OperacionesPrevias TEXT,\n"
                + "    Per_ID VARCHAR(8) NOT NULL,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Pacientes(Per_ID)\n"
                + ");");

        stmt.execute("CREATE TABLE IF NOT EXISTS Servicios (\n"
                + "    S_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    S_Descripcion TEXT NOT NULL,\n"
                + "    S_FechaInicio DATE NOT NULL,\n"
                + "    S_FechaFin DATE NOT NULL,\n"
                + "    S_Costo DECIMAL(10, 2) NOT NULL,\n"
                + "    S_Tipo VARCHAR(30) NOT NULL,\n"
                + "    Per_IDPaciente VARCHAR(8) NOT NULL,\n"
                + "    Per_IDCuidador VARCHAR(8) NOT NULL,\n"
                + "    FOREIGN KEY (Per_IDPaciente) REFERENCES Pacientes(Per_ID),\n"
                + "    FOREIGN KEY (Per_IDCuidador) REFERENCES Cuidadores(Per_ID)\n"
                + ");");

        stmt.execute("CREATE TABLE IF NOT EXISTS Atenciones (\n"
                + "    A_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    A_Fecha DATE NOT NULL,\n"
                + "    A_HoraInicio TIME NOT NULL,\n"
                + "    A_HoraFin TIME NOT NULL,\n"
                + "    S_ID VARCHAR(8) NOT NULL,\n"
                + "    FOREIGN KEY (S_ID) REFERENCES Servicios(S_ID)\n"
                + ");");

    }

}
