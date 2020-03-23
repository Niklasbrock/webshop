package dat19v2.niklasbrock.webshop.service;

import dat19v2.niklasbrock.webshop.model.Product;
import dat19v2.niklasbrock.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){ return productRepository.findAll(); }

    public void create(Product product){
        productRepository.create(product);
    }

    public boolean update(Product product){ return productRepository.update(product); }

    public Product read(int id){
        return productRepository.read(id);
    }

    public boolean delete(int id) { return productRepository.delete(id); }
}
