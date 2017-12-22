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
    private String industry;
    private String sales;
    private String SNSAddress;
    private Report report; 
    private Brand brand = new Brand();

    public UserBrandMarketer(String industry, String sales, String SNSAddress, String id, String password, String email, String num, int numComplaint, String kkk ) {
        super(id, password, email, num, numComplaint);
        this.industry = industry;
        this.sales = sales;
        this.SNSAddress = SNSAddress;
        brand.setIndustry(industry);
        brand.setId(kkk); // 해당브랜드의 고유 id (ex UNIQLO 는 1번, SPAO는 4번)
        
        
    }

    
    private void feedbackWrite(){
        
    }
    private void reportRegister(){
        
    }
    private void reportRead(){
        
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
    // id 변환함수 만들어야함
    

}
