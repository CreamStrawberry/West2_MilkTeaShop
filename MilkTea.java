package west2_milkteashop;

public class MilkTea {
	public String name;
	public Ingredient Ing;
	public String IngName;
	public MilkTea(String name1,String name2) {
		this.name = name1;
		this.IngName = name2;
	}
	@Override
	public String toString() {
		return  "MilkTea Name: "+this.name+'\n'+
				"Ingredient Name: "+this.Ing.name+'\n'+
				"Date of manufature: "+this.Ing.date+'\n'+
				"Expiration: "+this.Ing.days;
	}
}
