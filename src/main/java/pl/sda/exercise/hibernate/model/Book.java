package pl.sda.exercise.hibernate.model;

import javax.persistence.*;
import java.util.Set;

//klasa- encja z adnotacjami

@Entity //ta adnotacja mowi, ze ta klasa bedzie encja hibernetowa
@Table(name="book") //podajemy nazwe tabelki w bazie
@NamedQueries(value={   //nazwa zapytania - do poznejszego wykorzystania np. w BookService
        @NamedQuery(name="ourQueryForAllBooks", query="from Book"),
        @NamedQuery(name="countBooksQuery", query = "select count(*) from Book"),
        @NamedQuery(name="getBookById", query = "from Book b where b.id = :id"),
        @NamedQuery(name="getBooksByTitle", query = "from Book b where b.title like :title"),
})
public class Book {

    @Id //mowi, ze to pole bedzie odpowiadalo za przechowywanie auto incrementa z bazy danych
    @Column(name="id") //nazwa kolumnyz bazy zawierajaca glowne id tabelki
    @GeneratedValue(strategy=GenerationType.IDENTITY) //sposob generowania kolejnej wartosci id; identity - odpowiednik native z klasycznego hiberneta
    private Integer id;

    @Column(name="title") //nazwa kolumny z bazy
    private String title;

    @ManyToOne(fetch=FetchType.EAGER) //okresla, ze pole bookAuthor bedzie wskazywalo na relacje wiele-do-jeden (do autora ksiazki)
    @JoinColumn(name="author_id")           //fetch=FetchType.EAGER - wylacza lazy loading
    private Author bookAuthor;

    @ManyToMany(fetch = FetchType.EAGER)    //okresla, ze pole categories bedzie wskazywalo na relacje wiele-do-wiele pomiedzy ksiazka a kategoriami
    @JoinTable(joinColumns = @JoinColumn(name = "book_id"), //pierwsza strona relacji
    inverseJoinColumns = @JoinColumn(name = "category_id")     ,      //druga strona relacji
            name="book_category"  //nazwa tabelki przechowujacej relacje wiele-do-wielu
    )
    private Set<Category> categories;


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

    public Author getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(Author bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + "]";
    }




}