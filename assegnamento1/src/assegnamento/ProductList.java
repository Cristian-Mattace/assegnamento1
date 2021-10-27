package assegnamento;
import java.util.ArrayList;
import java.util.List;

public class ProductList {

    private List<Product> productList;

    public ProductList(){
        this.productList = new ArrayList<Product>();
    }

    public void addProductList(Product p) {
        this.productList.add(p);
    }

    public void removeProduct(Product p){
        productList.remove(p);
    }

    public List<Product> getProductList(){
        return productList;
    }

    public int getNumberOfElements(){
        return productList.size();
    }

    public List<Product> getProductByNameProduct(String n){

        ArrayList<Product> p = new ArrayList<>();

        for (Product product : productList) {
            if (product.getName() == n) {
                p.add(product);
            }
        }
        return p;
    }

    public List<Product> getProductByNameProductor(String n){

        ArrayList<Product> p = new ArrayList<>();

        for (Product product : productList) {
            if (product.getNameproductor() == n) {
                p.add(product);
            }
        }
        return p;
    }

    public assegnamento.Product getProductMinPrice(){
        Product p = productList.get(0);
        for (Product product : productList) {
            if (product.getPrice() < p.getPrice()) {
                p = product;
            }
        }
        return p;
    }

    public Product getProductMaxPrice(){
        Product p = productList.get(0);
        for (Product product : productList) {
            if (product.getPrice() > p.getPrice()) {
                p = product;
            }
        }
        return p;
    }
}
