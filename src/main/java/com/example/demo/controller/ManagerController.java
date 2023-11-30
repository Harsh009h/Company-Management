package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Employee;
import com.example.demo.service.ClientService;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ManagerController {


    @Autowired
    private EmployeeService studentService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/students")
    public ModelAndView getAllStudents(ModelAndView model){
            List<Employee> students = studentService.getStudents();
            model.addObject("students",students);
            model.setViewName("students");
            return model;
    }

    @GetMapping("/student/search")
    public ModelAndView getStudentByRollNo(@RequestParam String rollNo, ModelAndView model){
        Employee student = studentService.getStudentByRollNo(rollNo);
        model.addObject("student",student);
        model.setViewName("studentDetails");
        return model;
    }

    @GetMapping("/student/create")
    public ModelAndView createStudent(ModelAndView model){
        Employee student = new Employee();
        model.setViewName("createStudent");
        model.addObject("student",student);
        return model;
    }

    @PostMapping("/student/save")
    public ModelAndView createStudent(@ModelAttribute Employee student, ModelAndView model){
        boolean result = studentService.saveStudent(student);
        student = new Employee();
        model.setViewName("createStudent");
        model.addObject("student",student);
        model.addObject("success", result);
        return model;
    }

    @GetMapping("/student/edit")
    public ModelAndView editStudent(@RequestParam String rollNo, ModelAndView model){
        Employee student = studentService.getStudentByRollNo(rollNo);
        model.addObject("student",student);
        model.setViewName("updateStudent");
        return model;
    }

    @PostMapping("/student/update")
    public ModelAndView updateStudent(@ModelAttribute Employee student, ModelAndView model){
        boolean result = studentService.updateStudent(student);
        student = studentService.getStudentByRollNo(student.getRollNo());
        model.addObject("student",student);
        model.setViewName("studentDetails");
        model.addObject("success", result);
        return model;
    }

    @PostMapping("/student/delete")
    public ModelAndView deleteStudent(@RequestParam String studentId, ModelAndView model){

        Boolean deletedBook = studentService.deleteStudent(Integer.parseInt(studentId));
        List<Employee> students =  studentService.getStudents();
        model.setViewName("students");
        model.addObject("students", students);
        model.addObject("success", deletedBook);
        return model;
    }

    @GetMapping("/books")
    public ModelAndView getBooks(ModelAndView model){
        List<Book> books =  bookService.getBooks();
        model.setViewName("books");
        model.addObject("books", books);
        return model;
    }

    @GetMapping("/book/search")
    public ModelAndView getBookByIsbn(@RequestParam  String isbn, ModelAndView model){
        Book book =  bookService.getBookByIsbn(isbn);
        model.addObject("book",book);
        model.setViewName("bookDetails");
        return model;
    }

    @GetMapping("/book/create")
    public ModelAndView createBook(ModelAndView model){
        Book book = new Book();
        model.setViewName("createBook");
        model.addObject("book",book);
        return model;
    }

    @PostMapping("/book/save")
    public ModelAndView createBook(@ModelAttribute Book book, ModelAndView model){
        boolean result = bookService.addBook(book);
        book = new Book();
        model.setViewName("createBook");
        model.addObject("book",book);
        model.addObject("success", result);
        return model;

    }

    @GetMapping("/book/edit")
    public ModelAndView editBook(@RequestParam String isbn, ModelAndView model){
        Book book =  bookService.getBookByIsbn(isbn);
        model.addObject("book",book);
        model.setViewName("updateBook");
        return model;
    }

    @PostMapping("/book/update")
    public ModelAndView updateBook(@ModelAttribute Book book, ModelAndView model){
        boolean result = bookService.updateBook(book);
        book =  bookService.getBookByIsbn(book.getIsbn());
        model.addObject("book",book);
        model.setViewName("bookDetails");
        model.addObject("success", result);
        return model;
    }

    @PostMapping("/book/delete")
    public ModelAndView deleteBook(@RequestParam int bookId, ModelAndView model){
        Boolean success = bookService.deleteBook(bookId);
        List<Book> books =  bookService.getBooks();
        model.setViewName("books");
        model.addObject("books", books);
        model.addObject("success", success);
        return model;
    }
}
