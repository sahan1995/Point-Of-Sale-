/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao;

import java.util.ArrayList;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface CrudDAO<T, ID> extends SuperDAO{

    public ArrayList<T> getAll() throws Exception;

    public boolean save(T entity) throws Exception;

    public boolean delete(ID id) throws Exception;

    public T findById(ID id) throws Exception;

    public boolean update(T entity) throws Exception;

}
