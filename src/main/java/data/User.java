package data;

public class User {

    private String fname;
    private String lname;
    private String dateOfBirth;
    private CountryData country;
    private CityData city;
    private EnglishLevelData englishLevel;
    private String email;
    private String phone;

    public User(String fname, String lname, String dateOfBirth, CountryData country, CityData city, EnglishLevelData englishLevel, String email, String phone) {
        this.fname = fname;
        this.lname = lname;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.city = city;
        this.englishLevel = englishLevel;
        this.email = email;
        this.phone = phone;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public CountryData getCountry() {
        return country;
    }

    public CityData getCity() {
        return city;
    }

    public EnglishLevelData getEnglishLevel() {
        return englishLevel;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
