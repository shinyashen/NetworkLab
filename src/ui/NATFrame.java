package ui;

import java.awt.*;
import javax.swing.*;

public class NATFrame extends Frame {
    public NATFrame() {
        super();
    }

    public void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        scrollPane2 = new JScrollPane();
        textArea1 = new JTextArea();

        //======== this ========
        setTitle("\u8def\u7531\u5668");
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("IP\u5730\u5740");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(25, 25), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(70, 25, 100, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u7aef\u53e3\u53f7");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(185, 25), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(235, 25, 100, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u5f00\u59cb\u5de5\u4f5c");
        contentPane.add(button1);
        button1.setBounds(360, 20, 90, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u5173\u95ed");
        contentPane.add(button2);
        button2.setBounds(465, 20, 90, button2.getPreferredSize().height);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 55, 525, 85);

        //======== scrollPane2 ========
        {

            //---- textArea1 ----
            textArea1.setEditable(false);
            scrollPane2.setViewportView(textArea1);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(25, 155, 525, 50);

        contentPane.setPreferredSize(new Dimension(585, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    public void appendInfo(String info) {
        textArea1.append(info + "\n");
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JScrollPane scrollPane2;
    private JTextArea textArea1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
