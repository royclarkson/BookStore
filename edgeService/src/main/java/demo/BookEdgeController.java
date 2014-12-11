package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/books")
public class BookEdgeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private BookService bookService;
	private InventoryService inventoryService;

	@Autowired
	public BookEdgeController(BookService bookService, InventoryService inventoryService) {
		this.bookService = bookService;
		this.inventoryService = inventoryService;
	}

	@RequestMapping(value="/{isbn}", method=RequestMethod.GET)
	public Book bookByIsbn(@PathVariable("isbn") String isbn) {

		// For some reason these don't work - Says "Load balancer does not have available server for client: BookService"
		//		BookDetails bookDetails = bookService.getBookDetails(isbn);
		//		BookInventory bookInventory = inventoryService.getBookInventory(isbn);

		BookDetails bookDetails = restTemplate.getForObject("http://BookService/books/{isbn}", BookDetails.class, isbn);
		BookInventory bookInventory = restTemplate.getForObject("http://InventoryService/inventory/{isbn}", BookInventory.class, isbn);

		return new Book(bookDetails, bookInventory);
	}
	
}
