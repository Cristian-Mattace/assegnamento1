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

    public int firstMenu(){
        int sc=0;
        try {
            System.out.println("1. Login");
            System.out.println("2. Create new account");
            System.out.println("0. Exit");
            String s = this.br.readLine();
            sc = Integer.parseInt(s);
            return sc;
        }catch(IOException e){
            e.printStackTrace();
            return 0;
        }
    }

    public void firstPage(){

        do{
            scelta=firstMenu();
            switch (scelta){
                case 1: try {
                    System.out.println("Insert Email: ");
                    String mail = this.br.readLine();

                    System.out.println("Insert Password: ");
                    String psw=this.br.readLine();
                    int idUser = 0;
                    idUser = this.UL.accessSystem(mail, psw);
                    if(idUser > 0) checkUser(idUser);

                    }catch(IOException ex){
                        ex.printStackTrace();
                    }

                    break;

                case 2: try {
                    System.out.println("Insert nome: ");
                    String nome = this.br.readLine();

                    System.out.println("Insert cognome: ");
                    String cognome=this.br.readLine();

                    System.out.println("Insert email: ");
                    String email = this.br.readLine();

                    System.out.println("Insert password: ");
                    String psw=this.br.readLine();

                    checkNewAccount(nome, cognome, email, psw);

                }catch(IOException ex){
                    ex.printStackTrace();
                }
                    break;

                case 0: break;

                default:
                    System.out.println("Incorrect choise, try again!");
                    break;
            }
        }while (scelta != 0);
    }

    public void checkUser(int ids) throws IOException {
        if(ids==1){
            System.out.println("AMMINISTRATORE");
        }
        for(User u : this.UL.getUsers()){

            if(u.getId() == ids){
                if(u.getEmployee().equals(true)){

                    secondPageEmployee();

                }else
                    secondPageClient();
            }

        }
    }

    public int secondMenuEmployee(){
        int sc=0;
        try {
            System.out.println("1. List product");
            System.out.println("2. Add quantity");
            System.out.println("0. Exit");
            String s = this.br.readLine();
            sc = Integer.parseInt(s);
            return sc;
        }catch(IOException e){
            e.printStackTrace();
            return 0;
        }
    }

    public void secondPageEmployee() throws IOException {

        do{
            scelta = secondMenuEmployee();
            switch (scelta){

                case 1:
                    this.PL.stamp();
                    break;

                case 2:
                    addQuantityToProduct();
                    break;
                case 0: break;
                default:
                    System.out.println("Incorrect choise, try again!");
                    break;
            }
        }while (scelta != 0);
    }

    public int secondMenuClient(){
        int sc=0;
        try {
            System.out.println("1. Search product");
            System.out.println("2. Buy products");
            System.out.println("0. Exit");
            String s = this.br.readLine();
            sc = Integer.parseInt(s);
            return sc;
        }catch(IOException e){
            e.printStackTrace();
            return 0;
        }
    }


    public void secondPageClient() throws IOException {

        do{
            scelta = secondMenuClient();
            switch (scelta){

                case 1:
                    searchProductPage();
                    break;

                case 2:
                    productPurchase();
                    break;
                case 0: break;
                default:
                    System.out.println("Incorrect choise, try again!");
                    break;
            }
        }while (scelta != 0);
    }


    public int searchProductMenu() {

        int sc = 0;
        try {
            System.out.println("Search product by: ");
            System.out.println("1. Product name");
            System.out.println("2. Productor name");
            System.out.println("3. Min price");
            System.out.println("4. Max price");
            String s = this.br.readLine();
            sc = Integer.parseInt(s);
            return sc;
        }catch(IOException e){
            e.printStackTrace();
            return 0;
        }
    }


    public void searchProductPage() throws IOException {

        Product p = new Product();
        do{
            scelta = searchProductMenu();
            switch (scelta){

                case 1:
                    System.out.println("Enter the product name to search: ");
                    String s1 = this.br.readLine();
                    for(Product pp : this.PL.getProductByNameProduct(s1)){
                        System.out.println(pp.getCode()+" "+pp.getName()+" "+pp.getNameproductor()+" €"+pp.getPrice());
                    }
                    break;

                case 2:
                    System.out.println("Enter the productor name to search: ");
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
                    System.out.println("Incorrect choise, try again!");
                    break;
            }
        }while (scelta != 0);
    }


    public void productPurchase() throws IOException {
        System.out.println("Enter the name product to buy: ");
        String name = this.br.readLine();
        System.out.println("Enter the quantity: ");
        String quantity = this.br.readLine();
        int q = Integer.parseInt(quantity);

        if(Objects.equals(name, "") && Objects.equals(q, "")){
            System.out.println("Enter all fields!");
        }
        else{
            Product p = this.PL.getProductByNameProduct(name).get(0);
            if(p.getQuantity() < q) {
                System.out.println("Quantity too big!");
            }
            else{
                p.acquisto(q);
                System.out.println("Great purchase!");
            }
        }

    }


    public boolean checkNewAccount(String n, String c, String e, String p){

        if(Objects.equals(n, "") || Objects.equals(c, "") || Objects.equals(e, "") || Objects.equals(p, "")){
            System.out.println("Enter all fields!");
            return false;
        }

        User u = new User(this.UL.listSize()+1, n, c, e, p, false);

        this.UL.addUser(u);

        return true;
    }

    public void addQuantityToProduct() throws IOException {
        System.out.println("Enter the ID product: ");
        String i = this.br.readLine();
        int ID = Integer.parseInt(i);
        System.out.println("Enter the quantity: ");
        String quantity = this.br.readLine();
        int q = Integer.parseInt(quantity);

        if(Objects.equals(ID, "") && Objects.equals(q, "")){
            System.out.println("Enter all fields!");
        }
        else{
            Product p = this.PL.getProductById(ID);
            if(p == null) {
                System.out.println("Product doesn't exist!");
            }
            else{
                p.addQuantity(q);
                System.out.println("Quantity update!");
            }
        }
    }




}
