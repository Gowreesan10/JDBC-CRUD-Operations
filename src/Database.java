import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database extends javax.swing.JFrame {

    static Connection connection = null;
    String table;
    String selectedDnumber = null, selectedDlocation = null;

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel row1;
    private javax.swing.JLabel row2;
    private javax.swing.JLabel row3;
    private javax.swing.JLabel row4;

    public Database() {
        initComponents();
        jPanel1.setVisible(false);
    }

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Database.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Database().setVisible(true));

        establishDatabaseConnection();
    }

    static void establishDatabaseConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/department";
            String user = "root";
            String password = "";

            connection = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "DataBase Successfully Connected ", "", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, exp.getMessage(), "DataBase Connection Failure", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        row1 = new javax.swing.JLabel();
        row2 = new javax.swing.JLabel();
        row3 = new javax.swing.JLabel();
        row4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DEPARTMENT DATABASE");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Select Table:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Department", "Dept_locations"}));
        jComboBox1.addActionListener(this::selectTable);

        row1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        row1.setText("row1");

        row2.setText("row2");

        row3.setText("row3");

        row4.setText("row4");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("UPDATE");
        jButton1.addActionListener(this::UpdateRecord);

        jButton3.setText("DELETE");
        jButton3.addActionListener(this::DeleteData);

        jButton4.setText("INSERT");
        jButton4.addActionListener(this::insertData);

        jButton2.setText("Search By Dnumber");
        jButton2.addActionListener(this::SearchData);

        jButton5.setText("Clear");
        jButton5.addActionListener(this::ClearSearch);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(row3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                                        .addComponent(row2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                                        .addComponent(row1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                                        .addComponent(row4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                                                .addGap(55, 55, 55)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGap(73, 73, 73)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(74, 74, 74)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(row1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(row2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(row3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField4)
                                        .addComponent(row4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButton1)
                                                .addComponent(jButton3))
                                        .addComponent(jButton4))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void selectTable(java.awt.event.ActionEvent evt) {
        table = jComboBox1.getSelectedItem().toString();
        if (table.equals("Department")) {
            jButton2.setText("Search By Dnumber");
        } else {
            jButton2.setText("Search By Dnumber and Dlocation");
        }
        row3.setVisible(true);
        row4.setVisible(true);

        jTextField3.setVisible(true);
        jTextField4.setVisible(true);
        clearTextField();
        setDataInTable();
    }

    private void ClearSearch(java.awt.event.ActionEvent evt) {
        clearTextField();
        selectedDnumber = null;
        selectedDlocation = null;
    }

    private void insertData(java.awt.event.ActionEvent evt) {
        String query;
        try {

            if (table.equals("Department")) {
                String Dname = jTextField1.getText();
                int Dnumber = Integer.parseInt(jTextField2.getText());
                int Mgr_ssn = Integer.parseInt(jTextField3.getText());
                String Mgr_start_date = jTextField4.getText();

                query = "INSERT INTO " + table + " VALUES ('" + Dname + "'," + Dnumber + "," + Mgr_ssn + ",'" + Mgr_start_date + "')";

            } else {
                int Dnumber = Integer.parseInt(jTextField1.getText());
                String Dlocation = jTextField2.getText();

                query = "INSERT INTO " + table + " VALUES (" + Dnumber + ",'" + Dlocation + "')";
            }

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            setDataInTable();
            JOptionPane.showMessageDialog(null, "Record Sucessfully Added", "", JOptionPane.INFORMATION_MESSAGE);
            statement.close();
            clearTextField();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception, "", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void DeleteData(java.awt.event.ActionEvent evt) {
        String query = null;

        try {
            if (selectedDlocation == null && selectedDnumber == null) {
                throw new Exception("Please Select Record Before Updating");
            }

            if (table.equals("Department")) {
                query = "DELETE FROM " + table + " WHERE Dnumber=" + selectedDnumber;
            } else {
                query = "DELETE FROM " + table + " WHERE (Dnumber=" + selectedDnumber + ") AND (Dlocation ='" + selectedDlocation + "')";
            }

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            setDataInTable();
            JOptionPane.showMessageDialog(null, "Record Sucessfully Deleted", "", JOptionPane.INFORMATION_MESSAGE);
            clearTextField();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception, "", JOptionPane.ERROR_MESSAGE);
        }
        selectedDnumber = null;
        selectedDlocation = null;
    }

    private void SearchData(java.awt.event.ActionEvent evt) {

        String query = null;

        switch (table) {
            case "Department" -> {
                selectedDnumber = jTextField2.getText();
                if (!selectedDnumber.isEmpty()) {
                    query = "SELECT * FROM " + table + " WHERE Dnumber = " + selectedDnumber;
                }
            }
            case "Dept_locations" -> {
                selectedDnumber = jTextField1.getText();
                selectedDlocation = jTextField2.getText();
                if (!selectedDnumber.isEmpty() && !selectedDlocation.isEmpty()) {
                    query = "SELECT * FROM " + table + " WHERE (Dnumber = " + selectedDnumber + ") AND ( Dlocation = '" + selectedDlocation + "')";
                }
            }
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet rsQuery = statement.executeQuery(query);

            if (rsQuery.isBeforeFirst()) {
                while (rsQuery.next()) {

                    if (table.equals("Department")) {
                        String Dname = rsQuery.getString("Dname");
                        int Mgr_ssn = rsQuery.getInt("Mgr_ssn");
                        Date Mgr_start_date = rsQuery.getDate("Mgr_start_date");

                        jTextField1.setText(Dname);
                        jTextField3.setText(Mgr_ssn + "");
                        jTextField4.setText(Mgr_start_date + "");
                    }
                    JOptionPane.showMessageDialog(null, "Record Successfully Selected", "", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Record Not found", "", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception, "", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void UpdateRecord(java.awt.event.ActionEvent evt) {
        String query;
        try {
            if (selectedDlocation == null && selectedDnumber == null) {
                throw new Exception("Please Select Record Before Updating");
            }
            if (table.equals("Department")) {
                String Dname = jTextField1.getText();
                int Mgr_ssn = Integer.parseInt(jTextField3.getText());
                String Mgr_start_date = jTextField4.getText();

                query = "UPDATE " + table + " SET Dname='" + Dname + "', Mgr_ssn='" + Mgr_ssn + "'," +
                        " Mgr_start_date='" + Mgr_start_date + "' WHERE Dnumber=" + selectedDnumber;
            } else {
                String Dnumber = jTextField1.getText();
                String Dlocation = jTextField2.getText();

                query = "UPDATE " + table + " SET Dnumber = " + Dnumber + ", Dlocation = '" + Dlocation +
                        "' WHERE (Dnumber = " + selectedDnumber + ") AND ( Dlocation = '" + selectedDlocation + "')";
            }

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            setDataInTable();
            JOptionPane.showMessageDialog(null, "Record Successfully Updated", "", JOptionPane.INFORMATION_MESSAGE);
            clearTextField();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception, "", JOptionPane.ERROR_MESSAGE);
        }
        selectedDnumber = null;
        selectedDlocation = null;
    }

    private void setDataInTable() {
        DefaultTableModel dataModel = generateDataModel();
        jTable1.setModel(dataModel);
        jPanel1.setVisible(true);
    }

    private DefaultTableModel generateDataModel() {

        try {
            String retSql = "select * from " + table;
            Statement statement = connection.createStatement();
            ResultSet rsQuery = statement.executeQuery(retSql);

            String[] department = {"Dname", "Dnumber", "Mgr_ssn", "Mgr_start_date"};
            String[] departmentLocation = {"Dnumber", "Dlocation"};
            String[] columnsNames = null;

            DefaultTableModel model = null;

            if (table.equals("Department")) {
                columnsNames = department;
                model = new DefaultTableModel(columnsNames, 0);

                row3.setText(columnsNames[2]);
                row4.setText(columnsNames[3]);

                while (rsQuery.next()) {
                    String Dname = rsQuery.getString("Dname");
                    int Dnumber = rsQuery.getInt("Dnumber");
                    int Mgr_ssn = rsQuery.getInt("Mgr_ssn");
                    Date Mgr_start_date = rsQuery.getDate("Mgr_start_date");
                    Object[] rowData = new Object[]{Dname, Dnumber + "", Mgr_ssn + "", Mgr_start_date + ""};
                    model.addRow(rowData);
                }
            } else {
                row3.setVisible(false);
                row4.setVisible(false);

                jTextField3.setVisible(false);
                jTextField4.setVisible(false);
                columnsNames = departmentLocation;
                model = new DefaultTableModel(columnsNames, 0);

                while (rsQuery.next()) {
                    int Dnumber = rsQuery.getInt("Dnumber");
                    String Dlocation = rsQuery.getString("Dlocation");
                    Object[] rowData = new Object[]{Dnumber + "", Dlocation};
                    model.addRow(rowData);
                }
            }

            statement.close();

            row1.setText(columnsNames[0]);
            row2.setText(columnsNames[1]);

            return model;
        } catch (Exception exp) {
            JOptionPane.showMessageDialog(null, exp, "", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void clearTextField() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }

}
