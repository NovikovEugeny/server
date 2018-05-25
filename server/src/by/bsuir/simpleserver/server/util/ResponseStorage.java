package by.bsuir.simpleserver.server.util;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class ResponseStorage {

    public static String get404Response() {
        DateFormat df = DateFormat.getTimeInstance();
        df.setTimeZone(TimeZone.getTimeZone("GMT"));

        StringBuffer buffer = new StringBuffer();
        buffer.append("HTTP/1.1 404 Not Found\n");
        buffer.append("Date: ");
        buffer.append(df.format(new Date()));
        buffer.append('\n');
        buffer.append("Content-Type: text/plain\n");
        buffer.append("Connection: close\n");
        buffer.append("Server: Server\n");
        buffer.append("Pragma: no-cache\n\n");
        buffer.append("Not found!");

        return buffer.toString();
    }

    public static String get200Response() {
        DateFormat df = DateFormat.getTimeInstance();
        df.setTimeZone(TimeZone.getTimeZone("GMT"));

        StringBuffer buffer = new StringBuffer();
        buffer.append("HTTP/1.1 200 OK\n");
        buffer.append("Date: ");
        buffer.append(df.format(new Date()));
        buffer.append('\n');
        buffer.append("Content-Type: application/json\n");
        buffer.append("Connection: close\n");
        buffer.append("Server: Server\n");
        buffer.append("Pragma: no-cache\n\n");

        return buffer.toString();
    }
}
