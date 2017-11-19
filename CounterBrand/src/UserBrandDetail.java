/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterbrand;

/**
 *
 * @author JunHo
 */
public class UserBrandDetail {
    
    private  String id;
    private  String password;
    private  String name;
    private  String industry;
    private  String sales;
    private  String SNSAddress;
    private  String Email;
    private  String num;
    static private  int count;
    
    public UserBrandDetail(String id, String password, String industry, String name, String sales, String SNSAddress, String Email, String num) {
        this.id = new String(id);
        this.name = new String(name);
        this.industry = new String(industry);
        this.sales = new String(sales);
        this.SNSAddress = new String(SNSAddress);
        this.Email = new String(Email);
        this.password = new String(password);
        this.num = new String(num);
    }
    
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getSNSAddress() {
        return SNSAddress;
    }

    public void setSNSAddress(String SNSAddress) {
        this.SNSAddress = SNSAddress;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
   
}
