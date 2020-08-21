import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 寻找奇数 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int res = 0;
		String[] strings = bf.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			res = res ^ Integer.parseInt(strings[i]);
		}
		System.out.println(res);
	}
}
