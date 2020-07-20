package bad_car;

import java.util.*;

public class CarManager {

    public static void main(String[] args) {
        System.out.println("Main method");
        CarManager carManager = new CarManager();
        System.out.println("best car: " + carManager.getBestCar().get());
        System.out.println("Small change");
        System.out.println("==============");
        carManager.getCarsNames();
    }

    List<Car> carsDb = Arrays.asList(
            new Car("1", "Golf III", "Volkswagen"),
            new Car("2", "500", "Fiat"),
            new Car("3", "Megan", "Renault"),
            new Car("4", "Corolla", "Toyota"),
            new Car("5", "Seicento", "Fiat"),
            new Car("6", "Rx7", "Mazdaaaaaaaaaa")
    );

    public Optional<Car> getFromDb(String carId) {
        return carsDb.stream()
                .filter(c -> c.getId().equals(carId))
                .findFirst();
    }

    public void getCarsNames() {
        carsDb.stream()
                //comment 1
                // comment2
                .map(c -> c.getBrand() + " " + c.getModel())
                .forEach(System.out::println);
    }

    public Optional<Car> getBestCar() {
        Map<Car, Integer> carRates = new HashMap<>();
        carRates.put(carsDb.get(0), 1);
        carRates.put(carsDb.get(1), 2);
        carRates.put(carsDb.get(2), 3);
        carRates.put(carsDb.get(3), 4);
        carRates.put(carsDb.get(4), 5);
        carRates.put(carsDb.get(5), 6);
        return carsDb.stream()
                .max((c1, c2) -> Integer.compare(carRates.get(c1), carRates.get(c2)));
    }
}
