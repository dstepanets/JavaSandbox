public class U2 extends Rocket {

	U2() {
		cost = 120_000_000;
		rocketWeight = 18_000;
		maxWeight = 29_000;
		cargoCarried = 0;
		cargoLimit = maxWeight - rocketWeight;
	}

	@Override
	public boolean launch() {
		double crashChance = 0.04 * (cargoCarried / cargoLimit);
		double ran = Math.random();
		System.out.println(String.format("%.2f/" + crashChance, ran));
		return (ran >= crashChance);

	}

	@Override
	public boolean land() {
		double crashChance = 0.08 * (cargoCarried / cargoLimit);
		double ran = Math.random();
		System.out.println(String.format("%.2f/" + crashChance, ran));
		return (ran >= crashChance);
	}
}
