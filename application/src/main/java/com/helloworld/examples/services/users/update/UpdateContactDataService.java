package com.helloworld.examples.services.users.update;

import com.helloworld.examples.enums.Role;
import com.helloworld.examples.exceptions.InsufficientPrivilegesException;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserOutput;
import com.helloworld.examples.port.in.users.update.UpdateUserUseCase;
import com.helloworld.examples.port.in.users.update.models.UpdateUserInput;
import com.helloworld.examples.port.in.users.update.models.UpdateUserOutput;
import com.helloworld.examples.port.out.users.update_contact_data.UpdateContactDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateContactDataService implements UpdateUserUseCase {

    private final UpdateContactDataRepository updateContactDataRepository;


    @Override
    public UpdateUserOutput updateContactData(UpdateUserInput input) throws InsufficientPrivilegesException {
        if (!Role.ADMINISTRATOR.equals(input.getWho().getRole())) throw new InsufficientPrivilegesException();

        try {
            updateContactDataRepository.updateUser(input.getUserToUpdate());
        } catch (Exception e) {
            return UpdateUserOutput.builder().success(false).build();
        }
        return UpdateUserOutput.builder().success(true).build();
    }
}
