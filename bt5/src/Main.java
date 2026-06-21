import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Định nghĩa lớp Product
class Product {
    private String id;
    private String name;
    private double price;

    // Constructor có tham số
    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Các phương thức Getter và Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Phương thức in thông tin sản phẩm theo định dạng cột
    public void displayProduct() {
        System.out.printf("Mã: %-6s | Tên sản phẩm: %-18s | Giá: %,.0f VND\n", id, name, price);
    }
}

// Lớp điều khiển chương trình chính
public class Main {
    private static List<Product> productList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Thêm sẵn vài sản phẩm demo ban đầu
        productList.add(new Product("P001", "Điện thoại iPhone", 25000000));
        productList.add(new Product("P002", "Laptop Dell XPS", 35000000));

        int choice;
        do {
            System.out.println("\n===== CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM =====");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Cập nhật sản phẩm theo ID");
            System.out.println("4. Xóa sản phẩm theo ID");
            System.out.println("5. Thoát chương trình");
            System.out.print("Chọn chức năng (1-5): ");

            // Xử lý ngoại lệ nếu người dùng nhập chữ thay vì nhập số
            while (!scanner.hasNextInt()) {
                System.out.print("Vui lòng chỉ nhập số từ 1 đến 5: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm dòng

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    displayAllProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Chức năng 1: Thêm mới sản phẩm
    private static void addProduct() {
        System.out.println("\n--- THÊM MỚI SẢN PHẨM ---");
        System.out.print("Nhập mã sản phẩm (ID): ");
        String id = scanner.nextLine().trim();

        // Kiểm tra xem ID đã tồn tại hay chưa
        for (Product p : productList) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.println("Lỗi: Mã sản phẩm này đã tồn tại!");
                return;
            }
        }

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine().trim();
        System.out.print("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Xóa bộ đệm

        Product newProduct = new Product(id, name, price);
        productList.add(newProduct);
        System.out.println("Thêm sản phẩm thành công!");
    }

    // Chức năng 2: Hiển thị danh sách sản phẩm
    private static void displayAllProducts() {
        System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
        if (productList.isEmpty()) {
            System.out.println("Danh sách đang trống.");
            return;
        }
        for (Product p : productList) {
            p.displayProduct();
        }
    }

    // Chức năng 3: Cập nhật sản phẩm
    private static void updateProduct() {
        System.out.println("\n--- CẬP NHẬT SẢN PHẨM ---");
        System.out.print("Nhập mã sản phẩm cần sửa: ");
        String id = scanner.nextLine().trim();

        for (Product p : productList) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.print("Nhập tên mới (Tên cũ: " + p.getName() + "): ");
                String newName = scanner.nextLine().trim();
                System.out.print("Nhập giá mới (Giá cũ: " + p.getPrice() + "): ");
                double newPrice = scanner.nextDouble();
                scanner.nextLine(); // Xóa bộ đệm

                p.setName(newName);
                p.setPrice(newPrice);
                System.out.println("Cập nhật thông tin thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã ID là: " + id);
    }

    // Chức năng 4: Xóa sản phẩm
    private static void deleteProduct() {
        System.out.println("\n--- XÓA SẢN PHẨM ---");
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String id = scanner.nextLine().trim();

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equalsIgnoreCase(id)) {
                Product removedProduct = productList.remove(i);
                System.out.println("Đã xóa sản phẩm: " + removedProduct.getName() + " thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã ID là: " + id);
    }
}
