package com.belili.view;

import javax.swing.ImageIcon;

public class View_main extends javax.swing.JFrame {

    public View_main() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/com/belili/icons/iconMBR.png")).getImage());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp_main_profile = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jp_profile_imgUser = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_profile_codeUser = new javax.swing.JTextField();
        txt_profile_fullNameUser = new javax.swing.JTextField();
        txt_profile_correoUser = new javax.swing.JTextField();
        txt_profile_phone1User = new javax.swing.JTextField();
        txt_profile_phone2User = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_profile_pm = new javax.swing.JTextField();
        txt_profile_dateUser = new javax.swing.JTextField();
        txt_profile_stateUser = new javax.swing.JTextField();
        txt_profile_pp = new javax.swing.JTextField();
        txt_profile_ps = new javax.swing.JTextField();
        txt_profile_pw = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jp_main_main = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_main_archivo = new javax.swing.JMenu();
        menui_main_configuracion = new javax.swing.JMenuItem();
        menui_main_salir = new javax.swing.JMenuItem();
        menu_main_modulos = new javax.swing.JMenu();
        menui_main_mantenimiento = new javax.swing.JMenuItem();
        menui_main_compra = new javax.swing.JMenuItem();
        menui_main_venta = new javax.swing.JMenuItem();
        menui_main_almacen = new javax.swing.JMenuItem();
        menu_main_sesion = new javax.swing.JMenu();
        menui_main_main = new javax.swing.JMenuItem();
        menui_main_perfil = new javax.swing.JMenuItem();
        menu_main_ayuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jp_main_profile.setBackground(new java.awt.Color(204, 204, 204));
        jp_main_profile.setLayout(new java.awt.BorderLayout());

        jLabel6.setText(" ");
        jp_main_profile.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        jLabel7.setText("          ");
        jp_main_profile.add(jLabel7, java.awt.BorderLayout.LINE_START);

        jLabel8.setText(" ");
        jp_main_profile.add(jLabel8, java.awt.BorderLayout.PAGE_END);

        jLabel9.setText("          ");
        jp_main_profile.add(jLabel9, java.awt.BorderLayout.LINE_END);

        jPanel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto"));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 200));

        jp_profile_imgUser.setBackground(new java.awt.Color(255, 255, 255));
        jp_profile_imgUser.setMaximumSize(new java.awt.Dimension(170, 170));
        jp_profile_imgUser.setPreferredSize(new java.awt.Dimension(170, 170));

