package people;

public class Person {
    private String name;
    private String region;
    private Integer yearOfBirth;

    public Person(String name, String region, Integer yearOfBirth) {
        this.name = name;
        this.region = region;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getYearOfBirth() {
        return this.yearOfBirth;
    }

    public void setYear(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

}
