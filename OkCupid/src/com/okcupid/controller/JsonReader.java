/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.okcupid.controller;

import com.okcupid.model.Answer;
import com.okcupid.model.UserProfile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class will help to read the JSON files
 *
 * @author Jose Anaya
 */
public class JsonReader {

    /**
     * this method will read a json file and will create the user profile
     * objects, those objects will get stored in an arraylist and will be
     * returned
     *
     * @return
     */
    public ArrayList<UserProfile> readJSONFile() {
        ArrayList<UserProfile> usersList = new ArrayList<>();
        StringBuilder inputJSONFile = new StringBuilder();
        UserProfile userProfile;
        Answer answer;
        try {
            String line;
            FileReader fr = new FileReader("input.json");
            BufferedReader br = new BufferedReader(fr);
            System.out.println("Reading file...");
            while ((line = br.readLine()) != null) {
                inputJSONFile.append(line);
            }
            JSONObject inputJSON = new JSONObject(inputJSONFile.toString());
            JSONArray jsonProfiles = inputJSON.getJSONArray("profiles");
            for (int i = 0; i < jsonProfiles.length(); i++) {
                userProfile = new UserProfile();
                JSONObject jsonProfile = jsonProfiles.getJSONObject(i);
                userProfile.setId(jsonProfile.getInt("id"));
                //Goes through all answers in the profile
                JSONArray answersJSON = jsonProfile.getJSONArray("answers");
                for (int j = 0; j < answersJSON.length(); j++) {
                    try {
                        JSONObject jsonAnswer = answersJSON.getJSONObject(j);
                        JSONArray acceptableAnswersJSON = jsonAnswer.getJSONArray("acceptableAnswers");
                        answer = new Answer();
                        ArrayList<Integer> acceptabeAnswers = new ArrayList<>();
                        for (int k = 0; k < acceptableAnswersJSON.length(); k++) {
                            acceptabeAnswers.add(acceptableAnswersJSON.getInt(k));
                        }
                        answer.setQuestionId(jsonAnswer.getInt("questionId"));
                        answer.setAnswer(jsonAnswer.getInt("answer"));
                        answer.setImportance(jsonAnswer.getInt("importance"));
                        answer.setAcceptableAnswers(acceptabeAnswers);
                        userProfile.addAnswer(answer.getQuestionId(), answer);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                usersList.add(userProfile);
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }

    /**
     * This method will return a JSON object with matching results
     *
     * @param results
     * @return
     */
    public JSONObject generateJSONresult(ArrayList<UserProfile> results) {
        JSONObject outputJSON = new JSONObject();
        try {
            JSONArray resultsArrayJSON = new JSONArray();
            outputJSON.put("results", resultsArrayJSON);
            for (UserProfile user : results) {
                JSONObject resultJSON = new JSONObject();
                resultJSON.put("profileId", user.getId());
                JSONArray matchesArrayJSON = new JSONArray();
                resultJSON.put("matches",matchesArrayJSON);
                for (int i = 0; i<user.getProfileMatches().values().size();i++) {
                    JSONObject matchProfile = new JSONObject();
                    matchProfile.put("profileId", user.getProfileMatches().values().toArray()[i]);
                    DecimalFormat df = new DecimalFormat("#.##");
                    matchProfile.put("score", df.format(user.getProfileMatches().keySet().toArray()[i]));
                    matchesArrayJSON.put(matchProfile);
                }
                resultsArrayJSON.put(resultJSON);
            }
            // Printing the generated JSON to console
            System.out.println("\n" + outputJSON.toString());

        }catch(JSONException e) {
            e.printStackTrace();
        }
        return outputJSON;

    }

}
