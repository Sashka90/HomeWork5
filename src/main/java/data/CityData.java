package data;

public enum CityData {
    MOSCOW("Москва");

    private String name;

    CityData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
