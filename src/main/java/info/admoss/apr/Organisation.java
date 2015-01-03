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
    private String endpoint;
    private String id;
    private Model m;
    private Resource r;
    private Property title;
    private Property description;
    private Property website;
    
    public Organisation() {
        
        m = ModelFactory.createDefaultModel();
        setProperties();
        r = m.createResource("http://admoss.info/apr/org/org#103");
        r.addProperty(title, "Liberty and Democracy Party" );
        r.addProperty(description, "\"The Liberty & Democracy Party (formerly the Liberal Democratic Party) stands for lower taxes, small government and individual responsibility.\"");
        r.addProperty(website, "www.ldp.org.au");
        SOPL("Organisation initialised");
        
    }
    
    
    public Organisation (String input) {
            m = ModelFactory.createDefaultModel();
        setProperties();
        
    }
    
    private void SOPL(String in){
        System.out.println("SOPL: " + in);
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return r.getProperty(title).getObject().toString();
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description.toString();
    }

    /**
     * @return the website
     */
    public String getWebsite() {
        return website.toString();
    }

    /**
     * @param title the title to set
     */
    public void setTitle(Property title) {
        this.title = title;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(Property description) {
        this.description = description;
    }

    /**
     * @param website the website to set
     */
    public void setWebsite(Property website) {
        this.website = website;
    }
    
    
    final void setProperties() {  
      title = m.createProperty("http://purl.org/dc/elements/1.1/title");
      description = m.createProperty("http://purl.org/dc/elements/1.1/description");
      website = m.createProperty("http://xmlns.com/foaf/0.1/homepage");  
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the endpoint
     */
    public String getEndpoint() {
        return endpoint; 
    }

    /**
     * @param endpoint the endpoint to set
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
