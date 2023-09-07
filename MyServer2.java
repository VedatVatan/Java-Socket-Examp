import socketapp.MyClient2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import static java.lang.System.in;


public class MyServer2 {


    private static String BufferedReader;
    private static ArrayList<String> gameList = new ArrayList<>();
    private static ArrayList<String> gameList2 = new ArrayList<>();
    private static ArrayList<String> gameList3 = new ArrayList<>();
    private static String text=null;
    private static String text2=null;
    private static String text3 = null;


    public static void main(String[] args) throws IOException {


        JFrame f = new JFrame("Server");
        JLabel l1, l2; //Labels
        JTextField t1, t2, t3, t4; // t1 and t2 text for game and application, you write your interest game or application
        JButton btn; //JButton
        JRadioButton r1 = new JRadioButton("GTX 1000 Series");
        r1.setBounds(100, 30, 100, 30);
        JRadioButton r2 = new JRadioButton("RTX 2000 Series");
        r2.setBounds(100, 80, 100, 30);
        JRadioButton r3 = new JRadioButton("RTX 3000 Series");
                r3.setBounds(100,130,100,30);
        ButtonGroup bg = new ButtonGroup(); //Grouping for RadioButtons

        bg.add(r1); // Adding Radio Button 1 to group
        bg.add(r2);// Adding radio button 2 to group
        bg.add(r3);// Adding Radio Button 3 to group
        JTextArea textArea;


        l1 = new JLabel("Enter Games");
        l1.setBounds(50, 150, 100, 30);
        l1.setVisible(false);

        t1 = new JTextField();
        t1.setBounds(50, 190, 200, 30);
        //t1.setVisible(false); //TextField comes with Radio Button

        l2 = new JLabel("Enter Applications");
        l2.setBounds(50, 170, 100, 30);
        l2.setVisible(false);

        t2 = new JTextField();
        t2.setBounds(50, 200, 200, 30);





        btn = new JButton("Add"); //Button for add games in to server
        btn.setBounds(100, 250, 100, 30);





        textArea = new JTextArea(50, 90);


        f.add(r1);
        f.add(r2);
        f.add(r3);
        f.add(l1);
        f.add(t1);
        f.add(btn);
        f.setSize(400, 500);
        f.add(textArea);
        f.setLayout(null);
        f.setVisible(true);


        String clientGelen;
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        String gpu;
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( r1.isSelected() &&e.getSource()==btn) {
                    text = t1.getText();

                    {
                        gameList.add(text);

                    }

                }

                    if (e.getSource()==btn && r2.isSelected()){
                        text = t1.getText();
                        {
                            gameList2.add(text);
                        }
                    }
                    if (e.getSource()==btn && r3.isSelected()){
                        text = t1.getText();
                        {
                            gameList3.add(text);
                        }
                    }
                    System.out.println(gameList);// See for in the interface
                    System.out.println(gameList2);
                    System.out.println(gameList3);
                }


            public ArrayList<String> getGameList() {
                return gameList;


            }
            public ArrayList<String> getgameList2(){
                return gameList2;
            }
            public ArrayList<String> getGamelist3(){
                return gameList3;
            }



        });


        try {
            //*Server listen to client on 7755 port *//
            serverSocket = new ServerSocket(7755);
        } catch (Exception e) {
            System.out.println("Port Error!");
        }
        System.out.println("SERVER READY FOR CONNECTION...");
        // Without connection, the program does not switch to the next line of code (accept) //
        clientSocket = serverSocket.accept();

        //The PrintWriter object that we use to send data to the client is created.
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        //A BufferedReader object is created that holds the data from the client
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while((clientGelen = in.readLine()) != null) {
            System.out.println("Client'dan gelen veri = " + clientGelen);
            gpu = String.valueOf(clientGelen);
            if (clientGelen.equals("GTX 1060")) {
                out.println(gameList);
            } else if (clientGelen.equals("RTX 2070")) {
                out.println(gameList2);
            } else if (clientGelen.equals("RTX 3080")) {
                out.println(gameList3);
            }


        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }


}


