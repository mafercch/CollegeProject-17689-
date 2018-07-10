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
public class Course {
    String name;
    String details;

    public Course(String name, String details) {
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

    public String toString() {
        return "name : " + this.getName() + " , details : " + this.getDetails();
    }
    
}
