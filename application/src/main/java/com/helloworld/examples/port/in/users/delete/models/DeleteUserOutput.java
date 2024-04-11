package com.helloworld.examples.port.in.users.delete.models;

import com.helloworld.examples.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class DeleteUserOutput {

    boolean success;
}
