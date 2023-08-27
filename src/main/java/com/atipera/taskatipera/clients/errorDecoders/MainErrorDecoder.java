package com.atipera.taskatipera.clients.errorDecoders;

import com.atipera.taskatipera.exceptions.UserNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if (methodKey.equals("GitHubUserClient#extractAllUsersRepositoriesByUsername(String)") &&
                response.status() == 404) {
            String errorMessage = "No such user registered on GitHub";
            throw new UserNotFoundException(errorMessage);
        }
        return defaultErrorDecoder.decode(methodKey, response);
    }
}
