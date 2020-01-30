package br.com.hbsis.hbsis.year;

public class YearDTO {

    private Long id;
    private String nameYear;

    public YearDTO() {
    }

    public YearDTO(Long id, String nameYear) {
        this.id = id;
        this.nameYear = nameYear;
    }

    public static YearDTO of(Year year) {
        return new YearDTO(
                year.getId(),
                year.getNameYear()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameYear() {
        return nameYear;
    }

    public void setNameYear(String nameYear) {
        this.nameYear = nameYear;
    }

    @Override
    public String toString() {
        return "YearDTO{" +
                "id=" + id +
                ", nameYear='" + nameYear + '\'' +
                '}';
    }
}
