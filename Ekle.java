import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



//public class Ekle {


    public class Ekle implements ActionListener {

        private ArrayList<String> gameList = new ArrayList<>();
        private String text=null;
        JTextField  textField = new JTextField(10);


        public Ekle() {
            JFrame frame = new JFrame();

            JButton button = new JButton("Ekle");
            button.addActionListener(this);


            JPanel panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
            panel.setLayout(new GridLayout(0, 1));
            panel.add(textField);

            panel.add(button);


            frame.add(panel, BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setTitle("Vedat 2");
            frame.pack();
            frame.setVisible(true);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            text = textField.getText();
            {
                gameList.add(text);
            }
            System.out.println(gameList);
        }

        public ArrayList<String> getGameList() {
            return gameList;
        }
    }
