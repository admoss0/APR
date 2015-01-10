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

    public static void main(String[] args) {
        Organisation o = new Organisation("http://admoss.info/apr/org/org#103");
        SOPL("ID: " + o.getId());
        SOPL("Title: " + o.getTitle());
        SOPL("Description: " + o.getDescription());
        SOPL("Website: " + o.getWebsite());

    }

    private static void SOPL(String in) {
        System.out.println("SOPL: " + in);
    }

}
