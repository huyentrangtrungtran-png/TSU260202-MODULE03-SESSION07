import java.util.Scanner;

// Định nghĩa lớp Person
class Person {
    // Các thuộc tính
    private String name;
    private int age;

    // Constructor mặc định
    public Person() {}

    // Getter và Setter cho thuộc tính name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter và Setter cho thuộc tính age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// Lớp Main để xử lý logic chương trình
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Tạo đối tượng Person thứ nhất và nhập dữ liệu
        Person person1 = new Person();
        System.out.println("Nhập thông tin người thứ nhất:");
        System.out.print("Nhập tên: ");
        person1.setName(scanner.nextLine());
        System.out.print("Nhập tuổi: ");
        person1.setAge(scanner.nextInt());

        scanner.nextLine(); // Xóa bộ nhớ đệm sau khi nhập số int

        // 2. Tạo đối tượng Person thứ hai và nhập dữ liệu
        Person person2 = new Person();
        System.out.println("\nNhập thông tin người thứ hai:");
        System.out.print("Nhập tên: ");
        person2.setName(scanner.nextLine());
        System.out.print("Nhập tuổi: ");
        person2.setAge(scanner.nextInt());

        // 3. So sánh tuổi và in kết quả
        System.out.println("\n--- Kết quả so sánh ---");
        if (person1.getAge() > person2.getAge()) {
            System.out.println(person1.getName() + " (" + person1.getAge() + " tuổi) lớn tuổi hơn " + person2.getName() + ".");
        } else if (person1.getAge() < person2.getAge()) {
            System.out.println(person2.getName() + " (" + person2.getAge() + " tuổi) lớn tuổi hơn " + person1.getName() + ".");
        } else {
            System.out.println("Cả hai người bằng tuổi nhau (" + person1.getAge() + " tuổi).");
        }

        scanner.close();
    }
}
