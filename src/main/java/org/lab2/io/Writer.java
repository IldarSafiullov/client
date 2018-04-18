package org.lab2.io;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Writer {

    final Socket socket;

    public Writer(Socket socket) {
        this.socket = socket;
    }

    public void writeMessage(String message) throws IOException {
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        dout.writeUTF(message);
    }
}

