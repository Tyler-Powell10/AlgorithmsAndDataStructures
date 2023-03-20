/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandqueues;

import java.util.ArrayList;

/**
 *
 * @author Frank NKurunziza
 */
public class Hailstone {
    int num;
    ArrayList<Integer> hailNumber=new ArrayList<>();
// then call a recursive method that creates and stores in the ArrayList the hailstone sequence until the number 1
    public Hailstone(int num,ArrayList<Integer> hail) {
        this.num = num;
        this.hailNumber=hail;
        
        if(num<1){
            num=1;
//            hailNumber.add(num);
        }
        else{
//            hailNumber.add(num);
            recurr(num);
        }
    }
    public void recurr(int start){
        if(start<=1){
            return;
        }else{
            if(start%2==0){
                int eNum=start/2;
                hailNumber.add(eNum);
                recurr(eNum);
            }else{
                int oNum=(start*3)+1;
                hailNumber.add(oNum);
                recurr(oNum);
            }
        }
    }
    
    
    
}
