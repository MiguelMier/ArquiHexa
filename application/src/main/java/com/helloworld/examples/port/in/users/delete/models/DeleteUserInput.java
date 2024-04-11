package com.helloworld.examples.port.in.users.delete.models;

import com.helloworld.examples.exceptions.InvalidParameterException;
import com.helloworld.examples.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Data
public class DeleteUserInput {
    User who;
    Long userToDelete;

    public void validate() throws InvalidParameterException {
        if (userToDelete <= 0) throw new InvalidParameterException();
    }
}
