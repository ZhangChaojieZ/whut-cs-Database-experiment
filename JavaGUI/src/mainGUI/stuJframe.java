/*
 * Created by JFormDesigner on Wed Dec 18 16:14:27 CST 2019
 */

package mainGUI;

import src.com.dbExperiment.dao.vo.User;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Brainrain
 */
public class stuJframe extends JFrame {
    public stuJframe(User user) {
        this.user = user;
        initComponents();

    }

    private void SdCMenuItemActionPerformed(ActionEvent e) {
        // TODO add your code here
        new selectedCourseJFrame(this.user).setVisible(true);
    }

    private void SCMenuItemActionPerformed(ActionEvent e) {
        // TODO add your code here
        new selectCourseJframe(this.user).setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        stuMenuBar = new JMenuBar();
        courseMenu = new JMenu();
        SCMenuItem = new JMenuItem();
        SdCMenuItem = new JMenuItem();
        welcomelabel = new JLabel();

        //======== this ========
        setTitle("\u5b66\u751f\u754c\u9762");
        setMinimumSize(new Dimension(80, 40));
        setFont(new Font(Font.DIALOG, Font.PLAIN, 12));
        Container contentPane = getContentPane();

        //======== stuMenuBar ========
        {
            stuMenuBar.setPreferredSize(new Dimension(176, 30));

            //======== courseMenu ========
            {
                courseMenu.setText("\u8bfe\u7a0b\u4fe1\u606f");
                courseMenu.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));
                courseMenu.setPreferredSize(new Dimension(75, 25));

                //---- SCMenuItem ----
                SCMenuItem.setText("\u9009\u8bfe");
                SCMenuItem.setPreferredSize(new Dimension(75, 25));
                SCMenuItem.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));
                SCMenuItem.addActionListener(e -> SCMenuItemActionPerformed(e));
                courseMenu.add(SCMenuItem);

                //---- SdCMenuItem ----
                SdCMenuItem.setText("\u5df2\u9009\u8bfe\u7a0b");
                SdCMenuItem.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));
                SdCMenuItem.addActionListener(e -> SdCMenuItemActionPerformed(e));
                courseMenu.add(SdCMenuItem);
            }
            stuMenuBar.add(courseMenu);
        }
        setJMenuBar(stuMenuBar);

        //---- welcomelabel ----
        welcomelabel.setText("         \u6b22\u8fce\u6765\u5230\u6559\u52a1\u7ba1\u7406\u7cfb\u7edf      ");
        welcomelabel.setFont(new Font("\u6977\u4f53", Font.PLAIN, 30));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(84, 84, 84)
                    .addComponent(welcomelabel, GroupLayout.PREFERRED_SIZE, 583, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(86, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(welcomelabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(216, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar stuMenuBar;
    private JMenu courseMenu;
    private JMenuItem SCMenuItem;
    private JMenuItem SdCMenuItem;
    private JLabel welcomelabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private User user;
}
