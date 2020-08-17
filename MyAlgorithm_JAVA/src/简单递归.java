import java.util.Scanner;import javax.security.auth.kerberos.KerberosKey;

public class 简单递归 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int i = simple(100);
//		System.out.println(i);
		Scanner scanner = new Scanner(System.in);
//		int n = scanner.nextInt();
//		int m = scanner.nextInt();
//		int k = nTom(n, m);
//		System.out.println(k);
		
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int k = nTom(n, m);
		System.out.println(k);
	}
	
	//从1到100
	public static int simple(int k) {
		if (k == 1) {
			return 1;
		}else {
			return simple(k-1)+k;
		}
	}
	
	//从n到m
	public static int nTom(int n, int m) {
		int count = 0;
		if (n > m) {
			count = -1;
		}
		if (n == m) {
			count = n;
		}else {
			count = nTom(n, m-1) + m;
		}
		return count;
	}
	
	//使用递归，计算从 n，n+t, n+2t, .... n+ mt 的值(m >=1)
	public static int nTomt(int n, int t, int m) {
		int count = 0;
		if (t == 0) {
			count = n;
		}else {
			//t如果为1，就是从n到m的值
			if (t == 1) {
				if (n > m) {
					count = -1;
				}
				if (n == m) {
					count = n;
				}else {
					count = nTom(n, m-1) + m;
				}
			}else {
				//t > 1
				if (n > m) {
					count = -1;
				}
				if (n == m) {
					count = n;
				}else {
					count = nTom(n, m-1) + m*t;
				}
			}
		}
		return count;
	}
}
