package west2_milkteashop;

import java.util.Calendar;

abstract class Ingredient {
	protected String name;
	protected int days;//������
	protected Calendar date = Calendar.getInstance();//��������
	
	public Ingredient() {
	}
	public abstract String toString();
}