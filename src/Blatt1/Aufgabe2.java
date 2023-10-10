package Blatt1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Aufgabe2 {
    public static void main(String[] args) {
        List<Integer>result=sieb(100000);
        System.out.println(result);
    }

    private static List<Integer> sieb(int schranke){
        Set<Integer> set=new HashSet<>();
        List<Integer>list=new ArrayList<>();
        for(int i =2;i<=schranke;i++){
            if(!set.contains(i)){
                list.add(i);
                int temp=0;
                int counter =1;
                while(temp<schranke){
                    temp=counter*i;
                    set.add(temp);
                    counter++;
                }
            }
        }
        return list;
    }
}
