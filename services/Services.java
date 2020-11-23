package services;

public interface Services<T> {

	public void findAndPrint(T object, String idObject);
	
	public void findAndModify(T object, String idObject, String objectName, 
			Integer price, String description);
	
	public void printAll();
}
