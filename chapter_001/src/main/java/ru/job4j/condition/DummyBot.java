package ru.job4j.condition;

/**
 * DummyBot.
 * @author Alexander Kashkin.
 * @since 01.01.2019.
 * @version 1
 */
public class DummyBot {
    public String answer (String question){
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
