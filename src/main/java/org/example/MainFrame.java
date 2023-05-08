package org.example;

import java.io.FileInputStream;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;

public class MainFrame {
    JFrame frame = new JFrame();
    private JTextField textField = new JTextField();
    private JLabel result = new JLabel("", JLabel.CENTER);

    MainFrame() {
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 0));

        panel.add(new JLabel("Enter your file name:", JLabel.CENTER));
        panel.add(textField);

        JButton button = new JButton("Enter");
        button.addActionListener(actionEvent -> {
            try {
                HashMap<String, Integer> frequencyMap = WordFrequency.getFrequencyMap(new FileInputStream(textField.getText()));
                result.setText(String.valueOf(frequencyMap));
            }
            catch (IOException exc) {
                result.setText(String.valueOf(exc.getMessage()));
            }
        });

        panel.add((button));
        panel.add(result);

        frame.add(panel);
    }

    public void show() {
        frame.setVisible(true);
    }
}
