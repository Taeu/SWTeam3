/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaehoon;

/**
 *
 * @author JunHo
 */
public class UserBrandDetail extends UserDetail{
    private  String name;
    private  String industry;
    private  String sales;
    private  String SNSAddress;
    static private  int count;
    
    public UserBrandDetail(String id, String password, String industry, String name, String sales, String SNSAddress, String email, String num, String type) {
        this.name = new String(name);
        this.industry = new String(industry);
        this.sales = new String(sales);
        this.SNSAddress = new String(SNSAddress);
        setId(id);
        setEmail(email);
        setNum(num);
        setPassword(password);
        setType(type);
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

   
}
