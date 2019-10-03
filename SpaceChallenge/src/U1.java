public class U1 extends Rocket {

	U1() {
		cost = 100_000_000;
		rocketWeight = 10_000;
		maxWeight = 18_000;
		cargoCarried = 0;
		cargoLimit = maxWeight - rocketWeight;
	}

	@Override
	public boolean launch() {
		double crashChance = 0.05 * (cargoCarried / cargoLimit);
		double ran = Math.random();
		System.out.println(String.format("%.2f/" + crashChance, ran));
		return (ran >= crashChance);

	}

	@Override
	public boolean land() {
		double crashChance = 0.01 * (cargoCarried / cargoLimit);
		double ran = Math.random();
		System.out.println(String.format("%.2f/" + crashChance, ran));
		return (ran >= crashChance);
	}
}
