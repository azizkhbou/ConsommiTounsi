package ConsomiTounsi.Service;

import ConsomiTounsi.entities.Product;
import ConsomiTounsi.entities.TypeCategory;
import ConsomiTounsi.entities.TypeCriteria;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;


public interface ProductManagerInterface {
    List<Product> retrieveAllProducts();
    Product addProduct(Product P);
    void deleteProduct(Long id);
    void deleteProduct(String id);
    Product updateProduct(Long id ,Product P);
    Optional<Product> FindProduct(Long id);
    Optional<Product> FindProduct(String id);
    int addProductQuantity(long id , int nb);
    int decrementProductQuantity(long id);
    void resetQuantity(long id);



    @Transactional
    int getNbProductsByshelf(int idshelf);
    
    @Transactional
    List<Product> FindProductByIdShelf(Long id);

   // List<Product>findByCategoryProduct(TypeCategory cp);
   // void showAdvertsement( List<Product> products,TypeCriteria criteria) ;
    EntityManager getEntityManager();
	List<Long> sendIdClaimedProduct();	
}
