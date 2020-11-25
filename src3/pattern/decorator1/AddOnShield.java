package pattern.decorator1;

public class AddOnShield extends AbsBot {
    AbsBot targetBot;

    public AddOnShield(AbsBot absBot) {
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
        targetBot.downHp((int)(attack * 0.5));
    }

    @Override
    public void speedUp() {
        targetBot.speedUp();
    }

    @Override
    public void run() {
        targetBot.run();
    }

    @Override
    public int getHp() {
        return targetBot.getHp();
    }
}
