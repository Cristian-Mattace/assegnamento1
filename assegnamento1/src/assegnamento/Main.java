package assegnamento;

import java.util.List;

/**
 * The class {@code Main} is the initial class of the project
 */

public class Main {

    /**
     * Initial Main method
     */
    public static void main(String[] args) {
	// write your code here
        Product processor = new Product("Processor",1,"Intel", (float) 150.00, 2);
        Product video = new Product("Video card",2,"Intel", (float) 90.00, 4);
        Product desktop = new Product("Desktop",3,"Hp", (float) 190.00, 1);
        Product mouse = new Product("Mouse",4,"Logitech", (float) 12.90, 5);

        ProductList pp = new ProductList();

        pp.addProductList(processor);
        pp.addProductList(video);
        pp.addProductList(desktop);
        pp.addProductList(mouse);

        User CEO = new User(1,"CEO","66","ceo66@gmail.com","ceo66",true);
        User employee1 = new User(2,"Pippo","1","pippo@gmail.com","pippo",true);
        User employee2 = new User(3,"Pluto","2","pluto@gmail.com","pluto",true);
        User client1 = new User(4,"Caio","1","caio@gmail.com","caio",false);
        User client2 = new User(5,"Sempronio","2","sempronio@gmail.com","sempronio",false);

        UserList us = new UserList();

        us.addUser(CEO);
        us.addUser(employee1);
        us.addUser(employee2);
        us.addUser(client1);
        us.addUser(client2);

        Menu mn = new Menu(us, pp);
        mn.firstPage();
    }
}
