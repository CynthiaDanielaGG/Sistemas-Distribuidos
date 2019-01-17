
package Chat;


//Interfaz_chat.java

import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author Administrador
 */
public class Interfaz_chat extends javax.swing.JFrame {

    private Logger log = Logger.getLogger(Interfaz_chat.class);
    private Socket socket;
    
    private int puerto;
    private String host;
    private String usuario;
    public Interfaz_chat() {
        initComponents();
        ventana_inicio();
        jTextField1.setText(usuario);
        jTextField_mensaje.requestFocus();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jTextField_mensaje = new javax.swing.JTextField();
        jButton_enviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHAT ITCH");

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("USUARIO:");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(51, 255, 204));
        jTextField1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 204));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTextArea.setEditable(false);
        jTextArea.setBackground(new java.awt.Color(51, 255, 204));
        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextArea.setForeground(new java.awt.Color(0, 0, 204));
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Mensaje nuevo:");

        jTextField_mensaje.setBackground(new java.awt.Color(51, 255, 204));
        jTextField_mensaje.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextField_mensaje.setForeground(new java.awt.Color(0, 0, 255));
        jTextField_mensaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_mensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_mensajeKeyPressed(evt);
            }
        });

        jButton_enviar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton_enviar.setForeground(new java.awt.Color(0, 0, 204));
        jButton_enviar.setText("Enviar");
        jButton_enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_enviarActionPerformed(evt);
            }
        });
        jButton_enviar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton_enviarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jButton_enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_mensaje)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel2)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(jTextField_mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_enviar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void jButton_enviarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        ConexionServidor obj_con=new ConexionServidor(socket, jTextField_mensaje, usuario);
        obj_con.actionPerformed(evt);
        jTextField_mensaje.requestFocus();
    }                                              

    private void jTextField_mensajeKeyPressed(java.awt.event.KeyEvent evt) {                                              
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            jButton_enviarActionPerformed(null);
    }                                             

    private void jButton_enviarKeyPressed(java.awt.event.KeyEvent evt) {                                          
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            jButton_enviarActionPerformed(null);
    }                                         

    public void ventana_inicio(){
    // Ventana de configuracion inicial
        VentanaConfiguracion vc = new VentanaConfiguracion(this);
        host = vc.getHost();
        puerto = vc.getPuerto();
        usuario = vc.getUsuario();
        
        log.info("Quieres conectarte a " + host + " en el puerto " + puerto + " con el nombre de ususario: " + usuario + ".");
        
        // Se crea el socket para conectar con el Sevidor del Chat
        try {
            socket = new Socket(host, puerto);
        } catch (UnknownHostException ex) {
            log.error("No se ha podido conectar con el servidor (" + ex.getMessage() + ").");
        } catch (IOException ex) {
            log.error("No se ha podido conectar con el servidor (" + ex.getMessage() + ").");
        }
    }
    
    public void recibirMensajesServidor(){
        // Obtiene el flujo de entrada del socket
        DataInputStream entradaDatos = null;
        String mensaje;
        
        jTextArea.setLineWrap(true); // Las lineas se parten al llegar al ancho del textArea
        jTextArea.setWrapStyleWord(true); // Las lineas se parten entre palabras (por los espacios blancos)
        //actualizar el scroll
        DefaultCaret caret = (DefaultCaret)jTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        try {
            entradaDatos = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            log.error("Error al crear el stream de entrada: " + ex.getMessage());
        } catch (NullPointerException ex) {
            log.error("El socket no se creo correctamente. ");
        }
        
        // Bucle infinito que recibe mensajes del servidor
        boolean conectado = true;
        while (conectado) {
            try {
                mensaje = entradaDatos.readUTF();
                jTextArea.append(mensaje + System.lineSeparator());
            } catch (IOException ex) {
                log.error("Error al leer del stream de entrada: " + ex.getMessage());
                conectado = false;
            } catch (NullPointerException ex) {
                log.error("El socket no se creo correctamente. ");
                conectado = false;
            }
        }
    }
    
    public static void main(String args[]) {
        PropertyConfigurator.configure("log4j.properties");        
        
        Interfaz_chat c = new Interfaz_chat();
        c.setVisible(true);
        c.recibirMensajesServidor();
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton_enviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField_mensaje;
    // End of variables declaration                   
}

