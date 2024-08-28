package com.layout.project.service;

import com.layout.project.model.Layout;
import com.layout.project.model.User;
import com.layout.project.model.UserGroup;
import com.layout.project.model.UserLayoutAssignment;
import com.layout.project.repository.LayoutRepository;
import com.layout.project.repository.UserGroupRepository;
import com.layout.project.repository.UserLayoutAssignmentRepository;
import com.layout.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LayoutService {

    @Autowired
    private LayoutRepository layoutRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Autowired
    private UserLayoutAssignmentRepository userLayoutAssignmentRepository;

    public List<Layout> getAllLayouts() {
        return layoutRepository.findAll();
    }

    public void assignLayoutToUser(Long userId, Long layoutId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Layout layout = layoutRepository.findById(layoutId).orElseThrow(() -> new RuntimeException("Layout not found"));

        UserLayoutAssignment assignment = userLayoutAssignmentRepository.findByUser(user)
                .orElse(new UserLayoutAssignment());

        assignment.setUser(user);
        assignment.setLayout(layout);

        userLayoutAssignmentRepository.save(assignment);
    }

    public void assignLayoutToUserGroup(Long userGroupId, Long layoutId){
        UserGroup userGroup = userGroupRepository.findById(userGroupId).orElseThrow(() -> new RuntimeException("User group not found"));
        Layout layout = layoutRepository.findById(layoutId).orElseThrow(() -> new RuntimeException("Layout not found"));

        userGroup.getUsers().forEach(user -> {
            UserLayoutAssignment assignment = userLayoutAssignmentRepository.findByUser(user)
                    .orElse(new UserLayoutAssignment());

            assignment.setUser(user);
            assignment.setUserGroup(userGroup);
            assignment.setLayout(layout);

            userLayoutAssignmentRepository.save(assignment);
        });
    }

    public Layout getLayoutForUser(User user){
        return userLayoutAssignmentRepository.findByUser(user)
                .map(UserLayoutAssignment::getLayout)
                .orElse(null);
    }

    public void updateLayoutForUser(Long userId, Long layoutId) {
        assignLayoutToUser(userId, layoutId);
    }
}
