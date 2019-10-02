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
		System.out.println(crashChance);
		return (crashChance >= Math.random());

	}

	@Override
	public boolean land() {
		double crashChance = 0.08 * (cargoCarried / cargoLimit);
		System.out.println(crashChance);
		return (crashChance >= Math.random());
	}
}
