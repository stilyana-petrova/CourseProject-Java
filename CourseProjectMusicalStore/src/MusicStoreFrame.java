import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MusicStoreFrame extends JFrame {

    Connection conn = null;
    PreparedStatement state = null;
    ResultSet result = null;

    JTabbedPane tabbedPane = new JTabbedPane();

    // Product Tab Components
    JPanel productPanel = new JPanel(new GridLayout(3, 1));
    JPanel productUpPanel = new JPanel(new GridLayout(4, 2));
    JPanel productMidPanel = new JPanel();
    JPanel productDownPanel = new JPanel();

    JLabel productNameL = new JLabel("Product Name:");
    JLabel productPriceL = new JLabel("Price:");
    JLabel productImageL = new JLabel("Image URL:");
    JLabel productQuantityL = new JLabel("Quantity:");

    JTextField productNameTF = new JTextField();
    JTextField productPriceTF = new JTextField();
    JTextField productImageTF = new JTextField();
    JTextField productQuantityTF = new JTextField();

    JButton addProductButton = new JButton("Add Product");
    JButton deleteProductButton = new JButton("Delete Product");
    JButton editProductButton = new JButton("Edit Product");
    JButton refreshProductButton = new JButton("Refresh");

    JTable productTable = new JTable();
    JScrollPane productScroll = new JScrollPane(productTable);

    // Users Tab Components
    JPanel usersPanel = new JPanel(new GridLayout(3, 1));
    JPanel usersUpPanel = new JPanel(new GridLayout(3, 2));
    JPanel usersMidPanel = new JPanel();
    JPanel usersDownPanel = new JPanel();

    JLabel userFNameL = new JLabel("First Name:");
    JLabel userLNameL = new JLabel("Last Name:");
    JLabel userGenderL = new JLabel("Gender:");

    JTextField userFNameTF = new JTextField();
    JTextField userLNameTF = new JTextField();
    String[] genders = {"male", "female"};
    JComboBox<String> userGenderCombo = new JComboBox<>(genders);

    JButton addUserButton = new JButton("Add User");
    JButton deleteUserButton = new JButton("Delete User");
    JButton editUserButton = new JButton("Edit User");
    JButton refreshUserButton = new JButton("Refresh");

    JTable usersTable = new JTable();
    JScrollPane usersScroll = new JScrollPane(usersTable);

    // Orders Tab Components
    JPanel ordersPanel = new JPanel(new GridLayout(3, 1));
    JPanel ordersUpPanel = new JPanel(new GridLayout(2, 2));
    JPanel ordersMidPanel = new JPanel();
    JPanel ordersDownPanel = new JPanel();

    JLabel selectUserL = new JLabel("Select User:");
    JComboBox<String> userCombo = new JComboBox<>();
    JLabel selectProductsL = new JLabel("Select Products:");
    JTable productsTable = new JTable();
    JScrollPane productsScroll = new JScrollPane(productsTable);

    JButton createOrderButton = new JButton("Create Order");
    JButton refreshOrdersButton = new JButton("Refresh");

    // All Orders Tab Components
    JPanel allOrdersPanel = new JPanel(new GridLayout(1, 1));
    JTable allOrdersTable = new JTable();
    JScrollPane allOrdersScroll = new JScrollPane(allOrdersTable);

    public MusicStoreFrame() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1, 1));

        // Setup Product Tab
        setupProductPanel();
        tabbedPane.addTab("Products", productPanel);

        // Setup Users Tab
        setupUsersPanel();
        tabbedPane.addTab("Users", usersPanel);

        // Setup Orders Tab
        setupOrdersPanel();
        tabbedPane.addTab("Orders", ordersPanel);

        // Setup All Orders Tab
        setupAllOrdersPanel();
        tabbedPane.addTab("All Orders", allOrdersPanel);

        // Add TabbedPane to the frame
        this.add(tabbedPane);

        // Add Action Listeners
        addProductButton.addActionListener(new AddProductAction());
        deleteProductButton.addActionListener(new DeleteProductAction());
        editProductButton.addActionListener(new EditProductAction());
        refreshProductButton.addActionListener(new RefreshProductAction());

        addUserButton.addActionListener(new AddUserAction());
        deleteUserButton.addActionListener(new DeleteUserAction());
        editUserButton.addActionListener(new EditUserAction());
        refreshUserButton.addActionListener(new RefreshUserAction());

        createOrderButton.addActionListener(new CreateOrderAction());
        refreshOrdersButton.addActionListener(new RefreshOrdersAction());

        // Refresh Tables
        refreshProductTable();
        refreshUsersTable();
        refreshUserCombo();
        refreshProductsTable();
        refreshAllOrdersTable();

        this.setVisible(true);
    }

    private void setupProductPanel() {
        // Upper Panel (Input Fields)
        productUpPanel.add(productNameL);
        productUpPanel.add(productNameTF);
        productUpPanel.add(productPriceL);
        productUpPanel.add(productPriceTF);
        productUpPanel.add(productImageL);
        productUpPanel.add(productImageTF);
        productUpPanel.add(productQuantityL);
        productUpPanel.add(productQuantityTF);

        // Middle Panel (Buttons)
        productMidPanel.add(addProductButton);
        productMidPanel.add(deleteProductButton);
        productMidPanel.add(editProductButton);
        productMidPanel.add(refreshProductButton);

        // Lower Panel (Table)
        productDownPanel.add(productScroll);
        productScroll.setPreferredSize(new Dimension(750, 200));

        // Add sub-panels to the main product panel
        productPanel.add(productUpPanel);
        productPanel.add(productMidPanel);
        productPanel.add(productDownPanel);
    }

    private void setupUsersPanel() {
        // Upper Panel (Input Fields)
        usersUpPanel.add(userFNameL);
        usersUpPanel.add(userFNameTF);
        usersUpPanel.add(userLNameL);
        usersUpPanel.add(userLNameTF);
        usersUpPanel.add(userGenderL);
        usersUpPanel.add(userGenderCombo);

        // Middle Panel (Buttons)
        usersMidPanel.add(addUserButton);
        usersMidPanel.add(deleteUserButton);
        usersMidPanel.add(editUserButton);
        usersMidPanel.add(refreshUserButton);

        // Lower Panel (Table)
        usersDownPanel.add(usersScroll);
        usersScroll.setPreferredSize(new Dimension(750, 200));

        // Add sub-panels to the main users panel
        usersPanel.add(usersUpPanel);
        usersPanel.add(usersMidPanel);
        usersPanel.add(usersDownPanel);
    }

    private void setupOrdersPanel() {
        // Upper Panel (User Selection)
        ordersUpPanel.add(selectUserL);
        ordersUpPanel.add(userCombo);

        // Middle Panel (Product Selection)
        ordersMidPanel.add(selectProductsL);
        ordersMidPanel.add(productsScroll);
        productsScroll.setPreferredSize(new Dimension(750, 200));

        // Lower Panel (Buttons)
        ordersDownPanel.add(createOrderButton);
        ordersDownPanel.add(refreshOrdersButton);

        // Add sub-panels to the main orders panel
        ordersPanel.add(ordersUpPanel);
        ordersPanel.add(ordersMidPanel);
        ordersPanel.add(ordersDownPanel);
    }

    private void setupAllOrdersPanel() {
        allOrdersPanel.add(allOrdersScroll);
        allOrdersScroll.setPreferredSize(new Dimension(750, 400));
        refreshAllOrdersTable();
    }

    private void refreshProductTable() {
        conn = DBConnection.GetConnection();
        try {
            state = conn.prepareStatement("SELECT * FROM product");
            result = state.executeQuery();
            try {
				productTable.setModel(new MyModel(result));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void refreshUsersTable() {
        conn = DBConnection.GetConnection();
        try {
            state = conn.prepareStatement("SELECT * FROM users");
            result = state.executeQuery();
            try {
				usersTable.setModel(new MyModel(result));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void refreshUserCombo() {
        userCombo.removeAllItems();
        conn = DBConnection.GetConnection();
        String sql = "SELECT id, fname, lname FROM users";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            while (result.next()) {
                String user = result.getInt("id") + ". " + result.getString("fname") + " " + result.getString("lname");
                userCombo.addItem(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void refreshProductsTable() {
        conn = DBConnection.GetConnection();
        try {
            state = conn.prepareStatement("SELECT * FROM product");
            result = state.executeQuery();
            try {
				productsTable.setModel(new MyModel(result));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void refreshAllOrdersTable() {
        conn = DBConnection.GetConnection();
        String sql = "SELECT o.id AS order_id, u.fname, u.lname, o.orderdate, o.totalprice, " +
                     "STRING_AGG(p.name, ', ') AS products " +
                     "FROM orders o " +
                     "JOIN users u ON o.userid = u.id " +
                     "JOIN order_products op ON o.id = op.order_id " +
                     "JOIN product p ON op.product_id = p.id " +
                     "GROUP BY o.id, u.fname, u.lname, o.orderdate, o.totalprice";
        try {
            state = conn.prepareStatement(sql);
            result = state.executeQuery();
            try {
				allOrdersTable.setModel(new MyModel(result));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearProductForm() {
        productNameTF.setText("");
        productPriceTF.setText("");
        productImageTF.setText("");
        productQuantityTF.setText("");
    }

    private void clearUserForm() {
        userFNameTF.setText("");
        userLNameTF.setText("");
        userGenderCombo.setSelectedIndex(0);
    }

    class AddProductAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.GetConnection();
            String sql = "INSERT INTO product (name, price, image, quantity) VALUES (?, ?, ?, ?)";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, productNameTF.getText());
                state.setDouble(2, Double.parseDouble(productPriceTF.getText()));
                state.setString(3, productImageTF.getText());
                state.setInt(4, Integer.parseInt(productQuantityTF.getText()));
                state.execute();
                refreshProductTable();
                clearProductForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    class DeleteProductAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow == -1) return;
            int productId = Integer.parseInt(productTable.getValueAt(selectedRow, 0).toString());

            conn = DBConnection.GetConnection();
            String sql = "DELETE FROM product WHERE id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, productId);
                state.execute();
                refreshProductTable();
                clearProductForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    class EditProductAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = productTable.getSelectedRow();
            if (selectedRow == -1) return;
            int productId = Integer.parseInt(productTable.getValueAt(selectedRow, 0).toString());

            conn = DBConnection.GetConnection();
            String sql = "UPDATE product SET name=?, price=?, image=?, quantity=? WHERE id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, productNameTF.getText());
                state.setDouble(2, Double.parseDouble(productPriceTF.getText()));
                state.setString(3, productImageTF.getText());
                state.setInt(4, Integer.parseInt(productQuantityTF.getText()));
                state.setInt(5, productId);
                state.execute();
                refreshProductTable();
                clearProductForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    class RefreshProductAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            refreshProductTable();
            clearProductForm();
        }
    }

    class AddUserAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            conn = DBConnection.GetConnection();
            String sql = "INSERT INTO users (fname, lname, gender) VALUES (?, ?, ?)";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, userFNameTF.getText());
                state.setString(2, userLNameTF.getText());
                state.setString(3, userGenderCombo.getSelectedItem().toString());
                state.execute();
                refreshUsersTable();
                clearUserForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    class DeleteUserAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = usersTable.getSelectedRow();
            if (selectedRow == -1) return;
            int userId = Integer.parseInt(usersTable.getValueAt(selectedRow, 0).toString());

            conn = DBConnection.GetConnection();
            String sql = "DELETE FROM users WHERE id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setInt(1, userId);
                state.execute();
                refreshUsersTable();
                clearUserForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    class EditUserAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedRow = usersTable.getSelectedRow();
            if (selectedRow == -1) return;
            int userId = Integer.parseInt(usersTable.getValueAt(selectedRow, 0).toString());

            conn = DBConnection.GetConnection();
            String sql = "UPDATE users SET fname=?, lname=?, gender=? WHERE id=?";
            try {
                state = conn.prepareStatement(sql);
                state.setString(1, userFNameTF.getText());
                state.setString(2, userLNameTF.getText());
                state.setString(3, userGenderCombo.getSelectedItem().toString());
                state.setInt(4, userId);
                state.execute();
                refreshUsersTable();
                clearUserForm();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    class RefreshUserAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            refreshUsersTable();
            clearUserForm();
        }
    }

    class CreateOrderAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get selected user
            String selectedUser = userCombo.getSelectedItem().toString();
            int userId = Integer.parseInt(selectedUser.split("\\.")[0]);

            // Get selected products
            int[] selectedRows = productsTable.getSelectedRows();
            if (selectedRows.length == 0) {
                System.out.println("No products selected!");
                return;
            }

            // Create order
            conn = DBConnection.GetConnection();
            String sql = "INSERT INTO orders (userid, totalprice) VALUES (?, ?)";
            try {
                // Calculate total price
                double totalPrice = 0;
                for (int row : selectedRows) {
                    double price = Double.parseDouble(productsTable.getValueAt(row, 2).toString());
                    int quantity = Integer.parseInt(productsTable.getValueAt(row, 4).toString());
                    totalPrice += price * quantity;
                }

                // Insert order
                state = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                state.setInt(1, userId);
                state.setDouble(2, totalPrice);
                state.executeUpdate();

                // Get the generated order ID
                ResultSet generatedKeys = state.getGeneratedKeys();
                int orderId = -1;
                if (generatedKeys.next()) {
                    orderId = generatedKeys.getInt(1);
                }

                // Insert order products
                if (orderId != -1) {
                    String sqlOrderProducts = "INSERT INTO order_products (order_id, product_id, quantity) VALUES (?, ?, ?)";
                    for (int row : selectedRows) {
                        int productId = Integer.parseInt(productsTable.getValueAt(row, 0).toString());
                        int quantity = Integer.parseInt(productsTable.getValueAt(row, 4).toString());

                        state = conn.prepareStatement(sqlOrderProducts);
                        state.setInt(1, orderId);
                        state.setInt(2, productId);
                        state.setInt(3, quantity);
                        state.execute();
                    }
                }

                System.out.println("Order created successfully!");
                refreshProductsTable();
                refreshAllOrdersTable(); 
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    class RefreshOrdersAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            refreshUserCombo();
            refreshProductsTable();
        }
    }


}