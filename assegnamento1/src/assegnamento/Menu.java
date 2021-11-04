package assegnamento;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * The class {@code Menu} provides an implementation of a
 * models of menu
 *
 **/
public class Menu {
    private String scelta;
    private final UserList UL;
    private final ProductList PL;
    private int ids;
    private InputStreamReader isr;
    private BufferedReader br;

    /**
     * Class constructor
     * @param userl the list of users
     * @param productl the list of products
     */
    public Menu(UserList userl, ProductList productl){
        this.scelta="";
        this.UL = userl;
        this.PL = productl;
        this.ids=0;
        this.isr = new InputStreamReader(System.in);
        this.br = new BufferedReader(this.isr);
    }

    /**
     * @return the choice made by the user/client/ceo
     */
    public String firstMenu(){
        try {
            System.out.println("1. Login");
            System.out.println("2. Create new account");
            System.out.println("0. Exit");
            return this.br.readLine();
        }catch(Exception e){
            System.out.println("ERRORE: " + e);
            return null;
        }
    }

    /**
     * the first menu that appears
     */
    public void firstPage(){

        do{
            scelta=firstMenu();
            switch (scelta){
                case "1":
                    try {
                        System.out.println("Insert Email: ");
                        String mail = this.br.readLine();

                        System.out.println("Insert Password: ");
                        String psw=this.br.readLine();
                        int idUser = 0;
                        idUser = this.UL.accessSystem(mail, psw);
                        if(idUser > 0) checkUser(idUser);
                    }
                    catch(Exception e){
                        System.out.println("ERRORE: " + e);
                    }
                    break;

                case "2": checkNewAccount(false);
                    break;

                case "0": break;

                default:
                    System.out.println("Incorrect choise, try again!");
                    break;
            }
        }while (!scelta.equals("0"));
    }


