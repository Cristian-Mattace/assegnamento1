package assegnamento;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 *
 * The class {@code ProductList} provides an implementation of a
 * model of a product's list
 *
 **/

public class ProductList {

    private List<Product> productList;

    /**
     * Class constructor.
     */
    public ProductList(){
        this.productList = new ArrayList<Product>();
    }

    /**
     * Add product to the list's product
     * @param p the product that will be added to the list
     */
    public void addProductList(Product p) {
        this.productList.add(p);
    }

    /**
     * Remove the product from the list of product
     * @param p the product that will be removed from the list
     */
    public void removeProduct(Product p){
        this.productList.remove(p);
    }

    /**
     * Return the list's product
     * @return the list's product
     */
    public List<Product> getProductList(){
        return this.productList;
    }

    /**
     * Return the number of the product in the list
     * @return the number of product in the list
     */
    public int listSize(){
        return this.productList.size();
    }

    /**
     * It takes a string as input and returns the array list of products with that name
     * @param n the name of product
     * @return the product with the same name
     */
    public ArrayList<Product> getProductByNameProduct(String n){

        ArrayList<Product> p = new ArrayList<>();

        for (Product product : this.productList) {
            if (Objects.equals(product.getName(), n)) {
                p.add(product);
            }
        }

        if(p.size() == 0){

            System.out.println("Product doesn't exist");
            return null;
        }else
            return p;
    }

    /**
     * It takes a string as input and returns the array list of products with that productor
     * @param n the name of producer's product
     * @return the product with the same name of producer
     */
    public ArrayList<Product> getProductByNameProductor(String n){

        ArrayList<Product> p = new ArrayList<>();

        for (Product product : this.productList) {
            if (Objects.equals(product.getNameproductor(), n)) {
                p.add(product);
            }
        }

        if(p.size() == 0) System.out.println("Product doesn't exist");
        return p;
    }

    /**
     * It calculates the minimum price of the products in the product list
     * @return the product with the min price
     */
    public Product getProductMinPrice(){
        Product p = this.productList.get(0);
        for (Product product : this.productList) {
            if (product.getPrice() < p.getPrice()) {
                p = product;
            }
        }
        return p;
    }

    /**
     * It calculates the maximum price of the products in the product list
     * @return the product with the max price
     */
    public Product getProductMaxPrice(){
        Product p = this.productList.get(0);
        for (Product product : this.productList) {
            if (product.getPrice() > p.getPrice()) {
                p = product;
            }
        }
        return p;
    }

    /**
     * It finds the product with that ID
     * @param id the product's id
     * @return the product with the same id
     */
    public Product getProductById(int id){
        for (Product product : this.productList) {
            if (Objects.equals(product.getCode(), id)) {
                return product;
            }
        }
        System.out.println("Product doesn't exist");
        return null;
    }

    /**
     * Print all info of all product in the list
     */
    public void stamp(){
        for(Product p : this.productList){
            System.out.println(p.getName()+" "+p.getCode()+" "+p.getNameproductor()+" €"+p.getPrice()+" "+p.getQuantity());
        }
    }

}
