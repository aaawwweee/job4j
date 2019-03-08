package ru.job4j.condition;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class DummyBotTest {
    @Test
    public void whenGreetBot() {
        DummyBot dummyBot = new DummyBot();
        assertThat(dummyBot.answer("Привет, бот."), is("Привет, умник."));
    }
    @Test
    public void whenByeBot() {
        DummyBot dummyBot = new DummyBot();
        assertThat(dummyBot.answer("Пока."), is("До скорой встречи."));
    }
    @Test
    public void whenBreakingBot() {
        DummyBot dummyBot = new DummyBot();
        assertThat(dummyBot.answer("Как дела?"), is("Это ставит меня в тупик. Задайте другой вопрос."));
    }
}
