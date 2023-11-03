/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.IOFile;
import controller.ValidException;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BanDoc;
import model.MuonSach;
import model.Sach;

/**
 *
 * @author 84912
 */
public class Main extends javax.swing.JFrame {

    private List<BanDoc> list1;
    private DefaultTableModel tmBD;
    private String fBD;

    private List<Sach> list2;
    private DefaultTableModel tmS;
    private String fS;

    private List<MuonSach> list3;
    private DefaultTableModel tmMS;
    private String fMS;

    private List<MuonSach> list4;
    private DefaultTableModel tm4;
    private String f4;

    public Main() {
        initComponents();
        setLocationRelativeTo(this);

        //Ban doc:
        fBD = "src/controller/BANDOC.dat";
        if (new File(fBD).exists()) {
            list1 = IOFile.doc(fBD);
        } else {
            list1 = new ArrayList<>();
        }
        tmBD = (DefaultTableModel) tb1.getModel();
        docBD();
        setButtonBD(true);
        eventBD();

        //Sach:
        fS = "src/controller/SACH.dat";
        if (new File(fS).exists()) {
            list2 = IOFile.doc(fS);
        } else {
            list2 = new ArrayList<>();
        }
        tmS = (DefaultTableModel) tb2.getModel();
        docS();
        setButtonS(true);
        eventS();

        // QLMS
        fMS = "src/controller/QLMS.dat";
        if (new File(fMS).exists()) {
            list3 = IOFile.doc(fMS);
        } else {
            list3 = new ArrayList<>();
        }
        tmMS = (DefaultTableModel) tb3.getModel();
        docMS();
        eventMS();

        // Bang thong ke
//        f4 = "src/controller/QLMS.dat";
//        if (new File(f4).exists()) {
//            list4 = IOFile.doc(f4);
//        } else {
//            list4 = new ArrayList<>();
//        }
        tm4 = (DefaultTableModel) tb4.getModel();
//        docTK();
        eventTK();
    }

    private void docBD() {
        tmBD.setRowCount(0);
        for (BanDoc i : list1) {
            tmBD.addRow(i.toObject());
        }
    }

    private void setButtonBD(boolean b) {
        themBT.setEnabled(b);
        capnhatBT.setEnabled(!b);
        boquaBT.setEnabled(!b);
    }

    private void eventBD() {
        themBT.addActionListener(e -> {
            maBD.setText(10000 + list1.size() + "");
            tenBD.requestFocus();
            setButtonBD(false);
        });

        capnhatBT.addActionListener(e -> {
            try {
                if (!sdtBD.getText().matches("\\d+")) {
                    throw new ValidException("Nhap so");
                }
                BanDoc x = new BanDoc(Integer.parseInt(maBD.getText()),
                        tenBD.getText(), dchiBD.getText(), sdtBD.getText());
                list1.add(x);
                tmBD.addRow(x.toObject());
                setButtonBD(true);
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, ex);
                sdtBD.setText("");
                sdtBD.requestFocus();
            }
        });

        boquaBT.addActionListener(e -> {
            setButtonBD(true);
        });

        xoaBT.addActionListener(e -> {
            int row = tb1.getSelectedRow();
            if (row >= 0 && row < tb1.getRowCount()) {
                list1.remove(row);
                tmBD.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de xoa");
            }
        });

