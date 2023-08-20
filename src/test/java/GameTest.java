import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class GameTest {

    @Test
    public void testPlayer1Win() {
        Player Misha = new Player(1, "Миша", 10);
        Player Sasha = new Player(2, "Саша", 2);
        Game game = new Game();

        game.register(Misha);
        game.register(Sasha);

        int actual = game.round("Миша", "Саша");
        int expexted = 1;

        Assertions.assertEquals(expexted, actual);
    }

    @Test
    public void testPlayer2Win() {
        Player Misha = new Player(1, "Миша", 10);
        Player Sasha = new Player(2, "Саша", 20);
        Game game = new Game();

        game.register(Misha);
        game.register(Sasha);

        int actual = game.round("Миша", "Саша");
        int expexted = 2;

        Assertions.assertEquals(expexted, actual);
    }

    @Test
    public void testDraw() {
        Player Misha = new Player(1, "Миша", 10);
        Player Sasha = new Player(2, "Саша", 10);
        Game game = new Game();

        game.register(Misha);
        game.register(Sasha);

        int actual = game.round("Миша", "Саша");
        int expexted = 0;

        Assertions.assertEquals(expexted, actual);
    }

    @Test
    public void testPlayer1NotFound() {
        Player Misha = new Player(1, "Миша", 10);
        Player Sasha = new Player(2, "Саша", 10);
        Game game = new Game();

        game.register(Misha);
        game.register(Sasha);


        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Маша", "Саша")
        );
    }
    @Test
    public void testPlayer2NotFound() {
        Player Misha = new Player(1, "Миша", 10);
        Player Sasha = new Player(2, "Саша", 10);
        Game game = new Game();

        game.register(Misha);
        game.register(Sasha);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Миша", "Оля")
        );
    }




}