package me.kub0vv_.bindsystem.gui;

import me.kub0vv_.bindsystem.bind.Bind;
import me.kub0vv_.bindsystem.bind.BindManager;

import javax.swing.*;
import java.awt.*;

public class ExampleGui {
    //initialize BindManager for keybinds and actions
    private static BindManager manager = new BindManager();

    public void createAndShowGUI() {
        JFrame frame = new JFrame("Example Gui for KeyBind System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new FlowLayout());
        frame.setContentPane(contentPane);

        JButton button1 = new JButton("Bind: ? (1)");

        //add button and action to BindManager to listen for keybinds and perform actions when triggered
        manager.addButton(button1, new Bind() {
            @Override
            public void performAction() {
                JOptionPane.showMessageDialog(frame, "KeyBind 1 clicked!");
            }
        });
        JButton button2 = new JButton("Bind: ? (2)");
        manager.addButton(button2, new Bind() {
            @Override
            public void performAction() {
                JOptionPane.showMessageDialog(frame, "KeyBind 2 clicked!");
            }
        });
        JButton button3 = new JButton("Bind: ? (3)");
        manager.addButton(button3, new Bind() {
            @Override
            public void performAction() {
                JOptionPane.showMessageDialog(frame, "KeyBind 3 clicked!");
            }
        });
        contentPane.add(button1);
        contentPane.add(button2);
        contentPane.add(button3);

        frame.pack();
        frame.setVisible(true);
    }
}

// By kub0vv_