package studentmis;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private final List<Student> students = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", students);
        return "index";
    }

    @PostMapping("/add")
    public String addStudent(
            @RequestParam String name,
            @RequestParam String course,
            @RequestParam String email) {

        students.add(new Student(name, course, email));
        return "redirect:/";
    }

    public static class Student {
        private String name;
        private String course;
        private String email;

        public Student(String name, String course, String email) {
            this.name = name;
            this.course = course;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public String getCourse() {
            return course;
        }

        public String getEmail() {
            return email;
        }
    }
}