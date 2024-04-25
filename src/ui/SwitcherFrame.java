package ui;

import javax.swing.*;
import java.awt.*;

public class SwitcherFrame extends Frame {
    public SwitcherFrame() {
        super();
    }

    public void appendInfo(String info) {
        textArea1.append(info + "\n");
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button2 = new JButton();

        //======== this ========
        setTitle("\u4ea4\u6362\u673a");
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("IP\u5730\u5740");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(25, 25), label1.getPreferredSize()));

        //---- textField1 ----
        textField1.setText("127.0.0.1");
        contentPane.add(textField1);
        textField1.setBounds(70, 25, 100, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u7aef\u53e3\u53f7");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(200, 25), label2.getPreferredSize()));

        //---- textField2 ----
        textField2.setText("10001");
        contentPane.add(textField2);
        textField2.setBounds(245, 25, 100, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u5f00\u59cb\u5de5\u4f5c");
        contentPane.add(button1);
        button1.setBounds(355, 20, 90, button1.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 65, 320, 195);

        //---- button2 ----
        button2.setText("\u5173\u95ed");
        contentPane.add(button2);
        button2.setBounds(355, 60, 90, button2.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(470, 290));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
