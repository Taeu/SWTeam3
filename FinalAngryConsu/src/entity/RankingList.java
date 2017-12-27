/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import control.XMLRankingManager;
import java.util.Collections;
import java.util.LinkedList;
import others.BCIComparator;

/**
 *
 * @author user
 */
public class RankingList {
    private LinkedList<Ranking> rankingListed;
    int fa_max1, f_max2, f_max3;
    int fo_max1, fo_max2, fo_max3;
    int ac_max1, ac_max2, ac_max3;
    int max1, max2, max3;
    public XMLRankingManager rankingManager = new XMLRankingManager();
    
    
    public int compareBCI(Ranking o1, Ranking o2) {
        int a = o1.getBCI();
        int b = o2.getBCI();
 
        // ascending order (descending order would be: name2.compareTo(name1))
        if( a>b) return a;
        return b;
        }

    //산업별로 scoring 하고, Ranking의 rank 들을 업데이트 시켜준다.
    private void scoring(){
        

// total
        
        Collections.sort(this.rankingListed,new BCIComparator());
        //industry = "fashion
        
        // industry = " acc
        
        
        // industry = " food
        
    }
    private void show(){
        
    }
}
