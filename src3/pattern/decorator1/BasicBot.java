package pattern.decorator1;

public class BasicBot extends AbsBot{

    int energy;
    int attack = 5;
    int hp = 30;
    int speed = 50;

    @Override
    public void chargeEnergy(int energy) {
        this.energy += energy;
    }

    @Override
    public int attack() {
        return attack;
    }

    @Override
    public void downHp(int attack) {
        hp -= attack;
    }

    @Override
    public void speedUp() {
        speed += 5;
    }

    @Override
    public void run() {
        System.out.println("Run !! (Speed: " + speed + ")");
    }

    @Override
    public int getHp() {
        return hp;
    }
    
}
