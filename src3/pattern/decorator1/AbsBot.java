package pattern.decorator1;

abstract public class AbsBot {
    abstract public void chargeEnergy(int energy);
    abstract public int attack();
    abstract public void downHp(int attack);
    abstract public void speedUp();
    abstract public void run();
    abstract public int getHp();
}
