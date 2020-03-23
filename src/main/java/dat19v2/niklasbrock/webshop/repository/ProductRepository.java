package dat19v2.niklasbrock.webshop.repository;

import dat19v2.niklasbrock.webshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product>{

    private List<Product> products = new ArrayList<>();

    public ProductRepository(){
        products.add(new Product(0, "vare 1", 99, "Beskrivelse af 1. vare"));
        products.add(new Product(1, "vare 2", 49, "Beskrivelse af 2. vare"));
        products.add(new Product(2, "vare 3", 199, "Beskrivelse af 3. vare"));
        products.add(new Product(3, "vare 4", 299, "Beskrivelse af 4. vare"));
    }

    public List<Product> findAll(){
        return products;
    }

    /*Adds a new product to collection*/
    public void create(Product product){
        boolean idFound = false;
        for (int i = 0; i < products.size(); i++){
            /*Checks for holes in the ID number sequence, if a product has been deleted*/
            if (products.get(i).getId() != i+1){
                product.setId(i+1);
                idFound = true;
            }
            if (!idFound){
                /*If there are no holes, then adding ID to end of number sequence*/
                product.setId(products.size()+1);
            }
        }
        products.add(product);
    }

    @Override
    public Product read(int id) {
        for (Product product :
                products) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean update(Product product) {
        for (int i = 0; i < products.size(); i++){
            if (products.get(i).getId() == product.getId()){
                products.set(i, product);
                return true;
            }
        }
        return false;
    }

//    TODO needs work. It needs work be able to delete any id/index combo
    @Override
    public boolean delete(int id) {
        boolean deleted = false;
        for (int i = 0; i < products.size(); i++){
            if (products.get(id) == products.get(i)){
                products.remove(id);
                return true;
            }
        }
        return false;
    }
}
