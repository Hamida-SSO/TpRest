package fr.iocean.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Book")
public class Book extends GenericModel {

	@Id
	@SequenceGenerator(name = "seq_book", sequenceName = "seq_book")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_book")
	@Column(name="id")	protected int id;

	@NotNull @Column(name="title") private String title;
	@Length(min=10, max=15) @Column(name="isbn") private String isbn;
	@Column(name="publication_date") @Temporal(TemporalType.DATE)    private Date publicationDate;
	@Column(name="nb_pages") private int nbPages;
	@Column(name="authors") private String authors;
	
	public int getId() {		return id;	}
	public void setId(int id) {		this.id = id;			}
	public String getTitle() {		return title;	}
	public void setTitle(String title) {		this.title = title;	}
	public String getIsbn() {		return isbn;	}
	public void setIsbn(String isbn) {		this.isbn = isbn;	}
	public Date getPublicationDate() {		return publicationDate;	}
	public void setPublicationDate(Date publicationDate) {		this.publicationDate = publicationDate;	}
	public int getNbPages() {		return nbPages;	}
	public void setNbPages(int nbPages) {		this.nbPages = nbPages;	}
	public String getAuthors() {		return authors;	}
	public void setAuthors(String authors) {		this.authors = authors;	}
	
}
