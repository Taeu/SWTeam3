/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author user
 */
public class User {
       private String num;
       
    private String id;
    private String password;
    private String email;
 
    private int numComplaint;
    public User(){
 
    }
    public User(String id, String password, String email, String num, int numComplaint) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.num = num;
        this.numComplaint = numComplaint;
    }
    
    
    private void register(){
        
    }
    private void rankView(){
        
    }
    private void complainList(){
        
    }
    private void complainRead(){
        
    }
    
    
    // getter setter
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getNumComplaint() {
        return numComplaint;
    }

    public void setNumComplaint(int numComplaint) {
        this.numComplaint = numComplaint;
    }
}
