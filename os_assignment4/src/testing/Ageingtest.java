package testing;

public class Ageingtest {

	public static void main(String[] args) {
		
		int i = 2;
		int j = Integer.parseInt(Integer.toBinaryString(i<<1));
		System.out.println(Integer.toBinaryString(i>>1));
		System.out.println(j+1);

	}

}
