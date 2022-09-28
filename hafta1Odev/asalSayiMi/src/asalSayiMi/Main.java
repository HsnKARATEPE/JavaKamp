package asalSayiMi;

public class Main {

	public static void main(String[] args) {
		int number=-9;
		int remainder=number%2;
		boolean mesaj=true;
		 
		
		if(number==1) {
			System.out.println("Sayı Asal Değildir");
			return;
		}
		if (number<1) {
			System.out.println("Geçersiz Sayı");
		}
		
		for(int i=2;i<number;i++) {
			if (number%i==0) {
				mesaj=false;
				break;
				
			}
		
		}
		if(mesaj) {
			System.out.println("Sayı asal değildir");
		}else {
			System.out.println("Sayı asaldır");

		}
		

	}

}
