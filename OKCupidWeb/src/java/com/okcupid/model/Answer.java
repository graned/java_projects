/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okcupid.model;

import java.util.ArrayList;

/**
 *
 * @author Jose Anaya
 * This class will help create and manipulate the answers given by a user
 */
public class Answer {
    private int answer;
    private int questionId;
    private int importance;
    private ArrayList<Integer> acceptableAnswers;

    /**
     * returns the answer given by the user
     * @return int
     */
    public int getAnswer() {
        return answer;
    }

    /**
     * sets the answer given by the user
     * @param answer 
     */
    public void setAnswer(int answer) {
        this.answer = answer;
    }

    /**
     * returns the question id
     * @return int
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * sets the question id
     * @param questionId 
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * returns the importance value
     * @return int
     */
    public int getImportance() {
        return importance;
    }

    /**
     * sets the importance value
     * @param importance 
     */
    public void setImportance(int importance) {
        this.importance = importance;
    }

    /**
     * returns the acceptable answers 
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getAcceptableAnswers() {
        return acceptableAnswers;
    }

    /**
     * sets the acceptable answers
     * @param acceptableAnswers 
     */
    public void setAcceptableAnswers(ArrayList<Integer> acceptableAnswers) {
        this.acceptableAnswers = acceptableAnswers;
    }
}
