package ir.ac.kntu;

import junit.framework.TestCase;

public class Test extends TestCase {
    public void testcountrate(){
        User user = new User("Amir", "Abasi123456", "zxjcbhj@gmail.com", 20, "24525");
        Game game = new Game("Snake", "very good", "action", 10);
        game.rates.put(user.getUsername(),7.2);
        assertEquals(UserLibrary.countRates(game),7.2);
    }

    public void testcountrates(){
        User user = new User("Amir", "Abasi123456", "zxjcbhj@gmail.com", 20, "24525");
        Game game = new Game("Walk", "very good", "action", 10);
        User user1 = new User("She", "She123456", "zxyuybbhj@gmail.com", 30, "2125");
        game.rates.put(user.getUsername(),7.2);
        game.rates.put(user1.getUsername(),8.0);
        assertEquals(UserLibrary.countRates(game),7.6);
    }

    public void testuser(){
        User user = new User("Amir", "Abasi123456", "zxjcbhj@gmail.com", 20, "24525");
        Game game = new Game("Walk", "very good", "action", 10);
        User user1 = new User("She", "She123456", "zxyuybbhj@gmail.com", 30, "2125");
        game.rates.put(user.getUsername(),7.2);
        user.setWallet(50);
        game.rates.put(user1.getUsername(),8.0);
        assertEquals(user.getUsername(),"Amir");
        assertEquals(user.getEmail(),"zxjcbhj@gmail.com");
        assertEquals(user.getWallet(),50.0);
    }

    public void testuser1(){
        User user = new User("Amir", "Abasi123456", "zxjcbhj@gmail.com", 20, "24525");
        Game game = new Game("Walk", "very good", "action", 10);
        User user1 = new User("She", "She123456", "zxyuybbhj@gmail.com", 30, "2125");
        game.rates.put(user.getUsername(),7.2);
        user.setWallet(50);
        game.rates.put(user1.getUsername(),8.0);
        assertEquals(user1.getUsername(),"She");
        assertEquals(user1.getPassword(),"She123456");
        assertEquals(user1.getPhoneNumber(),"2125");
    }

    public void testgame(){
        User user = new User("Amir", "Abasi123456", "zxjcbhj@gmail.com", 20, "24525");
        Game game = new Game("Walk", "very good", "action", 10);
        User user1 = new User("She", "She123456", "zxyuybbhj@gmail.com", 30, "2125");
        game.rates.put(user.getUsername(),7.2);
        user.setWallet(50);
        game.rates.put(user1.getUsername(),8.0);
        assertEquals(game.getName(),"Walk");
        assertEquals(game.getPrice(),10.0);
        assertEquals(game.getGenres(),"action");
    }
}
