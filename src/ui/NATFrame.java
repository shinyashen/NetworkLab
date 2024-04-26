package ui;

import entity.Entry;
import entity.NAT;
import impl.Scanner;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.Vector;

public class NATFrame extends Frame {
    public NATFrame() {
        super();
    }

    public void updateTable() {
        Vector<Entry> table = NAT.table.table;
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        tableModel.getDataVector().clear();
        for (Entry e : table) {
            String arr[] = new String[6];
            if (e.protocol == 0)
                arr[0] = "TCP";
            else
                arr[0] = "UDP";
            arr[1] = e.src_ip;
            arr[2] = e.src_port + "";
            arr[3] = e.dst_ip;
            arr[4] = e.dst_port + "";
            arr[5] = Scanner.liveSeconds - (System.currentTimeMillis() - e.liveTime) / 1000 + "s";
            tableModel.addRow(arr);
        }
    }

    public void setFixedColumnWidth(JTable table, String columnName, int width) {
        TableColumnModel tcm = table.getTableHeader().getColumnModel();
        DefaultTableModel tm = (DefaultTableModel) table.getModel();
        int column = tm.findColumn(columnName);
        TableColumn tc = tcm.getColumn(column);
        tc.setPreferredWidth(width);
        tc.setMaxWidth(width);
        tc.setMinWidth(width);
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
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
        table1.getTableHeader().setReorderingAllowed(false);
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        String column[]={"协议","内网IP","内网端口","公网IP","公网端口","剩余时间"};
        for(String str:column)
            tableModel.addColumn(str);
        setFixedColumnWidth(table1, "协议", 70);
        setFixedColumnWidth(table1, "内网IP", 116);
        setFixedColumnWidth(table1, "内网端口", 70);
        setFixedColumnWidth(table1, "公网IP", 116);
        setFixedColumnWidth(table1, "公网端口", 70);
        setFixedColumnWidth(table1, "剩余时间", 70);
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
            scrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

            //---- table1 ----
            table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 55, 530, 85);

        //======== scrollPane2 ========
        {

            //---- textArea1 ----
            textArea1.setEditable(false);
            scrollPane2.setViewportView(textArea1);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(25, 155, 530, 150);

        contentPane.setPreferredSize(new Dimension(580, 335));
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
