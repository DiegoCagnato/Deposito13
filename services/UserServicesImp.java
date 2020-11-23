package services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import daoservices.UserDaoService;
import entity.User;


public class UserServicesImp implements Services<User> {

	    @Inject
	    private UserDaoService userDao;
		
		/*public UserServicesImp(){
			
			userDao = new UserDaoService();
		}*/
		
		@Override
		public void findAndPrint(User User, String idUser){
			
			String id = (String) idUser;
			User u = userDao.getById(User, (String)id);
		    print(u);
		}
		
		@Override
	    public void findAndModify(User User, String idUser, String UserName, 
	    		Integer none1, String none2){
			
			String id = (String) idUser;
			String name = (String) UserName;
			User u = userDao.getById(User, id);
			userDao.cancel(User, id);
			u.setName(name);
			userDao.insert(u);
		}
		
		public void printAll(){
			
			User u = new User();
			List<User> users = new ArrayList<>();
			users = userDao.getAll(u);
			for(User user : users){
				
				print(user);
			}
		}
		
		public void print(User u){
			
			System.out.println("Utente: " + u.getName());
		    System.out.println("------------------------------------");
		}
}
