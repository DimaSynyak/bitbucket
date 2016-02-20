package ua.lardy.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.lardy.project.beans.category.CategoryList;
import ua.lardy.project.beans.messages.MessageList;
import ua.lardy.project.services.datails.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by root on 8/12/15.
 */
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryList categoryList;

    @Autowired
    private MessageList messageList;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        return "login";
    }

    @Secured(value = "ROLE_USER")
    @RequestMapping("/edit")
    public String edit(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView = new ModelAndView();
        return "edit";
    }

    @Secured(value = "ROLE_USER")
    @RequestMapping("/view")
    public String view(HttpServletRequest request, HttpServletResponse response){

        return "view";
    }

//
//    @RequestMapping("/main")
//    public ModelAndView main(HttpServletRequest request, HttpServletResponse response){
//        String name = null;
//        if (request.getUserPrincipal() != null) {
//            name = request.getUserPrincipal().getName();
//        }
//        ModelAndView model = new ModelAndView();
//        model.setViewName("main");
//        model.addObject("genres", categoryList.getCategories());
//
//        if (name == null){
//            return model;
//        }
//
//
//        return model;
//    }
//
//    @RequestMapping(value = "/books/genreId={genreId}")
//    public ModelAndView getGenreId(@PathVariable String genreId, HttpServletRequest request, HttpServletResponse response){
//        String name = null;
//        if (request.getUserPrincipal() != null) {
//            name = request.getUserPrincipal().getName();
//        }
//        ModelAndView model = new ModelAndView();
//        model.setViewName("books");
////        model.addObject("books", messageList.getBooksByGenreId(genreId));
//        model.addObject("genres", categoryList.getCategories());
//        model.addObject("imgBook", "../resources/images/image_title_book2.jpg");
//
//        if (name == null){
//            return model;
//        }
////        Person person = userService.getPerson(name);
////
////        model.addObject("name", person.getName());
////        model.addObject("role", person.getRole());
//
//        return model;
//    }
//
//    @RequestMapping(value = "/books/image={bookId}", method = RequestMethod.GET)
//    public void getImage(@PathVariable String bookId, HttpServletRequest request, HttpServletResponse response){
//        try{
//            response.setContentType("image/jpeg");
//            OutputStream out = response.getOutputStream();
//
////            Message message = messageList.getBook(Integer.parseInt(bookId));
////            response.setContentLength(message.getImage().length);
////            out.write(message.getImage());
//            return;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @RequestMapping(value = "/books/bookletter={bookLetter}")
//    public ModelAndView getBooks(@PathVariable String bookLetter, HttpServletRequest request, HttpServletResponse response){
//        String name = null;
//        if (request.getUserPrincipal() != null) {
//            name = request.getUserPrincipal().getName();
//        }
//        ModelAndView model = new ModelAndView();
//        model.setViewName("books");
////        model.addObject("books", messageList.getBooksByLetter(bookLetter));
//        model.addObject("genres", categoryList.getCategories());
//        model.addObject("imgBook", "../resources/images/image_title_book2.jpg");
//
//        if (name == null){
//            return model;
//        }
////        Person person = userService.getPerson(name);
////
////        model.addObject("name", person.getName());
////        model.addObject("role", person.getRole());
//
//        return model;
//    }
//
//    @RequestMapping(value = "/books/search", method = RequestMethod.GET)
//    public ModelAndView getBooksSearch(HttpServletRequest request, HttpServletResponse response){
//        String name = null;
//        if (request.getUserPrincipal() != null) {
//            name = request.getUserPrincipal().getName();
//        }
//        String line = request.getParameter("search_string");
//        ModelAndView model = new ModelAndView();
//        model.addObject("search_string", line);
//        model.setViewName("books");
////        model.addObject("books", messageList.getBooksByLetter(line));
//        model.addObject("genres", categoryList.getCategories());
//        model.addObject("imgBook", "../resources/images/image_title_book2.jpg");
//
//        if (name == null){
//            return model;
//        }
////        Person person = userService.getPerson(name);
////
////        model.addObject("name", person.getName());
////        model.addObject("role", person.getRole());
//
//        return model;
//    }
//
//    @Secured(value = "ROLE_ADMIN")
//    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
//    public ModelAndView addBook(HttpServletRequest request, HttpServletResponse response){
//        String name = null;
//        if (request.getUserPrincipal() != null) {
//            name = request.getUserPrincipal().getName();
//        }
//        ModelAndView model = new ModelAndView();
//        model.setViewName("addBooks");
//        model.addObject("genres", categoryList.getCategories());
//        model.addObject("imgBook", "/resources/images/image_title_book2.jpg");//warning
//
//        if (name == null){
//            return model;
//        }
////        Person person = userService.getPerson(name);
////
////        model.addObject("name", person.getName());
////        model.addObject("role", person.getRole());
//
//        return model;
//    }
//
//    @Secured(value = "ROLE_ADMIN")
//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    public ModelAndView handleFileUpload(
//                               @RequestParam("image") MultipartFile file,
//                               HttpServletRequest request,
//                               HttpServletResponse response){
//        String name = null;
//        if (request.getUserPrincipal() != null) {
//            name = request.getUserPrincipal().getName();
//        }
//        ModelAndView model = new ModelAndView();
//        model.setViewName("addBooks");
//        model.addObject("genres", categoryList.getCategories());
//        model.addObject("imgBook", "/resources/images/image_title_book2.jpg");
//        model.addObject("upload", true);
//        try {
//            request.getSession().setAttribute("image", file.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (name == null){
//            return model;
//        }
////        Person person = userService.getPerson(name);
////
////        model.addObject("name", person.getName());
////        model.addObject("role", person.getRole());
//
//        return model;
//    }
//
//    @Secured(value = "ROLE_ADMIN")
//    @RequestMapping(value = "/addbook/editbook", method = RequestMethod.GET)
//    public void editimage(HttpServletRequest request, HttpServletResponse response){
//        HttpSession session = request.getSession();
//        byte[] image = (byte[]) session.getAttribute("image");
//        try{
//            if (image == null){
////                image = messageList.getBook(Integer.parseInt("1")).getImage();
//            }
//
//
//            response.setContentType("image/jpeg");
//            OutputStream out = response.getOutputStream();
//
//            response.setContentLength(image.length);
//            out.write(image);
//            return;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Secured(value = "ROLE_ADMIN")
//    @RequestMapping(value = "/validate", method = RequestMethod.POST)
//    public ModelAndView validate(@RequestParam("file") MultipartFile file,
//                                         HttpServletRequest request,
//                                         HttpServletResponse response){
//        HttpSession session = request.getSession();
//        byte[] content = null;
//        byte[] image = (byte[]) session.getAttribute("image");
//
//        if (!file.isEmpty() ){
//            try {
//                content = file.getBytes();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        boolean flag = true;
//        ModelAndView model = new ModelAndView();
//
//        String authorName = request.getParameter("authorName");
//        String authorBirthday = request.getParameter("authorBirthday");
//        String bookName = request.getParameter("bookName");
//        String pageCount = request.getParameter("pageCount");
//        String publisherName = request.getParameter("publisherName");
//        String publisherYear = request.getParameter("publisherYear");
//        String genreName = request.getParameter("genreName");
//        String isbn = request.getParameter("isbn");
//
//        if (authorName == null || authorName.equals("")){
//            flag = false;
//            model.addObject("authorName", "*required field input");
//        }
//        else {
//            model.addObject("authorName", "");
//        }
//
//        if (authorBirthday == null || authorBirthday.equals("")){
//            flag = false;
//            model.addObject("authorBirthday", "*required field input");
//        }
//        else {
//            model.addObject("authorBirthday", "");
//        }
////
//        if (bookName == null || bookName.equals("")){
//            flag = false;
//            model.addObject("bookName", "*required field input");
//        }
//        else {
//            model.addObject("bookName", "");
//        }
////
//        if (pageCount == null || pageCount.equals("")){
//            flag = false;
//            model.addObject("pageCount", "*required field input");
//        }
//        else {
//            model.addObject("pageCount", "");
//        }
////
//        if (publisherName == null || publisherName.equals("")){
//            flag = false;
//            model.addObject("publisherName", "*required field input");
//        }
//        else {
//            model.addObject("publisherName", "");
//        }
////
//        if (publisherYear == null || publisherYear.equals("")){
//            flag = false;
//            model.addObject("publisherYear", "*required field input");
//        }
//        else {
//            model.addObject("publisherYear", "");
//        }
//
//        if (isbn == null || isbn.equals("")){
//            flag = false;
//            model.addObject("isbn", "*required field input");
//        }
//        else {
//            model.addObject("isbn", "");
//        }
//
//
//        if (flag){
//            Author author = new Author();
//            author.setName(authorName);
////            author.setBirthday(Date.valueOf(authorBirthday));
//
////            Publisher publisher = new Publisher();
////            publisher.setName(publisherName);
////
////            Message messages = new Message();
////            messages.setName(bookName);
////            messages.setPage_count(Integer.parseInt(pageCount));
////            messages.setImage(image);
////            messages.setIsbn(isbn);
////            messages.setContent(content);
////            messages.setPublish_year(Date.valueOf(publisherYear));
////            messages.setAuthor(author);
////            messages.setPublish(publisher);
//
//
//            session.setAttribute("state", "Кгига записана");
//        }
//        else {
//            session.setAttribute("state", "Ошибка записи книги");
//        }
//
//        String name = null;
//        if (request.getUserPrincipal() != null) {
//            name = request.getUserPrincipal().getName();
//        }
//
//        model.setViewName("addBooks");
//        model.addObject("genres", categoryList.getCategories());
//        model.addObject("imgBook", "/resources/images/image_title_book2.jpg");//warning
//        model.addObject("upload", true);
//
//        if (name == null){
//            return model;
//        }
////        Person person = userService.getPerson(name);
////
////        model.addObject("name", person.getName());
////        model.addObject("role", person.getRole());
//
//        return model;
//    }

}
