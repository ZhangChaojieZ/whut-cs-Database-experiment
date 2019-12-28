/*
 * Created by JFormDesigner on Thu Dec 19 17:31:54 CST 2019
 */

package mainGUI;

import src.com.dbExperiment.dao.factory.csDAOfactory;
import src.com.dbExperiment.dao.factory.scDAOfactory;
import src.com.dbExperiment.dao.factory.userDAOfactory;
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
public class selectedCourseJFrame extends JFrame {
    public selectedCourseJFrame(User user) {
        this.user = user;
        initComponents();

    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        try {
            if(!userDAOfactory.getuserDAOInstance().IsSelCourse()) {
                JOptionPane.showMessageDialog(this,"不在选课时间，无法操作！");
                return;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        int currentRow =selectedCourseList.getSelectedRow();
        if(currentRow == -1) {
            JOptionPane.showMessageDialog(this,"请选中一行");
        }else {
            try {
                if(scDAOfactory.getscDAOInstance().delete((String)tablemodel.getValueAt(currentRow, 0),
                        this.user.getNo())) {
                    JOptionPane.showMessageDialog(this,"删除成功");
                }else{
                    JOptionPane.showMessageDialog(this,"删除失败");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        baseJPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        selectedCourseList = new JTable();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //======== baseJPanel ========
        {

            //======== scrollPane1 ========
            {

                //---- selectedCourseList ----
                selectedCourseList.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "\u8bfe\u7a0b\u540d\u79f0", "\u4e0a\u8bfe\u8001\u5e08", "\u8d77\u6b62\u5468", "\u4e0a\u8bfe\u5929\u6b21", "\u4e0a\u8bfe\u8bfe\u6b21", "\u4e0a\u8bfe\u5730\u70b9", "\u5bb9\u91cf", "\u5df2\u9009\u4eba\u6570"
                    }
                ));
                scrollPane1.setViewportView(selectedCourseList);
            }

            //---- button1 ----
            button1.setText("\u5220\u9664\u8bfe\u7a0b");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });

            GroupLayout baseJPanelLayout = new GroupLayout(baseJPanel);
            baseJPanel.setLayout(baseJPanelLayout);
            baseJPanelLayout.setHorizontalGroup(
                baseJPanelLayout.createParallelGroup()
                    .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addGroup(baseJPanelLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(button1)
                        .addContainerGap(698, Short.MAX_VALUE))
            );
            baseJPanelLayout.setVerticalGroup(
                baseJPanelLayout.createParallelGroup()
                    .addGroup(baseJPanelLayout.createSequentialGroup()
                        .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(button1)
                        .addGap(0, 59, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(baseJPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(baseJPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        try {
            String[] columName = new String[] {
                    "\u8bfe\u7a0b\u540d\u79f0", "\u4e0a\u8bfe\u8001\u5e08", "\u8d77\u6b62\u5468\u6570",
                    "\u4e0a\u8bfe\u5929\u6b21", "\u4e0a\u8bfe\u8bfe\u6b21",
                    "\u4e0a\u8bfe\u5730\u70b9", "\u5bb9\u91cf", "\u5df2\u9009\u4eba\u6570"
                    };
            if(csDAOfactory.getcsDAOInstance().queryselected(this.user.getNo()) != null) {
                List<csList> cslists = csDAOfactory.getcsDAOInstance().queryselected(this.user.getNo());

                int cslistNum = cslists.size();
                Object[][] rowInfo = new Object[cslistNum][8];

                int i = 0;
                while (i < cslistNum) {
                    rowInfo[i][0] = cslists.get(i).getCsno();
                    rowInfo[i][1] = cslists.get(i).getcNmae();
                    rowInfo[i][2] = cslists.get(i).getCsweeks();
                    rowInfo[i][3] = cslists.get(i).getCsday();
                    rowInfo[i][4] = cslists.get(i).getCsclass();
                    rowInfo[i][5] = cslists.get(i).getCsadress();
                    rowInfo[i][6] = cslists.get(i).getCscapacity();
                    rowInfo[i][7] = cslists.get(i).getCsselnum();
                    i++;
                }
                tablemodel = new DefaultTableModel(rowInfo, columName);
                selectedCourseList.setModel(tablemodel);
                selectedCourseList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                selectedCourseList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                selectedCourseList.setVisible(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel baseJPanel;
    private JScrollPane scrollPane1;
    private JTable selectedCourseList;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private TableModel tablemodel;
    private User user;
}
