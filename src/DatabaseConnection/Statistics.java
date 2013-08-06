/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

/**
 *
 * @author Mate
 */
public class Statistics {
    private int wordId;
    private int userID;
    private int questionCount;
    private int correctAnswer;
    private int wrongAnswer;
    private double ratio;

    public Statistics(int wordId, int userID, int questionCount, int correctAnswer, int wrongAnswer, double ratio) {
        this.wordId = wordId;
        this.userID = userID;
        this.questionCount = questionCount;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
        this.ratio = ratio;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
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
