package Demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Tìm kiếm theo tên");
            System.out.println("3. Xem sản phẩm còn hàng");
            System.out.println("4. Mua hàng");
            System.out.println("5. Xem danh sách đơn hàng");
            System.out.println("0. Thoát");
            System.out.print("Chọn một tính năng (0-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    store.displayProductList();
                    break;
                case 2:
                    // Thêm tính năng tìm kiếm theo tên
                    break;
                case 3:

                    store.displayAvailableProducts();
                    break;
                case 4:
                    System.out.print("Nhập ID sản phẩm muốn mua: ");
                    int productId = scanner.nextInt();
                    System.out.print("Nhập số lượng: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên khách hàng: ");
                    String customerName = scanner.nextLine();
                    store.buyProduct(productId, quantity, customerName);
                    break;
                case 5:
                    store.displayInvoices();
                    break;
                case 0:
                    System.out.println("Cảm ơn bạn đã sử dụng ứng dụng quản lý bán hàng. Tạm biệt!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }}