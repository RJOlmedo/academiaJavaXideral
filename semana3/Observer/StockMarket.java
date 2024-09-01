public class StockMarket {
    public static void main(String[] args) {
        Stock appleStock = new Stock("AAPL", 150.00);

        Investor investor1 = new ConcreteInvestor("Alice");
        Investor investor2 = new ConcreteInvestor("Bob");

        appleStock.addObserver(investor1);
        appleStock.addObserver(investor2);

        appleStock.setPrice(155.00);
        appleStock.setPrice(160.00);

        appleStock.removeObserver(investor1);
        appleStock.setPrice(165.00);
    }
}
