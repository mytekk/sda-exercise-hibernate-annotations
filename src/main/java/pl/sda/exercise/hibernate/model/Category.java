package pl.sda.exercise.hibernate.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by RENT on 2017-07-14.
 */

//klasa-encja z adnotacjami dla tabelki category z bazy danych

@Entity
@Table(name = "category")
@NamedQueries(value = {
        @NamedQuery(name="getAllCategories", query = "from Category")
})
public class Category {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Transient //bo takiej kolumny nie ma w bazie danych
    private String subcategory;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER) //druga strona relacji wiele-do-wielu zdefiniowanej w klasie Book
    private Set<Book> setOfBooks;           //korzystam z tamtej definicji, ktora siedzi w polu "categories" i zamiast definiowac
                                            //wszystko tutaj od poczatku, to odwracam relacje i odwoluje sie do tamtego pola
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getSetOfBooks() {
        return setOfBooks;
    }

    public void setSetOfBooks(Set<Book> setOfBooks) {
        this.setOfBooks = setOfBooks;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
