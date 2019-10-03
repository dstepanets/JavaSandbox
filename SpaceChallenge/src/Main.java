import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {

		Simulation sim = new Simulation();
//		sim.printItems();

		System.out.println("\tCARGO LOADING...\n");
		ArrayList<U1> U1Fleet = sim.loadU1();
		ArrayList<U2> U2Fleet = sim.loadU2();

		System.out.println("\n\tU1 SIMULATIONS START...");
		System.out.println("<[CARGO WAS LOADED ON " + U1Fleet.size() + " U1 ROCKETS]>");
		System.out.format("Estimated budget for U1 missions: %,d\n", sim.runSimulation(U1Fleet));

		System.out.println("\n\tU2 SIMULATIONS START...");
		System.out.println("<[CARGO WAS LOADED ON " + U2Fleet.size() + " U2 ROCKETS]>");
		System.out.format("Estimated budget for U2 missions: %,d\n", sim.runSimulation(U2Fleet));

	}
}
