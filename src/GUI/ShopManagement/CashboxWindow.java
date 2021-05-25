package GUI.ShopManagement;

import ApplicationManager.ApplicationManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class CashboxWindow extends JFrame {

    private static final String windowName = "Касса";
    private static final String backButtonText = "Назад";
    private static final String updateButtonText = "Обновить";
    private static final String payOrderButtonText = "Оплатить заказ";
    private static final String undoOrderButtonText = "Отказаться от заказа";
    private static final String returnBrokenButtonText = "Вернуть брак";
    private static final String getFinancialReportButtonText = "Получить финансовый отчет";

    private ApplicationManager applicationManager;

    DefaultTableModel tableModel;

    private JPanel navigatePanel;
    private JPanel contentPanel;
    private JPanel managePanel;

    private JButton buttonBack;
    private JButton updateDatabaseButton;

    private JButton payOrderButton;
    private JButton undoOrderButton;
    private JButton returnBrokenButton;
    private JButton getFinancialReportButton;

    private JScrollPane scrollPane;
    private JTable table;

    public CashboxWindow(ApplicationManager applicationManager) {
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

        payOrderButton = new JButton(payOrderButtonText);
        payOrderButton.addActionListener(new PayOrderListener());

        undoOrderButton = new JButton(undoOrderButtonText);
        undoOrderButton.addActionListener(new UndoOrderListener());

        returnBrokenButton = new JButton(returnBrokenButtonText);
        returnBrokenButton.addActionListener(new ReturnBrokenListener());

        getFinancialReportButton = new JButton(getFinancialReportButtonText);
        getFinancialReportButton.addActionListener(new GetFinancialReportButtonListener());

        navigatePanel.add(buttonBack);
        navigatePanel.add(updateDatabaseButton);

        JPanel tableManagePanel = new JPanel();
        tableManagePanel.setLayout(new BoxLayout(tableManagePanel, BoxLayout.LINE_AXIS));

        tableManagePanel.add(payOrderButton);
        tableManagePanel.add(undoOrderButton);
        tableManagePanel.add(returnBrokenButton);
        tableManagePanel.add(getFinancialReportButton);

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

    class PayOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new PayOrderOptionPane();
        }
    }

    class UndoOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new UndoOrderOptionPane();
        }
    }

    class ReturnBrokenListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ReturnBrokenOptionPane();
        }
    }

    class GetFinancialReportButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO: ...
        }
    }

    public void updateTable() {
        try {
            tableModel = applicationManager.getCashboxList();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        table.setModel(tableModel);
        table.repaint();
    }

    public class PayOrderOptionPane {
        JFrame frame;
        String frameText = "Введите номер заказа (order_id):";

        PayOrderOptionPane() {
            frame = new JFrame();
            String result = JOptionPane.showInputDialog(frame, frameText);
            applicationManager.payOrderCahsbox(Integer.parseInt(result));
            JOptionPane.showMessageDialog(null, "Заказ № " + result + " оплачен.");
        }
    }

    public class UndoOrderOptionPane {
        JFrame frame;
        String frameText = "Введите номер заказа (order_id):";

        UndoOrderOptionPane() {
            frame = new JFrame();
            String result = JOptionPane.showInputDialog(frame, frameText);
            applicationManager.undoOrderCahsbox(Integer.parseInt(result));
            JOptionPane.showMessageDialog(null, "Заказ № " + result + " отменен.");
        }
    }

    public class ReturnBrokenOptionPane {
        JFrame frame;
        String frameText = "Введите номер заказа (order_id):";

        ReturnBrokenOptionPane() {
            frame = new JFrame();
            String result = JOptionPane.showInputDialog(frame, frameText);
            applicationManager.brokenOrderCahsbox(Integer.parseInt(result));
            JOptionPane.showMessageDialog(null, "Бракованный заказ № " + result + " возвращен.");
        }
    }
}