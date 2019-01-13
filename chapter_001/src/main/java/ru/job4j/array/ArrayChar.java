package ru.job4j.array;

public class ArrayChar {
    private  char[] data;

    public ArrayChar(String line){
        this.data = line.toCharArray();
    }

    /**
     * Метод проверяет заданный префикс слова
     * @param prefix
     * @return - если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++){
            if (data[i] != value[i] ) {
                result = false;
            }
        }
        return result;
    }
}
