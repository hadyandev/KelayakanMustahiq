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
import kelayakanmustahiq.function.FunctionVariabelFuzzy;
import kelayakanmustahiq.model.MustahiqModel;
import kelayakanmustahiq.model.DerajatFuzzyModel;
import java.awt.HeadlessException;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Hadyan Ahmad
 */
public class PanelMustahiq extends javax.swing.JPanel {

    private final MustahiqModel mustahiqModel = new MustahiqModel();
    private final DerajatFuzzyModel dfm = new DerajatFuzzyModel();

    /**
     * Creates new form PanelMustahiq
     */
    public PanelMustahiq() {
        initComponents();
        refreshMustahiq();
    }

    private String number(int x) {
        String num = "Rp. "+NumberFormat.getIntegerInstance().format(x)+",-";
        return num;
    }

    private void FillData() {
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
        this.tblMustahiq.setModel(dtm);
        tblMustahiq.setRowSorter(new TableRowSorter(dtm));
    }

    private void refreshMustahiq() {
        tfNamaMustahiq.setText("");
        tfAlamat.setText("");
        tfTanggungan.setText("");
        tfPendapatan.setText("");
        btnAddMustahiq.setEnabled(true);
        FunctionVariabelFuzzy fvf = new FunctionVariabelFuzzy();
        
        lblTimTingMin.setText(fvf.domainMin("Tempat Tinggal").toString());
        lblTimTingMax.setText(fvf.domainMax("Tempat Tinggal").toString());
        sliderTempatTinggal.setMinimum(fvf.domainMin("Tempat Tinggal"));
        sliderTempatTinggal.setMaximum(fvf.domainMax("Tempat Tinggal"));
        tfTempatTinggal.setText("");
        
        lblAttitudeMin.setText(fvf.domainMin("Attitude").toString());
        lblAttitudeMax.setText(fvf.domainMax("Attitude").toString());
        sliderAttitude.setMinimum(fvf.domainMin("Attitude"));
        sliderAttitude.setMaximum(fvf.domainMax("Attitude"));
        tfAttitude.setText("");
        FillData();
    }

    private Integer cariIdMustahiq(String namaMustahiq) {
        int id = 0;
        for (Mustahiq mustahiq : this.mustahiqModel.findAll()) {
            if (mustahiq.getNamaMustahiq().equals(namaMustahiq)) {
                id = mustahiq.getIdMustahiq();
            }
        }
        return id;
    }

