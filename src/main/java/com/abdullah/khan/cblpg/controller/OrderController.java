package com.abdullah.khan.cblpg.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abdullah.khan.cblpg.model.Message;
import com.abdullah.khan.cblpg.model.Order;
import com.abdullah.khan.cblpg.model.Response;
import com.abdullah.khan.cblpg.model.Tkkpg;
import com.abdullah.khan.cblpg.service.OrderService;
import com.abdullah.khan.cblpg.service.RequestService;
import com.abdullah.khan.cblpg.service.ResponseService;
import com.abdullah.khan.cblpg.service.impl.RequestApplicationTypeTextByXml;
import com.abdullah.khan.cblpg.util.ContentTypeContext;
import com.abdullah.khan.cblpg.util.XmlUtil;

//https://stackoverflow.com/questions/17955777/redirect-to-an-external-url-from-controller-action-in-spring-mvc
//sandbox.thecitybank.com:5443/index.jsp?ORDERID=eouhsi2434&SESSIONID=deobdcmn328493
@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	RequestService requestService;
	
	@Autowired
	RequestApplicationTypeTextByXml requestApplicationTypeTextByXml;

	@Autowired
	ResponseService responseService;

	@Autowired
	XmlUtil xmlUtil;
	
	@Autowired
	ContentTypeContext contentTypeContext;

	// http://localhost:8080/orders
	@GetMapping("/orders")
	public List<Order> retrieveAllOrders() {
		return orderService.retrieveAllOrders();
	}

//	@RequestMapping("/to-be-redirected")
//	public ResponseEntity<Object> redirectToExternalUrl() throws URISyntaxException {
//		URI yahoo = new URI("http://www.yahoo.com");
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.setLocation(yahoo);
//		return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
//	}

	// http://localhost:8080/orders/1
	@GetMapping("/orders/{orderId}")
	public Order retriveDataildForOrder(@PathVariable String orderId) {
		return orderService.retrieveOrder(orderId);
	}

	// http://localhost:8080/orders
	@PostMapping("/orders")
	public ResponseEntity<String> addOrder(@RequestBody Tkkpg tkkpg) throws Exception {
		Order order = tkkpg.getRequest().getOrder();
		String objectToXml = xmlUtil.convertObjectToXml(tkkpg);
				
		//contentTypeContext.setRequestService(requestApplicationTypeTextByXml);
		//contentTypeContext.setRequestService(new RequestApplicationTypeUrlEncoded());
		//String xmlResponse = contentTypeContext.sendXmlRequest(objectToXml);
		
		String xmlResponse = requestService.sendXmlRequest(objectToXml);
		
		String filterXmlResponse = responseService.filterXmlResponse(xmlResponse);
		Response response = xmlUtil.convertXmlToTkkpgObject(filterXmlResponse);

		if (response == null)
			return ResponseEntity.noContent().build();

		order.setOrderID(response.getOrder().getOrderID());
		order.setSessionID(response.getOrder().getSessionID());
		String redirectUrl = redirectUrl(response);
		order.setuRL(redirectUrl);
		orderService.saveOrder(order);	
		return new ResponseEntity<>(redirectUrl, HttpStatus.OK);
	}
	
	private String redirectUrl(Response response) {
		String url = response.getOrder().getuRL();
		String orderId = response.getOrder().getOrderID();
		String sessionId = response.getOrder().getSessionID();
		return url + "?ORDERID=" + orderId + "&" + "SESSIONID=" + sessionId;
	}

	// http://localhost:8080/cancel
	@PostMapping("/cancel")
	public ResponseEntity<Order> cancelOrder(@RequestParam Map<String, String> params) throws Exception {
		String xmlmsg = params.get("xmlmsg");
		Message response = xmlUtil.convertXmlToMessageObject(xmlmsg);
		Order order = orderService.retrieveOrder(response.getOrderID());
		order.setOrderStatus(response.getOrderStatus());
		orderService.updateOrder(response.getOrderStatus(), response.getOrderID());
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	// http://localhost:8080/approve
	@PostMapping("/approve")
	public ResponseEntity<Order> approveOrder(@RequestParam Map<String, String> params) throws Exception {
		String xmlmsg = params.get("xmlmsg");
		Message response = xmlUtil.convertXmlToMessageObject(xmlmsg);
		Order order = orderService.retrieveOrder(response.getOrderID());
		order.setOrderStatus(response.getOrderStatus());
		orderService.updateOrder(response.getOrderStatus(), response.getOrderID());
		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	// http://localhost:8080/decline
	@GetMapping("/decline")
    public String declineOrder(){
        return "decline";
    }

	/***
	 * <tkkpg> <request> <language>EN</language> <order> <url/>
	 * <orderType>Purchase</orderType> <merchant>4545534</merchant>
	 * <amount>1</amount> <currency>050</currency> <description>Test
	 * Product</description>
	 * <approveURL>http://localhost/cbp/Approved.php</approveURL>
	 * <cancelURL>http://localhost/cbp/Cancelled.php</cancelURL>
	 * <declineURL>http://localhost/cbp/Declined.php</declineURL>
	 * <orderID/><oessionID/> </order> <operation>CreateOrder</operation> </request>
	 * </tkkpg>
	 **/
}
