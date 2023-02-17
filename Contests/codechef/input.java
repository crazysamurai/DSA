import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class test {
	public static void main(String[] args) {
		// loop till 't' items
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {

		t--;
		}

		// buffered reader
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(in);
		try {
			int num = Integer.parseInt(bf.readLine());
			System.out.println(num);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}