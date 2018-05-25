package by.bsuir.simpleserver.command.util;

import by.bsuir.simpleserver.entity.User;

import java.util.List;

public final class JsonConverter {

    public static String toJson(User user) {
        StringBuffer buffer = new StringBuffer();

        if (user != null) {
            buffer.append("{");
            buffer.append("\"id\" : ");
            buffer.append(user.getId());
            buffer.append(", ");
            buffer.append("\"name\" : \"");
            buffer.append(user.getName());
            buffer.append("\", ");
            buffer.append("\"login\" : \"");
            buffer.append(user.getLogin());
            buffer.append("\", ");
            buffer.append("\"password\" : \"");
            buffer.append(user.getPassword());
            buffer.append("\"");
            buffer.append("}");
        }

        return buffer.toString();
    }

    public static String toJsonArray(List<User> users) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");

        users.forEach(user -> {
            buffer.append(toJson(user));
            buffer.append(", ");
        });

        String result = buffer.substring(0, buffer.length() - 2);
        result = result + "]";

        return result;
    }
}
