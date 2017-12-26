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
public class UserBrandMarketer extends User {
    private String sales;
    private String SNSAddress;
    private Report report; 
    private Brand brand = new Brand();
    
    public UserBrandMarketer(){
        super();
    }
    
    
    public UserBrandMarketer(String num, String id, String password, String email, int numComplaint, String sales, String SNSAddress, String kkk, String name,String industry ) {
        super(id, password, email, num, numComplaint);
        this.sales = sales;
        this.SNSAddress = SNSAddress;
        brand.setIndustry(industry);
        brand.setName(name);
        brand.setId(kkk); // 해당브랜드의 고유 id (ex UNIQLO 는 1번, SPAO는 4번)
        
        
    }

    
    private void feedbackWrite(){
        
    }
    private void reportRegister(){
        
    }
    private void reportRead(){
        
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
    public void setBrand(Brand brand){
        this.brand = brand;
    }
    public Brand getBrand(){
        return brand;
    }
    // id 변환함수 만들어야함
    

}
