package com.helloworld.examples.port.in.users.update.models;

import com.helloworld.examples.exceptions.InvalidParameterException;
import com.helloworld.examples.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class UpdateUserInput {

    User who;
    Long userToUpdateID;
    User userToUpdate;

    public void validate() throws InvalidParameterException {
        if (!userToUpdate.getEmail().contains("@")) throw new InvalidParameterException();
    }
}
