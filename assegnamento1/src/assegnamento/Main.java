package assegnamento;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Product pri = new Product("Prodotto1",1,"rino", (float) 12.90, 2);
        Product sec = new Product("Prodotto2",2,"pino", (float) 12.90, 4);
        Product ter = new Product("Prodotto3",3,"gino", (float) 1.00, 5);
        Product qua = new Product("Prodotto4",4,"fino", (float) 12.90, 1);
        Product qui = new Product("Prodotto5",5,"sino", (float) 12.90, 1);

        ProductList pp = new ProductList();

        pp.addProductList(pri);
        pp.addProductList(sec);
        pp.addProductList(ter);
        pp.addProductList(qua);
        pp.addProductList(qui);

        //pp.stamp();

        //////////////////////////////////////////////////

        User uu1 = new User(1,"Utente1","c","x","cccc",false);
        User uu2 = new User(2,"Utente2","c","y","y",true);
        User uu3 = new User(3,"Utente3","c","z","cccc",false);
        User uu4 = new User(4,"Utente4","c","xx","cccc",false);

        UserList us = new UserList();

        us.addUser(uu1);
        us.addUser(uu2);
        us.addUser(uu3);
        us.addUser(uu4);

        //us.stamp();

        Menu mn = new Menu(us, pp);
        mn.firstPage();
    }
}
