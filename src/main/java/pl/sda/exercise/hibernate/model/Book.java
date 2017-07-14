package pl.sda.exercise.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//klasa- encja z adnotacjami

@Entity //ta adnotacja mowi, ze ta klasa bedzie encja hibernetowa
@Table(name="book") //podajemy nazwe tabelki w bazie
@NamedQueries(value={   //nazwa zapytania - do poznejszego wykorzystania np. w BookService
        @NamedQuery(name="ourQueryForAllBooks", query="from Book"),
        @NamedQuery(name="countBooksQuery", query = "select count(*) from Book"),
        @NamedQuery(name="getBookById", query = "from Book b where b.id = :id"),
})
public class Book {

    @Id //mowi, ze to pole bedzie odpowiadalo za przechowywanie auto incrementa z bazy danych
    @Column(name="id") //nazwa kolumnyz bazy zawierajaca glowne id tabelki
    @GeneratedValue(strategy=GenerationType.IDENTITY) //sposob generowania kolejnej wartosci id; identity - odpowiednik native z klasycznego hiberneta
    private Integer id;

    @Column(name="title") //nazwa kolumny z bazy
    private String title;


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + "]";
    }




}