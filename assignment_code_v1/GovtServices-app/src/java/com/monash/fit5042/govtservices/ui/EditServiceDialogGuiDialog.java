package com.monash.fit5042.govtservices.ui;

import com.monash.fit5042.govtservice.entities.GovtService;
import com.monash.fit5042.govtservice.entities.ServiceType;
import com.monash.fit5042.govtservices.GovernmentServiceListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class EditServiceDialogGuiDialog extends javax.swing.JDialog {

    GovtService service;
    GovernmentServiceListener listener;
    List<ServiceType> allAvailableServicesType;

    /**
     * Creates new form EditServiceDialogGuiDialog
     */
    public EditServiceDialogGuiDialog(java.awt.Frame parent, boolean modal, GovernmentServiceListener listener) {
        super(parent, modal);
        initComponents();
        this.listener = listener;
        initData();
        setTitle("Add new Service");
    }

    /**
     * Creates new form EditServiceDialogGuiDialog
     */
    public EditServiceDialogGuiDialog(java.awt.Frame parent, boolean modal,
            GovtService service, GovernmentServiceListener listener) {
        super(parent, modal);
        initComponents();
        this.service = service;
        this.listener = listener;
        initData();
        setTitle("Edit Service");
    }

    private void initData() {
        initServiceTypes();
        //loads the service info if it's editing
        if (this.service != null) {
            txtServiceName.setText(this.service.getServiceName());
            txtDescription.setText(this.service.getDescription());
            txtThumbnail.setText(this.service.getThumbnail());    
            ServiceType type = this.service.getServiceType();
            int indexForType = findIndexForServiceType(type);
            cmbServiceType.setSelectedIndex(indexForType);
        }
    }
    
    private int findIndexForServiceType(ServiceType type){
        int retVal = 0;
        for(int i=0;i<allAvailableServicesType.size();i++){
            if(type.getId().longValue() == allAvailableServicesType.get(i).getId().longValue()){
                retVal = i;
                break;
            }
        }
        return retVal;
    }

    private void initServiceTypes() {
         
        allAvailableServicesType = this.listener.getAllAvailableServicesType();
        ArrayList<String> types = new ArrayList<>();
        for(ServiceType type: allAvailableServicesType){
            types.add(type.getTitle());
        }
        cmbServiceType.setModel(new DefaultComboBoxModel(types.toArray()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        holder = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtServiceName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtThumbnail = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        cmbServiceType = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Service Name");

        jLabel2.setText("Service Type");

        jLabel3.setText("Description");

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        jLabel4.setText("Thumbnail");

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cmbServiceType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout holderLayout = new javax.swing.GroupLayout(holder);
        holder.setLayout(holderLayout);
        holderLayout.setHorizontalGroup(
            holderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(holderLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(holderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(holderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(txtThumbnail)
                    .addComponent(txtServiceName)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, holderLayout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSave))
                    .addComponent(cmbServiceType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        holderLayout.setVerticalGroup(
            holderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(holderLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(holderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtServiceName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(holderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbServiceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(holderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(holderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtThumbnail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(holderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(holder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(holder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        String serviceName = txtServiceName.getText();
        String description = txtDescription.getText();
        ServiceType serviceType = allAvailableServicesType.get(cmbServiceType.getSelectedIndex());
        String thumbnail = txtThumbnail.getText();
        
        if(service!=null){
            service.setServiceName(serviceName);
            service.setDescription(description);
            service.setServiceType(serviceType);
            service.setThumbnail(thumbnail);
            listener.editService(service);
        }else{
            GovtService newService = new GovtService();
            newService.setServiceName(serviceName);
            newService.setDescription(description);
            newService.setServiceType(serviceType);
            newService.setThumbnail(thumbnail);
            listener.addService(newService);
        }
        dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbServiceType;
    private javax.swing.JPanel holder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtServiceName;
    private javax.swing.JTextField txtThumbnail;
    // End of variables declaration//GEN-END:variables
}