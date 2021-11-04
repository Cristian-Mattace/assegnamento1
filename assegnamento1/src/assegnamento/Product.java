package assegnamento;

/**
 *
 * The class {@code Product} provides an implementation of a
 * model of a product
 *
 **/
public class Product {

    private String name;
    private int code;
    private String name_productor;
    private float price;
    private int quantity;


    /**
     * Class constructor.
     *
     **/
    public Product(){
        this.name = "";
        this.code = 0;
        this.name_productor = "";
        this.price = 0;
        this.quantity = 0;
    }


    /**
     * Class constructor with parameters
     * @param nam the product's name
     * @param cod the product's code to recognize it
     * @param nameProd the producer of product
     * @param pric the product's price
     * @param quantit the product's quantity
     */
    public  Product(final String nam, final int cod, final String nameProd, final float pric, final int quantit){
        this.name = nam;
        this.code = cod;
        this.name_productor = nameProd;
        this.price = pric;
        this.quantity = quantit;
    }

    /**
     * It returns the product's name
     * @return the product's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * It returns the product's code
     * @return the product's code
     */
    public int getCode(){
        return this.code;
    }

    /**
     * It returns the producer's name of the product
     * @return the producer's name of the product
     */
    public String getNameproductor(){
        return this.name_productor;
    }

    /**
     * It returns the product's price
     * @return the product's price
     */
    public float getPrice(){

        return this.price;
    }

    /**
     * It returns the product's quantity
     * @return the product's quantity
     */
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * It adds quantity to the product
     * @param q quantity of product
     *          to incrase or decrase from stock.
     */
    public void addQuantity(int q) {

        this.quantity = this.quantity + q;

        if(this.quantity<0){
            this.quantity = this.quantity - q;
            System.out.println("There are only "+ this.quantity + " stock product! Add more");
        }else
            System.out.println("Quantity update!");
    }

    /**
     * It finalizes the purchase of the product
     * @param q the quantity of product that a client
     *          would buy
     * @return true, if the purchase was succesfull
     *          false, if the purchase was wrong
     */
    public boolean acquisto(int q){
        if(q > this.quantity){
            System.out.println("There aren't enough products !!!");
            return false;
        }
        else{
            this.quantity = this.quantity - q;
            System.out.println("Purchase made, new quantity : " + this.quantity);
            return true;
        }
    }

    /**
     * It prints all the info of product
     */
    public void stamp(){
        System.out.println(this.getCode()+" "+this.getName()+" "+this.getNameproductor()+" €"+this.getPrice()+" "+this.getQuantity());
    }

}
