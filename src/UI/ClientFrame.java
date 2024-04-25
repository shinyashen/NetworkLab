package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import static entity.Client.clientIP;
import static entity.Client.sendData;

public class ClientFrame extends JFrame {
    public ClientFrame() {
        initComponents();
    }

    public void ClientWindowShow() {
        SwingUtilities.invokeLater(() -> {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            setVisible(true);
        });
    }

    private void ClientSend(ActionEvent e) {
        System.out.println("客户端窗口点击了发送按钮！");
        if (comboBox1.getSelectedItem().toString().equals("A")) {
            System.out.println("客户端将以A标识发送报文：");
            sendData(clientIP[0]);
        }
        else if (comboBox1.getSelectedItem().toString().equals("B")) {
            System.out.println("客户端将以B标识发送报文：");
            sendData(clientIP[1]);
        }
        else if (comboBox1.getSelectedItem().toString().equals("C")) {
            System.out.println("客户端将以C标识发送报文：");
            sendData(clientIP[2]);
        }
    }

    private void ClientExit(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        comboBox1 = new JComboBox<>();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("\u5ba2\u6237\u7aef");
        setResizable(false);
        setFont(new Font("\u5fae\u8f6f\u96c5\u9ed1", Font.PLAIN, 12));
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "A",
            "B",
            "C"
        }));
        contentPane.add(comboBox1);
        comboBox1.setBounds(120, 20, 100, comboBox1.getPreferredSize().height);

        //---- textField1 ----
        textField1.setText("127.0.0.1");
        contentPane.add(textField1);
        textField1.setBounds(120, 60, 100, textField1.getPreferredSize().height);

        //---- textField2 ----
        textField2.setText("Hello World!");
        contentPane.add(textField2);
        textField2.setBounds(120, 100, 260, textField2.getPreferredSize().height);

        //---- label1 ----
        label1.setText("\u672c\u8fdb\u7a0b\u6807\u8bc6");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(25, 25), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u4ea4\u6362\u673a\uff1aIP\u5730\u5740");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(25, 65), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u53d1\u9001\u5185\u5bb9");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(25, 105), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u7aef\u53e3\u53f7");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(230, 65), label4.getPreferredSize()));

        //---- textField3 ----
        textField3.setText("10000");
        contentPane.add(textField3);
        textField3.setBounds(280, 60, 100, textField3.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u53d1\u9001");
        button1.addActionListener(e -> ClientSend(e));
        contentPane.add(button1);
        button1.setBounds(230, 20, 70, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u5173\u95ed");
        button2.addActionListener(e -> ClientExit(e));
        contentPane.add(button2);
        button2.setBounds(310, 20, 70, button2.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 145, 350, 150);

        contentPane.setPreferredSize(new Dimension(405, 350));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JComboBox<String> comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
