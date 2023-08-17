package ru.geekbrains.api.lesson5.hw;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
//        Scanner scanner=new Scanner(System.in);
//        String text=scanner.nextLine();
          String text = "Россия идет вперед всей планеты. Планета — это не Россия.";

        Map<String, Integer> mapStr = getStringMapFromText(text);
        for (Map.Entry<String, Integer> elem : mapStr.entrySet()) {
            System.out.println("количество вхождения слова " +elem.getKey() + " = "+ elem.getValue());
        }
        System.out.println(mapStr);
    }

    /**
     * @apiNote Подсчитать количество вхождения каждого слова (Усложнение - игнорировать пунктуацию)*
     * @param text введенное предложение
     * @return мэп с ключом - словом и значением - количеством вхождения слова
     */
    private static Map<String, Integer> getStringMapFromText(String text) {
        Map<String, Integer> mapStr = new HashMap<>();
        String[] words =(text.toLowerCase()+" ").split("\\p{P}?[ \\t\\n\\r]+");
        for (int i = 0; i < words.length; i++) {
            if (!mapStr.containsKey(words[i])) {
                mapStr.put(words[i],1);
            } else {
                mapStr.put(words[i],mapStr.get(words[i])+1);
            }
        }
        return mapStr;
    }
}