        luuBT.addActionListener(e -> {
            IOFile.viet(fBD, list1);
        });
    }

    // Sach:
    private void docS() {
        tmS.setRowCount(0);
        for (Sach i : list2) {
            tmS.addRow(i.toObject());
        }
    }

    private void setButtonS(boolean b) {
        themS.setEnabled(b);
        capnhatS.setEnabled(!b);
        boquaS.setEnabled(!b);
    }

    private void eventS() {
        themS.addActionListener(e -> {
            maS.setText(10000 + list2.size() + "");
            tenS.requestFocus();
            setButtonS(false);
        });

        capnhatS.addActionListener(e -> {
            try {
                if (!numS.getText().matches("\\d+")) {
                    throw new ValidException("Nhap so");
                }
                Sach x = new Sach(Integer.parseInt(maS.getText()),
                        tenS.getText(), tacgiaS.getText(), cnS.getSelectedItem().toString(), Integer.parseInt(numS.getText()));
                list2.add(x);
                tmS.addRow(x.toObject());
                setButtonS(true);
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, ex);
                numS.setText("");
                numS.requestFocus();
            }
        });

        boquaS.addActionListener(e -> {
            setButtonS(true);
        });

        suaS.addActionListener(e -> {
            int row = tb2.getSelectedRow();
            if (row >= 0 && row < tb2.getRowCount()) {
                Sach x = new Sach(Integer.parseInt(maS.getText()),
                        tenS.getText(), tacgiaS.getText(), cnS.getSelectedItem().toString(), Integer.parseInt(numS.getText()));
                list2.set(row, x);
                tmS.removeRow(row);
                tmS.insertRow(row, x.toObject());
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de sua");
            }
        });

        luuS.addActionListener(e -> {
            IOFile.viet(fS, list2);
        });

        // Lam moi sau khi da cho muon sach
        lammoiS.addActionListener(e -> {
            tmS.setRowCount(0);
            for (Sach i : list2) {
                tmS.addRow(i.toObject());
            }
        });
    }

    private void docMS() {
        tmMS.setRowCount(0);
        for (MuonSach i : list3) {
            tmMS.addRow(i.toObject());
        }
    }

    private void eventMS() {
        lammoiMS.addActionListener(e -> {
            maBDCB.removeAllItems();
            for (BanDoc i : list1) {
                maBDCB.addItem(i.getMa() + "");
            }
            maSCB.removeAllItems();
            for (Sach i : list2) {
                maSCB.addItem(i.getMa() + "");
            }
        });

        themMS.addActionListener(e -> {
            int ma1 = Integer.parseInt(maBDCB.getSelectedItem().toString());
            int ma2 = Integer.parseInt(maSCB.getSelectedItem().toString());
            if (trung(ma1, ma2)) {
                JOptionPane.showMessageDialog(this, "Trung ma!!!");
                maBDCB.requestFocus();
                return;
            }
            int sl = 0;
            int slsach = getSach(ma2).getNum();
            try {
                sl = Integer.parseInt(numMS.getText());
                if (sl > slsach) {
                    JOptionPane.showMessageDialog(this, "Khong du sach");
                    numMS.setText("");
                    numMS.requestFocus();
                    return;
                }
                String tt = ttS.getText();
                MuonSach x = new MuonSach(getBanDoc(ma1), getSach(ma2), sl, tt);
                list3.add(x);
                tmMS.addRow(x.toObject());

                //Dat lai so luong sau khi muon
                getSach(ma2).setNum(slsach - sl);
                IOFile.viet(fS, list2);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nhap so luong!!!");
                numMS.setText("");
                numMS.requestFocus();
                return;
            }
        });

        luuMS.addActionListener(e -> {
            IOFile.viet(fMS, list3);
        });

        sxMS.addActionListener(e -> {
            if (sxCB.getSelectedIndex() == 0) {
                list3.sort(new Comparator<MuonSach>() {
                    @Override
                    public int compare(MuonSach x, MuonSach y) {
                        return x.getBandoc().getTen().compareToIgnoreCase(y.getBandoc().getTen());
                    }

                });
            } else {
                list3.sort(new Comparator<MuonSach>() {
                    @Override
                    public int compare(MuonSach x, MuonSach y) {
                        return x.getSoLuong() - y.getSoLuong();
                    }

                });
            }

            // Xoa bang di, luu lai moi sap xep
            tmMS.setRowCount(0);
            for (MuonSach i : list3) {
                tmMS.addRow(i.toObject());
            }
        });
    }

    // Kiem tra ban doc muon 1 sach 2 lan
    private boolean trung(int mabd, int mas) {
        for (MuonSach i : list3) {
            if (i.getBandoc().getMa() == mabd && i.getSach().getMa() == mas) {
                return true;
            }
        }
        return false;
    }

    // Dem so sach 1 ban doc da muon
    private int demSach(int mabd) {
        int cnt = 0;
        for (MuonSach i : list3) {
            if (i.getBandoc().getMa() == mabd) {
                cnt++;
            }
        }
        return cnt;
    }

    private Sach getSach(int mas) {
        for (Sach i : list2) {
            if (i.getMa() == mas) {
                return i;
            }
        }
        return null;
    }

    private BanDoc getBanDoc(int mas) {
        for (BanDoc i : list1) {
            if (i.getMa() == mas) {
                return i;
            }
        }
        return null;
    }

    private void docTK(List<MuonSach> list) {
        tm4.setRowCount(0);
        for (MuonSach i : list) {
            tm4.addRow(i.toObject());
        }
    }

    private void eventTK() {
        // Hien thi: show tu trong file ra
        
        hthiBT.addActionListener(e -> {
            f4 = "src/controller/QLMS.dat";
            if (new File(f4).exists()) {
                list4 = IOFile.doc(f4);
            } else {
                list4 = new ArrayList<>();
            }
            docTK(list4);
        });
        
        timBT.addActionListener(e -> {
            List<MuonSach> listSearch = new ArrayList<>();
            String s = timkiemTF.getText().trim().toLowerCase();
            
            for(MuonSach i: list4)
                if(i.getBandoc().getTen().toLowerCase().contains(s) || i.getSach().getTen().toLowerCase().contains(s))
                    listSearch.add(i);
            // Hien thi len table:
            docTK(listSearch);
        });
        
        tkBT.addActionListener(e -> {
            Map<String, Integer> mp = list4.stream().collect(Collectors.groupingBy(MuonSach::vietTK, Collectors.summingInt(MuonSach::getSoLuong)));
            tkTA.setText("Ban doc \t\t Tong so luong muon");
            for(String i: mp.keySet())
                tkTA.append("\n" + i + "\tSo luong: " + mp.get(i));
            
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        maBD = new javax.swing.JTextField();
        tenBD = new javax.swing.JTextField();
        dchiBD = new javax.swing.JTextField();
        sdtBD = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        themBT = new javax.swing.JButton();
        capnhatBT = new javax.swing.JButton();
        boquaBT = new javax.swing.JButton();
        xoaBT = new javax.swing.JButton();
        luuBT = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        maS = new javax.swing.JTextField();
        tenS = new javax.swing.JTextField();
        tacgiaS = new javax.swing.JTextField();
        numS = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cnS = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        themS = new javax.swing.JButton();
        capnhatS = new javax.swing.JButton();
        boquaS = new javax.swing.JButton();
        suaS = new javax.swing.JButton();
        luuS = new javax.swing.JButton();
        lammoiS = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        numMS = new javax.swing.JTextField();
        maBDCB = new javax.swing.JComboBox<>();
        maSCB = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        sxCB = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        ttS = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        themMS = new javax.swing.JButton();
        luuMS = new javax.swing.JButton();
        sxMS = new javax.swing.JButton();
        lammoiMS = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        hthiBT = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        timkiemTF = new javax.swing.JTextField();
        timBT = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tkTA = new javax.swing.JTextArea();
        tkBT = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tb4 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chuong trinh quan ly sach\n");

        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma", "Ho va ten", "Dia chi", "So dien thoai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tb1);

        jLabel1.setText("Ma:");

        jLabel2.setText("Ho va ten:");

        jLabel3.setText("Dia chi:");

        jLabel4.setText("So dien thoai:");

        maBD.setEditable(false);
        maBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maBDActionPerformed(evt);
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
                    .addComponent(jLabel4))
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maBD)
                    .addComponent(tenBD)
                    .addComponent(dchiBD)
                    .addComponent(sdtBD, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(maBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tenBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dchiBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sdtBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        themBT.setText("Them");

        capnhatBT.setText("Cap nhat");

        boquaBT.setText("Bo qua");

        xoaBT.setText("Xoa");

        luuBT.setText("Luu");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(luuBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoaBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boquaBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capnhatBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(themBT)
                .addGap(18, 18, 18)
                .addComponent(capnhatBT)
                .addGap(18, 18, 18)
                .addComponent(boquaBT)
                .addGap(18, 18, 18)
                .addComponent(xoaBT)
                .addGap(18, 18, 18)
                .addComponent(luuBT)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ban doc", jPanel1);

        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ma", "Ten sach", "Tac gia", "Chuyen nganh", "So luong"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
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
        jScrollPane3.setViewportView(tb2);

        jLabel9.setText("Ma:");

        jLabel10.setText("Ten sach:");

        jLabel11.setText("Tac gia:");

        jLabel12.setText("Chuyen nganh:");

        maS.setEditable(false);
        maS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maSActionPerformed(evt);
            }
        });

        jLabel5.setText("So luong:");

        cnS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoa học tự nhiên ", "Văn học – Nghệ thuật", "Điện tử Viễn thông", "Công nghệ thông tin" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel5))
                .addGap(42, 42, 42)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(maS)
                    .addComponent(tenS)
                    .addComponent(tacgiaS)
                    .addComponent(numS, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(cnS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(maS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tenS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tacgiaS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cnS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(numS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        themS.setText("Them");

        capnhatS.setText("Cap nhat");

        boquaS.setText("Bo qua");

        suaS.setText("Sua");

        luuS.setText("Luu");

        lammoiS.setText("Lam moi");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lammoiS, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(luuS, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suaS, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boquaS, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capnhatS, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themS, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(themS)
                .addGap(18, 18, 18)
                .addComponent(capnhatS)
                .addGap(18, 18, 18)
                .addComponent(boquaS)
                .addGap(18, 18, 18)
                .addComponent(suaS)
                .addGap(18, 18, 18)
                .addComponent(luuS)
                .addGap(18, 18, 18)
                .addComponent(lammoiS)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sach", jPanel2);

        tb3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ma ban doc", "Ho va ten ban doc", "Ma sach", "Ten sach", "So luong", "Tinh trang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
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
        jScrollPane2.setViewportView(tb3);

        jLabel6.setText("Ma ban doc:");

        jLabel7.setText("Ma sach:");

        jLabel8.setText("So luong:");

        maBDCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maSCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Sap xep:");

        sxCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo Họ tên bạn đọc", "Theo Số lượng cuốn sách được mượn (giảm dần)" }));

        jLabel14.setText("Tinh trang:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(50, 50, 50)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(numMS)
                    .addComponent(maBDCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(maSCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sxCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ttS))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(maBDCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(maSCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(numMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ttS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(sxCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        themMS.setText("Them");

        luuMS.setText("Luu");

        sxMS.setText("Sap xep");

        lammoiMS.setText("Lam moi");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lammoiMS, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sxMS, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(luuMS, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themMS, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(themMS)
                .addGap(18, 18, 18)
                .addComponent(luuMS)
                .addGap(18, 18, 18)
                .addComponent(sxMS)
                .addGap(18, 18, 18)
                .addComponent(lammoiMS)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quan ly muon sach", jPanel3);

        hthiBT.setText("Hien thi");

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sap xep", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14), new java.awt.Color(51, 0, 255))); // NOI18N

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Theo ho va ten ban doc");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Theo so luong muon");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addGap(29, 29, 29)
                .addComponent(jRadioButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel15.setText("Tim kiem:");

        timBT.setText("Tim");

        tkTA.setColumns(20);
        tkTA.setRows(5);
        jScrollPane4.setViewportView(tkTA);

        tkBT.setText("Thong ke");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hthiBT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timkiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tkBT, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(timBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hthiBT)
                    .addComponent(jLabel15)
                    .addComponent(timkiemTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timBT))
                .addGap(31, 31, 31)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tkBT))
                        .addGap(0, 41, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tb4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ma ban doc", "Ho va ten ban doc", "Ma sach", "Ten sach", "So luong", "Tinh trang"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tb4);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane5)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Thong ke muon sach", jPanel4);

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

    private void maBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maBDActionPerformed

    private void maSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maSActionPerformed

    private void tb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb3MouseClicked

    }//GEN-LAST:event_tb3MouseClicked

    private void tb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb2MouseClicked
        int row = tb2.getSelectedRow();
        if (row >= 0 && row < tb2.getRowCount()) {
            maS.setText(tmS.getValueAt(row, 0).toString());
            tenS.setText(tmS.getValueAt(row, 1).toString());
            tacgiaS.setText(tmS.getValueAt(row, 2).toString());
            numS.setText(tmS.getValueAt(row, 4).toString());

            for (int i = 0; i < cnS.getItemCount(); i++) {
                if (cnS.getItemAt(i).equals(tmS.getValueAt(row, 3).toString())) {
                    cnS.setSelectedIndex(i);
                }
            }
        }
    }//GEN-LAST:event_tb2MouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if(jRadioButton1.isSelected()){
            list4.sort(new Comparator<MuonSach>(){
                @Override
                public int compare(MuonSach x, MuonSach y) {
                    return x.getBandoc().getTen().compareToIgnoreCase(y.getBandoc().getTen());
                }
                
            });
            docTK(list4);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void tb4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb4MouseClicked

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(jRadioButton2.isSelected()){
            list4.sort(new Comparator<MuonSach>(){
                @Override
                public int compare(MuonSach x, MuonSach y) {
                    return y.getSoLuong() - x.getSoLuong();
                }
                
            });
            docTK(list4);
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
    private javax.swing.JButton boquaBT;
    private javax.swing.JButton boquaS;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton capnhatBT;
    private javax.swing.JButton capnhatS;
    private javax.swing.JComboBox<String> cnS;
    private javax.swing.JTextField dchiBD;
    private javax.swing.JButton hthiBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel12;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton lammoiMS;
    private javax.swing.JButton lammoiS;
    private javax.swing.JButton luuBT;
    private javax.swing.JButton luuMS;
    private javax.swing.JButton luuS;
    private javax.swing.JTextField maBD;
    private javax.swing.JComboBox<String> maBDCB;
    private javax.swing.JTextField maS;
    private javax.swing.JComboBox<String> maSCB;
    private javax.swing.JTextField numMS;
    private javax.swing.JTextField numS;
    private javax.swing.JTextField sdtBD;
    private javax.swing.JButton suaS;
    private javax.swing.JComboBox<String> sxCB;
    private javax.swing.JButton sxMS;
    private javax.swing.JTextField tacgiaS;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTable tb4;
    private javax.swing.JTextField tenBD;
    private javax.swing.JTextField tenS;
    private javax.swing.JButton themBT;
    private javax.swing.JButton themMS;
    private javax.swing.JButton themS;
    private javax.swing.JButton timBT;
    private javax.swing.JTextField timkiemTF;
    private javax.swing.JButton tkBT;
    private javax.swing.JTextArea tkTA;
    private javax.swing.JTextField ttS;
    private javax.swing.JButton xoaBT;
    // End of variables declaration//GEN-END:variables
}
