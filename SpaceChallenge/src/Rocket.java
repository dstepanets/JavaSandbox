public class Rocket implements SpaceShip {

	protected int cost;
	protected int rocketWeight;
	protected int maxWeight;
	protected int cargoCarried;
	protected int cargoLimit;

	public boolean	launch() {
		return true;
	}

	public boolean	land() {
		return true;
	}

	public boolean	canCarry(Item item) {
		return ((cargoCarried + item.getWeight()) <= cargoLimit);
	}

	public void	carry(Item item) {
		cargoCarried += item.getWeight();
	}

}
