package model;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String name;
    private BigDecimal price;
    private int quantity;

    public Product(int id, String name, BigDecimal price, int quantity) {

        if (id < 1) {
            throw new IllegalArgumentException("Identificador nao pode ser abaixo de 1");
        }
        this.id = id;

        if (name == null || name.isBlank() == true) {
            throw new IllegalArgumentException("Produto esta sem nome!");
        }
        this.name = name;

        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço invalido!!");
        }
        this.price = price;

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantidade Invalida!! Nao pode ser menor que 0.");
        }
        this.quantity = quantity;

    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setName(String name) {
        if (name == null || name.isBlank() == true) {
            throw new IllegalArgumentException("Produto esta sem nome!");
        }
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço invalido!!");
        }
        this.price = price;
    }

    public void addStock(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantidade Invalida!! Tem que ser maior que 0.");
        }
        this.quantity += quantity;
    }

    public void removeStock(int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Quantidade Invalida!! Tem que ser maior que 0.");
        }

        if (quantity > this.quantity) {
            throw new IllegalArgumentException("Quantidade Invalida!! quantidade muito alta");
        }
        this.quantity -= quantity;
    }

    @Override 
    public String toString(){
        return "Produto \n id = " + id + ",\n name = " + name + ",\n price = " + price + ",\n quantity = " + quantity + "\n\n";
    }

}
