/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.monash.fit5042.govtservices.ui;

import com.monash.fit5042.govtservice.entities.GovtService;
import com.monash.fit5042.govtservice.entities.GovtUser;
import com.monash.fit5042.govtservice.entities.ServiceType;
import com.monash.fit5042.govtservices.GovernmentServiceListener;
import com.monash.fit5042.govtservices.UserServiceListener;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.table.DefaultTableModel;

public class GovernmentServicesGUIForm extends javax.swing.JFrame implements GuiEventListener {

    private static final String[] TABLE_COLUMNS = {"Id", "Service Name"};
    
    private static final String[] TABLE_USER_COLUMNS = {"Id", "Name", "Type"};

    private static final String[] TABLE_SERVICE_TYPE_COLUMNS = {"Id", "Service Type"};


    GovernmentServiceListener listener;
    UserServiceListener userServiceListner;

    public GovernmentServicesGUIForm(GovernmentServiceListener listener, 
            UserServiceListener userServiceListner) {
        initComponents();
        this.listener = listener;
        this.userServiceListner = userServiceListner;
        setupGovtServiceTableProperties();
        setupGovtUserTableProperties();
        setupServiceTypeProperties();
        loadAllServicesIntoTable();
        loadAllUsersIntoTable();
        loadAllServiceTypesIntoTable();
    }

    private void setupGovtServiceTableProperties() {
        tbl_services_list.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                TABLE_COLUMNS
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tbl_services_list.setSelectionMode(SINGLE_SELECTION);
    }
    
    
    private void setupGovtUserTableProperties() {
        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                TABLE_COLUMNS
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class, 
                java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblUsers.setSelectionMode(SINGLE_SELECTION);
    }
    
    private void setupServiceTypeProperties() {
        tblServiceTypes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                TABLE_SERVICE_TYPE_COLUMNS
        ) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, 
                java.lang.String.class, java.lang.String.class, 
                java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblServiceTypes.setSelectionMode(SINGLE_SELECTION);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblWelcomeTitle = new javax.swing.JLabel();
        tabHolder = new javax.swing.JTabbedPane();
        View = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_services_list = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtSearchQuery = new javax.swing.JTextField();
        btnAddService = new javax.swing.JButton();
        viewAll = new javax.swing.JButton();
        btnStartService = new javax.swing.JButton();
        holder = new javax.swing.JPanel();
        btnUserAdd = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        btnUserEdit = new javax.swing.JButton();
        btnUserDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblServiceTypes = new javax.swing.JTable();
        btnAddServiceType = new javax.swing.JButton();
        btnEditServiceType = new javax.swing.JButton();
        btnDeleteServiceType = new javax.swing.JButton();
        btnViewAllTypes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblWelcomeTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        lblWelcomeTitle.setText("Welcome to Services of Government of Australia");

        View.setPreferredSize(new java.awt.Dimension(587, 400));

