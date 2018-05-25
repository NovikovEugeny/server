package by.bsuir.simpleserver.server;

import by.bsuir.simpleserver.command.Command;
import by.bsuir.simpleserver.command.CommandProvider;
import by.bsuir.simpleserver.server.util.ResponseStorage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {

    private Socket socket;
    private OutputStream outputStream;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        this.outputStream = socket.getOutputStream();
    }

    @Override
    public void run() {
        try {
            try {
                String uri = getURI();
                CommandProvider commandProvider = CommandProvider.getInstance();
                Command command = commandProvider.getCommand(uri);
                command.execute(uri, outputStream);

                socket.close();
            } catch (IllegalArgumentException exc) {
                sendNotFoundError();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getURI() throws IOException {
        InputStream inputStream = socket.getInputStream();
        String startHeader = new Scanner(inputStream).nextLine();

        return startHeader.substring(startHeader.indexOf(" "), startHeader.lastIndexOf(" ")).trim();
    }

    private void sendNotFoundError() throws IOException {
        outputStream.write(ResponseStorage.get404Response().getBytes());
    }
}
