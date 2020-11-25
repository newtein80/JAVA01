package pattern.decorator2;

public class ImprovedAttackBot implements IBot {

    IBot bot;

    public ImprovedAttackBot(IBot iBot) {
        this.bot = iBot;
    }

    @Override
    public void currentStatus() {
        this.bot.currentStatus();
    }

    @Override
    public void chargeEnergy(int energy) {
        this.bot.chargeEnergy(energy);
    }

    @Override
    public int attack() {
        return this.bot.attack() * 2;
    }

    @Override
    public void downHp(int attack) {
        this.bot.downHp(attack);
    }

    @Override
    public void run(int speedup) {
        this.bot.run(speedup);
    }
    
}
