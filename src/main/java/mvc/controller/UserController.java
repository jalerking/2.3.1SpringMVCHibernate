package mvc.controller;


import mvc.entity.User;
import mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @PostMapping("/user/add")
    public String add(@RequestParam("name") String name,
                      @RequestParam("age") Integer age) {
        userService.save(new User(name, age));
        return "redirect:/users";
    }

    @PostMapping("/users/update")
    public String update(@RequestParam("id") Long id,
                         @RequestParam("name") String name,
                         @RequestParam("age") Integer age) {
        User user = new User(name, age);
        user.setId(id);
        userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("/user/delete")
    public String delete(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/users/edit")
    public String edit(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user-edit";
    }
}