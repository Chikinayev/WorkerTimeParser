package org.example;

import java.time.LocalTime;
import java.util.*;

public class WorkTimeParser {

    public String[][] prepareWorkTime(String[][] schedule) {
        // Предполагаем, что массив schedule имеет формат:
        // [ [имя специалиста 1, день 1, время начала, время конца],
        //   [имя специалиста 1, день 2, время начала, время конца],
        //   ...,
        //   [имя специалиста N, день M, время начала, время конца] ]

        // Сортируем массив по имени специалиста и дню недели
        Arrays.sort(schedule, new Comparator<String[]>() {
            @Override
            public int compare(String[] a, String[] b) {
                int nameCompare = a[0].compareTo(b[0]);
                if (nameCompare != 0) {
                    return nameCompare;
                } else {
                    int dayCompare = a[1].compareTo(b[1]);
                    return dayCompare;
                }
            }
        });

        // Объединяем строки с одинаковым именем специалиста и днем недели
        List<String[]> mergedSchedule = new ArrayList<>();
        String[] prevRow = null;
        for (String[] row : schedule) {
            if (prevRow == null || !row[0].equals(prevRow[0]) || !row[1].equals(prevRow[1])) {
                mergedSchedule.add(row);
                prevRow = row;
            } else {
                prevRow[3] = row[3]; // Обновляем время окончания
            }
        }

        // Преобразуем список обратно в массив
        String[][] result = mergedSchedule.toArray(new String[mergedSchedule.size()][]);

        return result;
    }
}

