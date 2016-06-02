package guitarsearch.domain;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import guitarsearch.dao.InventoryDao;
import guitarsearch.daoImpl.InventoryDaoImpl;

public class InitializeInventory {
	
	public static void main(String[] args) {
		creatTable();
		InventoryDao inventory = new InventoryDaoImpl();
		initialTable(inventory);
	}
	
	private static boolean creatTable() {
		int i = 0;
		Connection conn = JdbcConn.getJdbcConn();
		try {
			Statement stmt = conn.createStatement();
			String sql =  "CREATE TABLE Inventory " +
	                   "(serialNumber VARCHAR(50) PRIMARY KEY NOT NULL," +
	                   "builder VARCHAR(50) NOT NULL, " + 
	                   "model VARCHAR(50) NOT NULL, " + 
	                   "type VARCHAR(50) NOT NULL, " +
	                   "numStrings interger NOT NULL, " +
	                   "topWood VARCHAR(50) NOT NULL, " +
	                   "backWood VARCHAR(50) NOT NULL, " +
	                   "price Double(6,2) NOT NULL)"; 
			i = stmt.executeUpdate(sql);	// i = 0
			System.out.println(i);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i > 0;
	}
	
	private static void initialTable(InventoryDao inventory) {

	    inventory.addGuitar("11277", 3999.95, 
	    	      new GuitarSpec(Builder.COLLINGS, "CJ", Type.ACOUSTIC, 6,
	    	                     Wood.INDIAN_ROSEWOOD, Wood.SITKA));
	    	    inventory.addGuitar("V95693", 1499.95, 
	    	      new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6,
	    	                     Wood.ALDER, Wood.ALDER));
	    	    inventory.addGuitar("V9512", 1549.95, 
	    	      new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6,
	    	                     Wood.ALDER, Wood.ALDER));
	    	    inventory.addGuitar("122784", 5495.95, 
	    	      new GuitarSpec(Builder.MARTIN, "D-18", Type.ACOUSTIC, 6,
	    	                     Wood.MAHOGANY, Wood.ADIRONDACK));
	    	    inventory.addGuitar("76531", 6295.95, 
	    	      new GuitarSpec(Builder.MARTIN, "OM-28", Type.ACOUSTIC, 6,
	    	                     Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
	    	    inventory.addGuitar("70108276", 2295.95, 
	    	      new GuitarSpec(Builder.GIBSON, "Les Paul", Type.ELECTRIC, 6,
	    	                     Wood.MAHOGANY, Wood.MAHOGANY));
	    	    inventory.addGuitar("82765501", 1890.95, 
	    	      new GuitarSpec(Builder.GIBSON, "SG '61 Reissue", Type.ELECTRIC, 6,
	    	                     Wood.MAHOGANY, Wood.MAHOGANY));
	    	    inventory.addGuitar("77023", 6275.95, 
	    	      new GuitarSpec(Builder.MARTIN, "D-28", Type.ACOUSTIC, 6,
	    	                     Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
	    	    inventory.addGuitar("1092", 12995.95, 
	    	      new GuitarSpec(Builder.OLSON, "SJ", Type.ACOUSTIC, 12,
	    	                     Wood.INDIAN_ROSEWOOD, Wood.CEDAR));
	    	    inventory.addGuitar("566-62", 8999.95, 
	    	      new GuitarSpec(Builder.RYAN, "Cathedral", Type.ACOUSTIC, 12,
	    	                     Wood.COCOBOLO, Wood.CEDAR));
	    	    inventory.addGuitar("629584", 2100.95, 
	    	      new GuitarSpec(Builder.PRS, "Dave Navarro Signature", Type.ELECTRIC, 
	    	                     6, Wood.MAHOGANY, Wood.MAPLE));
	    	  }
}
