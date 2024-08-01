import java.util.*;

//Класс Notebook: Содержит поля для характеристик ноутбука: RAM, HDD, OS и цвет.    Предоставляет геттеры и метод toString().

class Notebook {                           

    private int ram; // ОЗУ в ГБ
    private int hdd; // Объем ЖД в ГБ
    private String os; // Операционная система
    private String color; // Цвет

    public Notebook(int ram, int hdd, String os, String color) {
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Notebook [RAM=" + ram + "GB, HDD=" + hdd + "GB, OS=" + os + ", Color=" + color + "]";
    }
}

public class NotebookStore {
    private Set<Notebook> notebooks;

    public NotebookStore() {
        notebooks = new HashSet<>();
    }

    public void addNotebook(Notebook notebook) {
        notebooks.add(notebook);
    }

    public void filterNotebooks(Map<String, String> filters) {
        for (Notebook notebook : notebooks) {
            boolean matches = true;

            if (filters.containsKey("ram")) {
                int ram = Integer.parseInt(filters.get("ram"));
                if (notebook.getRam() < ram) {
                    matches = false;
                }
            }

            if (filters.containsKey("hdd")) {
                int hdd = Integer.parseInt(filters.get("hdd"));
                if (notebook.getHdd() < hdd) {
                    matches = false;
                }
            }

            if (filters.containsKey("os")) {
                String os = filters.get("os");
                if (!notebook.getOs().equalsIgnoreCase(os)) {
                    matches = false;
                }
            }

            if (filters.containsKey("color")) {
                String color = filters.get("color");
                if (!notebook.getColor().equalsIgnoreCase(color)) {
                    matches = false;
                }
            }

            if (matches) {
                System.out.println(notebook);
            }
        }
    }
}
    