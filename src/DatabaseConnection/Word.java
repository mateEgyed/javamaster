/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.util.ArrayList;

/**
 *
 * @author Mate
 */
public class Word {
    private int hunId;
    private ArrayList<Integer> engId;
    private String hunWord;
    private ArrayList<String> engWord;
   /* private double ratio;
    private int questionCount;*/

    public Word(int hunId, ArrayList<Integer> engId, String hunWord, ArrayList<String> engWord) {
        this.hunId = hunId;
        this.engId = engId;
        this.hunWord = hunWord;
        this.engWord = engWord;
        /*this.ratio = ratio;
        this.questionCount = questionCount;*/
    }

    public int getHunId() {
        return hunId;
    }

    public void setHunId(int hunId) {
        this.hunId = hunId;
    }

    public ArrayList<Integer> getEngId() {
        return engId;
    }

    public void setEngId(ArrayList<Integer> engId) {
        this.engId = engId;
    }

    public String getHunWord() {
        return hunWord;
    }

    public void setHunWord(String hunWord) {
        this.hunWord = hunWord;
    }

    public ArrayList<String> getEngWord() {
        return engWord;
    }

    public void setEngWord(ArrayList<String> engWord) {
        this.engWord = engWord;
    }
    
    public void addEngWord(String word){
        engWord.add(engWord.lastIndexOf(word)+1, word);
    }
    
    public void addEngId(int id){
        engId.add(engId.size(), id);
    }

   /* public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }*/
    
}
