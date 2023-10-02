package Lesson1.Seminar.Chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Chat extends JFrame {

    private static final int WINDOW_HEIGHT = 640;
    private static final int WINDOW_WIDTH = 720;
    private static final int WINDOW_POSX = 300;
    private static final int WINDOW_POSY = 100;

    private final JLabel connectLbl = new JLabel("Connect to server", SwingConstants.CENTER);
    private final JLabel chatLbl = new JLabel("Chat", SwingConstants.CENTER);
    private final JTextField emailFld = new JTextField("Email");
    private final JTextField passwordFld = new JTextField("Password");
    private final JTextField ipFld = new JTextField("IP Address");
    private final JTextField portFld = new JTextField("Port");
    private final JTextField messageFld = new JTextField();
    private final JTextArea chatMessage = new JTextArea();
    private final JButton sendMessage = new JButton("Send message");
    private final JButton connectBtn = new JButton("Connect");
    private final JPanel top = new JPanel(new GridLayout(7, 1));
    private final JPanel bot = new JPanel(new BorderLayout());
    private final ButtonGroup buttonGroup = new ButtonGroup();

    Log log = new Log(this);



    Chat() {
        setBounds(WINDOW_POSX, WINDOW_POSY, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setPlaceholder(emailFld, "Email");
        setPlaceholder(passwordFld, "Password");
        setPlaceholder(ipFld, "IP Address");
        setPlaceholder(portFld, "Port");


        connectBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!emailFld.getText().isEmpty() && !emailFld.getText().equals("Email")) {
                    sendMessage.setEnabled(true);
                    log.read();
                } else {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Для отправки сообщений необходимо ввести email");
                }
            }
        });

        sendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatMessage.append(String.format("%s : %s \n", emailFld.getText(), messageFld.getText()));
                messageFld.setText("");
                log.write();
            }
        });

        chatMessage.setEditable(false);
        sendMessage.setEnabled(false);
        chatMessage.setBackground(Color.gray);

        top.add(connectLbl);
        top.add(emailFld);
        top.add(passwordFld);
        top.add(ipFld);
        top.add(portFld);
        top.add(connectBtn);
        top.add(chatLbl);

        bot.add(messageFld, BorderLayout.CENTER);
        bot.add(sendMessage, BorderLayout.EAST);

        add(top, BorderLayout.NORTH);
        add(chatMessage, BorderLayout.CENTER);
        add(bot, BorderLayout.SOUTH);

        setVisible(true);

    }

    public void setPlaceholder(JTextField field, String message) {
        field.setForeground(Color.gray);
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(message)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(Color.GRAY);
                    field.setText(message);

                }
            }
        });
    }

    public String getChatHistory() {
        return chatMessage.getText();
    }

    public void setChatHistory(String history) {
        chatMessage.setText(history);
    }

}
