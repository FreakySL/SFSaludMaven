/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author santi
 */
public interface DAO<T> {
    
    public boolean create(T object);
    public T read(int id) throws SQLException;
    public boolean update (T object);
    public T delete(int id);
    public List<T> readAll();
    
}
