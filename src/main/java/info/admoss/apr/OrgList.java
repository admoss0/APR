/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package info.admoss.apr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admos0
 */
public class OrgList {
    
    
    public OrgList(){
        
        List<OrgListMember> list = new ArrayList<>();
          
    }
    
    
    class OrgListMember {
        private String id;
        private String title;
        
        @Override
        public String toString(){
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
