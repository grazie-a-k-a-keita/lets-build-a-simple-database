package db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public void main() {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(isr);

			while (true) {
				System.out.print("db > ");
				String input = reader.readLine();

				if (input == null)
					break;

				if (input.equals(".exit"))
					break;

				System.out.println(String.format("Unrecognized command '%s'.", input));
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
