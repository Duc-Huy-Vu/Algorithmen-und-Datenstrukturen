package Blatt9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkipList {
    Element head;
    Element tail;
    Element remember;

    private final int NEG_INFINITY = Integer.MIN_VALUE;
    private final int MAX_INFINITY = Integer.MAX_VALUE;
    public static void main(String[] args) {
        SkipList list = new SkipList();
       list.insert(1);
       list.insert(32);
        list.show();
        int number;
        Random random = new Random(100);
   /* for(int i=0;i<100;i++){
        System.out.println(random.nextInt(2));
    }*/
    }

    public SkipList(){

        initSkipList();
    }
    private void initSkipList(){

        head=new Element();;
        head.setValue(NEG_INFINITY);

        tail =new Element();
        tail.setValue(MAX_INFINITY);
        head.setRight(tail);
        tail.setLeft(head);

        Element headElement = new Element();
        headElement.setValue(NEG_INFINITY);
        head.setAbove(headElement);
        Element lastElement = new Element();
        lastElement.setValue(MAX_INFINITY);
        tail.setAbove(lastElement);
        lastElement.setDown(tail);
        headElement.setDown(head);
        lastElement.setLeft(headElement);
        headElement.setRight(lastElement);
        head=headElement;
        tail=lastElement;
    }
    public void show(){
        Element thead= head;
        while(thead!=null) {
            Element current = thead;
            System.out.print("[");
            while (current.right.value !=MAX_INFINITY ){
                System.out.print(current.right.value);
                System.out.print(",");

                current=current.right;
            }
            System.out.println("]");
            thead=thead.getDown();
        }
    }
    public void insert(int number){


        Element node=search(number);

            int coin=-1;
            /// remember = node;
      //  while (flipCoin()==Coin.headCoin.ordinal()){
            do{


                Element element = new Element();

                element.setValue(number);
                Element nodeNext = node.getRight();
                nodeNext.setLeft(element);
                element.setRight(nodeNext);
                node.setRight(element);
                element.setLeft(node);
                remember=element;
                if (coin==Coin.tailCoin.ordinal()){
                    remember.setAbove(element);
                    element.setDown(remember);
                }

                coin = flipCoin();



                while(node.getAbove()==null || node.value!=NEG_INFINITY){
                    node=node.getLeft();
                }

                if (node.getValue()==NEG_INFINITY && coin==Coin.tailCoin.ordinal()){
                    Element headElement = new Element();
                    headElement.setValue(NEG_INFINITY);
                    head.setAbove(headElement);
                    Element lastElement = new Element();
                    lastElement.setValue(MAX_INFINITY);
                    tail.setAbove(lastElement);
                    lastElement.setDown(tail);
                    headElement.setDown(head);
                    lastElement.setLeft(headElement);
                    headElement.setRight(lastElement);
                    head=headElement;
                    tail=lastElement;
                }

                remember=element;

            }while(coin==Coin.tailCoin.ordinal());

        //}






    }
    private int flipCoin(){
        Random random = new Random();
        int number = random.nextInt(2);
        return number;

    }
    public Element search(int number){
        Element node = head;

        while (node.getDown()!=null){
            node = node.getDown();
            while(node.getRight().value<=number){
                node=node.getRight();
            }
        }
        return node;
    }

}
enum Coin{
    headCoin, tailCoin
}
class Element{

    int value;
    Element above =null;
    Element right=null ;
    Element down=null;

    public Element getLeft() {
        return left;
    }

    public void setLeft(Element left) {
        this.left = left;
    }

    Element left=null;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public Element getAbove() {
        return above;
    }

    public void setAbove(Element above) {
        this.above = above;
    }

    public Element getRight() {
        return right;
    }

    public void setRight(Element right) {
        this.right = right;
    }

    public Element getDown() {
        return down;
    }

    public void setDown(Element down) {
        this.down = down;
    }
}
