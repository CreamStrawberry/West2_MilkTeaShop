package west2_milkteashop;

import java.util.Calendar;

public class Bubble extends Ingredient{
	final static String name = "Bubble";
	
	public Bubble() {
		super();
		this.days = 7;
		this.date.set(Calendar.YEAR, 2019);
		this.date.set(Calendar.MONTH,11);
		this.date.set(Calendar.DAY_OF_MONTH,1);
	}
	
	@Override
	public String toString() {
		return "Name: "+Bubble.name+'\n'+
				"Date of manufature: "+this.date+"\n"+
				"Expiration: "+this.days;
	}
	//ÊÇ·ñ¹ıÆÚ
	public boolean isOutOfDays() {
		Calendar cal = Calendar.getInstance();
		long time1 = cal.getTimeInMillis();
		long time2 = cal.getTimeInMillis();
		long dtime = (time1-time2)/(1000*60*60*24);
		if(dtime>days) return true;
		else return false;
	}

}