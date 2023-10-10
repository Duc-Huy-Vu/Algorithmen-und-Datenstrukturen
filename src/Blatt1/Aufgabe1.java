package Blatt1;

import java.util.ArrayList;
import java.util.List;

public class Aufgabe1 {

    public static void main(String[] args) {
        int result=ggT(22,4);
        System.out.println(result);
        int result2 = rekursivGgT(22,4);
        System.out.println(result2);
        int result3 = kgV(1000,440);
        System.out.println(result3);
        ausgabe(30,40);
    }
    private static int ggT(int number1, int number2){
        int a = number1;
        int b=number2;
        int r =0;

        do{
            r=a%b;
            a=b;
            b=r;

        }while(r!=0);

        return a;
    }
    private static int rekursivGgT(int a,int b){
        int r = 0;
        r=a%b;
        a=b;
        b=r;
        if(r==0){
            return a;
        }
        return rekursivGgT(a,b);
    }
    private static int kgV(int a,int b){
      //  int result =0;
        int temp = 0;
        List<Integer>list= new ArrayList<>();
        for(int i =1; i<=b;i++){
            temp= a*i;
            list.add(temp);
        }
        for(int j =0;j<=a;j++){
            temp=b*j;
            if(list.contains(temp)){
                return temp;
            }
        }
        return temp;
    }
    private static void ausgabe(int a, int b){
        int value1 = 0;
        int value2 =0;
        int value3=0;
        for(int i=a;i<=b;i++){
            value1=ggT(a,i);
            System.out.println("GGT: "+value1);
            value2=kgV(a,i);
            System.out.println("KGT: "+value2);
            value3=value1*value2;
            System.out.println("result: "+value3);
        }
    }
}
