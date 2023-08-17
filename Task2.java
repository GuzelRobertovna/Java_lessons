package ru.geekbrains.api.lesson5.hw;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        list1.add("Иван Иванов");
        list1.add("Светлана Петрова");
        list1.add("Кристина Белова");
        list1.add("Анна Мусина");
        list1.add("Анна Крутова");
        list1.add("Иван Юрин");
        list1.add("Петр Лыков");
        list1.add("Мария Федорова");
        list1.add("Марина Светлова");
        list1.add("Петр Чернышов");
        list1.add("Мария Савина");
        list1.add("Мария Рыкова");
        list1.add("Марина Лугова");
        list1.add("Иван Мечников");

        Map<String, Integer> mapList = getListMapFromText(list1);

        // отсортировать по убыванию частоты а затем в алфавитном порядке
        SortedSet<Map.Entry<String, Integer>> sorted = new TreeSet<>(
                Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey())
        );
        sorted.addAll(mapList.entrySet());
        System.out.println(sorted);

    }

    /**
     * @apiNote Пусть дан список сотрудников.Написать программу, которая найдёт
     * и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
     * @param list1 список сотрудников
     * @return отсортированный список сотрудников
     */
    private static Map<String, Integer> getListMapFromText(ArrayList list1) {
        Map<String, Integer> mapList = new HashMap<>();
        String[] str = new String[list1.size()];
        list1.toArray(str);


            for (int i = 0; i < list1.size(); i++) {
                String[] parts = str[i].split(" ");
                if (!mapList.containsKey(parts[0])) {
                    mapList.put(parts[0],1);
                } else {
                    mapList.put(parts[0], mapList.get(parts[0]) + 1);
                }
            }
            return mapList;
    }
}

