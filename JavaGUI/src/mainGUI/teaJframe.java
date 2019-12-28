/*
 * Created by JFormDesigner on Wed Dec 18 16:53:42 CST 2019
 */

package mainGUI;

import src.com.dbExperiment.dao.factory.csDAOfactory;
import src.com.dbExperiment.dao.vo.User;
import src.com.dbExperiment.dao.vo.csList;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.table.DefaultTableModel;

/**
 * @author Brainrain
 */
public class teaJframe extends JFrame {
    public teaJframe(User user) {
        this.user = user;
        initComponents();

    }

    private void menuItemscheduleActionPerformed(ActionEvent e) {
        // TODO add your code here
        new csInfoJframe(this.user).setVisible(true);
    }

    private void menuItemgradeActionPerformed(ActionEvent e) {
        // TODO add your code here
        new ScManaInfoJFrame(this.user).setVisible(true);
    }

    private void menuItemAddclassActionPerformed(ActionEvent e) {
        // TODO add your code here
        new addcourseJFrame().setVisible(true);
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        teaMenuBar = new JMenuBar();
        courseMenu = new JMenu();
        menuItemschedule = new JMenuItem();
        stuMamageMenu = new JMenu();
        menuItemgrade = new JMenuItem();
        courseManageMenu = new JMenu();
        menuItemAddclass = new JMenuItem();

        //======== this ========
        setTitle("\u6559\u5e08\u754c\u9762");
        Container contentPane = getContentPane();

        //======== teaMenuBar ========
        {
            teaMenuBar.setPreferredSize(new Dimension(199, 30));

            //======== courseMenu ========
            {
                courseMenu.setText("\u8bfe\u7a0b\u4fe1\u606f");
                courseMenu.setPreferredSize(new Dimension(75, 25));
                courseMenu.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));

                //---- menuItemschedule ----
                menuItemschedule.setText("\u8bfe\u7a0b\u5b89\u6392");
                menuItemschedule.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));
                menuItemschedule.setPreferredSize(new Dimension(75, 25));
                menuItemschedule.addActionListener(e -> menuItemscheduleActionPerformed(e));
                courseMenu.add(menuItemschedule);
            }
            teaMenuBar.add(courseMenu);

            //======== stuMamageMenu ========
            {
                stuMamageMenu.setText("\u5b66\u751f\u7ba1\u7406");
                stuMamageMenu.setMinimumSize(new Dimension(75, 25));
                stuMamageMenu.setPreferredSize(new Dimension(75, 25));
                stuMamageMenu.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));

                //---- menuItemgrade ----
                menuItemgrade.setText("\u5b66\u751f\u6210\u7ee9");
                menuItemgrade.setPreferredSize(new Dimension(75, 25));
                menuItemgrade.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));
                menuItemgrade.addActionListener(e -> menuItemgradeActionPerformed(e));
                stuMamageMenu.add(menuItemgrade);
            }
            teaMenuBar.add(stuMamageMenu);

            //======== courseManageMenu ========
            {
                courseManageMenu.setText("\u8bfe\u7a0b\u7ba1\u7406");
                courseManageMenu.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));
                courseManageMenu.setPreferredSize(new Dimension(75, 25));

                //---- menuItemAddclass ----
                menuItemAddclass.setText("\u7533\u8bf7\u5f00\u8bfe");
                menuItemAddclass.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));
                menuItemAddclass.setPreferredSize(new Dimension(75, 25));
                menuItemAddclass.addActionListener(e -> menuItemAddclassActionPerformed(e));
                courseManageMenu.add(menuItemAddclass);
            }
            teaMenuBar.add(courseManageMenu);
        }
        setJMenuBar(teaMenuBar);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 678, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 383, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar teaMenuBar;
    private JMenu courseMenu;
    private JMenuItem menuItemschedule;
    private JMenu stuMamageMenu;
    private JMenuItem menuItemgrade;
    private JMenu courseManageMenu;
    private JMenuItem menuItemAddclass;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private User user;
}
