// Định nghĩa lớp Book
class Book {
    // Các thuộc tính private để đảm bảo tính bao đóng
    private String title;
    private String author;
    private double price;

    // Constructor mặc định
    public Book() {}

    // Constructor có tham số (tùy chọn để khởi tạo nhanh)
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        setPrice(price); // Gọi setter để tận dụng kiểm tra điều kiện giá hợp lệ
    }

    // Getter và Setter cho thuộc tính title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter và Setter cho thuộc tính author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter và Setter cho thuộc tính price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // Kiểm tra điều kiện giá sách không được âm
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Lỗi: Giá sách không được là số âm (" + price + "). Giữ nguyên giá trị cũ.");
        }
    }
}

// Lớp Main để chạy kiểm thử
public class Main {
    public static void main(String[] args) {
        // 1. Khởi tạo đối tượng Book
        Book myBook = new Book();

        // 2. Thiết lập giá trị ban đầu qua các phương thức Setter
        myBook.setTitle("Lập Trình Hướng Đối Tượng Java");
        myBook.setAuthor("Nguyễn Văn A");
        myBook.setPrice(125000);

        // 3. Truy cập và in thông tin qua các phương thức Getter
        System.out.println("--- Thông tin sách ban đầu ---");
        System.out.println("Tên sách: " + myBook.getTitle());
        System.out.println("Tác giả: " + myBook.getAuthor());
        System.out.println("Giá sách: " + myBook.getPrice() + " VND");
        System.out.println("--------------------------------\n");

        // 4. Thử thay đổi giá trị thuộc tính price sang số dương (Hợp lệ)
        System.out.println("--- Thử cập nhật giá hợp lệ (150,000 VND) ---");
        myBook.setPrice(150000);
        System.out.println("Giá sách sau khi cập nhật: " + myBook.getPrice() + " VND");
        System.out.println("--------------------------------\n");

        // 5. Thử thay đổi giá trị thuộc tính price sang số âm (Không hợp lệ)
        System.out.println("--- Thử cập nhật giá không hợp lệ (-50,000 VND) ---");
        myBook.setPrice(-50000);
        System.out.println("Giá sách hiện tại: " + myBook.getPrice() + " VND");
        System.out.println("--------------------------------");
    }
}
