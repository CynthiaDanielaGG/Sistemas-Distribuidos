/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;

//ConexionCliente.java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextArea;
import org.apache.log4j.Logger;


public class ConexionCliente extends Thread implements Observer{
    
    private Logger log = Logger.getLogger(ConexionCliente.class);
    private Socket socket; 
    private MensajesChat mensajes;
    private DataInputStream entradaDatos;
    private DataOutputStream salidaDatos;
    private JTextArea jTextArea1;
    
    public ConexionCliente (Socket socket, MensajesChat mensajes,JTextArea area){
        this.socket = socket;
        this.mensajes = mensajes;
        this.jTextArea1=area;
        try {
            entradaDatos = new DataInputStream(socket.getInputStream());
            salidaDatos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            jTextArea1.append("Error al crear los stream de entrada y salida : " + ex.getMessage()
                +System.lineSeparator());
        }
    }
    
    @Override
    public void run(){
        String mensajeRecibido;
        boolean conectado = true;
        // Se apunta a la lista de observadores de mensajes
        mensajes.addObserver(this);
        
        while (conectado) {
            try {
                // Lee un mensaje enviado por el cliente
                mensajeRecibido = entradaDatos.readUTF();
                // Pone el mensaje recibido en mensajes para que se notifique 
                // a sus observadores que hay un nuevo mensaje.
                mensajes.setMensaje(mensajeRecibido);
            } catch (IOException ex) {
                jTextArea1.append("Cliente con la IP " + socket.getInetAddress().getHostName() + " desconectado."
                        +System.lineSeparator());
                conectado = false; 
                // Si se ha producido un error al recibir datos del cliente se cierra la conexion con el.
                try {
                    entradaDatos.close();
                    salidaDatos.close();
                } catch (IOException ex2) {
                    jTextArea1.append("Error al cerrar los stream de entrada y salida :" + ex2.getMessage()+
                            System.lineSeparator());
                }
            }
        }   
    }
    
    @Override
    public void update(Observable o, Object arg) {
        try {
            // Envia el mensaje al cliente
            salidaDatos.writeUTF(arg.toString());
        } catch (IOException ex) {
            jTextArea1.append("Error al enviar mensaje al cliente (" + ex.getMessage() + ")."+System.lineSeparator());
        }
    }
}