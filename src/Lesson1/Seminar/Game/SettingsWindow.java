package Lesson1.Seminar.Game;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;
    private static int sliderSizeValue = 3;
    private static int sliderWinValue = 3;
    private static boolean gameMod;


    JLabel labelMode = new JLabel("Выберите режим игры");
    JRadioButton hvshBtn = new JRadioButton("Человек против человека");
    JRadioButton hvsaiBtn = new JRadioButton("Человек против машины");

    JLabel labelSize = new JLabel(String.format("Установите размер поля: %d", sliderSizeValue));
    JSlider sliderSize = new JSlider(3,10,3);

    JLabel labelWin = new JLabel(String.format("Установите длинну для победы: %d", sliderWinValue));
    JSlider sliderWin = new JSlider(3,10,3);

    JPanel grid = new JPanel(new GridLayout(4,1));
    ButtonGroup topButtonGroup = new ButtonGroup();
    JPanel top = new JPanel(new GridLayout(2,1));
    JPanel topButton = new JPanel(new GridLayout(1,2));
    JPanel middle = new JPanel(new GridLayout(2,1));
    JPanel bottom = new JPanel(new GridLayout(2,1));

    JButton btnStart = new JButton("Начать игру");

    SettingsWindow(GameWindow gameWindow) {
        setTitle("Окно настроек");
        setLocation(gameWindow.getLocation().x, gameWindow.getLocation().y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        topButtonGroup.add(hvshBtn);
        topButtonGroup.add(hvsaiBtn);
        topButton.add(hvshBtn);
        topButton.add(hvsaiBtn);

        top.add(labelMode);
        top.add(topButton);

        middle.add(labelSize);
        middle.add(sliderSize);

        bottom.add(labelWin);
        bottom.add(sliderWin);

        grid.add(top);
        grid.add(middle);
        grid.add(bottom);
        grid.add(btnStart);

        sliderSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderSizeValue = sliderSize.getValue();
                labelSize.setText(String.format("Установите размер поля: %d", sliderSizeValue));
            }
        });

        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderWinValue = sliderWin.getValue();
                labelWin.setText(String.format("Установите длинну для победы: %d", sliderWinValue));
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameMod = hvshBtn.isSelected();
                gameWindow.startNewGame(0,sliderSizeValue,sliderSizeValue,sliderWinValue);
                setVisible(false);
            }
        });


        add(grid);
    }
}
