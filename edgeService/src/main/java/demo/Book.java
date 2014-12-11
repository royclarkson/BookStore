package demo;

public class Book {

	private BookDetails details;
	private BookInventory inventory;

	public Book(BookDetails details, BookInventory inventory) {
		this.details = details;
		this.inventory = inventory;
	}

	public BookDetails getDetails() {
		return details;
	}
	
	public BookInventory getInventory() {
		return inventory;
	}
	
}
