import banner.*;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.Random;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JOptionPane;

import javax.swing.JPanel;

 class Hangman extends JFrame{

    final private int FRAME_WIDTH=800;

    final private int FRAME_HIGHT=550;

    public final String[] normal = { "HUMAN", "GAMES", "WOLF", "DOG","CAT","TREE","JAVA","ERROR","FATHER" };

    private static String[] letters = { "A", "B", "C", "D", "E", "F",

            "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",

            "S", "T", "U", "V", "W", "X", "Y", "Z" };

    String testWord,cmpWord="";

    int counter = 5,scor=0;

    JLabel name,score,hpoint;

    JLabel testInput=new JLabel("");

    JButton[] letterButtons;

    public Hangman() {

//Start game me

        displayWordOnUI();

        JFrame mainFrame = new JFrame("Hello");

        mainFrame.setLayout(new BorderLayout());

        mainFrame.setResizable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton reset=new JButton("New Word");

        name=new JLabel("USER1 :");

        score=new JLabel(String.valueOf(scor));

        hpoint=new JLabel("5");

        mainFrame.setVisible(true);

        JPanel playerInfo= new JPanel();

        playerInfo.setLayout(new BorderLayout());

        playerInfo.add(name,BorderLayout.WEST);

        playerInfo.add(score,BorderLayout.CENTER);

        playerInfo.add(hpoint,BorderLayout.EAST);

//playerInfo.setSize(700,400);

        mainFrame.add(playerInfo,BorderLayout.NORTH);

//Letters panel

        JPanel letterPanel = new JPanel();

        letterPanel.setSize(FRAME_HIGHT,FRAME_WIDTH);

        letterPanel.setLayout(new GridLayout(2,13));

        letterButtons = new JButton[letters.length];

        for (int i = 0; i < letters.length; ++i) {

            letterButtons[i] = new JButton(letters[i]);

            letterPanel.add(letterButtons[i]);

            letterButtons[i].addActionListener(new Action());

        }



        mainFrame.add(letterPanel,BorderLayout.SOUTH);

//testInput.getText(checkInput());

        mainFrame.add(testInput, BorderLayout.CENTER);

        mainFrame.add(reset,BorderLayout.WEST);

        reset.addActionListener(new Action());

        mainFrame.pack();

    }

    private void displayWordOnUI() {

        for (int i = 0; i < normal.length; ++i){

            testWord =normal[new Random().nextInt(normal.length)];

        }

        System.out.println(testWord);

        testInput.setText(hideWord(testWord));

    }

    private String hideWord(String word) {

        String a = "";

        for(int i=0;i<word.length();i++){

            a=a+"-";

        }

        return a;

    }

    public class Action implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            JButton source = (JButton) event.getSource();

            if(source.getActionCommand().equals("Reset")){

                displayWordOnUI();

                for(JButton i : letterButtons){

                    i.setEnabled(true);

                }

                hpoint.setText("5");

                counter=5;

            }else{

                source.setEnabled(false);

                if(source.getLabel().equalsIgnoreCase("Change the word"))

                {

                    if(testWord.equalsIgnoreCase(cmpWord))

                        scor=scor+10;

                    for (int i = 0; i < normal.length; ++i){

                        testWord =normal[new Random().nextInt(normal.length)];

                    }

                    testInput.setText(testWord);

                    cmpWord="";

                }

                else{

                    String x = source.getText();

                    cmpWord=cmpWord+x;

                    checkInput(x);

                }

            }

        }

    }

    private void checkInput(String x) {



        if (testWord.contains(x)){

            System.out.print(x);
            String current[] = testInput.getText().split("");
            String s[]=testWord.split("");
            int pos = 0;
            for(String s1:s){
                if(x.equals(s1)){
                    current[pos]=x;
                }
                pos++;
            }

            String now="";
            for(String c1 : current){
                now = now+c1;
            }

            testInput.setText(now);

            if( now.indexOf("-")<0){

                JOptionPane.showMessageDialog(rootPane, "You won");

            }

        }else {

            counter--;

            hpoint.setText("Health Points: " + counter);

        }

        if (counter==0){

            hpoint.setText("0");

            JOptionPane.showMessageDialog(rootPane, "You lost");

            for(JButton i : letterButtons){

                i.setEnabled(false);

            }

        }

        if(testWord.equalsIgnoreCase(cmpWord)) {

            scor = scor + 10;
        }
    }

    public static void main(String[] args) {
        //Banner banner = new Banner("Welcome to the Hangman Game, please enjoy the play");
        new Hangman();

    }

}