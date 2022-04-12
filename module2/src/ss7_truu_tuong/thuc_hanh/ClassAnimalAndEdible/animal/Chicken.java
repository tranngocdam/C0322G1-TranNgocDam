package ss7_truu_tuong.thuc_hanh.ClassAnimalAndEdible.animal;


import ss7_truu_tuong.thuc_hanh.ClassAnimalAndEdible.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }
    @Override
    public String howToEat() {
        return "could be fried";
    }
}
