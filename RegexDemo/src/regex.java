import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {

	public String inputName() {
		String name;
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("K�rem adja meg a nev�t: ");
			name = scan.nextLine();
		}
		return name;
	}

	public boolean regex1(String name) {
		String validRegex = "([A-Z���������][a-z���������]+) {1,2}[A-Z���������][a-z���������]+";
		Pattern pattern = Pattern.compile(validRegex);
		Matcher matcher = pattern.matcher(name);
		return matcher.find();
	}

	public void valid(boolean regex1) {
		if (regex1) {
			System.out.println("Helyes");
		} else {
			System.out.println("Helytelen");
		}
	}
}
