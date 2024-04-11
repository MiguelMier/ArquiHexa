package com.helloworld.examples.frontapi.admin.users.update.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.helloworld.examples.frontapi.admin.users.delete.models.DeleteUserResponse;
import com.helloworld.examples.port.in.users.delete.models.DeleteUserOutput;
import com.helloworld.examples.port.in.users.update.models.UpdateUserOutput;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class UpdateUserResponse {

    @JsonProperty("success")
    boolean success;

    public static UpdateUserResponse fromApplicationModel(UpdateUserOutput output) {
        return UpdateUserResponse.builder().success(output.isSuccess()).build();
    }
}
