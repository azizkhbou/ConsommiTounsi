package ConsomiTounsi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Comment implements Serializable {


	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long idComment;
	private int likesComment;
	private boolean mostPertinentComment;
	private String textComment;

	@ManyToOne
	Subject subject;

	public long getIdComment() {
		return idComment;
	}

	public void setIdComment(long idComment) {
		this.idComment = idComment;
	}

	public int getLikesComment() {
		return likesComment;
	}

	public void setLikesComment(int likesComment) {
		this.likesComment = likesComment;
	}

	public boolean isMostPertinentComment() {
		return mostPertinentComment;
	}

	public void setMostPertinentComment(boolean mostPertinentComment) {
		this.mostPertinentComment = mostPertinentComment;
	}

	public String getTextComment() {
		return textComment;
	}

	public void setTextComment(String textComment) {
		this.textComment = textComment;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	
	
}
