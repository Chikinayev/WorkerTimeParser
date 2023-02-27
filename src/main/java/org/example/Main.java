package org.example;

public class Main {
    public static void main(String[] args) {
        String[][] input = {
                {"Name", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"},
                {"John", "10:00 - 18:00", "10:00 - 18:00", "10:00 - 18:00", "10:00 - 18:00", "10:00 - 18:00", "10:00 - 18:00", "10:00 - 18:00"},
                {"John", "09:00 - 17:00", "09:00 - 17:00", "09:00 - 17:00", "09:00 - 17:00", "09:00 - 17:00", "09:00 - 17:00", "09:00 - 17:00"}
        };
        WorkTimeParser parser = new WorkTimeParser();
        String[][] output = parser.prepareWorkTime(input);
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}