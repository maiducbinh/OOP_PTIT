/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.IOFile;
import controller.ValidException;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DangKy;
import model.Mon;
import model.SinhVien;

/**
 *
 * @author 84912
 */
public class Main extends javax.swing.JFrame {

    private List<Mon> list1;
    private DefaultTableModel tm1;
    private String f1;
    
    private List<SinhVien> list2;
    private DefaultTableModel tm2;
    private String f2;
    
    private List<DangKy> list3;
    private DefaultTableModel tm3;
    private String f3;
    
    private List<DangKy> list4;

    public Main() {
        initComponents();
        setLocationRelativeTo(this);

        // Mon:
        f1 = "src/controller/MH.dat";
        if (new File(f1).exists()) {
            list1 = IOFile.doc(f1);
        } else {
            list1 = new ArrayList<>();
        }
        tm1 = (DefaultTableModel) tb1.getModel();
        docMon();
        setButtonMon(true);
        eventMon();
        
        // Sinh vien:
        f2 = "src/controller/SV.dat";
        if (new File(f2).exists()) {
            list2 = IOFile.doc(f2);
        } else {
            list2 = new ArrayList<>();
        }
        tm2 = (DefaultTableModel) tb2.getModel();
        docSV();
        setButtonSV(true);
        eventSV();
        
        //DKMH
        // Sinh vien:
        f3 = "src/controller/QLDK.dat";
        if (new File(f3).exists()) {
            list3 = IOFile.doc(f3);
        } else {
            list3 = new ArrayList<>();
        }
        tm3 = (DefaultTableModel) tb3.getModel();
        docDK();
        eventDK();
        
        // Lop
        eventTK();
    }

    private void docMon() {
        tm1.setRowCount(0);
        for (Mon i : list1) {
            tm1.addRow(i.toObject());
        }

    }

    private void setButtonMon(boolean b) {
        themBT1.setEnabled(b);
        capnhatBT1.setEnabled(!b);
        boquaBT1.setEnabled(!b);
    }

    private void eventMon() {
        themBT1.addActionListener(e -> {
            maMon.setText(100 + list1.size() + "");
            tenMon.requestFocus();
            setButtonMon(false);
        });

        capnhatBT1.addActionListener(e -> {
            try {
                if (!soTiet.getText().matches("\\d+")) {
                    throw new ValidException("Nhap so");
                }
                Mon x = new Mon(Integer.parseInt(maMon.getText()), tenMon.getText(), Integer.parseInt(soTiet.getText()), loaiCB.getSelectedItem().toString());
                list1.add(x);
                tm1.addRow(x.toObject());
                setButtonMon(true);
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, ex);
                soTiet.setText("");
                soTiet.requestFocus();

            }
        });
        
        suaBT1.addActionListener(e -> {
            int row = tb1.getSelectedRow();
            if(row >= 0 && row < tb1.getRowCount()){
                Mon x = new Mon(Integer.parseInt(maMon.getText()), tenMon.getText(), Integer.parseInt(soTiet.getText()), loaiCB.getSelectedItem().toString());
                list1.set(row, x);
                tm1.removeRow(row);
                tm1.insertRow(row, x.toObject());
                setButtonMon(true);
            }
            else{
                JOptionPane.showMessageDialog(this, "Chon dong de sua");
            }
        });
        
        boquaBT1.addActionListener(e -> {
            setButtonMon(true);
        });
        
