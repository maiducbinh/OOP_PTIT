/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.IOFile;
import controller.ValidException;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BangChamCong;
import model.CongNhan;
import model.Xuong;

/**
 *
 * @author 84912
 */
public class Main extends javax.swing.JFrame {

    private List<CongNhan> list1;
    private DefaultTableModel tmCN;
    private String fCN;

    private List<Xuong> list2;
    private DefaultTableModel tmX;
    private String fX;
    
    private List<BangChamCong> list3;
    private DefaultTableModel tmBCC;
    private String fBCC;

    public Main() {
        initComponents();
        fCN = "src/controller/CN.dat";
        if (new File(fCN).exists()) {
            list1 = IOFile.doc(fCN);
        } else {
            list1 = new ArrayList<>();
        }
        tmCN = (DefaultTableModel) tbCN.getModel();
        docCN();
        setButtonCN(true);
        eventCN();

        fX = "src/controller/XUONG.dat";
        if (new File(fX).exists()) {
            list2 = IOFile.doc(fX);
        } else {
            list2 = new ArrayList<>();
        }
        tmX = (DefaultTableModel) tbXuong.getModel();
        docX();
        setButtonX(true);
        eventX();
        
        fBCC = "src/controller/BANGCHAMCONG.dat";
        if (new File(fBCC).exists()) {
            list3 = IOFile.doc(fBCC);
        } else {
            list3 = new ArrayList<>();
        }
        tmBCC = (DefaultTableModel) tbBCC.getModel();
        docBCC();
        eventBCC();
        
        eventTK();
    }

    private void docCN() {
        tmCN.setRowCount(0);
        for (CongNhan iCongNhan : list1) {
            tmCN.addRow(iCongNhan.toObject());
        }
    }

    private void setButtonCN(boolean b) {
        themCN.setEnabled(b);
        capnhatCN.setEnabled(!b);
        boquaCN.setEnabled(!b);
    }

    private void eventCN() {
        themCN.addActionListener(e -> {
            maCN.setText(1000 + list1.size() + "");
            tenCN.requestFocus();
            setButtonCN(false);
        });
        capnhatCN.addActionListener(e -> {
            try {
                if (!dthoaiCN.getText().matches("\\d+")) {
                    throw new ValidException("Nhap so");
                }
                CongNhan x = new CongNhan(Integer.parseInt(maCN.getText()), tenCN.getText(), dchiCN.getText(), dthoaiCN.getText(), Integer.parseInt(bacCN.getSelectedItem().toString()));
                list1.add(x);
                tmCN.addRow(x.toObject());
                setButtonCN(true);
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, ex);
                dthoaiCN.setText("");
                dthoaiCN.requestFocus();
            }
        });

        boquaCN.addActionListener(e -> {
            setButtonCN(true);
        });

        xoaCN.addActionListener(e -> {
            int row = tbCN.getSelectedRow();
            if (row >= 0 && row < tbCN.getRowCount()) {
                list1.remove(row);
                tmCN.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de xoa");
            }
        });

