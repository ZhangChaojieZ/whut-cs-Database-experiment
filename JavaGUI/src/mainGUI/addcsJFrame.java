/*
 * Created by JFormDesigner on Thu Dec 19 20:15:32 CST 2019
 */

package mainGUI;

import src.com.dbExperiment.dao.factory.courseDAOfactory;
import src.com.dbExperiment.dao.factory.csDAOfactory;
import src.com.dbExperiment.dao.vo.Course;
import src.com.dbExperiment.dao.vo.CourseSchedule;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Brainrain
 */
public class addcsJFrame extends JFrame {
    public addcsJFrame(CourseSchedule cs) {
        this.cs = cs;
        System.out.println(this.cs.getCno());
        initComponents();

    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here

        cs.setCsclass(this.textFieldclass.getText());
        cs.setCsweeks(this.textFieldcsSE.getText());
        cs.setCsweek(this.textFieldcsSE.getText());
        cs.setCsadress(this.textFieldAdress.getText());
        cs.setCsday("星期" + this.comboBoxday.getSelectedItem());
        cs.setCsclass(this.textFieldclass.getText());
        cs.setCscapacity(this.textFieldcapac.getText());
        cs.setCsselnum(this.textFieldselNum.getText());
        cs.setCsno(this.textFieldcsno.getText());
        try {
            if(csDAOfactory.getcsDAOInstance().addCs(cs)) {
                JOptionPane.showMessageDialog(this,"添加成功！");
            }else {
                JOptionPane.showMessageDialog(this,"添加失败！");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void textFieldcapacMouseClicked(MouseEvent e) {
        // TODO add your code here
        if(!textFieldcapac.isEditable()){
            textFieldcapac.setText("");
            textFieldcapac.setForeground(Color.black);
            textFieldcapac.setEditable(true);
            textFieldcapac.requestFocus();
        }
    }

    private void initComponents() {
        //cs = new CourseSchedule();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        labelcsno = new JLabel();
        labelcsSE = new JLabel();
        labelcTime = new JLabel();
        labelcAdr = new JLabel();
        buttonOK = new JButton();
        textFieldcsno = new JTextField();
        textFieldcsSE = new JTextField();
        textFieldclass = new JTextField();
        textFieldAdress = new JTextField();
        label5 = new JLabel();
        label6 = new JLabel();
        comboBoxday = new JComboBox<>();
        label7 = new JLabel();
        textFieldcno = new JTextField();
        label1 = new JLabel();
        textFieldcapac = new JTextField();
        label2 = new JLabel();
        textFieldselNum = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();

        //---- labelcsno ----
        labelcsno.setText("\u8bfe\u7a0b\u5b89\u6392\u7f16\u53f7");
        labelcsno.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

        //---- labelcsSE ----
        labelcsSE.setText("  \u8d77\u6b62\u5468");
        labelcsSE.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

        //---- labelcTime ----
        labelcTime.setText("\u4e0a\u8bfe\u65f6\u95f4");
        labelcTime.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

        //---- labelcAdr ----
        labelcAdr.setText("\u4e0a\u8bfe\u5730\u70b9");
        labelcAdr.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

        //---- buttonOK ----
        buttonOK.setText("\u786e\u8ba4\u6dfb\u52a0");
        buttonOK.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        buttonOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- textFieldcsSE ----
        textFieldcsSE.setColumns(15);
        textFieldcsSE.setPreferredSize(new Dimension(171, 40));

        //---- textFieldclass ----
        textFieldclass.setColumns(10);

        //---- textFieldAdress ----
        textFieldAdress.setColumns(15);

        //---- label5 ----
        label5.setText("\u661f\u671f");
        label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

        //---- label6 ----
        label6.setText("\u8282");
        label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

        //---- comboBoxday ----
        comboBoxday.setModel(new DefaultComboBoxModel<>(new String[] {
            "\u4e00",
            "\u4e8c",
            "\u4e09",
            "\u56db",
            "\u4e94",
            "\u516d",
            "\u65e5"
        }));

        //---- label7 ----
        label7.setText("\u8bfe\u7a0b\u7f16\u53f7");
        label7.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));

        //---- label1 ----
        label1.setText("\u8bfe\u7a0b\u5bb9\u91cf");

        //---- textFieldcapac ----
        textFieldcapac.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textFieldcapacMouseClicked(e);
            }
        });

        //---- label2 ----
        label2.setText("\u5df2\u9009\u4eba\u6570");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(labelcsno))
                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(labelcsSE, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(label7, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labelcTime, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(labelcAdr, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label1, GroupLayout.Alignment.TRAILING)
                                            .addComponent(label2, GroupLayout.Alignment.TRAILING)))))
                            .addGap(34, 34, 34)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label5)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboBoxday, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(textFieldclass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(label6))
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textFieldcsno, GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldcsSE, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textFieldcno, GroupLayout.Alignment.LEADING))
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(textFieldselNum, GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldcapac, GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldAdress, GroupLayout.Alignment.LEADING))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(186, 186, 186)
                            .addComponent(buttonOK, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(57, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label7)
                        .addComponent(textFieldcno, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelcsno, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldcsno, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldcsSE, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelcsSE, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(comboBoxday, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldclass, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label6)
                        .addComponent(labelcTime, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldAdress, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelcAdr, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldcapac, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldselNum, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label2))
                    .addGap(65, 65, 65)
                    .addComponent(buttonOK, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(41, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        textFieldselNum.setText("0");
        textFieldselNum.setEditable(false);
        textFieldselNum.setBackground(Color.white);
        textFieldselNum.setForeground(Color.black);

        textFieldcapac.setText("请输入0~150");
        textFieldcapac.setEditable(false);
        textFieldcapac.setBackground(Color.white);
        textFieldcapac.setForeground(Color.lightGray);

        //System.out.println(this.cs.getCno()+"hahah");
        textFieldcno.setText(this.cs.getCno());
        textFieldcno.setEditable(false);
        textFieldcno.setBackground(Color.white);
        textFieldcno.setForeground(Color.black);

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel labelcsno;
    private JLabel labelcsSE;
    private JLabel labelcTime;
    private JLabel labelcAdr;
    private JButton buttonOK;
    private JTextField textFieldcsno;
    private JTextField textFieldcsSE;
    private JTextField textFieldclass;
    private JTextField textFieldAdress;
    private JLabel label5;
    private JLabel label6;
    private JComboBox<String> comboBoxday;
    private JLabel label7;
    private JTextField textFieldcno;
    private JLabel label1;
    private JTextField textFieldcapac;
    private JLabel label2;
    private JTextField textFieldselNum;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
     private static CourseSchedule cs;

}
