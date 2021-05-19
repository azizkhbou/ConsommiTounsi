package ConsomiTounsi.controllers.mouadh_Controllers;

import ConsomiTounsi.Service.ProductManager;
import ConsomiTounsi.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductManager pm;
    // Add A new Product
    @PostMapping("/product")
    ResponseEntity<?> createNewProduct(@RequestBody Product p) {

        pm.addProduct(p);
        return new ResponseEntity<>(new MessageResponseModel("Product Added"), HttpStatus.CREATED);
    }
    // Show All Product
    @GetMapping("/product")
    ResponseEntity<?> getAllProduct() {
        List<Product> p = pm.retrieveAllProducts();
        GetAllProductResponse products = new GetAllProductResponse(p);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    // show A specific product with by id
    @GetMapping("/product/{id}")
    ResponseEntity<?> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(pm.FindProduct(id), HttpStatus.OK);

    }

    /*
    @GetMapping("/getproductsbyorder/{id}")
    ResponseEntity<?> getProductByOrder(@PathVariable Long id){
        return new ResponseEntity<>(pm.FindByOrder(id),HttpStatus.OK);
    }

     */

    // Delete A Product
    @DeleteMapping("/product/{id}")
    ResponseEntity<?> deleteProductById(@PathVariable Long id) {
        pm.deleteProduct(id);
        return new ResponseEntity<>(new MessageResponseModel("Product Deleted"), HttpStatus.OK);

    }
    // Update A Product
    @PutMapping("/product/{id}")
    ResponseEntity<?> updateProduct(@PathVariable Long id,@RequestBody Product p) {
        pm.updateProduct(id,p);
        return new ResponseEntity<>(new MessageResponseModel("Product Updated"), HttpStatus.CREATED);
    }

    // get All Product By Rating
    @GetMapping("/productbyrating")
    ResponseEntity<?> getAllProductByRating() {
        List<Product> p = pm.findByRating();
        GetAllProductResponse products = new GetAllProductResponse(p);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @GetMapping("/products/{name}")
    ResponseEntity<?> getProductByName(@PathVariable String name) {
        List<Product>p=pm.findByName(name);
        return new ResponseEntity<>(p, HttpStatus.OK);

    }
    


    // get All Product By Desc Price
    @GetMapping("/productbydesc")
    ResponseEntity<?> getAllProductByDescPrice() {
        List<Product> p = pm.findByDescPrice();
        GetAllProductResponse products = new GetAllProductResponse(p);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    // get All Product By Asc Price
    @GetMapping("/productbyasc")
    ResponseEntity<?> getAllProductByAscPrice() {
        List<Product> p = pm.findByAscPrice();
        GetAllProductResponse products = new GetAllProductResponse(p);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    // get Product By Category
    @GetMapping("/prodCategory/{category}")
    ResponseEntity<?> getprodbyCategory(@PathVariable String category){
        List<Product> p = pm.findProductByCategory(category);
        GetAllProductResponse products = new GetAllProductResponse(p);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

}
