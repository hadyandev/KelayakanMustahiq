/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelayakanmustahiq.view;

import kelayakanmustahiq.entities.Mustahiq;
import kelayakanmustahiq.entities.DerajatFuzzy;
import kelayakanmustahiq.function.FunctionDerajatFuzzy;
import kelayakanmustahiq.function.FunctionMustahiq;
import kelayakanmustahiq.fuzzy.Apred;
import kelayakanmustahiq.fuzzy.MembershipFunction;
import kelayakanmustahiq.fuzzy.Tsukamoto;
import kelayakanmustahiq.model.MustahiqModel;
import kelayakanmustahiq.model.DerajatFuzzyModel;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Hadyan Ahmad
 */
public class PanelPerhitungan extends javax.swing.JPanel {

    private final MustahiqModel mustahiqModel = new MustahiqModel();
    private final DerajatFuzzyModel dfm = new DerajatFuzzyModel();

    /**
     * Creates new form PanelMustahiq
     */
    public PanelPerhitungan() {
        initComponents();
        refreshPerhitungan();
    }

    private void refreshPerhitungan() {
        FillInputFuzzy();
        FillTanggungan();
        FillTempatTinggal();
        FillPendapatan();
        FillAttitude();
        Empty();
    }

    private String number(int x) {
        String num = "Rp. " + NumberFormat.getIntegerInstance().format(x) + ",-";
        return num;
    }

    private void FillInputFuzzy() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("#");
        dtm.addColumn("Nama Mustahiq");
        dtm.addColumn("Tanggungan");
        dtm.addColumn("Kualitas Tempat Tinggal");
        dtm.addColumn("Pendapatan");
        dtm.addColumn("Attitude");

        ArrayList list = new ArrayList();
        for (Mustahiq mustahiq : this.mustahiqModel.findAll()) {
            list.add(mustahiq.getIdMustahiq());
        }

