package pattern.factory;

public class Bmw5Series implements ICar{

    @Override
    public void run() {
        System.out.println("5 Series Run~");
    }

    @Override
    public void stop() {
        System.out.println("5 Series Stop!");
    }

    @Override
    public void alert() {
        System.out.println("5 Series Alert!");
    }

}
