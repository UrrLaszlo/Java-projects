import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {

	public String inputName() {
		String name;
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Kérem adja meg a nevét: ");
			name = scan.nextLine();
		}
		return name;
	}

	public boolean regex1(String name) {
		String validRegex = "([A-ZÁÉÍÚÜÛÖÕÓ][a-záéíúüûöõó]+) {1,2}[A-ZÁÉÍÚÜÛÖÕÓ][a-záéíúüûöõó]+";
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
