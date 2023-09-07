package socketapp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;


public class MyClient2 {

    public static void main(String[] args) throws IOException {
        ekrankarti();
    }

    public static void ekrankarti() throws UnknownHostException, IOException {
        JFrame frame = new JFrame("Client");
        JLabel gpuLBL,areaLbl;
        JTextField gpuTXT;
        JButton sendBTN;
        JTextArea textArea;

        gpuLBL = new JLabel("Enter GPU");
        gpuLBL.setBounds(52,110,100,30);
        gpuLBL.setVisible(true);

        gpuTXT = new JTextField();
        gpuTXT.setBounds(50,150,100,30);

        sendBTN = new JButton("Send");
        sendBTN.setBounds(51,200,100,30);

        textArea = new JTextArea();
        textArea.setBounds(220,100,150,240);
        textArea.setEditable(false);

        areaLbl = new JLabel("Playable Games");
        areaLbl.setBounds(250,55,100,50);

        frame.add(gpuLBL);
        frame.add(gpuTXT);
        frame.add(sendBTN);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(400,500);
        frame.add(textArea);
        frame.add(areaLbl);

        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String deger = "";
        try {
            //* Connected to server with localhost and port 7755 *//
            socket = new Socket("localhost", 7755);
        } catch (Exception e) {
            System.out.println("Port Error!");
        }
        // Created PrintWriter object used to send data to server
        out = new PrintWriter(socket.getOutputStream(), true);


        //* A BufferedReader object is created that holds the data from the server
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));



        // It is requested to enter the video card model to be query.
       BufferedReader data = new BufferedReader(new InputStreamReader(System.in));


        PrintWriter finalOut = out;

            sendBTN.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == sendBTN && gpuTXT.getText().equals("GTX 1060")) {

                        finalOut.println(gpuTXT.getText());
                    } else if (e.getSource() == sendBTN && gpuTXT.getText().equals("RTX 2070")) {
                        finalOut.println(gpuTXT.getText());

                    } else if (e.getSource() == sendBTN && gpuTXT.getText().equals("RTX 3080")) {
                        finalOut.println(gpuTXT.getText());

                    }
                }
            });


         {
            out.println(gpuTXT.getText());


            textArea.setText(in.readLine()); //The information from the server is kept in the variable in.readLine and printed.



        }




        out.close();
        in.close();
        data.close();
        socket.close();
    }
}