/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import lk.ijse.pos.db.DBConnection;

/**
 *
 * @author Sahan Rajakaruna
 */
public class CrudUitl {

    private static PreparedStatement getPre(String query, Object... args) throws Exception {

        PreparedStatement pre = DBConnection.getInstance().getConnection().prepareStatement(query);
   
        for (int i = 0; i < args.length; i++) {

        
            pre.setObject(i+1, args[i]);
      
            
        }
        return pre;
    }

    public static boolean executeUpdate(String query, Object... args) throws Exception {

      
        return getPre(query, args).executeUpdate() > 0;
    }

    public static ResultSet executeQuery(String query, Object... args) throws Exception {
        return getPre(query, args).executeQuery();
    }
}
