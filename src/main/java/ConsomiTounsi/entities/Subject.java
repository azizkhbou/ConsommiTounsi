package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Subject implements Serializable {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long idSubject;
	
	private boolean featuredSubject;
	private String descriptionSubject;
	private int likesSubject;

	@ManyToOne
	User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="subject")
	private Set<Comment> comment;

	public long getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(long idSubject) {
		this.idSubject = idSubject;
	}

	public boolean isFeaturedSubject() {
		return featuredSubject;
	}

	public void setFeaturedSubject(boolean featuredSubject) {
		this.featuredSubject = featuredSubject;
	}

	public String getDescriptionSubject() {
		return descriptionSubject;
	}

	public void setDescriptionSubject(String descriptionSubject) {
		this.descriptionSubject = descriptionSubject;
	}

	public int getLikesSubject() {
		return likesSubject;
	}

	public void setLikesSubject(int likesSubject) {
		this.likesSubject = likesSubject;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	
	
}
