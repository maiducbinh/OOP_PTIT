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
import model.Phong;
import model.SinhVien;

/**
 *
 * @author 84912
 */
public class Main extends javax.swing.JFrame {

    private List<SinhVien> list1;
    private DefaultTableModel tm1;
    private String f1;

    private List<Phong> list2;
    private DefaultTableModel tm2;
    private String f2;

    private List<DangKy> list3;
    private DefaultTableModel tm3;
    private String f3;

    public Main() {
        initComponents();
        setLocationRelativeTo(this);

        // Sinh vien:
        f1 = "src/controller/SV.dat";
        if (new File(f1).exists()) {
            list1 = IOFile.doc(f1);
        } else {
            list1 = new ArrayList<>();
        }
        tm1 = (DefaultTableModel) tb1.getModel();
        setButtonSV(true);
        docSV();
        eventSV();

        f2 = "src/controller/PHONG.dat";
        if (new File(f2).exists()) {
            list2 = IOFile.doc(f2);
        } else {
            list2 = new ArrayList<>();
        }
        tm2 = (DefaultTableModel) tb2.getModel();
        setButtonP(true);
        docP();
        eventP();
        
        f3 = "src/controller/DSKTX.dat";
        if (new File(f3).exists()) {
            list3 = IOFile.doc(f3);
        } else {
            list3 = new ArrayList<>();
        }
        tm3 = (DefaultTableModel) tb3.getModel();
        docKTX();
        eventKTX();
        
        eventTK();
    }

    private void setButtonSV(boolean b) {
        them1.setEnabled(b);
        capnhat1.setEnabled(!b);
        boqua1.setEnabled(!b);
    }

    private void docSV() {
        tm1.setRowCount(0);
        for (SinhVien i : list1) {
            tm1.addRow(i.toObject());
        }
    }

