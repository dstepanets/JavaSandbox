import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

	private ArrayList<Item> itemsPhase1;
	private ArrayList<Item> itemsPhase2;

	Simulation() {
		itemsPhase1 = loadItems("resources/phase-1.txt");
		itemsPhase2 = loadItems("resources/phase-2.txt");
	}

	public ArrayList<Item> loadItems(String filePath) {

		ArrayList<Item> items = new ArrayList<>();

		try {
			Scanner scanner = new Scanner(new File(filePath));
			while (scanner.hasNextLine()) {
				String str[] = scanner.nextLine().split("=");
				items.add(new Item(str[0], Integer.parseInt(str[1])));
			}
		} catch (FileNotFoundException e) {
			System.err.println("ERROR. File \'" + filePath + "\' is not found.");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("ERROR. File \'" + filePath + "\' has wrong lines format.");
		}
		return items;
	}

//	debugging
	public void printItems() {
		for (Item i : itemsPhase1) {
			System.out.println(i.getName() + "=" + i.getWeight());
		}
		for (Item i : itemsPhase2) {
			System.out.println(i.getName() + "=" + i.getWeight());
		}
	}

}
