/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stacksandqueues;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Frank NKurunziza
 */
public class HailstoneTest {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        Scanner input=new Scanner(System.in);
        System.out.println("Input a number from 1 to 10000");
        System.out.println("--------------------------------");
        int hailNumber=input.nextInt();
        
        for(int i=1;i<=hailNumber;i++){   
            ArrayList<Integer> hailList=new ArrayList<>();
//            System.out.println("i: "+i);
            Hailstone hail=new Hailstone(i,hailList);
            list.add(hailList);
//            System.out.println("HailStone List: "+hail.getHailstoneSeq()+" Longest sequence: "+hail.hailNumber.size());
        }
        int longSeq=0;
        int max=0;
        
        for(int i=0;i<list.size();i++){
            ArrayList<Integer> currSeq=list.get(i);
            if(currSeq.size() > max){
                longSeq=i;
                max=currSeq.size();
            }
        }
            System.out.println("Longest sequence was "+max+" starting with : "+list.get(longSeq).get(0));
            for(int i=0;i<list.get(longSeq).size();i++){
                System.out.println(""+list.get(longSeq).get(i));
            }
    }
}
