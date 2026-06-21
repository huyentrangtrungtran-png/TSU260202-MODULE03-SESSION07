import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Định nghĩa lớp Category
class Category {
    private String id;
    private String name;
    private String description;

    // Constructor có tham số
    public Category(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Phương thức in thông tin danh mục theo hàng cột gọn gàng
    public void displayCategory() {
        System.out.printf("Mã: %-6s | Tên danh mục: %-15s | Mô tả: %s\n", id, name, description);
    }
}

// Lớp điều khiển chương trình chính
public class Main {
    private static List<Category> categoryList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Thêm dữ liệu mẫu ban đầu để dễ thử nghiệm
        categoryList.add(new Category("CAT01", "Điện tử", "Các thiết bị điện tử, công nghệ"));
        categoryList.add(new Category("CAT02", "Thời trang", "Quần áo, giày dép, phụ kiện"));

        int choice;
        do {
            System.out.println("\n===== CHƯƠNG TRÌNH QUẢN LÝ DANH MỤC =====");
            System.out.println("1. Thêm mới danh mục");
            System.out.println("2. Hiển thị danh sách danh mục");
            System.out.println("3. Cập nhật danh mục theo ID");
            System.out.println("4. Xóa danh mục theo ID");
            System.out.println("5. Tìm kiếm danh mục theo tên");
            System.out.println("6. Thoát chương trình");
            System.out.print("Chọn chức năng (1-6): ");

            // Ngăn chặn lỗi khi người dùng vô tình gõ chữ vào menu số
            while (!scanner.hasNextInt()) {
                System.out.print("Vui lòng chỉ nhập số từ 1 đến 6: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm dòng

            switch (choice) {
                case 1:
                    addCategory();
                    break;
                case 2:
                    displayAllCategories();
                    break;
                case 3:
                    updateCategory();
                    break;
                case 4:
                    deleteCategory();
                    break;
                case 5:
                    searchCategoryByName();
                    break;
                case 6:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình. Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (choice != 6);

        scanner.close();
    }

    // Chức năng 1: Thêm mới danh mục
    private static void addCategory() {
        System.out.println("\n--- THÊM MỚI DANH MỤC ---");
        System.out.print("Nhập mã danh mục (ID): ");
        String id = scanner.nextLine().trim();

        // Kiểm tra xem ID danh mục đã tồn tại chưa để tránh trùng lặp
        for (Category c : categoryList) {
            if (c.getId().equalsIgnoreCase(id)) {
                System.out.println("Lỗi: Mã danh mục này đã tồn tại!");
                return;
            }
        }

        System.out.print("Nhập tên danh mục: ");
        String name = scanner.nextLine().trim();
        System.out.print("Nhập mô tả danh mục: ");
        String description = scanner.nextLine().trim();

        Category newCategory = new Category(id, name, description);
        categoryList.add(newCategory);
        System.out.println("Thêm danh mục mới thành công!");
    }

    // Chức năng 2: Hiển thị danh sách danh mục
    private static void displayAllCategories() {
        System.out.println("\n--- DANH SÁCH DANH MỤC ---");
        if (categoryList.isEmpty()) {
            System.out.println("Danh sách danh mục đang trống.");
            return;
        }
        for (Category c : categoryList) {
            c.displayCategory();
        }
    }

    // Chức năng 3: Cập nhật thông tin danh mục
    private static void updateCategory() {
        System.out.println("\n--- CẬP NHẬT DANH MỤC ---");
        System.out.print("Nhập mã danh mục cần sửa: ");
        String id = scanner.nextLine().trim();

        for (Category c : categoryList) {
            if (c.getId().equalsIgnoreCase(id)) {
                System.out.print("Nhập tên mới (Tên cũ: " + c.getName() + "): ");
                String newName = scanner.nextLine().trim();
                System.out.print("Nhập mô tả mới (Mô tả cũ: " + c.getDescription() + "): ");
                String newDesc = scanner.nextLine().trim();

                c.setName(newName);
                c.setDescription(newDesc);
                System.out.println("Cập nhật thông tin danh mục thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục có mã ID: " + id);
    }

    // Chức năng 4: Xóa danh mục khỏi danh sách
    private static void deleteCategory() {
        System.out.println("\n--- XÓA DANH MỤC ---");
        System.out.print("Nhập mã danh mục cần xóa: ");
        String id = scanner.nextLine().trim();

        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getId().equalsIgnoreCase(id)) {
                Category removed = categoryList.remove(i);
                System.out.println("Đã xóa thành công danh mục: " + removed.getName());
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục có mã ID: " + id);
    }

    // Chức năng 5: Tìm kiếm danh mục theo tên (Không phân biệt hoa thường, chứa từ khóa)
    private static void searchCategoryByName() {
        System.out.println("\n--- TÌM KIẾM DANH MỤC THEO TÊN ---");
        System.out.print("Nhập tên danh mục muốn tìm kiếm: ");
        String searchName = scanner.nextLine().trim();

        boolean found = false;
        for (Category c : categoryList) {
            // Sử dụng contains và toLowerCase để tìm kiếm gần đúng
            if (c.getName().toLowerCase().contains(searchName.toLowerCase())) {
                c.displayCategory();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy danh mục nào có tên chứa từ khóa: '" + searchName + "'");
        }
    }
}
