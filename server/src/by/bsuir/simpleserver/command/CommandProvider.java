package by.bsuir.simpleserver.command;

import by.bsuir.simpleserver.command.impl.ShowUserById;
import by.bsuir.simpleserver.command.impl.ShowUserList;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
    private final static CommandProvider INSTANCE = new CommandProvider();

    private final Map<String, Command> repository = new HashMap<>();

    public static CommandProvider getInstance() {
        return INSTANCE;
    }

    private CommandProvider() {
        repository.put("/show-users/", new ShowUserList());
        repository.put("/show-user-by-id/", new ShowUserById());
    }

    public Command getCommand(String commandName) {
        commandName = commandName.substring(commandName.indexOf("/"), commandName.lastIndexOf("/") + 1).trim();

        Command command = repository.get(commandName);

        if (command == null) {
            throw new IllegalArgumentException();
        }

        return command;
    }
}
