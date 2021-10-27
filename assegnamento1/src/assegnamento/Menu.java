package assegnamento;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
    private int scelta;
    //private Scanner myObj;
    private UserList UL;
    private int ids;
    private InputStreamReader isr;
    private BufferedReader br;

    public Menu(UserList userl){
        this.scelta=0;
//this.myObj = new Scanner(System.in);
        this.UL = userl;
        this.ids=0;
        this.isr = new InputStreamReader(System.in);
        this.br = new BufferedReader(this.isr);
    }

    public int FirstMenu(){
        int sc=0;
        try {
            System.out.println("1. Login");
            System.out.println("2. Create new account");
            System.out.println("3. Delete accaount");
            System.out.println("0. Exit");
            String s = this.br.readLine();
            sc = Integer.parseInt(s);
            return sc;
        }catch(IOException e){
            e.printStackTrace();
            return 0;
        }
    }
    public void FirstPage(){

        do{
            scelta=FirstMenu();
            switch (scelta){
                case 1: try {
                    System.out.println("Inserisci Email: ");
                    String mail = this.br.readLine();

                    this.UL.stamp();

                    System.out.println("Inserisci Password: ");
                    String psw=this.br.readLine();
                    System.out.println(this.UL.accessSystem(mail,

                            psw));

                }catch(IOException ex){
                    ex.printStackTrace();
                }

                    break;
                case 2: break;
                case 3: break;
            }
        }while (scelta>0);
    }

}