        luuBT1.addActionListener(e -> {
            IOFile.viet(f1, list1);
        });

    }
    
    private void docSV() {
        tm2.setRowCount(0);
        for (SinhVien i : list2) {
            tm2.addRow(i.toObject());
        }

    }

    private void setButtonSV(boolean b) {
        themBT2.setEnabled(b);
        capnhatBT2.setEnabled(!b);
        boquaBT2.setEnabled(!b);
    }

    private void eventSV() {
        themBT2.addActionListener(e -> {
            maSV.setText(10000 + list2.size() + "");
            tenSV.requestFocus();
            setButtonSV(false);
        });

        capnhatBT2.addActionListener(e -> {
            try {
                if (!sdtSV.getText().matches("\\d+")) {
                    throw new ValidException("Nhap so");
                }
                SinhVien x = new SinhVien(Integer.parseInt(maSV.getText()), tenSV.getText(), dchiSV.getText(), sdtSV.getText());
                list2.add(x);
                tm2.addRow(x.toObject());
                setButtonSV(true);
                
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, ex);
                sdtSV.setText("");
                sdtSV.requestFocus();

            }
        });

        xoaBT2.addActionListener(e -> {
            int row = tb2.getSelectedRow();
            if (row >= 0 && row < tb2.getRowCount()) {
                list2.remove(row);
                tm2.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de xoa");
            }
        });
        
        boquaBT2.addActionListener(e -> {
            setButtonSV(true);
        });
        
        luuBT2.addActionListener(e -> {
            IOFile.viet(f2, list2);
        });

    }
    
    private void docDK() {
        tm3.setRowCount(0);
        for (DangKy i : list3) {
            tm3.addRow(i.toObject());
        }

    }

    private void eventDK() {
        lammoiBT3.addActionListener(e -> {
            maSVCB.removeAllItems();
            for(SinhVien i: list2)
                maSVCB.addItem(i.getMa() + "");
            
            maMHCB.removeAllItems();
            for(Mon i: list1)
                maMHCB.addItem(i.getMa() + "");
        });
        
        themBT3.addActionListener(e -> {
            int ma1 = Integer.parseInt(maSVCB.getSelectedItem().toString());
            int ma2 = Integer.parseInt(maMHCB.getSelectedItem().toString());
            if(trung(ma1, ma2)){
                JOptionPane.showMessageDialog(this, "Nhap trung ma");
                maSVCB.requestFocus();
                return;
            }
            if(demMaSV(ma1) == 8){
                JOptionPane.showMessageDialog(this, "Hoc qua 8 mon");
                maSVCB.requestFocus();
                return;
            } 
            String date = tgdk.getText();
            if(!date.matches("\\d+/\\d+/\\d+")){
                JOptionPane.showMessageDialog(this, "Nhap lai ngay");
                tgdk.requestFocus();
                return;
            }
            DangKy x = null;
            try {
                x = new DangKy(getMon(ma2), getSV(ma1), date);
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            list3.add(x);
            tm3.addRow(x.toObject());
        });
        
        luuBT3.addActionListener(e -> {
            IOFile.viet(f3, list3);
        });
        

    }
    
    private boolean trung(int ma1, int ma2){
        for(DangKy i: list3)
            if(i.getSinhVien().getMa() == ma1 && i.getMon().getMa() == ma2)
                return true;
        return false;
    }
    
    private int demMaSV(int ma){
        int cnt = 0;
        for(DangKy i: list3)
            if(i.getSinhVien().getMa() == ma)
                cnt++;
        return cnt;
    }
    
    private SinhVien getSV(int ma){
        for(SinhVien i: list2)
            if(i.getMa() == ma)
                return i;
        return null;
    }
    
    private Mon getMon(int ma){
        for(Mon i: list1)
            if(i.getMa() == ma)
                return i;
        return null;
    }
    
    private void eventTK(){
        f3 = "src/controller/QLDK.dat";
        if (new File(f3).exists()) {
            list4 = IOFile.doc(f3);
        } else {
            list4 = new ArrayList<>();
        }
        thongkeBT.addActionListener(e -> {
            list4.sort(new Comparator<DangKy>(){
                @Override
                public int compare(DangKy x, DangKy y) {
                    return x.getDate().compareTo(y.getDate());
                }
                
            });
            
            Map<String, Integer> mp = list4.stream().collect(Collectors.groupingBy(DangKy::vietTK, Collectors.summingInt(DangKy::getSV)));
            TA.append("Ten mon: \t So luong SV\n");
            for(String i: mp.keySet()){
                if(mp.get(i) > 30)
                    TA.append(i + " " + 30);
                else TA.append(i + "\t" + mp.get(i) + "\n");
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        maMon = new javax.swing.JTextField();
        tenMon = new javax.swing.JTextField();
        soTiet = new javax.swing.JTextField();
        themBT1 = new javax.swing.JButton();
        capnhatBT1 = new javax.swing.JButton();
        suaBT1 = new javax.swing.JButton();
        boquaBT1 = new javax.swing.JButton();
        luuBT1 = new javax.swing.JButton();
        loaiCB = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        maSV = new javax.swing.JTextField();
        tenSV = new javax.swing.JTextField();
        dchiSV = new javax.swing.JTextField();
        sdtSV = new javax.swing.JTextField();
        themBT2 = new javax.swing.JButton();
        capnhatBT2 = new javax.swing.JButton();
        xoaBT2 = new javax.swing.JButton();
        boquaBT2 = new javax.swing.JButton();
        luuBT2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tgdk = new javax.swing.JTextField();
        themBT3 = new javax.swing.JButton();
        luuBT3 = new javax.swing.JButton();
        lammoiBT3 = new javax.swing.JButton();
        maSVCB = new javax.swing.JComboBox<>();
        maMHCB = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA = new javax.swing.JTextArea();
        thongkeBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setText("Ma mon:");

        jLabel6.setText("Ten mon:");

        jLabel7.setText("Tong so tiet:");

        jLabel8.setText("Loai mon hoc:");

        maMon.setEditable(false);

        themBT1.setText("Them");

        capnhatBT1.setText("Cap nhat");

        suaBT1.setText("Sua");
        suaBT1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suaBT1MouseClicked(evt);
            }
        });

        boquaBT1.setText("Bo qua");

        luuBT1.setText("Luu");

        loaiCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đại cương", "Cơ sở ngành", "Chuyên ngành bắt buộc", "Chuyên ngành tự chọn" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(luuBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maMon, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(tenMon)
                            .addComponent(soTiet)
                            .addComponent(loaiCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(themBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capnhatBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(suaBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boquaBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(maMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themBT1))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capnhatBT1))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(soTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boquaBT1))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(suaBT1)
                    .addComponent(loaiCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(luuBT1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma mon", "Ten mon", "Tong so tiet", "Loai mon hoc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Mon hoc", jPanel1);

        jLabel9.setText("MaSV:");

        jLabel10.setText("Ho va ten:");

        jLabel11.setText("Dia chi:");

        jLabel12.setText("So dien thoai:");

        maSV.setEditable(false);

        themBT2.setText("Them");

        capnhatBT2.setText("Cap nhat");

        xoaBT2.setText("Xoa");

        boquaBT2.setText("Bo qua");

        luuBT2.setText("Luu");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(luuBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maSV)
                            .addComponent(tenSV)
                            .addComponent(dchiSV)
                            .addComponent(sdtSV, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(themBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(capnhatBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(xoaBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boquaBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(maSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themBT2))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capnhatBT2))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(dchiSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boquaBT2))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(sdtSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoaBT2))
                .addGap(18, 18, 18)
                .addComponent(luuBT2)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MaSV", "Ho va ten", "Dia chi", "So dien thoai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tb2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sinh vien", jPanel2);

        jLabel13.setText("MaSV:");

        jLabel14.setText("Ma MH:");

        jLabel15.setText("Thoi gian dang ky:");

        themBT3.setText("Them");

        luuBT3.setText("Luu");

        lammoiBT3.setText("Lam moi");

        maSVCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maMHCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Theo tên sinh viên");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Theo thời gian đăng ký");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Sap xep:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel1))
                .addGap(47, 47, 47)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tgdk, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                    .addComponent(maSVCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maMHCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(themBT3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(luuBT3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lammoiBT3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(themBT3)
                            .addComponent(maSVCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(luuBT3)
                            .addComponent(maMHCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tgdk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lammoiBT3))
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton1))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        tb3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma SV", "Ho va ten", "Ma MH", "Thoi gian dang ky"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tb3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Bang dang ky", jPanel3);

        TA.setColumns(20);
        TA.setRows(5);
        jScrollPane1.setViewportView(TA);

        thongkeBT.setText("Thong ke lop hoc");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(thongkeBT)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(thongkeBT)
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lop hoc", jPanel4);

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
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void suaBT1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suaBT1MouseClicked

    }//GEN-LAST:event_suaBT1MouseClicked

    private void tb1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1MouseClicked
        int row = tb1.getSelectedRow();
        if(row >= 0 && row < tb1.getRowCount()){
            maMon.setText(tm1.getValueAt(row, 0).toString());
            tenMon.setText(tm1.getValueAt(row, 1).toString());
            soTiet.setText(tm1.getValueAt(row, 2).toString());
            
            for(int i = 0; i < loaiCB.getItemCount(); i++)
                if(loaiCB.getItemAt(i).equals(tm1.getValueAt(row, 3).toString()))
                    loaiCB.setSelectedIndex(i);
        }
    }//GEN-LAST:event_tb1MouseClicked

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        list3.sort(new Comparator<DangKy>(){
            @Override
            public int compare(DangKy x, DangKy y) {
                String a[] = x.getSinhVien().getTen().split(" ");
                String b[] = y.getSinhVien().getTen().split(" ");
                String ten1 = a[a.length - 1] + x;
                String ten2 = b[b.length - 1] + y;
                return ten1.compareToIgnoreCase(ten2);
            }
        });
        
        tm3.setRowCount(0);
        for (DangKy i : list3) {
            tm3.addRow(i.toObject());
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        list3.sort(new Comparator<DangKy>(){
            @Override
            public int compare(DangKy x, DangKy y) {
                return x.getDate().compareTo(y.getDate());
            }
        });
        
        tm3.setRowCount(0);
        for (DangKy i : list3) {
            tm3.addRow(i.toObject());
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

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
    private javax.swing.JTextArea TA;
    private javax.swing.JButton boquaBT1;
    private javax.swing.JButton boquaBT2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton capnhatBT1;
    private javax.swing.JButton capnhatBT2;
    private javax.swing.JTextField dchiSV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton lammoiBT3;
    private javax.swing.JComboBox<String> loaiCB;
    private javax.swing.JButton luuBT1;
    private javax.swing.JButton luuBT2;
    private javax.swing.JButton luuBT3;
    private javax.swing.JComboBox<String> maMHCB;
    private javax.swing.JTextField maMon;
    private javax.swing.JTextField maSV;
    private javax.swing.JComboBox<String> maSVCB;
    private javax.swing.JTextField sdtSV;
    private javax.swing.JTextField soTiet;
    private javax.swing.JButton suaBT1;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTextField tenMon;
    private javax.swing.JTextField tenSV;
    private javax.swing.JTextField tgdk;
    private javax.swing.JButton themBT1;
    private javax.swing.JButton themBT2;
    private javax.swing.JButton themBT3;
    private javax.swing.JButton thongkeBT;
    private javax.swing.JButton xoaBT2;
    // End of variables declaration//GEN-END:variables
}
