package paket;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import paket.GAMU.ChoiceHandler;

public class UI {
    
        JFrame window;
        JPanel titleNamePanel, startButtoPanel, mainTextPanel, choiceButtonPanel, playerPanel;
        JLabel titleNameLabel, hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel;
        JButton starButton, choice1, choice2, choice3, choice4;
        JTextArea mainTextArea;
        Font titleFont = new Font("Time New Roman", Font.BOLD, 40);
        Font NormalFont = new Font("Times New Roman", Font.PLAIN, 20);


        
        public void createUI(ChoiceHandler cHandler) {
            
            //Buat Window
            window = new JFrame();
            window.setSize(800, 600);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.getContentPane().setBackground(Color.BLACK);
            window.setLayout(null);

            //Layar utama
            titleNamePanel = new JPanel();
            titleNamePanel.setBounds(100, 100, 600, 500);
            titleNamePanel.setBackground(Color.BLACK);
            
            titleNameLabel = new JLabel("PERJALANAN SI GUNDUL");
            titleNameLabel.setForeground(Color.WHITE);
            titleNameLabel.setFont(titleFont);
            titleNamePanel.add(titleNameLabel);

            startButtoPanel = new JPanel();
            startButtoPanel.setBounds(300, 400, 200, 100);
            startButtoPanel.setBackground(Color.BLACK);
            
            starButton = new JButton("START");
            starButton.setBackground(Color.BLACK);
            starButton.setForeground(Color.WHITE);
            starButton.setFont(NormalFont);
            starButton.setFocusPainted(false);
            starButton.addActionListener(cHandler);
            starButton.setActionCommand("Start");
            startButtoPanel.add(starButton);

            window.add(titleNamePanel);
            window.add(startButtoPanel);

            //Layar game
            mainTextPanel = new JPanel();
            mainTextPanel.setBounds(100, 100, 600, 250);
            mainTextPanel.setBackground(Color.BLACK);
            window.add(mainTextPanel);

            mainTextArea = new JTextArea("P goblok");
            mainTextArea.setBounds(100, 100, 600, 250);
            mainTextArea.setBackground(Color.BLACK);
            mainTextArea.setForeground(Color.WHITE);
            mainTextArea.setFont(NormalFont);
            mainTextArea.setLineWrap(true);
            mainTextArea.setWrapStyleWord(true);
            mainTextArea.setEditable(false);
            mainTextPanel.add(mainTextArea);

            //Pilihan game
            choiceButtonPanel = new JPanel();
            choiceButtonPanel.setBounds(250, 350, 300, 150);
            choiceButtonPanel.setBackground(Color.BLACK);
            choiceButtonPanel.setLayout(new GridLayout(4,11));
            window.add(choiceButtonPanel);

            choice1 = new JButton("choice1");
            choice1.setBackground(Color.BLACK);
            choice1.setForeground(Color.WHITE);
            choice1.setFont(NormalFont);
            choice1.setFocusPainted(false);
            choice1.addActionListener(cHandler);
            choice1.setActionCommand("c1");
            choiceButtonPanel.add(choice1);

            choice2 = new JButton("choice2");
            choice2.setBackground(Color.BLACK);
            choice2.setForeground(Color.WHITE);
            choice2.setFont(NormalFont);
            choice2.setFocusPainted(false);
            choice2.addActionListener(cHandler);
            choice2.setActionCommand("c2");
            choiceButtonPanel.add(choice2);

            choice3 = new JButton("choice3");
            choice3.setBackground(Color.BLACK);
            choice3.setForeground(Color.WHITE);
            choice3.setFont(NormalFont);
            choice3.setFocusPainted(false);
            choice3.addActionListener(cHandler);
            choice3.setActionCommand("c3");
            choiceButtonPanel.add(choice3);

            choice4 = new JButton("choice4");
            choice4.setBackground(Color.BLACK);
            choice4.setForeground(Color.WHITE);
            choice4.setFont(NormalFont);
            choice4.setFocusPainted(false);
            choice4.addActionListener(cHandler);
            choice4.setActionCommand("c4");
            choiceButtonPanel.add(choice4);

            playerPanel = new JPanel();
            playerPanel.setBounds(100, 15, 600, 50);
            playerPanel.setBackground(Color.BLACK);
            playerPanel.setLayout(new GridLayout(1,4));
            window.add(playerPanel);

            hpLabel = new JLabel("HP:");
            hpLabel.setFont(NormalFont);
            hpLabel.setForeground(Color.white);
            playerPanel.add(hpLabel);

            hpNumberLabel = new JLabel();
            hpNumberLabel.setFont(NormalFont);
            hpNumberLabel.setForeground(Color.white);
            playerPanel.add(hpNumberLabel);

            weaponLabel = new JLabel("Weapon:");
            weaponLabel.setFont(NormalFont);
            weaponLabel.setForeground(Color.white);
            playerPanel.add(weaponLabel);

            weaponNameLabel = new JLabel();
            weaponNameLabel.setFont(NormalFont);
            weaponNameLabel.setForeground(Color.white);
            playerPanel.add(weaponNameLabel);

            window.setVisible(true);

        }
}