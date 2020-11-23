package services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import daoservices.ProductDaoService;
import entity.Product;

public class ProductServicesImp implements Services<Product> {
	
	@Inject
    private ProductDaoService productDao;
	
	/*public ProductServicesImp(){
		
		productDao = new ProductDaoService();
	}*/
	
	@Override
	public void findAndPrint(Product product, String idProduct){
		
		String id = (String) idProduct;
		Product p = productDao.getById(product, (String)id);
	    print(p);
	}
	
	@Override
    public void findAndModify(Product product, String idProduct, String productName, 
    		Integer price, String description){
		
		String id = (String) idProduct;
		String name = (String) productName;
		Product p = productDao.getById(product, id);
		productDao.cancel(product, id);
		p.setProductName(name);
		p.setPrice(price);
		p.setDescription(description);
		productDao.insert(p);
	}
	
	@Override
	public void printAll(){
		
		List<Product> products = new ArrayList<>();
		Product p = new Product();
		products = productDao.getAll(p);
		for(Product product : products){
			print(product);
		}
	}
	
	public void print(Product p){
		
		System.out.println("Prodotto: " + p.getProductName());
	    System.out.println("della categoria: " + p.getCategory().getCategoryName());
	    System.out.println("Prezzo: " + p.getPrice());
	    System.out.println("Descrizione: " + p.getDescription());
	    System.out.println("------------------------------------");
	}

}
