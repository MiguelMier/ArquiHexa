package com.helloworld.examples.services.users.create;

import com.helloworld.examples.enums.Role;
import com.helloworld.examples.exceptions.InsufficientPrivilegesException;
import com.helloworld.examples.models.User;
import com.helloworld.examples.port.in.users.create.CreateUserUseCase;
import com.helloworld.examples.port.in.users.create.models.CreateUserInput;
import com.helloworld.examples.port.in.users.create.models.CreateUserOutput;
import com.helloworld.examples.port.out.users.create.CreateUserRepository;
import com.helloworld.examples.port.out.users.files.FileCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    //private final CreateUserRepository userRepository;
    private final FileCreator fileCreator;

    @Override
    public CreateUserOutput createUser(CreateUserInput input) throws Exception {
        input.validate();
        User newUser = input.getNewUserData();
        if (!Role.ADMINISTRATOR.equals(input.getWho().getRole())) throw new InsufficientPrivilegesException();

        String userData = "User ID: " + newUser.getUserId() + "\n" +
                "Name: " + newUser.getName() + " " + newUser.getSurname() + "\n" +
                "Email: " + newUser.getEmail() + "\n" +
                "Role: " + newUser.getRole() + "\n";


        try {
            fileCreator.writeToFile(userData);
        } catch (IOException e) {
            throw new Exception("Error al escribir en el archivo: " + e.getMessage());
        }

        return CreateUserOutput.builder().newUser(newUser).build();
    }


}
