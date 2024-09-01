public class ConcreteInvestor implements Investor {
    private String investorName;

    public ConcreteInvestor(String investorName) {
        this.investorName = investorName;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Investor " + investorName + " notified. " +
                           "New price of " + stockSymbol + " is " + price);
    }
}
