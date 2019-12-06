package west2_milkteashop;

public interface Shop {
	void addIngredient(String name);
	void soldMilkTea(String TeaName,String IngName);
	void stock(Ingredient ing);
	void Making(String IngName) throws SoldOutException;
}