    private void eventSV() {
        them1.addActionListener(e -> {
            ma1.setText(list1.size() + 10000 + "");
            ten1.requestFocus();
            setButtonSV(false);
        });

        capnhat1.addActionListener(e -> {
            try {
                if (!ngay1.getText().matches("\\d+/\\d+/\\d+")) {
                    throw new ValidException("Nhap lai ngay sinh");
                }
                SinhVien x = new SinhVien(Integer.parseInt(ma1.getText()), ten1.getText(), dchi1.getText(), ngay1.getText(), lop1.getText());
                list1.add(x);
                tm1.addRow(x.toObject());
                setButtonSV(true);
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        boqua1.addActionListener(e -> {
            setButtonSV(true);
        });

        xoa1.addActionListener(e -> {
            int row = tb1.getSelectedRow();
            if (row >= 0 && row < tb1.getRowCount()) {
                list1.remove(row);
                tm1.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chom dong de xoa");
            }
        });

        luu1.addActionListener(e -> {
            IOFile.viet(f1, list1);
        });
    }

    private void setButtonP(boolean b) {
        them2.setEnabled(b);
        capnhat2.setEnabled(!b);
        boqua2.setEnabled(!b);
    }

    private void docP() {
        tm2.setRowCount(0);
        for (Phong i : list2) {
            tm2.addRow(i.toObject());
        }
    }

    private void eventP() {
        them2.addActionListener(e -> {
            ma2.setText(list2.size() + 100 + "");
            ten2.requestFocus();
            setButtonP(false);
        });

        capnhat2.addActionListener(e -> {
            Phong x = new Phong(Integer.parseInt(ma2.getText()), ten2.getText(), loai2.getSelectedItem().toString());
            list2.add(x);
            tm2.addRow(x.toObject());
            setButtonP(true);
        });

        boqua2.addActionListener(e -> {
            setButtonP(true);
        });

        xoa2.addActionListener(e -> {
            int row = tb1.getSelectedRow();
            if (row >= 0 && row < tb1.getRowCount()) {
                list2.remove(row);
                tm2.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chom dong de xoa");
            }
        });

        luu2.addActionListener(e -> {
            IOFile.viet(f2, list2);
        });

        sua2.addActionListener(e -> {
            int row = tb2.getSelectedRow();
            if (row >= 0 && row < tb2.getRowCount()) {
                Phong x = new Phong(Integer.parseInt(ma2.getText()), ten2.getText(), loai2.getSelectedItem().toString());
                list2.set(row, x);
                tm2.removeRow(row);
                tm2.addRow(x.toObject());
            } else {
                JOptionPane.showMessageDialog(this, "Chom dong de sua");
            }
        });
    }
    
    private void docKTX() {
        tm3.setRowCount(0);
        for (DangKy i : list3) {
            tm3.addRow(i.toObject());
        }
    }

    private void eventKTX() {
        lammoi3.addActionListener(e -> {
            maSVCB.removeAllItems();
            for(SinhVien i: list1)
                maSVCB.addItem(i.getMa() + "");
            maPCB.removeAllItems();
            for(Phong i: list2)
                maPCB.addItem(i.getMa() + "");
        });
        
        
        them3.addActionListener(e -> {
            int masv = Integer.parseInt(maSVCB.getSelectedItem().toString());
            int map = Integer.parseInt(maPCB.getSelectedItem().toString());
            if(getPhong(map).getNum() == 0){
                JOptionPane.showMessageDialog(this, "Phong du 8 nguoi");
                maPCB.requestFocus();
                return;
            }
            try {
                if (!ngay3.getText().matches("\\d+/\\d+/\\d+")) {
                    throw new ValidException("Nhap lai ngay vao phong");
                }
                DangKy x = new DangKy(getSV(masv), getPhong(map), ngay3.getText());
                getPhong(map).setNum(getPhong(map).getNum() - 1);
                tm3.addRow(x.toObject());
                list3.add(x);
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        luu3.addActionListener(e -> {
            IOFile.viet(f3, list3);
        });
    }
    
    private SinhVien getSV(int ma){
        for(SinhVien i: list1)
            if(i.getMa() == ma)
                return i;
        return null;
    }
    
    private Phong getPhong(int ma){
        for(Phong i: list2)
            if(i.getMa() == ma)
                return i;
        return null;
    }
    
    private void eventTK(){
        thongke.addActionListener(e -> {
            Map<String, Integer> mp = list3.stream().collect(Collectors.groupingBy(DangKy::vietTK, Collectors.summingInt(DangKy::phi)));
            for(String i: mp.keySet())
                TA.append(i + "\t" + mp.get(i) + "\n");
            
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ma1 = new javax.swing.JTextField();
        ten1 = new javax.swing.JTextField();
        dchi1 = new javax.swing.JTextField();
        ngay1 = new javax.swing.JTextField();
        lop1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        them1 = new javax.swing.JButton();
        capnhat1 = new javax.swing.JButton();
        boqua1 = new javax.swing.JButton();
        xoa1 = new javax.swing.JButton();
        luu1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ma2 = new javax.swing.JTextField();
        ten2 = new javax.swing.JTextField();
        loai2 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        them2 = new javax.swing.JButton();
        capnhat2 = new javax.swing.JButton();
        boqua2 = new javax.swing.JButton();
        xoa2 = new javax.swing.JButton();
        luu2 = new javax.swing.JButton();
        sua2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        maSVCB = new javax.swing.JComboBox<>();
        maPCB = new javax.swing.JComboBox<>();
        ngay3 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        them3 = new javax.swing.JButton();
        luu3 = new javax.swing.JButton();
        lammoi3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TA = new javax.swing.JTextArea();
        thongke = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ma", "Ho ten", "Dia chi", "Ngay sinh", "Lop"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb1);
        if (tb1.getColumnModel().getColumnCount() > 0) {
            tb1.getColumnModel().getColumn(3).setHeaderValue("Ngay sinh");
            tb1.getColumnModel().getColumn(4).setResizable(false);
            tb1.getColumnModel().getColumn(4).setHeaderValue("Lop");
        }

        jLabel1.setText("Ma:");

        jLabel2.setText("Ho ten:");

        jLabel3.setText("Dia chi:");

        jLabel4.setText("Ngay sinh:");

        jLabel5.setText("Lop:");

        ma1.setEditable(false);

        ten1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ten1ActionPerformed(evt);
            }
        });

        ngay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ngay1ActionPerformed(evt);
            }
        });

        lop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lop1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(35, 35, 35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ma1)
                    .addComponent(ten1)
                    .addComponent(dchi1)
                    .addComponent(ngay1)
                    .addComponent(lop1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ten1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dchi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ngay1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lop1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        them1.setText("Them");

        capnhat1.setText("Cap nhat");

        boqua1.setText("Bo qua");

        xoa1.setText("Xoa");
        xoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa1ActionPerformed(evt);
            }
        });

        luu1.setText("Luu");
        luu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(luu1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boqua1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capnhat1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(them1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(them1)
                .addGap(18, 18, 18)
                .addComponent(capnhat1)
                .addGap(18, 18, 18)
                .addComponent(boqua1)
                .addGap(18, 18, 18)
                .addComponent(xoa1)
                .addGap(18, 18, 18)
                .addComponent(luu1)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Sinh vien", jPanel1);

        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Ma", "Ten phong", "Loai phong"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb2);

        jLabel6.setText("Ma:");

        jLabel7.setText("Ten phong:");

        jLabel8.setText("Loai phong:");

        ma2.setEditable(false);

        ten2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ten2ActionPerformed(evt);
            }
        });

