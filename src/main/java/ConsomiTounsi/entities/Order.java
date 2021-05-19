package ConsomiTounsi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="\"Order\"")

public class Order implements Serializable {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)

	private Long id;
	@Temporal (TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date date;
	
	@Enumerated(EnumType.STRING)
	private Payment_type paymentType;


	private float cost;

	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Payment_type getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Payment_type paymentType) {
		this.paymentType = paymentType;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}




	private boolean paid;
	private float weight;
    private Long idUser;
	@OneToOne
	Payment payment;

	@ManyToOne
	Delivery delivery;
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JoinTable(
			name = "product_ord",
			joinColumns = @JoinColumn(name = "order_id"),
			inverseJoinColumns = @JoinColumn(name = "product_id"))

	private List<Product> products;

	public void addproducts(List<Product> addedProducts){

		addedProducts.forEach(product -> {

			if (productExist(product.getId())){
				throw new IllegalStateException("Product Not Found");
			}
			products.add(product);
		});
	}

	public void addproducts(Product addedProducts){
        if (productExist(addedProducts.getId()))
		{throw new IllegalStateException("Product Not even Found");}
        products.add(addedProducts);

    }
    private  boolean productExist ( Long idProduct ){
        for ( Product product:products   ){
            if ( product.getId()==idProduct)
                return true  ;

        }
        return  false ;
    }




}
	/*
	boolean trouve=true;
	List<Product> l=O.getProducts();
        for (int i=0;i<l.size();i++)
		{
		if(!this.pm.product_exist(l.get(i).getId()))
		trouve=false;
		}
		if(trouve)
		{
		orderLegacy.setProducts(l);
		}
		else
		throw new IllegalStateException("One of product is messing");

	 */

