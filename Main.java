package west2_milkteashop;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Shop teashop = new TeaShop();
		int n=5;
		boolean flag=true;
		//进货
		Scanner scanner = new Scanner(System.in);
		while(flag) {
			String IngName = scanner.nextLine();
			if(IngName.equals(Bubble.name))  {
				Ingredient Ing = new Bubble();
				teashop.stock(Ing);
			}
			if(IngName.equals(Cocount.name)) {
				Ingredient Ing = new Cocount();
				teashop.stock(Ing);
			}
			n--;
			if(n==0) {
				flag = false;
			}
		}
		//制作
		try {
			teashop.Making("Bubble");
			teashop.Making("Cocount");
		}catch(SoldOutException e) {
			e.printStackTrace();
		}
		
		teashop.soldMilkTea("MilkTea1", "Bubble");
		teashop.soldMilkTea("MilkTea2", "Cocount");
		scanner.close();
	}
	
}
