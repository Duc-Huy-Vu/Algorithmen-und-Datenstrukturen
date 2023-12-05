package Blatt6;

import java.util.List;
import java.util.Random;

public class DoppelVerketteListe {

    ListElement startElement= null;
    public DoppelVerketteListe(){

    }

    public static void main(String[] args) {
        DoppelVerketteListe list= new DoppelVerketteListe();
        list.addLast(5);
        list.addLast(35);
        list.addLast(6);
        list.addLast(2);
        list.addLast(9);
        list.addLast(67);
        list.addLast(7);
      // list.swap(list,1,4);
      //  list.insertBefore(0,10);
      list.Quicksort(list,0,6);
        list.showList();


        System.out.println(list.getElment(6).getNumber());
        System.out.println(list.getElment(2).getNumber());

        ListElement test = new ListElement(2);
        ListElement temp1 = test;
        if(test.equals(temp1)){
            System.out.println("true");
        }



    }
    public void addLast(int value){

        ListElement newElem = new ListElement(value);
        ListElement lastElem= getLastElement();
        if(lastElem==null){
            startElement=newElem;
            startElement.setPositionNumber(0);
            return;
        }
        int newNumber = lastElem.getPositionNumber();
        newElem.setPositionNumber(++newNumber);
        lastElem.setNext(newElem);
        newElem.setPrev(lastElem);
    }
    public void insertBefore(int position, int number){
        ListElement newElement= new ListElement(number);
        ListElement pointer;
        pointer= startElement;
        if(position==0){
            ListElement temp = startElement.getNext();
            startElement = newElement;
            startElement.setNext(temp);
            startElement.setPrev(null);
            temp.setPrev(startElement);
            return;
        }
        int counter=position;
        for(int i=0;i<counter;i++){
            pointer=pointer.getNext();
        }
        pointer.getPrev().setNext(newElement);
        pointer.setPrev(newElement);
        newElement.setNext(pointer);
        newElement.setPrev(pointer.getPrev());




    }
    public void delete(int insert){
        ListElement le = startElement;
        if(le.getNumber()==insert){
            if(le.getNext()!=null){
                startElement=le.getNext();
                startElement.setPrev(null);

                return;
            }
        }
        while (le.getNext() != null && le.getNumber()!=insert){
            if(le.getNext().getNumber()==insert){
                if(le.getNext().getNext()!=null){
                    le.setNext(le.getNext().getNext());
                    le.getNext().setPrev(le);
                    return;
                }else{
                    le.setNext(null);
                    break;
                }
            }
            le = le.getNext();
        }
    }
    public ListElement getElment(int number){
        ListElement element = startElement;
        if(startElement==null){
            return null;
        }
        for (int i =0; i<number;i++){
            if(element.getNext()==null){
                return null;
            }
            element =element.getNext();
        }
        return element;
    }
    public void showList(){
        ListElement le = startElement;
        if(startElement==null){
            System.out.println("Empty List!");
        }else if(startElement.getNext()==null){
            System.out.println(startElement.getNumber());
            return;
        }
        while(le.getNext()!=null){
            System.out.println( le.getNumber()+" Position:"+le.getPositionNumber());
            le=le.getNext();
        }
        System.out.println( le.getNumber()+" Position:"+le.getPositionNumber());

    }
    private ListElement getLastElement(){
        ListElement le= startElement;
        if(startElement==null){
            return startElement;
        }

        while(le.getNext()!=null){
            le = le.getNext();
        }
        return le;

    }
   private void swap(DoppelVerketteListe liste,int position1,int position2){
        ListElement element;
       ListElement temp = getElment(position2);
       ListElement temp2= getElment(position1);
       int number2=temp.getNumber();
       temp.setNumber(temp2.getNumber());
       temp2.setNumber(number2);



       

    }

    private int PreparePartition(DoppelVerketteListe liste, int first,int last, int p){
        int pivot=liste.getElment(first).getNumber();
        p=first-1;
        for(int i=first; i<=last;i++){
            if(liste.getElment(i).getNumber()<=pivot){
                p++;
                swap(liste,i,p);
                showList();
                System.out.println();
            }
        }
        swap(liste,first,p);
        return p;
    }
    public void Quicksort(DoppelVerketteListe liste, int first,int last){
        int part = 0;
        if(first<last){
            int partionNumber=PreparePartition(liste,first,last,part);
            Quicksort(liste,first,partionNumber-1);
            Quicksort(liste,partionNumber+1,last);
        }
    }
}

class ListElement{


    int positionNumber;

    public void setNumber(int number) {
        this.number = number;
    }

    private int number;
    ListElement prev;

    public ListElement getPrev() {
        return prev;
    }

    public void setPrev(ListElement prev) {
        this.prev = prev;
    }

    public ListElement getNext() {
        return next;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }

    ListElement next;

    public ListElement(int number){
        this.number = number;
        prev=null;
        next=null;
    }
    public int getNumber(){
        return this.number;
    }
    public int getPositionNumber() {
        return positionNumber;
    }

    public void setPositionNumber(int positionNumber) {
        this.positionNumber = positionNumber;
    }


}