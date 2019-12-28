/*
 * Created by JFormDesigner on Thu Dec 19 19:48:57 CST 2019
 */

package mainGUI;

import src.com.dbExperiment.dao.DAO.courseDAO;
import src.com.dbExperiment.dao.factory.courseDAOfactory;
import src.com.dbExperiment.dao.vo.Course;
import src.com.dbExperiment.dao.vo.CourseSchedule;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class courManaIfoJFrame extends JFrame {

    public courManaIfoJFrame() {
        initComponents();
    }

    private void selectSwitchbuttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        int currentRow = coursetable.getSelectedRow();
        if(currentRow == -1) {
            JOptionPane.showMessageDialog(this,"请选中一行");
            return;
        }
        else if(((String)tablemodel.getValueAt(currentRow,3)).equals("已审核")) {
            JOptionPane.showMessageDialog(this,"请勿重复同意！");
            return;
        }
        else {
            try {
                if(courseDAOfactory.getcourseDAOInstance().updateCourseStatus((String)tablemodel.getValueAt(currentRow
                        ,0), "已审核")) {
                    JOptionPane.showMessageDialog(this,"同意成功！");
                }else {
                    JOptionPane.showMessageDialog(this,"同意失败！");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            };
        }
    }

    private void buttonaddCsMouseClicked(MouseEvent e) {
        // TODO add your code here
        int currentRow = coursetable.getSelectedRow();
        if(currentRow == -1) {
            JOptionPane.showMessageDialog(this,"请选中一行");
            return;
        } else {
            CourseSchedule cs = new CourseSchedule();
            cs.setCno((String)tablemodel.getValueAt(currentRow,0));
            System.out.println(cs.getCno());
            new addcsJFrame(cs).setVisible(true);

        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        coursetable = new JTable();
        agreeCourbutton = new JButton();
        buttonaddCs = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        ///zzzzzxxx

        //======== panel1 ========
        {

            //======== scrollPane1 ========
            {

                //---- coursetable ----
                coursetable.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u8bfe\u7a0b\u7f16\u53f7", "\u8bfe\u7a0b\u540d\u79f0", "\u8bfe\u7a0b\u6027\u8d28", "\u8bfe\u7a0b\u72b6\u6001", "\u5b66\u5206", "\u5b66\u65f6\u6570", "\u5f00\u8bfe\u5b66\u671f", "\u6559\u5e08\u7f16\u53f7", "\u5b66\u9662\u7f16\u53f7"
                    }
                ));
                coursetable.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
                scrollPane1.setViewportView(coursetable);
            }

            //---- agreeCourbutton ----
            agreeCourbutton.setText("\u540c\u610f\u5f00\u8bfe");
            agreeCourbutton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    selectSwitchbuttonMouseClicked(e);
                }
            });

            //---- buttonaddCs ----
            buttonaddCs.setText("\u6dfb\u52a0\u8bfe\u7a0b\u5b89\u6392");
            buttonaddCs.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buttonaddCsMouseClicked(e);
                }
            });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(agreeCourbutton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169)
                        .addComponent(buttonaddCs)
                        .addContainerGap(247, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 851, Short.MAX_VALUE)
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonaddCs, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(agreeCourbutton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        //cs = new CourseSchedule();
        try {
            List<Course> cour = courseDAOfactory.getcourseDAOInstance().quaryAll();
            int courseNum = courseDAOfactory.getcourseDAOInstance().quaryAll().size();
            Object[][] rowInfo = new Object[courseNum][9];
            int i = 0;
            while (i < courseNum) {
                rowInfo[i][0] = cour.get(i).getCno();
                rowInfo[i][1] = cour.get(i).getCname();
                rowInfo[i][2] = cour.get(i).getCnature();
                rowInfo[i][3] = cour.get(i).getCstatus();
                rowInfo[i][4] = cour.get(i).getCcredit();
                rowInfo[i][5] = cour.get(i).getChour();
                rowInfo[i][6] = cour.get(i).getCterm();
                rowInfo[i][7] = cour.get(i).getTeano();
                rowInfo[i][8] = cour.get(i).getCollno();
                i++;
            }
            tablemodel = new DefaultTableModel(rowInfo,new String[] {
                    "\u8bfe\u7a0b\u7f16\u53f7", "\u8bfe\u7a0b\u540d\u79f0", "\u8bfe\u7a0b\u6027\u8d28", "\u8bfe\u7a0b\u72b6\u6001", "\u5b66\u5206", "\u5b66\u65f6\u6570", "\u5f00\u8bfe\u5b66\u671f", "\u6559\u5e08\u7f16\u53f7", "\u5b66\u9662\u7f16\u53f7"
            });
            coursetable.setModel(tablemodel);
            coursetable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            coursetable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            coursetable.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable coursetable;
    private JButton agreeCourbutton;
    private JButton buttonaddCs;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private TableModel tablemodel;
    //private CourseSchedule cs;

}
