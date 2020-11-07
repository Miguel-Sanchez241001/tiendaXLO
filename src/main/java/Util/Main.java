/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.net.UnknownHostException;

/**
 *
 * @author Rodrigo
 */
public class Main {

    public static void main(String[] args) {
        try {
        new ServerSocket(8080).start();
            
        } catch (UnknownHostException e) {
        }
    }
    
}
