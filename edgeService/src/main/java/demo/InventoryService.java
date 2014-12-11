package demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="InventoryService", loadbalance=true)
public interface InventoryService {

	@RequestMapping(value="/books/{isbn}", method=RequestMethod.GET)
	BookInventory getBookInventory(@PathVariable("isbn") String isbn);

}
