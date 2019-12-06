package west2_milkteashop;

import java.util.Calendar;

abstract class Ingredient {
	protected String name;
	protected int days;//保质期
	protected Calendar date = Calendar.getInstance();//生产日期
	
	public Ingredient() {
	}
	public abstract String toString();
}