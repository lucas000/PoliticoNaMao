package Consultas;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vicom
 */

public class MandaEmail {
    
    private String emailOrigem;
    private String senha;
    private String emailDestino;
    private String assunto;
    private String msg;
    private Properties props = new Properties();

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmailDestino() {
        return emailDestino;
    }

    public void setEmailDestino(String emailDestino) {
        this.emailDestino = emailDestino;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getEmailOrigem() {
        return emailOrigem;
    }

    public void setEmailOrigem(String emailOrigem) {
        this.emailOrigem = emailOrigem;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

  public void enviarGmail() {
        boolean retorno = false;
        //Get the session object  
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session s = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication("samuelalvesv4@gmail.com","alvesv42011");//email e senha usuário 
                    }
                });

        //compose message  
        try {
            MimeMessage message = new MimeMessage(s);
            message.setFrom(new InternetAddress("samuelalvesv4@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailDestino));

            message.setSubject(assunto);
            message.setContent(msg, "text/html; charset=utf-8");

            //send message  
            Transport.send(message);

            retorno = true;

        } catch (MessagingException e) {
            retorno = false;
            e.printStackTrace();
        }
       
    }
    
    
    
}
