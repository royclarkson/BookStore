package demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@RequestMapping(value="/{isbn}", method=RequestMethod.GET)
	public InventoryRecord inventoryByISBN(@PathVariable("isbn") String isbn) {
		return new InventoryRecord(isbn, 256);
	}
	
}
