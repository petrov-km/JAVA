package main;

import main.model.Task;
import main.model.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

   // @Autowired
    private final TaskRepository taskRepository;
    public TaskController (TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks/")
    public List<Task> list() {
        Iterable<Task> taskIterable = taskRepository.findAll();
        List<Task> taskList = new ArrayList<>();
        for (Task task: taskIterable){
            taskList.add(task);
        }
        return taskList;
       // return Storage.getAllTasks();
    }

    @PostMapping("/tasks/")
    public int add(Task task) {
        Task newTask = taskRepository.save(task);
        return newTask.getId();
        //return Storage.addTask(task);
    }

    @DeleteMapping("/tasks/{id}")
        public ResponseEntity delete (@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!(optionalTask.isPresent())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        taskRepository.deleteById(id);
        return new ResponseEntity(optionalTask.get(), HttpStatus.OK);
        /*
        Task task = Storage.deleteTask(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(task, HttpStatus.OK);*/
    }

    @DeleteMapping("/tasks/")
    public void clear() {
        taskRepository.deleteAll();
        //Storage.deleteAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!(optionalTask.isPresent())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalTask.get(), HttpStatus.OK);
        /*Task task = Storage.getTask(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(task, HttpStatus.OK);*/
    }

    @PatchMapping("/tasks/{id}")
    @ResponseBody
    public ResponseEntity method(@PathVariable int id,
                                 @RequestParam(value = "text", required = false) String text,
                                 @RequestParam(value = "date", required = false) String date) {

        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!(optionalTask.isPresent())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Task task = optionalTask.get();
        if (!(text == null)) {
            task.setText(text);
        }
        if (!(date == null)) {
            task.setDate(date);
        }
        taskRepository.save(task);
        return new ResponseEntity(task, HttpStatus.OK);

        /*Task task = Storage.editTask(id,text,date);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(task, HttpStatus.OK);*/
    }
}
