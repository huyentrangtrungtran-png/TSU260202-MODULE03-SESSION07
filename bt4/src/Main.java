import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Định nghĩa lớp Student
class Student {
    // Các thuộc tính
    private String name;
    private int age;
    private String className; // Đổi từ 'class' thành 'className' để tránh trùng từ khóa hệ thống
    private double avgScore;

    // Constructor có tham số để khởi tạo dữ liệu nhanh
    public Student(String name, int age, String className, double avgScore) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.avgScore = avgScore;
    }

    // Các phương thức Getter và Setter cần thiết
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClassName() {
        return className;
    }

    public double getAvgScore() {
        return avgScore;
    }

    // Phương thức hiển thị thông tin sinh viên trên một dòng
    public void displayInfo() {
        System.out.printf("Tên: %-18s | Tuổi: %-2d | Lớp: %-6s | ĐTB: %-3.1f\n",
                this.name, this.age, this.className, this.avgScore);
    }
}

// Lớp Main xử lý logic chương trình
public class Main {
    public static void main(String[] args) {
        // 1. Tạo một danh sách có sẵn các đối tượng Student
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Nguyễn Văn An", 20, "CNTT1", 8.5));
        studentList.add(new Student("Trần Thị Bình", 19, "CNTT2", 6.2));
        studentList.add(new Student("Lê Hoàng Cường", 21, "CNTT1", 4.5));
        studentList.add(new Student("Phạm Minh Đức", 20, "KHMT3", 9.2));
        studentList.add(new Student("Vũ Hoàng Yến", 19, "KHMT3", 7.8));

        // 2. Sử dụng Scanner để nhận thông tin min và max từ người dùng
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập điểm tối thiểu (min): ");
        double min = scanner.nextDouble();
        System.out.print("Nhập điểm tối đa (max): ");
        double max = scanner.nextDouble();

        // 3. Hiển thị danh sách sinh viên thỏa mãn điều kiện
        System.out.println("\n--- Kết quả lọc sinh viên (Điểm từ " + min + " đến " + max + ") ---");
        boolean found = false;

        for (Student student : studentList) {
            // Kiểm tra xem điểm của sinh viên có nằm trong khoảng [min, max] hay không
            if (student.getAvgScore() >= min && student.getAvgScore() <= max) {
                student.displayInfo();
                found = true;
            }
        }

        // Trường hợp không tìm thấy sinh viên nào phù hợp
        if (!found) {
            System.out.println("Không có sinh viên nào có điểm trong khoảng này.");
        }

        scanner.close();
    }
}
