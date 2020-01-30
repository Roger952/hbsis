package br.com.hbsis.hbsis.year;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YearDTO)) return false;
        YearDTO yearDTO = (YearDTO) o;
        return id.equals(yearDTO.id) &&
                nameYear.equals(yearDTO.nameYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameYear);
    }
}
