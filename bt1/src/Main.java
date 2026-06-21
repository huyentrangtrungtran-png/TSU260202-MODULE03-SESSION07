// Định nghĩa lớp Rectangle
class Rectangle {
    // Các thuộc tính
    private double length;
    private double width;

    // 1. Constructor mặc định (không tham số)
    public Rectangle() {
        this.length = 1.0;
        this.width = 1.0;
    }

    // 2. Constructor có tham số
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Phương thức tính diện tích
    public double getArea() {
        return this.length * this.width;
    }

    // Phương thức tính chu vi
    public double getPerimeter() {
        return 2 * (this.length + this.width);
    }

    // Phương thức hiển thị thông tin
    public void display() {
        System.out.println("Chiều dài: " + this.length);
        System.out.println("Chiều rộng: " + this.width);
        System.out.println("Diện tích: " + this.getArea());
        System.out.println("Chu vi: " + this.getPerimeter());
        System.out.println("-----------------------");
    }
}

// Lớp chứa phương thức main để chạy chương trình
public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng bằng constructor mặc định
        System.out.println("--- Hình chữ nhật mặc định ---");
        Rectangle defaultRect = new Rectangle();
        defaultRect.display();

        // Tạo đối tượng bằng constructor có tham số
        System.out.println("--- Hình chữ nhật tùy chỉnh ---");
        Rectangle customRect = new Rectangle(5, 3);
        customRect.display();
    }
}
