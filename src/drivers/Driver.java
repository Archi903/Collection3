package drivers;

import exception.NoDriveLicenseException;

import java.util.*;

public abstract class Driver {
    private final String name;
    private final boolean driverLicense;
    private final int experience;
    private static final Set<String> listDrivers = new HashSet<>();

    public Driver(String name, boolean driverLicense, int experience){
        this.name = name;
        this.experience = experience;
        this.driverLicense = driverLicense;

    }

    public String getName() {
        return name;
    }

    public boolean isDriverLicense() {
        return driverLicense;
    }

    public int getExperience() {
        return experience;
    }


    public abstract void startCar();

    public abstract void stopCar();

    public abstract void refillCar();


    public static Set<String> getListDrivers() {
        return listDrivers;
    }

    public static void setListDrivers(String name) {
        listDrivers.add(name);
    }

    @Override
    public String toString() {
        return "Водитель " + name;
    }

    public void check() throws NoDriveLicenseException {
        if (!driverLicense){
            throw new NoDriveLicenseException("Необходимо указать тип прав!", this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return driverLicense == driver.driverLicense && experience == driver.experience && Objects.equals(name, driver.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, driverLicense, experience);
    }
}
