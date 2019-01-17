package EchoEjercicio;
import java.net.*;
import java.io.*;

public class Servidor {
    
    final int PUERTO = 5000;
    ServerSocket sc;
    Socket so;
    DataOutputStream salida;
    String mensajeRecibido;
//SERVIDOR

    public void initServer() {
        BufferedReader entrada;

        try {
            sc = new ServerSocket(PUERTO);/* crea socket servidor que escuchara en puerto 5000*/
            so = new Socket();
            System.out.println("Esperando una conexi?n:");
            so = sc.accept();
//Inicia el socket, ahora esta esperando una conexi?n por parte del cliente
            System.out.println("Un cliente se ha conectado.");
//Canales de entrada y salida de datos
            entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
            salida = new DataOutputStream(so.getOutputStream());
            System.out.println("Confirmando conexion al cliente....");
            salida.writeUTF("Conexi?n exitosa..envia un mensaje :D");
//Recepcion de mensaje
            mensajeRecibido = entrada.readLine();
            System.out.println(mensajeRecibido);
            salida.writeUTF("Se recibio tu mensaje.. Terminando conexion...");
            salida.writeUTF("Gracias por conectarte, adios!");
            System.out.println("Cerrando conexi?n...");
            sc.close();//Aqui se cierra la conexi?n con el cliente
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Servidor con = new Servidor();
        con.initServer();
    }
}


