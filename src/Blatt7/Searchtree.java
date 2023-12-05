package Blatt7;

public class Searchtree {

    Treeelement root;

    public static void main(String[] args) {
        Searchtree tree = new Searchtree();
        tree.Insert(6);
        tree.Insert(8);
        tree.Insert(3);
        tree.Insert(1);
        tree.Insert(7);
        tree.Insert(9);
        tree.Print();
    }
    private void Insert(Treeelement currentRoot, Treeelement element) {
        if (element.getValue() <= currentRoot.getValue()) {
            if (currentRoot.getLeft() == null) {
                currentRoot.setLeft(element);
            } else {
                Insert(currentRoot.getLeft(), element);
            }
        } else {
            if (currentRoot.getRight() == null) {
                currentRoot.setRight(element);
            } else {
                Insert(currentRoot.getRight(), element);
            }
        }
    }

    public void Insert(int value) {
        Treeelement element = new Treeelement();
        element.setValue(value);
        element.setRight(null);
        element.setLeft(null);
        if (root == null) {
            root = element;
        } else {
            Insert(root, element);
        }
    }

    public boolean Contains(int value) {
        Treeelement element = root;
        while (element != null) {
            if (value == root.value) {
                return true;
            }
            if (value <= element.getValue()) {
                element = element.getLeft();
            } else {
                element = element.getRight();
            }
        }
        return false;
    }
    private void Print(Treeelement root){
        if(root!=null){
            System.out.print("(");
            Print(root.getLeft());
            System.out.print(","+root.getValue()+",");
            Print(root.getRight());
            System.out.print(")");
        }else{
            System.out.print("n");
        }
    }
    public void Print(){
        Print(root);
    }

}

class Treeelement {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Treeelement getRight() {
        return right;
    }

    public void setRight(Treeelement right) {
        this.right = right;
    }

    public Treeelement getLeft() {
        return left;
    }

    public void setLeft(Treeelement left) {
        this.left = left;
    }

    int value;
    Treeelement right;
    Treeelement left;
}