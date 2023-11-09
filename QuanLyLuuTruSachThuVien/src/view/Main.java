/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.IOFile;
import controller.ValidException;
import java.io.File;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Ke;
import model.QuanLy;
import model.Sach;

/**
 *
 * @author 84912
 */
public class Main extends javax.swing.JFrame {

    private List<Sach> list1;
    private DefaultTableModel tm1;
    private String f1;

    private List<Ke> list2;
    private DefaultTableModel tm2;
    private String f2;

    private List<QuanLy> list3;
    private DefaultTableModel tm3;
    private String f3;

    private List<Sach> list4;
    private DefaultTableModel tm4;

    public Main() {
        initComponents();
        setLocationRelativeTo(this);

        f1 = "src/controller/SACH.dat";
        if (new File(f1).exists()) {
            list1 = IOFile.doc(f1);
        } else {
            list1 = new ArrayList<>();
        }
        tm1 = (DefaultTableModel) tb1.getModel();
        setButtonS(true);
        docS();
        eventS();

        f2 = "src/controller/KE.dat";
        if (new File(f2).exists()) {
            list2 = IOFile.doc(f2);
        } else {
            list2 = new ArrayList<>();
        }
        tm2 = (DefaultTableModel) tb2.getModel();
        setButtonK(true);
        docK();
        eventK();

        f3 = "src/controller/QLSTV.dat";
        if (new File(f3).exists()) {
            list3 = IOFile.doc(f3);
        } else {
            list3 = new ArrayList<>();
        }
        tm3 = (DefaultTableModel) tb3.getModel();
        docQL();
        eventQL();

        f1 = "src/controller/SACH.dat";
        if (new File(f1).exists()) {
            list4 = IOFile.doc(f1);
        } else {
            list4 = new ArrayList<>();
        }
        tm4 = (DefaultTableModel) tb4.getModel();
        docTK();
        eventTK();

    }

    private void setButtonS(boolean b) {
        them1.setEnabled(b);
        capnhat1.setEnabled(!b);
        boqua1.setEnabled(!b);
    }

    private void docS() {
        tm1.setRowCount(0);
        for (Sach i : list1) {
            tm1.addRow(i.toObject());
        }
    }

    private void eventS() {
        them1.addActionListener(e -> {
            ma1.setText(10000 + list1.size() + "");
            ten1.requestFocus();
            setButtonS(false);
        });

        capnhat1.addActionListener(e -> {
            try {
                if (!nam1.getText().matches("\\d+")) {
                    throw new ValidException("Nhap lai so");
                }
                Sach x = new Sach(Integer.parseInt(ma1.getText()), ten1.getText(), tg1.getText(), cn1.getSelectedItem().toString(), Integer.parseInt(nam1.getText()));
                list1.add(x);
                tm1.addRow(x.toObject());
                setButtonS(true);
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, ex);
                nam1.setText("");
                nam1.requestFocus();
            }
        });

        boqua1.addActionListener(e -> {
            setButtonS(true);
        });

        xoa1.addActionListener(e -> {
            int row = tb1.getSelectedRow();
            if (row >= 0 && row < tb1.getRowCount()) {
                list1.remove(row);
                tm1.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de xoa");
            }
        });

