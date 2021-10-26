/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.utilerias;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Kimi
 */

public class EnviarMail {
    public void enviarCorreo(String destinatario, String asunto, String mensaje){
        try {
            Properties p = new Properties();
            
            p.setProperty("mail.sntp.host","sntp.gmail.com");
            p.setProperty("mail.sntp.starttls.enable","true");
            p.setProperty("mail.sntp.port","587");
            p.setProperty("mail.sntp.user","cuentadegmailnueva");
            p.setProperty("mail.sntp.auth","true");
            
            Session s = Session.getDefaultInstance(p);
            MimeMessage elMensaje = new MimeMessage(s);
            elMensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            elMensaje.addRecipient(Message.RecipientType.CC, new InternetAddress(""));
            elMensaje.setSubject(asunto);
            elMensaje.setText(mensaje);
            
            Transport t = s.getTransport("sntp");
            t.connect(p.getProperty("mail.sntp.user"),"PONTUCLAVEAQUI");
            t.close();
        } catch (AddressException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args){
        EnviarMail email = new EnviarMail();
        String destinatatio = "";
    }
}