        javax.swing.GroupLayout jp_profile_imgUserLayout = new javax.swing.GroupLayout(jp_profile_imgUser);
        jp_profile_imgUser.setLayout(jp_profile_imgUserLayout);
        jp_profile_imgUserLayout.setHorizontalGroup(
            jp_profile_imgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );
        jp_profile_imgUserLayout.setVerticalGroup(
            jp_profile_imgUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp_profile_imgUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jp_profile_imgUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel1.setFont(new java.awt.Font("Loma", 0, 12)); // NOI18N
        jLabel1.setText("Codigo de Usuario :");

        jLabel2.setFont(new java.awt.Font("Loma", 0, 12)); // NOI18N
        jLabel2.setText("Nombres Completos :");

        jLabel3.setFont(new java.awt.Font("Loma", 0, 12)); // NOI18N
        jLabel3.setText("Correo Electronico :");

        jLabel4.setFont(new java.awt.Font("Loma", 0, 12)); // NOI18N
        jLabel4.setText("Telefono N1 :");

        jLabel5.setFont(new java.awt.Font("Loma", 0, 12)); // NOI18N
        jLabel5.setText("Telefono N2 :");

        txt_profile_codeUser.setBackground(new java.awt.Color(255, 255, 255));
        txt_profile_codeUser.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt_profile_codeUser.setFocusable(false);

        txt_profile_fullNameUser.setBackground(new java.awt.Color(255, 255, 255));
        txt_profile_fullNameUser.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt_profile_fullNameUser.setFocusable(false);

        txt_profile_correoUser.setBackground(new java.awt.Color(255, 255, 255));
        txt_profile_correoUser.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt_profile_correoUser.setFocusable(false);

        txt_profile_phone1User.setBackground(new java.awt.Color(255, 255, 255));
        txt_profile_phone1User.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt_profile_phone1User.setFocusable(false);

        txt_profile_phone2User.setBackground(new java.awt.Color(255, 255, 255));
        txt_profile_phone2User.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt_profile_phone2User.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_profile_codeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_profile_fullNameUser)
                            .addComponent(txt_profile_correoUser)
                            .addComponent(txt_profile_phone1User)
                            .addComponent(txt_profile_phone2User))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_profile_codeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_profile_fullNameUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_profile_correoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_profile_phone1User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_profile_phone2User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Permisos"));

        jLabel10.setFont(new java.awt.Font("Loma", 0, 12)); // NOI18N
        jLabel10.setText("Estado de Cuenta :");

        jLabel11.setFont(new java.awt.Font("Loma", 0, 12)); // NOI18N
        jLabel11.setText("Fecha Limite :");

        jLabel12.setFont(new java.awt.Font("Loma", 0, 12)); // NOI18N
        jLabel12.setText("Permiso de Mantenimiento :");

        jLabel13.setFont(new java.awt.Font("Loma", 0, 12)); // NOI18N
        jLabel13.setText("Permiso de Compra :");

        jLabel14.setFont(new java.awt.Font("Loma", 0, 12)); // NOI18N
        jLabel14.setText("Permiso de Venta :");

        jLabel15.setFont(new java.awt.Font("Loma", 0, 12)); // NOI18N
        jLabel15.setText("Permiso de Almacen :");

        txt_profile_pm.setBackground(new java.awt.Color(255, 255, 255));
        txt_profile_pm.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt_profile_pm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_profile_pm.setFocusable(false);

        txt_profile_dateUser.setBackground(new java.awt.Color(255, 255, 255));
        txt_profile_dateUser.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt_profile_dateUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_profile_dateUser.setFocusable(false);

        txt_profile_stateUser.setBackground(new java.awt.Color(255, 255, 255));
        txt_profile_stateUser.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt_profile_stateUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_profile_stateUser.setFocusable(false);

        txt_profile_pp.setBackground(new java.awt.Color(255, 255, 255));
        txt_profile_pp.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt_profile_pp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_profile_pp.setFocusable(false);

        txt_profile_ps.setBackground(new java.awt.Color(255, 255, 255));
        txt_profile_ps.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt_profile_ps.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_profile_ps.setFocusable(false);

        txt_profile_pw.setBackground(new java.awt.Color(255, 255, 255));
        txt_profile_pw.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt_profile_pw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_profile_pw.setFocusable(false);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/belili/images/marca.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_profile_pm)
                            .addComponent(txt_profile_dateUser)
                            .addComponent(txt_profile_stateUser)
                            .addComponent(txt_profile_pp)
                            .addComponent(txt_profile_ps, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(txt_profile_pw)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel16)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_profile_stateUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_profile_dateUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_profile_pm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_profile_pp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_profile_ps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txt_profile_pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jp_main_profile.add(jPanel11, java.awt.BorderLayout.CENTER);

        jp_main_main.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jp_main_mainLayout = new javax.swing.GroupLayout(jp_main_main);
        jp_main_main.setLayout(jp_main_mainLayout);
        jp_main_mainLayout.setHorizontalGroup(
            jp_main_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
        );
        jp_main_mainLayout.setVerticalGroup(
            jp_main_mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );

        menu_main_archivo.setText("Archivo");

        menui_main_configuracion.setText("Configuracion");
        menu_main_archivo.add(menui_main_configuracion);

        menui_main_salir.setText("Salir");
        menu_main_archivo.add(menui_main_salir);

        jMenuBar1.add(menu_main_archivo);

        menu_main_modulos.setText("Modulos");

        menui_main_mantenimiento.setText("Mantenimiento");
        menu_main_modulos.add(menui_main_mantenimiento);

        menui_main_compra.setText("Compra");
        menu_main_modulos.add(menui_main_compra);

        menui_main_venta.setText("Venta");
        menu_main_modulos.add(menui_main_venta);

        menui_main_almacen.setText("Almacen");
        menu_main_modulos.add(menui_main_almacen);

        jMenuBar1.add(menu_main_modulos);

        menu_main_sesion.setText("Sesion");

        menui_main_main.setText("Principal");
        menu_main_sesion.add(menui_main_main);

        menui_main_perfil.setText("Perfil");
        menui_main_perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menui_main_perfilActionPerformed(evt);
            }
        });
        menu_main_sesion.add(menui_main_perfil);

        jMenuBar1.add(menu_main_sesion);

        menu_main_ayuda.setText("Ayuda");
        jMenuBar1.add(menu_main_ayuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1076, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jp_main_profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jp_main_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jp_main_profile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jp_main_main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menui_main_perfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menui_main_perfilActionPerformed
    }//GEN-LAST:event_menui_main_perfilActionPerformed

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(View_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(View_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(View_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(View_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new View_main().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jp_main_main;
    public javax.swing.JPanel jp_main_profile;
    public javax.swing.JPanel jp_profile_imgUser;
    public javax.swing.JMenu menu_main_archivo;
    private javax.swing.JMenu menu_main_ayuda;
    public javax.swing.JMenu menu_main_modulos;
    private javax.swing.JMenu menu_main_sesion;
    public javax.swing.JMenuItem menui_main_almacen;
    public javax.swing.JMenuItem menui_main_compra;
    public javax.swing.JMenuItem menui_main_configuracion;
    public javax.swing.JMenuItem menui_main_main;
    public javax.swing.JMenuItem menui_main_mantenimiento;
    public javax.swing.JMenuItem menui_main_perfil;
    public javax.swing.JMenuItem menui_main_salir;
    public javax.swing.JMenuItem menui_main_venta;
    public javax.swing.JTextField txt_profile_codeUser;
    public javax.swing.JTextField txt_profile_correoUser;
    public javax.swing.JTextField txt_profile_dateUser;
    public javax.swing.JTextField txt_profile_fullNameUser;
    public javax.swing.JTextField txt_profile_phone1User;
    public javax.swing.JTextField txt_profile_phone2User;
    public javax.swing.JTextField txt_profile_pm;
    public javax.swing.JTextField txt_profile_pp;
    public javax.swing.JTextField txt_profile_ps;
    public javax.swing.JTextField txt_profile_pw;
    public javax.swing.JTextField txt_profile_stateUser;
    // End of variables declaration//GEN-END:variables
}
