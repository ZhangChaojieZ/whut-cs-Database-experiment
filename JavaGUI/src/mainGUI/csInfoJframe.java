/*
 * Created by JFormDesigner on Fri Dec 20 17:27:49 CST 2019
 */

package mainGUI;

import src.com.dbExperiment.dao.factory.csDAOfactory;
import src.com.dbExperiment.dao.vo.User;
import src.com.dbExperiment.dao.vo.csList;

import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class csInfoJframe extends JFrame {
    public csInfoJframe(User user) {
        this.user = user;
        initComponents();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        tablecs = new JTable();

        //======== this ========
        setTitle("\u8bfe\u7a0b\u5b89\u6392");
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- tablecs ----
            tablecs.setModel(new DefaultTableModel(
                new Object[][] {
                    {"", null, null, null, null, null, null, null},
                },
                new String[] {
                    "\u8bfe\u7a0b\u7f16\u53f7", "\u8bfe\u7a0b\u540d\u79f0", "\u8d77\u6b62\u5468", "\u4e0a\u8bfe\u5929\u6b21", "\u4e0a\u8bfe\u8bfe\u6b21", "\u4e0a\u8bfe\u5730\u70b9", "\u8bfe\u7a0b\u5bb9\u91cf", "\u5df2\u9009\u4eba\u6570"
                }
            ));
            scrollPane1.setViewportView(tablecs);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 531, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        try {
            String[] columName = new String[] {
                    "\u8bfe\u7a0b\u540d\u79f0", "\u4e0a\u8bfe\u8001\u5e08", "\u8d77\u6b62\u5468\u6570",
                    "\u4e0a\u8bfe\u5929\u6b21", "\u4e0a\u8bfe\u8bfe\u6b21",
                    "\u4e0a\u8bfe\u5730\u70b9", "\u5bb9\u91cf", "\u5df2\u9009\u4eba\u6570",
                    };
            //if(csDAOfactory.getcsDAOInstance().queryByteaNo(this.user.getNo()) != null) {
                List<csList> cslistInfo = csDAOfactory.getcsDAOInstance().querycsByteaNo(this.user.getNo());
                int IcslistInfoNum = cslistInfo.size();
                Object[][] rowInfo = new Object[IcslistInfoNum][8];

                int i = 0;
                while (i < IcslistInfoNum) {
                    rowInfo[i][0] = cslistInfo.get(i).getCsno();
                    rowInfo[i][1] = cslistInfo.get(i).getcNmae();
                    rowInfo[i][2] = cslistInfo.get(i).getCsweeks();
                    rowInfo[i][3] = cslistInfo.get(i).getCsday();
                    rowInfo[i][4] = cslistInfo.get(i).getCsclass();
                    rowInfo[i][5] = cslistInfo.get(i).getCsadress();
                    rowInfo[i][6] = cslistInfo.get(i).getCscapacity();
                    rowInfo[i][7] = cslistInfo.get(i).getCsselnum();
                    i++;
                }
                tablemodel = new DefaultTableModel(rowInfo, columName);
                tablecs.setModel(tablemodel);
                tablecs.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                tablecs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                tablecs.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable tablecs;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private TableModel tablemodel;
    private User user;
}
