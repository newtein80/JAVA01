package pattern.decorator2;

public class BasicBot extends AbsBot {

    @Override
    public int attack() {
        return attack;
    }

    @Override
    public void downHp(int attack) {
        hp -= attack;
    }

    @Override
    public void run(int speedup) {
        speed += speedup;
    }
    
}
