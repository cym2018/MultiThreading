package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    JFrame jFrame;
    public MainWindow(){
        jFrame=new JFrame("main");
        jFrame.setSize(400,400);
        JButton jButton=new JButton("exit");
        jButton.setMaximumSize(new Dimension(100,100));
        jButton.setBounds(100,100,30,30);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jFrame.add(jButton);
        jFrame.setVisible(true);
    }
    public void init(){

    }
}
