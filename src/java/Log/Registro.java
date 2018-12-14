/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Log;

/**
 *
 * @author Allan
 */
     

public class Registro {
    
    //Date data = new Date();
    //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private String user;
    private String operacao;
    private String data;
    

    public Registro(String user, String data, String operacao) {
        this.user = user;
        this.data = data;
        this.operacao = operacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    @Override
    public String toString() {
        return "Registro{" + "user:" + user + ", operacao:" + operacao + ", data:" + data + '}';
    }

  
    
    
    

  
    
    
    
}
