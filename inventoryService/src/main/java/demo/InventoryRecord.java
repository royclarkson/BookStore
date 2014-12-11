package demo;

public class InventoryRecord {

	private String isbn;
	private int onHand;

	public InventoryRecord(String isbn, int onHand) {
		this.isbn = isbn;
		this.onHand = onHand;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public int getOnHand() {
		return onHand;
	}

}
