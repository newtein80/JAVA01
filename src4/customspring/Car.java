package customspring;

import java.util.List;
import java.util.Properties;

public class Car {
    String model = "original";
    int cc = 2000;
    List<Object> options;
    Properties properties;

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the cc
     */
    public int getCc() {
        return cc;
    }

    /**
     * @param cc the cc to set
     */
    public void setCc(int cc) {
        this.cc = cc;
    }

    /**
     * @return the options
     */
    public List<Object> getOptions() {
        return options;
    }

    /**
     * @param options the options to set
     */
    public void setOptions(List<Object> options) {
        this.options = options;
    }

    /**
     * @return the properties
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * @param properties the properties to set
     */
    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
