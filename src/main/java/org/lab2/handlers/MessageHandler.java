package org.lab2.handlers;


import org.lab2.authorization.User;
import java.io.DataOutputStream;
import java.io.IOException;

public class MessageHandler {

    DataOutputStream dout;

    public void sendLoginAndPassword(String login, String password) throws IOException {
        dout.writeUTF(login);
        dout.writeUTF(password);
    }

    public void sendFirstName(String firstName) throws IOException {
        dout.writeUTF(firstName);
    }

    public void sendLastName(String lastName) throws IOException {
        dout.writeUTF(lastName);
    }



}
