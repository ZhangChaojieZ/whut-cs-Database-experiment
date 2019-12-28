/*
 * Created by JFormDesigner on Thu Dec 19 19:37:48 CST 2019
 */

package mainGUI;

import java.awt.event.*;

import src.com.dbExperiment.dao.factory.courseDAOfactory;
import src.com.dbExperiment.dao.factory.csDAOfactory;
import src.com.dbExperiment.dao.factory.scDAOfactory;
import src.com.dbExperiment.dao.vo.User;
import src.com.dbExperiment.dao.vo.csList;
import src.com.dbExperiment.dao.vo.scList;

import java.awt.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.*;

/**
 * @author Brainrain
 */
public class ScManaInfoJFrame extends JFrame {
    public ScManaInfoJFrame(User user) {
        this.user = user;
        initComponents();

    }

    private void buttonaddScoreMouseClicked(MouseEvent e) {
        // TODO add your code here
        int currentRow = csInfotable.getSelectedRow();
        if(currentRow == -1) {
            JOptionPane.showMessageDialog(this,"请选中一行");
            return;
        } else {
            String csno = (String) tablemodel.getValueAt(currentRow,0);
            String sno = (String) tablemodel.getValueAt(currentRow,1);
            String score = JOptionPane.showInputDialog("请输入分数0~100");
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String strtime = sdf.format(date);

            try {
                if(scDAOfactory.getscDAOInstance().updateGrade(csno,sno,strtime,Integer.parseInt(score))) {
                    JOptionPane.showMessageDialog(this,"添加成功！");
                }else {
                    JOptionPane.showMessageDialog(this,"添加失败！");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            };
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        csInfotable = new JTable();
        buttonaddScore = new JButton();

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
                        "\u8bfe\u7a0b\u5b89\u6392\u7f16\u53f7", "\u8bfe\u7a0b\u540d\u79f0", "\u5b66\u53f7", "\u9009\u8bfe\u5b66\u751f", "\u5b66\u751f\u6210\u7ee9", "\u6210\u7ee9\u65f6\u95f4"
                    }
                ));
                scrollPane1.setViewportView(csInfotable);
            }

            //---- buttonaddScore ----
            buttonaddScore.setText("\u6dfb\u52a0\u5206\u6570");
            buttonaddScore.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    buttonaddScoreMouseClicked(e);
                }
            });

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(buttonaddScore, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(380, Short.MAX_VALUE))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                        .addGap(42, 42, 42)
                        .addComponent(buttonaddScore, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        try {
            String[] columName = new String[] {
                    "\u8bfe\u7a0b\u5b89\u6392\u7f16\u53f7", "\u4e0a\u8bfe\u8001\u5e08", "\u5b66\u53f7",
                    "\u9009\u8bfe\u5b66\u751f", "\u5b66\u751f\u6210\u7ee9", "\u6210\u7ee9\u65f6\u95f4"};
            List<scList> sclists = scDAOfactory.getscDAOInstance().queryByteaNo(this.user.getNo());
            int sclistNum = sclists.size();
            Object[][] rowInfo = new Object[sclistNum][6];

            int i = 0;
            while(i < sclistNum){
                rowInfo[i][0] = sclists.get(i).getCsNo();
                rowInfo[i][1] = sclists.get(i).getCnmae();
                rowInfo[i][2] = sclists.get(i).getTeaname();
                rowInfo[i][3] = sclists.get(i).getSname();
                rowInfo[i][4] = sclists.get(i).getScgrade();
                rowInfo[i][5] = sclists.get(i).getScgradeTime();
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
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable csInfotable;
    private JButton buttonaddScore;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private TableModel tablemodel;
    private User user;
}
