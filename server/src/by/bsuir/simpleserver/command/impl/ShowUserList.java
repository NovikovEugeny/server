package by.bsuir.simpleserver.command.impl;

import by.bsuir.simpleserver.command.Command;
import by.bsuir.simpleserver.command.util.JsonConverter;
import by.bsuir.simpleserver.entity.User;
import by.bsuir.simpleserver.repository.UserRepository;
import by.bsuir.simpleserver.server.util.ResponseStorage;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ShowUserList implements Command {

    @Override
    public void execute(String request, OutputStream outputStream) throws IOException {
        List<User> users = UserRepository.findAll();
        String jsonArray = JsonConverter.toJsonArray(users);

        String response = ResponseStorage.get200Response() + jsonArray;
        outputStream.write(response.getBytes());
    }
}
