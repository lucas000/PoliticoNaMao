/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Vicom
 */
public class VerificaSenha {

    public boolean senhaBoa(final String senha) {
        // Criterio 1: Senha com 8 caracteres ou mais
        if (senha.length() < 8) {
            return false;
        }
        // Criterio 2: Senha contém letras maiúsculas
        Pattern p2 = Pattern.compile("[A-Z]");
        if (!p2.matcher(senha).find()) {
            return false;
        }
        // Criterio 3: Senha contém letras minúsculas
        Pattern p3 = Pattern.compile("[a-z]");
        if (!p3.matcher(senha).find()) {
            return false;
        }
        // Criterio 4: Senha contém dígitos
        Pattern p4 = Pattern.compile("[0-9]");
        if (!p4.matcher(senha).find()) {
            return false;
        }
        // Critério 5: Senha contém um dos seguintes caracteres especiais: - + * / = % ! @ & $
        Pattern p5 = Pattern.compile("[-+*/=%!@&$#]");
        if (!p5.matcher(senha).find()) {
            return false;
        }
        // senão...
        return true;
    }

    public boolean verificaCampos(String nome, String email, String senha1, String senha2) {

        if (nome == null || nome.equals("")) {
            return false;
        }
        if (email == null || email.equals("")) {
            return false;
        }
        if (senha1 == null || senha1.equals("")) {
            return false;
        }
        if (senha2 == null || senha2.equals("")) {
            return false;
        }
        return true;
    }
    
    public boolean verificaCampos(String email, String senha1) {

        if (email == null || email.equals("")) {
            return false;
        }
        if (senha1 == null || senha1.equals("")) {
            return false;
        }
        return true;
    }
    
    
    public boolean verificarSenha(String email , String senha){
        ArrayList<String> sub = new ArrayList();
        ArrayList<String> sub1 = new ArrayList();

        for (int i = 0; i < email.length(); i++) {
            sub.add("" + email.charAt(i) + email.charAt(i + 1) + email.charAt(i + 2) + email.charAt(i + 3));
            if (email.charAt(i + 4) == '.') {
                break;
            }
        }

        for (int i = 0; i < senha.length(); i++) {
            if ((i + 3) == senha.length()) {
                break;
            }
            sub1.add("" + senha.charAt(i) + senha.charAt(i + 1) + senha.charAt(i + 2) + senha.charAt(i + 3));

        }
        for (String sub1s : sub1) {
            Pattern p = Pattern.compile(sub1s);
            for (int i = 0; i < sub.size(); i++) {
                Matcher m = p.matcher(sub.get(i));
                if(!m.matches() == false){
                return false;
                }
            }
        }
        return true;
    }
}