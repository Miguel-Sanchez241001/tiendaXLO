/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.ProductoBEAN;
import Util.ConnectionBD;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class ProductoDAO {
    Connection cn=null;
    PreparedStatement pt=null;
    ResultSet rs=null;
    ProductoBEAN objProducto= new ProductoBEAN();
    ArrayList<ProductoBEAN> lista=null;
 public void AgregarProducto(ProductoBEAN objProducto){
    try{
     cn=ConnectionBD.getConexionBD();
            pt=cn.prepareStatement("INSERT INTO `producto`(`idProd`, `id`, `producto`, `descripcion`, `foto`, `costo`, `categoria`) VALUES (?,?,?,?,?,?,?)");
            pt.setInt(1,objProducto.getCodigoProducto());
           pt.setInt(2, objProducto.getCodigoUsuario());
           pt.setString(3,objProducto.getProducto());
           pt.setString(4,objProducto.getDescripcion());
           pt.setBlob(5, objProducto.getFoto());
           pt.setDouble(6, objProducto.getCosto());
           pt.setString(7, objProducto.getCategoria());
           
            pt.executeUpdate();
            pt.close();
            cn.close();
            
    
    }catch(Exception e){JOptionPane.showMessageDialog(null, "error");}
    
    }
    
}
