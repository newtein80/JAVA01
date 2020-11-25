package pattern.decorator2;

public class BasicAdvancedBot extends AbsBot {

    @Override
    public int attack() {
        return attack * 3;
    }

    @Override
    public void downHp(int attack) {
        hp -= (attack * 0.2);
    }

    @Override
    public void run(int speedup) {
        speed += speedup;
    }
    
}
