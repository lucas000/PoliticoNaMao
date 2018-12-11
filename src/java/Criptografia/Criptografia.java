/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Criptografia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author Vicom
 */
public class Criptografia {

    /* o delimitador usado para separar campos no arquivo de senhas */
    public static final char DELIMITER = ':';
    public static final String DELIMITER_STR = "" + DELIMITER;
    //dUserMap é uma Hashtable por nome de usuário
    private static Hashtable dUserMap;
    /**
     * localização do arquivo de senha no disco
     */
    private static String dPwdFile;

    public static void add(String username, String password) throws Exception {
        dUserMap.put(username, computeSHA(password));
    }

    public static boolean checkPassword(String username, String password) {
        try {
            String t = (String) dUserMap.get(username);
            return (t == null) ? false : t.equals(computeSHA(password));
        } catch (Exception e) {
        }
        return false;
    }

    /* Seguem as operações de gerenciamento de arquivos de senha */
    public static void init(String pwdFile) throws Exception {
        dUserMap = load(pwdFile);
        dPwdFile = pwdFile;
    }

    public static void flush() throws Exception {
        store(dPwdFile, dUserMap);
    }

    public static Hashtable load(String pwdFile) {
        Hashtable userMap = new Hashtable();
        try {
            FileReader fr = new FileReader(pwdFile);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                int delim = line.indexOf(DELIMITER_STR);
                String username = line.substring(0, delim);
                String hpwd = line.substring(delim + 1);
                userMap.put(username, hpwd);
            }
        } catch (Exception e) {
            System.err.println("Warning: Could not load password file.");
        }
        return userMap;
    }

    public static void store(String pwdFile, Hashtable userMap) throws Exception {
        try {
            FileWriter fw = new FileWriter(pwdFile);
            Enumeration e = userMap.keys();
            while (e.hasMoreElements()) {
                String uname = (String) e.nextElement();
                fw.write(uname + DELIMITER_STR
                        + userMap.get(uname).toString() + "");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String computeSHA(String preimage) throws Exception {
        MessageDigest md = null;
        md = MessageDigest.getInstance("SHA-256");
        md.update(preimage.getBytes("UTF-8"));
        byte raw[] = md.digest();
        System.out.println("Criptografou isso: " + (new sun.misc.BASE64Encoder().encode(raw)));
        return (new sun.misc.BASE64Encoder().encode(raw));
    }

}
