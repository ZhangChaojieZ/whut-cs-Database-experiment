/*
 * Created by JFormDesigner on Thu Dec 19 16:44:49 CST 2019
 */

package mainGUI;

import src.com.dbExperiment.dao.factory.csDAOfactory;
import src.com.dbExperiment.dao.factory.scDAOfactory;
import src.com.dbExperiment.dao.factory.userDAOfactory;
import src.com.dbExperiment.dao.vo.SC;
import src.com.dbExperiment.dao.vo.User;
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
public class selectCourseJframe extends JFrame {
    public selectCourseJframe(User user) {
        this.user = user;
        System.out.println(this.user.getTerm());
        System.out.println(this.user.getCollno());
        initComponents();

    }

    private void selectCoursebuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        try {
            if(!userDAOfactory.getuserDAOInstance().IsSelCourse()) {
                JOptionPane.showMessageDialog(this,"未开始选课");
                return;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        SC sc = new SC();
        int currentRow =courseScheduleList.getSelectedRow();
        if(currentRow == -1) {
            JOptionPane.showMessageDialog(this,"请选中一行");
        }else {
            sc.setCsNo((String)tablemodel.getValueAt(currentRow,0));
            sc.setSno(user.getNo());
        }
        try {
            if(scDAOfactory.getscDAOInstance().addSc(sc)) {
                JOptionPane.showMessageDialog(this,"选课成功");
            }else{
                JOptionPane.showMessageDialog(this,"选课失败");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        baseJPanel = new JPanel();
        selectCoursescrollPane = new JScrollPane();
        courseScheduleList = new JTable();
        selectCoursebutton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== baseJPanel ========
        {

            //======== selectCoursescrollPane ========
            {

                //---- courseScheduleList ----
                courseScheduleList.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u8bfe\u7a0b\u7f16\u53f7", "\u8bfe\u7a0b\u540d\u79f0", "\u4e0a\u8bfe\u8001\u5e08", "\u8d77\u6b62\u5468", "\u4e0a\u8bfe\u5929\u6b21", "\u4e0a\u8bfe\u8bfe\u6b21", "\u4e0a\u8bfe\u5730\u70b9", "\u5bb9\u91cf", "\u5df2\u9009\u4eba\u6570"
                    }
                ));
                {
                    TableColumnModel cm = courseScheduleList.getColumnModel();
                    cm.getColumn(1).setCellEditor(new DefaultCellEditor(
                        new JComboBox(new DefaultComboBoxModel(new String[] {
                            "cslist0"
                        }))));
                    cm.getColumn(2).setCellEditor(new DefaultCellEditor(
                        new JComboBox(new DefaultComboBoxModel(new String[] {
                            "cslist1"
                        }))));
                    cm.getColumn(3).setCellEditor(new DefaultCellEditor(
                        new JComboBox(new DefaultComboBoxModel(new String[] {
                            "cslist2"
                        }))));
                    cm.getColumn(4).setCellEditor(new DefaultCellEditor(
                        new JComboBox(new DefaultComboBoxModel(new String[] {
                            "cslist3"
                        }))));
                    cm.getColumn(5).setCellEditor(new DefaultCellEditor(
                        new JComboBox(new DefaultComboBoxModel(new String[] {
                            "cslist4"
                        }))));
                    cm.getColumn(6).setCellEditor(new DefaultCellEditor(
                        new JComboBox(new DefaultComboBoxModel(new String[] {
                            "cslist5"
                        }))));
                    cm.getColumn(7).setCellEditor(new DefaultCellEditor(
                        new JComboBox(new DefaultComboBoxModel(new String[] {
                            "cslist6"
                        }))));
                    cm.getColumn(8).setCellEditor(new DefaultCellEditor(
                        new JComboBox(new DefaultComboBoxModel(new String[] {
                            "cslist7"
                        }))));
                }
                courseScheduleList.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));
                courseScheduleList.setSelectionBackground(new Color(57, 105, 138));
                selectCoursescrollPane.setViewportView(courseScheduleList);
            }

            GroupLayout baseJPanelLayout = new GroupLayout(baseJPanel);
            baseJPanel.setLayout(baseJPanelLayout);
            baseJPanelLayout.setHorizontalGroup(
                baseJPanelLayout.createParallelGroup()
                    .addGroup(baseJPanelLayout.createSequentialGroup()
                        .addComponent(selectCoursescrollPane, GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                        .addContainerGap())
            );
            baseJPanelLayout.setVerticalGroup(
                baseJPanelLayout.createParallelGroup()
                    .addGroup(baseJPanelLayout.createSequentialGroup()
                        .addComponent(selectCoursescrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 46, Short.MAX_VALUE))
            );
        }

        //---- selectCoursebutton ----
        selectCoursebutton.setText("\u9009\u8bfe");
        selectCoursebutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectCoursebuttonMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(baseJPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(152, 152, 152)
                    .addComponent(selectCoursebutton)
                    .addContainerGap(624, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(baseJPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(selectCoursebutton)
                    .addGap(0, 37, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        try {
            String[] columName = new String[] {
                    "\u8bfe\u7a0b\u7f16\u53f7", "\u8bfe\u7a0b\u540d\u79f0", "\u4e0a\u8bfe\u8001\u5e08", "\u8d77\u6b62\u5468", "\u4e0a\u8bfe\u5929\u6b21", "\u4e0a\u8bfe\u8bfe\u6b21", "\u4e0a\u8bfe\u5730\u70b9", "\u5bb9\u91cf", "\u5df2\u9009\u4eba\u6570"
            };
            List<csList> cslists = csDAOfactory.getcsDAOInstance().queryBycollNoAndCterm(this.user.getCollno(),
                    this.user.getTerm());
            int cslistNum = cslists.size();
            Object[][] rowInfo = new Object[cslistNum][9];

            int i = 0;
            while(i < cslistNum){
                rowInfo[i][0] = cslists.get(i).getCsno();
                rowInfo[i][1] = cslists.get(i).getcNmae();
                rowInfo[i][2] = cslists.get(i).getTeaNmae();
                rowInfo[i][3] = cslists.get(i).getCsweeks();
                rowInfo[i][4] = cslists.get(i).getCsday();
                rowInfo[i][5] = cslists.get(i).getCsclass();
                rowInfo[i][6] = cslists.get(i).getCsadress();
                rowInfo[i][7] = cslists.get(i).getCscapacity();
                rowInfo[i][8] = cslists.get(i).getCsselnum();
                i++;
                /*//rowInfo[i][0] = cslists.get(i).getCsno();
                rowInfo[i][0] = cslists.get(i).getcNmae();
                rowInfo[i][1] = cslists.get(i).getTeaNmae();
                rowInfo[i][2] = cslists.get(i).getCsweeks();
                rowInfo[i][3] = cslists.get(i).getCsday();
                rowInfo[i][4] = cslists.get(i).getCsclass();
                rowInfo[i][5] = cslists.get(i).getCsadress();
                rowInfo[i][6] = cslists.get(i).getCscapacity();
                rowInfo[i][7] = cslists.get(i).getCsselnum();
                i++;*/
            }
            tablemodel = new DefaultTableModel(rowInfo,columName);
            courseScheduleList.setModel(tablemodel);
            courseScheduleList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            courseScheduleList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            courseScheduleList.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel baseJPanel;
    private JScrollPane selectCoursescrollPane;
    private JTable courseScheduleList;
    private JButton selectCoursebutton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private TableModel tablemodel;
    private User user;
}