        for (Mustahiq mustahiq : this.mustahiqModel.findAll()) {
            int x = list.indexOf(mustahiq.getIdMustahiq()) + 1;
            dtm.addRow(new Object[]{x, mustahiq.getNamaMustahiq(), mustahiq.getJumlahTanggungan(), mustahiq.getKualitasTempattinggal(),
                number(mustahiq.getJumlahPendapatan()), mustahiq.getAttitude()});
        }
        this.tblInputFuzzy.setModel(dtm);
        tblInputFuzzy.setRowSorter(new TableRowSorter(dtm));
    }

    private void FillTanggungan() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("#");
        dtm.addColumn("Nama Mustahiq");
        dtm.addColumn("Tanggungan");
        dtm.addColumn("μ[x]tanggunganSedikit");
        dtm.addColumn("μ[x]tanggunganBanyak");

        FunctionMustahiq fm = new FunctionMustahiq();

        ArrayList list = new ArrayList();
        for (DerajatFuzzy df : this.dfm.findAll()) {
            list.add(df.getIdDerajat());
        }

        for (DerajatFuzzy df : this.dfm.findAll()) {
            int x = list.indexOf(df.getIdDerajat()) + 1;
            dtm.addRow(new Object[]{x, df.getNamaMustahiq(), fm.jumlahTanggungan(df.getIdDerajat()), df.getTanggunganSedikit(),
                df.getTanggunganBanyak()});
        }
        this.tblTanggungan.setModel(dtm);
        tblTanggungan.setRowSorter(new TableRowSorter(dtm));
    }

    private void FillTempatTinggal() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("#");
        dtm.addColumn("Nama Mustahiq");
        dtm.addColumn("Kualitas Tempat Tinggal");
        dtm.addColumn("μ[x]tempatTinggalBuruk");
        dtm.addColumn("μ[x]tempatTinggalBaik");

        FunctionMustahiq fm = new FunctionMustahiq();

        ArrayList list = new ArrayList();
        for (DerajatFuzzy df : this.dfm.findAll()) {
            list.add(df.getIdDerajat());
        }

        for (DerajatFuzzy df : this.dfm.findAll()) {
            int x = list.indexOf(df.getIdDerajat()) + 1;
            dtm.addRow(new Object[]{x, df.getNamaMustahiq(), fm.tempatTinggal(df.getIdDerajat()), df.getTempattinggalBuruk(),
                df.getTempattinggalBaik()});
        }
        this.tblBiaya.setModel(dtm);
        tblBiaya.setRowSorter(new TableRowSorter(dtm));
    }

    private void FillPendapatan() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("#");
        dtm.addColumn("Nama Mustahiq");
        dtm.addColumn("Pendapatan");
        dtm.addColumn("μ[x]pendapatanKurang");
        dtm.addColumn("μ[x]pendapatanCukup");

        FunctionMustahiq fm = new FunctionMustahiq();

        ArrayList list = new ArrayList();
        for (DerajatFuzzy df : this.dfm.findAll()) {
            list.add(df.getIdDerajat());
        }

        for (DerajatFuzzy df : this.dfm.findAll()) {
            int x = list.indexOf(df.getIdDerajat()) + 1;
            dtm.addRow(new Object[]{x, df.getNamaMustahiq(), number(fm.jumlahPendapatan(df.getIdDerajat())),
                df.getPendapatanKurang(), df.getPendapatanCukup()});
        }
        this.tblPendapatan.setModel(dtm);
        tblPendapatan.setRowSorter(new TableRowSorter(dtm));
    }

    private void FillAttitude() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("#");
        dtm.addColumn("Nama Mustahiq");
        dtm.addColumn("Attitude");
        dtm.addColumn("μ[x]attitudeKurangBaik");
        dtm.addColumn("μ[x]attitudeBaik");

        FunctionMustahiq fm = new FunctionMustahiq();

        ArrayList list = new ArrayList();
        for (DerajatFuzzy df : this.dfm.findAll()) {
            list.add(df.getIdDerajat());
        }

        for (DerajatFuzzy df : this.dfm.findAll()) {
            int x = list.indexOf(df.getIdDerajat()) + 1;
            dtm.addRow(new Object[]{x, df.getNamaMustahiq(), fm.attitude(df.getIdDerajat()),
                df.getAttitudeKurangbaik(), df.getAttitudeBaik()});
        }
        this.tblAttitude.setModel(dtm);
        tblAttitude.setRowSorter(new TableRowSorter(dtm));
    }

    private void FillApred() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("#");
        dtm.addColumn("Nama Mustahiq");
        dtm.addColumn("R1");
        dtm.addColumn("R2");
        dtm.addColumn("R3");
        dtm.addColumn("R4");
        dtm.addColumn("R5");
        dtm.addColumn("R6");
        dtm.addColumn("R7");
        dtm.addColumn("R8");
        dtm.addColumn("R9");
        dtm.addColumn("R10");
        dtm.addColumn("R11");
        dtm.addColumn("R12");
        dtm.addColumn("R13");
        dtm.addColumn("R14");
        dtm.addColumn("R15");
        dtm.addColumn("R16");

        Apred a = new Apred();

        ArrayList list = new ArrayList();
        for (DerajatFuzzy df : this.dfm.findAll()) {
            list.add(df.getIdDerajat());
        }

        for (DerajatFuzzy df : this.dfm.findAll()) {
            int x = list.indexOf(df.getIdDerajat()) + 1;
            dtm.addRow(new Object[]{x, df.getNamaMustahiq(), a.Rule1(df.getIdDerajat()), a.Rule2(df.getIdDerajat()), a.Rule3(df.getIdDerajat()),
                a.Rule4(df.getIdDerajat()), a.Rule5(df.getIdDerajat()), a.Rule6(df.getIdDerajat()), a.Rule7(df.getIdDerajat()),
                a.Rule8(df.getIdDerajat()), a.Rule9(df.getIdDerajat()), a.Rule10(df.getIdDerajat()), a.Rule11(df.getIdDerajat()),
                a.Rule12(df.getIdDerajat()), a.Rule13(df.getIdDerajat()), a.Rule14(df.getIdDerajat()), a.Rule15(df.getIdDerajat()),
                a.Rule16(df.getIdDerajat())});
        }
        this.tblApred.setModel(dtm);
        tblApred.setRowSorter(new TableRowSorter(dtm));
    }

    private void FillZ() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("#");
        dtm.addColumn("Nama Mustahiq");
        dtm.addColumn("R1");
        dtm.addColumn("R2");
        dtm.addColumn("R3");
        dtm.addColumn("R4");
        dtm.addColumn("R5");
        dtm.addColumn("R6");
        dtm.addColumn("R7");
        dtm.addColumn("R8");
        dtm.addColumn("R9");
        dtm.addColumn("R10");
        dtm.addColumn("R11");
        dtm.addColumn("R12");
        dtm.addColumn("R13");
        dtm.addColumn("R14");
        dtm.addColumn("R15");
        dtm.addColumn("R16");

        Apred a = new Apred();
        Tsukamoto t = new Tsukamoto();

        ArrayList list = new ArrayList();
        for (DerajatFuzzy df : this.dfm.findAll()) {
            list.add(df.getIdDerajat());
        }

        for (DerajatFuzzy df : this.dfm.findAll()) {
            int x = list.indexOf(df.getIdDerajat()) + 1;
            dtm.addRow(new Object[]{x, df.getNamaMustahiq(), t.ZMin(a.Rule1(df.getIdDerajat())), t.ZMin(a.Rule2(df.getIdDerajat())),
                t.ZMin(a.Rule3(df.getIdDerajat())), t.ZMin(a.Rule4(df.getIdDerajat())), t.ZMin(a.Rule5(df.getIdDerajat())),
                t.ZMin(a.Rule6(df.getIdDerajat())), t.ZMax(a.Rule7(df.getIdDerajat())), t.ZMin(a.Rule8(df.getIdDerajat())),
                t.ZMin(a.Rule9(df.getIdDerajat())), t.ZMin(a.Rule10(df.getIdDerajat())),
                t.ZMin(a.Rule11(df.getIdDerajat())), t.ZMax(a.Rule12(df.getIdDerajat())), t.ZMin(a.Rule13(df.getIdDerajat())),
                t.ZMin(a.Rule14(df.getIdDerajat())), t.ZMin(a.Rule15(df.getIdDerajat())), t.ZMin(a.Rule16(df.getIdDerajat()))});
        }
        this.tblZ.setModel(dtm);
        tblZ.setRowSorter(new TableRowSorter(dtm));
    }

    

    private void Empty() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("#");
        dtm.addColumn("Nama Mustahiq");
        dtm.addColumn("R1");
        dtm.addColumn("R2");
        dtm.addColumn("R3");
        dtm.addColumn("R4");
        dtm.addColumn("R5");
        dtm.addColumn("R6");
        dtm.addColumn("R7");
        dtm.addColumn("R8");
        dtm.addColumn("R9");
        dtm.addColumn("R10");
        dtm.addColumn("R11");
        dtm.addColumn("R12");
        dtm.addColumn("R13");
        dtm.addColumn("R14");
        dtm.addColumn("R15");
        dtm.addColumn("R16");
        this.tblApred.setModel(dtm);
        tblApred.setRowSorter(new TableRowSorter(dtm));

        DefaultTableModel dtmZ = new DefaultTableModel();
        dtmZ.addColumn("#");
        dtmZ.addColumn("Nama Mustahiq");
        dtmZ.addColumn("R1");
        dtmZ.addColumn("R2");
        dtmZ.addColumn("R3");
        dtmZ.addColumn("R4");
        dtmZ.addColumn("R5");
        dtmZ.addColumn("R6");
        dtmZ.addColumn("R7");
        dtmZ.addColumn("R8");
        dtmZ.addColumn("R9");
        dtmZ.addColumn("R10");
        dtmZ.addColumn("R11");
        dtmZ.addColumn("R12");
        dtmZ.addColumn("R13");
        dtmZ.addColumn("R14");
        dtmZ.addColumn("R15");
        dtmZ.addColumn("R16");
        this.tblZ.setModel(dtmZ);
        tblZ.setRowSorter(new TableRowSorter(dtmZ));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        lblHeader = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jXHeader1 = new org.jdesktop.swingx.JXHeader();
        btnRefresh = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblInputFuzzy = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTanggungan = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblBiaya = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblPendapatan = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblAttitude = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblApred = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblZ = new javax.swing.JTable();

        jButton1.setText("jButton1");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        panelImage1.setForeground(new java.awt.Color(0, 0, 0));
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kelayakanmustahiq/resource/mosque_dark blue.jpg"))); // NOI18N

        lblHeader.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(0, 0, 0));
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblHeader.setText("LIST PERHITUNGAN KELAYAKAN");

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kelayakanmustahiq/resource/repeat_24px.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(0, 51, 204));

        tblInputFuzzy.setBackground(new java.awt.Color(153, 204, 255));
        tblInputFuzzy.setModel(new javax.swing.table.DefaultTableModel(
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
        tblInputFuzzy.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblInputFuzzy.setRowSelectionAllowed(false);
        jScrollPane3.setViewportView(tblInputFuzzy);

        jTabbedPane1.addTab("Input Fuzzy", jScrollPane3);

        tblTanggungan.setBackground(new java.awt.Color(153, 204, 255));
        tblTanggungan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTanggungan.setRowSelectionAllowed(false);
        jScrollPane4.setViewportView(tblTanggungan);

        jTabbedPane1.addTab("Derajat Tanggungan", jScrollPane4);

        tblBiaya.setBackground(new java.awt.Color(153, 204, 255));
        tblBiaya.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBiaya.setRowSelectionAllowed(false);
        jScrollPane5.setViewportView(tblBiaya);

        jTabbedPane1.addTab("Derajat Tempat Tinggal", jScrollPane5);

        tblPendapatan.setBackground(new java.awt.Color(153, 204, 255));
        tblPendapatan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPendapatan.setRowSelectionAllowed(false);
        jScrollPane6.setViewportView(tblPendapatan);

        jTabbedPane1.addTab("Derajat Pendapatan", jScrollPane6);

        tblAttitude.setBackground(new java.awt.Color(153, 204, 255));
        tblAttitude.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAttitude.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblAttitude.setRowSelectionAllowed(false);
        jScrollPane7.setViewportView(tblAttitude);

        jTabbedPane1.addTab("Derajat Attitude", jScrollPane7);

        tblApred.setBackground(new java.awt.Color(153, 204, 255));
        tblApred.setModel(new javax.swing.table.DefaultTableModel(
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
        tblApred.setRowSelectionAllowed(false);
        jScrollPane8.setViewportView(tblApred);

        jTabbedPane1.addTab("a-predikat", jScrollPane8);

        tblZ.setBackground(new java.awt.Color(153, 204, 255));
        tblZ.setModel(new javax.swing.table.DefaultTableModel(
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
        tblZ.setRowSelectionAllowed(false);
        jScrollPane9.setViewportView(tblZ);

        jTabbedPane1.addTab("Nilai z", jScrollPane9);

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelImage1Layout.createSequentialGroup()
                        .addComponent(jXHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRefresh)))
                .addContainerGap())
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeader)
                    .addComponent(jXHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        MembershipFunction mf = new MembershipFunction();
        Mustahiq mustahiq = new Mustahiq();
        try {
            for (DerajatFuzzy df : this.dfm.findAll()) {
                int id = df.getIdDerajat();
                df = this.dfm.find(id);

                FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
                df.setNamaMustahiq(fdf.namaMustahiq(id));
                df.setTanggunganSedikit(mf.tanggunganSedikit(id));
                df.setTanggunganBanyak(mf.tanggunganBanyak(id));
                df.setTempattinggalBuruk(mf.tempatTinggalBuruk(id));
                df.setTempattinggalBaik(mf.tempatTinggalBaik(id));
                df.setPendapatanKurang(mf.pendapatanKurang(id));
                df.setPendapatanCukup(mf.pendapatanCukup(id));
                df.setAttitudeKurangbaik(mf.attitudeKurangBaik(id));
                df.setAttitudeBaik(mf.attitudeBaik(id));
                this.dfm.update(df);
            }
        } catch (Exception e) {
        }
        refreshPerhitungan();
        FillApred();
        FillZ();
    }//GEN-LAST:event_btnRefreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    private javax.swing.JLabel lblHeader;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JTable tblApred;
    private javax.swing.JTable tblAttitude;
    private javax.swing.JTable tblBiaya;
    private javax.swing.JTable tblInputFuzzy;
    private javax.swing.JTable tblPendapatan;
    private javax.swing.JTable tblTanggungan;
    private javax.swing.JTable tblZ;
    // End of variables declaration//GEN-END:variables
}
