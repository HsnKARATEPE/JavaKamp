package sayiBulma;

public class Main {

	public static void main(String[] args) {
		int[] sayilar=new int[] {1,5,7,9,0};
		int aranacak=8;
		boolean durum=false;
		
		
		for(int sayi:sayilar) {
			if(sayi==aranacak) {
				durum=true;
				break;
				
			}
			
		}
		if (durum) {
			System.out.println("Sayı var");
		}else {
			System.out.println("Sayı yok");
		
		}
	}

}
