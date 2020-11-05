/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.UserBEAN;
import Util.ConnectionBD;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class UsuarioDAO {
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    UserBEAN objuser= new UserBEAN();
    ArrayList<UserBEAN> lista=null;
     public void AgregarUsuario(UserBEAN objuser){
    try{
     cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("INSERT INTO `usuario`(`id`, `nombre`, `apellidos`, `telefono`, `email`) VALUES (id,?,?,?,?)");
           pt.setString(1, objuser.getNombre());
           pt.setString(2,objuser.getApellido());
           pt.setInt(3, objuser.getTelefono());
           pt.setString(4, objuser.getEmail());
           
           pt.executeUpdate();
            pt.close();
            cn.close();
            
    
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
    }
        public void AgregarLogin(UserBEAN objuser){
    try{
     cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("INSERT INTO `login`(`id`, `usuario`, `clave`) VALUES (?,?,?)");
           pt.setInt(1, objuser.getCodigo());
           pt.setString(2,objuser.getUsuario());
           pt.setString(3, objuser.getClave());
           
           pt.executeUpdate();
            pt.close();
            cn.close();
            
    
    }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    
    }
     
      public int ValidarLogin(UserBEAN objuser){
        int val=0;
        try {
            
            cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("SELECT login.usuario,login.clave,usuario.nombre,usuario.apellidos from login INNER JOIN usuario on usuario.id=login.id WHERE login.usuario=? and login.clave=?");
            pt.setString(1, objuser.getUsuario());
            pt.setString(2, objuser.getClave());
            rs=pt.executeQuery();
            if(rs.next())
            {
                val= val+1;
                objuser.setNombre(rs.getString("nombre"));
                objuser.setApellido(rs.getString("apellidos"));

                objuser.setUsuario(rs.getString("usuario"));
                objuser.setClave(rs.getString("clave"));
            }
            if (val==1) {
                return 1;
            }else{
            return 0;}
            
        } catch (Exception e) {JOptionPane.showMessageDialog(null, e);
         return 0;   
        }
        
        }
     
}
