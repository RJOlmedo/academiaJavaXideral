// Clase abstracta
abstract class Animal {
    // Metodo abstracto
    public abstract void makeSound();
    
    // Metodo concreto
    public void sleep() {
        System.out.println("Zzz...");
    }
}

// Subclase concreta 1
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof Woof!");
    }
}

// Subclase concreta 2
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

// Clase principal
public class polimorfismoConAbstracciones {
    public static void main(String[] args) {
        // Polimorfismo en accion
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        
        // Llamada a los metodos
        myDog.makeSound(); 
        myCat.makeSound(); 
        
        // Llamada a un metodo concreto de la clase abstracta
        myDog.sleep();    
        myCat.sleep();     
    }
}
