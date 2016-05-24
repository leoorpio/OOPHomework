package guitarseach.dao;

import java.util.List;

import guitarsearch.domain.*;

public interface InventoryDAO {

	// ����guitar ����
	public abstract boolean addGuitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood);
	
	// ����guitar ����
	public abstract boolean updateGuitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood);
	
	// ɾ��guitar ����
	public abstract boolean deleteGuitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood);
	
	// ȡ������guitar����
	public abstract List<Guitar> getAllGuitars();
	
	// ������������guitar
	public abstract Guitar searchGuitar(Guitar searchGuitar);
}
