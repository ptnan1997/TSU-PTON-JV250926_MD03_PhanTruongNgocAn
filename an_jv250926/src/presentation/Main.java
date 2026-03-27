package presentation;

import ra.business.DegreeManagement;
import ra.business.inputData;
import ra.entity.Degree;


import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DegreeManagement manager = new DegreeManagement();
        int choice;
        do {
            System.out.println("""
                    *************DEGREES MANAGEMENT*************
                    1. Danh sách các bằng cấp
                    2. Thêm mới một bằng cấp
                    3. Cập nhật bằng cấp
                    4. Xóa bằng cấp
                    5. Tìm kiếm bằng cấp theo tên
                    6. Thoát
                    *******************************************
                    """);
            choice = inputData.getInt(sc,"Lựa chọn của bạn: ");
            switch (choice) {
                case 1 ->  //Danh sách các bằng cấp
                    manager.getAllDegrees();

                case 2 -> {//Thêm mới một bằng cấp
                    String degreeName = inputData.getString(sc,"Nhập tên bằng cấp:");
                    String emp_id = inputData.getString(sc,"Nhập mã nhân viên:");
                    LocalDate date = inputData.getDate(sc, "Nhập vào ngày cấp bằng :");
                    String school_name = inputData.getString(sc,"Nhập trường cấp bằng:");
                    int degree_year = inputData.getInt(sc,"Nhập năm cấp bằng:");
                    String degree_classification = inputData.getString(sc,"Nhập xếp loại:");
                    manager.addDegree(new Degree(degreeName,emp_id,date,school_name,degree_year,degree_classification));
                }
                case 3 -> {//Cập nhật bằng cấp
                    int degreeId = inputData.getInt(sc,"Nhập mã bằng cấp muốn cập nhật");
                    String degreeName = inputData.getString(sc,"Nhập tên bằng cấp:");
                    String emp_id = inputData.getString(sc,"Nhập mã nhân viên:");
                    LocalDate  data = inputData.getDate(sc, "Nhập vào ngày cấp bằng theo định dạng (dd/MM/yyyy):");
                    String school_name = inputData.getString(sc,"Nhập trường cấp bằng:");
                    int degree_year = inputData.getInt(sc,"Nhập năm cấp bằng:");
                    String degree_classification = inputData.getString(sc,"Nhập xếp loại:");
                    manager.updateDegree(degreeId, new Degree(degreeName,emp_id,data,school_name,degree_year,degree_classification));

                }
                case 4 -> {//Xóa bằng cấp
                    int deleteDegree = inputData.getInt(sc, "Nhập vào mã bằng cấp muốn xóa");
                    manager.deleteDegree(deleteDegree);
                }
                case 5 -> {//Tìm kiếm bằng cấp theo tên
                    String findByDegreeName = inputData.getString(sc,"Nhập tên bằng cấp cần tìm:");
                    manager.getDegreeByDegreeName(findByDegreeName);
                }
                case 6 ->
                    System.out.println("Kết thúc chương trình. Cảm ơn đã sử dụng");
                default -> System.out.println("Lựa chọn không hợp lệ.Vui lòng nhập lại");
            }
        }  while (choice != 6);
    }
}
