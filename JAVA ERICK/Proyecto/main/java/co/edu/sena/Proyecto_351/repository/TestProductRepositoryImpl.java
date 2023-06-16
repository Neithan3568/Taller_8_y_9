package co.edu.sena.Proyecto_351.repository;
import co.edu.sena.Proyecto_351.model.Product;

import java.sql.SQLException;

public class TestProductRepositoryImpl {
    public static void main(String[] args) throws SQLException {
        repository<Product> repository = new ProductRepositoryImpl();

        System.out.println("========== createObj Insert =========="); //insert
        Product productInsert = new Product();
        productInsert.setProduct_name(" Hello world");
        productInsert.setProduct_value(20.000F);
        productInsert.setCategory_id(1);
        repository.saveObj(productInsert);
        productInsert.setProduct_name("Uml");
        productInsert.setProduct_value(40.000F);
        productInsert.setCategory_id(1);
        repository.saveObj(productInsert);

    }
}
