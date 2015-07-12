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
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author admos0
 */
public class OrgList {

    List<OrgListMember> list;

    private Properties apr = new Properties();
    Model m;
    Logger log = Logger.getLogger(Organisation.class);
    Property title, description, website;

    public OrgList() {

        //log.setLevel(Level.OFF);
        
        try {
            apr.load(getClass().getResourceAsStream("/apr.properties"));
        
        } catch (Exception ex) {
            System.out.println("crap, I couldn't find it");      
        }
        retrieve();
        setProperties();


    }
      
        
        

        
    

    private void retrieve() {
        log.debug("starting retrieve");
        String query = "construct { ?s ?p ?o } where { ?s <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://admoss.info/apr/PoliticalOrganisation> ."
                + "?s <http://purl.org/dc/elements/1.1/title> ?o ."
                + "?s ?p ?o ."
                + " }";
        Query q;
        q = QueryFactory.create(query);
        QueryExecution qe = QueryExecutionFactory.createServiceRequest(apr.getProperty("endpoint"), q);
        m = qe.execConstruct();
        log.debug("retrieve completed");

    }

    final void setProperties() {
        title = m.createProperty("http://purl.org/dc/elements/1.1/title");
        description = m.createProperty("http://purl.org/dc/elements/1.1/description");
        website = m.createProperty("http://xmlns.com/foaf/0.1/homepage");
    }

    public List getList() {
        log.debug("getting list");
        list = new ArrayList<>();

        ResIterator i = m.listResourcesWithProperty(title, null);
        while (i.hasNext()) {
            Resource r = i.next();
            list.add(new OrgListMember(r.getURI(), r.getProperty(title).getLiteral().toString()));
        }
        Collections.sort(list);

        log.debug("list returned");
        return list;

    }

}