package bad_car;

import java.util.*;

public class CarManager {

    public static void main(String[] args) {
        System.out.println("Main method");
        CarManager carManager = new CarManager();
        System.out.println("best car: " + carManager.getBestCar().get());
        System.out.println("Small change");
    }

    List<Car> carsDb = Arrays.asList(
            new Car("1", "Golf III", "Volkswagen"),
            new Car("2", "500", "Fiat"),
            new Car("3", "Corolla", "Toyota"),
            new Car("4", "Seicento", "Fiat"),
            new Car("5", "Rx7", "Mazdaaaaaaaaaa")
    );

    public Optional<Car> getFromDb(String carId) {
        return carsDb.stream()
                .filter(c -> c.getId().equals(carId))
                .findFirst();
    }

    public String getCarsNames() {
        return carsDb.stream()
                .map(c -> c.getBrand() + " " + c.getModel())
                .reduce((prev, next) -> prev + "," + next)
                .orElse("Sorry. No cars");
    }

    public Optional<Car> getBestCar() {
        Map<Car, Integer> carRates = new HashMap<>();
        Car renault = new Car("3", "Megane", "Renault");
        Car fiat = new Car("2", "500", "Fiat");
        Car golf = new Car("1", "Golf III", "Volkswagen");
        carRates.put(renault, 1);
        carRates.put(fiat, 2);
        carRates.put(golf, 3);
        return carsDb.stream()
                .max((c1, c2) -> Integer.compare(carRates.get(c1), carRates.get(c2)));
    }
}
