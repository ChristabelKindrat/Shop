import catalog.Catalog;
import product.Product;

import java.util.Scanner;

public class Shop{
    private Catalog catalog = new Catalog();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add product to catalog");
            System.out.println("2. View all products");
            System.out.println("3. View specific product");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    viewSpecificProduct();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private void addProduct() {
        System.out.println("Enter product details:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Stock quantity: ");
        int stockQuantity = scanner.nextInt();
        scanner.nextLine();

        Product product = new Product(id, name, description, price, stockQuantity);
        catalog.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private void viewAllProducts() {
        System.out.println("List of all products:");
        for (Product product : catalog.getProducts()) {
            System.out.println(product.getName() + " (" + product.getId() + ")");
        }
    }

    private void viewSpecificProduct() {
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Product product = catalog.getProductById(id);
        if (product == null) {
            System.out.println("Product not found.");
        } else {
            System.out.println("Product details:");
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Stock quantity: " + product.getStockQuantity());
        }
    }

    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.start();
    }
}
