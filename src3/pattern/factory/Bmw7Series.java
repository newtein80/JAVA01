package pattern.factory;

public class Bmw7Series implements ICar{
    
    @Override
    public void run() {
        System.out.println("7 Series Run~");
    }

    @Override
    public void stop() {
        System.out.println("7 Series Stop!");
    }

    @Override
    public void alert() {
        System.out.println("7 Series Alert!");
    }

}
