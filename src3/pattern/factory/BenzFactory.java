package pattern.factory;

public class BenzFactory implements ICarFactory{

    @Override
    public ICar makeCar(String type) {
        if ("EClass".equals(type)) {
            return new BenzEClass();
        }
        else {
            return new BenzCClass();
        }
    }
    
}
