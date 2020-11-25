package pattern.factory;

public class BmwFactory implements ICarFactory{
    
    @Override
    public ICar makeCar(String type) {
        if ("7Series".equals(type)) {
            return new Bmw7Series();
        }
        else {
            return new Bmw5Series();
        }
    }

}
