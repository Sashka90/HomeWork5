package data;

public enum EnglishLevelData {
    INTERMEDIATE("Средний (Intermediate)");

    private String name;


    EnglishLevelData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
