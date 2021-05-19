package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Payment implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private   Long id;
    private   String customerId;
    private String email;
    private  float amount;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String description;
    @OneToOne
    Order order;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Payment(Long id, String customerId, String email, float amount, Date date, String description, Order order) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.email = email;
		this.amount = amount;
		this.date = date;
		this.description = description;
		this.order = order;
	}
	public Payment() {
	
	}
    
    
}
