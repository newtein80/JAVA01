package pattern.decorator1;

public class AddOnFly extends AbsBot{
    AbsBot targetBot;

    public AddOnFly(AbsBot absBot) {
        this.targetBot = absBot;
    }

    @Override
    public void chargeEnergy(int energy) {
        targetBot.chargeEnergy(energy);
    }

    @Override
    public int attack() {
        return targetBot.attack();
    }

    @Override
    public void downHp(int attack) {
        targetBot.downHp(attack);
    }

    @Override
    public void speedUp() {
        targetBot.speedUp();
    }

    @Override
    public void run() {
        speedUp();
		speedUp();
		speedUp();
		speedUp();
		targetBot.run();
		System.out.println("하늘 난다.");
    }

    @Override
    public int getHp() {
        return targetBot.getHp();
    }
}
