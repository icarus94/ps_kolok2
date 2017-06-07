/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

/**
 *
 * @author Miroslav
 */
public class Validator {
    private static Validator instanca;

    private Validator() {
    }

    public static Validator getInstanca() {
        if(instanca == null)
            instanca = new Validator();
        return instanca;
    }
    
    public boolean checkUsername(String username){
        if(!username.contains("@")){
            return false;
        }
        
        return true;
    }
    
    public boolean checkPassword(String pass){
        if(!pass.isEmpty() && Character.isAlphabetic(pass.charAt(0))){
            for (int i = 0; i < pass.length(); i++) {
                if(Character.isDigit(pass.charAt(i))){
                    return true;
                }
            }
        }
        
        return false;
    }

    public boolean checkSlovo(String slovo) {
        if(slovo.length() != 1){
            return false;
        }
        return true;
    }
}
