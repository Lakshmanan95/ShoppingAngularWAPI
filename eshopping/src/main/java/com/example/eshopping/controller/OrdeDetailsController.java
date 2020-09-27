package com.example.eshopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eshopping.common.CommonConstant;
import com.example.eshopping.entity.Cart;
import com.example.eshopping.entity.OrderDetails;
import com.example.eshopping.entity.OrderMaster;
import com.example.eshopping.entity.Product;
import com.example.eshopping.model.order.OrderFinal;
import com.example.eshopping.model.order.OrderRequest;
import com.example.eshopping.model.order.OrderResponse;
import com.example.eshopping.service.OrderDetailService;
import com.example.eshopping.service.ProductService;
import com.example.eshopping.util.DateTimeUtil;
import com.example.eshopping.util.EshoppingLogger;


@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrdeDetailsController {

	@Autowired
	OrderDetailService orderDetailService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/saveOrder")
	public OrderResponse saveOrder(@RequestBody OrderRequest request) {
		OrderResponse response = new OrderResponse();
		try {
			OrderMaster orderMaster = new OrderMaster();
			orderMaster.setOrderedDate(DateTimeUtil.getTodayString());
			orderMaster.setOrderStatus(CommonConstant.STATUS_PENDING);
			orderMaster.setPaymentMethod(request.getOrder().getPaymentMethod());
			orderMaster.setUserId(request.getOrder().getUserId());
			orderMaster.setCustomerName(request.getOrder().getCustomerName());
			orderMaster.setAddress(request.getOrder().getAddress());
			orderMaster.setCity(request.getOrder().getCity());
			orderMaster.setState(request.getOrder().getState());
			orderMaster.setCountry(request.getOrder().getCountry());
			orderMaster.setZipCode(request.getOrder().getZipCode());
			orderMaster.setEmail(request.getOrder().getEmail());
			orderMaster.setPhoneNumber(request.getOrder().getPhoneNumber());
			orderMaster = orderDetailService.saveOrderMaster(orderMaster);
			double totalPrice = 0;
			for(Cart cart : request.getCart()) {
				OrderDetails order = new OrderDetails();
				Product product = productService.getProductById(cart.getProductId());
				order.setOrderId(orderMaster.getId());
				order.setProductId(cart.getProductId());
				order.setProductName(cart.getProductName());
				double price = product.getPrice() * cart.getQuantity();
				order.setPrice(Math.round(price * 100.0)/100.0);
				order.setQuantity(cart.getQuantity());
				totalPrice+=price;
				orderDetailService.saveOrder(order);
			}
			orderMaster.setTotalPrice(totalPrice);
			orderDetailService.saveOrderMaster(orderMaster);		
		}
		catch(Exception e) {
			System.out.println(e);
			EshoppingLogger.logError(getClass(), "Order Failed", e);
			response.setErrorCode("101");
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	}
	
	@GetMapping("/getOrderList")
	public OrderResponse getOrderList() {
		OrderResponse response = new OrderResponse();
		try {
			List<OrderDetails> orders = orderDetailService.getOrders();
			response.setOrdersList(orders);
		}
		catch(Exception e) {
			System.out.println(e);
			EshoppingLogger.logError(getClass(), "Order List Failed", e);
			response.setErrorCode("101");
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	}
	
	@PostMapping("/getUsersOrder")
	public OrderResponse getOrderListByUserId(@RequestBody OrderRequest request) {
		OrderResponse response = new OrderResponse();
		try {
			List<OrderFinal> orderFinal = new ArrayList<>();
			List<OrderMaster> orderMaster = orderDetailService.getOrderMasterByUserId(request.getUserId());
			for(OrderMaster order : orderMaster) {
				OrderFinal finalorder = new OrderFinal();
				List<OrderDetails> orderDetails = orderDetailService.getOrderDetailsByOrderId(order.getId());
				finalorder.setOrderDetails(orderDetails);
				finalorder.setOrderMaster(order);
				orderFinal.add(finalorder);
			}
			
			response.setOrderFinal(orderFinal);
		}
		catch(Exception e) {
			System.out.println(e);
			EshoppingLogger.logError(getClass(), "Order List by user Failed", e);
			response.setErrorCode("101");
			response.setStatus(CommonConstant.ERROR);
		}
		return response;
	}
	
	
	@PostMapping("/updateOrder")
	public OrderResponse updateOrder(@RequestBody OrderRequest request) {
		OrderResponse response = new OrderResponse();
		try {
			OrderMaster order = orderDetailService.getOrderById(request.getOrder().getId());
			if(order == null) {
				response.setErrorCode("102");
				response.setStatus(CommonConstant.ERROR);
				response.setMessage("Order Not Found");
				return response;
			}
			order.setOrderStatus(request.getOrder().getOrderStatus());
			orderDetailService.saveOrderMaster(order);
		}
		catch(Exception e) {
			response.setErrorCode("101");
			response.setStatus(CommonConstant.ERROR);
			response.setMessage("Update Order Failed");
			return response;
		}
		return response;
	}
	
	
}
