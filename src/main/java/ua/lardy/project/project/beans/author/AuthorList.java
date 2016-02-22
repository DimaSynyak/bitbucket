package ua.lardy.project.project.beans.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ua.lardy.project.project.DAO.author.AuthorDAO;

import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Класс контроллер. Связывает отображение и модель объектов.
 * @author Sinyak D.V
 * @version 1.0
 */
@Named
@SessionScoped
public class AuthorList {

    private List<Author> authors;
    private Author author;

    @Autowired
    private AuthorDAO authorDAO;

    public AuthorList(){}

    /**
     * Метод предназначен возвращать списки объектов класса {@link Author}.
     * @param name строковая переменная, которая принимает на вход имя или часть имени автора. Критерий поиска.
     * @return Возвращает не отсортированный список авторов.
     */
    public List<Author> getAuthorsByName(String name){
        List<Author> authorList = authorDAO.getAuthorsByName(name);

        return authorList;
    }

    /**
     * Метод предназначен возвращать объекты, содержащие информацию об авторе
     * @param name строковая переменная, которая принимает на вход имя автора. Критерий поиска.
     * @return Возвращает объект типа {@link Author}
     */
    public Author getAuthorByName(String name){
        Author author = authorDAO.getAuthorByName(name);

        return author;
    }

    /**
     * Метод предназначен для возврата порядкового номера автора из таблицы баз данных. Возвращает порядковый номер автора, который вошел под своей учетной записью
     * @return Возвращает порядковый номер, тип int
     */
    public int getAuthorId(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null)
            return 0;
        String name = auth.getName();
        Author author = getAuthorByName(name);
        return author.getId();
    }

    /**
     * Метод предназначен возвращать объект, класса {@link Author}, из таблицы баз данных, который удовлетворяет критерию поиска.
     * @param login строковая переменная, которая принимает на вход логин пользователя. Критерий поиска.
     * @return Возвращает объект класса {@link Author}.
     */
    public Author getAuthor(String login) {
        Author author = null;
        author = authorDAO.getAuthorByLogin(login);
        return author;
    }
}
