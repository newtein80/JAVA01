package pattern.factory;

import java.lang.reflect.InvocationTargetException;

public class CarManager {
    public static ICar getCar(String carFactory, String type)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, ClassNotFoundException {
        ICarFactory factory = (ICarFactory) Class.forName(carFactory).getDeclaredConstructor().newInstance();
        return factory.makeCar(type);
    }
}