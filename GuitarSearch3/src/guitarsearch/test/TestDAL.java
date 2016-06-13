package guitarsearch.test;

import java.util.List;

import guitarsearch.dao.InventoryDao;
import guitarsearch.domain.DataAccess;
import guitarsearch.domain.Guitar;

public class TestDAL {
	public static void main(String[] args) {
		InventoryDao inv = DataAccess.createInventoryDao();
		List<Guitar> guitars = inv.getAllGuitars();
		for(Guitar g : guitars) {
			System.out.println(g.getPrice());
		}
	}
}
