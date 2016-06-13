package guitarsearch.domain;

import guitarsearch.dao.InventoryDao;
import guitarsearch.daoImpl.InventoryMysqlDaoImpl;
import guitarsearch.daoImpl.InventorySqliteDaoImpl;

public class DataAccess {
		
		private static String db = "sqlite";
	
		public static InventoryDao createInventoryDao() {
			InventoryDao obj = null;
			switch (db) {
			case "sqlite":
				obj = new InventorySqliteDaoImpl();
				break;
			case "mysql":    
				obj = new InventoryMysqlDaoImpl();
				break;
			}
			return obj;
		}	
}
