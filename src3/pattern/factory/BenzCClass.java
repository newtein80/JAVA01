package pattern.factory;

public class BenzCClass implements ICar{

    @Override
    public void run() {
        System.out.println("C Class Run~");
    }

    @Override
    public void stop() {
        System.out.println("C Class Stop!");
    }

    @Override
    public void alert() {
        System.out.println("C Class Alert!");
    }
    
}
