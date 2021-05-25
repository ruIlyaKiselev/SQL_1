package GUI.MainMenu;

import ApplicationManager.ApplicationManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopManagementWindow extends JFrame {
    private final int textFieldWidth = 300;
    private final int textFieldHeight = 25;

    private static final String windowName = "Управление магазином";
    private static final String manageDatabaseLabelText = "";
    private static final String cashboxButtonText = "Касса";
    private static final String warehouseButtonText = "Склад";
    private static final String applicationAndOrdersButtonText = "Заявки и заказы";
    private static final String clientsButtonText = "Клиенты";
    private static final String providersAndManufacturersText = "Поставщики и производители";

    private static final String mainMenuButtonText = "Главное меню";

    private JButton helpButton;
    private static final String helpButtonText = "Помощь";
    private static final String helpText = "Это окно управления магазином. Здесь осуществляется вся бизнес логика.\n" +
            "Для работы с кассой нажмите \"Касса\", на кассе можно оплатить товар, вернуть брак и прочее.\n" +
            "Для работы со складом нажмите \"Склад\", на складе можно посмотреть весь товар, брак, заглянуть в ячейки.\n" +
            "Для работы с заявками и заказами нажмите \"Заявки и заказы\", здесь же идет работа с поставками.\n" +
            "Для работы с клиентами нажмите \"Клиенты\", можно посмотреть клиентов и их заказы.\n" +
            "Для работы с поставщиками и производителями нажмите \"Поставщики и производители\", здесь же каталог запчастей.\n";

    private ApplicationManager applicationManager;

    private JButton cashboxButton;
    private JButton warehouseButton;
    private JButton applicationAndOrdersButton;
    private JButton clientsButton;
    private JButton providersAndManufacturersButton;

    private JButton mainMenuButton;

    public ShopManagementWindow(ApplicationManager applicationManager) {
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

        cashboxButton = new JButton();
        cashboxButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        cashboxButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        cashboxButton.setText(cashboxButtonText);
        cashboxButton.addActionListener(new CashboxActionListener());

        warehouseButton = new JButton();
        warehouseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        warehouseButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        warehouseButton.setText(warehouseButtonText);
        warehouseButton.addActionListener(new WarehouseActionListener());

        applicationAndOrdersButton = new JButton();
        applicationAndOrdersButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        applicationAndOrdersButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        applicationAndOrdersButton.setText(applicationAndOrdersButtonText);
        applicationAndOrdersButton.addActionListener(new ApplicationAndOrdersListener());

        clientsButton = new JButton();
        clientsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        clientsButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        clientsButton.setText(clientsButtonText);
        clientsButton.addActionListener(new ClientsListener());

        providersAndManufacturersButton = new JButton();
        providersAndManufacturersButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        providersAndManufacturersButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        providersAndManufacturersButton.setText(providersAndManufacturersText);
        providersAndManufacturersButton.addActionListener(new ProvidersAndManufacturersListener());

        mainMenuButton = new JButton();
        mainMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainMenuButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        mainMenuButton.setText(mainMenuButtonText);
        mainMenuButton.addActionListener(new MainMenuActionListener());

        helpButton = new JButton();
        helpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        helpButton.setMaximumSize(new Dimension(textFieldWidth, textFieldHeight));
        helpButton.setText(helpButtonText);
        helpButton.addActionListener(new HelpListener());

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        this.getContentPane().add(manageDatabaseLabel);
        this.getContentPane().add(cashboxButton);
        this.getContentPane().add(warehouseButton);
        this.getContentPane().add(applicationAndOrdersButton);
        this.getContentPane().add(clientsButton);
        this.getContentPane().add(providersAndManufacturersButton);

        this.getContentPane().add(new JLabel(" "));
        this.getContentPane().add(mainMenuButton);
        this.getContentPane().add(new JLabel(" "));
        this.getContentPane().add(helpButton);
    }

    class CashboxActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showCashboxWindow();
        }
    }

    class WarehouseActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showWarehouseWindow();
        }
    }

    class ApplicationAndOrdersListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showApplicationsAndOrdersWindow();
        }
    }

    class ClientsListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showClientsWindow();
        }
    }

    class ProvidersAndManufacturersListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showProvidersAndManufacturersWindow();
        }
    }

    class MainMenuActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            applicationManager.showMainWindow();
        }
    }

    class HelpListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, helpText);
        }
    }
}
