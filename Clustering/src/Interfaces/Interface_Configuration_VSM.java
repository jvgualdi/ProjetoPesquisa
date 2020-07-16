
package Interfaces;

import parameters.Parameters_B_K_M;
import UC.SearchIO;
import configuration.Configuration_Unsupervised_Base;
import configuration.Configuration_Unsupervised_VSM;
import UC.UnsupervisedVectorSpacedClustering;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Interface_Configuration_VSM extends javax.swing.JFrame {
    
    Configuration_Unsupervised_VSM vsmConfig;
    
    public Interface_Configuration_VSM() {
        vsmConfig = new Configuration_Unsupervised_VSM();
        initComponents();
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cK_Means = new javax.swing.JCheckBox();
        bKMeansParameter = new javax.swing.JButton();
        cBKmeans = new javax.swing.JCheckBox();
        bBKmean_Parameter = new javax.swing.JButton();
        cNMF = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jEntrada = new javax.swing.JLabel();
        tEntrada = new javax.swing.JTextField();
        jSaida = new javax.swing.JLabel();
        tSaida = new javax.swing.JTextField();
        bSearchEntrada = new javax.swing.JButton();
        bSearchSaida = new javax.swing.JButton();
        bOK = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();
        lRepetition = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tRep = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tThreads = new javax.swing.JTextField();
        bSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cK_Means.setText("K-Means");

        bKMeansParameter.setText("...");
        bKMeansParameter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKMeansParameterActionPerformed(evt);
            }
        });

        cBKmeans.setText("B.K-Means");

        bBKmean_Parameter.setText("...");
        bBKmean_Parameter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBKmean_ParameterActionPerformed(evt);
            }
        });

        cNMF.setText("NMF");

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cBKmeans)
                    .addComponent(cK_Means)
                    .addComponent(cNMF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bKMeansParameter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBKmean_Parameter, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cK_Means)
                    .addComponent(bKMeansParameter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBKmeans)
                    .addComponent(bBKmean_Parameter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cNMF)
                    .addComponent(jButton1))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jEntrada.setText("Entrada:");

        jSaida.setText("Saida: ");

        bSearchEntrada.setText("Search");
        bSearchEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSearchEntradaActionPerformed(evt);
            }
        });

        bSearchSaida.setText("Search");
        bSearchSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSearchSaidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSaida)
                    .addComponent(jEntrada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tSaida, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addComponent(tEntrada))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bSearchEntrada)
                    .addComponent(bSearchSaida))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEntrada)
                    .addComponent(tEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSearchEntrada))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSaida)
                    .addComponent(tSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bSearchSaida))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        bOK.setText("OK");
        bOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOKActionPerformed(evt);
            }
        });

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        lRepetition.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setText("N Repetition: ");

        tRep.setText("10");
        tRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tRepActionPerformed(evt);
            }
        });

        jLabel1.setText("N Threads:");

        tThreads.setText("10");
        tThreads.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tThreadsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lRepetitionLayout = new javax.swing.GroupLayout(lRepetition);
        lRepetition.setLayout(lRepetitionLayout);
        lRepetitionLayout.setHorizontalGroup(
            lRepetitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lRepetitionLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(lRepetitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(lRepetitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tRep, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(tThreads))
                .addGap(81, 81, 81))
        );
        lRepetitionLayout.setVerticalGroup(
            lRepetitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lRepetitionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lRepetitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(lRepetitionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tThreads, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bSave.setText("Save configuration");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bOK)
                        .addGap(17, 17, 17)
                        .addComponent(bSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bCancelar)
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lRepetition, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lRepetition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bOK)
                    .addComponent(bCancelar)
                    .addComponent(bSave))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void denifeConfiguration(){
        vsmConfig.setNumThreads(Integer.parseInt(tThreads.getText()));
        vsmConfig.setNumReps(Integer.parseInt(tRep.getText()));

        if(cK_Means.isSelected()){
            vsmConfig.setK_means(true);
        }else{
            vsmConfig.setK_means(false);
        }
        if(cBKmeans.isSelected()){
            vsmConfig.setB_k_means(true);
        }else{
            vsmConfig.setB_k_means(false);
        }
        if(cNMF.isSelected()){
            vsmConfig.setNmf(true);
        }else{
            vsmConfig.setNmf(false);
        }
        
        vsmConfig.setDirEntrada(tEntrada.getText());
        vsmConfig.setDirSaida(tSaida.getText());
    }
    
    private void bOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOKActionPerformed
        denifeConfiguration();
        UnsupervisedVectorSpacedClustering.learning(vsmConfig);
        this.dispose();
    }//GEN-LAST:event_bOKActionPerformed

    private void bSearchEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchEntradaActionPerformed
        tEntrada.setText(SearchIO.AbreDir());
    }//GEN-LAST:event_bSearchEntradaActionPerformed

    private void bSearchSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchSaidaActionPerformed
        tSaida.setText(SearchIO.AbreDir());
    }//GEN-LAST:event_bSearchSaidaActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bKMeansParameterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKMeansParameterActionPerformed
        new Interface_Parameters_K_Means(vsmConfig.getKmeans_Parameter());
    }//GEN-LAST:event_bKMeansParameterActionPerformed

    private void tRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tRepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tRepActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        denifeConfiguration();
        JFileChooser save = new JFileChooser();
        save.setFileSelectionMode(save.FILES_ONLY);
        save.setDialogTitle("Save");
        save.setDialogType(save.SAVE_DIALOG);
        save.setFileFilter(new FileNameExtensionFilter("Unsupervised Clustering (*.uc)", "uc"));
        save.showSaveDialog(null);

        File config = save.getSelectedFile();
        if(config == null){
            return;
        }
        String fileName = config.toString();

        FileOutputStream file;
        ObjectOutputStream obj;
        try {
            if(!fileName.endsWith(".uc")){
                fileName = fileName + ".uc";
            }
            file = new FileOutputStream(fileName);
            obj = new ObjectOutputStream(file);
            obj.writeObject(vsmConfig);
            obj.close();
        } catch (Exception e) {
            System.err.println("Error when saving configuration object.");
            e.printStackTrace();
            System.exit(0);
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void bBKmean_ParameterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBKmean_ParameterActionPerformed
        new Interface_Parameters_B_K_M(vsmConfig.getbKmeans_Parameter());
    }//GEN-LAST:event_bBKmean_ParameterActionPerformed

    private void tThreadsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tThreadsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tThreadsActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Interface_Parameters_NMF(vsmConfig.getNmf_Parameter());
    }//GEN-LAST:event_jButton1ActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBKmean_Parameter;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bKMeansParameter;
    private javax.swing.JButton bOK;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bSearchEntrada;
    private javax.swing.JButton bSearchSaida;
    private javax.swing.JCheckBox cBKmeans;
    private javax.swing.JCheckBox cK_Means;
    private javax.swing.JCheckBox cNMF;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jEntrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jSaida;
    private javax.swing.JPanel lRepetition;
    private javax.swing.JTextField tEntrada;
    private javax.swing.JTextField tRep;
    private javax.swing.JTextField tSaida;
    private javax.swing.JTextField tThreads;
    // End of variables declaration//GEN-END:variables
}
