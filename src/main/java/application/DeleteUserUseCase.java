package application;

import domain.entity.User;
import domain.service.UserService;

public class DeleteUserUseCase {
    private final UserService userService;

    public DeleteUserUseCase(UserService userService){
        this.userService =userService;
    }
      public int execute(int id) {
        int rowsUpdate =0;

       return rowsUpdate= userService.DeleteUserById(id);

    }

}
