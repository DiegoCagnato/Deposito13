package services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import entity.Product;
import entity.User;

public class CartService {

	private Set<Product> cart;
	private User user;
	private Integer idCart;
	
	public CartService(Integer idCart,User user){
		
		this.idCart = idCart;
		this.user = user;
		cart = new HashSet<>();
	}
	
	public void setUser(User user){
		
		this.user = user;
	}
	
	public User getUser(){
		
		return user;
	}
	
	public void getProductIntoCart(Product product){
		
		cart.add(product);
	}
	
	public void removeProductFromCart(Product product){
		
		cart.remove(product);
	}
	
	public void purchaseCart(){
		
		PurchaseService ps = new PurchaseService();
		for(Product product : cart){
			
			ps.purchase(product, product.getIdProduct(), user, idCart);
		}
	}
	
	public void printCartProduct(){
		
		ProductServicesImp psi = new ProductServicesImp();
		for(Product product : cart){
			
			psi.print(product);
		}
	}
}
