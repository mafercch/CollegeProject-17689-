/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinesFolder;
/**
 *
 * @author mariacontreras / 17689
 */
public class Branch {
    
    Long id;
    String name;
    String details;

    public Branch(Long id, String name, String details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public String getName() {
        return name;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return "( branch id : " + getId() + " ) " + this.getName() + " , details : " + this.getDetails();
    }
}
