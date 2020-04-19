package Contact;

import javax.swing.*;
import java.awt.*;

public class VEdit_Contact extends JFrame {
    JLabel judul = new JLabel("Edit Contact");
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

    JButton btnSave = new JButton("Simpan");
    JButton btnCancel = new JButton("Batal");
    JButton btnBack = new JButton("Kembali");

    public VEdit_Contact(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("UPN V Yogyakarta");
        setVisible(true);
        setLayout(null);
        setSize(800,600);
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

        add(btnSave);
        btnSave.setBounds(50,130,100,20);
        add(btnCancel);
        btnCancel.setBounds(175,130,100,20);
        add(btnBack);
        btnBack.setBounds(300,130,100,20);
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
