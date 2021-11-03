package assegnamento;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductList {

    private List<Product> productList;

    public ProductList(){
        this.productList = new ArrayList<Product>();
    }

    public void addProductList(Product p) {
        this.productList.add(p);
    }

    public void removeProduct(Product p){
        this.productList.remove(p);
    }

    public List<Product> getProductList(){
        return this.productList;
    }

    public int getNumberOfElements(){
        return this.productList.size();
    }

    public ArrayList<Product> getProductByNameProduct(String n){

        ArrayList<Product> p = new ArrayList<>();

        for (Product product : this.productList) {
            if (Objects.equals(product.getName(), n)) {
                p.add(product);
            }
        }

        if(p.size() == 0) System.out.println("Product doesn't exist");
        return p;
    }

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

    public Product getProductMinPrice(){
        Product p = this.productList.get(0);
        for (Product product : this.productList) {
            if (product.getPrice() < p.getPrice()) {
                p = product;
            }
        }
        return p;
    }

    public Product getProductMaxPrice(){
        Product p = this.productList.get(0);
        for (Product product : this.productList) {
            if (product.getPrice() > p.getPrice()) {
                p = product;
            }
        }
        return p;
    }

    public Product getProductById(int id){
        for (Product product : this.productList) {
            if (Objects.equals(product.getCode(), id)) {
                return product;
            }
        }
        System.out.println("Product doesn't exist");
        return null;
    }

    public void stamp(){
        for(Product p : this.productList){
            System.out.println(p.getName()+" "+p.getCode()+" "+p.getNameproductor()+" €"+p.getPrice()+" "+p.getQuantity());
        }
    }

    public int listSize(){
        return this.productList.size();
    }

}
