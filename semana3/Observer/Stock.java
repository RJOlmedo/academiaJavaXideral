import java.util.ArrayList;
import java.util.List;

public class Stock {
    private String stockSymbol;
    private double price;
    private List<Investor> investors = new ArrayList<>();

    public Stock(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
    }

    public void addObserver(Investor investor) {
        investors.add(investor);
    }

    public void removeObserver(Investor investor) {
        investors.remove(investor);
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public double getPrice() {
        return price;
    }

    private void notifyObservers() {
        for (Investor investor : investors) {
            investor.update(stockSymbol, price);
        }
    }
}
