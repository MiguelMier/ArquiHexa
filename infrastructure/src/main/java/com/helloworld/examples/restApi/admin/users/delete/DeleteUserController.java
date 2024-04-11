package com.helloworld.examples.restApi.admin.users.delete;

import com.helloworld.examples.frontapi.admin.users.delete.models.DeleteUserRequest;
import com.helloworld.examples.frontapi.admin.users.delete.models.DeleteUserResponse;
import com.helloworld.examples.port.in.users.delete.DeleteUserUseCase;
import com.helloworld.examples.restApi.admin.users.create.models.CreateUserRequest;
import com.helloworld.examples.restApi.admin.users.create.models.CreateUserResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("restapi/users")
@RestController
@Controller
@RequiredArgsConstructor
public class DeleteUserController {

    private final DeleteUserUseCase useCase;

    @PostConstruct
    void init() {
        System.out.println("DeleteUserController has been created");
    }

    @PostMapping(path = "/delete")
    DeleteUserResponse deleteUser(@RequestBody DeleteUserRequest request) throws Exception {
        var output = useCase.deleteUser(request.toApplicationModel());
        return DeleteUserResponse.fromApplicationModel(output);
    }
}
