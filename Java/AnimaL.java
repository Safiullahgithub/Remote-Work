class AnimaL {
    void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends AnimaL {
    @Override
    void makeSound() {
        System.out.println("Woof");
    }
}

class Cat extends AnimaL {
    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        AnimaL myDog = new Dog();
        AnimaL myCat = new Cat();

        myDog.makeSound(); // Output: Woof
        myCat.makeSound(); // Output: Meow
    }
}
