package strings;

public class Main {

	public static void main(String[] args) {
		String mesaj="Bugün Hava Çok Güzel.";
		System.out.println(mesaj);
				
/*		
		System.out.println("Eleman Sayısı = "+mesaj.length());
		System.out.println("5. Eleman= "+mesaj.charAt(4));
		System.out.println("Birleştirme = "+mesaj.concat(" Yaşasın"));
		System.out.println("Ne ile Başlıyor= "+mesaj.startsWith("B"));
		System.out.println("Ne ile Bitiyor= "+mesaj.endsWith("."));
		
		char[]karakterler=new char[5];
		mesaj.getChars(0, 5, karakterler, 0);	//Başlangıç Karak.,Bitiş Karak.,
		System.out.println(karakterler);		//Nereye ata, kacından itibaren
			
		System.out.println("Baştan Kaçıncı Eleman= "+mesaj.indexOf('a'));
		System.out.println("Sondan Kaçıncı Eleman= "+mesaj.lastIndexOf('e'));
*/
		
		String yeniMesaj=mesaj.replace(' ', '-');
		System.out.println("Karakter Değiştirme= "+yeniMesaj);
		System.out.println("Metinden Parça Alma= "+mesaj.substring(2,4));
		//başlangıç index,bitiş index(dahil değil)
		
		
		//Metini Parçalara Ayırma
		for (String kelime:mesaj.split(" ")){//tek tırnak değil
			System.out.println(kelime);
		}
	
		System.out.println("Hepsi küçük harf ="+mesaj.toLowerCase());
		System.out.println("Hepsi büyük harf ="+mesaj.toUpperCase());

		String mesaj2="     Bugün hava çok güzelll      ";
	
		System.out.println("Başında ve sonundaki boşlukları atma ="+mesaj2.trim());


	}

}
