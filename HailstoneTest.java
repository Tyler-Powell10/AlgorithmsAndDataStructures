/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package stacksandqueues;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Frank NKurunziza
 */
public class HailstoneTest {
    public static void main(String[] args) {
        ArrayList<Integer> hailList=new ArrayList<>();
        Scanner input=new Scanner(System.in);
        System.out.println("Input a number from 1 to 10000");
        System.out.println("--------------------------------");
        int hailNumber=input.nextInt();
        Hailstone hail=new Hailstone(hailNumber,hailList);
        System.out.println("HailStone List: "+hail.hailNumber+" Longest sequence: "+hail.hailNumber.size());
    }
}
