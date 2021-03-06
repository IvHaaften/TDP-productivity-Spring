package TDPproductivitySpring.task.controllers;

import TDPproductivitySpring.project.model.Project;
import TDPproductivitySpring.task.model.Task;
import TDPproductivitySpring.task.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TaskController {
    final String url="/task";

    @Autowired private TaskService taskService;

    @PostMapping(url)
    public Task create (@RequestBody Task task){
        return taskService.save(task);
    }

    @GetMapping(url)
    public List<Task> findAll(){
        Iterable<Task> temp = taskService.findAll();
        //System.out.println(temp);

        List<LocalTime> projectTimes = new ArrayList<>();





        return (List<Task>)taskService.findAll();

    }


    @GetMapping(url +"/{id}")
    public Optional<Task> taskById(@PathVariable int id){
        System.out.println(taskService.findById(id));
        return taskService.findById(id);
    }

    @PutMapping(url)
    public Task update(@RequestBody Task task){
        return taskService.save(task);
    }

    @PatchMapping(url+"/{id}")
    public Task updatePartialByID(@RequestBody Task task, @PathVariable int id){
        task.setId(id);
        return taskService.save(task);
    }

    @PatchMapping(url)
    public Task updatePartial(@RequestBody Task task){
        return taskService.save(task);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @DeleteMapping(url +"/{id}")
    public void delete(@PathVariable int id){
        taskService.deleteById(id);
    }

    /*
    @GetMapping(url +"/{id}")
    public Optional<Task> taskById(@PathVariable int id){
        return taskService.findById(id);
    }

     */
/*
    @GetMapping(url+"Proj={name}")
    public Optional<Task> findByProjectId(@PathVariable String name){
        return taskService.findByProjectId(name);
    }

 */



}
