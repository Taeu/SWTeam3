/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package others;
import entity.Ranking;
 import java.util.*;  
 
/**
 *
 * @author user
 */
public class BCIComparator implements Comparator<Ranking>{   
  
    public int compare(Ranking r1,Ranking r2){  
        if (r1.getBCI()> r2.getBCI()) return 1;
        else return -1;  
    }  
}
