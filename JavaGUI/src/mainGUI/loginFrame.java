package mainGUI;

import src.com.dbExperiment.dao.factory.userDAOfactory;
import src.com.dbExperiment.dao.vo.User;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Wed Dec 18 13:26:12 CST 2019
 */



/**
 * @author Brainrain
 */
public class loginFrame extends JFrame {
    public loginFrame() {
        initComponents();
    }

    private void loginButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        String name;        // 用户名
        String password;    // 密码
        String role;        // 用户角色
        User user;          // 用户

        user = new User();
        name = nametextField.getText();
        //password = passwordtextField.getPassword().toString();
        password = passwordtextField.getText();
        if(sturadioButton.isSelected()) {
            role = sturadioButton.getText();
        }else if(tearadioButton.isSelected()) {
            role = tearadioButton.getText();
        }else {
            role = manaradioButton.getText();
        }

        // 生成一个user，作为验证登录的参数
        user.setName(name);     // 将名字也设置为账号，如果数据库中存在则会变成正确的名字
        user.setNo(name);
        user.setPassword(password);

        try {
            if(userDAOfactory.getuserDAOInstance().getLogin(user, role)) {
                // 根据角色登录到不同界面
                /*switch (role){
                    case "学生":new stuJframe(user).setVisible(true);
                    case "教师":new teaJframe(user).setVisible(true);
                    case "管理员":new manJframe().setVisible(true);
                }*/
                if(role.equals("学生")) {
                    new stuJframe(user).setVisible(true);
                }else if(role.equals("教师")) {
                    new teaJframe(user).setVisible(true);
                }else {
                    new manJframe().setVisible(true);
                }

                this.setVisible(false); // 隐藏登录窗口
            }else{
                JOptionPane.showMessageDialog(this,"密码或账号输入错误！");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private void passwordtextFieldMouseClicked(MouseEvent e) {
        // TODO add your code here
        if(!passwordtextField.isEditable()) {
            passwordtextField.setText("");
            passwordtextField.setForeground(Color.black);
            passwordtextField.setEditable(true);
            passwordtextField.requestFocus();
        }

    }

    private void nametextFieldMouseClicked(MouseEvent e) {
        // TODO add your code here
        if(!nametextField.isEditable()){
            nametextField.setText("");
            nametextField.setForeground(Color.black);
            nametextField.setEditable(true);
            nametextField.requestFocus();
        }
    }

    private void thisWindowClosed(WindowEvent e) {
        // TODO add your code here
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        loginPane = new JPanel();
        ButtonGroup btGroup = new ButtonGroup();
        tearadioButton = new JRadioButton();
        btGroup.add(this.tearadioButton);
        manaradioButton = new JRadioButton();
        btGroup.add(this.manaradioButton);
        sturadioButton = new JRadioButton();
        btGroup.add(this.sturadioButton);
        nametextField = new JTextField();
        /*nametextField.setText("请输入账号");
        nametextField.setEditable(false);
        nametextField.setBackground(Color.WHITE);
        nametextField.setForeground(Color.lightGray);*/
        nameLabel = new JLabel();
        passwordLabel = new JLabel();
        passwordtextField = new JPasswordField();
        /*passwordtextField.setText("请输入密码");
        passwordtextField.setEditable(false);
        passwordtextField.setBackground(Color.WHITE);
        passwordtextField.setForeground(Color.lightGray);*/
        loginButton = new JButton();

        //======== this ========
        setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 12));
        setAlwaysOnTop(true);
        setTitle("\u6559\u52a1\u7ba1\u7406\u4fe1\u606f\u7cfb\u7edf");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                thisWindowClosed(e);
            }
        });
        Container contentPane = getContentPane();

        //======== loginPane ========
        {
            loginPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            //---- tearadioButton ----
            tearadioButton.setText("\u6559\u5e08");
            tearadioButton.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));

            //---- manaradioButton ----
            manaradioButton.setText("\u7ba1\u7406\u5458");
            manaradioButton.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));

            //---- sturadioButton ----
            sturadioButton.setText("\u5b66\u751f");
            sturadioButton.setSelected(true);
            sturadioButton.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));

            //---- nametextField ----
            nametextField.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    nametextFieldMouseClicked(e);
                }
            });

            //---- nameLabel ----
            nameLabel.setText("  \u7528\u6237\u540d");
            nameLabel.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));

            //---- passwordLabel ----
            passwordLabel.setText("\u5bc6\u7801");
            passwordLabel.setBackground(new Color(51, 204, 255));
            passwordLabel.setFont(new Font("\u6977\u4f53", Font.PLAIN, 16));

            //---- passwordtextField ----
            passwordtextField.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 12));
            passwordtextField.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    passwordtextFieldMouseClicked(e);
                }
            });

            //---- loginButton ----
            loginButton.setText("\u767b\u5f55");
            loginButton.setFont(new Font("\u6977\u4f53", Font.PLAIN, 18));
            loginButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    loginButtonMouseClicked(e);
                }
            });

            GroupLayout loginPaneLayout = new GroupLayout(loginPane);
            loginPane.setLayout(loginPaneLayout);
            loginPaneLayout.setHorizontalGroup(
                loginPaneLayout.createParallelGroup()
                    .addGroup(loginPaneLayout.createSequentialGroup()
                        .addContainerGap(47, Short.MAX_VALUE)
                        .addGroup(loginPaneLayout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, loginPaneLayout.createSequentialGroup()
                                .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(GroupLayout.Alignment.TRAILING, loginPaneLayout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addGap(18, 18, 18)))
                        .addGroup(loginPaneLayout.createParallelGroup()
                            .addComponent(passwordtextField, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                            .addComponent(nametextField))
                        .addContainerGap(94, Short.MAX_VALUE))
                    .addGroup(loginPaneLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(loginPaneLayout.createParallelGroup()
                            .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                            .addGroup(loginPaneLayout.createSequentialGroup()
                                .addComponent(sturadioButton, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(tearadioButton)
                                .addGap(38, 38, 38)
                                .addComponent(manaradioButton)))
                        .addContainerGap(106, Short.MAX_VALUE))
            );
            loginPaneLayout.setVerticalGroup(
                loginPaneLayout.createParallelGroup()
                    .addGroup(loginPaneLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(loginPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(nametextField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(loginPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordtextField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(loginPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(sturadioButton)
                            .addComponent(tearadioButton)
                            .addComponent(manaradioButton))
                        .addGap(34, 34, 34)
                        .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(loginPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(loginPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel loginPane;
    private JRadioButton tearadioButton;
    private JRadioButton manaradioButton;
    private JRadioButton sturadioButton;
    private JTextField nametextField;
    private JLabel nameLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordtextField;
    private JButton loginButton;
    /////////
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
