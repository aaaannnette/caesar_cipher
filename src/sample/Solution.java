package sample;

public class Solution {

    public static String decode(String string, int key) {
        StringBuilder sb = new StringBuilder(); //инициализируем переменную sb

        for (char c : string.toCharArray()      //проходим по всем символам строки
        ) {
            sb.append((char) (c + key));       //образование новой строки путем посимвольного добавления
        }

        return sb.toString();                 // преобразуем строку и возвращаем
    }
}
