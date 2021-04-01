package GUI;

import ApplicationManager.ApplicationManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManualModeWindow extends JFrame {

    private ApplicationManager applicationManager;

    private JPanel navigatePanel;
    private JPanel contentPanel;
    private JPanel managePanel;

    private JButton buttonBack;
    private JButton executeButton;

    private JTextField queryField;
    private JTextArea consoleArea;

    public ManualModeWindow(ApplicationManager applicationManager) {
        super("Manual Mode");
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.applicationManager = applicationManager;

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPanel);

        managePanel = new JPanel();
        managePanel.setLayout(new BoxLayout(managePanel, BoxLayout.PAGE_AXIS));

        navigatePanel = new JPanel();
        FlowLayout navigatePanelLayout = (FlowLayout) navigatePanel.getLayout();
        navigatePanelLayout.setAlignment(FlowLayout.LEFT);

        buttonBack = new JButton("Back");
        buttonBack.addActionListener(new BackButtonActionListener());

        executeButton = new JButton("Execute");
        //executeButton.addActionListener(new UpdateActionListener());

        queryField = new JTextField(50);
        queryField.setMaximumSize(new Dimension((this.getWidth() - 100), 20));

        consoleArea = new JTextArea(20, 70);

        navigatePanel.add(buttonBack);

        JPanel tmpPanel = new JPanel();
        tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.LINE_AXIS));

        tmpPanel.add(queryField);
        tmpPanel.add(executeButton);

        managePanel.add(tmpPanel);

        contentPanel.add(navigatePanel, BorderLayout.NORTH);
        contentPanel.add(managePanel);
        contentPanel.add(consoleArea, BorderLayout.SOUTH);
    }


    class BackButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            applicationManager.showMainWindow();
        }
    }

    class ExecuteButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ResultSet resultSet;
            try {
                resultSet = applicationManager.executeQuery(queryField.getText());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            //TODO: ...
        }
    }

}