package pattern.decorator2;

public interface IBot {
    public void currentStatus();
    public void chargeEnergy(int energy);
    public int attack();
    public void downHp(int attack);
    public void run(int speedup);
}
