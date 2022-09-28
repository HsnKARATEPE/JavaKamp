package conditionals;

public class Main {

	public static void main(String[] args) {
		int sayi=19;
		
		if(sayi<20) {
			System.out.println("Sayı 20 den küçük");
		}
		
		if(sayi<15) {
			System.out.println("Sayı 15 den küçük");
		} else if(sayi==15) {
			System.out.println("Sayı 15 e eşittir.");
		}else {
			System.out.println("Sayı 15 den büyük");
		}

	}

}
