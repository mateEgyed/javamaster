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
        tfNewEng.setToolTipText("Több szó megadása esetén \",\" kirakása kötelező a szavak között.\n");
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

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfNewHun = new javax.swing.JTextField();
        tfNewEng = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfHun = new javax.swing.JTextField();
        tfEng = new javax.swing.JTextField();
        btChange = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Szó hozzáadás/módosítás/törlés");
        setModal(true);
        setPreferredSize(new java.awt.Dimension(400, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("Új szó hozzáadása:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel7, gridBagConstraints);

        jLabel8.setText("Magyar szó:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel8, gridBagConstraints);

        jLabel9.setText("Angol szó:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel9, gridBagConstraints);

        tfNewHun.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(tfNewHun, gridBagConstraints);

        tfNewEng.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(tfNewEng, gridBagConstraints);

        btAdd.setText("Hozzáad");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(btAdd, gridBagConstraints);

        jLabel10.setText("Meglévő szó módosítása/törlése:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel10, gridBagConstraints);

        jLabel11.setText("Magyar szó");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel11, gridBagConstraints);

        jLabel12.setText("Angol szó:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(jLabel12, gridBagConstraints);

        tfHun.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(tfHun, gridBagConstraints);

        tfEng.setPreferredSize(new java.awt.Dimension(100, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
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
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(btChange, gridBagConstraints);

        btCancel.setText("Mégse");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(btCancel, gridBagConstraints);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(51, 0, 51));
        jSeparator1.setPreferredSize(new java.awt.Dimension(350, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(jSeparator1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        hunWord = tfNewHun.getText();
        engWord.clear();
        String engText = tfNewEng.getText();
        if (hunWord.equals("") || engText.equals("")) {
            JOptionPane.showMessageDialog(this, "Kérlek add meg a szükséges szavakat", "Üres mező", JOptionPane.PLAIN_MESSAGE);
        } else {

            String[] tempEngWord = engText.split(",");
            engWord.addAll(Arrays.asList(tempEngWord));
            dbConn.addWord(hunWord, engWord);
        }
        tfNewHun.setText("");
        tfNewEng.setText("");
    }//GEN-LAST:event_btAddActionPerformed

    private void btChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChangeActionPerformed
        boolean isDelete = false;
        hunWord = tfHun.getText();
        engWord.clear();
        String engText = tfEng.getText();
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
                    if (isDelete) {
                        dbConn.deleteWord(w);
                    } else {
                        w.setEngWord(engWord);
                        dbConn.updateWord(w);
                    }
                }
            }
        }
        tfHun.setText("");
        tfEng.setText("");
    }//GEN-LAST:event_btChangeActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        tfNewHun.setText("");
        tfNewEng.setText("");
        tfHun.setText("");
        tfEng.setText("");
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btChange;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tfEng;
    private javax.swing.JTextField tfHun;
    private javax.swing.JTextField tfNewEng;
    private javax.swing.JTextField tfNewHun;
    // End of variables declaration//GEN-END:variables
    private DbConnection dbConn;
    private String hunWord;
    private ArrayList<String> engWord = new ArrayList<>();
}