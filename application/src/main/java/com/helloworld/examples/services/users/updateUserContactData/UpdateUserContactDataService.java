package com.helloworld.examples.services.users.updateUserContactData;

import com.helloworld.examples.enums.Role;
import com.helloworld.examples.exceptions.InsufficientPrivilegesException;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserOutput;
import com.helloworld.examples.port.in.users.updateUserContactData.UpdateUserContactDataUseCase;
import com.helloworld.examples.port.in.users.updateUserContactData.models.UpdateUserContactDataInput;
import com.helloworld.examples.port.in.users.updateUserContactData.models.UpdateUserContactDataOutput;
import com.helloworld.examples.port.out.users.files.FileCreator;
import com.helloworld.examples.port.out.users.updateUserContactData.UpdateUserContactDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@AllArgsConstructor
public class UpdateUserContactDataService implements UpdateUserContactDataUseCase {

    //private UpdateUserContactDataRepository repository;
    private FileCreator fileCreator;

    private static boolean userIsGoingToChangeOwnData(UpdateUserContactDataInput input) {
        return input.getWho().getUserId().equals(input.getUserToChange().getUserId());
    }

    @Override
    public UpdateUserContactDataOutput updateUserContactData(UpdateUserContactDataInput input) throws InsufficientPrivilegesException {
        UpdateUserContactDataOutput output = new UpdateUserContactDataOutput();

        if (!input.getWho().getRole().equals(Role.ADMINISTRATOR) && !userIsGoingToChangeOwnData(input)) {
            throw new InsufficientPrivilegesException();
        }
        try {
            //repository.updateUserContactData(input.getUserToChange());
            try {
                String updatedUserData = "User ID: " + input.getUserToChange().getUserId() + "\n";

                fileCreator.deleteLine(updatedUserData);
                String newUserData = "User ID: " + input.getUserToChange().getUserId() + "\n" +
                        "Name: " + input.getUserToChange().getName() + " " + input.getUserToChange().getSurname() + "\n" +
                        "Email: " + input.getUserToChange().getEmail() + "\n" +
                        "Role: " + input.getUserToChange().getRole() + "\n";
                fileCreator.writeToFile(newUserData);
            } catch (IOException e) {
                return UpdateUserContactDataOutput.builder().success(false).build();
            }

            output.setSuccess(true);
        } catch (Exception e) {
            output.setSuccess(false);
        }
        return output;
    }
}
