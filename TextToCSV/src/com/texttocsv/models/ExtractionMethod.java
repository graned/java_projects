/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.texttocsv.models;

/**
 *
 * @author j.anaya.villagrana
 */
public enum ExtractionMethod {

    VPN("VPN"),
    CLEAR_QUEST("CLEAR_QUEST");
    private final String extractionMethod;

    private ExtractionMethod(String extractionMethod) {
        this.extractionMethod = extractionMethod;
    }

    public String toString() {
        return extractionMethod;
    }
}
