package GUI;

import ApplicationManager.ApplicationManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TableManageWindow extends JFrame {

    private static final String windowName = "Просмотр и редактирование таблиц";
    private static final String backButtonText = "Назад";
    private static final String updateButtonText = "Обновить";
    private static final String addRowButtonText = "Добавить запись";
    private static final String deleteRowButtonText = "Удалить запись";
    private static final String overrideRowButtonText = "Перезаписать запись";
    private static final String saveChangesButtonText = "Сохранить изменения";
    private static final String discardButtonText = "Отменить изменения";
    private static final String firstRowButtonText = "Первая запись";
    private static final String lastRowButtonText = "Последняя запись";
    private static final String prevRowButtonText = "Предыдущая запись";
    private static final String nextRowButtonText = "Следующая запись";

    private ApplicationManager applicationManager;

    private JPanel navigatePanel;
    private JPanel contentPanel;
    private JPanel managePanel;

    private JButton buttonBack;
    private JButton updateDatabaseButton;

    private JButton addRowButton;
    private JButton deleteRowButton;
    private JButton overrideRowButton;
    private JButton saveChangesButton;
    private JButton discardButton;

    private JButton firstRowButton;
    private JButton lastRowButton;
    private JButton nextRowButton;
    private JButton prevRowButton;

    private List<JLabel> tableDataLabels;
    private List<JTextField> tableDataTextFields;

    private JScrollPane scrollPane;

    private JTable table;

    private JComboBox comboBox;

    private int selectedRowIndex = 0;
    private String currentTableName;

    public TableManageWindow(ApplicationManager applicationManager) {
        super(windowName);
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.applicationManager = applicationManager;

        table = new JTable();
        table.setDefaultEditor(Object.class, null);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableMouseClickedListener(e);
            }
        });

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPanel);

        managePanel = new JPanel();
        managePanel.setLayout(new BoxLayout(managePanel, BoxLayout.PAGE_AXIS));

        navigatePanel = new JPanel();
        FlowLayout navigatePanelLayout = (FlowLayout) navigatePanel.getLayout();
        navigatePanelLayout.setAlignment(FlowLayout.LEFT);

        comboBox = new JComboBox();
        comboBox.addItemListener(new ItemChangeListener());
        //AutoCompletion.enable(comboBox);

        tableDataLabels = new ArrayList<>();
        tableDataTextFields = new ArrayList<>();

        buttonBack = new JButton(backButtonText);
        buttonBack.addActionListener(new BackButtonActionListener());

        updateDatabaseButton = new JButton(updateButtonText);
        updateDatabaseButton.addActionListener(new UpdateActionListener());

        addRowButton = new JButton(addRowButtonText);
        addRowButton.addActionListener(new AddRowActionListener());

        deleteRowButton = new JButton(deleteRowButtonText);
        deleteRowButton.addActionListener(new DeleteRowActionListener());

        overrideRowButton = new JButton(overrideRowButtonText);
        overrideRowButton.addActionListener(new OverrideRowActionListener());

        saveChangesButton = new JButton(saveChangesButtonText);
        saveChangesButton.addActionListener(new SaveChangesActionListener());

        discardButton = new JButton(discardButtonText);
        discardButton.addActionListener(new DiscardActionListener());

        firstRowButton = new JButton(firstRowButtonText);
        firstRowButton.addActionListener(new FirstRowActionListener());

        nextRowButton = new JButton(nextRowButtonText);
        nextRowButton.addActionListener(new NextRowActionListener());

        prevRowButton = new JButton(prevRowButtonText);
        prevRowButton.addActionListener(new PrevRowActionListener());

        lastRowButton = new JButton(lastRowButtonText);
        lastRowButton.addActionListener(new LastRowActionListener());

        navigatePanel.add(buttonBack);
        navigatePanel.add(updateDatabaseButton);
        navigatePanel.add(comboBox);

        scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);

        contentPanel.add(navigatePanel, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(managePanel, BorderLayout.SOUTH);
    }

    public void loadDataToTable() {
        comboBox.setModel(applicationManager.getAllTables());
        currentTableName = comboBox.getModel().getElementAt(0).toString();
        updateTableModule();
    }

    class BackButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            applicationManager.showDatabaseManagementWindow();
        }
    }

    class UpdateActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateTableModule();
        }
    }

    class FirstRowActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedRowIndex = 0;
            loadTableDataToFields();
        }
    }

    class NextRowActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selectedRowIndex != table.getRowCount() - 1) {
                selectedRowIndex++;
                loadTableDataToFields();
            }
        }
    }

    class PrevRowActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (selectedRowIndex != 0) {
                selectedRowIndex--;
                loadTableDataToFields();
            }
        }
    }

    class LastRowActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            selectedRowIndex = table.getRowCount() - 1;
            loadTableDataToFields();
        }
    }

    class AddRowActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Vector<String> cols = new Vector<>();
            Vector<String> values = new Vector<>();
            for (int i = 0; i != tableDataTextFields.size(); i++) {
                cols.add(tableDataLabels.get(i).getText());
                values.add(tableDataTextFields.get(i).getText());
            }

            try {
                applicationManager.oracleAddRow(currentTableName, cols, values);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            updateTableModule();
        }
    }

    class DeleteRowActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Vector<String> cols = new Vector<>();
            Vector<String> values = new Vector<>();
            for (int i = 0; i != tableDataTextFields.size(); i++) {
                cols.add(tableDataLabels.get(i).getText());
                values.add(tableDataTextFields.get(i).getText());
            }

            try {
                applicationManager.oracleDeleteRow(currentTableName, cols, values);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            updateTableModule();
        }
    }

    class OverrideRowActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Vector<String> cols = new Vector<>();
            Vector<String> oldValues = new Vector<>();
            Vector<String> newValues = new Vector<>();
            for (int i = 0; i != tableDataTextFields.size(); i++) {
                cols.add(tableDataLabels.get(i).getText());
                newValues.add(tableDataTextFields.get(i).getText());
            }

            for (int i = 0; i != table.getModel().getColumnCount(); i++) {
                oldValues.add(table.getModel().getValueAt(selectedRowIndex, i).toString());
            }

            try {
                applicationManager.oracleOverrideRow(currentTableName, cols, oldValues, newValues);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            updateTableModule();
        }
    }

    class SaveChangesActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                applicationManager.oracleCommit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class DiscardActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                applicationManager.oracleRollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    class ItemChangeListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                Object item = event.getItem();
                currentTableName = item.toString();
                updateTableModule();
                loadTableDataToFields();
                repaint();
            }
        }
    }

    private void tableMouseClickedListener(MouseEvent event) {
        selectedRowIndex = table.getSelectedRow();
        loadTableDataToFields();
    }

    private void loadTableDataToFields() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        for (int i = 0; i != table.getColumnCount(); i++) {
            try {
                tableDataTextFields.get(i).setText(tableModel.getValueAt(selectedRowIndex, i).toString());
            } catch (ArrayIndexOutOfBoundsException e) {
                return;
            } catch (NullPointerException e1) {
                tableDataTextFields.get(i).setText("");
            };
        }

        table.requestFocus();
        table.changeSelection(selectedRowIndex, 0,false, false);
    }

    private void updateTableModule() {
        DefaultTableModel tableModel;
        try {
            tableModel = applicationManager.getTableByName(currentTableName);
            table.setModel(tableModel);

            tableDataLabels.clear();
            tableDataTextFields.clear();
            managePanel.removeAll();
            managePanel.revalidate();
            managePanel.repaint();

            for (int i = 0; i != tableModel.getColumnCount(); i++) {
                tableDataLabels.add(new JLabel(tableModel.getColumnName(i)));
                tableDataTextFields.add(new JTextField(70));

                tableDataTextFields.get(i).setMaximumSize(new Dimension((this.getWidth() - 100), 20));

                JPanel tmpPanel = new JPanel();
                tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.LINE_AXIS));

                tmpPanel.add(tableDataLabels.get(i));
                tmpPanel.add(Box.createHorizontalGlue());
                tmpPanel.add(tableDataTextFields.get(i));

                managePanel.add(tmpPanel);
            }
        } catch (SQLException ignored) {}

        JPanel tableNavigationPanel = new JPanel();
        tableNavigationPanel.setLayout(new BoxLayout(tableNavigationPanel, BoxLayout.LINE_AXIS));

        tableNavigationPanel.add(firstRowButton);
        tableNavigationPanel.add(prevRowButton);
        tableNavigationPanel.add(nextRowButton);
        tableNavigationPanel.add(lastRowButton);

        managePanel.add(tableNavigationPanel);

        JPanel tableManagePanel = new JPanel();
        tableManagePanel.setLayout(new BoxLayout(tableManagePanel, BoxLayout.LINE_AXIS));

        tableManagePanel.add(addRowButton);
        tableManagePanel.add(deleteRowButton);
        tableManagePanel.add(overrideRowButton);
        tableManagePanel.add(saveChangesButton);
        tableManagePanel.add(discardButton);

        managePanel.add(tableManagePanel);

        loadTableDataToFields();
    }
}