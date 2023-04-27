import controller.ManagerStudent;
import model.Student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ManagerStudent managerStudent = new ManagerStudent();
        String filePatch = "F:\\Code Gym\\Pratice\\Thi_module02\\src\\data\\data";
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    1.Xem danh sách sinh viên.
                    2.Thêm mới.
                    3.Cập nhật.
                    4.Xóa.
                    5.Sắp xếp.
                    6.Đọc từ file.
                    7.Ghi vào file.
                    8.Thoát.
                      """);
            System.out.println();
            System.out.println("Mời chọn chức năng !!!");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    managerStudent.showAllStudent();
                    scanner.nextLine();

                    break;
                case 2:
                    managerStudent.addStudent();
                    break;
                case 3:
                    String studentCode;
                    studentCode = managerStudent.inputStudentCode();
                    managerStudent.findStudent(studentCode);
                    break;
                case 4:
                    String studentCode1;
                    studentCode1 = managerStudent.inputStudentCode();
                    managerStudent.remove(studentCode1);
                    break;
                case 5:
                    int choice1;
                    while (true){
                        try {
                            System.out.println("Sắp xếp");
                            System.out.println("1. Tăng dần theo điểm trung bình");
                            System.out.println("2. Giảm dần theo điểm trung bình");
                            System.out.println("3. quay lại");
                            System.out.println();
                            choice1 = scanner.nextInt();
                            switch (choice1) {
                                case 1:
                                    System.out.println("1. Tăng dần theo điểm trung bình");
                                    managerStudent.sortAscending();
                                    break;
                                case 2:
                                    System.out.println("2. Giảm dần theo điểm trung bình");
                                    managerStudent.sortDescending();
                                    break;
                                case 3:
                                    System.out.println("quay lại");
                                    return;
                                default:
                                    System.out.println("lựa chọn không đúng");
                                    break;
                            }
                        }catch (Exception e) {
                            System.out.println("lựa chọn không hợp lệ");
                            scanner.nextLine();
                        }
                    break;
                case 6:
                    managerStudent.loadFileCSV(filePatch);
                    break;
                case 7:
                    managerStudent.writeToFiveSCV();
                    break;

            }

        } while (choice != 8);
    }

    }
}