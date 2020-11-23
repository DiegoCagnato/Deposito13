package eshop3;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import daoservices.CategoryDaoService;
import daoservices.ProductDaoService;
import daoservices.UserDaoService;
import entity.Category;
import entity.Product;
import entity.User;
import hibernateutil.HibernateUtil;
import services.CartService;

public class EShop3 {

	public static void main(String[] args) {
		
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		
		Category caffetteria = new Category("ca", "caffetteria");
		Category piante = new Category("pi", "piante");
		Category telefoni = new Category("te", "telefoni");
		
		//CategoryDaoService cds = new CategoryDaoService();
		CategoryDaoService cds = container.select(CategoryDaoService.class).get();
		
		cds.insert(caffetteria);
		cds.insert(piante);
		cds.insert(telefoni);
		
		Product tazzine = new Product("ca001", caffetteria, "tazzine pregiate", 40, "tazzine");
		Product moka = new Product("ca002", caffetteria, "moka Bialetti", 20, "moka");
		Product cactus = new Product("pi001", piante, "cactus pungente", 35, "cactus");
		Product baobab = new Product("pi002", piante, "baobab gigante", 50, "baobab");
		Product nokia3310 = new Product("te001", telefoni, "telefono antico", 15, "nokia 3310");
		Product IPhone = new Product("te002", telefoni, "telefono moderno", 100, "iPhone");
		
		//ProductDaoService pds = new ProductDaoService();
		ProductDaoService pds = container.select(ProductDaoService.class).get();
		
		pds.insert(tazzine);
		pds.insert(moka);
		pds.insert(cactus);
		pds.insert(baobab);
		pds.insert(nokia3310);
		pds.insert(IPhone);
		
		User giovanni = new User("jhonny", "Giovanni");
		User maria= new User("mary", "Maria");
		User roberto = new User("bob", "Roberto");
		
		//UserDaoService uds = new UserDaoService();
		UserDaoService uds = container.select(UserDaoService.class).get();
		
		uds.insert(giovanni);
		uds.insert(maria);
		uds.insert(roberto);
		
		CartService cart = new CartService(1, maria);
		
		cart.getProductIntoCart(cactus);
		cart.getProductIntoCart(moka);
		cart.getProductIntoCart(baobab);
		
		cart.printCartProduct();
		cart.purchaseCart();
		
		HibernateUtil.closeEMF();
		
		container.shutdown();

	}

}
