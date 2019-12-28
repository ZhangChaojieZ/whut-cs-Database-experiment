/*
 * Created by JFormDesigner on Thu Dec 19 20:32:45 CST 2019
 */

package mainGUI;

import src.com.dbExperiment.dao.factory.scDAOfactory;
import src.com.dbExperiment.dao.vo.scList;

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
public class courSelInfoJFrame extends JFrame {
    public courSelInfoJFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        Container contentPane = getContentPane();

        //======== panel1 ========
        {

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                        {null, null, null, null, null},
                    },
                    new String[] {
                        "\u8bfe\u7a0b\u5b89\u6392\u7f16\u53f7", "\u8bfe\u7a0b\u540d\u79f0", "\u6559\u5e08\u59d3\u540d", "\u5b66\u53f7", "\u5b66\u751f\u59d3\u540d"
                    }
                ));
                scrollPane1.setViewportView(table1);
            }

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
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
                .addComponent(panel1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        try {
            String[] columName = new String[] {
                    "\u8bfe\u7a0b\u5b89\u6392\u7f16\u53f7", "\u8bfe\u7a0b\u540d\u79f0",
                    "\u6559\u5e08\u59d3\u540d", "\u5b66\u53f7", "\u5b66\u751f\u59d3\u540d"
            };
            List<scList> sclists = scDAOfactory.getscDAOInstance().queryAll();
            int sclistNum = sclists.size();
            Object[][] rowInfo = new Object[sclistNum][6];

            int i = 0;
            while(i < sclistNum){
                rowInfo[i][0] = sclists.get(i).getCsNo();
                rowInfo[i][1] = sclists.get(i).getCnmae();
                rowInfo[i][2] = sclists.get(i).getTeaname();
                rowInfo[i][3] = sclists.get(i).getSno();
                rowInfo[i][4] = sclists.get(i).getSname();

                i++;
            }
            tablemodel = new DefaultTableModel(rowInfo,columName);
            table1.setModel(tablemodel);
            table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            table1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            table1.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private  TableModel tablemodel;
}