    private void addMustahiq() {
        try {
            if (tfNamaMustahiq.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Mustahiq harus diisi!");
            } else {
                Mustahiq mustahiq = new Mustahiq();
                mustahiq.setNamaMustahiq(this.tfNamaMustahiq.getText());
                mustahiq.setAlamat(this.tfAlamat.getText());
                mustahiq.setJumlahTanggungan(Integer.valueOf(this.tfTanggungan.getText()));
                mustahiq.setKualitasTempattinggal(Integer.valueOf(this.tfTempatTinggal.getText()));
                mustahiq.setJumlahPendapatan(Integer.valueOf(this.tfPendapatan.getText()));
                mustahiq.setAttitude(Integer.valueOf(this.tfAttitude.getText()));
                mustahiq.setStatus("Tidak Layak");
                float kelayakan = 0;
                mustahiq.setKelayakan(kelayakan);
                this.mustahiqModel.create(mustahiq);

                DerajatFuzzy df = new DerajatFuzzy();
                float derajatAwal = 0;
                df.setNamaMustahiq(this.tfNamaMustahiq.getText());
                this.dfm.create(df);

                this.sliderTempatTinggal.setValue(Integer.valueOf(tfTempatTinggal.getText()));
                this.sliderAttitude.setValue(Integer.valueOf(tfAttitude.getText()));
                JOptionPane.showMessageDialog(null, "Mustahiq berhasil ditambahkan!");
            }
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        refreshMustahiq();
    }

    private void updateMustahiq() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblMustahiq.getModel();
            if (tblMustahiq.getSelectedRow() == -1) {
                if (tblMustahiq.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Tabel masih kosong!");
                } else {
                    JOptionPane.showMessageDialog(null, "Mustahiq harus dipilih!");
                }
            } else {
                int index = this.tblMustahiq.getSelectedRow();
                int id = cariIdMustahiq(this.tblMustahiq.getValueAt(index, 1).toString());
                FunctionMustahiq fm = new FunctionMustahiq();

                Mustahiq mustahiq = new Mustahiq();
                mustahiq.setIdMustahiq(id);
                mustahiq.setNamaMustahiq(this.tfNamaMustahiq.getText());
                mustahiq.setAlamat(this.tfAlamat.getText());
                mustahiq.setJumlahTanggungan(Integer.valueOf(this.tfTanggungan.getText()));
                mustahiq.setKualitasTempattinggal(Integer.valueOf(this.tfTempatTinggal.getText()));
                mustahiq.setJumlahPendapatan(Integer.valueOf(this.tfPendapatan.getText()));
                mustahiq.setAttitude(Integer.valueOf(this.tfAttitude.getText()));
                mustahiq.setStatus(fm.status(id));
                mustahiq.setKelayakan(fm.kelayakan(id));
                this.mustahiqModel.update(mustahiq);

                try {
                    DerajatFuzzy df = this.dfm.find(id);
                    FunctionDerajatFuzzy fdf = new FunctionDerajatFuzzy();
                    df.setIdDerajat(id);
                    df.setNamaMustahiq(this.tfNamaMustahiq.getText());
                    this.dfm.update(df);
                } catch (Exception e) {
                }

                JOptionPane.showMessageDialog(null, "Update Mustahiq berhasil!");
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        refreshMustahiq();
    }

    private void deleteMustahiq() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblMustahiq.getModel();
            if (tblMustahiq.getSelectedRow() == -1) {
                if (tblMustahiq.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(null, "Tabel masih kosong!");
                } else {
                    JOptionPane.showMessageDialog(null, "Mustahiq harus dipilih!");
                }
            } else {
                int result = JOptionPane.showConfirmDialog(null, "Apakah yakin Anda akan menghapus Mustahiq?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    int index = this.tblMustahiq.getSelectedRow();
                    int id = cariIdMustahiq(this.tblMustahiq.getValueAt(index, 1).toString());

                    Mustahiq mustahiq = this.mustahiqModel.find(id);
                    this.mustahiqModel.delete(mustahiq);

                    DerajatFuzzy df = this.dfm.find(id);
                    this.dfm.delete(df);
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showConfirmDialog(null, e.getMessage());
        }
        refreshMustahiq();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNamaMustahiq = new javax.swing.JTextField();
        lblHeader = new javax.swing.JLabel();
        btnAddMustahiq = new javax.swing.JButton();
        btnUpdateMustahiq = new javax.swing.JButton();
        btnDeleteMustahiq = new javax.swing.JButton();
        btnRefreshMustahiq = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        tfTanggungan = new javax.swing.JFormattedTextField();
        tfTempatTinggal = new javax.swing.JFormattedTextField();
        tfPendapatan = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        sliderAttitude = new javax.swing.JSlider();
        lblAttitudeMin = new javax.swing.JLabel();
        lblAttitudeMax = new javax.swing.JLabel();
        tfAttitude = new javax.swing.JFormattedTextField();
        jXHeader1 = new org.jdesktop.swingx.JXHeader();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMustahiq = new javax.swing.JTable();
        sliderTempatTinggal = new javax.swing.JSlider();
        lblTimTingMax = new javax.swing.JLabel();
        lblTimTingMin = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tfAlamat = new javax.swing.JTextArea();

        panelImage1.setForeground(new java.awt.Color(0, 0, 0));
        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kelayakanmustahiq/resource/mosque_green.jpg"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Kualitas Tempat Tinggal");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nama Mustahiq");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Jumlah Tanggungan");

        lblHeader.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lblHeader.setForeground(new java.awt.Color(0, 0, 0));
        lblHeader.setText("LIST MUSTAHIQ");

