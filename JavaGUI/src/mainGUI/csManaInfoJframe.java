/*
 * Created by JFormDesigner on Thu Dec 19 19:41:59 CST 2019
 */

package mainGUI;

import src.com.dbExperiment.dao.factory.csDAOfactory;
import src.com.dbExperiment.dao.factory.userDAOfactory;
import src.com.dbExperiment.dao.vo.Course;
import src.com.dbExperiment.dao.vo.csList;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class csManaInfoJframe extends JFrame {
    public csManaInfoJframe() {
        initComponents();
    }

    private void checkBoxSelSwitchActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(checkBoxSelSwitch.isSelected()) {
            try {
                userDAOfactory.getuserDAOInstance().scStstusSwitch("已开始");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else {
            try {
                userDAOfactory.getuserDAOInstance().scStstusSwitch("未开始");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        csInfotable = new JTable();
        checkBoxSelSwitch = new JCheckBox();

        //======== this ========
        Container contentPane = getContentPane();

        //======== panel1 ========
        {

            //======== scrollPane1 ========
            {

                //---- csInfotable ----
                csInfotable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u8bfe\u7a0b\u5b89\u6392\u7f16\u53f7", "\u8bfe\u7a0b\u540d\u79f0", "\u6559\u5e08\u7f16\u53f7", "\u6559\u5e08\u59d3\u540d", "\u8d77\u6b62\u5468", "\u4e0a\u8bfe\u5929\u6b21", "\u4e0a\u8bfe\u8bfe\u6b21", "\u4e0a\u8bfe\u5730\u70b9", "\u8bfe\u7a0b\u5bb9\u91cf", "\u5df2\u9009\u4eba\u6570"
                    }
                ));
                scrollPane1.setViewportView(csInfotable);
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))
            );
        }

        //---- checkBoxSelSwitch ----
        checkBoxSelSwitch.setText("\u5f00/\u5173\u9009\u8bfe");
        checkBoxSelSwitch.addActionListener(e -> checkBoxSelSwitchActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(325, Short.MAX_VALUE)
                    .addComponent(checkBoxSelSwitch, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                    .addGap(318, 318, 318))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addComponent(checkBoxSelSwitch, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addGap(46, 46, 46))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        try {
            String[] columName = new String[] {
                    "\u8bfe\u7a0b\u5b89\u6392\u7f16\u53f7", "\u8bfe\u7a0b\u540d\u79f0",
                    "\u6559\u5e08\u7f16\u53f7", "\u6559\u5e08\u59d3\u540d",
                    "\u8d77\u6b62\u5468", "\u4e0a\u8bfe\u5929\u6b21", "\u4e0a\u8bfe\u8bfe\u6b21",
                    "\u4e0a\u8bfe\u5730\u70b9", "\u8bfe\u7a0b\u5bb9\u91cf", "\u5df2\u9009\u4eba\u6570"
            };
            List<csList> cslists = csDAOfactory.getcsDAOInstance().queryAllCs();
            int cslistNum = cslists.size();
            Object[][] rowInfo = new Object[cslistNum][10];

            int i = 0;
            while(i < cslistNum){
                rowInfo[i][0] = cslists.get(i).getCsno();
                rowInfo[i][1] = cslists.get(i).getcNmae();
                rowInfo[i][2] = cslists.get(i).getTeaNo();
                rowInfo[i][3] = cslists.get(i).getTeaNmae();
                rowInfo[i][4] = cslists.get(i).getCsweeks();
                rowInfo[i][5] = cslists.get(i).getCsday();
                rowInfo[i][6] = cslists.get(i).getCsclass();
                rowInfo[i][7] = cslists.get(i).getCsadress();
                rowInfo[i][8] = cslists.get(i).getCscapacity();
                rowInfo[i][9] = cslists.get(i).getCsselnum();
                i++;
            }
            tablemodel = new DefaultTableModel(rowInfo,columName);
            csInfotable.setModel(tablemodel);
            csInfotable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            csInfotable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            csInfotable.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(userDAOfactory.getuserDAOInstance().IsSelCourse()) {
                checkBoxSelSwitch.setSelected(true);
            }else {
                checkBoxSelSwitch.setSelected(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable csInfotable;
    private JCheckBox checkBoxSelSwitch;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private TableModel tablemodel;

}
