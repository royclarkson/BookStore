package demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

	@RequestMapping(value="/{isbn}", method=RequestMethod.GET)
	public Book bookByISBN(@PathVariable("isbn") String isbn) {
		return new Book(isbn, "Knitting with Dog Hair", "Kendall Crolius", "Better A Sweater From A Dog You Know and Love Than From A Sheep You'll Never Meet.");
	}
	
}
