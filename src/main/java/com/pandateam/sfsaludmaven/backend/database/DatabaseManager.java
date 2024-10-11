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
        String url = "jdbc:mysql://localhost:3306/cuidadosdb";
        String user = "root";
        String password = "admin";

        try {
            Class.forName("com.mysql.jdbc.Driver");
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

    private void crearTablas() {
        String sql = "-- Crear la base de datos\n"
                + "CREATE DATABASE IF NOT EXISTS SanFranciscoDB;\n"
                + "USE SanFranciscoDB;\n"
                + "\n"
                + "-- Crear la tabla Personas\n"
                + "CREATE TABLE Personas (\n"
                + "    Per_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    Per_Nombre VARCHAR(255) NOT NULL,\n"
                + "    Per_Apellido VARCHAR(255) NOT NULL,\n"
                + "    Per_NumeroDocumento VARCHAR(20) NOT NULL,\n"
                + "    Per_FechaNacimiento DATE NOT NULL,\n"
                + "    Per_Telefono VARCHAR(20) NOT NULL,\n"
                + "    Per_Correo VARCHAR(255) NOT NULL\n"
                + ");\n"
                + "\n"
                + "-- Crear la tabla Pacientes (herencia de Personas)\n"
                + "CREATE TABLE Pacientes (\n"
                + "    Per_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    P_TieneSuscripcion ENUM('Sí', 'No') NOT NULL,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Personas(Per_ID)\n"
                + ");\n"
                + "\n"
                + "-- Crear la tabla Cuidadores (herencia de Personas)\n"
                + "CREATE TABLE Cuidadores (\n"
                + "    Per_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    C_Profesion VARCHAR(255) NOT NULL,\n"
                + "    C_Experiencia VARCHAR(255) NOT NULL,\n"
                + "    C_Categoria VARCHAR(255) NOT NULL,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Personas(Per_ID)\n"
                + ");\n"
                + "\n"
                + "-- Crear la tabla Socios (herencia de Pacientes)\n"
                + "CREATE TABLE Socios (\n"
                + "    Per_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    S_NúmeroSocio VARCHAR(20) NOT NULL,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Pacientes(Per_ID)\n"
                + ");\n"
                + "\n"
                + "-- Crear la tabla No Socios (herencia de Pacientes)\n"
                + "CREATE TABLE NoSocios (\n"
                + "    Per_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Pacientes(Per_ID)\n"
                + ");\n"
                + "\n"
                + "-- Crear la tabla Suscripción\n"
                + "CREATE TABLE Suscripcion (\n"
                + "    S_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    S_FechaInicio DATE NOT NULL,\n"
                + "    S_Descuento DECIMAL(5, 2) NOT NULL,\n"
                + "    S_Estado ENUM('Junior', 'Medium', 'Full', 'PreJunior', 'PreMedium', 'PreFull', 'JuniorToMedium', 'MediumToFull', 'JuniorToFull') NOT NULL\n"
                + ");\n"
                + "\n"
                + "-- Relación de uno a uno entre Socios y Suscripción (Socio titular)\n"
                + "ALTER TABLE Socios ADD CONSTRAINT FK_SocioSuscripción\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Suscripción(S_ID);\n"
                + "\n"
                + "-- Crear la tabla Declaración Jurada\n"
                + "CREATE TABLE DeclaracionJurada (\n"
                + "    DJ_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    DJ_Enfermedades TEXT,\n"
                + "    DJ_OperacionesPrevias TEXT,\n"
                + "    Per_ID VARCHAR(8) NOT NULL,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Pacientes(Per_ID)\n"
                + ");\n"
                + "\n"
                + "-- Crear la tabla Servicios\n"
                + "CREATE TABLE Servicios (\n"
                + "    S_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    S_Descripcion TEXT NOT NULL,\n"
                + "    S_FechaInicio DATE NOT NULL,\n"
                + "    S_FechaFin DATE NOT NULL,\n"
                + "    S_Costo DECIMAL(10, 2) NOT NULL,\n"
                + "    S_Tipo ENUM('Eventualidad', 'Cuidado Nocturno', 'Cuidador Interno', 'Cuidado Externo', 'Acompañamiento', 'Niñera', 'Fin de semana') NOT NULL,\n"
                + "    Per_IDPaciente VARCHAR(8) NOT NULL,\n"
                + "    Per_IDCuidador VARCHAR(8) NOT NULL,\n"
                + "    FOREIGN KEY (Per_IDPaciente) REFERENCES Pacientes(Per_ID),\n"
                + "    FOREIGN KEY (Per_IDCuidador) REFERENCES Cuidadores(Per_ID)\n"
                + ");\n"
                + "\n"
                + "-- Crear la tabla Atenciones\n"
                + "CREATE TABLE Atenciones (\n"
                + "    A_ID VARCHAR(8) PRIMARY KEY,\n"
                + "    A_Fecha DATE NOT NULL,\n"
                + "    A_HoraInicio TIME NOT NULL,\n"
                + "    A_HoraFin TIME NOT NULL,\n"
                + "    S_ID VARCHAR(8) NOT NULL,\n"
                + "    FOREIGN KEY (S_ID) REFERENCES Servicios(S_ID)\n"
                + ");";
        try (Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
