package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id_event;

	private String eventName;
	private double raisedAmount_event;
	private String place_event;
	private String target_event;
	//@Temporal (TemporalType.DATE)
	private LocalDateTime date_event;
	private int nombreplace;
	private int nombredeplaceinitiale;




	/*@OneToMany(cascade = CascadeType.PERSIST, mappedBy="event")
	private List<Donation> donation;*/

	@OneToMany(mappedBy="event",
			cascade = {CascadeType.ALL, CascadeType.REMOVE})
	private List<Donation> donation = new ArrayList<>();

	
	/*@ManyToOne
	Pool pool;*/

	/*@ManyToMany(cascade = CascadeType.ALL, mappedBy="event")
	private List<Client> clients;*/

	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	/*@JoinTable(
			name = "client_event",
			joinColumns = @JoinColumn(name = "event_id"),
			inverseJoinColumns = @JoinColumn(name = "client_id"))*/
	private List<Client> clients;

	public void addclients(List<Client> addedCleints){

		addedCleints.forEach(client -> {

			if (clientExist(client.getIdUser())){
				throw new IllegalStateException("client Not Exist");
			}
			clients.add(client);
		});
	}

	public void addclients(Client addedClients){
		/*if (clientExist(addedClients.getIdUser()))
		{throw new IllegalStateException("Client Not even Exist");}*/
		clients.add(addedClients);

	}
	private  boolean clientExist ( Long idClient ){
		for ( Client client:clients   ){
			if ( client.getIdUser()!=idClient)
				return true  ;

		}
		return  false ;
	}

	//public void addClient (List<Client> adeddclient) {
		//if(clients == null)
			//clients = new ArrayList<>();
		//adeddclient.forEach(client -> {clients.add(client); });

	public boolean addclient(Client emp) {
		if(clients == null)
			clients = new ArrayList<>();

		return clients.add(emp);
	}

	public boolean removeclient(Client emp) {
		if(clients == null)
			clients = new ArrayList<>();

		return clients.remove(emp);
	}

	public long getId_event() {
		return id_event;
	}

	public void setId_event(long id_event) {
		this.id_event = id_event;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public double getRaisedAmount_event() {
		return raisedAmount_event;
	}

	public void setRaisedAmount_event(double raisedAmount_event) {
		this.raisedAmount_event = raisedAmount_event;
	}

	public String getPlace_event() {
		return place_event;
	}

	public void setPlace_event(String place_event) {
		this.place_event = place_event;
	}

	public String getTarget_event() {
		return target_event;
	}

	public void setTarget_event(String target_event) {
		this.target_event = target_event;
	}

	public LocalDateTime getDate_event() {
		return date_event;
	}

	public void setDate_event(LocalDateTime date_event) {
		this.date_event = date_event;
	}

	public int getNombreplace() {
		return nombreplace;
	}

	public void setNombreplace(int nombreplace) {
		this.nombreplace = nombreplace;
	}

	public int getNombredeplaceinitiale() {
		return nombredeplaceinitiale;
	}

	public void setNombredeplaceinitiale(int nombredeplaceinitiale) {
		this.nombredeplaceinitiale = nombredeplaceinitiale;
	}

	public List<Donation> getDonation() {
		return donation;
	}

	public void setDonation(List<Donation> donation) {
		this.donation = donation;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	

}







