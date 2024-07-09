package application;

import domain.entity.User;
import domain.service.UserService;

public class UpdateCaseUseUSer {
    private final UserService userService;

    public UpdateCaseUseUSer(UserService userService) {
        this.userService = userService;
    }
        public void execute(User user) {
        userService.updatUserById(user);
    }

}
