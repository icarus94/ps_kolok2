/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package izuzetak;

/**
 *
 * @author vojkan
 */
public class ValidationException extends Exception {
    
    String poruka;

    public ValidationException(String poruka) {
        super(poruka);
        this.poruka = poruka;    
    }
    
        
    
    
}
