package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {

    //Задаю размеры окна

    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;

    //Создаю панели кнопки, лист пользователей

    private final JTextArea chatArea = new JTextArea();
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField ipAddressField = new JTextField("127.0.0.1");
    private final JTextField portField = new JTextField("8181");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top", true);
    private final JTextField loginField = new JTextField("login");
    private final JPasswordField passwordField = new JPasswordField("123");
    private final JButton buttonLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton buttonDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField messageField = new JTextField();
    private final JButton buttonSend = new JButton("Send");

    private final JList<String> listUsers = new JList<>();


    //В главном методе создаю объект окна

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });
    }

    //В конструкторе задаю значения по умолчанию и добавляю элементы на панели, а панели в окно
    //Делаю окно видимым
    ClientGUI () {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat");
        setSize(WIDTH, HEIGHT);
        setAlwaysOnTop(true);

        listUsers.setListData(new String[]{"user1", "user2", "user3", "user4",
                "user5", "user6", "user7", "user8", "user9"});
        JScrollPane scrollPaneUsers = new JScrollPane(listUsers);
        JScrollPane scrollPaneChatArea = new JScrollPane(chatArea);
        scrollPaneUsers.setPreferredSize(new Dimension(100, 0));

        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setEditable(false);

        panelTop.add(ipAddressField);
        panelTop.add(portField);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(loginField);
        panelTop.add(passwordField);
        panelTop.add(buttonLogin);
        panelBottom.add(buttonDisconnect, BorderLayout.WEST);
        panelBottom.add(messageField, BorderLayout.CENTER);
        panelBottom.add(buttonSend, BorderLayout.EAST);

        add(scrollPaneChatArea, BorderLayout.CENTER);
        add(scrollPaneUsers, BorderLayout.EAST);
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);

        cbAlwaysOnTop.addActionListener(this);
        messageField.addActionListener(this);
        buttonSend.addActionListener(this);

        setVisible(true);
    }

    //Добавляю листнер к элементу cbAlwaysOnTop
    //Добавляю листнеры к элементам messageField и buttonSend,
    //При их срабатывании текст переходит из messageField в chatArea

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        String textToChat = "null";
        if (src == cbAlwaysOnTop) {
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        } else if (src == messageField) {
            textToChat = messageField.getText();
            chatArea.append(textToChat+"\n");
            messageField.setText("Enter new message");
        } else if (src == buttonSend) {
            textToChat = messageField.getText();
            chatArea.append(textToChat+"\n");
            messageField.setText("Enter new message");
        } else {
            throw new RuntimeException("Unsupported action: " + src);
        }

        //В блоке try-catch произвожу запись каждого сообщения в файл,
        //для каждого сообщения открываю файл с логом, записываю сообщение и закрываю файл

        try(FileWriter writer = new FileWriter("log.txt", true)) {
            writer.append(System.lineSeparator()+textToChat);
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        StackTraceElement[] ste = e.getStackTrace();
        String msg = String.format("Exception in \"%s\": %s %s%n\t %s",
                t.getName(), e.getClass().getCanonicalName(), e.getMessage(), ste[0]);
        JOptionPane.showMessageDialog(this, msg, "Exception!", JOptionPane.ERROR_MESSAGE);
    }
}
