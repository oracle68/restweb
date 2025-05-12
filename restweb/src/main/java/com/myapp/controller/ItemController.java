package com.myapp.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myapp.model.Item;


@Controller
public class ItemController {

	private Logger logger;
	public ItemController() {
		this.logger = Logger.getLogger(this.getClass());
	}

	
	
	//@RequestMapping(value="/itemService", method=RequestMethod.POST, produces="application/JSON")
	@PostMapping(path = "/itemService", consumes = "application/json", produces = "application/json")
	public @ResponseBody Item ItemService(@RequestHeader HttpHeaders httpHeaders, 
			@RequestBody Item item) {	
		logger.info(item);
		System.out.println(item);
		
		Item item2 = new Item (2L,"name 2","desc 2",item.getPrice()*100);
		return item2;
	}
	
	@GetMapping(path="/item2Service",produces="application/json")
	public @ResponseBody Item Item2Service() {	
		logger.debug("item");
		return new Item(2L,"item2","desc2",25.0);
	}	
}
