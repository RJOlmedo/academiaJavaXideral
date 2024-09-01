public class Menu {
    private String mainDish;
    private String sideDish;
    private String drink;
    private String dessert;

    private Menu(MenuBuilder builder) {
        this.mainDish = builder.mainDish;
        this.sideDish = builder.sideDish;
        this.drink = builder.drink;
        this.dessert = builder.dessert;
    }

    public String getMainDish() {
        return mainDish;
    }

    public String getSideDish() {
        return sideDish;
    }

    public String getDrink() {
        return drink;
    }

    public String getDessert() {
        return dessert;
    }

    @Override
    public String toString() {
        return "Menu [Main Dish=" + mainDish + ", Side Dish=" + sideDish + ", Drink=" + drink + ", Dessert=" + dessert + "]";
    }

    public static class MenuBuilder {
        private String mainDish;
        private String sideDish;
        private String drink;
        private String dessert;

        public MenuBuilder setMainDish(String mainDish) {
            this.mainDish = mainDish;
            return this;
        }

        public MenuBuilder setSideDish(String sideDish) {
            this.sideDish = sideDish;
            return this;
        }

        public MenuBuilder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public MenuBuilder setDessert(String dessert) {
            this.dessert = dessert;
            return this;
        }

        public Menu build() {
            return new Menu(this);
        }
    }
}
