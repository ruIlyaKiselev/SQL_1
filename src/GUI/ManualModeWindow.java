package GUI;

import ApplicationManager.ApplicationManager;
import GUI.Utility.DBTablePrinter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
        executeButton.addActionListener(new ExecuteButtonActionListener());

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
            applicationManager.showDatabaseManagementWindow();
        }
    }

    class ExecuteButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                ResultSet resultSet = applicationManager.executeQuery(queryField.getText());
                ResultSetMetaData rsmd = resultSet.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                DBTablePrinter.printResultSet(resultSet);

                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) {
                        consoleArea.append(" | ");
                    }
                    consoleArea.append(rsmd.getColumnName(i));
                }
                consoleArea.append("\n");

                while (resultSet.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) {
                            consoleArea.append(" | ");
                        }
                        consoleArea.append(resultSet.getString(i));
                    }
                    consoleArea.append("\n");
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}