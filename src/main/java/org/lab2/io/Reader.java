package org.lab2.io;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Reader {

    private final Socket socket;

    public Reader(Socket socket) {
        this.socket = socket;
    }

    public String readMessage() throws IOException {
        DataInputStream din = new DataInputStream(socket.getInputStream());
        return din.readUTF();
    }
}