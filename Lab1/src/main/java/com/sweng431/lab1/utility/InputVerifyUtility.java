/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sweng431.lab1.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Anthony Vallin
 */
public class InputVerifyUtility 
{
    public boolean checkName(String input) throws NameException
    {
        Pattern specialCharacterPattern = Pattern.compile("[~#@*+%{}<>\\[\\]|\"\\_^]");
        Pattern digitPattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher specialCharacterMatcher = specialCharacterPattern.matcher(input);
        Matcher digitMatcher = digitPattern.matcher(input);
   
        if (specialCharacterMatcher.find())
            throw new NameException("Input contains a special character!");
        else if (digitMatcher.find())
            throw new NameException("Input contains a digit!");
        else if (input.length() < 0 || input.length() > 15)
            throw new NameException("Invalid input length!");
        else
            return true;
    }
    
    public boolean checkAge(int input) throws AgeException
    {
        if ((input > 0) && (input <= 100))
        {
            return true;
        }
        else
        {
            throw new AgeException("Age Exception: " + input + " is invalid!");
        }
    }
}
