package by.bsuir.simpleserver.command;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public interface Command {
    void execute(String request, OutputStream outputStream) throws IOException;
}
