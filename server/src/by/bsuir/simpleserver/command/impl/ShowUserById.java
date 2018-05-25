package by.bsuir.simpleserver.command.impl;

import by.bsuir.simpleserver.command.Command;
import by.bsuir.simpleserver.command.util.JsonConverter;
import by.bsuir.simpleserver.entity.User;
import by.bsuir.simpleserver.repository.UserRepository;
import by.bsuir.simpleserver.server.util.ResponseStorage;

import java.io.IOException;
import java.io.OutputStream;

public class ShowUserById implements Command {

    @Override
    public void execute(String request, OutputStream outputStream) throws IOException {
        long id = Long.parseLong(request.substring(request.lastIndexOf("/") + 1, request.length()).trim());
        User user = UserRepository.findById(id);
        String json = JsonConverter.toJson(user);

        String response = ResponseStorage.get200Response() + json;
        outputStream.write(response.getBytes());
    }
}
