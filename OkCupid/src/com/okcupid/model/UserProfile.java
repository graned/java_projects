/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okcupid.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import static java.util.regex.Pattern.matches;

/**
 *
 * @author Jose Anaya
 * 
 * This class will help to create user profiles.
 */
public class UserProfile {
    private int id;
    private final Map<Integer,Answer> answers;
    private final TreeMap<Double, Integer> matches;

    /**
     * This constructor initializes the maps we will use to store the answers given by the user and the 
     * matches per user
     */
    public UserProfile(){
        answers = new HashMap<Integer,Answer>();
        matches = new TreeMap<Double, Integer>(new Comparator<Double>(){
            public int compare(Double d1, Double d2){
                if(d1 > d2){
                    return -1;
                }else if(d1 < d2){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
    }
    /**
     * Returns the id of the user
     * @return id 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * returns the answers given by the user
     * @return Map<Integer, Answer>  
     */
    public Map<Integer, Answer> getAnswers() {
        return answers;
    }

    /**
     * adds a new answer to the user's answer collection
     * @param questionId
     * @param answer 
     */
    public void addAnswer(int questionId, Answer answer) {
        this.answers.put(questionId, answer);
    }

    /**
     * returns the matches of the user
     * @return TreeMap<Double, Integer>
     */
    public TreeMap<Double, Integer> getProfileMatches() {
        return matches;
    }

    /**
     * Adds a new match to the user.
     * If the map exceeds 10 elements after insertion of new match
     *      remove last element. This will keep only the top 10 matches per user
     * @param userProfile
     * @param percentage 
     */
    public void addMatch(UserProfile userProfile, double percentage) {
        if(matches.isEmpty() || matches.size() < 10){
           matches.put(percentage, userProfile.id);
        }else{
            matches.put(percentage, userProfile.id);
            matches.pollLastEntry();
        }
    }
}