        luu1.addActionListener(e -> {
            IOFile.viet(f1, list1);
        });
    }

    private void setButtonK(boolean b) {
        them2.setEnabled(b);
        capnhat2.setEnabled(!b);
        boqua2.setEnabled(!b);
    }

    private void docK() {
        tm2.setRowCount(0);
        for (Ke i : list2) {
            tm2.addRow(i.toObject());
        }
    }

    private void eventK() {
        them2.addActionListener(e -> {
            ma2.setText(100 + list2.size() + "");
            ten2.requestFocus();
            setButtonK(false);
        });

        capnhat2.addActionListener(e -> {
            try {
                if (!soLuong2.getText().matches("\\d+")) {
                    throw new ValidException("Nhap lai so");
                }
                Ke x = new Ke(Integer.parseInt(ma2.getText()), ten2.getText(), loai2.getSelectedItem().toString(), Integer.parseInt(soLuong2.getText()));
                list2.add(x);
                tm2.addRow(x.toObject());
                setButtonK(true);
            } catch (ValidException ex) {
                JOptionPane.showMessageDialog(this, ex);
                soLuong2.setText("");
                soLuong2.requestFocus();
            }
        });

        boqua2.addActionListener(e -> {
            setButtonK(true);
        });

        xoa2.addActionListener(e -> {
            int row = tb2.getSelectedRow();
            if (row >= 0 && row < tb2.getRowCount()) {
                list2.remove(row);
                tm2.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de xoa");
            }
        });

        luu2.addActionListener(e -> {
            IOFile.viet(f2, list2);
        });

        sua2.addActionListener(e -> {
            int row = tb2.getSelectedRow();
            if (row >= 0 && row < tb2.getRowCount()) {
                Ke x = new Ke(Integer.parseInt(ma2.getText()), ten2.getText(), loai2.getSelectedItem().toString(), Integer.parseInt(soLuong2.getText()));
                list2.set(row, x);
                tm2.removeRow(row);
                tm2.insertRow(row, x.toObject());
            } else {
                JOptionPane.showMessageDialog(this, "Chon dong de sua");
            }
        });
    }

    private void docQL() {
        tm3.setRowCount(0);
        for (QuanLy i : list3) {
            tm3.addRow(i.toObject());
        }
    }

    private void eventQL() {
        lammoi3.addActionListener(e -> {
            maSCB.removeAllItems();
            for (Sach i : list1) {
                maSCB.addItem(i.getMa() + "");
            }
            maKCB.removeAllItems();
            for (Ke i : list2) {
                maKCB.addItem(i.getMa() + "");
            }
        });

        them3.addActionListener(e -> {
            int ma1 = Integer.parseInt(maSCB.getSelectedItem().toString());
            int ma2 = Integer.parseInt(maKCB.getSelectedItem().toString());
            try {
                int num = Integer.parseInt(soLuong3.getText());
                if (num > getKe(ma2).getSoLuong()) {
                    JOptionPane.showMessageDialog(this, "Khong du cho trong");
                    soLuong3.setText("");
                    soLuong3.requestFocus();
                    return;
                }
                QuanLy x = new QuanLy(getSach(ma1), getKe(ma2), num);
                list3.add(x);
                tm3.addRow(x.toObject());

                //Dat lai so luong sau khi muon
                getKe(ma2).setSoLuong(getKe(ma2).getSoLuong() - num);
                IOFile.viet(f2, list2);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Nhap so luong!!!");
                soLuong3.setText("");
                soLuong3.requestFocus();
            }
        });

        luu3.addActionListener(e -> {
            IOFile.viet(f2, list2);
        });

        sx3.addActionListener(e -> {
            if (sxCB.getSelectedIndex() == 0) {
                list3.sort(new Comparator<QuanLy>() {
                    @Override
                    public int compare(QuanLy x, QuanLy y) {
                        return x.getSach().getTen().compareTo(y.getSach().getTen());
                    }

                });
            } else {
                list3.sort(new Comparator<QuanLy>() {
                    @Override
                    public int compare(QuanLy x, QuanLy y) {
                        return x.getSoLuong() - y.getSoLuong();
                    }

                });
            }
            docQL();
        });
    }

    private Sach getSach(int ma) {
        for (Sach i : list1) {
            if (i.getMa() == ma) {
                return i;
            }
        }
        return null;
    }

    private Ke getKe(int ma) {
        for (Ke i : list2) {
            if (i.getMa() == ma) {
                return i;
            }
        }
        return null;
    }

    private void docTK() {
        tm4.setRowCount(0);
        for (Sach i : list4) {
            tm4.addRow(i.toObject());
        }
    }

    private void eventTK() {
        /*
        Khoa học tự nhiên
        Văn học – Nghệ thuật
Điện tử Viễn thông
Công nghệ thông tin
         */
        tim4.addActionListener(e -> {
            tm4.setRowCount(0);
            if (cnCB4.getSelectedIndex() == 0) {
                for (Sach i : list4) {
                    if (i.getChuyenNganh().equals("Khoa hoc tu nhien")) {
                        tm4.addRow(i.toObject());
                    }
                }
            } else if (cnCB4.getSelectedIndex() == 1) {
                for (Sach i : list4) {
                    if (i.getChuyenNganh().equals("Van hoc – Nghe thuat")) {
                        tm4.addRow(i.toObject());
                    }
                }
            } else if (cnCB4.getSelectedIndex() == 2) {
                for (Sach i : list4) {
                    if (i.getChuyenNganh().equals("Dien tu Vien thong")) {
                        tm4.addRow(i.toObject());
                    }
                }
            } else {
                for (Sach i : list4) {
                    if (i.getChuyenNganh().equals("Cong nghe thong tin")) {
                        tm4.addRow(i.toObject());
                    }
                }
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
        tg1 = new javax.swing.JTextField();
        cn1 = new javax.swing.JComboBox<>();
        nam1 = new javax.swing.JTextField();
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ma2 = new javax.swing.JTextField();
        ten2 = new javax.swing.JTextField();
        loai2 = new javax.swing.JComboBox<>();
        soLuong2 = new javax.swing.JTextField();
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
        jLabel13 = new javax.swing.JLabel();
        soLuong3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        maSCB = new javax.swing.JComboBox<>();
        maKCB = new javax.swing.JComboBox<>();
        sxCB = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        them3 = new javax.swing.JButton();
        luu3 = new javax.swing.JButton();
        lammoi3 = new javax.swing.JButton();
        sx3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tb4 = new javax.swing.JTable();
        cnCB4 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        tim4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ma sach", "Ten sach", "Tac gia", "Chuyen nganh", "Nam xuat ban"
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
            tb1.getColumnModel().getColumn(4).setHeaderValue("Nam xuat ban");
        }

        jLabel1.setText("Ma sach:");

        jLabel2.setText("Ten sach:");

        jLabel3.setText("Tac gia:");

        jLabel4.setText("Chuyen nganh:");

        jLabel5.setText("Nam xuat ban:");

        ma1.setEditable(false);

        cn1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoa hoc tu nhien", "Van hoc – Nghe thuat", "Dien tu Vien thong", "Cong nghe thong tin" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ma1)
                    .addComponent(ten1)
                    .addComponent(tg1)
                    .addComponent(cn1, 0, 206, Short.MAX_VALUE)
                    .addComponent(nam1))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
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
                    .addComponent(tg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        them1.setText("Them");

        capnhat1.setText("Cap nhat");

        boqua1.setText("Bo qua");

        xoa1.setText("Xoa");

        luu1.setText("Luu");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(luu1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boqua1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capnhat1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(them1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(them1)
                .addGap(18, 18, 18)
                .addComponent(capnhat1)
                .addGap(18, 18, 18)
                .addComponent(boqua1)
                .addGap(18, 18, 18)
                .addComponent(xoa1)
                .addGap(18, 18, 18)
                .addComponent(luu1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sach", jPanel1);

        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma ke", "Ten ke", "Loai ke", "So luong toi da"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        jLabel6.setText("Ma ke:");

        jLabel7.setText("Ten ke:");

        jLabel9.setText("Loai ke:");

        jLabel10.setText("So luong toi da:");

        ma2.setEditable(false);

        loai2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhỏ", "Trung bình", "Lớn" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ma2)
                    .addComponent(ten2)
                    .addComponent(loai2, 0, 206, Short.MAX_VALUE)
                    .addComponent(soLuong2))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ma2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ten2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(loai2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(soLuong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        them2.setText("Them");

        capnhat2.setText("Cap nhat");

        boqua2.setText("Bo qua");

        xoa2.setText("Xoa");

        luu2.setText("Luu");

        sua2.setText("Sua");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sua2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(luu2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoa2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boqua2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(capnhat2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(them2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Ke sach", jPanel2);

        tb3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ma sach", "Ten sach", "Ma ke", "So luong"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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

        jLabel13.setText("So luong:");

        soLuong3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                soLuong3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Ma sach:");

        jLabel11.setText("Ma ke:");

        maSCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        maKCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        sxCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo tên sách ", "Theo số lượng mỗi loại" }));

        jLabel12.setText("Sap xep:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(maKCB, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maSCB, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sxCB, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(soLuong3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(maSCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(maKCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(soLuong3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sxCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        them3.setText("Them");

        luu3.setText("Luu");

        lammoi3.setText("Lam moi");

        sx3.setText("Sap xep");
        sx3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sx3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sx3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lammoi3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(luu3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(them3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(them3)
                .addGap(18, 18, 18)
                .addComponent(luu3)
                .addGap(18, 18, 18)
                .addComponent(lammoi3)
                .addGap(18, 18, 18)
                .addComponent(sx3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quan ly sach", jPanel3);

        tb4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ma sach", "Ten sach", "Tac gia", "Chuyen nganh", "Nam xuat ban"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tb4);
        if (tb4.getColumnModel().getColumnCount() > 0) {
            tb4.getColumnModel().getColumn(4).setHeaderValue("Nam xuat ban");
        }

        cnCB4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khoa hoc tu nhien", "Van hoc – Nghe thuat", "Dien tu Vien thong", "Cong nghe thong tin" }));

        jLabel14.setText("Chuyen nganh:");

        tim4.setText("Tim kiem");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(cnCB4, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(tim4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cnCB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(tim4))
                .addGap(0, 248, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tim kiem", jPanel4);

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

    private void tb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb2MouseClicked
        int row = tb2.getSelectedRow();
        if (row >= 0 && row < tb2.getRowCount()) {
            ma2.setText(tm2.getValueAt(row, 0).toString());
            ten2.setText(tm2.getValueAt(row, 1).toString());
            soLuong2.setText(tm2.getValueAt(row, 3).toString());

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

    private void soLuong3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_soLuong3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_soLuong3ActionPerformed

    private void sx3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sx3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sx3ActionPerformed

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
    private javax.swing.JButton boqua1;
    private javax.swing.JButton boqua2;
    private javax.swing.JButton capnhat1;
    private javax.swing.JButton capnhat2;
    private javax.swing.JComboBox<String> cn1;
    private javax.swing.JComboBox<String> cnCB4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JButton lammoi3;
    private javax.swing.JComboBox<String> loai2;
    private javax.swing.JButton luu1;
    private javax.swing.JButton luu2;
    private javax.swing.JButton luu3;
    private javax.swing.JTextField ma1;
    private javax.swing.JTextField ma2;
    private javax.swing.JComboBox<String> maKCB;
    private javax.swing.JComboBox<String> maSCB;
    private javax.swing.JTextField nam1;
    private javax.swing.JTextField soLuong2;
    private javax.swing.JTextField soLuong3;
    private javax.swing.JButton sua2;
    private javax.swing.JButton sx3;
    private javax.swing.JComboBox<String> sxCB;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTable tb4;
    private javax.swing.JTextField ten1;
    private javax.swing.JTextField ten2;
    private javax.swing.JTextField tg1;
    private javax.swing.JButton them1;
    private javax.swing.JButton them2;
    private javax.swing.JButton them3;
    private javax.swing.JButton tim4;
    private javax.swing.JButton xoa1;
    private javax.swing.JButton xoa2;
    // End of variables declaration//GEN-END:variables
}
