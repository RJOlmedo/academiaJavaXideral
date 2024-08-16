// Clase Singleton
class Singleton {
    // Variable estática para almacenar la única instancia de la clase
    private static Singleton instance;

    // Constructor privado para evitar la instanciación directa
    private Singleton() {
        // Código de inicialización
        System.out.println("Singleton instance created");
    }

    // Método estático que devuelve la única instancia de la clase
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // Método de ejemplo
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
}

// Clase principal
public class patronSingleton {
    public static void main(String[] args) {
        // Obtén la única instancia del Singleton
        Singleton singleton1 = Singleton.getInstance();
        singleton1.showMessage(); // Salida: Hello from Singleton!

        // Obtén la instancia nuevamente
        Singleton singleton2 = Singleton.getInstance();
        singleton2.showMessage(); // Salida: Hello from Singleton!

        // Verifica que ambas referencias apuntan a la misma instancia
        if (singleton1 == singleton2) {
            System.out.println("Both variables point to the same Singleton instance.");
        }
    }
}
