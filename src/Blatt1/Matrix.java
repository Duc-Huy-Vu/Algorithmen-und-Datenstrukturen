package Blatt1;

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    int[][] matrix;
    int zeile;
    int spalte;

    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 3);
        matrix.Init();
        matrix.Input();
        matrix.Print();
        Matrix matrix1 = new Matrix(3, 2);
        matrix1.Init();
        matrix1.Input();
        matrix.Mult(matrix1);
        matrix.Print();

    }

    public Matrix(int zeile, int spalte) {
        matrix = new int[zeile][spalte];
        this.zeile = zeile;
        this.spalte = spalte;
    }

    public void Init() {
        for (int i = 0; i < zeile; i++) {
            for (int j = 0; j < spalte; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void Print() {
        for (int i = 0; i < zeile; i++) {
            for (int j = 0; j < spalte; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void RandomFill() {
        Random random = new Random();
        for (int i = 0; i < zeile; i++) {
            for (int j = 0; j < spalte; j++) {
                matrix[i][j] = random.nextInt();
            }
        }
    }

    public void Mult(Matrix input) {
        if (this.spalte != input.zeile) {
            System.out.println("Matrizen koennen nicht miteinander multipliziert werden!");
            return;
        }
        Matrix result = new Matrix(this.zeile, input.spalte);
        int loops = input.spalte;
        int value = 0;
        for (int j = 0; j < zeile; j++) {
            for (int k = 0; k < input.spalte; k++) {
                for (int l = 0; l < input.zeile; l++) {
                    value += this.matrix[j][l] * input.matrix[l][k];
                }
                result.matrix[j][k] = value;
                value = 0;
            }
        }
        this.matrix = result.matrix;
        this.zeile= result.zeile;
        this.spalte= result.spalte;
    }

    public void Input() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < zeile; i++) {
            for (int j = 0; j < spalte; j++) {
                System.out.println("Bitte geben Sie die Zahl für die Matrix" + "[" + i + "]" + "[" + j + "]" + "ein:");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
    public void Add(Matrix input){
        if((this.spalte!= input.spalte) ||(this.zeile!=input.zeile)){
            System.out.println("Matrizen koennen nicht miteinander multipliziert werden!");
            return;
        }
        for (int i = 0; i < zeile; i++) {
            for (int j = 0; j < spalte; j++) {
                matrix[i][j] =  matrix[i][j]+input.matrix[i][j];
            }
        }
    }
}
