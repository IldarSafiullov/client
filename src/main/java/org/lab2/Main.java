package org.lab2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.lab2.authorization.User;
import java.io.*;
import java.net.Socket;

public  class Main {
    static DataOutputStream dout;

    public static void main(String[] args) throws IOException {
        run();

    }

    public static void run() throws IOException{
        Socket socket = new Socket("192.168.0.15", 8090);
        dout = new DataOutputStream(socket.getOutputStream());
        User user = new User("user", "Ildar", "Saf", "password");

        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(user);
        System.out.println(json);

        dout.writeUTF(json);

    }

    public void sendPassword(String password) throws IOException {
        dout.writeUTF(password);
    }

    public void sendData(String s){
        try {
            dout.writeUTF(s);
            dout.flush();
        } catch (Exception e) {
            e.printStackTrace();}
    }


/*    public Main(String name) {
        super(name);
        setLayout(new FlowLayout());
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        final JTextField t1 = new JTextField(30);
        JTextArea chatWindow = new JTextArea();
        final JButton b1 = new JButton("send");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (actionEvent.getSource() == b1) {
                    sendData(t1.getText());
                }
            }
        });
        add(t1);
        add(b1);
    }*/
}