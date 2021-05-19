package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pool implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id_pool;
	private double amount_pool;


	
	/*@OneToMany(mappedBy="pool",cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
			fetch= FetchType.EAGER)
	private Set<Event> event;*/

	@OneToOne(mappedBy="pool")
	private Admin admin;



	public long getId_pool() {
		return id_pool;
	}



	public void setId_pool(long id_pool) {
		this.id_pool = id_pool;
	}



	public double getAmount_pool() {
		return amount_pool;
	}



	public void setAmount_pool(double amount_pool) {
		this.amount_pool = amount_pool;
	}



	public Admin getAdmin() {
		return admin;
	}



	public void setAdmin(Admin admin) {
		this.admin = admin;
	}





}
