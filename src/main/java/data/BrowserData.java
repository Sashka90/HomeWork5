package data;

public enum BrowserData {
    CHROME("chrome");

    public String getName() {
        return name;
    }

    private String name;

    BrowserData(String name) {
        this.name = name;
    }
}
