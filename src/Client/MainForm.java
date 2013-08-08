/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import DatabaseConnection.Word;
import DatabaseConnection.DbConnection;
import DatabaseConnection.Statistics;
import DatabaseConnection.User;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Mate
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((screenSize.width-this.getWidth())/2, (screenSize.height-this.getHeight())/2);
        enter.setLocationRelativeTo(this);
        enter.setVisible(true);
        
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

        pnResult = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        lbAnswer = new javax.swing.JLabel();
        lbRate = new javax.swing.JLabel();
        pnWords = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbHunWord = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfEngWord = new javax.swing.JTextField();
        btCheck = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbUserName = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        miFile = new javax.swing.JMenu();
        miUserChange = new javax.swing.JMenuItem();
        miExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miAddWord = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Szótár");
        setPreferredSize(new java.awt.Dimension(600, 500));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                check(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        pnResult.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        pnResult.setPreferredSize(new java.awt.Dimension(188, 150));
        pnResult.setLayout(new java.awt.GridLayout(2, 2, 2, 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("A helyes megoldás:");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pnResult.add(jLabel1);

        lbIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnResult.add(lbIcon);

        lbAnswer.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        lbAnswer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAnswer.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(204, 204, 204), null, new java.awt.Color(102, 102, 102)));
        pnResult.add(lbAnswer);

        lbRate.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        pnResult.add(lbRate);

        getContentPane().add(pnResult, java.awt.BorderLayout.PAGE_END);

        pnWords.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        pnWords.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("Magyar szó:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        pnWords.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Angol szó:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        pnWords.add(jLabel6, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        pnWords.add(lbHunWord, gridBagConstraints);

        jLabel4.setText("Kérlek add meg az alábbi magyar szó angol megfelelőjét.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.ipady = 6;
        gridBagConstraints.insets = new java.awt.Insets(21, 0, 21, 0);
        pnWords.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 10;
        pnWords.add(tfEngWord, gridBagConstraints);

        btCheck.setText("Ellenőriz");
        btCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCheckActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        pnWords.add(btCheck, gridBagConstraints);

        jLabel2.setText("Üdvözöllek:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        pnWords.add(jLabel2, gridBagConstraints);

        lbUserName.setPreferredSize(new java.awt.Dimension(50, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        pnWords.add(lbUserName, gridBagConstraints);

        getContentPane().add(pnWords, java.awt.BorderLayout.CENTER);

        miFile.setText("File");

        miUserChange.setText("Felhasználóváltás...");
        miUserChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUserChangeActionPerformed(evt);
            }
        });
        miFile.add(miUserChange);

        miExit.setText("Kilépés");
        miExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miExitActionPerformed(evt);
            }
        });
        miFile.add(miExit);

        jMenuBar1.add(miFile);

        jMenu2.setText("Szerkesztés");

        miAddWord.setText("Szó hozzáadás/módosítás...");
        miAddWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddWordActionPerformed(evt);
            }
        });
        jMenu2.add(miAddWord);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miUserChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUserChangeActionPerformed
        if(currentUser != null){
            enter = new EnterForm(this, true, dbConn, true);
            enter.setLocationRelativeTo(this);
            enter.setVisible(true);
        }
    }//GEN-LAST:event_miUserChangeActionPerformed

    private void miExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miExitActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(this, "Biztos hogy kilépsz?",
                "Kilépés", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_miExitActionPerformed

    private void miAddWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddWordActionPerformed
        word.setLocationRelativeTo(this);
        word.setVisible(true);
    }//GEN-LAST:event_miAddWordActionPerformed

    private void check(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_check
        if (enter != null && enter.getSessionUser() != null) {
            currentUser = enter.getSessionUser();
            enter = null;
        }
        if (!currentUserName.equals(currentUser.getUserName())) {
            currentUserName = currentUser.getUserName();
            lbUserName.setText(currentUserName);
            sessionCorrectAnswer = 0;
            sessionQuestionCount = 0;
            sessionWrongAnswer = 0;
            sessionRatio = 0.0;
        }
        setWord();

    }//GEN-LAST:event_check

    private void btCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCheckActionPerformed
        String tempEng = "";
        String labelEng = "";
        String[] answerEng = null;
        for (Word w : dbConn.getAllWords()) {
            if (tempWordId == w.getHunId()) {
                String tempHun = w.getHunWord();
                answerEng = w.getEngWord().toArray(new String[w.getEngWord().size()]);
            }
        }

        boolean contains = false;
        if (!(tempEng = tfEngWord.getText()).equals("")) {
            for (int i = 0; i < answerEng.length; i++) {
                if (answerEng[i].equals(tempEng)) {
                    contains = true;
                }
            }
            if (contains) {
                lbRate.setText("Gratulálok eltaláltad");
                currentUser.setCorrectAnswer();
                statistics.setCorrectAnswer();
                sessionCorrectAnswer++;
                lbIcon.setIcon(rightIcon);
            } else {
                lbRate.setText("Sajnos most nem sikerült");
                statistics.setWrongAnswer();
                currentUser.setWrongAnswer();
                sessionWrongAnswer++;
                lbIcon.setIcon(wrongIcon);
            };
            currentUser.setQuestionCount();
            currentUser.setRatio();
            statistics.setQuestionCount();
            statistics.setRatio();
            sessionQuestionCount++;
            btCheck.setEnabled(false);
            for (int i = 0; i < answerEng.length; i++) {
                labelEng += answerEng[i] + ",";

            }

            lbAnswer.setText(labelEng);
            dbConn.updateUser(currentUser);
            dbConn.updateStatistics(statistics);
            for (Word w : dbConn.getAllWords()) {
                if (tempWordId == w.getHunId()) {
                    stat.setStaticstics(
                            currentUser.getQuestionCount(),
                            currentUser.getCorrectAnswer(),
                            currentUser.getWrongAnswer(),
                            currentUser.getRatio(),
                            statistics.getQuestionCount(),
                            statistics.getCorrectAnswer(),
                            statistics.getWrongAnswer(),
                            statistics.getRatio(),
                            sessionQuestionCount,
                            sessionCorrectAnswer,
                            sessionWrongAnswer,
                            sessionRatio,
                            w.getHunWord(),
                            answerEng);
                    Point p = this.getLocation();
                    stat.setLocation(p);
                    stat.setVisible(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Kérlek előszőr írd be a fordítást", "Adj meg egy szót", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btCheckActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    private void setWord() {
        Random rnd = new Random();
        btCheck.setEnabled(true);
        lbAnswer.setText("");
        lbRate.setText("");
        tfEngWord.setText("");
        lbIcon.setIcon(null);

        if (dbConn.getAllWords().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Az adatbázis jelenleg üres adjon hozzá új szavakat", "Üres", JOptionPane.PLAIN_MESSAGE);
            word.setLocationRelativeTo(this);
            word.setVisible(true);
        } else {
            dbConn.selectStatistic(currentUser.getUserID());
            rndList = rand.getWeightingRandom(2, 7, 3);
            switch (rndList) {
                case 1:
                    if (!dbConn.getIncorrectWords().isEmpty()) {
                        rndWord = rnd.nextInt(dbConn.getIncorrectWords().size());
                        lbHunWord.setText(dbConn.getIncorrectWords().get(rndWord).getHunWord());
                        tempWordId = dbConn.getIncorrectWords().get(rndWord).getHunId();
                    } else {
                        rndWord = rnd.nextInt(dbConn.getWords().size());
                        lbHunWord.setText(dbConn.getWords().get(rndWord).getHunWord());
                        tempWordId = dbConn.getWords().get(rndWord).getHunId();
                    }
                    break;
                case 2:
                    if (!dbConn.getWords().isEmpty()) {
                        rndWord = rnd.nextInt(dbConn.getWords().size());
                        lbHunWord.setText(dbConn.getWords().get(rndWord).getHunWord());
                        tempWordId = dbConn.getWords().get(rndWord).getHunId();
                    } else {
                        rndWord = rnd.nextInt(dbConn.getIncorrectWords().size());
                        lbHunWord.setText(dbConn.getIncorrectWords().get(rndWord).getHunWord());
                        tempWordId = dbConn.getIncorrectWords().get(rndWord).getHunId();
                    }
                    break;
            }
            for (Statistics s : dbConn.getStatistics()) {
                if (s.getWordId() == (tempWordId)) {
                    statistics = s;
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCheck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbAnswer;
    private javax.swing.JLabel lbHunWord;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbRate;
    private javax.swing.JLabel lbUserName;
    private javax.swing.JMenuItem miAddWord;
    private javax.swing.JMenuItem miExit;
    private javax.swing.JMenu miFile;
    private javax.swing.JMenuItem miUserChange;
    private javax.swing.JPanel pnResult;
    private javax.swing.JPanel pnWords;
    private javax.swing.JTextField tfEngWord;
    // End of variables declaration//GEN-END:variables
    private DbConnection dbConn = new DbConnection();
    private EnterForm enter = new EnterForm(this, true, dbConn,false);
    private StatisticForm stat = new StatisticForm(this, true);
    private WeightingRandom rand = new WeightingRandom();
    private WordForm word = new WordForm(this, true, dbConn);
    private Icon rightIcon = new ImageIcon("r.jpg");
    private Icon wrongIcon = new ImageIcon("w.jpg");
    private User currentUser;
    private Statistics statistics;
    private int rndWord;
    private int rndList;
    private int tempWordId;
    private int sessionQuestionCount;
    private int sessionCorrectAnswer;
    private int sessionWrongAnswer;
    private double sessionRatio;
    private String currentUserName = "";
}