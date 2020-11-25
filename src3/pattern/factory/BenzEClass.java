package pattern.factory;

public class BenzEClass implements ICar{

    @Override
    public void run() {
        System.out.println("E Class Run~");
    }

    @Override
    public void stop() {
        System.out.println("E Class Stop!");
    }

    @Override
    public void alert() {
        System.out.println("E Class Alert!");
    }
    
}
