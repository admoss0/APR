/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.admoss.apr;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

/**
 *
 * @author admos0
 */
public class Organisation {
    
    Model m;
    Resource r;
    Property title, description, website;
    
    public Organisation() {
        
        m = ModelFactory.createDefaultModel();
        
        SOPL("Organisation initialised");
        
    }
    
    private void SOPL(String in){
        System.out.println("SOPL: " + in);
    }
}
