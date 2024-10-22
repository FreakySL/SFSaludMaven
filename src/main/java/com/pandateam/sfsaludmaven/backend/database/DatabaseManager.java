/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import org.mindrot.jbcrypt.BCrypt;


/**
 *
 * @author santi
 */
public class DatabaseManager {

    private static DatabaseManager instance;
    private Connection connection;

    private DatabaseManager() {

        //CONSULTAR SOBRE INFORMACIÓN DE USUARIO Y CONTRASEÑA EN EL CÓDIGO
        String url = "jdbc:mysql://localhost:3306/SanFranciscoDB";
        String user = "root";
        String password = "admin";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            crearTablas();
            crearUsuarioBase();
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
        stmt.execute("CREATE TABLE IF NOT EXISTS Persona (\n"
                + "	Per_ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,\n"
                + "    Per_Nombre VARCHAR(50) NOT NULL,\n"
                + "    Per_Apellido VARCHAR(50) NOT NULL,\n"
                + "    Per_NumeroDocumento INT NOT NULL,\n"
                + "    Per_FechaNacimiento DATE NOT NULL,\n"
                + "    Per_Telefono INT NOT NULL,\n"
                + "    Per_Correo VARCHAR(255) NOT NULL,\n"
                + "    Per_Esp VARCHAR(20) CHECK (Per_Esp IN ('Paciente', 'Cuidador', 'Paciente y Cuidador')) NOT NULL\n"
                + ");");

        // Crear la tabla Pacientes
        stmt.execute("CREATE TABLE IF NOT EXISTS Paciente (\n"
                + "	Per_ID INT UNIQUE PRIMARY KEY,\n"
                + "	P_TieneSuscripcion VARCHAR(8) NOT NULL,\n"
                + "    P_Esp VARCHAR(20) CHECK (P_Esp IN ('Socio','NoSocio')) NOT NULL,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Persona(Per_ID)\n"
                + ");");

        // Crear la tabla Cuidadores
        stmt.execute("CREATE TABLE IF NOT EXISTS Cuidador (\n"
                + "    Per_ID INT UNIQUE PRIMARY KEY,\n"
                + "    C_Profesion VARCHAR(100) NOT NULL,\n"
                + "    C_Experiencia VARCHAR(255) NOT NULL,\n"
                + "    C_Categoria VARCHAR(50) NOT NULL,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Persona(Per_ID)\n"
                + ");");

        stmt.execute("CREATE TABLE IF NOT EXISTS Suscripcion (\n"
                + "    Sus_ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,\n"
                + "    Sus_Titular INT UNIQUE NOT NULL,\n"
                + "    Sus_FechaInicio DATE NOT NULL,\n"
                + "    Sus_Descuento INT NOT NULL,\n"
                + "    Sus_Estado VARCHAR(30) NOT NULL\n"
                + ");");

        stmt.execute("CREATE TABLE IF NOT EXISTS Socio (\n"
                + "    Per_ID INT UNIQUE PRIMARY KEY,\n"
                + "    S_NumeroSocio VARCHAR(20) UNIQUE NOT NULL,\n"
                + "    Sus_ID INT NOT NULL,\n"
                + "    FOREIGN KEY (Sus_ID) REFERENCES Suscripcion(Sus_ID),\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Paciente(Per_ID)\n"
                + ");");

        stmt.execute("CREATE TABLE IF NOT EXISTS NoSocio (\n"
                + "    Per_ID INT UNIQUE PRIMARY KEY,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Paciente(Per_ID)\n"
                + ");");

        stmt.execute("CREATE TABLE IF NOT EXISTS DeclaracionJurada (\n"
                + "    DJ_ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,\n"
                + "    DJ_Enfermedades TEXT,\n"
                + "    DJ_OperacionesPrevias TEXT,\n"
                + "    Per_ID INT NOT NULL,\n"
                + "    FOREIGN KEY (Per_ID) REFERENCES Paciente(Per_ID)\n"
                + ");");

        stmt.execute("CREATE TABLE IF NOT EXISTS Servicio (\n"
                + "    S_ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,\n"
                + "    S_Descripcion VARCHAR(255) NOT NULL,\n"
                + "    S_FechaInicio DATE NOT NULL,\n"
                + "    S_FechaFin DATE NOT NULL,\n"
                + "    S_Costo DECIMAL(10, 2) NOT NULL,\n"
                + "    S_Tipo VARCHAR(30) NOT NULL,\n"
                + "    Per_IDPaciente INT NOT NULL,\n"
                + "    Per_IDCuidador INT NOT NULL,\n"
                + "    FOREIGN KEY (Per_IDPaciente) REFERENCES Paciente(Per_ID),\n"
                + "    FOREIGN KEY (Per_IDCuidador) REFERENCES Cuidador(Per_ID)\n"
                + ");");

        stmt.execute("CREATE TABLE IF NOT EXISTS Atencion (\n"
                + "    A_ID INT AUTO_INCREMENT UNIQUE PRIMARY KEY,\n"
                + "    A_Fecha DATE NOT NULL,\n"
                + "    A_HoraInicio TIME NOT NULL,\n"
                + "    A_HoraFin TIME NOT NULL,\n"
                + "    S_ID INT NOT NULL,\n"
                + "    FOREIGN KEY (S_ID) REFERENCES Servicio(S_ID)\n"
                + ");");
        
        stmt.execute("CREATE TABLE IF NOT EXISTS Usuario (\n"
                + "    Usuario_ID INT AUTO_INCREMENT PRIMARY KEY,\n"
                + "    Usuario_Nombre VARCHAR(50) NOT NULL,\n"
                + "    Usuario_Contrasena VARCHAR(255) NOT NULL\n"
                + ");");

        try {
            stmt.execute("INSERT INTO Persona (Per_Nombre, Per_Apellido, Per_NumeroDocumento, Per_FechaNacimiento, Per_Telefono, Per_Correo, Per_Esp)\n"
                    + "VALUES ('Juan', 'Pérez', 12345678, '1985-03-25', 123456789, 'juan.perez@example.com', 'Paciente y Cuidador'),\n"
                    + "       ('María', 'González', 23456789, '1990-07-14', 987654321, 'maria.gonzalez@example.com', 'Cuidador'),\n"
                    + "       ('Luis', 'Rodríguez', 34567890, '1988-11-02', 555555555, 'luis.rodriguez@example.com', 'Paciente'),\n"
                    + "       ('Ana', 'López', 45678901, '1995-05-18', 444444444, 'ana.lopez@example.com', 'Paciente'),\n"
                    + "       ('Carlos', 'Martínez', 56789012, '1980-09-09', 333333333, 'carlos.martinez@example.com', 'Paciente');");

            stmt.execute("INSERT INTO Paciente (Per_ID, P_TieneSuscripcion, P_Esp)\n"
                    + "VALUES (1, 'Sí', 'Socio'),\n"
                    + "       (3, 'No', 'NoSocio'),\n"
                    + "       (4, 'Sí', 'Socio'),\n"
                    + "       (5, 'No', 'NoSocio');");

            stmt.execute("INSERT INTO Cuidador (Per_ID, C_Profesion, C_Experiencia, C_Categoria)\n"
                    + "VALUES (1, 'Enfermero', '5 años', 'Senior'),\n"
                    + "       (2, 'Cuidador domiciliario', '3 años', 'Junior');");

            stmt.execute("INSERT INTO Suscripcion (Sus_Titular, Sus_FechaInicio, Sus_Descuento, Sus_Estado)\n"
                    + "VALUES (12345, '2022-01-15', 10, 'Activo'),\n"
                    + "       (12346, '2021-07-20', 15, 'Activo');");

            stmt.execute("INSERT INTO Socio (Per_ID, S_NumeroSocio, Sus_ID)\n"
                    + "VALUES (1, 'S001', 1),\n"
                    + "       (4, 'S002', 2);");

            stmt.execute("INSERT INTO NoSocio (Per_ID)\n"
                    + "VALUES (3),\n"
                    + "       (5);");

            stmt.execute("INSERT INTO DeclaracionJurada (DJ_Enfermedades, DJ_OperacionesPrevias, Per_ID)\n"
                    + "VALUES ('Hipertensión', 'Apéndice', 1),\n"
                    + "       ('Diabetes', 'Cirugía ocular', 3),\n"
                    + "       ('Asma', 'Ninguna', 4),\n"
                    + "       ('Ninguna', 'Ninguna', 5);");

            stmt.execute("INSERT INTO Servicio (S_Descripcion, S_FechaInicio, S_FechaFin, S_Costo, S_Tipo, Per_IDPaciente, Per_IDCuidador)\n"
                    + "VALUES ('Cuidado nocturno para paciente con hipertensión', '2024-01-01', '2024-01-05', 500.00, 'Cuidado Nocturno', 1, 2),\n"
                    + "       ('Acompañamiento para paciente con diabetes', '2024-02-01', '2024-02-03', 300.00, 'Acompañamiento', 3, 1);");

            stmt.execute("INSERT INTO Atencion (A_Fecha, A_HoraInicio, A_HoraFin, S_ID)\n"
                    + "VALUES ('2024-01-01', '20:00', '08:00', 1),\n"
                    + "       ('2024-02-01', '09:00', '17:00', 2);");
        } catch (Exception e) {
            System.out.println("Inserciones realizadas");
        }

    }

    private void crearUsuarioBase() throws SQLException {

        String sql = "INSERT INTO Usuario (Usuario_Nombre, Usuario_Contrasena) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            String nombre = "admin";
            String contrasena = "admin";
            String hashedContrasena = BCrypt.hashpw(contrasena, BCrypt.gensalt());

            pstmt.setString(1, nombre);
            pstmt.setString(2, hashedContrasena);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public static DefaultTableModel resultToTable(ResultSet rs) throws SQLException {
        // Esta es una función auxiliar que les permite convertir los resultados de las
        // consultas (ResultSet) a un modelo interpretable para la tabla mostrada en pantalla
        // (es decir, para un objeto de tipo JTable, ver línea 81)
        ResultSetMetaData metaData = rs.getMetaData();

        // creando las columnas de la tabla
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        

        // creando las filas de la tabla con los resultados de la consulta
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
                System.out.println(rs.getObject(columnIndex).toString());
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);
    }

}
