package ss7_truu_tuong.thuc_hanh.ClassAnimalAndEdible.animal;

import ss7_truu_tuong.thuc_hanh.ClassAnimalAndEdible.animal.Animal;
import ss7_truu_tuong.thuc_hanh.ClassAnimalAndEdible.animal.Chicken;
import ss7_truu_tuong.thuc_hanh.ClassAnimalAndEdible.animal.Tiger;
import ss7_truu_tuong.thuc_hanh.ClassAnimalAndEdible.edible.Edible;
import ss7_truu_tuong.thuc_hanh.ClassAnimalAndEdible.fruit.Apple;
import ss7_truu_tuong.thuc_hanh.ClassAnimalAndEdible.fruit.Fruit;
import ss7_truu_tuong.thuc_hanh.ClassAnimalAndEdible.fruit.Orange;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howToEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }
    }
}
