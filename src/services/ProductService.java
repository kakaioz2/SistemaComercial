package services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import model.Product;

public class ProductService {
    private ArrayList<Product> productList;

    public ProductService() {
        productList = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Produto invalido! nao pode ser nulo.");
        }
        for (Product product1 : productList) {
            if (product1.getId() == product.getId()) {
                throw new IllegalArgumentException("Id ja existe!");
            }

        }
        Product product2 = new Product(

                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity());

        this.productList.add(product2);

    }

    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> productListCopy = new ArrayList<Product>();
        for (Product product : productList) {
            Product product2 = new Product(

                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity());

            productListCopy.add(product2);
        }
        return productListCopy;
    }

    public Product getProductById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                Product product2 = new Product(

                        product.getId(),
                        product.getName(),
                        product.getPrice(),
                        product.getQuantity());

                return product2;
            }
        }
        return null;
    }

    public void removeProduct(int id) {

        for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();) {
            Product product = iterator.next();

            if (product.getId() == id) {
                iterator.remove();
                return;
            }
        }
        throw new IllegalArgumentException("Invalido!");
    }

    public void updateProductPrice(int id, BigDecimal newPrice) {
        if (newPrice != null && newPrice.compareTo(BigDecimal.ZERO) > 0) {
            for (Product product : productList) {
                if (product.getId() == id) {
                    product.setPrice(newPrice);
                    return;
                }
            }
            throw new IllegalArgumentException("Invalido!");

        } else {
            throw new IllegalArgumentException("Preço Invalido!");
        }
    }
}
