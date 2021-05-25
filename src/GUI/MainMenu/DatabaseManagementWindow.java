package GUI.MainMenu;

import ApplicationManager.ApplicationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabaseManagementWindow extends JFrame {
    private final int textFieldWidth = 300;
    private final int textFieldHeight = 25;

    private static final String windowName = "Администрирование базы данных";
    private static final String manageDatabaseLabelText = "";
    private static final String manageDatabaseButtonText = "Просмотр и редактирование таблиц";
    private static final String manualModeButtonText = "Ручной режим ввода запросов";
    private static final String initButtonText = "Инициализировать базу данных";
    private static final String fillButtonText = "Заполнить базу тестовыми данными";
    private static final String dropButtonText = "Удалить базу данных";
    private static final String mainMenuButtonText = "Главное меню";

    private ApplicationManager applicationManager;

    private JButton manageDatabaseButton;
    private JButton manualModeButton;

    private JButton initButton;
    private JButton fillButton;
    private JButton dropButton;

    private JButton mainMenuButton;

    public DatabaseManagementWindow(ApplicationManager applicationManager) {
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

        manageDatabaseButton = new JButton();
        manageDatabaseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        manageDatabaseButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        manageDatabaseButton.setText(manageDatabaseButtonText);
        manageDatabaseButton.addActionListener(new ManageTableActionListener());

        manualModeButton = new JButton();
        manualModeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        manualModeButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        manualModeButton.setText(manualModeButtonText);
        manualModeButton.addActionListener(new ManualModeActionListener());

        initButton = new JButton();
        initButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        initButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        initButton.setText(initButtonText);
        initButton.addActionListener(new InitActionListener());

        fillButton = new JButton();
        fillButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        fillButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        fillButton.setText(fillButtonText);
        fillButton.addActionListener(new FillActionListener());

        dropButton = new JButton();
        dropButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dropButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        dropButton.setText(dropButtonText);
        dropButton.addActionListener(new DropActionListener());

        JLabel paddingLabel = new JLabel(" ");
        paddingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainMenuButton = new JButton();
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        mainMenuButton.setText(mainMenuButtonText);
        mainMenuButton.addActionListener(new MainMenuActionListener());

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.getContentPane().add(manageDatabaseLabel);
        this.getContentPane().add(manageDatabaseButton);
        this.getContentPane().add(manualModeButton);
        this.getContentPane().add(initButton);
        this.getContentPane().add(fillButton);
        this.getContentPane().add(dropButton);
        this.getContentPane().add(paddingLabel);
        this.getContentPane().add(mainMenuButton);
    }

    class ManageTableActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showTableManageWindow();
        }
    }

    class ManualModeActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showManualModeWindow();
        }
    }

    class InitActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.initDatabase();
        }
    }

    class FillActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.fillDatabase();
        }
    }

    class DropActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.dropTables();
        }
    }

    class MainMenuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showMainWindow();
        }
    }
}
