package com.helloworld.examples.services.users.delete;

import com.helloworld.examples.enums.Role;
import com.helloworld.examples.exceptions.InsufficientPrivilegesException;
import com.helloworld.examples.models.User;
import com.helloworld.examples.port.in.users.delete.DeleteUserUseCase;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserInput;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserOutput;
import com.helloworld.examples.port.out.users.delete.DeleteUserRepository;
import com.helloworld.examples.port.out.users.files.FileCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DeleteUserService implements DeleteUserUseCase {
    //private final DeleteUserRepository userRepository;
    private final FileCreator fileCreator;


    public DeleteUserOutput deleteUser(DeleteUserInput input) throws InsufficientPrivilegesException {
        if (!Role.ADMINISTRATOR.equals(input.getWho().getRole())) {
            throw new InsufficientPrivilegesException();
        }

        long userToDelete = input.getUserToDelete();
        try {
            String deletedUserData = "User ID: " + userToDelete+ "\n";

            fileCreator.deleteLine(deletedUserData);
        } catch (IOException e) {
            return DeleteUserOutput.builder().success(false).build();
        }

        return DeleteUserOutput.builder().success(true).build();
    }
}
