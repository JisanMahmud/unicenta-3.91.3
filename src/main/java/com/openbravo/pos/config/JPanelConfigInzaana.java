/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openbravo.pos.config;

import com.inzaana.pos.client.ClientUploadManager;
import com.openbravo.pos.forms.AppConfig;
import com.openbravo.pos.forms.InzaanaSplash;
import java.awt.Component;
import java.util.prefs.Preferences;

/**
 *
 * @author User
 */
public class JPanelConfigInzaana extends javax.swing.JPanel implements PanelConfig {

    Preferences preference;
    String url;
    String userId;
    String userName;

    /**
     * Creates new form JPanelConfigInzaana
     */
    public JPanelConfigInzaana() {
        initComponents();

        preference = Preferences.userRoot();
        url = preference.get(InzaanaSplash.INZAANA_URL_KEY, "URL NOT FOUND");
        userId = preference.get(InzaanaSplash.INZAANA_USER_ID_KEY, "USER ID NOT FOUND");
        userName = preference.get(InzaanaSplash.INZAANA_USER_NAME_KEY, "USER NAME NOT FOUND");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldUrl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUserId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(600, 450));

        jLabel1.setText("Inzaan Server Url");

        jLabel2.setText("User Id");

        jLabel3.setText("User Name");

        jButton1.setText("Batch Upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldUrl)
                        .addComponent(jTextFieldUserId)
                        .addComponent(jTextFieldUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ClientUploadManager uploadManager = new ClientUploadManager();
        uploadManager.startBatchUpload();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldUrl;
    private javax.swing.JTextField jTextFieldUserId;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables

    @Override
    public void loadProperties(AppConfig config) {
        jTextFieldUrl.setText(url);
        jTextFieldUserId.setText(userId);
        jTextFieldUserName.setText(userName);
    }

    @Override
    public void saveProperties(AppConfig config) {
        preference.put(InzaanaSplash.INZAANA_URL_KEY, jTextFieldUrl.getText());
        preference.put(InzaanaSplash.INZAANA_USER_ID_KEY, jTextFieldUserId.getText());
        preference.put(InzaanaSplash.INZAANA_USER_NAME_KEY, jTextFieldUserName.getText());
    }

    @Override
    public boolean hasChanged() {
        return true;
    }

    @Override
    public Component getConfigComponent() {
        return this;
    }
}
