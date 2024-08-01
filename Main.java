import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NotebookStore store = new NotebookStore();
        store.addNotebook(new Notebook(8, 256, "Windows", "Black"));
        store.addNotebook(new Notebook(16, 512, "Linux", "Silver"));
        store.addNotebook(new Notebook(4, 128, "Windows", "White"));

        Scanner scanner = new Scanner(System.in);
        Map<String, String> filters = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        String criteria = scanner.nextLine();
    

        switch (criteria) {
            case "1":
                System.out.print("Введите минимальный объем ОЗУ (в ГБ): ");
                filters.put("ram", scanner.nextLine());
                break;
            case "2":
                System.out.print("Введите минимальный объем ЖД (в ГБ): ");
                filters.put("hdd", scanner.nextLine());
                break;
            case "3":
                System.out.print("Введите операционную систему: ");
                filters.put("os", scanner.nextLine());
                break;
            case "4":
                System.out.print("Введите цвет: ");
                filters.put("color", scanner.nextLine());
                break;
            default:
                System.out.println("Некорректный ввод.");
                return;
        }

        store.filterNotebooks(filters);
        scanner.close();
    }
}


    

