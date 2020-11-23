package services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import daoservices.CategoryDaoService;
import entity.Category;

public class CategoryServicesImp implements Services<Category>{

	@Inject
	private CategoryDaoService categoryDao;
	
	/*public CategoryServicesImp(){
		
		categoryDao = new CategoryDaoService();
	}*/
	
	@Override
	public void findAndPrint(Category category, String id){
		
		Category c = categoryDao.getById(category, id);
	    print(c);
	}
	
	@Override
    public void findAndModify(Category category, String idCategory, String categoryName, 
    		 Integer none1,  String none2){
		
		String id = (String) idCategory;
		String name = (String) categoryName;
		Category c = categoryDao.getById(category, id);
		categoryDao.cancel(category, id);
		c.setCategoryName(name);
		categoryDao.insert(c);
	}
	
	public void printAll(){
		
		List<Category> categories = new ArrayList<>();
		Category c = new Category();
		categories = categoryDao.getAll(c);
		for (Category category : categories){
			print(category);
		}
	}
	
	public void print(Category c){
		
		System.out.println("Categoria: " + c.getCategoryName() + 
	    		". N° di pezzi: " + c.getNProduct());
	    System.out.println("-----------------------------");
	}

}
