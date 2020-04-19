package Contact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class View_Contact extends JFrame {
    JLabel judul = new JLabel("Contact List");
    JLabel lNoHp = new JLabel("No. HP");
    JLabel lNama = new JLabel("Nama");
    JLabel lUmur = new JLabel("Umur");
    JLabel lEmail = new JLabel("Email");
    JLabel ltahun = new JLabel("Tahun");
    JLabel lvalidNoHP = new JLabel();
    JLabel lvalidUmur = new JLabel();

    JTextField tfNoHP = new JTextField();
    JTextField tfNama = new JTextField();
    JTextField tfUmur = new JTextField();
    JTextField tfEmail = new JTextField();

    JButton btnAdd = new JButton("Tambah");
    JButton btnCancel = new JButton("Batal");
    JButton btnEdit = new JButton("Edit");
    JButton btnDelete = new JButton("Hapus");
    JButton btnResetAll = new JButton("Reset All");

    JTable table;
    DefaultTableModel defaultTableModel;
    JScrollPane jScrollPane;
    Object kolom[] = {"Nama", "No. HP","Umur", "Email"};

    public View_Contact(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("UPN V Yogyakarta");
        setVisible(true);
        setLayout(null);
        setSize(800,1000);
        setResizable(true);
        setLocationRelativeTo(null);

        add(judul);
        judul.setBounds(300,10,200,20);
        add(lNama);
        lNama.setBounds(50,40,50,20);
        add(tfNama);
        tfNama.setBounds(150,40,100,20);
        add(lNoHp);
        lNoHp.setBounds(400,40,50,20);
        add(tfNoHP);
        tfNoHP.setBounds(450,40,100,20);
            add(lvalidNoHP);
            lvalidNoHP.setBounds(450,60,100,20);
            lvalidNoHP.setForeground(Color.red);
            lvalidNoHP.setFont(new Font("Serif", Font.BOLD, 10));
        add(lUmur);
        lUmur.setBounds(400,80,50,20);
        add(tfUmur);
        tfUmur.setBounds(450,80,100,20);
        add(ltahun);
        ltahun.setBounds(560,80,50,20);
            add(lvalidUmur);
            lvalidUmur.setBounds(450,100,100,20);
            lvalidUmur.setForeground(Color.red);
            lvalidUmur.setFont(new Font("Serif", Font.BOLD, 10));
        add(lEmail);
        lEmail.setBounds(50,80,50,20);
        add(tfEmail);
        tfEmail.setBounds(150,80,100,20);

        add(btnAdd);
        btnAdd.setBounds(50,130,100,20);
        add(btnCancel);
        btnCancel.setBounds(175,130,100,20);
        add(btnEdit);
        btnEdit.setBounds(300,130,100,20);
        add(btnDelete);
        btnDelete.setBounds(425,130,100,20);
        add(btnResetAll);
        btnResetAll.setBounds(550,130,100,20);
        btnEdit.setEnabled(false);
        btnDelete.setEnabled(false);

        defaultTableModel= new DefaultTableModel(kolom, 0);
        table = new JTable(defaultTableModel);
        jScrollPane = new JScrollPane(table);
        add(jScrollPane);
        jScrollPane.setBounds(50, 160, 600, 350);

    }

    public String getNama(){
        return tfNama.getText();
    }
    public String getNoHP(){
        return tfNoHP.getText();
    }
    public String getUmur(){
        return tfUmur.getText();
    }
    public String getEmail(){
        return tfEmail.getText();
    }
}
