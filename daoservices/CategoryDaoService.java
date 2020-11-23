package daoservices;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entity.Category;
import hibernateutil.HibernateUtil;

public class CategoryDaoService extends GenericDao<Category>{

	
    
    public void updateCategoryNProductAfterPurchase(Category object, String id){
    	
    	EntityManager em = HibernateUtil.getEM();
    	EntityTransaction et = em.getTransaction();
		et.begin();
		Category obj = em.find(Category.class, id);
		obj.setNProduct(obj.getNProduct()-1);
		et.commit();
		em.close();
    }
    
    
    
}
