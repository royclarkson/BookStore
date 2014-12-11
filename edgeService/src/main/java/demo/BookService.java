package demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="BookService", loadbalance=true)
public interface BookService {

	@RequestMapping(value="/books/{isbn}", method=RequestMethod.GET)
	BookDetails getBookDetails(@PathVariable("isbn") String isbn); 
	
}
