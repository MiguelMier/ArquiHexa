package com.helloworld.examples.frontapi.admin.users.update;

import com.helloworld.examples.frontapi.admin.users.delete.models.DeleteUserRequest;
import com.helloworld.examples.frontapi.admin.users.delete.models.DeleteUserResponse;
import com.helloworld.examples.frontapi.admin.users.update.models.UpdateUserRequest;
import com.helloworld.examples.frontapi.admin.users.update.models.UpdateUserResponse;
import com.helloworld.examples.port.in.users.delete.DeleteUserUseCase;
import com.helloworld.examples.port.in.users.update.UpdateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("frontapi/users")
@RestController
@RequiredArgsConstructor
public class UpdateUserPresenter {

    private final UpdateUserUseCase useCase;

    @PutMapping(path = "/updateContactData")
    UpdateUserResponse updateContactData(@RequestBody UpdateUserRequest request) throws Exception {
        var output = useCase.updateContactData(request.toApplicationModel());
        return UpdateUserResponse.fromApplicationModel(output);
    }
}
