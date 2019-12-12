package dstepanets.orderbook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Input {

	static void parseInputFile(String path) {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String ln;
			while ((ln = br.readLine()) != null) {
				String[] command = ln.split(",");
				switch (command[0]) {
					case "u":
						parseUpdate(command);
						break;
					case "q":
						parseQuery(command);
						break;
					case "o":
						parseOrder(command);
						break;
					default:
						Output.logError();
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("Input file not found or can't be read.");
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void parseUpdate(String[] command) {
		for (String s : command) {
			System.out.print(s + ",");
		}
		System.out.println();

		if (command.length == 4) {
//			command[1];

		}

	}

	private static void parseQuery(String[] command) {
		for (String s : command) {
			System.out.print(s + ",");
		}
		System.out.println();
	}

	private static void parseOrder(String[] command) {
		for (String s : command) {
			System.out.print(s + ",");
		}
		System.out.println();
	}

}
