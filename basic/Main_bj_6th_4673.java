package basic;


public class Main_bj_6th_4673 {
	public static int[] arr = new int[10000];
	public static void main(String[] args) {
		for(int i =0 ; i < arr.length ; i++) {
			self_number(i+1);
		}
		for(int i= 0 ; i< arr.length-1 ; i++) {
			if(arr[i] == 0) System.out.println(i+1);
		}
	}
	
	public static void self_number(int n){
		int dn = n;
		while(n>0) {
			dn += n%10;
			n /= 10;
		}
		if(dn < 10000) {
			arr[dn-1] ++;
		}
	}
}
