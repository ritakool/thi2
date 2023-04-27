package model;

public class Student {
    private String studentCode;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double averageScore;

    public Student(String studentCode, String name, int age, String gender, String address, double averageScore) {
        this.studentCode = studentCode;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.averageScore = averageScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    @Override
    public String toString() {
        return "Sinh viên: " + '\t' +
                "Họ và tên: " + name + '\t' +
                "Tuổi: " + age + '\t' +
                "Giới tính: " + gender + '\t' +
                "Địa chỉ: " + address + '\t' +
                "Điểm trung bình: " + averageScore
                ;
    }
}