    /**
     * @param ids the user's id
     *            the fucntion check if the users
     *            that login the program is
     *            1-> CEO
     *            2->Client
     *            3->Employee
     */
    public void checkUser(int ids){
        try {
            if (ids == 1) {
                System.out.println("AMMINISTRATORE");
                secondPageCeo();
            } else {
                for (User u : this.UL.getUsers()) {

                    if (u.getId() == ids) {
                        if (u.getEmployee().equals(true)) {
                            secondPageEmployee();
                        } else
                            secondPageClient();
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("ERRORE: " + e);
        }
    }


    /**
     * @return the choice made by the employee after login
     */
    public String secondMenuEmployee(){
        try {
            System.out.println("1. List product");
            System.out.println("2. Add quantity");
            System.out.println("0. Exit");
            return this.br.readLine();
        }catch(Exception e){
            System.out.println("ERRORE: " + e);
            return null;
        }
    }


    /**
     * the menu that appears to employees after login
     */
    public void secondPageEmployee(){
        try {
            do {
                scelta = secondMenuEmployee();
                switch (scelta) {

                    case "1":
                        this.PL.stamp();
                        break;

                    case "2":
                        addQuantityToProduct();
                        break;
                    case "0":
                        firstPage();
                        break;
                    default:
                        System.out.println("Incorrect choise, try again!");
                        break;
                }
            } while (!scelta.equals("0"));
        }
        catch(Exception e){
            System.out.println("ERRORE: " + e);
        }
    }


    /**
     * @return the choice made by the client after login
     */
    public String secondMenuClient(){
        try {
            System.out.println("1. Search product");
            System.out.println("2. Buy products");
            System.out.println("3. List product");
            System.out.println("0. Exit");
            return this.br.readLine();
        }catch(Exception e){
            System.out.println("ERRORE: " + e);
            return null;
        }
    }


    /**
     * the menu that appears to client after login
     */
    public void secondPageClient(){
        try {
            do {
                scelta = secondMenuClient();
                switch (scelta) {

                    case "1":
                        searchProductPage();
                        break;

                    case "2":
                        productPurchase();
                        break;

                    case "3":
                        this.PL.stamp();
                        break;

                    case "0":
                        firstPage();
                        break;

                    default:
                        System.out.println("Incorrect choise, try again!");
                        break;
                }
            } while (!scelta.equals("0"));
        }
        catch(Exception e){
            System.out.println("ERRORE: " + e);
        }
    }


    /**
     * @return the choice made by the client after Search product
     */
    public String searchProductMenu() {

        try {
            System.out.println("Search product by: ");
            System.out.println("1. Product name");
            System.out.println("2. Productor name");
            System.out.println("3. Min price");
            System.out.println("4. Max price");
            System.out.println("0. Exit");
            return this.br.readLine();
        }catch(Exception e){
            System.out.println("ERRORE: " + e);
            return null;
        }
    }


    /**
     *  the menu that appears to client after Search product
     */
    public void searchProductPage(){
        try {
            Product p = new Product();
            do {
                scelta = searchProductMenu();
                switch (scelta) {

                    case "1":
                        System.out.println("Enter the product name to search: ");
                        String s1 = this.br.readLine();
                        for (Product pp : this.PL.getProductByNameProduct(s1)) {
                            System.out.println(pp.getCode() + " " + pp.getName() + " " + pp.getNameproductor() + " €" + pp.getPrice());
                        }
                        break;

                    case "2":
                        System.out.println("Enter the productor name to search: ");
                        String s2 = this.br.readLine();
                        for (Product pp : this.PL.getProductByNameProductor(s2)) {
                            System.out.println(pp.getCode() + " " + pp.getName() + " " + pp.getNameproductor() + " €" + pp.getPrice());
                        }
                        break;

                    case "3":
                        p = this.PL.getProductMinPrice();
                        System.out.println(p.getCode() + " " + p.getName() + " " + p.getNameproductor() + " €" + p.getPrice());
                        break;

                    case "4":
                        p = this.PL.getProductMaxPrice();
                        System.out.println(p.getCode() + " " + p.getName() + " " + p.getNameproductor() + " €" + p.getPrice());
                        break;

                    case "0":
                        secondPageClient();
                        break;

                    default:
                        System.out.println("Incorrect choise, try again!");
                        break;
                }
            } while (!scelta.equals("0"));
        }
        catch(Exception e){
            System.out.println("ERRORE: " + e);
        }
    }


    /**
     * the method of controll of product purchase
     */
    public void productPurchase(){
        try {
            System.out.println("Enter the ID product to buy: ");
            String ID = this.br.readLine();

            if (Objects.equals(ID, "")) {
                System.out.println("Enter the ID!!");
            } else {

                Product prod = this.PL.getProductById(Integer.parseInt(ID));

                if (prod == null) secondPageClient();

                System.out.println("Enter the quantity: ");
                String quantity = this.br.readLine();
                if (Objects.equals(quantity, "") || Integer.parseInt(quantity) < 1) {
                    System.out.println("Enter correct quantity!!");
                } else {
                    int q = Integer.parseInt(quantity);

                    if (prod.getQuantity() < q) {
                        System.out.println("Quantity too big!");
                    } else {
                        prod.acquisto(q);
                        System.out.println("Great purchase!");
                    }
                }
            }

        }
        catch(Exception e){
            System.out.println("ERRORE: " + e);
        }


    }


    /**
     * @param emlpoyee check if the user si an employee
     *                 the metod checks the creations of new accounts
     */
    public void checkNewAccount(boolean emlpoyee){

        try {

            System.out.println("Insert first name: ");
            String nome = this.br.readLine();

            System.out.println("Insert last name: ");
            String cognome=this.br.readLine();

            System.out.println("Insert email: ");
            String email = this.br.readLine();

            System.out.println("Insert password: ");
            String psw=this.br.readLine();

            if(Objects.equals(nome, "") || Objects.equals(cognome, "") || Objects.equals(email, "") || Objects.equals(psw, "")){
                System.out.println("Enter all fields!");
            }
            else {
                User u = new User(this.UL.listSize() + 1, nome, cognome, email, psw, emlpoyee);
                this.UL.addUser(u);
            }
        }catch(Exception e){
            System.out.println("ERRORE: " + e);
        }
    }



    public void checkNewProduct(){

        try {
            System.out.println("Insert name: ");
            String name = this.br.readLine();

            System.out.println("Insert productor name: ");
            String productor_name=this.br.readLine();

            System.out.println("Insert price: ");
            String price = this.br.readLine();

            System.out.println("Stock quantity: ");
            String quantity=this.br.readLine();

            if(Objects.equals(name, "") || Objects.equals(productor_name, "") || Objects.equals(price, "") || Objects.equals(quantity, "")){
                System.out.println("Enter all fields!");
            }
            else {

                Product prd = new Product(name, this.PL.listSize() + 1, productor_name, Float.parseFloat(price), Integer.parseInt(quantity));
                this.PL.addProductList(prd);
            }
        }catch(Exception e){
            System.out.println("ERRORE: " + e);
        }
    }



    public String secondMenuCeo(){
        try {
            System.out.println("1. Create employee account");
            System.out.println("2. Delete employee account");
            System.out.println("3. Create product");
            System.out.println("4. Delete product");
            System.out.println("5. Other product options");
            System.out.println("0. Exit");
            String sc = this.br.readLine();
            return sc;
        }catch(Exception e){
            System.out.println("ERRORE: " + e);
            return null;
        }
    }



    public void secondPageCeo(){
        try {
            do {
                scelta = secondMenuCeo();
                switch (scelta) {

                    case "1":
                        checkNewAccount(true);
                        break;

                    case "2":
                        this.UL.removeUser(searchUserById());
                        break;

                    case "3":
                        checkNewProduct();
                        break;

                    case "4":
                        this.PL.removeProduct(searchProductById());
                        break;

                    case "5":
                        secondPageEmployee();
                        break;

                    case "0":
                        firstPage();
                        break;
                    default:
                        System.out.println("Incorrect choise, try again!");
                        break;
                }
            } while (!scelta.equals("0"));
        }
        catch(Exception e){
            System.out.println("ERRORE: " + e);
        }
    }



    public void addQuantityToProduct(){
        try {
            System.out.println("Enter the ID product: ");
            String ID = this.br.readLine();
            System.out.println("Enter the quantity: ");
            String quantity = this.br.readLine();

            if (Objects.equals(ID, "") || Objects.equals(quantity, "")) {
                System.out.println("Enter all fields!");
            } else {
                Product p = this.PL.getProductById(Integer.parseInt(ID));
                if (p == null) {
                    System.out.println("Product doesn't exist!");
                } else {
                    p.addQuantity(Integer.parseInt(quantity));

                }
            }
        }
        catch(Exception e){
            System.out.println("ERRORE: " + e);
        }
    }



    public User searchUserById(){
        try {
            System.out.println("Inserte user's id: ");
            String ids = this.br.readLine();
            return this.UL.getUserById(Integer.parseInt(ids));
        }catch(Exception e){
            System.out.println("ERRORE: " + e);
            return null;
        }
    }



    public Product searchProductById(){
        try {
            System.out.println("Insert product's id: ");
            String ids = this.br.readLine();

            return this.PL.getProductById(Integer.parseInt(ids));
        }catch(Exception e){
            System.out.println("ERRORE: " + e);
            return null;
        }
    }

}
