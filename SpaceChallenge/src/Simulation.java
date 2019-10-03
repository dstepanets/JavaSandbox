import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

	private ArrayList<Item> items;

	Simulation() {
		items = new ArrayList<>();
		items = loadItems("resources/phase-1.txt");
		items = loadItems("resources/phase-2.txt");
	}

	public ArrayList<Item> loadItems(String filePath) {

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

	public ArrayList<U1> loadU1() {

		ArrayList<U1> U1Fleet = new ArrayList<>();

		U1 rocket = new U1();
		for (int i = 0; i < items.size(); ) {
			if (rocket.canCarry(items.get(i))) {
				System.out.println("U1 #" + (U1Fleet.size() + 1) + ": " + items.get(i).getName() + "=" + items.get(i).getWeight());
				rocket.carry(items.get(i++));
			} else {
				U1Fleet.add((rocket));
				System.out.println(">> Rocket U1 #" + U1Fleet.size() + " is loaded with " + rocket.cargoCarried + "kg");
				rocket = new U1();
			}
		}
		if (!U1Fleet.contains(rocket)) {
			U1Fleet.add((rocket));
			System.out.println(">> Rocket U1 #" + U1Fleet.size() + " is loaded with " + rocket.cargoCarried + "kg");
		}
		return U1Fleet;
	}

	public ArrayList<U2> loadU2() {

		ArrayList<U2> U2Fleet = new ArrayList<>();

		U2 rocket = new U2();
		for (int i = 0; i < items.size(); ) {
			if (rocket.canCarry(items.get(i))) {
				System.out.println("U2 #" + (U2Fleet.size() + 1) + ": " + items.get(i).getName() + "=" + items.get(i).getWeight());
				rocket.carry(items.get(i++));
			} else {
				U2Fleet.add((rocket));
				System.out.println(">> Rocket U2 #" + U2Fleet.size() + " is loaded with " + rocket.cargoCarried + "kg");
				rocket = new U2();
			}
		}
		if (!U2Fleet.contains(rocket)) {
			U2Fleet.add((rocket));
			System.out.println(">> Rocket U2 #" + U2Fleet.size() + " is loaded with " + rocket.cargoCarried + "kg");
		}
		return U2Fleet;
	}

	public int runSimulation(ArrayList<? extends Rocket> fleet) {

		int	budget = 0, mission = 0;
		boolean launch = false, land = false;

		for (Rocket r : fleet) {
			do {
				mission++;
				budget += r.cost;
				launch = r.launch();
				if (!launch) {
					System.out.println("!!! Rocket #" + mission + " crashed on launch");
					continue;
				}
				land = r.land();
				if (!land) {
					System.out.println("!!! Rocket #" + mission + " crashed on landing");
					continue;
				}
			} while (!launch || !land);
			System.out.println("Mission #" + mission + " success!");
		}
		System.out.println(mission - fleet.size() + " rocket(s) were lost.");
		return budget;
	}

	//	DEBUGGING
	public void printItems() {
		for (Item i : items) {
			System.out.println(i.getName() + "=" + i.getWeight());
		}
	}
}
