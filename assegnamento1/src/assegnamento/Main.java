package assegnamento;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Product cc = new Product("pippo",1,"rino", (float) 12.90);
        Product sec = new Product("gbfv",2,"pino", (float) 12.90);
        Product ter = new Product("heng",3,"gino", (float) 1);
        Product qua = new Product("egb",4,"fino", (float) 12.90);
        Product qui = new Product("qweafd",5,"sino", (float) 12.90);

        userList ul = new userList();
        ProductList pp = new ProductList();
        pp.addProductList(cc);
        pp.addProductList(sec);
        pp.addProductList(ter);
        pp.addProductList(qua);
        pp.addProductList(qui);

        User uu = new User(0,"cc","c","x","cccc",false);

        System.out.println(cc.getName());
        System.out.println(uu.getId());

        System.out.println(pp.getNumberOfElements());
        Product p = pp.getProductMinPrice();
        System.out.println(p.getCode());
    }
}