        loai2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phòng VIP", "Chất lượng cao", "Thường" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(35, 35, 35)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ma2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(ten2)
                    .addComponent(loai2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ten2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(loai2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        them2.setText("Them");

        capnhat2.setText("Cap nhat");

        boqua2.setText("Bo qua");

        xoa2.setText("Xoa");
        xoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoa2ActionPerformed(evt);
            }
        });

        luu2.setText("Luu");
        luu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luu2ActionPerformed(evt);
            }
        });

        sua2.setText("Sua");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sua2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(luu2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boqua2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capnhat2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(them2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(them2)
                .addGap(18, 18, 18)
                .addComponent(capnhat2)
                .addGap(18, 18, 18)
                .addComponent(boqua2)
                .addGap(18, 18, 18)
                .addComponent(xoa2)
                .addGap(18, 18, 18)
                .addComponent(luu2)
                .addGap(18, 18, 18)
                .addComponent(sua2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Phong", jPanel2);

        tb3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ma SV", "Ho ten", "Ma phong", "Ten phong", "Ngay vao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb3);

        jLabel9.setText("Ma SV:");

        jLabel10.setText("Ma phong:");

        jLabel11.setText("Ngay vao:");

        maSVCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maPCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel12.setText("Sap xep:");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Theo ho ten sinh vien");
        jRadioButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton1MouseClicked(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Theo ten phong");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(maSVCB, 0, 148, Short.MAX_VALUE)
                                .addComponent(maPCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ngay3))
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(114, 114, 114))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(maSVCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(maPCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ngay3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addGap(42, 42, 42)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        them3.setText("Them");

        luu3.setText("Luu");
        luu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luu3ActionPerformed(evt);
            }
        });

        lammoi3.setText("Lam moi");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lammoi3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(luu3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(them3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(them3)
                .addGap(18, 18, 18)
                .addComponent(luu3)
                .addGap(18, 18, 18)
                .addComponent(lammoi3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Danh sach KTX", jPanel3);

        TA.setColumns(20);
        TA.setRows(5);
        jScrollPane4.setViewportView(TA);

        thongke.setText("Thong ke");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(thongke)
                .addContainerGap(217, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void xoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xoa1ActionPerformed

    private void luu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_luu1ActionPerformed

    private void ten1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ten1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ten1ActionPerformed

    private void ngay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ngay1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ngay1ActionPerformed

    private void lop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lop1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lop1ActionPerformed

    private void ten2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ten2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ten2ActionPerformed

    private void xoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoa2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xoa2ActionPerformed

    private void luu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_luu2ActionPerformed

    private void tb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb2MouseClicked
        int row = tb2.getSelectedRow();
        if (row >= 0 && row < tb2.getRowCount()) {
            ma2.setText(tm2.getValueAt(row, 0).toString());
            ten2.setText(tm2.getValueAt(row, 1).toString());

            for (int i = 0; i < loai2.getItemCount(); i++) {
                if (loai2.getItemAt(i).equals(tm2.getValueAt(row, 2).toString())) {
                    loai2.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_tb2MouseClicked

    private void tb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb3MouseClicked

    private void luu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_luu3ActionPerformed

    private void jRadioButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton1MouseClicked
        list3.sort(new Comparator<DangKy>(){
            @Override
            public int compare(DangKy x, DangKy y) {
                String a[] = x.getSinhVien().getTen().split("\\s+");
                String b[] = y.getSinhVien().getTen().split("\\s+");
                String ten1 = a[a.length - 1] + x;
                String ten2 = b[b.length - 1] + x;
                return ten1.compareToIgnoreCase(ten2);
            }
            
        });
        docKTX();
    }//GEN-LAST:event_jRadioButton1MouseClicked

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        list3.sort(new Comparator<DangKy>(){
            @Override
            public int compare(DangKy x, DangKy y) {
                String a[] = x.getPhong().getTen().split("\\s+");
                String b[] = y.getPhong().getTen().split("\\s+");
                String ten1 = a[a.length - 1] + x;
                String ten2 = b[b.length - 1] + x;
                return ten1.compareToIgnoreCase(ten2);
            }
            
        });
        docKTX();
    }//GEN-LAST:event_jRadioButton2MouseClicked

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
    private javax.swing.JButton boqua1;
    private javax.swing.JButton boqua2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton capnhat1;
    private javax.swing.JButton capnhat2;
    private javax.swing.JTextField dchi1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton lammoi3;
    private javax.swing.JComboBox<String> loai2;
    private javax.swing.JTextField lop1;
    private javax.swing.JButton luu1;
    private javax.swing.JButton luu2;
    private javax.swing.JButton luu3;
    private javax.swing.JTextField ma1;
    private javax.swing.JTextField ma2;
    private javax.swing.JComboBox<String> maPCB;
    private javax.swing.JComboBox<String> maSVCB;
    private javax.swing.JTextField ngay1;
    private javax.swing.JTextField ngay3;
    private javax.swing.JButton sua2;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTextField ten1;
    private javax.swing.JTextField ten2;
    private javax.swing.JButton them1;
    private javax.swing.JButton them2;
    private javax.swing.JButton them3;
    private javax.swing.JButton thongke;
    private javax.swing.JButton xoa1;
    private javax.swing.JButton xoa2;
    // End of variables declaration//GEN-END:variables
}
