package pl.sda.exercise.hibernate.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="author")
@NamedQueries(value = {
        @NamedQuery(name = "getAuthorsQuery", query = "from Author")
})
public class Author {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @OneToMany(fetch = FetchType.EAGER) //okresla, ze pole books bedzie wskazywalo na relacje jeden-do-wiele (do wielu ksiazek tego autora)
    @JoinColumn(name="author_id")    //fetch=FetchType.EAGER - wylacza lazy loading
    private Set<Book> books;     //hibernate sam sobie wykryje, ze kolumna author_id siedzi w tabeli book i na tej podstawie wyciagnie dane


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }




}