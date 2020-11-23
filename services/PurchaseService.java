package services;



import javax.inject.Inject;

import daoservices.CategoryDaoService;
import daoservices.ProductDaoService;
import daoservices.PurchaseDaoService;
import entity.Product;
import entity.Purchase;
import entity.User;


public class PurchaseService {
	
	@Inject
	private CategoryDaoService categoryDao;
	
	@Inject
	private ProductDaoService productDao;
	
	@Inject
	private PurchaseDaoService purchaseDao;
	
	//private User user;
	
	//private Integer idCart;
	
	/*public PurchaseService(Integer idCart, User user){
		
		//categoryDao = new CategoryDaoService();
		//productDao = new ProductDaoService();
		//purchaseDao = new PurchaseDaoService();
		this.user = user;
		this.idCart = idCart;
	}*/
	
	public void purchase(Product product, String idProduct, User user, Integer idCart){
		
		Product p = productDao.getById(product, idProduct);
		if(p.getCategory().getNProduct() == 1){
			
			Purchase purchase = new Purchase(idCart, user, p);
			purchaseDao.insert(purchase);
			productDao.cancel(p, p.getIdProduct());
			categoryDao.cancel(p.getCategory(), p.getCategory().getIdCategory());
		}
		else{
			
			categoryDao.updateCategoryNProductAfterPurchase(p.getCategory(), p.getCategory().getIdCategory());
		    Purchase purchase = new Purchase(idCart, user, p);
			purchaseDao.insert(purchase);
			productDao.cancel(p, p.getIdProduct());
		}
	}

}
