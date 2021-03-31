package GUI;

import ApplicationManager.ApplicationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private final int textFieldWidth = 200;
    private final int textFieldHeight = 20;

    private ApplicationManager applicationManager;

    private JButton manageDatabaseButton;
    private JButton manualModeButton;

    public MainWindow(ApplicationManager applicationManager) {
        super("Main window");
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.applicationManager = applicationManager;

        manageDatabaseButton = new JButton();
        manageDatabaseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        manageDatabaseButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        manageDatabaseButton.setText("Manage database");
        manageDatabaseButton.addActionListener(new ManageTableActionListener());

        manualModeButton = new JButton();
        manualModeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        manualModeButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        manualModeButton.setText("Manual mode");
        manualModeButton.addActionListener(new ManualModeActionListener());

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.getContentPane().add(manageDatabaseButton);
        this.getContentPane().add(manualModeButton);
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
}
