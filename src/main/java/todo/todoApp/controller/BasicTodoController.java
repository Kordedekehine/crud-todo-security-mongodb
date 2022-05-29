package todo.todoApp.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import todo.todoApp.model.Todo;
import todo.todoApp.service.BasicService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/todobs")
public class BasicTodoController {

   private final BasicService basicService;

    public BasicTodoController(BasicService basicService) {
        this.basicService = basicService;
    }

    @GetMapping
     public List<Todo> getTodos(){
        return basicService.getAllStudents();
     }

     @PostMapping
     public void addTodos(@RequestBody Todo todo){
        basicService.addTodo(todo);
     }

     @DeleteMapping(path = "{todoId}")
    public void deleteMapping(@PathVariable ("todoId") Long id){
        basicService.deleteTodos(id);
     }

//    @InitBinder
//    public void dateBinder(WebDataBinder binder){
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat,false));
//    }

     @PutMapping("{todoId}")
    public void updateStudent(@PathVariable ("todoId") Long id,@RequestParam (required = false)String username,
                              @RequestParam String description,@RequestParam Date date){
          basicService.updateTodo(id,username,description,date);
     }
}
