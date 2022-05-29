package todo.todoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import todo.todoApp.model.Todo;
import todo.todoApp.service.iTodoService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

@Autowired
    iTodoService todoService;

//We need to bind the date with our infos
@InitBinder
public void dateBinder(WebDataBinder binder){

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat,false));
}

      @GetMapping("/list-todos")
    public String showTodos(ModelMap model) {
        String name = getLoggedInUserName(model);
        model.put("todos", todoService.getTodosByUser(name));
        //return model.put("todos", todoSe.retrieveTodos(name));
        return "list-todos";
    }

    private String getLoggedInUserName(ModelMap model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        }

        return principal.toString();
    }

    @GetMapping("add-todo")
    public String showToAddPage(ModelMap modelMap){
    modelMap.addAttribute("todo",new Todo());
       return "todo";
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam long id) {
        todoService.deleteTodo(id);
        // service.deleteTodo(id);
        return "redirect:/list-todos";
    }

    @GetMapping("/update-todo")
    public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
        Todo todo = todoService.getTodoById(id).get();
        model.put("todo", todo);
        return "todo";
    }

    @PutMapping("/update-todo")
    public String updateTodo(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult){

    if (bindingResult.hasErrors()){
        return "todo";
    }
    todo.setUserName(getLoggedInUserName(modelMap));
    todoService.updateTodo(todo);
    return "redirect:list-todos";
    }

    @PostMapping("/add-todo")
    public String addTodo(ModelMap modelMap, @Valid Todo todo, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "todo";
        }
        todo.setUserName(getLoggedInUserName(modelMap));
        todoService.updateTodo(todo);
        return "redirect:add-todos";
    }
}
