package guitarsearch.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import guitarseach.dao.InventoryDAO;
import guitarsearch.domain.Guitar;
import guitarsearch.domain.JdbcConn;

public class InventoryDaoImpl implements InventoryDAO{
	public  boolean addGuitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
		int i = 0;
		Connection conn = JdbcConn.getJdbcConn();
		PreparedStatement pstmt = null;
		String sql = "insert into Inventory(serialNumber, price, builder, model, type, backWood, topWood) values(?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serialNumber);
			pstmt.setDouble(2, price);
			pstmt.setString(3, builder);
			pstmt.setString(4, model);
			pstmt.setString(5, type);
			pstmt.setString(6, backWood);
			pstmt.setString(7, topWood);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i > 0;
	}
	public  boolean updateGuitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
		int i = 0;
		/**
		 * code
		 */
		return i > 0;		
	}
	
	public  boolean deleteGuitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
		int i = 0;
		/**
		 * code
		 */
		return i > 0;		
	}
	
	
	public  List<Guitar> getAllGuitars() {
		List<Guitar> guitars = new LinkedList<Guitar>();
		Connection conn = JdbcConn.getJdbcConn();
		ResultSet rs = null;
		String sql = "Select * From Inventory";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Guitar guitar = new Guitar(rs.getString("serialNumber"), rs.getDouble("price"), rs.getString("builder"),
						rs.getString("model"), rs.getString("type"), rs.getString("backWood"), rs.getString("topWood"));
				guitars.add(guitar);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return guitars;
	}
	
	public Guitar searchGuitar(Guitar searchGuitar){		
		InventoryDaoImpl inventory = new InventoryDaoImpl();
		List<Guitar> guitars= inventory.getAllGuitars();
	
	    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {	    	
	        Guitar guitar = (Guitar)i.next();        
	        String builder = searchGuitar.getBuilder();
	        if ((builder != null) && (!builder.equals("")) && (!builder.equals(guitar.getBuilder())))
	          continue;
	        return guitar;
	      }
	      return null;	
	}
}
