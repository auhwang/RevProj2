package maverick.ogs.service;

import java.util.List;
import java.util.UUID;

import maverick.ogs.beans.Files;
import maverick.ogs.beans.Item;
import maverick.ogs.dao.FileDAO;
import maverick.ogs.dao.FileDAOImpl;
import maverick.ogs.dao.ItemDAO;
import maverick.ogs.dao.ItemDAOImpl;

public class ItemService {

	public static void insertNewItem(Item item, String fileKey) {
		ItemDAO itemDao = new ItemDAOImpl();
		FileDAO fileDao = new FileDAOImpl();
		String itemid = UUID.randomUUID().toString();
		item.setItemId(itemid);
		item.setAccountId(UserService.getUserById(item.getAccountId().getAccountId()));
		Files file = new Files(fileKey);
		String fileid = fileDao.insertFile(file);
		file = fileDao.getFileById(fileid);
		item.setItemFile(file);
		itemDao.insertItem(item);
	}
	
	public static List<Item> getItemsForSale(){
		ItemDAO itemDao = new ItemDAOImpl();
		return itemDao.getAllItemsForSale();
	}
}
