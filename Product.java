package Demo;

import java.util.ArrayList;
import java.util.Date;


class Product {
    int product_id;
    String name;
    double price;
    int quantity;

    public Product(int product_id, String name, double price, int quantity) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class Invoice {
    String customer_name;
    String product;
    int quantity;
    Date timestamp;

    public Invoice(String customer_name, String product, int quantity, Date timestamp) {
        this.customer_name = customer_name;
        this.product = product;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }
}

class Store {
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Invoice> invoices = new ArrayList<>();

    public Store() {
        products.add(new Product(1, "Product1", 10.0, 50));
        products.add(new Product(2, "Product2", 15.0, 30));
        // Thêm các sản phẩm khác vào đây
    }

    public void displayProductList() {
        for (Product product : products) {
            System.out.println(product.product_id + ". " +
                    product.name + " - " +
                    product.price + "$ - Quantity: " +
                    product.quantity);
        }
    }
    public void displayAvailableProducts() {
        System.out.println("Các sản phẩm còn hàng:");
        for (Product product : products) {
            if (product.quantity > 0) {
                System.out.println(product.product_id +
                        ". " + product.name + " - " +
                        product.price + "$ - Quantity: " +
                        product.quantity);
            }
        }
    }

    public void buyProduct(int productId, int quantity, String customerName) {
        Product product = null;
        for (Product p : products) {
            if (p.product_id == productId) {
                product = p;
                break;
            }
        }

        if (product != null && product.quantity >= quantity) {
            product.quantity -= quantity;
            Invoice invoice = new Invoice(customerName, product.name, quantity, new Date());
            invoices.add(invoice);
            System.out.println("Đã mua hàng: " + quantity +
                    " " + product.name +
                    "(s) cho " + customerName);
        } else if (product != null && product.quantity < quantity) {
            System.out.println("Sản phẩm '" + product.name +
                    "' chỉ còn " + product.quantity +
                    " trong kho. Vui lòng giảm số lượng.");
        } else {
            System.out.println("Không tìm thấy sản phẩm hoặc số lượng không hợp lệ.");
        }
    }

    public void displayInvoices() {
        for (Invoice invoice : invoices) {
            System.out.println("Time: " + invoice.timestamp +
                    " - Customer: " + invoice.customer_name +
                    " - Demo.Product: " + invoice.product +
                    " - Quantity: " + invoice.quantity);
        }
    }
}

