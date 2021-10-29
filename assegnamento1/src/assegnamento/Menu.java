package assegnamento;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;


public class Menu {
    private int scelta;
    //private Scanner myObj;
    private UserList UL;
    private ProductList PL;
    private int ids;
    private InputStreamReader isr;
    private BufferedReader br;

    public Menu(UserList userl, ProductList productl){
        this.scelta=0;
        this.UL = userl;
        this.PL = productl;
        this.ids=0;
        this.isr = new InputStreamReader(System.in);
        this.br = new BufferedReader(this.isr);
    }

    public int FirstMenu(){
        int sc=0;
        try {
            System.out.println("1. Login");
            System.out.println("2. Create new account");
            System.out.println("3. Delete account");
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
                    System.out.println(this.UL.accessSystem(mail, psw));
                    SecondPage();

                }catch(IOException ex){
                    ex.printStackTrace();
                }

                    break;
                case 2: try {
                    System.out.println("Inserisci nome: ");
                    String nome = this.br.readLine();

                    System.out.println("Inserisci cognome: ");
                    String cognome=this.br.readLine();

                    System.out.println("Inserisci email: ");
                    String email = this.br.readLine();

                    System.out.println("Inserisci password: ");
                    String psw=this.br.readLine();

                    checkNewAccount(nome, cognome, email, psw);

                }catch(IOException ex){
                    ex.printStackTrace();
                }
                    break;
                case 3: break;

                case 0: break;

                default:
                    System.out.println("Scelta non corretta, riprova!");
                    break;
            }
        }while (scelta != 0);
    }


    public int SecondMenu(){
        int sc=0;
        try {
            System.out.println("1. Cerca prodotti");
            System.out.println("2. Acquista prodotti");
            System.out.println("0. Exit");
            String s = this.br.readLine();
            sc = Integer.parseInt(s);
            return sc;
        }catch(IOException e){
            e.printStackTrace();
            return 0;
        }
    }


    public void SecondPage() throws IOException {

        do{
            scelta = SecondMenu();
            switch (scelta){

                case 1:
                    SearchProductPage();
                    break;

                case 2: break;
                case 0: break;
                default:
                    System.out.println("Scelta non corretta, riprova!");
                    break;
            }
        }while (scelta != 0);
    }


    public int SearchProductMenu() {

        int sc = 0;
        try {
            System.out.println("Cerca prodotti per: ");
            System.out.println("1. Nome prodotto");
            System.out.println("2. Nome produttore");
            System.out.println("3. Prezzo minimo");
            System.out.println("4. Prezzo massimo");
            String s = this.br.readLine();
            sc = Integer.parseInt(s);
            return sc;
        }catch(IOException e){
            e.printStackTrace();
            return 0;
        }
    }


    public void SearchProductPage() throws IOException {

        Product p = new Product();
        do{
            scelta = SearchProductMenu();
            switch (scelta){

                case 1:
                    System.out.println("Inserisci il nome prodotto da cercare: ");
                    String s1 = this.br.readLine();
                    for(Product pp : this.PL.getProductByNameProduct(s1)){
                        System.out.println(pp.getCode()+" "+pp.getName()+" "+pp.getNameproductor()+" €"+pp.getPrice());
                    }
                    break;

                case 2:
                    System.out.println("Inserisci il nome produttore da cercare: ");
                    String s2 = this.br.readLine();
                    for(Product pp : this.PL.getProductByNameProductor(s2)){
                        System.out.println(pp.getCode()+" "+pp.getName()+" "+pp.getNameproductor()+" €"+pp.getPrice());
                    }
                    break;

                case 3:
                    p = this.PL.getProductMinPrice();
                    System.out.println(p.getCode()+" "+p.getName()+" "+p.getNameproductor()+" €"+p.getPrice());
                    break;

                case 4:
                    p = this.PL.getProductMaxPrice();
                    System.out.println(p.getCode()+" "+p.getName()+" "+p.getNameproductor()+" €"+p.getPrice());
                    break;

                case 0: break;

                default:
                    System.out.println("Scelta non corretta, riprova!");
                    break;
            }
        }while (scelta != 0);
    }


    public boolean checkNewAccount(String n, String c, String e, String p){

        if(Objects.equals(n, "") && Objects.equals(c, "") && Objects.equals(e, "") && Objects.equals(p, "")){
            System.out.println("Inserisci tutti i campi!");
            return false;
        }

        User u = new User(this.UL.listSize()+1, n, c, e, p, false);

        this.UL.addUser(u);

        return true;
    }

}
