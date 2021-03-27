package GUI;

import ApplicationManager.ApplicationManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

public class TableManageWindow extends JFrame {

    private final int textFieldWidth = 200;
    private final int textFieldHeight = 20;

    private ApplicationManager applicationManager;

    private JPanel contentPane;
    private JPanel managePanel;

    private JButton buttonBack;
    private JButton addRowButton;
    private JButton saveChangesButton;
    private JButton updateDatabaseButton;
    private JButton discardButton;
    private JButton deleteButton;

    private ArrayList<JLabel> tableDataLabels;
    private ArrayList<JTextField> tableDataTextFields;

    private JScrollPane scrollPane;

    private JTable table;

    public TableManageWindow(ApplicationManager applicationManager) {
        super("Table management");
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.applicationManager = applicationManager;

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        managePanel = new JPanel();
        managePanel.setLayout(new BoxLayout(managePanel, BoxLayout.PAGE_AXIS));

        JPanel navigatePanel = new JPanel();
        FlowLayout navigatePanelLayout = (FlowLayout) navigatePanel.getLayout();
        navigatePanelLayout.setAlignment(FlowLayout.LEFT);

        tableDataLabels = new ArrayList<>();
        tableDataTextFields = new ArrayList<>();

        buttonBack = new JButton("Back");
        buttonBack.addActionListener(new BackButtonActionListener());

        addRowButton = new JButton("Add row to table");
        saveChangesButton = new JButton("Save changes");
        updateDatabaseButton = new JButton("Update database");
        discardButton = new JButton("Discard changes");
        deleteButton = new JButton("Delete");

        navigatePanel.add(buttonBack);

        scrollPane = new JScrollPane();
        table = new JTable();
        scrollPane.setViewportView(table);

        contentPane.add(navigatePanel, BorderLayout.NORTH);
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(managePanel, BorderLayout.SOUTH);
    }

    public void loadDataToTable() {
        try {
            DefaultTableModel tableModel = applicationManager.getTableByName();
            table.setModel(tableModel);

            for (int i = 0; i != tableModel.getColumnCount(); i++) {
                System.out.println(tableModel.getColumnName(i));
                tableDataLabels.add(new JLabel(tableModel.getColumnName(i)));
                tableDataTextFields.add(new JTextField(70));

                tableDataTextFields.get(i).setMaximumSize(new Dimension(70, 20));

                JPanel tmpPanel = new JPanel();
                tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.LINE_AXIS));

                tmpPanel.add(tableDataLabels.get(i));
                tmpPanel.add(Box.createHorizontalGlue());
                tmpPanel.add(tableDataTextFields.get(i));

                managePanel.add(tmpPanel);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableMouseClickedListener(e);
            }
        });

        JPanel tmpPanel = new JPanel();
        tmpPanel.setLayout(new BoxLayout(tmpPanel, BoxLayout.LINE_AXIS));

        tmpPanel.add(addRowButton);
        tmpPanel.add(saveChangesButton);
        tmpPanel.add(updateDatabaseButton);
        tmpPanel.add(discardButton);
        tmpPanel.add(deleteButton);

        managePanel.add(tmpPanel);
    }

    class BackButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showMainWindow();
        }
    }

    private void tableMouseClickedListener(MouseEvent event) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        int selectedRowIndex = table.getSelectedRow();

        for (int i = 0; i != table.getColumnCount(); i++) {
            try {
                tableDataTextFields.get(i).setText(tableModel.getValueAt(selectedRowIndex, i).toString());
            } catch (NullPointerException e) {
                tableDataTextFields.get(i).setText("NULL");
            }
        }
    }
}


