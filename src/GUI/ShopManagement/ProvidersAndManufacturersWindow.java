package GUI.ShopManagement;

import ApplicationManager.ApplicationManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class ProvidersAndManufacturersWindow extends JFrame {

    private static final String windowName = "Поставщики и производители";
    private static final String backButtonText = "Назад";
    private static final String updateButtonText = "Обновить";
    private static final String providersManagementButtonText = "Управление поставщиками";
    private static final String manufacturersManagementButtonText = "Управление производителями";
    private static final String catalogManagementButtonText = "Управление каталогом товаров";

    private ApplicationManager applicationManager;

    DefaultTableModel tableModel;

    private JPanel navigatePanel;
    private JPanel contentPanel;
    private JPanel managePanel;

    private JButton buttonBack;
    private JButton updateDatabaseButton;

    private JButton providersManagementButton;
    private JButton manufacturersManagementButton;
    private JButton catalogManagementButton;

    private JScrollPane scrollPane;
    private JTable table;

    public ProvidersAndManufacturersWindow(ApplicationManager applicationManager) {
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

        providersManagementButton = new JButton(providersManagementButtonText);
        providersManagementButton.addActionListener(new ProvidersManagementListener());

        manufacturersManagementButton = new JButton(manufacturersManagementButtonText);
        manufacturersManagementButton.addActionListener(new ManufacturersManagementListener());

        catalogManagementButton = new JButton(catalogManagementButtonText);
        catalogManagementButton.addActionListener(new CatalogManagementListener());

        navigatePanel.add(buttonBack);
        navigatePanel.add(updateDatabaseButton);

        JPanel tableManagePanel = new JPanel();
        tableManagePanel.setLayout(new BoxLayout(tableManagePanel, BoxLayout.LINE_AXIS));

        tableManagePanel.add(providersManagementButton);
        tableManagePanel.add(manufacturersManagementButton);
        tableManagePanel.add(catalogManagementButton);

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

    class ProvidersManagementListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tableModel = applicationManager.getProvidersList();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            table.setModel(tableModel);
            table.repaint();
        }
    }

    class ManufacturersManagementListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tableModel = applicationManager.getManufacturersList();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            table.setModel(tableModel);
            table.repaint();
        }
    }

    class CatalogManagementListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tableModel = applicationManager.getSparePartsList();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            table.setModel(tableModel);
            table.repaint();
        }
    }

    public void updateTable() {
        try {
            tableModel = applicationManager.getSparePartsList();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        table.setModel(tableModel);
        table.repaint();
    }
}
