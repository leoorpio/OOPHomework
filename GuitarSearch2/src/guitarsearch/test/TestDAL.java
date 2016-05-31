package guitarsearch.test;

import java.util.Iterator;
import java.util.List;

import guitarsearch.dao.InventoryDao;
import guitarsearch.daoImpl.InventoryDaoImpl;
import guitarsearch.domain.Guitar;

public class TestDAL {
	public static void main(String[] args) {
		InventoryDao inv = new InventoryDaoImpl();
		List<Guitar> guitars = inv.getAllGuitars();
		for(Iterator<Guitar> i = guitars.iterator(); i.hasNext();) {
			Guitar guitar = i.next();
			System.out.print(guitar.getSpec().getBuilder() + "\t");
			System.out.print(guitar.getSpec().getType() + "\t");
			System.out.print(guitar.getSpec().getBackWood() + "\t");
			System.out.println(guitar.getSpec().getTopWood());
		}
		System.out.println(guitars);
	}
}
