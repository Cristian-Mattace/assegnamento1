package assegnamento;

public class Product {

    private String name;
    private int code;
    private String name_productor;
    private float price;
    private int quantity;

    public Product(){
        this.name = "";
        this.code = 0;
        this.name_productor = "";
        this.price = 0;
        this.quantity = 0;
    }

    public  Product(final String nam, final int cod, final String nameProd, final float pric, final int quantit){
        this.name = nam;
        this.code = cod;
        this.name_productor = nameProd;
        this.price = pric;
        this.quantity = quantit;
    }

    public String getName(){

        return this.name;
    }

    public int getCode(){

        return this.code;
    }

    public String getNameproductor(){

        return this.name_productor;
    }

    public float getPrice(){

        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

}
