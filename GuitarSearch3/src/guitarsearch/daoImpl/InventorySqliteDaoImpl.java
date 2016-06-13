package guitarsearch.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import guitarsearch.dao.InventoryDao;
import guitarsearch.domain.Builder;
import guitarsearch.domain.DBUtil;
import guitarsearch.domain.Guitar;
import guitarsearch.domain.GuitarSpec;
import guitarsearch.domain.Type;
import guitarsearch.domain.Wood;

public class InventorySqliteDaoImpl implements InventoryDao {

	@Override
	public boolean addGuitar(String serialNumber, double price, GuitarSpec spec) {
		int i = 0;
		Connection conn = DBUtil.getSqliteConn();
		PreparedStatement pstmt = null;
		String sql = "insert into Inventory(serialNumber, price, builder, model, type, numStrings, backWood, topWood) values(?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serialNumber);
			pstmt.setDouble(2, price);
			pstmt.setString(3, spec.getBuilder().toString());
			pstmt.setString(4, spec.getModel());
			pstmt.setString(5, spec.getType().toString());
			pstmt.setInt(6, spec.getNumStrings());
			pstmt.setString(7, spec.getBackWood().toString());
			pstmt.setString(8, spec.getTopWood().toString());
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i>0;
	}

	@Override
	public boolean deleteGuitar(String serialNumber) {
		int i = 0;
		Connection conn = DBUtil.getSqliteConn();
		String sql = "Delete From Inventory Where serialNumber = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, serialNumber);
			i = pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i > 0;
	}

	@Override
	public boolean updateGuitar(String serialNumber, double price, GuitarSpec spec) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Guitar> getAllGuitars() {
		List<Guitar> guitars = new LinkedList<Guitar>();
		Connection conn = DBUtil.getSqliteConn();
		PreparedStatement pstmt = null;
		String sql = "select * from Inventory";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String serialNumber = rs.getString("serialNumber");
				Double price = rs.getDouble("price");
				Builder builder = Builder.exchangeBuilder(rs.getString("builder"));
				String model = rs.getString("model");
				int numSprings = rs.getInt("numStrings");
				Type type = Type.exchangeType(rs.getString("type"));
				Wood backWood = Wood.exchangeWood(rs.getString("backWood"));
				Wood topWood = Wood.exchangeWood(rs.getString("topWood"));
				GuitarSpec spec = new GuitarSpec(builder, model, type, numSprings, backWood, topWood);
				Guitar guitar = new Guitar(serialNumber, price, spec);
				guitars.add(guitar);
			}
			conn.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return guitars;
	}

	@Override
	public List<Guitar> searchGuitar(GuitarSpec searchGuitar) {
		InventoryDao inve = new InventorySqliteDaoImpl();
		List<Guitar> guitars = inve.getAllGuitars();
	    List<Guitar> matchingGuitars = new LinkedList<Guitar>();
	    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
	      Guitar guitar = (Guitar)i.next();
	      if (guitar.getSpec().matches(searchGuitar))
	        matchingGuitars.add(guitar);
	    }
	    return matchingGuitars;
	}

}
