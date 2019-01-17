
package EchoEjercicio;

import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;


public class Cliente {

        final String HOST = "192.168.43.61";
    final int PUERTO = 5000;
    Socket sc;
    DataOutputStream mensaje;
    DataInputStream entrada;
//Cliente

    public void initClient() /*ejecuta este metodo para correr el cliente */ {
        try {

            sc = new Socket(HOST, PUERTO); /*conectar a un servidor en ip con puerto 5000*/

//creamos el flujo de datos por el que se enviara un mensaje

            mensaje = new DataOutputStream(sc.getOutputStream());

//enviamos el mensaje
//String respuesta=JOptionPane.showInputDialog(null,"Cliente...");
            mensaje.writeUTF("HOLA ABIGAIL");

//cerramos la conexi?n
            sc.close();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

    }

    public static void main(String[] args) {
        Cliente con = new Cliente();
        con.initClient();

    }

}
