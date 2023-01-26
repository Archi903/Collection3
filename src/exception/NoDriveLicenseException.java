package exception;

import drivers.Driver;

public class NoDriveLicenseException extends Exception{
    private final Driver driver;

    public NoDriveLicenseException(String message, Driver driver) {
        super(message);
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }
}
