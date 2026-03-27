package ra.business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class inputData {
    public static String getString(Scanner scanner, String suggest) {
        while (true) {
            System.out.print(suggest);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.err.println("Chuỗi không được để trống!");
        }
    }

    public static int  getInt(Scanner scanner, String suggest) {
        while (true){
            try {
                System.out.print(suggest);
                int input = Integer.parseInt(scanner.nextLine());
                if (input < 0) {
                    System.out.println("Vui lòng nhập số nguyên lớn hơn 0");
                    continue;
                }
                return input;
            } catch (NumberFormatException e){
                System.out.println("Vui lòng nhập vào số nguyên !");
            }
        }
    }
    public static LocalDate getDate(Scanner scanner, String suggest) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true){
            try {
                System.out.print(suggest);
                String input= scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Chuỗi không được để trống");
                    continue;
                }
                LocalDate date =  LocalDate.parse(input, formatter);
                return date;
            } catch (NumberFormatException e){
                System.out.println("Vui Lòng nhập đúng định dạng dd/MM/yyyy!");
            }
        }
    }
}
