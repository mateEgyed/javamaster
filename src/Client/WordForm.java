/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import DatabaseConnection.Word;
import DatabaseConnection.DbConnection;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author Mate
 */
public class WordForm extends javax.swing.JDialog {

    /**
     * Creates new form WordForm
     */
    public WordForm(java.awt.Frame parent, boolean modal, DbConnection dbConn) {
        super(parent, modal);
        this.dbConn = dbConn;
        initComponents();
        tfEng.setToolTipText("Több szó megadása esetén \",\" kirakása kötelező a szavak között.\n"
                + "A mezű üresen hagyása esetén az adott szó törlődik az adatbázisból");
        tfHun.setToolTipText("A módosítani kívánt szót ide kell írni");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfHun = new javax.swing.JTextField();
        tfEng = new javax.swing.JTextField();
        btChange = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Szó hozzáadás/módosítás/törlés");
        setModal(true);
        setPreferredSize(new java.awt.Dimension(400, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel10.setText("Szó hozzáadása/törlése/módosítása:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 6, 10, 6);
        getContentPane().add(jLabel10, gridBagConstraints);

        jLabel11.setText("Magyar szó");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        getContentPane().add(jLabel11, gridBagConstraints);

        jLabel12.setText("Angol szó:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        getContentPane().add(jLabel12, gridBagConstraints);

        tfHun.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 6, 10, 6);
        getContentPane().add(tfHun, gridBagConstraints);

        tfEng.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 6, 10, 6);
        getContentPane().add(tfEng, gridBagConstraints);

        btChange.setText("Módosít");
        btChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(15, 6, 15, 6);
        getContentPane().add(btChange, gridBagConstraints);

        btCancel.setText("Mégse");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 6, 10, 6);
        getContentPane().add(btCancel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChangeActionPerformed
        boolean isDelete = false;
        boolean isAdd = false;
        boolean isMod = false;
        hunWord = tfHun.getText();
        engWord.clear();
        String engText = tfEng.getText();
        Word currentWord = null;
        if (hunWord.equals("")) {
            JOptionPane.showMessageDialog(this, "Kérlek add meg a módosítandó szót, melyet akár a listából is kiválaszthatsz", "Üres mező", JOptionPane.PLAIN_MESSAGE);
        } else {
            if (engText.equals("")) {
                isDelete = true;
            }
            String[] tempEngWord = engText.split(",");
            engWord.addAll(Arrays.asList(tempEngWord));
            for (Word w : dbConn.getAllWords()) {
                if (hunWord.equals(w.getHunWord())) {
                    isAdd = true;
                    if (isDelete) {
                        currentWord = w;
                    } else {
                        isMod = true;
                        currentWord = w;
                    }
                }
            }
            if (isMod) {
                currentWord.setEngWord(engWord);
                dbConn.updateWord(currentWord);
            }
            if (isDelete) {
                dbConn.deleteWord(currentWord);
            }
            if (!isAdd) {
                dbConn.addWord(hunWord, engWord);
            }
        }
        tfHun.setText("");
        tfEng.setText("");
    }//GEN-LAST:event_btChangeActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        tfHun.setText("");
        tfEng.setText("");
        checkWords();
    }//GEN-LAST:event_btCancelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        checkWords();
    }//GEN-LAST:event_formWindowClosing

    private void checkWords() {
        if (!dbConn.getAllWords().isEmpty()) {
            dispose();
        } else {
            int dialogResult = JOptionPane.showConfirmDialog(this, "A szó adatbázis jelenleg üres, amennyiben nem ad hozzá új szót a program befejezi futását.\n"
                    + "Biztos nem ad hozzá új szót?",
                    "Kilépés", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btChange;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JTextField tfEng;
    private javax.swing.JTextField tfHun;
    // End of variables declaration//GEN-END:variables
    private DbConnection dbConn;
    private String hunWord;
    private ArrayList<String> engWord = new ArrayList<>();
}
