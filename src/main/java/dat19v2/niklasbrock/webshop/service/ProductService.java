package dat19v2.niklasbrock.webshop.service;

import dat19v2.niklasbrock.webshop.model.Product;
import dat19v2.niklasbrock.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Iterable<Product> findAll(){ return productRepository.findAll(); }

    public void create(Product product){
        productRepository.save(product);
    }

    public void update(Product product){ productRepository.save(product); }

    public Product read(int id){
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id).get();
            } else return null;
        }

    public void delete(Product product) { productRepository.delete(product); }
}
