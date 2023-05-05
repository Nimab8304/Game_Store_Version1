package ir.ac.kntu;

import junit.framework.TestCase;

public class Test extends TestCase {
    public void testuser(){
        User user = new User("Amir", "Abasi123456", "zxjcbhj@gmail.com", 20, "24525");
        Game game = new Game("Snake", "very good", "action", 10);
        game.rates.put(user.getUsername(),7.2);
        assertEquals(UserLibrary.countRates(game),7.2);
    }
}
