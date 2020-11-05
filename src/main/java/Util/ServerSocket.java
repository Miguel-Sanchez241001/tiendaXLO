/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

        public class ServerSocket extends WebSocketServer {
            public ServerSocket(int puerto) throws UnknownHostException{
            super(new InetSocketAddress(puerto));
            System.out.println("Recibiendo conexiones"+ puerto);
}
         
    @Override
    public void onOpen(WebSocket ws, ClientHandshake ch) {
      ws.send("Bienvenido a mi servidor ");
        System.out.println("Se ha iniciado una nueva conexion");
                }

    @Override
    public void onClose(WebSocket ws, int i, String string, boolean bln) {
    }

    @Override
    public void onMessage(WebSocket ws, String mensaje) {
    ws.send("Gracias por el mensaje "+mensaje);
        System.out.println("Se ha recibido el mensaje"+mensaje);
    }

    @Override
    public void onError(WebSocket ws, Exception excptn) {
    }

    @Override
    public void onStart() {
   
    }
    
}
