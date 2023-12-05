package Blatt4;

import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static void main(String[] args) {
        int[]number ={-3,8,7,10,11,16,2,6};
        Sort sort = new Sort();
        //sort.InsertionSort(number);
       // sort.BubbleSort(number);
        sort.Quicksort(number,0,7);
        System.out.println(Arrays.toString(number));

        System.out.println(sort.myAlogrithm(number, 9));
    }

    public void InsertionSort(int []array){
        int i,j,key;

        for(j=1;j<array.length;j++){

            key = array[j];
            i=j-1;
            while(i>=0 && array[i]<key){
                array[i+1]=array[i];
                i--;
            }
            array[i+1]=key;
        }
    }

    public void BubbleSort(int []array){
        for(int i=0;i<array.length;i++){
            for(int j =1;j<array.length;j++){
                if(array[j-1]>array[j]){
                    int h= array[j-1];
                    array[j-1]=array[j];
                    array[j]=h;
                }
            }
        }
    }
    public void SelectionSort(int []array){
        int i,j,max;
        for(i= array.length-1; i>0;i--){
            max=i;
            for (j = i; j>=0;j--){
                if(array[j]>array[max]){
                    max=j;
                }
            }
            int h = array[max];
            array[max]=array[i];
            array[i]=h;
        }
    }

    private void swap(int []a,int position1,int postion2){
        int temp = a[postion2];
        a[postion2]=a[position1];
        a[position1]=temp;
    }
    private int randomNumber (int first, int last){
        Random rand = new Random();
        int pivot = rand.nextInt(first,last);
        return pivot;
    }
    private int PreparePartition(int []a, int first,int last, int p){
        int random = randomNumber(first,last);
       swap(a,first,random);
        int pivot=a[first];
        p=first-1;
        for(int i=first; i<=last;i++){
            if(a[i]<=pivot){
                p++;
                swap(a,i,p);
            }
        }
        swap(a,first,p);
        return p;
    }
    public void Quicksort(int[]a, int first,int last){
        int part = 0;
        if(first<last){
            int partionNumber=PreparePartition(a,first,last,part);
            Quicksort(a,first,partionNumber-1);
            Quicksort(a,partionNumber+1,last);
        }
    }
    // Aufgabe 3
    public boolean myAlogrithm (int []a,int s){
        int stop =((a.length/2))+1;
        int temp;
        int l=a.length-1;
        int f=0;
        for(int i=0;i<=stop;i++){
            temp=a[f]+a[l];
            if (temp>s){
                l--;
            } else if (temp<s) {
                f++;
            }else {
                return true;
            }
        }
        return false;
    }
    //Insert Method for Rekursive Insertion Sort
    void Insert(int[] a,int first, int last){
        int key = a[last];
        while(first<last && a[last-1]>key){
            a[last] = a[last-1];
            last--;
        }
        a[last] = key;
    }

    //Rekursive Insertion Sort
    void InsertionSortRek(int[] a,int first, int last){
        if(first<last){
            InsertionSortRek(a,first,last-1);		//Sort partialfield
            Insert(a,first,last);					//Insert last+1
        }
    }


}
