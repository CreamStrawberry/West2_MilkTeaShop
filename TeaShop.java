package west2_milkteashop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public  class TeaShop implements Shop{
	private List<Bubble> BubbleList = new ArrayList<Bubble>();
	private List<Cocount> CocountList = new ArrayList<Cocount>();
	private List<MilkTea> MilkTeaList = new ArrayList<MilkTea>();
	int count = 0;
	
	//����
	private void stockBubble(Bubble Bub) {
		BubbleList.add(Bub);
		System.out.println("����һ������");
	}
	private void stockCocount(Cocount coc) {
		CocountList.add(coc);
		System.out.println("����һ��Ҭ��");
	}
	public void stock(Ingredient Ing) {
		if(Ing instanceof Bubble) {
			stockBubble((Bubble)Ing);
		}
		if(Ing instanceof Cocount) {
			stockCocount((Cocount)Ing);
		}
	}
	
	//������ϣ�����
	public void addIngredient(String name) {
		count++;
		String teaName = "MilkTea"+count;
		MilkTea tea = new MilkTea(teaName,name);
		MilkTeaList.add(tea);
	}
	//����
	public void Making(String IngName) throws SoldOutException{
		if(IngName.equals(Bubble.name)) {
			if(BubbleList.size()!=0) {
				while(BubbleList.get(0).isOutOfDays())
					BubbleList.remove(0);
			}
			if(BubbleList.size()==0) {
				System.out.println("����������");
				throw new SoldOutException();
			}
			addIngredient(IngName);
			System.out.println("�����̲����");
			BubbleList.remove(0);
		}
		if(IngName.equals(Cocount.name)) {
			if(CocountList.size()!=0) {
				while(CocountList.get(0).isOutOfDays())
					CocountList.remove(0);
			}
			if(CocountList.size()==0) {
				System.out.println("Ҭ��������");
				throw new SoldOutException();
			}
			addIngredient(IngName);
			System.out.println("Ҭ���̲����");
			CocountList.remove(0);
		}
	}
	
	
	//�����̲�
	public void soldMilkTea(String TeaName,String IngName) {
		if(MilkTeaList.size()==0) {
			System.out.println(TeaName+"�޷�����");
			return;
		}
		Iterator<MilkTea> it=MilkTeaList.iterator();
		 while(it.hasNext()){
			 	MilkTea tea=it.next();
	            if (tea.name.equals(TeaName)&&tea.IngName.equals(IngName)) {
	                it.remove();
	                System.out.println("�ɹ��۳�һ��"+TeaName+"�̲�");
	            }
	        }
		/*for(MilkTea tea : MilkTeaList) {
			if(tea.name.equals(TeaName)&&tea.IngName.equals(IngName)) {
				MilkTeaList.remove(tea);
				System.out.println("�ɹ��۳�һ��"+TeaName+"�̲�");
			}
		}*/
	}
}
