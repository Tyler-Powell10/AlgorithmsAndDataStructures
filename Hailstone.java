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
    int max=0;
    ArrayList<Integer> hailNumber=new ArrayList<>();
// then call a recursive method that creates and stores in the ArrayList the hailstone sequence until the number 1
    public Hailstone(int num,ArrayList<Integer> hail) {
        this.num = num;
        this.hailNumber=hail;
        
        if(num<1){
            num=1;
            max=num;
            hailNumber.add(num);
        }
        else{
            hailNumber.add(num);
            recurr(num);
        }
    }
    public void recurr(int start){
        if(start<=1){
            return;
        }else{
            if(start%2==0){
                num=start/2;
                hailNumber.add(num);
                if(num>max){
                    max=num;
                }
                recurr(num);
            }else{
                num=(start*3)+1;
                hailNumber.add(num);
                if(num>max){
                    max=num;
                }
                recurr(num);
            }
        }
    }
    
    
    
}
