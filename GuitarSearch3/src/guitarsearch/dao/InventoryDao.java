package guitarsearch.dao;

import java.util.List;

import guitarsearch.domain.Guitar;
import guitarsearch.domain.GuitarSpec;

public interface InventoryDao {
	// 添加guitar
	public abstract boolean addGuitar(String serialNumber, double price, GuitarSpec spec);
	
	// 删除guitar
	public abstract boolean deleteGuitar(String serialNumber);
	
	// 更新guitar
	public abstract boolean updateGuitar(String serialNumber,double price, GuitarSpec spec);
	
	// 获取所有guitar
	public abstract List<Guitar> getAllGuitars();
	
	// 搜索符合的guitar
	public abstract List<Guitar> searchGuitar(GuitarSpec searchGuitar);
}
