package ru.mirea.itlab.controllers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonSyntaxException;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import ru.mirea.itlab.apiRes.errors.AddError;
import ru.mirea.itlab.apiRes.errors.EntError;
import ru.mirea.itlab.apiRes.errors.JsonError;
import ru.mirea.itlab.apiRes.errors.NullPointerError;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
@ControllerAdvice
@RestController
public class ExceptionController {

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public AddError AddExceptionHandler(HttpServletRequest request,
                                        Exception e, Model model) throws JsonProcessingException {
        return new AddError();
    }
    @ExceptionHandler(value = java.lang.NullPointerException.class)
    public NullPointerError NullExceptionHandler(HttpServletRequest request,
                                                 Exception e, Model model)  {
        System.out.println("Hello java");
        return new NullPointerError();
    }
    @ExceptionHandler(value = JsonSyntaxException.class)
    public JsonError JsonExceptionHandler(HttpServletRequest request,
                                          Exception e, Model model)  {
        return new JsonError("Json error");
    }
    @ExceptionHandler(value = EntityNotFoundException.class)
    public EntError EntityNotFoundExceptionHandler(HttpServletRequest request,
                                               Exception e, Model model) {
        return new EntError();
    }
}
