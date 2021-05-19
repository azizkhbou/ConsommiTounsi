package ConsomiTounsi.controllers.ShelfStoreProduct;

import ConsomiTounsi.Service.ProductManagerInterface;
import ConsomiTounsi.Service.ShelfManagerInterface;
import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.Shelf;
import ConsomiTounsi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductMayssaController {

    @Autowired
    ProductManagerInterface productmanager ;

    @Autowired
    ProductRepository pr;

    @PostMapping("/add")
    public void addProduct(@RequestBody Product p){ productmanager.addProduct(p);}

    @PutMapping("/ProductQuantityadd")
    public void addProductQuantity(@RequestParam("id") long id , @RequestParam("nb") int nb) {
        productmanager.addProductQuantity(id , nb);
    }

    @GetMapping("/retrieve-id")
    public Product getProductById(@RequestParam("id") long id){
        return pr.findById(id).orElse(new Product());
    }

    @PutMapping("/ProductQuantitydec")
    public void decrementProductQuantity(@RequestParam("id") long id) {
        productmanager.decrementProductQuantity(id);
    }

    @PutMapping("/resetProduct")
    public void resetQuantity(@RequestParam("id") long id) {
        productmanager.resetQuantity(id);
    }

    @GetMapping("/nbProductByShelf")
    public int getNbProductsByshelf(@RequestParam("id") int id){
        return productmanager.getNbProductsByshelf(id); }


    @GetMapping("/ProductsByShelf")
    public List<Product> FindProductByIdShelf(@RequestParam("id") long id){
        return productmanager.FindProductByIdShelf(id); }


}