        tbl_services_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbl_services_list);

        btnEdit.setText("View/Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setActionCommand("");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtSearchQuery.setToolTipText("Search by Id, Person, Type");

        btnAddService.setText("Add");
        btnAddService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServiceActionPerformed(evt);
            }
        });

        viewAll.setText("View All");
        viewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllActionPerformed(evt);
            }
        });

        btnStartService.setText("Start Service");
        btnStartService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartServiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ViewLayout = new javax.swing.GroupLayout(View);
        View.setLayout(ViewLayout);
        ViewLayout.setHorizontalGroup(
            ViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
            .addGroup(ViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ViewLayout.createSequentialGroup()
                .addComponent(btnStartService)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddService)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewAll, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        ViewLayout.setVerticalGroup(
            ViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ViewLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(ViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearchQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddService)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(viewAll)
                    .addComponent(btnStartService))
                .addGap(0, 20, Short.MAX_VALUE))
        );

        tabHolder.addTab("Services", View);

        btnUserAdd.setText("Add");
        btnUserAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserAddActionPerformed(evt);
            }
        });

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane3.setViewportView(tblUsers);

        btnUserEdit.setText("View/Edit");
        btnUserEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserEditActionPerformed(evt);
            }
        });

        btnUserDelete.setText("Delete");
        btnUserDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout holderLayout = new javax.swing.GroupLayout(holder);
        holder.setLayout(holderLayout);
        holderLayout.setHorizontalGroup(
            holderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(holderLayout.createSequentialGroup()
                .addGroup(holderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, holderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUserAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUserEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUserDelete)))
                .addContainerGap())
        );
        holderLayout.setVerticalGroup(
            holderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(holderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(holderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUserAdd)
                    .addComponent(btnUserEdit)
                    .addComponent(btnUserDelete))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tabHolder.addTab("Users", holder);

        tblServiceTypes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane4.setViewportView(tblServiceTypes);

        btnAddServiceType.setText("Add");
        btnAddServiceType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServiceTypeActionPerformed(evt);
            }
        });

        btnEditServiceType.setText("View/Edit");
        btnEditServiceType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditServiceTypeActionPerformed(evt);
            }
        });

        btnDeleteServiceType.setText("Delete");
        btnDeleteServiceType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteServiceTypeActionPerformed(evt);
            }
        });

        btnViewAllTypes.setText("View All");
        btnViewAllTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllTypesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddServiceType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteServiceType)
                        .addGap(3, 3, 3)
                        .addComponent(btnViewAllTypes)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddServiceType)
                    .addComponent(btnEditServiceType)
                    .addComponent(btnDeleteServiceType)
                    .addComponent(btnViewAllTypes))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tabHolder.addTab("Service Type", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWelcomeTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabHolder))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblWelcomeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabHolder, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabHolder.getAccessibleContext().setAccessibleName("Services");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        
        int selectedRow = tbl_services_list.getSelectedRow();
        
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Please select a service from the table");
        }else{
            String id  = (String) tbl_services_list.getModel().getValueAt(selectedRow, 0);
            GovtService editingService = listener.getServiceById(id);
            EditServiceDialogGuiDialog dialog = new EditServiceDialogGuiDialog(this, 
                    true, editingService, listener);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int selectedRow = tbl_services_list.getSelectedRow();
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Please select a service from the table");
        }else{
            String id  = (String) tbl_services_list.getModel().getValueAt(selectedRow, 0);
            listener.deleteService(id);
            loadAllServicesIntoTable();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String text = txtSearchQuery.getText();
        List<GovtService> searchServices = listener.searchServices(text);
        loadTableData(searchServices);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUserAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAddActionPerformed
        AddUserDialogGuiDialog dialog = new AddUserDialogGuiDialog(this, true, 
                this.userServiceListner);
        dialog.setVisible(true);
        
    }//GEN-LAST:event_btnUserAddActionPerformed

    private void btnAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceActionPerformed
         EditServiceDialogGuiDialog dialog = new EditServiceDialogGuiDialog(this, true, listener);
         dialog.setVisible(true);
    }//GEN-LAST:event_btnAddServiceActionPerformed

    private void viewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllActionPerformed
           reloadServiceTable();
    }//GEN-LAST:event_viewAllActionPerformed

    private void btnStartServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartServiceActionPerformed
        //start service
    }//GEN-LAST:event_btnStartServiceActionPerformed

    private void btnUserDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserDeleteActionPerformed
          
        int selectedRow = tblUsers.getSelectedRow();
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Please select a service from the table");
        }else{
            String id  = (String) tblUsers.getModel()
                    .getValueAt(selectedRow, 0);
            userServiceListner.deleteUser(id);
            loadAllUsersIntoTable();
        }
    }//GEN-LAST:event_btnUserDeleteActionPerformed

    private void btnUserEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserEditActionPerformed
        int selectedRow = tblUsers.getSelectedRow();
        
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Please select a service from the table");
        }else{
            String id  = (String) tblUsers.getModel().getValueAt(selectedRow, 0);
            GovtUser user = userServiceListner.getUserById(id);
            AddUserDialogGuiDialog dialog 
                    = new AddUserDialogGuiDialog(this, 
                    true, user, userServiceListner);
            dialog.setVisible(true);
        }   
    }//GEN-LAST:event_btnUserEditActionPerformed

    private void btnAddServiceTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceTypeActionPerformed
        
         AddServiceTypeGuiDialog dialog = new AddServiceTypeGuiDialog(this, true, listener);
         dialog.setVisible(true);
        
    }//GEN-LAST:event_btnAddServiceTypeActionPerformed

    private void btnEditServiceTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditServiceTypeActionPerformed
        
        int selectedRow = tblServiceTypes.getSelectedRow();
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Please select a service type from the table");
        }else{
            String id  = (String) tblServiceTypes.getModel().getValueAt(selectedRow, 0);
            ServiceType serviceTypeById = listener.getServiceTypeById(id);
            AddServiceTypeGuiDialog dialog = new AddServiceTypeGuiDialog(this, 
                    true, listener, serviceTypeById);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_btnEditServiceTypeActionPerformed

    private void btnDeleteServiceTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteServiceTypeActionPerformed
        int selectedRow = tblServiceTypes.getSelectedRow();
        if (selectedRow == -1){
            JOptionPane.showMessageDialog(this, "Please select a service type from the table");
        }else{
            String id  = (String) tblServiceTypes.getModel().getValueAt(selectedRow, 0);
            listener.deleteServiceType(id);
            loadAllServiceTypesIntoTable();
        }
    }//GEN-LAST:event_btnDeleteServiceTypeActionPerformed

    private void btnViewAllTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllTypesActionPerformed
            loadAllServiceTypesIntoTable();
    }//GEN-LAST:event_btnViewAllTypesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel View;
    private javax.swing.JButton btnAddService;
    private javax.swing.JButton btnAddServiceType;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteServiceType;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEditServiceType;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnStartService;
    private javax.swing.JButton btnUserAdd;
    private javax.swing.JButton btnUserDelete;
    private javax.swing.JButton btnUserEdit;
    private javax.swing.JButton btnViewAllTypes;
    private javax.swing.JPanel holder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblWelcomeTitle;
    private javax.swing.JTabbedPane tabHolder;
    private javax.swing.JTable tblServiceTypes;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTable tbl_services_list;
    private javax.swing.JTextField txtSearchQuery;
    private javax.swing.JButton viewAll;
    // End of variables declaration//GEN-END:variables

    private void loadTableData(List<GovtService> allProperties) {

        try {

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(TABLE_COLUMNS);

            Iterator<GovtService> iterator = allProperties.iterator();
            while (iterator.hasNext()) {
                GovtService property = iterator.next();
                model.addRow(new String[]{String.valueOf(property.getId()), property.getServiceName()});
            }
            tbl_services_list.setModel(model);
        } catch (Exception ex) {
            //Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadUsersIntoTableData(List<GovtUser> allUsers) {

        try {

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(TABLE_USER_COLUMNS);

            Iterator<GovtUser> iterator = allUsers.iterator();
            while (iterator.hasNext()) {
                GovtUser user = iterator.next();
                model.addRow(new String[]{
                    String.valueOf(user.getId()), 
                    user.getFirstName() + " " + user.getLastName(), user.getType()});
            }
            tblUsers.setModel(model);
        } catch (Exception ex) {
            Logger.getLogger(GovernmentServicesGUIForm.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadServiceTypes(List<ServiceType> allServiceTypes) {

        try {

            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(TABLE_SERVICE_TYPE_COLUMNS);

            Iterator<ServiceType> iterator = allServiceTypes.iterator();
            while (iterator.hasNext()) {
                ServiceType user = iterator.next();
                model.addRow(new String[]{
                    String.valueOf(user.getId()), 
                    user.getTitle()});
            }
            tblServiceTypes.setModel(model);
        } catch (Exception ex) {
            Logger.getLogger(GovernmentServicesGUIForm.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void reloadServiceTable() {
        loadAllServicesIntoTable();
        loadAllUsersIntoTable();
        loadAllServiceTypesIntoTable();
    }
    
    private void loadAllServicesIntoTable(){
         List<GovtService> allAvailableServices = listener.getAllAvailableServices();
        loadTableData(allAvailableServices);
    }
    
    private void loadAllUsersIntoTable(){
        List<GovtUser> allUsers = this.userServiceListner.getAllUsers();
        loadUsersIntoTableData(allUsers);
    }
    
    private void loadAllServiceTypesIntoTable(){
        List<ServiceType> allAvailableServices = listener.getAllAvailableServicesType();
        loadServiceTypes(allAvailableServices);
    }
    
}
