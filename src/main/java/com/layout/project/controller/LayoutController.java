package com.layout.project.controller;

import com.layout.project.model.Layout;
import com.layout.project.model.User;
import com.layout.project.repository.UserRepository;
import com.layout.project.service.LayoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/layouts")
public class LayoutController {

    @Autowired
    private LayoutService layoutService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Layout> getAllLayouts(){
        return layoutService.getAllLayouts();
    }

    @PostMapping("/assign/user")
    public void assignLayoutToUser(@RequestParam Long userId, @RequestParam Long layoutId){
        layoutService.assignLayoutToUser(userId, layoutId);
    }

    @PostMapping("/assign/group")
    public void assignLayoutToUserGroup(@RequestParam Long groupId, @RequestParam Long layoutId){
        layoutService.assignLayoutToUserGroup(groupId, layoutId);
    }

    @GetMapping("/user/{userId}")
    public Layout getLayoutForUser(@PathVariable Long userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println("User: " + user);
        return layoutService.getLayoutForUser(user);
    }

    @PutMapping("/assign/update")
    public void updateLayoutForUser(@RequestParam Long userId, @RequestParam Long layoutId) {
        // Update logic
        layoutService.updateLayoutForUser(userId, layoutId);
    }
}
