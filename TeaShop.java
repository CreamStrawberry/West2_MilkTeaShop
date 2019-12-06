package west2_milkteashop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public  class TeaShop implements Shop{
	private List<Bubble> BubbleList = new ArrayList<Bubble>();
	private List<Cocount> CocountList = new ArrayList<Cocount>();
	private List<MilkTea> MilkTeaList = new ArrayList<MilkTea>();
	int count = 0;
	
	//进货
	private void stockBubble(Bubble Bub) {
		BubbleList.add(Bub);
		System.out.println("进货一份珍珠");
	}
	private void stockCocount(Cocount coc) {
		CocountList.add(coc);
		System.out.println("进货一份椰果");
	}
	public void stock(Ingredient Ing) {
		if(Ing instanceof Bubble) {
			stockBubble((Bubble)Ing);
		}
		if(Ing instanceof Cocount) {
			stockCocount((Cocount)Ing);
		}
	}
	
	//添加配料（制作
	public void addIngredient(String name) {
		count++;
		String teaName = "MilkTea"+count;
		MilkTea tea = new MilkTea(teaName,name);
		MilkTeaList.add(tea);
	}
	//制作
	public void Making(String IngName) throws SoldOutException{
		if(IngName.equals(Bubble.name)) {
			if(BubbleList.size()!=0) {
				while(BubbleList.get(0).isOutOfDays())
					BubbleList.remove(0);
			}
			if(BubbleList.size()==0) {
				System.out.println("珍珠已用完");
				throw new SoldOutException();
			}
			addIngredient(IngName);
			System.out.println("珍珠奶茶完成");
			BubbleList.remove(0);
		}
		if(IngName.equals(Cocount.name)) {
			if(CocountList.size()!=0) {
				while(CocountList.get(0).isOutOfDays())
					CocountList.remove(0);
			}
			if(CocountList.size()==0) {
				System.out.println("椰果已用完");
				throw new SoldOutException();
			}
			addIngredient(IngName);
			System.out.println("椰果奶茶完成");
			CocountList.remove(0);
		}
	}
	
	
	//出售奶茶
	public void soldMilkTea(String TeaName,String IngName) {
		if(MilkTeaList.size()==0) {
			System.out.println(TeaName+"无法制作");
			return;
		}
		Iterator<MilkTea> it=MilkTeaList.iterator();
		 while(it.hasNext()){
			 	MilkTea tea=it.next();
	            if (tea.name.equals(TeaName)&&tea.IngName.equals(IngName)) {
	                it.remove();
	                System.out.println("成功售出一杯"+TeaName+"奶茶");
	            }
	        }
		/*for(MilkTea tea : MilkTeaList) {
			if(tea.name.equals(TeaName)&&tea.IngName.equals(IngName)) {
				MilkTeaList.remove(tea);
				System.out.println("成功售出一杯"+TeaName+"奶茶");
			}
		}*/
	}
}
