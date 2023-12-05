package Blatt6;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[]number ={2,8,7,10,11,16,2,6};
        CountSort countSort = new CountSort();
        int [] erg=countSort.sort(number);
        System.out.println(Arrays.toString(erg));
    }
    public int[] sort(int[]a){
        int i =0, j=1;
        int b[]=new int[100];

        for (i=0;i<b.length;i++){
            b[i]=0;
        }
        for(i=0;i<a.length;i++){
            b[a[i]]++;
        }
        for(i=1;i<=b.length-1;i++){
            b[i]=b[i]+b[i-1];
        }
        int erg[] = new int[a.length];
        for(i=0;i<a.length;i++){
            erg[b[a[i]]-1]=a[i];
            b[a[i]]--;
        }
        return erg;
    }
}
