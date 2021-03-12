package com.company;
import java.util.Random;
import java.util.Scanner;
import java. util. Date;

public class Main {

    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        int cont =0;
        List data = new List();
        String p;
        boolean pared = false;
        do{
            p = l.nextLine();
            data.add(p);
            if(cont != 0){
                for(int j = 0 ; j<p.length();j++){
                    char k = p.charAt(j);
                    if(k =='0' || k=='m' || k=='e'){
                        pared = false;
                        break;
                    }else if (k=='1') {
                        pared = true;
                    }
                }
            }cont++;
        }while (pared != true);
        int cont2 = 0;
        for(ListNode u:data){
            Object xd = u.getObject();
        }
    }
}