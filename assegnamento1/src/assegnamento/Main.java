package assegnamento;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Product cc = new Product("pippo",1,"rino", (float) 12.90, 2);
        Product sec = new Product("gbfv",2,"pino", (float) 12.90, 4);
        Product ter = new Product("heng",3,"gino", (float) 1, 5);
        Product qua = new Product("egb",4,"fino", (float) 12.90, 1);
        Product qui = new Product("qweafd",5,"sino", (float) 12.90, 1);

        ProductList pp = new ProductList();

        pp.addProductList(cc);
        pp.addProductList(sec);
        pp.addProductList(ter);
        pp.addProductList(qua);
        pp.addProductList(qui);

        pp.stamp();

        //////////////////////////////////////////////////7

        User uu = new User(0,"primo","c","x","cccc",false);
        User uu1 = new User(0,"secondo","c","y","cccc",false);
        User uu2 = new User(0,"terzo","c","z","cccc",false);
        User uu3 = new User(0,"quarto","c","x","cccc",false);

        UserList us = new UserList();

        us.addUser(uu);
        us.addUser(uu1);
        us.addUser(uu2);
        us.addUser(uu3);

        us.stamp();
    }
}
