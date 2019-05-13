package com.abdullah.khan.cblpg.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.abdullah.khan.cblpg.model.Order;

@RestController
public class TestController {
	
	@ResponseBody
	@RequestMapping(value = "/orderui", method = RequestMethod.POST)
	public String orderuiPost(Order order) {
//Order [id=43224.0, merchant=13124.0, purchaseAmount=243.0, currency=050, description=Test Product, approveURL=http://localhost/cbp/Approved.php, cancelURL=http://localhost/cbp/Cancelled.php, declineURL=http://localhost/cbp/Declined.php]
		return order.toString();
	}
	@RequestMapping("/orderui")
	//@RequestMapping(value = "/orderui", method = RequestMethod.GET)
	public String orderuiGet() {
		return "orderui";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/orderuiencode", method = RequestMethod.POST, 
	consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
	produces = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String orderuiPostEncoded(String message) {
		
		System.out.println("execute" + message);
		return message;
	}

}
