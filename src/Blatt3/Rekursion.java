package Blatt3;

public class Rekursion {
    public static int f(int n, int m){

        if(n==0){
            return m +1;
        }
        if(m==0 && n>=1){
            return f(n-1,1);
        }

        return f(n-1,f(n,m-1));
    }

    public static void main(String[] args) {
        int result = f(1,1);
        System.out.println(result);
    }

}
