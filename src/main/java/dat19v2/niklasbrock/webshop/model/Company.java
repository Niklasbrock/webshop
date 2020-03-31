package dat19v2.niklasbrock.webshop.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    //    one to one relationship with cascade all, so that description is deleted if company is deleted.
    @OneToOne(cascade = CascadeType.ALL)
    private CompanyDescription companyDescription;

    @OneToMany
    @JoinColumn(name = "company_id")
    private Set<Product> products;

    public Company() {
    }

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
