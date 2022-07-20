package web.models;

public class Car {
    private String carName;
    private int carSeries;
    private char carClass;

    public Car(String carName, int carSeries, char carClass) {
        this.carName = carName;
        this.carSeries = carSeries;
        this.carClass = carClass;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(int carSeries) {
        this.carSeries = carSeries;
    }

    public char getCarClass() {
        return carClass;
    }

    public void setCarClass(char carClass) {
        this.carClass = carClass;
    }

}
