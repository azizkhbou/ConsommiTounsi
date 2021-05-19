package ConsomiTounsi.controllers.mouadh_Controllers;

import ConsomiTounsi.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {

    List<Product> products;

	public GetAllProductResponse(List<Product> products) {
		super();
		this.products = products;
	}
    
    
}
