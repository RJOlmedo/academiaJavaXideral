import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MenuTest {

    @Test
    public void testMenuCreation() {
        Menu menu = new Menu.MenuBuilder()
                .setMainDish("Grilled Chicken")
                .setSideDish("Caesar Salad")
                .setDrink("Iced Tea")
                .setDessert("Cheesecake")
                .build();

        assertEquals("Grilled Chicken", menu.getMainDish());
        assertEquals("Caesar Salad", menu.getSideDish());
        assertEquals("Iced Tea", menu.getDrink());
        assertEquals("Cheesecake", menu.getDessert());
    }

    @Test
    public void testMenuWithoutDessert() {
        Menu menu = new Menu.MenuBuilder()
                .setMainDish("Steak")
                .setSideDish("Fries")
                .setDrink("Soda")
                .build();

        assertEquals("Steak", menu.getMainDish());
        assertEquals("Fries", menu.getSideDish());
        assertEquals("Soda", menu.getDrink());
        assertEquals(null, menu.getDessert());
    }
}
