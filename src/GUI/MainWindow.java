package GUI;

import ApplicationManager.ApplicationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainWindow extends JFrame {
    private final int textFieldWidth = 300;
    private final int textFieldHeight = 25;

    private static final String windowName = "Главное меню";
    private static final String manageDatabaseLabelText = "";
    private static final String manageShopButtonText = "Управление магазином";
    private static final String manageUsersButtonText = "Управление пользователями";
    private static final String manageDatabaseButtonText = "Администрирование базы данных";
    private static final String disconnectButtonText = "Отключить текущее соединение";
    private static final String exitButtonText = "Выход из приложения";

    private JButton helpButton;
    private static final String helpButtonText = "Помощь";
    private static final String helpText = "Это главное меню.\n" +
            "Для работы с магазином нажмите \"Управление магазином\",\n" +
            "В управлении магазином осуществляются все действия, связанные с бизнес логикой.\n" +
            "Для добавления и удаления работников магазина нажмите \"Управление сотрудниками\".\n" +
            "Для ручного управления базой данных нажмите \"Администрирование базы данных\" (это админ панель).\n";

    private ApplicationManager applicationManager;

    private JButton manageShopButton;
    private JButton manageUsersButton;
    private JButton manageDatabaseButton;

    private JButton disconnectButton;
    private JButton exitButton;

    public MainWindow(ApplicationManager applicationManager) {
        super(windowName);
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.applicationManager = applicationManager;

        JLabel manageDatabaseLabel = new JLabel(manageDatabaseLabelText);
        manageDatabaseLabel.setBorder(BorderFactory.createEmptyBorder(240, 0, 0, 0));
        manageDatabaseLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        manageShopButton = new JButton();
        manageShopButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        manageShopButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        manageShopButton.setText(manageShopButtonText);
        manageShopButton.addActionListener(new ShopManagementActionListener());

        manageUsersButton = new JButton();
        manageUsersButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        manageUsersButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        manageUsersButton.setText(manageUsersButtonText);
        manageUsersButton.addActionListener(new ManageUsersActionListener());

        manageDatabaseButton = new JButton();
        manageDatabaseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        manageDatabaseButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        manageDatabaseButton.setText(manageDatabaseButtonText);
        manageDatabaseButton.addActionListener(new ManageDatabaseActionListener());

        disconnectButton = new JButton();
        disconnectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        disconnectButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        disconnectButton.setText(disconnectButtonText);
        disconnectButton.addActionListener(new DisconnectActionListener());

        exitButton = new JButton();
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        exitButton.setText(exitButtonText);
        exitButton.addActionListener(new ExitActionListener());

        helpButton = new JButton();
        helpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        helpButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        helpButton.setText(helpButtonText);
        helpButton.addActionListener(new HelpListener());

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.getContentPane().add(manageDatabaseLabel);
        this.getContentPane().add(manageShopButton);
        this.getContentPane().add(manageUsersButton);
        this.getContentPane().add(manageDatabaseButton);

        this.getContentPane().add(new JLabel(" "));
        this.getContentPane().add(disconnectButton);
        this.getContentPane().add(exitButton);
        this.getContentPane().add(new JLabel(" "));
        this.getContentPane().add(helpButton);
    }

    public void showAndHideButtons() {
        manageUsersButton.setEnabled(applicationManager.getUserRolesList().contains("SHOP_DIRECTOR") &&
                applicationManager.getUserRolesList().contains("SHOP_ADMIN"));
        manageDatabaseButton.setEnabled(applicationManager.getUserRolesList().contains("SHOP_ADMIN"));
    }

    class ShopManagementActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showShopManagementWindow();
        }
    }

    class ManageDatabaseActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showDatabaseManagementWindow();
        }
    }

    class ManageUsersActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showUsersManagementWindow();
        }
    }

    class DisconnectActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                applicationManager.logout();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
    }

    class ExitActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class HelpListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, helpText);
        }
    }
}
