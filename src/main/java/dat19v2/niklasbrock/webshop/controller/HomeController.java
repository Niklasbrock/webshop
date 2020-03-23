package dat19v2.niklasbrock.webshop.controller;

import dat19v2.niklasbrock.webshop.model.Product;
import dat19v2.niklasbrock.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index (Model model, HttpSession httpSession){
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product){
        productService.create(product);
        return "redirect:/";
    }

    /*use pathvariable to map id from list on webpage*/
    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        /*add product with ID to model view*/
        model.addAttribute("product", productService.read(id));
        return "update"; }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product){
        productService.update(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        productService.delete(id);
        return "redirect:/";
    }


}
