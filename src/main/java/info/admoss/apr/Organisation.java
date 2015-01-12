/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.admoss.apr;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author admos0
 */
public class Organisation {

    private String endpoint = "http://semantic-admoss.rhcloud.com/ds/query";
    private String id;
    private Model m;
    private Resource r;
    private Property title;
    private Property description;
    private Property website;
    private Level loglevel = Level.DEBUG;
    Logger log = Logger.getLogger(Organisation.class);
    
    
   
    

    public Organisation() {
      log.setLevel(loglevel);
        m = ModelFactory.createDefaultModel();
        setProperties();
        testOrg();
    }

    public Organisation(String input) {
        log.setLevel(loglevel);
        m = ModelFactory.createDefaultModel();
        setProperties();
        setId(input);
    }

    /**
     * A convenience method to print to stdout
     *
     * @param in - the string to print
     */
    private void SOPL(String in) {
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
        return r.getProperty(description).getObject().toString();
    }

    /**
     * @return the website
     */
    public String getWebsite() {
        return r.getProperty(website).getObject().toString();
    }

    /**
     * @param title the title to set
     */
    public void setTitle(Property title) {
        r.removeAll(this.title);
        r.addProperty(this.title, title);
    }

    /**
     * @param description the description to set
     */
    public void setDescription(Property description) {
        r.removeAll(this.description);
        r.addProperty(this.description, description);
    }

    /**
     * @param website the website to set
     */
    public void setWebsite(String website) {
        r.removeAll(this.website);
        r.addProperty(this.website, website);
    }

    /**
     * Sets up the Property constants
     */
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
        retrieve();
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

    private void retrieve() {
        log.debug("starting retrieve for " + id);
        String query = "construct { <" + id + "> ?p ?o } where { <" + id + "> ?p ?o }";
        Query q;
        q = QueryFactory.create(query);
        QueryExecution qe = QueryExecutionFactory.createServiceRequest(endpoint, q);
        m = qe.execConstruct();
        r = m.getResource(id);
        log.debug("retrieve completed");
    }

    private void testOrg() {
  
        r = m.createResource("http://admoss.info/apr/org/org#103");
        r.addProperty(title, "Liberty and Democracy Party");
        r.addProperty(description, "\"The Liberty & Democracy Party (formerly the Liberal Democratic Party) stands for lower taxes, small government and individual responsibility.\"");
        r.addProperty(website, "www.ldp.org.au");
    log.debug("Test Organisation initialised");
    }
}
