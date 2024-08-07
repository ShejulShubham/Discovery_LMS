package com.discovery.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book extends BaseEntity{
	
//    title
//    author
//    category
//    publication_date
//    ISBN
//    quantity_available
//    description
	
	@Column(name = "title", length = 30, unique = true)
	private String title;
	
//	private LocalDate publishDate;
	
	private int quantityAvailable;
	
	@Column(length = 300)
	private String description;
	
	// book *--->1 Category
	@ManyToOne
	//to customize FK col name n not null constraint
	@JoinColumn(name="category_id",nullable = false)
	private Category bookCategory;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "book_author",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();
	
	
	@OneToMany(mappedBy = "book")
    private Set<Borrow> borrows;
	
	private String bookImagePath;
	
	public String setAuthor(Author author) {
		
		authors.add(author);
		
		return "Success";
	}
	
//	public Author getAuthor() {
//		
//		return authors.
//	}
	
	
	
	
}
