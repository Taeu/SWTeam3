/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaehoon;

/**
 *
 * @author JAEHOON
 */
public class UserDetail {

    private String type;
    private String id;
    private String password;
    private String email;
    private String num;
    private String numComplain;
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public String getNumComplain() {
        return numComplain;
    }

    public void setNumComplain(String numComplain) {
        this.numComplain = numComplain;
    }
}

