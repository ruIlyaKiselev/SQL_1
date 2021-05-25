package GUI.ShopManagement;

import ApplicationManager.ApplicationManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class WarehouseWindow extends JFrame {

    private static final String windowName = "Склад";
    private static final String backButtonText = "Назад";
    private static final String updateButtonText = "Обновить";
    private static final String seeCellButtonText = "Посмотреть содержимое ячейки";
    private static final String productListButtonText = "Перечень товара на складе";
    private static final String brokenListButtonText = "Перечень брака на складе";
    private static final String getInventoryReportButtonText = "Инвентаризационная ведомость";

    private ApplicationManager applicationManager;

    DefaultTableModel tableModel;

    private JPanel navigatePanel;
    private JPanel contentPanel;
    private JPanel managePanel;

    private JButton buttonBack;
    private JButton updateDatabaseButton;

    private JButton seeCellButton;
    private JButton productListButton;
    private JButton brokenListButton;
    private JButton getInventoryReportButton;

    private JScrollPane scrollPane;
    private JTable table;

    public WarehouseWindow(ApplicationManager applicationManager) {
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

        seeCellButton = new JButton(seeCellButtonText);
        seeCellButton.addActionListener(new SeeCellListener());

        productListButton = new JButton(productListButtonText);
        productListButton.addActionListener(new  ProductListListener());

        brokenListButton = new JButton(brokenListButtonText);
        brokenListButton.addActionListener(new BrokenListListener());

        getInventoryReportButton = new JButton(getInventoryReportButtonText);
        getInventoryReportButton.addActionListener(new GetInventoryReportListener());

        navigatePanel.add(buttonBack);
        navigatePanel.add(updateDatabaseButton);

        JPanel tableManagePanel = new JPanel();
        tableManagePanel.setLayout(new BoxLayout(tableManagePanel, BoxLayout.LINE_AXIS));

        tableManagePanel.add(seeCellButton);
        tableManagePanel.add(productListButton);
        tableManagePanel.add(brokenListButton);
        tableManagePanel.add(getInventoryReportButton);

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

    class SeeCellListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new SeeCellOptionPane();
        }
    }

    class ProductListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateTable();
        }
    }

    class BrokenListListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                tableModel = applicationManager.getBrokenList();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            table.setModel(tableModel);
            table.repaint();
        }
    }

    class GetInventoryReportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: ...
        }
    }

    public void updateTable() {
        try {
            tableModel = applicationManager.getWarehouseList();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        table.setModel(tableModel);
        table.repaint();
    }

    public class SeeCellOptionPane {
        JFrame frame;
        String frameText = "Введите номер ячейки (order_id):";

        SeeCellOptionPane() {
            frame = new JFrame();
            String result = JOptionPane.showInputDialog(frame, frameText);
            System.out.println(result);
            if (result != null) {
                try {
                    JOptionPane.showMessageDialog(null, applicationManager.seeCells(Integer.parseInt(result)));
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
