/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Soulaima
 */
public class Role {

     private String roleU;
     public Role( String roleU) {
        this.roleU = roleU;
     }
     public Role() {
    }
      public String toString() {
        return "Role{" + "roleU=" + roleU+  '}';
    }
       public String getrole() {
        return roleU;
    }
        public void setrole(String roleU) {
        this.roleU =roleU;
    }
          
}