        luuCN.addActionListener(e -> {
            IOFile.viet(fCN, list1);
        });
    }

    private void docX() {
        tmX.setRowCount(0);
        for (Xuong i : list2) {
            tmX.addRow(i.toObject());
        }
    }

    private void setButtonX(boolean b) {
        themX.setEnabled(b);
        capnhatX.setEnabled(!b);
        boquaX.setEnabled(!b);
    }

    private void eventX() {
        themX.addActionListener(e -> {
            maX.setText(100 + list2.size() + "");
            tenX.requestFocus();
            setButtonX(false);
        });
        capnhatX.addActionListener(e -> {
            Xuong x = new Xuong(Integer.parseInt(maX.getText()),
                    tenX.getText(), Integer.parseInt(hesoX.getSelectedItem().toString()));
            list2.add(x);
            tmX.addRow(x.toObject());
            setButtonX(true);
        });

        boquaX.addActionListener(e -> {
            setButtonCN(true);
        });

        suaX.addActionListener(e -> {
            int row = tbXuong.getSelectedRow();
            if (row >= 0 && row < tbXuong.getRowCount()) {
                Xuong x = new Xuong(Integer.parseInt(maX.getText()),
                        tenX.getText(), Integer.parseInt(hesoX.getSelectedItem().toString()));
                list2.add(x);
                tmX.removeRow(row);
                tmX.insertRow(row, x.toObject());
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de sua");
            }
        });

        luuX.addActionListener(e -> {
            IOFile.viet(fX, list2);
        });
    }
    
    private void docBCC() {
        tmBCC.setRowCount(0);
        for (BangChamCong iCongNhan : list3) {
            tmBCC.addRow(iCongNhan.toObject());
        }
    }

    private void eventBCC() {
        refresh.addActionListener(e -> {
            maCNCB.removeAllItems();
            for(CongNhan iCongNhan: list1)
                maCNCB.addItem(iCongNhan.getMa() + "");
            maXCB.removeAllItems();
            for(Xuong iCongNhan: list2)
                maXCB.addItem(iCongNhan.getMa() + "");
        });
        
        themBCC.addActionListener(e -> {
            try{
                int ma1 = Integer.parseInt(maCNCB.getSelectedItem().toString());
                int ma2 = Integer.parseInt(maXCB.getSelectedItem().toString());
                int soNgay = Integer.parseInt(songay.getText());
                if(getSoNgay(ma1) + soNgay > 31){
                    JOptionPane.showMessageDialog(this, "Lam viec qua 31 ngay");
                }
                else
                {
                    BangChamCong x = new BangChamCong(getCongNhan(ma1), getXuong(ma2), soNgay);
                    list3.add(x);
                    tmBCC.addRow(x.toObject());
                    
                }
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this, "Nhap so");
            }
        });

        luuBCC.addActionListener(e -> {
            IOFile.viet(fBCC, list3);
        });
        
        sxBCC.addActionListener(e -> {
            int index = sapxep.getSelectedIndex();
            if(index == 0) {
                list3.sort(new Comparator<BangChamCong>(){
                    @Override
                    public int compare(BangChamCong x, BangChamCong y) {
                        String t1[] = x.getCongNhan().getTen().split("\\s+");
                        String t2[] = y.getCongNhan().getTen().split("\\s+");
                        String ten1 = t1[t1.length - 1] + x;
                        String ten2 = t2[t2.length - 1] + y;
                        return ten1.compareToIgnoreCase(ten2);
                    }
                
                });
            }
            else 
            {
                list3.sort(new Comparator<BangChamCong>(){
                    @Override
                    public int compare(BangChamCong o1, BangChamCong o2) {
                        return o1.getSoNgay() - o2.getSoNgay();
                    }
                    
                });
            }
            tmBCC.setRowCount(0);
            for(BangChamCong iBangChamCong: list3)
                tmBCC.addRow(iBangChamCong.toObject());
        });
    }
    
    private int getSoNgay(int ma){
        int ngay = 0;
        for(BangChamCong i: list3)
            if(i.getCongNhan().getMa() == ma)
                ngay += i.getSoNgay();
        return ngay;
    }
    
    private CongNhan getCongNhan(int ma){
        for(CongNhan i: list1)
            if(i.getMa() == ma)
                return i;
        return null;
    }
    
    private Xuong getXuong(int ma){
        for(Xuong i: list2)
            if(i.getMa() == ma)
                return i;
        return null;
    }
    
    private void eventTK(){
        thongkeBT.addActionListener(e -> {
            Map<String, Integer> mp = list3.stream().collect(Collectors.groupingBy(BangChamCong::vietTK, Collectors.summingInt(BangChamCong::thuNhap)));
            thongkeTB.setText(mp.toString());
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCN = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        maCN = new javax.swing.JTextField();
        tenCN = new javax.swing.JTextField();
        dchiCN = new javax.swing.JTextField();
        dthoaiCN = new javax.swing.JTextField();
        bacCN = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        themCN = new javax.swing.JButton();
        capnhatCN = new javax.swing.JButton();
        boquaCN = new javax.swing.JButton();
        xoaCN = new javax.swing.JButton();
        luuCN = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbXuong = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        maX = new javax.swing.JTextField();
        tenX = new javax.swing.JTextField();
        hesoX = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        themX = new javax.swing.JButton();
        capnhatX = new javax.swing.JButton();
        boquaX = new javax.swing.JButton();
        suaX = new javax.swing.JButton();
        luuX = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbBCC = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        maCNCB = new javax.swing.JComboBox<>();
        maXCB = new javax.swing.JComboBox<>();
        songay = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        sapxep = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        themBCC = new javax.swing.JButton();
        luuBCC = new javax.swing.JButton();
        sxBCC = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        thongkeTB = new javax.swing.JTextArea();
        thongkeBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbCN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ma", "Ho va ten", "Dia chi", "Dien thoai", "Bac"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCN);
        if (tbCN.getColumnModel().getColumnCount() > 0) {
            tbCN.getColumnModel().getColumn(4).setResizable(false);
            tbCN.getColumnModel().getColumn(4).setHeaderValue("Bac");
        }

        jLabel1.setText("Ma:");

        jLabel2.setText("Ho va ten:");

        jLabel3.setText("Dia chi:");

        jLabel4.setText("Dien thoai:");

        jLabel5.setText("Bac:");

        maCN.setEditable(false);

        tenCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenCNActionPerformed(evt);
            }
        });

        dchiCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dchiCNActionPerformed(evt);
            }
        });

        bacCN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7" }));
        bacCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bacCNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel5))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(bacCN, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 135, Short.MAX_VALUE))
                    .addComponent(maCN)
                    .addComponent(tenCN)
                    .addComponent(dchiCN)
                    .addComponent(dthoaiCN))
                .addGap(38, 38, 38))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(maCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tenCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dchiCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dthoaiCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(bacCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        themCN.setText("Them");
        themCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themCNActionPerformed(evt);
            }
        });

        capnhatCN.setText("Cap nhat");
        capnhatCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatCNActionPerformed(evt);
            }
        });

        boquaCN.setText("Bo qua");

        xoaCN.setText("Xoa");

        luuCN.setText("Luu");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(luuCN, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoaCN, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boquaCN, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capnhatCN, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themCN, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(themCN)
                .addGap(18, 18, 18)
                .addComponent(capnhatCN)
                .addGap(18, 18, 18)
                .addComponent(boquaCN)
                .addGap(18, 18, 18)
                .addComponent(xoaCN)
                .addGap(18, 18, 18)
                .addComponent(luuCN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cong nhan", jPanel1);

        tbXuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ma", "Ten xuong", "He so"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbXuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbXuongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbXuong);

        jLabel6.setText("Ma:");

        jLabel7.setText("Ten xuong:");

        jLabel10.setText("He so:");

        maX.setEditable(false);

        tenX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenXActionPerformed(evt);
            }
        });

        hesoX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", " " }));
        hesoX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hesoXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(hesoX, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 135, Short.MAX_VALUE))
                    .addComponent(maX)
                    .addComponent(tenX))
                .addGap(38, 38, 38))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(maX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tenX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(hesoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        themX.setText("Them");
        themX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themXActionPerformed(evt);
            }
        });

        capnhatX.setText("Cap nhat");
        capnhatX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capnhatXActionPerformed(evt);
            }
        });

        boquaX.setText("Bo qua");

        suaX.setText("Sua");
        suaX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaXActionPerformed(evt);
            }
        });

        luuX.setText("Luu");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(luuX, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suaX, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boquaX, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capnhatX, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themX, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(themX)
                .addGap(18, 18, 18)
                .addComponent(capnhatX)
                .addGap(18, 18, 18)
                .addComponent(boquaX)
                .addGap(18, 18, 18)
                .addComponent(suaX)
                .addGap(18, 18, 18)
                .addComponent(luuX)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Xuong", jPanel2);

        tbBCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma cong nhan", "Ho va ten", "Ma xuong", "So ngay"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbBCC);

        jLabel14.setText("Ma cong nhan:");

        jLabel15.setText("Ma xuong:");

        jLabel16.setText("So ngay:");

        maCNCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maXCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        maXCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maXCBActionPerformed(evt);
            }
        });

        songay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                songayActionPerformed(evt);
            }
        });

        jLabel8.setText("Sap xep");

        sapxep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ho ten cong nhan", "So ngay lam viec" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel8))
                .addGap(59, 59, 59)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maCNCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maXCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(songay)
                    .addComponent(sapxep, 0, 158, Short.MAX_VALUE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(maCNCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(maXCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(songay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(sapxep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        themBCC.setText("Them");
        themBCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themBCCActionPerformed(evt);
            }
        });

        luuBCC.setText("Luu ");
        luuBCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luuBCCActionPerformed(evt);
            }
        });

        sxBCC.setText("Sap xep");

        refresh.setText("Lam moi");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sxBCC, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(luuBCC, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themBCC, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(themBCC)
                .addGap(18, 18, 18)
                .addComponent(luuBCC)
                .addGap(18, 18, 18)
                .addComponent(sxBCC)
                .addGap(18, 18, 18)
                .addComponent(refresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bang cham cong", jPanel3);

        thongkeTB.setColumns(20);
        thongkeTB.setRows(5);
        jScrollPane4.setViewportView(thongkeTB);

        thongkeBT.setText("Thong ke");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thongkeBT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(thongkeBT)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thong ke", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void capnhatCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatCNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capnhatCNActionPerformed

    private void themCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themCNActionPerformed

    }//GEN-LAST:event_themCNActionPerformed

    private void bacCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bacCNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bacCNActionPerformed

    private void dchiCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dchiCNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dchiCNActionPerformed

    private void tenCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenCNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenCNActionPerformed

    private void themXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_themXActionPerformed

    private void capnhatXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capnhatXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capnhatXActionPerformed

    private void hesoXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hesoXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hesoXActionPerformed

    private void tenXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenXActionPerformed

    private void suaXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaXActionPerformed
        
    }//GEN-LAST:event_suaXActionPerformed

    private void tbXuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbXuongMouseClicked
        int row = tbXuong.getSelectedRow();
        if (row >= 0 && row < tbXuong.getRowCount()) {
            maX.setText(tmX.getValueAt(row, 0).toString());
            tenX.setText(tmX.getValueAt(row, 1).toString());
            for (int i = 0; i < hesoX.getItemCount(); i++) {
                if (hesoX.getItemAt(i).equals(tmX.getValueAt(row, 2).toString())) {
                    hesoX.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_tbXuongMouseClicked

    private void themBCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themBCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_themBCCActionPerformed

    private void luuBCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luuBCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_luuBCCActionPerformed

    private void songayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_songayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_songayActionPerformed

    private void maXCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maXCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maXCBActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> bacCN;
    private javax.swing.JButton boquaCN;
    private javax.swing.JButton boquaX;
    private javax.swing.JButton capnhatCN;
    private javax.swing.JButton capnhatX;
    private javax.swing.JTextField dchiCN;
    private javax.swing.JTextField dthoaiCN;
    private javax.swing.JComboBox<String> hesoX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton luuBCC;
    private javax.swing.JButton luuCN;
    private javax.swing.JButton luuX;
    private javax.swing.JTextField maCN;
    private javax.swing.JComboBox<String> maCNCB;
    private javax.swing.JTextField maX;
    private javax.swing.JComboBox<String> maXCB;
    private javax.swing.JButton refresh;
    private javax.swing.JComboBox<String> sapxep;
    private javax.swing.JTextField songay;
    private javax.swing.JButton suaX;
    private javax.swing.JButton sxBCC;
    private javax.swing.JTable tbBCC;
    private javax.swing.JTable tbCN;
    private javax.swing.JTable tbXuong;
    private javax.swing.JTextField tenCN;
    private javax.swing.JTextField tenX;
    private javax.swing.JButton themBCC;
    private javax.swing.JButton themCN;
    private javax.swing.JButton themX;
    private javax.swing.JButton thongkeBT;
    private javax.swing.JTextArea thongkeTB;
    private javax.swing.JButton xoaCN;
    // End of variables declaration//GEN-END:variables
}
