package com.helloworld.examples.port.in.users.update.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class UpdateUserOutput {

    private boolean success;
}
