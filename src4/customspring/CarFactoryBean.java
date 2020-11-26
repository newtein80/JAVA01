package customspring;

import org.springframework.beans.factory.config.AbstractFactoryBean;

@SuppressWarnings("rawtypes")
public class CarFactoryBean extends AbstractFactoryBean{

    @Override
    protected Object createInstance() throws Exception {
        return new Car();
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }
    
}
