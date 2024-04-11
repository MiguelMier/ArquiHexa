package com.helloworld.examples.port.in.users.update;

import com.helloworld.examples.exceptions.InsufficientPrivilegesException;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserInput;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserOutput;
import com.helloworld.examples.port.in.users.update.models.UpdateUserInput;
import com.helloworld.examples.port.in.users.update.models.UpdateUserOutput;

public interface UpdateUserUseCase {

    UpdateUserOutput updateContactData(UpdateUserInput input) throws InsufficientPrivilegesException;
}
