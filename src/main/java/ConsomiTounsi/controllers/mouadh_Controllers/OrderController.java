package ConsomiTounsi.controllers.mouadh_Controllers;

import ConsomiTounsi.Service.OrderManager;
import ConsomiTounsi.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderManager om;
    //Create A new Order
    @PostMapping
    ResponseEntity<?> createNewOrder( @RequestBody Order o){
        om.addOrder(o);
        return new ResponseEntity<>(new MessageResponseModel("Order Added "), HttpStatus.CREATED);
    }
    //Show All Orders
    @GetMapping
    ResponseEntity<?> getAllOrder(){
        List<Order> o=om.retrieveAllOrder();
        GetAllOrderResponse orders = new GetAllOrderResponse(o);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }
    //Show an order by id
    @GetMapping("/{id}")
    ResponseEntity<?> getOrderById(@PathVariable Long id){
        return new ResponseEntity<>(om.FindOrder(id),HttpStatus.OK);

    }
    //Delete an Order by id
    @DeleteMapping ("/{id}")
    ResponseEntity<?> deleteProductById(@PathVariable Long id){
        om.deleteOrder(id);
        return new ResponseEntity<>(new MessageResponseModel("Order Deleted"),HttpStatus.OK);

    }
    //Update an Order
    @PutMapping("/{id}")
    ResponseEntity<?> updateProduct(@PathVariable Long id ,@RequestBody Order o){

        om.updateOrder(id,o);
        return new ResponseEntity<>(new MessageResponseModel("Order Updated"), HttpStatus.OK);
    }
    //

}
