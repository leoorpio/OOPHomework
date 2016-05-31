package guitarsearch.dao;

import java.util.List;

import guitarsearch.domain.Guitar;
import guitarsearch.domain.GuitarSpec;

public interface InventoryDao {
	// ���guitar
	public abstract boolean addGuitar(String serialNumber, double price, GuitarSpec spec);
	
	// ɾ��guitar
	public abstract boolean deleteGuitar(String serialNumber);
	
	// ����guitar
	public abstract boolean updateGuitar(String serialNumber,double price, GuitarSpec spec);
	
	// ��ȡ����guitar
	public abstract List<Guitar> getAllGuitars();
	
	// �������ϵ�guitar
	public abstract List<Guitar> searchGuitar(GuitarSpec searchGuitar);
}
