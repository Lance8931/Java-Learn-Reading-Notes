import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class InputOutputTest {
	public static void main(String[] args) throws IOException {
		PrintWriter out = new PrintWriter(("E:\\GitHub\\Java-Learn-Reading-Notes\\txt\\myfile.txt"), "UTF-8");
		out.println("李锦欢");
		out.println(22);
		out.close();
		Scanner in = new Scanner(Paths.get("E:\\GitHub\\Java-Learn-Reading-Notes\\txt\\myfile.txt"), "UTF-8");
		String name = in.nextLine();
		int age = in.nextInt();
		System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
		in.close();
	}
}