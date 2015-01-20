/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.admoss.apr;

import org.apache.log4j.Logger;

<<<<<<< HEAD

=======
>>>>>>> adb047d1fa3d73ed413b7573ce8a57d06d32fa2f
/**
 *
 * @author admos0
 */
public class APR {
    
    static Logger log = Logger.getLogger(APR.class);

    public static void main(String[] args) {
        Organisation o = new Organisation("http://admoss.info/apr/org/org#106"
                + "");
        SOPL("ID: " + o.getId());
        SOPL("Title: " + o.getTitle());
        SOPL("Description: " + o.getDescription());
        SOPL("Website: " + o.getWebsite());
        
        log.info("****************************************************");

        OrgList ol = new OrgList();
<<<<<<< HEAD
        log.info("List: " + ol.getList().toString());
=======
>>>>>>> adb047d1fa3d73ed413b7573ce8a57d06d32fa2f
        
    }

    private static void SOPL(String in) {
       log.info(in);
    }

}
