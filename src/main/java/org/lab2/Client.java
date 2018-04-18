package org.lab2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.lab2.authorization.AuthForm;
import org.lab2.authorization.User;
import org.lab2.io.*;
import org.lab2.io.Reader;
import org.lab2.io.Writer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;



public  class Client extends JFrame implements Runnable{

    static DataOutputStream dout;

    public Client() {
        /*setLayout(new FlowLayout());
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        final JTextField t1 = new JTextField(30);
        JTextArea chatWindow = new JTextArea();
        final JButton b1 = new JButton("Send");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == b1) {
                    sendMessage(t1.getText());
                }
            }
        });
        add(t1);
        add(b1);
        add(chatWindow);*/
    }

    public static void main(String[] args) throws IOException {
            new Thread(new Client()).start();
    }

    public void run(){
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 8090);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String messageIn, messageOut;
            while (true){
                messageOut = br.readLine();
                new Writer(socket).writeMessage(messageOut);
                messageIn = new Reader(socket).readMessage();
                System.out.println(messageIn);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*User user = new User("user", "Ildar", "Saf", "password");
        AuthForm authForm = new AuthForm("SIGN_UP", user);
        String authType = authForm.getAuthType();

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(authForm);
        dout.writeUTF(json);*/

    }

    public void sendMessage( String message)  {
        try {
            dout.writeUTF(message);
            dout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}