package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class App extends JPanel {
    private JButton[] buttonList;
    private JButton selector;
    private JButton restart;
    private ClassList myClass;
    private int listLength;
    private JPanel controll = new JPanel();

    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("For Anna and her wonderful SAT Math Class");
        frame.setContentPane(new App().controll);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(512, 192);
        frame.setVisible(true);
    }

    public App() throws Exception {
        ButtonListener listener = new ButtonListener();
        myClass = new ClassList(Integer.parseInt(JOptionPane.showInputDialog(null, "Which Class? Type in 1 or 2")));
        listLength = myClass.getWholeClass().length;
        buttonList = new JButton[listLength];
        for (int i = 0; i < buttonList.length; i++) {
            buttonList[i] = new JButton(myClass.getWholeClass()[i].getName());
            buttonList[i].addActionListener(listener);
            controll.add(buttonList[i]);
        }
        selector = new JButton("Choose a winner");
        selector.addActionListener(listener);
        controll.add(selector);
        restart = new JButton("Reset class scores");
        restart.addActionListener(listener);
        controll.add(restart);

    }
        private void createUIComponents(){ // Not used - UI is created in App constructor

    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            int i = 0;
            if (ae.getSource() == selector) {
                if (myClass.getGoodStudents().size() == 0) {
                    JOptionPane.showMessageDialog(null, "No good students yet...");
                } else {
                    Student[] arr = new Student[myClass.getGoodStudents().size()];
                    int j = 0;
                    for (Student g : myClass.getGoodStudents()) {
                        arr[j] = g;
                        j++;
                    }
                    int randomChoice = (int) (Math.random() * arr.length);
                    JOptionPane.showMessageDialog(null, arr[randomChoice].getName() + " is the lucky one today!");
                }
            } else if (ae.getSource() == restart) {
                myClass.clearList();
                JOptionPane.showMessageDialog(null, "Scores cleared.");
            } else {
                while (ae.getSource() != buttonList[i]) {
                    i++;
                }
                myClass.getWholeClass()[i].correctAnswer();
                myClass.getWholeClass()[i].isGood();
                myClass.getWholeClass()[i].addGoodStudents(myClass.getGoodStudents());
                JOptionPane.showMessageDialog(null, "Nice job, " + myClass.getWholeClass()[i].getName() + "!");
            }
        }
    }
}
