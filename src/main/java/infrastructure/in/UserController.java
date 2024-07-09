package infrastructure.in;

import application.CreateUserUseCase;
import application.DeleteUserUseCase;
import application.FindUserUseCase;
import application.UpdateCaseUseUSer;
import domain.entity.User;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class UserController {
    private CreateUserUseCase createUserUseCase;
    private FindUserUseCase findUserUseCase;
    private DeleteUserUseCase deleteUserUseCase;
    private UpdateCaseUseUSer UpdateCaseUseUSer;

    
    public UserController(CreateUserUseCase createUserUseCase, FindUserUseCase findUserUseCase,
            DeleteUserUseCase deleteUserUseCase, application.UpdateCaseUseUSer updateCaseUseUSer) {
        this.createUserUseCase = createUserUseCase;
        this.findUserUseCase = findUserUseCase;
        this.deleteUserUseCase = deleteUserUseCase;
        UpdateCaseUseUSer = updateCaseUseUSer;
    }



    





    public void start() {
        // try (Scanner scanner = new Scanner(System.in)) {
            // System.out.println("Enter user name: ");
            // String name = scanner.nextLine();
String name = JOptionPane.showInputDialog("Ingrese su nombree");
		JOptionPane.showMessageDialog(null, "Hello " + name);
            // System.out.println("Enter user email: ");
            // String email = scanner.nextLine();

            String email = JOptionPane.showInputDialog("Ingrese su email");
            JOptionPane.showMessageDialog(null, "su email es  " + email);
            User user = new User();
            user.setName(name);
            user.setEmail(email);

            createUserUseCase.execute(user);
        // scanner.close();
        // }

        System.out.println("User created successfully!");
    }

    public void buscar() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter user id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            User user =new User();
            user=findUserUseCase.execute(id);
            System.out.println("Nombre del usuario: "+user.getName());
            System.out.println("Email del usuario: "+user.getEmail());

        }

    }

    public void eliminar() {        
        try (Scanner scanner = new Scanner(System.in)) {
        System.out.println("Enter user id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        int rowsUpdate =0;
        rowsUpdate=deleteUserUseCase.execute(id);
        

    }}

    public void modificar() {  
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter user id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter user name: ");
            String name = scanner.nextLine();

            System.out.println("Enter user email: ");
            String email = scanner.nextLine();

            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setEmail(email);

            UpdateCaseUseUSer.execute(user);

}}}
