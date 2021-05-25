package GUI.ShopManagement;

import ApplicationManager.ApplicationManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class ApplicationsAndOrdersWindow extends JFrame {

    private static final String windowName = "Заявки и заказы";
    private static final String backButtonText = "Назад";
    private static final String updateButtonText = "Обновить";
    private static final String suppliesManagementButtonText = "Управление поставками";
    private static final String applicationsManagementButtonText = "Управление заявками";
    private static final String ordersManagementButtonText = "Управление заказами";
    private static final String getUsersApplicationsReportButtonText = "Перечень заявок пользователей";

    private ApplicationManager applicationManager;

    DefaultTableModel tableModel;

    private JPanel navigatePanel;
    private JPanel contentPanel;
    private JPanel managePanel;

    private JButton buttonBack;
    private JButton updateDatabaseButton;

    private JButton suppliesManagementButton;
    private JButton applicationsManagementButton;
    private JButton ordersManagementButton;
    private JButton getUsersApplicationsReportButton;

    private JScrollPane scrollPane;
    private JTable table;

    public ApplicationsAndOrdersWindow(ApplicationManager applicationManager) {
        super(windowName);
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.applicationManager = applicationManager;

        table = new JTable();
        table.setMaximumSize(new Dimension(100, 100));
        table.setDefaultEditor(Object.class, null);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPanel);

        managePanel = new JPanel();
        managePanel.setLayout(new BoxLayout(managePanel, BoxLayout.PAGE_AXIS));

        navigatePanel = new JPanel();
        FlowLayout navigatePanelLayout = (FlowLayout) navigatePanel.getLayout();
        navigatePanelLayout.setAlignment(FlowLayout.LEFT);

        buttonBack = new JButton(backButtonText);
        buttonBack.addActionListener(new BackButtonActionListener());

        updateDatabaseButton = new JButton(updateButtonText);
        updateDatabaseButton.addActionListener(new UpdateActionListener());

        suppliesManagementButton = new JButton(suppliesManagementButtonText);
        suppliesManagementButton.addActionListener(new SuppliesManagementListener());

        applicationsManagementButton = new JButton(applicationsManagementButtonText);
        applicationsManagementButton.addActionListener(new ApplicationsManagementListener());

        ordersManagementButton = new JButton(ordersManagementButtonText);
        ordersManagementButton.addActionListener(new OrdersManagementListener());

        getUsersApplicationsReportButton = new JButton(getUsersApplicationsReportButtonText);
        getUsersApplicationsReportButton.addActionListener(new GetUsersApplicationsReportButtonListener());

        navigatePanel.add(buttonBack);
        navigatePanel.add(updateDatabaseButton);

        JPanel tableManagePanel = new JPanel();
        tableManagePanel.setLayout(new BoxLayout(tableManagePanel, BoxLayout.LINE_AXIS));

        tableManagePanel.add(suppliesManagementButton);
        tableManagePanel.add(applicationsManagementButton);
        tableManagePanel.add(ordersManagementButton);
        tableManagePanel.add(getUsersApplicationsReportButton);

        managePanel.add(tableManagePanel);

        scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        contentPanel.add(navigatePanel, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(managePanel, BorderLayout.SOUTH);
    }

    class BackButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            applicationManager.showShopManagementWindow();
        }
    }

    class UpdateActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateTable();
        }
    }

    class SuppliesManagementListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tableModel = applicationManager.getSupplyList();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            table.setModel(tableModel);
            table.repaint();
        }
    }

    class ApplicationsManagementListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tableModel = applicationManager.getApplicationList();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            table.setModel(tableModel);
            table.repaint();
        }
    }

    class OrdersManagementListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tableModel = applicationManager.getOrdersList();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            table.setModel(tableModel);
            table.repaint();
        }
    }

    class GetUsersApplicationsReportButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tableModel = applicationManager.getApplicationSum();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            table.setModel(tableModel);
            table.repaint();
        }
    }

    public void updateTable() {
        try {
            tableModel = applicationManager.getSupplyList();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        table.setModel(tableModel);
        table.repaint();
    }
}
