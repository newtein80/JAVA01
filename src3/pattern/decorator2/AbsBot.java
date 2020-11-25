package pattern.decorator2;

abstract public class AbsBot implements IBot{
    int energy = 0;
	int attack = 10;
	int hp = 100;
    int speed = 0;
    
    public void currentStatus() {
		System.out.println("hp:" + hp);
		System.out.println("speed:" + speed);
	}
	
	public void chargeEnergy(int energy) {
		this.energy += energy;
	}
}
