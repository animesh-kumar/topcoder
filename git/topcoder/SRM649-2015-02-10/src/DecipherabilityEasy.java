import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A brute force approach to check SRM 649 - 250
 * 
 * @author animesh-kumar
 *
 */
public class DecipherabilityEasy {

	public String check(String s, String t) {
		// For t to differ from s by exactly one character, it can't have any
		// other length other that length of s -1
		if (s.length() != t.length() + 1) {
			return "Impossible";
		} else {
			boolean possible = false;
			// Remove each character from s and check if it's equal to t
			for (int i = 0; i < s.length(); i++) {
				String newString = s.substring(0, i)
						+ s.substring(i + 1, s.length());
				if (newString.equals(t)) {
					possible = true;
				}
			}
			if (possible) {
				return "Possible";
			}
		}
		return "Impossible";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		OutputStreamWriter os = new OutputStreamWriter(System.out);
		PrintWriter pw = new PrintWriter(os);
		// Get the number of test cases
		int n = in.nextInt();
		DecipherabilityEasy d = new DecipherabilityEasy();
		for (int i = 0; i < n; i++) {
			String s = in.next();
			String t = in.next();
			pw.println(d.check(s, t));
		}
		pw.close();
		in.close();
	}

}