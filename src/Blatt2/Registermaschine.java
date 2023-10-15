package Blatt2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Registermaschine {
public List<List<String>>commands;

public int address[];
public int pc=0;
public int akkumulator;

    public static void main(String[] args) {
        Registermaschine registermaschine= new Registermaschine("commands.txt");
        System.out.println(registermaschine.commands.toString());
    }
    public Registermaschine(String text) {
        commands= new ArrayList<>();
        address=new int [5000];
        try {

            Scanner scanner = new Scanner(new File(text));
            while(scanner.hasNextLine()){
                List<String>commandsList=cutString(scanner.nextLine());
                commands.add(commandsList);
            }
            scanner.close();
            execution();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    private List<String> cutString(String input){
        List<String> temp = new ArrayList<>();
        String[]modified = input.split(" ");
        temp = Arrays.asList(modified);
        return temp;
    }
    private void execution(){
        String current = commands.get(pc).get(0);

        while (!current.equals("HLT")){
            if(current.equals("LDK")){
                akkumulator=Integer.parseInt(commands.get(pc).get(1));
                //address[akkumulator]=;
                pc++;
            }else if(current.equals("STA")){
                address[Integer.parseInt(commands.get(pc).get(1))]=akkumulator;
                pc++;
            }else if(current.equals("INP")){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Bitte geben Sie die gewuenschte Zahl ein:");
                address[Integer.parseInt(commands.get(pc).get(1))]=scanner.nextInt();
                scanner.close();
                pc++;
            }else if(current.equals("LDA")){
                akkumulator=address[Integer.parseInt(commands.get(pc).get(1))];
                pc++;
            }else if(current.equals("JEZ")){
                if(akkumulator==0){
                    pc=13;
                }else{
                    pc++;
                }
            }else if(current.equals("ADD")){
                akkumulator=akkumulator+address[Integer.parseInt(commands.get(pc).get(1))];
                pc++;
            }else if(current.equals("SUB")){
                akkumulator=akkumulator-address[Integer.parseInt(commands.get(pc).get(1))];
                pc++;
            }else if(current.equals("JMP")){
                pc= Integer.parseInt(commands.get(pc).get(1));

            }else if(current.equals("OUT")){
                System.out.println("Die Berechnung lautet"+address[Integer.parseInt(commands.get(pc).get(1))]);
                pc++;
            }
            current=commands.get(pc).get(0);
        }
    }
}
