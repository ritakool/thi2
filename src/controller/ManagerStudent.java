package controller;

import model.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class ManagerStudent {
    private List<Student> students;
    private Regex regex;
    Scanner scanner = new Scanner(System.in);


    public ManagerStudent() {
        this.students = new ArrayList<>();
        this.regex = new Regex();
    }
    public void findStudent(String studentCode) {
        for (Student student : students) {
            if (student.getStudentCode().equals(studentCode)) {
                System.out.println("Thông tin sinh viên: " + student);
                System.out.print("Bạn muốn cập nhật thông tin sinh viên này? (Y/N): ");
                String luaChon = new Scanner(System.in).nextLine();
                if (luaChon.equalsIgnoreCase("Y")) {
                    System.out.println("Nhập mã sinh viên mới");
                    String newStudentCode = inputStudentCode();
                    System.out.print("Nhập tên mới: ");
                    String name = inputName();
                    System.out.print("Nhập tuổi mới: ");
                    int age = inputAge();
                    System.out.print("Nhập giới tính mới: ");
                    String gender = inputGender();
                    System.out.print("Nhập địa chỉ mới: ");
                    String address = inputAddress();
                    System.out.print("Nhập điểm trung bình mới: ");
                    double average = inputAverage();
                    student.setStudentCode(newStudentCode);
                    student.setName(name);
                    student.setAge(age);
                    student.setGender(gender);
                    student.setAddress(address);
                    student.setAverageScore(average);
                    System.out.println("Cập nhật thông tin sinh viên thành công!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên có mã " + studentCode);
    }
    public void showAllStudent() {
        students.forEach(System.out::println);
    }
    public void addStudent() {
        String name;
        int age;
        String gender;
        double averageScore;
        String address;
        String studentCode;
        studentCode = inputStudentCode();
        name = inputName();
        age = inputAge();
        gender = inputGender();
        address = inputAddress();
        averageScore = inputAverage();


        Student student = new Student(studentCode, name, age, gender, address, averageScore);
        students.add(student);
        System.out.println("đã thêm thành công");
    }
    public void remove(String studentCode) {
        for (Student student : students) {
            if (student.getStudentCode().equals(studentCode)) {
                System.out.println("Thông tin sinh viên: " + studentCode);
                System.out.print("Bạn có muốn xóa sinh viên này? (Y/N): ");
                String luaChon = new Scanner(System.in).nextLine();
                if (luaChon.equalsIgnoreCase("Y")) {
                    students.remove(student);
                    System.out.println("Xóa sinh viên thành công!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy sinh viên có mã " + studentCode);
    }
    public void sortAscending() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student sv1, Student sv2) {
                return Double.compare(sv1.getAverageScore(), sv2.getAverageScore());
            }
        });
        System.out.println("Đã sắp xếp danh sách sinh viên theo điểm trung bình tăng dần!");
    }
    public void sortDescending() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return Double.compare(student2.getAverageScore(), student1.getAverageScore());
            }
        });
        System.out.println("Đã sắp xếp danh sách sinh viên theo điểm trung bình giảm dần!");
    }


    // TODO: nhập thông tinh
    public String inputName() {
        System.out.println("Nhập tên: ");
        String name;
        name = scanner.nextLine();
        while (!regex.checkName(name)) {
            System.out.println("Nhập đúng định dạng tên");
            name = scanner.nextLine();
        }
        System.out.println("nhập thành công");
        return name;
    }
    public int inputAge() {
        int age;
        System.out.println("Nhập tuổi: ");
        while (true) {
            try {
                age = scanner.nextInt();
                if (age < 0) {
                    System.out.println("Sai định dạng");
                } else {
                    System.out.println("nhập thành công");
                    return age;
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng");
                scanner.nextLine();
            }
        }
    }
    public double inputAverage() {
        double averageScore;
        while (true) {
            try {
                averageScore = scanner.nextDouble();
                if (averageScore < 0) {
                    System.out.println("Điểm không nhỏ hơn 0");
                } else {
                    System.out.println("Nhập thành công");
                    return averageScore;
                }
            } catch (Exception e) {
                System.out.println("Sai định dạng");
            }
        }
    }
    public String inputAddress() {
        String address;
        do {
            System.out.println("Nhập địa chỉ: ");
            address = scanner.nextLine();
        } while (address.isEmpty());
        return address;
    }
    public String inputStudentCode() {
        String studentCode;
        do {
            System.out.println("Nhập mã sinh viên");
            studentCode = scanner.nextLine();
        }while (studentCode.isEmpty());
            return studentCode;
    }
    public String inputGender() {
        String gender;
        do {
            System.out.println("nhập giới tính");
            gender = scanner.nextLine();
        } while (gender.isEmpty());
        return gender;
    }


    //TODO: ghi đọc file:
    public void loadFileCSV(String filePath) {
        String delimiter = ",";
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            System.out.println("Chú ý: Tất cả dữ liệu sinh viên hiện có trong bộ nhớ sẽ bị xóa nếu bạn tiếp tục!");
            System.out.print("Bạn có chắc chắn muốn tiếp tục (y/n)? ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("y")) {
                System.out.println("Hủy thao tác đọc file.");
                return;
            }
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(delimiter);
                Student sinhVien = new Student(data[0], data[1], Integer.parseInt(data[2]),
                        data[3], data[4], Double.parseDouble(data[5]));
                studentList.add(sinhVien);
            }
            System.out.println("Đã đọc danh sách sinh viên từ file CSV!");
            System.out.println("Đang cập nhật lại bộ nhớ...");
            this.students.clear();
            this.students.addAll(studentList);
            // Cập nhật lại bộ nhớ thành công, ghi ra file
            String outputFile = "F:\\Code Gym\\Pratice\\Thi_module02\\src\\data\\data.csv";
            FileWriter writer = new FileWriter(outputFile);
            for (Student student : students) {
                String[] data = {
                        student.getStudentCode(), student.getName(),
                        Integer.toString(student.getAge()), student.getGender(),
                        student.getAddress(), Double.toString(student.getAverageScore()) };
                writer.write(String.join(",", data));
                writer.write("\n");
            }
            writer.close();
            System.out.println("Đã cập nhật lại danh sách sinh viên và ghi ra file CSV!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void writeToFiveSCV(String filePath, List<Student> students) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Student student : students) {
                String[] data = { student.getStudentCode(), student.getName(), Integer.toString(student.getAge()), student.getGender(), student.getAddress(), Double.toString(student.getAverageScore()) };
                writer.write(String.join(",", data));
                writer.write("\n");
            }
            System.out.println("Đã ghi danh sách sinh viên vào file " + filePath + "!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Student> getListStudents(){
        return students;
    }

}
