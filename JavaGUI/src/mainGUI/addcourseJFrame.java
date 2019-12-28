/*
 * Created by JFormDesigner on Thu Dec 19 19:57:53 CST 2019
 */

package mainGUI;

import java.awt.event.*;

import src.com.dbExperiment.dao.factory.courseDAOfactory;
import src.com.dbExperiment.dao.vo.Course;

import java.awt.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Brainrain
 */
public class addcourseJFrame extends JFrame {
    public addcourseJFrame() {
        initComponents();
    }

    private void buttonsubmitMouseClicked(MouseEvent e) {
        // TODO add your code here
        Course cour = new Course();
        try {
            cour.setCno(this.cCollcomboBox.getSelectedItem() + "10"+(courseDAOfactory.getcourseDAOInstance().quaryByCollno(this.cCollcomboBox.getSelectedItem() +
                    "").size()+1));
            cour.setCname(this.textFieldcName.getText());
            cour.setCterm(this.cTermcomboBox.getSelectedItem() + "");
            cour.setCstatus("待审核");
            cour.setTeano(this.teaNametextField.getText());
            cour.setCcredit(this.cCretextField.getText());
            cour.setCnature(this.cStacomboBox.getSelectedItem() + "");
            cour.setChour(this.cHourtextField.getText());
            cour.setCollno(this.cCollcomboBox.getSelectedItem() + "");

            if(courseDAOfactory.getcourseDAOInstance().addCourse(cour)) {
                this.dispose();
                JOptionPane.showMessageDialog(this,"添加成功！");
            }else {
                JOptionPane.showMessageDialog(this,"添加失败！");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        labelcName = new JLabel();
        textFieldcName = new JTextField();
        labelcColl = new JLabel();
        labelcSta = new JLabel();
        labelcCre = new JLabel();
        labelcHour = new JLabel();
        cCollcomboBox = new JComboBox<>();
        cStacomboBox = new JComboBox<>();
        cHourtextField = new JTextField();
        cTermcomboBox = new JComboBox<>();
        labelcTerm = new JLabel();
        labelteaName = new JLabel();
        teaNametextField = new JTextField();
        cCretextField = new JTextField();
        buttonsubmit = new JButton();
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();

        //---- labelcName ----
        labelcName.setText("\u8bfe\u7a0b\u540d");

        //---- labelcColl ----
        labelcColl.setText("\u5f00\u8bfe\u5b66\u9662");

        //---- labelcSta ----
        labelcSta.setText("\u8bfe\u7a0b\u6027\u8d28");

        //---- labelcCre ----
        labelcCre.setText("\u5b66\u5206\u6570");

        //---- labelcHour ----
        labelcHour.setText("\u8bfe\u65f6\u6570");

        //---- cCollcomboBox ----
        cCollcomboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "0100",
            "0200",
            "0300",
            "0400",
            "0500",
            "0600",
            "0700",
            "0800",
            "0900",
            "1000",
            "1100",
            "1200",
            "\u8ba1\u7b97\u673a\u79d1\u5b66\u4e0e\u6280\u672f\u5b66\u9662",
            "\u4fe1\u606f\u5de5\u7a0b\u5b66\u9662",
            "\u8d44\u73af\u5b66\u9662",
            "\u7ecf\u6d4e\u5b66\u9662"
        }));

        //---- cStacomboBox ----
        cStacomboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u4e13\u4e1a\u5fc5\u4fee",
            "\u4e13\u4e1a\u9009\u4fee",
            "\u516c\u9009\u8bfe",
            "\u4e2a\u6027\u8bfe",
            "\u5b9e\u8df5\u8bfe"
        }));

        //---- cTermcomboBox ----
        cTermcomboBox.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u5927\u4e00\u4e0a",
            "\u5927\u4e00\u4e0b",
            "\u5927\u4e8c\u4e0a",
            "\u5927\u4e8c\u4e0b",
            "\u5927\u4e09\u4e0a",
            "\u5927\u4e09\u4e0b",
            "\u5927\u56db\u4e0a",
            "\u5927\u56db\u4e0b"
        }));

        //---- labelcTerm ----
        labelcTerm.setText("\u5f00\u8bfe\u5b66\u671f");

        //---- labelteaName ----
        labelteaName.setText("\u804c\u5de5\u53f7");

        //---- buttonsubmit ----
        buttonsubmit.setText("\u63d0\u4ea4\u7533\u8bf7");
        buttonsubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                buttonsubmitMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(88, 88, 88)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(labelcName)
                                .addComponent(labelteaName)
                                .addComponent(labelcColl)
                                .addComponent(labelcTerm)
                                .addComponent(labelcSta)
                                .addComponent(labelcCre)
                                .addComponent(labelcHour))
                            .addGap(35, 35, 35)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cCollcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldcName, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(teaNametextField, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(buttonsubmit)
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cTermcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cStacomboBox)
                                            .addComponent(cCretextField)
                                            .addComponent(cHourtextField)))))))
                    .addContainerGap(192, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldcName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelcName))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(teaNametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelteaName))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(cCollcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelcColl))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelcTerm)
                        .addComponent(cTermcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelcSta)
                        .addComponent(cStacomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelcCre)
                        .addComponent(cCretextField, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                    .addGap(18, 21, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelcHour)
                        .addComponent(cHourtextField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                    .addGap(50, 50, 50)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonsubmit)
                        .addComponent(label1))
                    .addGap(93, 93, 93))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel labelcName;
    private JTextField textFieldcName;
    private JLabel labelcColl;
    private JLabel labelcSta;
    private JLabel labelcCre;
    private JLabel labelcHour;
    private JComboBox<String> cCollcomboBox;
    private JComboBox<String> cStacomboBox;
    private JTextField cHourtextField;
    private JComboBox<String> cTermcomboBox;
    private JLabel labelcTerm;
    private JLabel labelteaName;
    private JTextField teaNametextField;
    private JTextField cCretextField;
    private JButton buttonsubmit;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
