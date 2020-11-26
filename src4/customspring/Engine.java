package customspring;

public class Engine {
    String vendor;
    int valve;

    // public Engine(){}
	// 생성자가 하나라도 만들면 default생성자를 만들지 않는다.
    public Engine(String vendor, int valve) {
        this.vendor = vendor;
        this.valve = valve;
    }

    public Engine(int valve, String vendor) {
        this.valve = valve;
        this.vendor = vendor;
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
        return vendor;
    }

    /**
     * @param vendor the vendor to set
     */
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    /**
     * @return the valve
     */
    public int getValve() {
        return valve;
    }

    /**
     * @param valve the valve to set
     */
    public void setValve(int valve) {
        this.valve = valve;
    }
}
