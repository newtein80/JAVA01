package pattern.factory;

import java.lang.reflect.InvocationTargetException;

public class BuyCar {
    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {
        ICar car = CarManager.getCar("pattern.factory.BenzFactory", "EClass");
        
        car.run();
    }
}
