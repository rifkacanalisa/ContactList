package Contact;


import javax.swing.*;
import java.awt.event.*;

public class Controller_Contact {
    View_Contact view_contact;
    Model_Contact model_contact;
    VEdit_Contact vEdit_contact;
    String dataedit = null;
    int baris, kolom;

    public Controller_Contact(View_Contact view_contact, Model_Contact model_contact){
        this.view_contact = view_contact;
        this.model_contact = model_contact;

        if(model_contact.getBanyakContact() != 0 ){
            String contact[][] = model_contact.ReadContact();
            view_contact.table.setModel((new JTable(contact, view_contact.kolom)).getModel());
            view_contact.btnResetAll.setEnabled(true);
        } else {
            view_contact.btnResetAll.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Contact Tidak Ada");
        }
        view_contact.tfNoHP.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try{
                    float hp = Float.parseFloat(view_contact.getNoHP());
                    view_contact.lvalidNoHP.setText("");
                    view_contact.btnAdd.setEnabled(true);
                } catch (NumberFormatException e1){
                    view_contact.lvalidNoHP.setText("Invalid Number");
                    view_contact.btnAdd.setEnabled(false);
                }
            }
        });
        view_contact.tfUmur.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try{
                    int umur = Integer.parseInt(view_contact.getUmur());
                    view_contact.lvalidUmur.setText("");
                    view_contact.btnAdd.setEnabled(true);
                } catch (NumberFormatException e2){
                    view_contact.lvalidUmur.setText("Invalid Number");
                    view_contact.btnAdd.setEnabled(false);
                }
            }
        });


        view_contact.btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(view_contact.getNoHP().equals("") || view_contact.getNama().equals("")
                            || view_contact.getUmur().equals("") || view_contact.getEmail().equals("")){
                        JOptionPane.showMessageDialog(null, "Data masih ada yang kosong");
                    }
                    else{
                        String Nama = view_contact.getNama();
                        String NoHp = view_contact.getNoHP();
                        String Umur = view_contact.getUmur();
                        String Email = view_contact.getEmail();
                        if(NoHp.length()>=9 && NoHp.length()<=13){
                            model_contact.InsertContact(Nama, NoHp, Umur, Email);
                            view_contact.tfNama.setText("");
                            view_contact.tfUmur.setText("");
                            view_contact.tfNoHP.setText("");
                            view_contact.tfEmail.setText("");
                            Update();
                            view_contact.btnResetAll.setEnabled(true);
                        }
                    }
                } catch (Exception e1){
                    System.out.println("Gagal button!!");
                }
            }
        });

        view_contact.btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    view_contact.tfNama.setText("");
                    view_contact.tfUmur.setText("");
                    view_contact.tfNoHP.setText("");
                    view_contact.tfEmail.setText("");
                } catch (Exception e1){
                    System.out.println("Error!!");
                }
            }
        });

        view_contact.table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baris = view_contact.table.getSelectedRow();
                kolom = view_contact.table.getSelectedColumn();
                dataedit =view_contact.table.getValueAt(baris,1).toString();
                if (dataedit != null){
                    view_contact.btnDelete.setEnabled(true);
                    view_contact.btnEdit.setEnabled(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        view_contact.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(dataedit != null){
                        model_contact.deleteContact(dataedit);
                        Update();
                        view_contact.btnDelete.setEnabled(false);
                    }
                } catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Contact Gagal Dihapus!",
                            "Hasil", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view_contact.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(dataedit!=null){
                        String NamaA = view_contact.table.getValueAt(baris,0).toString();
                        String NoHPA = view_contact.table.getValueAt(baris,1).toString();
                        String UmurA = view_contact.table.getValueAt(baris,2).toString();
                        String EmailA = view_contact.table.getValueAt(baris,3).toString();

                        vEdit_contact = new VEdit_Contact();
                        view_contact.dispose();
                        vEdit_contact.tfNama.setText(NamaA);
                        vEdit_contact.tfNoHP.setText(NoHPA);
                        vEdit_contact.tfUmur.setText(UmurA);
                        vEdit_contact.tfEmail.setText(EmailA);
                        vEdit_contact.tfNoHP.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyPressed(KeyEvent e) {
                                try{
                                    float hp = Float.parseFloat(vEdit_contact.getNoHP());
                                    vEdit_contact.lvalidNoHP.setText("");
                                    vEdit_contact.btnSave.setEnabled(true);
                                } catch (NumberFormatException e1){
                                    vEdit_contact.lvalidNoHP.setText("Invalid Number");
                                    vEdit_contact.btnSave.setEnabled(false);
                                }
                            }
                        });
                        vEdit_contact.tfUmur.addKeyListener(new KeyAdapter() {
                            @Override
                            public void keyPressed(KeyEvent e) {
                                try{
                                    int umur = Integer.parseInt(vEdit_contact.getUmur());
                                    vEdit_contact.lvalidUmur.setText("");
                                    vEdit_contact.btnSave.setEnabled(true);
                                } catch (NumberFormatException e2){
                                    vEdit_contact.lvalidUmur.setText("Invalid Number");
                                    vEdit_contact.btnSave.setEnabled(false);
                                }
                            }
                        });

                        vEdit_contact.btnSave.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if(vEdit_contact.tfNama!=null && vEdit_contact.tfUmur!=null &&
                                        vEdit_contact.tfNoHP!=null && vEdit_contact.tfEmail!=null){
                                    String NamaE = vEdit_contact.getNama();
                                    String NoHpE = vEdit_contact.getNoHP();
                                    String UmurE = vEdit_contact.getUmur();
                                    String EmailE = vEdit_contact.getEmail();
                                    model_contact.UpdateContact(NoHPA,NoHpE,NamaE,UmurE,EmailE);
                                    vEdit_contact.dispose();
                                    MVC mvc = new MVC();
                                }
                            }
                        });

                        vEdit_contact.btnCancel.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                vEdit_contact.tfNama.setText(NamaA);
                                vEdit_contact.tfEmail.setText(EmailA);
                                vEdit_contact.tfNoHP.setText(NoHPA);
                                vEdit_contact.tfUmur.setText(UmurA);
                            }
                        });

                        vEdit_contact.btnBack.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                vEdit_contact.dispose();
                                MVC mvc = new MVC();
                            }
                        });
                    }
                } catch (Exception e1){
                    JOptionPane.showMessageDialog(null, "Contact Gagal Diubah!",
                            "Hasil", JOptionPane.ERROR_MESSAGE);
                }
        }
        });

        view_contact.btnResetAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(model_contact.getBanyakContact() >= 0){
                        model_contact.resetData();
                        Update();
                        view_contact.btnResetAll.setEnabled(false);
                    }

                } catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Contact Gagal Dihapus!",
                            "Hasil", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    }
    public void Update(){
        String Contact[][] = model_contact.ReadContact();
        view_contact.table.setModel((new JTable(Contact, view_contact.kolom)).getModel());
    }
}
