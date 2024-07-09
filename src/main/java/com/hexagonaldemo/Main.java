package com.hexagonaldemo;

import javax.swing.JOptionPane;

import application.CreateUserUseCase;
import application.DeleteUserUseCase;
import application.FindUserUseCase;
import application.UpdateCaseUseUSer;
import domain.service.UserService;
import infrastructure.in.UserController;
import infrastructure.out.UserRepository;

public class Main {
    public static void main(String[] args) {

        
        Object[] options = { "Crear usuario", "Buscar ususario", "Editar usuario", "Eliminar usuario" };
        Object color = JOptionPane.showInputDialog(null, "Seleccione Una Opcion", 
                "MYSQL", JOptionPane.QUESTION_MESSAGE, null, options, "Crear usuario");
        
        int selectedIndex = -1; // default value for no selection or "Seleccione"
        for (int i = 0; i < options.length; i++) {
            if (options[i].equals(color)) {
                selectedIndex = i;
                break;
            }
        }
        UserService userService = new UserRepository();
        if (selectedIndex == 0) {
            CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
            UserController consoleAdapter = new UserController(createUserUseCase);

            consoleAdapter.start();
        }
        if (selectedIndex == 1) {
         
            FindUserUseCase findUserUseCase = new FindUserUseCase(userService);
            UserController consoleAdapter = new UserController(findUserUseCase);

            consoleAdapter.buscar();
        }
        if (selectedIndex == 2) {
         
            UpdateCaseUseUSer updateCaseUseUSer = new UpdateCaseUseUSer(userService);
            UserController consoleAdapter = new UserController(updateCaseUseUSer);

            consoleAdapter.modificar();
                }

        if (selectedIndex == 3) {
         
            DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCase(userService);
            UserController consoleAdapter = new UserController(deleteUserUseCase);

            consoleAdapter.eliminar();
        }

    }
}