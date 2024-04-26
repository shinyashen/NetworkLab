package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.util.Objects;

import static entity.Client.sendData;
import static java.lang.System.exit;

public class ClientFrame extends Frame {
    public ClientFrame() {
        super();
    }

    public int getProtocol() {
        return (radioButton1.isSelected()) ? 0 : 1;
    }

    public int getPort() {
        return Integer.parseInt(textField3.getText());
    }

    public String getData() {
        return textField2.getText();
    }

    public void appendInfo(String info) {
        textArea1.append(info + "\n");
    }

    private void ClientSend(ActionEvent e) {
        sendData(textField1.getText());
    }

    private void ClientExit(ActionEvent e) {
        exit(0);
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        if (Objects.requireNonNull(comboBox1.getSelectedItem()).toString().equals("A"))
            textField1.setText("10.0.0.1");
        else if (Objects.requireNonNull(comboBox1.getSelectedItem()).toString().equals("B"))
            textField1.setText("10.0.0.2");
        else if (Objects.requireNonNull(comboBox1.getSelectedItem()).toString().equals("C"))
            textField1.setText("10.0.0.3");
    }

    public void initComponents() {
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
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();

        //======== this ========
        setTitle("\u5ba2\u6237\u7aef");
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "A",
            "B",
            "C"
        }));
        comboBox1.addItemListener(e -> comboBox1ItemStateChanged(e));
        contentPane.add(comboBox1);
        comboBox1.setBounds(105, 20, 100, comboBox1.getPreferredSize().height);

        //---- textField1 ----
        textField1.setText("10.0.0.1");
        contentPane.add(textField1);
        textField1.setBounds(105, 65, 100, textField1.getPreferredSize().height);

        //---- textField2 ----
        textField2.setText("Hello World!");
        contentPane.add(textField2);
        textField2.setBounds(105, 105, 260, textField2.getPreferredSize().height);

        //---- label1 ----
        label1.setText("\u672c\u8fdb\u7a0b\u6807\u8bc6");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(25, 25), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("IP\u5730\u5740");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(25, 65), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u53d1\u9001\u5185\u5bb9");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(25, 105), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u7aef\u53e3\u53f7");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(215, 65), label4.getPreferredSize()));

        //---- textField3 ----
        textField3.setText("8888");
        contentPane.add(textField3);
        textField3.setBounds(265, 65, 100, textField3.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u53d1\u9001");
        button1.addActionListener(e -> ClientSend(e));
        contentPane.add(button1);
        button1.setBounds(375, 20, 90, button1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u5173\u95ed");
        button2.addActionListener(e -> ClientExit(e));
        contentPane.add(button2);
        button2.setBounds(375, 60, 90, button2.getPreferredSize().height);

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.setEditable(false);
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 145, 340, 150);

        //---- radioButton1 ----
        radioButton1.setText("TCP");
        radioButton1.setSelected(true);
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(220, 20), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText("UDP");
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(300, 20), radioButton2.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(490, 325));
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
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
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
