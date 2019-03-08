package ru.job4j.condition;

/**
 * @author Alexander Kashkin
 * @since 08.03.2019
 * @version 2
 */
public class DummyBot {
    /**
     *
     * @param question from client
     * @return bot's answer
     */
    public String answer(String question) {
        String rst = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, бот.".equals(question)) {
            rst = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rst = "До скорой встречи.";
        }
        return rst;
    }
}