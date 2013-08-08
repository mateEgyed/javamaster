/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 *
 * @author Mate
 */
public class DbConnection {

    private Connection conn;
    private PreparedStatement preparedStatement;
    private ArrayList<User> users;
    private ArrayList<Statistics> statistics;
    private ArrayList<Word> allWords;
    private ArrayList<Word> words;
    private ArrayList<Word> incorrectWords;
    public static final double ratioLimit = 40;

    public DbConnection() {
        try {
            String dbAddress = "jdbc:mysql://localhost/javamaster_dictionary?user=root&password=root";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbAddress);
            users = new ArrayList<>();
            statistics = new ArrayList<>();
            allWords = new ArrayList<>();
            words = new ArrayList<>();
            incorrectWords = new ArrayList<>();
            selectUser();
            selectAllWord();

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hiba a driver betöltésnél: \n" + ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hiba az adatbázis kapcsolódásnál: \n" + ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void selectUser() {
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM users");
            ResultSet rs = preparedStatement.executeQuery();
            users.clear();
            while (rs.next()) {
                users.add(new User(rs.getInt("user_id"),
                        rs.getString("user_name"),
                        rs.getInt("question_count"),
                        rs.getInt("correct_answer"),
                        rs.getInt("wrong_answer"),
                        rs.getDouble("ratio")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hiba a felhasználó kiválasztásnál: \n" + ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void addUser(String userName) {
        try {
            int autoID = 0;
            preparedStatement = conn.prepareStatement("INSERT INTO users values (default, ?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, userName);
            preparedStatement.setInt(2, 0);
            preparedStatement.setInt(3, 0);
            preparedStatement.setInt(4, 0);
            preparedStatement.setDouble(5, 0);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                autoID = rs.getInt(1);
            }
            
            preparedStatement = conn.prepareStatement("INSERT INTO statistics values (?,?,?,?,?,?)");
            for (int i = 0; i < allWords.size(); i++) {
                preparedStatement.setInt(1, autoID);
                preparedStatement.setInt(2, i + 1);
                preparedStatement.setInt(3, 0);
                preparedStatement.setInt(4, 0);
                preparedStatement.setInt(5, 0);
                preparedStatement.setDouble(6, 0);
                preparedStatement.executeUpdate();
            }
            selectUser();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hiba az új felhasználó hozzáadásánál: \n" + ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public Iterator<User> getUsers() {
        return users.iterator();
    }

    public void updateUser(User current) {
        try {
            preparedStatement = conn.prepareStatement("UPDATE users SET user_name = ?, question_count = ?, "
                    + "correct_answer = ?, wrong_answer = ?, ratio = ? WHERE user_id = ?");
            preparedStatement.setString(1, current.getUserName());
            preparedStatement.setInt(2, current.getQuestionCount());
            preparedStatement.setInt(3, current.getCorrectAnswer());
            preparedStatement.setInt(4, current.getWrongAnswer());
            preparedStatement.setDouble(5, current.getRatio());
            preparedStatement.setInt(6, current.getUserID());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hiba a felhasználó adatainak frissítésénél: \n" + ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        }
        selectUser();
    }

    private void selectAllWord() {
        try {
            preparedStatement = conn.prepareStatement("SELECT h.hun_id,e.eng_id, h.hun_word, e.eng_word "
                    + "FROM hun_word AS h INNER JOIN words AS w ON h.hun_id = w.hun_id "
                    + "INNER JOIN eng_word AS e ON w.eng_id = e.eng_id");
            ResultSet rs = preparedStatement.executeQuery();
            allWords.clear();
            int tmpID = 0;
            while (rs.next()) {
                ArrayList<String> tmpEng = new ArrayList<>();
                ArrayList<Integer> tmpEngId = new ArrayList<>();
                int tempId = rs.getInt("hun_id");
                if (tmpID == tempId) {
                    allWords.get(allWords.size() - 1).addEngWord(rs.getString("eng_word"));
                    allWords.get(allWords.size() - 1).addEngId(rs.getInt("eng_id"));
                } else {
                    tmpEng.add(rs.getString("eng_word"));
                    tmpEngId.add(rs.getInt("eng_id"));
                    allWords.add(new Word(tempId,
                            tmpEngId,
                            rs.getString("hun_word"),
                            tmpEng));
                    tmpID = tempId;
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hiba a szavak lekérdezésénél: \n" + ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void selectWord() {
        incorrectWords.clear();
        words.clear();
        for (int i = 0; i < allWords.size(); i++) {
            if (allWords.get(i).getHunId() == statistics.get(i).getWordId()) {
                if (statistics.get(i).getRatio() < ratioLimit || statistics.get(i).getQuestionCount() <= 0) {
                    incorrectWords.add(allWords.get(i));
                } else {
                    words.add(allWords.get(i));
                }
            }
        }
    }

    public ArrayList<Word> getAllWords() {
        return allWords;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public ArrayList<Word> getIncorrectWords() {
        return incorrectWords;
    }

    public void selectStatistic(int userID) {
        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM statistics WHERE user_id = ?");
            preparedStatement.setInt(1, userID);
            ResultSet rs = preparedStatement.executeQuery();
            statistics.clear();
            while (rs.next()) {
                statistics.add(new Statistics(rs.getInt("word_id"),
                        rs.getInt("user_id"),
                        rs.getInt("question_count"),
                        rs.getInt("correct_answer"),
                        rs.getInt("wrong_answer"),
                        rs.getDouble("ratio")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hiba a szó statisztika lekérdezésénél: \n" + ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        }
        selectAllWord();
        selectWord();
    }

    public ArrayList<Statistics> getStatistics() {
        return statistics;
    }

    public void updateStatistics(Statistics current) {
        try {
            preparedStatement = conn.prepareStatement("UPDATE statistics SET user_id = ?, word_id = ?, question_count = ?, correct_answer = ?, wrong_answer = ?,"
                    + "ratio = ? WHERE user_id = ?" + " AND word_id = ?");
            preparedStatement.setInt(1, current.getUserID());
            preparedStatement.setInt(2, current.getWordId());
            preparedStatement.setInt(3, current.getQuestionCount());
            preparedStatement.setInt(4, current.getCorrectAnswer());
            preparedStatement.setInt(5, current.getWrongAnswer());
            preparedStatement.setDouble(6, current.getRatio());
            preparedStatement.setInt(7, current.getUserID());
            preparedStatement.setInt(8, current.getWordId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hiba a szó statisztika frissítésénél: \n" + ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        }
        selectStatistic(current.getUserID());
    }

    public void addWord(String hunWord, ArrayList<String> engWord) {
        try {
            int autoHunId = 0;
            int[] autoEngId = new int[engWord.size()];
            int it = 0;
            preparedStatement = conn.prepareStatement("INSERT INTO hun_word VALUES (default, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, hunWord);
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                autoHunId = rs.getInt(1);
            }
            for (String eng : engWord) {
                preparedStatement = conn.prepareStatement("INSERT INTO eng_word VALUES (default, ?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, eng);
                preparedStatement.executeUpdate();
                ResultSet rs2 = preparedStatement.getGeneratedKeys();
                if (rs2.next()) {
                    autoEngId[it] = rs2.getInt(1);
                    it++;
                }
            }

            for (int i = 0; i < autoEngId.length; i++) {
                preparedStatement = conn.prepareStatement("INSERT INTO words VALUES (?, ?);");
                preparedStatement.setInt(1, autoHunId);
                preparedStatement.setInt(2, autoEngId[i]);
                preparedStatement.executeUpdate();
            }
            preparedStatement = conn.prepareStatement("INSERT INTO statistics VALUES (?,?,?,?,?,?)");
            for (int i = 0; i < users.size(); i++) {
                preparedStatement.setInt(1, users.get(i).getUserID());
                preparedStatement.setInt(2, autoHunId);
                preparedStatement.setInt(3, 0);
                preparedStatement.setInt(4, 0);
                preparedStatement.setInt(5, 0);
                preparedStatement.setDouble(6, 0);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hiba az új szó hozzáadásánál: \n" + ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        }
        selectAllWord();
    }

    public void updateWord(Word currentWord) {
        try {
            int autoEngId = 0;
            int tempIdSize = currentWord.getEngId().size();
            int tempEngSize = currentWord.getEngWord().size();
            for(int i = 0; i<tempIdSize;i++){
                    preparedStatement = conn.prepareStatement("DELETE FROM eng_word WHERE eng_id =?");
                    preparedStatement.setInt(1, currentWord.getEngId().get(i));
                    preparedStatement.executeUpdate();
            }
            for(int j=0;j<tempEngSize;j++){
                    preparedStatement = conn.prepareStatement("INSERT INTO eng_word VALUES (default,?)", Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1, currentWord.getEngWord().get(j));
                    preparedStatement.executeUpdate();
                    ResultSet rs = preparedStatement.getGeneratedKeys();
                    if (rs.next()) {
                        autoEngId = rs.getInt(1);
                    }
                    preparedStatement = conn.prepareStatement("INSERT INTO words VALUES (?,?)");
                    preparedStatement.setInt(1, currentWord.getHunId());
                    preparedStatement.setInt(2, autoEngId);
                    preparedStatement.executeUpdate();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hiba a szó frissítésénél: \n" + ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        }

    }

    public void deleteWord(Word currentWord) {
        try {
            preparedStatement = conn.prepareStatement("DELETE FROM `hun_word` WHERE hun_id =?");
            preparedStatement.setInt(1, currentWord.getHunId());
            preparedStatement.executeUpdate();
            for (Integer w : currentWord.getEngId()) {
                preparedStatement = conn.prepareStatement("DELETE FROM `eng_word` WHERE eng_id =?");
                preparedStatement.setInt(1, w);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Hiba a szó törlésénél: \n" + ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        }
    }

    @Override
    public void finalize() {
        try {
            super.finalize();
            if (conn != null) {
                conn.close();
            }
        } catch (Throwable ex) {
            JOptionPane.showMessageDialog(null, "Hiba a kapcsolat bontásánál: \n" + ex.getMessage(), "Exception", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
