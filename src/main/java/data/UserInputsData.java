package data;

public enum UserInputsData {
    FIRST_NAME("fname"),
    LAST_NAME("lname"),
    DATE_OF_BIRTH("date_of_birth"),
    COUNTRY("country"),
    CITY("city"),
    ENGLISH_LEVEL("english_level"),
    EMAIL("email"),
    PHONE("phone"),
    RELOCATE("ready_to_relocate");



    private String name;

    UserInputsData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
