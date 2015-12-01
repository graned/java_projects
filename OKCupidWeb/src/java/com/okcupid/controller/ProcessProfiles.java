/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okcupid.controller;

import com.okcupid.model.Answer;
import com.okcupid.model.UserProfile;
import java.util.List;
import java.util.Map;

/**
 *
 * This class will help process the profiles, and determine the matches of users
 * @author Jose Anaya
 */
public class ProcessProfiles {
    
    private double sameAnsweredQuestions;
    public ProcessProfiles() {
    }
    /**
     * This method will calculate the matches of 2 profiles
     * First loop will get every profile from a list provided and then second loop will start from the next
     * element to the right. 
     * 
     * @param users 
     */
    public void calculateMatches(List<UserProfile> users){
        for (UserProfile userProfile : users) {
            for (int i = users.indexOf(userProfile) + 1; i < users.size(); i++) {
                getMatchPercentage(userProfile, users.get(i));
            }
        }
    }
    /**
     * this method, will determine the match percentage between 2 profiles
     * @param profileOne
     * @param profileTwo
     * @return 
     */
    public double getMatchPercentage(UserProfile profileOne, UserProfile profileTwo){
        double matchPercentageOne = getHappinessPercentage(profileOne, profileTwo); 
        double matchPercentageTwo = getHappinessPercentage(profileTwo, profileOne);
        double matchPercentage = Math.sqrt((matchPercentageOne*matchPercentageTwo));
        double errorMargin = 1/sameAnsweredQuestions;
        double trueMatchPercentage = (matchPercentage - errorMargin) * 100;
        profileOne.addMatch(profileTwo, trueMatchPercentage);
        profileTwo.addMatch(profileOne, trueMatchPercentage);
        return trueMatchPercentage;
    }
    /**
     * this method will add all importance values from a specified profile
     * @param profile
     * @return 
     */
    private double getImportance(UserProfile profile){
        double importanceCounter = 0;
        for (Answer answer : profile.getAnswers().values()) {
            importanceCounter += answer.getImportance();
        }
        return importanceCounter;
    }
    
    /**
     * This method will determine the happiness percentage between 2 profiles, based on the  formula provided
     * @param profileOne
     * @param profileTwo
     * @return 
     */
    private double getHappinessPercentage(UserProfile profileOne, UserProfile profileTwo){
        Map<Integer, Answer> profileOneAnswers = profileOne.getAnswers();
        Map<Integer, Answer> profileTwoAnswers = profileTwo.getAnswers();
        sameAnsweredQuestions = 0;
        double profileTwoImportancePoints = 0;
        for (int questionId : profileOneAnswers.keySet()) {
            if(profileTwoAnswers.keySet().contains(questionId)){
                ++sameAnsweredQuestions;
                int profileTwoAnswer = profileTwoAnswers.get(questionId).getAnswer();
                if(profileOneAnswers.get(questionId).getAcceptableAnswers().contains(profileTwoAnswer)){
                    profileTwoImportancePoints += profileOneAnswers.get(questionId).getImportance();
                }
            }
        }
        return profileTwoImportancePoints/getImportance(profileOne);
    }
}
