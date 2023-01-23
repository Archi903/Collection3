package rally;

import drivers.Driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Transport<T extends Driver> implements Competing {

    private final String brand;
    private final String model;
    private double engineVolume;
    private T driver;
    private final Map<Mechanic, Integer> mechanics;

    private static final double DEFAULT_ENGINE_VALUE = 1.5;

    public Transport(String brand, String model, double engineVolume, T driver) {
        this.brand = brand;
        this.model = model;
        setEngineVolume(engineVolume);
        setDriver(driver);
        this.mechanics = new HashMap<>();
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) {
            this.engineVolume = DEFAULT_ENGINE_VALUE;
        } else {
            this.engineVolume = engineVolume;
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }


    public T getDriver() {
        return driver;
    }

    public void setDriver(T driver) {
        this.driver = driver;
    }


    public void startCar() {
        System.out.println(getBrand() + " " + model + ": начать движение");
    }

    public void stopCar() {
        System.out.println(getBrand() + " " + model + ": закончить движение");
    }

    public void pitStop() {
        System.out.println(getBrand() + " " + model + " пит-стоп");

    }

    public abstract void printType();

    public abstract void testCar();

    public Map getMechanics() {
        return mechanics;
    }

    public void setMechanics(Mechanic mechanic, Integer experience) {
        this.mechanics.put(mechanic,experience);
    }


    public void getAllTeam (Transport transport){
        System.out.println("У транспорта: " + getBrand() + " " + getModel() + " за рулем " + getDriver() + ", а обслуживает: " + getMechanics().get(transport));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport<?> transport = (Transport<?>) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model) && Objects.equals(driver, transport.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, driver);
    }
}
