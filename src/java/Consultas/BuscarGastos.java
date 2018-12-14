/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lucas
 */
public class BuscarGastos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String email = "samuelalvesv4@gmail.com";
        String senha = "otavio";
        
        VerificaSenha v = new VerificaSenha();
        
        System.out.println(v.verificarSenha(email, senha));
        

    }
}
