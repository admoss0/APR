/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.admoss.apr;

/**
 *
 * @author admos0
 */
public class APR {
    
    public static void main(String[] args){
        Organisation o = new Organisation();
        SOPL(o.getTitle());
        
        
        
    }
    
       private static void SOPL(String in){
        System.out.println("SOPL: " + in);
    }
    
}
