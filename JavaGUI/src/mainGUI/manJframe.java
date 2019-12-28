/*
 * Created by JFormDesigner on Wed Dec 18 17:21:17 CST 2019
 */

package mainGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Brainrain
 */
public class manJframe extends JFrame {
    public manJframe() {
        initComponents();
    }

    private void courInfoMenuItemActionPerformed(ActionEvent e) {
        // TODO add your code here
        new courManaIfoJFrame().setVisible(true);
    }

    private void scInfoMenuItemActionPerformed(ActionEvent e) {
        // TODO add your code here
        new courSelInfoJFrame().setVisible(true);
    }

    private void csInfoMenuItemActionPerformed(ActionEvent e) {
        // TODO add your code here
        new csManaInfoJframe().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        managerMenuBar = new JMenuBar();
        CourseInfoMenu = new JMenu();
        courInfoMenuItem = new JMenuItem();
        scInfoMenuItem = new JMenuItem();
        csInfoMenuItem = new JMenuItem();

        //======== this ========
        setTitle("\u7ba1\u7406\u5458\u754c\u9762");
        Container contentPane = getContentPane();

        //======== managerMenuBar ========
        {
            managerMenuBar.setPreferredSize(new Dimension(100, 30));

            //======== CourseInfoMenu ========
            {
                CourseInfoMenu.setText("\u8bfe\u7a0b\u7ba1\u7406");
                CourseInfoMenu.setPreferredSize(new Dimension(90, 25));
                CourseInfoMenu.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));

                //---- courInfoMenuItem ----
                courInfoMenuItem.setText("\u8bfe\u7a0b\u7ba1\u7406");
                courInfoMenuItem.setPreferredSize(new Dimension(90, 21));
                courInfoMenuItem.setFont(new Font("\u6977\u4f53", Font.PLAIN, 14));
                courInfoMenuItem.addActionListener(e -> courInfoMenuItemActionPerformed(e));
                CourseInfoMenu.add(courInfoMenuItem);

                //---- scInfoMenuItem ----
                scInfoMenuItem.setText("\u9009\u8bfe\u7ba1\u7406");
                scInfoMenuItem.setPreferredSize(new Dimension(90, 25));
                scInfoMenuItem.setFont(new Font("\u6977\u4f53", Font.PLAIN, 14));
                scInfoMenuItem.addActionListener(e -> scInfoMenuItemActionPerformed(e));
                CourseInfoMenu.add(scInfoMenuItem);

                //---- csInfoMenuItem ----
                csInfoMenuItem.setText("\u8bfe\u7a0b\u5b89\u6392\u7ba1\u7406");
                csInfoMenuItem.setPreferredSize(new Dimension(90, 25));
                csInfoMenuItem.setFont(new Font("\u6977\u4f53", Font.PLAIN, 14));
                csInfoMenuItem.addActionListener(e -> csInfoMenuItemActionPerformed(e));
                CourseInfoMenu.add(csInfoMenuItem);
            }
            managerMenuBar.add(CourseInfoMenu);
        }
        setJMenuBar(managerMenuBar);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 748, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 433, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar managerMenuBar;
    private JMenu CourseInfoMenu;
    private JMenuItem courInfoMenuItem;
    private JMenuItem scInfoMenuItem;
    private JMenuItem csInfoMenuItem;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
