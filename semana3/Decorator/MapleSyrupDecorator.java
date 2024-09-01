// Could be sugar but I love maple syrup on my coffee

public class MapleSyrupDecorator extends CoffeeDecorator {

    public MapleSyrupDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Organic Maple Syrup";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}
