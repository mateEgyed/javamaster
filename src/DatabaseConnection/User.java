/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

/**
 *
 * @author Mate
 */
public class User {
    private int userID;
    private String userName;
    private int questionCount;
    private int correctAnswer;
    private int wrongAnswer;
    private double ratio;

    public User(int userID, String userName, int questionCount, int correctAnswer, int wrongAnswer, double ratio) {
        this.userID = userID;
        this.userName = userName;
        this.questionCount = questionCount;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
        this.ratio = ratio;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount() {
        this.questionCount++;
        setRatio();
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer() {
        this.correctAnswer++;
    }

    public int getWrongAnswer() {
        return wrongAnswer;
    }

    public void setWrongAnswer() {
        this.wrongAnswer++;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio() {
        this.ratio = ((double)correctAnswer/questionCount)*100;
    }
    
}
