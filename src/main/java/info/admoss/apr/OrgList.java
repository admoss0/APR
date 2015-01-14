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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author admos0
 */
public class OrgList {

    List<OrgListMember> list;
    private String endpoint = "http://semantic-admoss.rhcloud.com/ds/query";
    Model m;
    Logger log = Logger.getLogger(Organisation.class);

    public OrgList() {

        list = new ArrayList<>();

    }

    private void retrieve() {
        log.debug("starting retrieve for ");
        String query = "construct { ?s ?p ?o } where { ?s ?p ?o ."
                + " }";
        Query q;
        q = QueryFactory.create(query);
        QueryExecution qe = QueryExecutionFactory.createServiceRequest(endpoint, q);
        m = qe.execConstruct();
        log.debug("retrieve completed");
    }

    class OrgListMember {

        private String id;
        private String title;

        @Override
        public String toString() {
            return this.getTitle();
        }

        /**
         * @return the id
         */
        public String getId() {
            return id;
        }

        /**
         * @return the title
         */
        public String getTitle() {
            return title;
        }

        /**
         * @param id the id to set
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @param title the title to set
         */
        public void setTitle(String title) {
            this.title = title;
        }
    }

}
