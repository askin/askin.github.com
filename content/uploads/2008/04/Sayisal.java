public class Sayisal {
	int[] _kupon = new int[6];
	int _num;
	public Sayisal(){
		int sira = 0;
		while (sira < 6) {
			_num = (int) (1 + Math.random() * 49);
			if (!varmi(_kupon, _num)) _kupon[sira++] = _num;
		}
	}
	
	private boolean varmi(int[] kupon, int num) {
		for (int x: kupon) {if (x == num) return true;}
		return false;
	}
	
	public String toString(){
		String kuponStr = "";
		for (int i = 0; i < 6; i++) kuponStr += (_kupon[i] + " ");
		return kuponStr;
	}
	
	public static void main(String[] args){
		byte kuponSayisi;
		if (args.length == 0) kuponSayisi = 1;
			else kuponSayisi = Byte.parseByte(args[0]);
			
		for (int i = 1; i <= kuponSayisi; i++){
			System.out.print(" " + i + ".kupon: ");
		System.out.println((new Sayisal()).toString());
		}
	}
}
		
			
				
