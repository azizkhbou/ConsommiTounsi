package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Shelf implements Serializable {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long idShelf;
	
	@Enumerated(EnumType.STRING)
    private typeShelf typeShelf;



	@ManyToOne
	Store store;


	@OneToMany(mappedBy="shelf",
			cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
			fetch= FetchType.EAGER)
	private List<Product> product = new ArrayList<>();


	public long getIdShelf() {
		return idShelf;
	}


	public void setIdShelf(long idShelf) {
		this.idShelf = idShelf;
	}


	public typeShelf getTypeShelf() {
		return typeShelf;
	}


	public void setTypeShelf(typeShelf typeShelf) {
		this.typeShelf = typeShelf;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}


	public List<Product> getProduct() {
		return product;
	}


	public void setProduct(List<Product> product) {
		this.product = product;
	}

	

}