        btnAddMustahiq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kelayakanmustahiq/resource/add-3_24px.png"))); // NOI18N
        btnAddMustahiq.setText("Add");
        btnAddMustahiq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddMustahiq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMustahiqActionPerformed(evt);
            }
        });

        btnUpdateMustahiq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kelayakanmustahiq/resource/save_24px.png"))); // NOI18N
        btnUpdateMustahiq.setText("Update");
        btnUpdateMustahiq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateMustahiq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMustahiqActionPerformed(evt);
            }
        });

        btnDeleteMustahiq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kelayakanmustahiq/resource/trash_24px.png"))); // NOI18N
        btnDeleteMustahiq.setText("Delete");
        btnDeleteMustahiq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteMustahiq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMustahiqActionPerformed(evt);
            }
        });

        btnRefreshMustahiq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kelayakanmustahiq/resource/repeat_24px.png"))); // NOI18N
        btnRefreshMustahiq.setText("Refresh");
        btnRefreshMustahiq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefreshMustahiq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshMustahiqActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Jumlah Pendapatan");

        tfTanggungan.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        tfTempatTinggal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        tfPendapatan.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Attitude");

        sliderAttitude.setPaintLabels(true);
        sliderAttitude.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sliderAttitude.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderAttitudeStateChanged(evt);
            }
        });

        lblAttitudeMin.setForeground(new java.awt.Color(204, 204, 204));
        lblAttitudeMin.setText("0");

        lblAttitudeMax.setForeground(new java.awt.Color(204, 204, 204));
        lblAttitudeMax.setText("100");

        tfAttitude.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        tblMustahiq.setBackground(new java.awt.Color(153, 255, 153));
        tblMustahiq.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMustahiq.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblMustahiq.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMustahiqMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMustahiq);

        sliderTempatTinggal.setPaintLabels(true);
        sliderTempatTinggal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sliderTempatTinggal.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderTempatTinggalStateChanged(evt);
            }
        });

        lblTimTingMax.setText("100");

        lblTimTingMin.setText("0");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Alamat");

        tfAlamat.setColumns(20);
        tfAlamat.setRows(5);
        jScrollPane2.setViewportView(tfAlamat);

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addComponent(jXHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelImage1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(121, 121, 121)
                                    .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                            .addComponent(lblAttitudeMin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblAttitudeMax))
                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                            .addComponent(tfAttitude, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(sliderAttitude, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(37, 37, 37)
                                    .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                            .addComponent(lblTimTingMin, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(146, 146, 146)
                                            .addComponent(lblTimTingMax))
                                        .addComponent(tfPendapatan)))
                                .addGroup(panelImage1Layout.createSequentialGroup()
                                    .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGap(36, 36, 36)
                                    .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tfNamaMustahiq)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                        .addComponent(tfTanggungan)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelImage1Layout.createSequentialGroup()
                                            .addComponent(tfTempatTinggal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(75, 75, 75))
                                        .addComponent(sliderTempatTinggal, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                            .addGroup(panelImage1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnAddMustahiq, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRefreshMustahiq, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelImage1Layout.createSequentialGroup()
                                        .addComponent(btnUpdateMustahiq, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDeleteMustahiq, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeader)
                    .addComponent(jXHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                    .addGroup(panelImage1Layout.createSequentialGroup()
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfNamaMustahiq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfTanggungan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfTempatTinggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderTempatTinggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTimTingMax)
                            .addComponent(lblTimTingMin))
                        .addGap(18, 18, 18)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfPendapatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfAttitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderAttitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAttitudeMax)
                            .addComponent(lblAttitudeMin))
                        .addGap(18, 18, 18)
                        .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddMustahiq)
                            .addComponent(btnUpdateMustahiq)
                            .addComponent(btnDeleteMustahiq))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefreshMustahiq)
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void btnAddMustahiqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMustahiqActionPerformed
        // TODO add your handling code here:
        addMustahiq();
    }//GEN-LAST:event_btnAddMustahiqActionPerformed

    private void btnUpdateMustahiqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMustahiqActionPerformed
        // TODO add your handling code here:
        updateMustahiq();
    }//GEN-LAST:event_btnUpdateMustahiqActionPerformed

    private void btnDeleteMustahiqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMustahiqActionPerformed
        // TODO add your handling code here:
        deleteMustahiq();
    }//GEN-LAST:event_btnDeleteMustahiqActionPerformed

    private void btnRefreshMustahiqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshMustahiqActionPerformed
        // TODO add your handling code here:
        refreshMustahiq();
    }//GEN-LAST:event_btnRefreshMustahiqActionPerformed

    private void sliderAttitudeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderAttitudeStateChanged
        // TODO add your handling code here:
        this.tfAttitude.setText(String.valueOf(this.sliderAttitude.getValue()));
    }//GEN-LAST:event_sliderAttitudeStateChanged

    private void tblMustahiqMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMustahiqMouseClicked
        // TODO add your handling code here:
        btnAddMustahiq.setEnabled(false);
        try {
            int index = this.tblMustahiq.getSelectedRow();
            int id = cariIdMustahiq(this.tblMustahiq.getValueAt(index, 1).toString());
            Mustahiq mustahiq = this.mustahiqModel.find(id);
            DerajatFuzzy df = this.dfm.find(id);

            this.tfNamaMustahiq.setText(mustahiq.getNamaMustahiq());
            this.tfAlamat.setText(mustahiq.getAlamat());
            this.tfTanggungan.setText(String.valueOf(mustahiq.getJumlahTanggungan()));
            this.tfTempatTinggal.setText(String.valueOf(mustahiq.getKualitasTempattinggal()));
            this.sliderTempatTinggal.setValue(mustahiq.getKualitasTempattinggal());
            this.tfPendapatan.setText(String.valueOf(mustahiq.getJumlahPendapatan()));
            this.tfAttitude.setText(String.valueOf(mustahiq.getAttitude()));            
            this.sliderAttitude.setValue(mustahiq.getAttitude());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_tblMustahiqMouseClicked

    private void sliderTempatTinggalStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderTempatTinggalStateChanged
        // TODO add your handling code here:
        this.tfTempatTinggal.setText(String.valueOf(this.sliderTempatTinggal.getValue()));
    }//GEN-LAST:event_sliderTempatTinggalStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMustahiq;
    private javax.swing.JButton btnDeleteMustahiq;
    private javax.swing.JButton btnRefreshMustahiq;
    private javax.swing.JButton btnUpdateMustahiq;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    private javax.swing.JLabel lblAttitudeMax;
    private javax.swing.JLabel lblAttitudeMin;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblTimTingMax;
    private javax.swing.JLabel lblTimTingMin;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private javax.swing.JSlider sliderAttitude;
    private javax.swing.JSlider sliderTempatTinggal;
    private javax.swing.JTable tblMustahiq;
    private javax.swing.JTextArea tfAlamat;
    private javax.swing.JFormattedTextField tfAttitude;
    private javax.swing.JTextField tfNamaMustahiq;
    private javax.swing.JFormattedTextField tfPendapatan;
    private javax.swing.JFormattedTextField tfTanggungan;
    private javax.swing.JFormattedTextField tfTempatTinggal;
    // End of variables declaration//GEN-END:variables
}
