import java.util.Scanner;

public class 寻找奇数 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count  = scanner.nextInt();
		int arr[] = new int[count];
		for (int i = 0; i < count; i++) {
			arr[i] = scanner.nextInt();
		}
		int temp = arr[0];
		for (int i = 0; i < count; i++) {
			temp = temp & arr[i];
		}
		System.out.println(temp);
	}
}
