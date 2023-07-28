package bo.com.crudquarkus.service;

import bo.com.crudquarkus.dto.ProductDto;
import bo.com.crudquarkus.entity.Product;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductService {

    public List<Product> listProduct() {
        return Product.listAll();
    }
    @Transactional
    public Product saveProduct(ProductDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.persist();
        return product;
    }

    @Transactional
    public Product updateProduct(Long id, ProductDto dto) {
        Product product = Product.findById(id);
        product.setName(dto.getName());
        product.setStock(dto.getStock());
        product.setPrice(dto.getPrice());
        return product;
    }
    @Transactional
    public void removeProduct(Long id){
        Product.deleteById(id);
    }
}
