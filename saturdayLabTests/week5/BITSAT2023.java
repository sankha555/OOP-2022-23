import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Question {
    /* DECLARE NO ADDITIONAL STATIC OR INSTANCE VARIABLES AND METHODS */
    private String questionText;
    private String answerText;

    public Question(String question){
        questionText = question;
    }

    public String getQuestionText(){
        return questionText;
    }

    public String getAnswerText(){
        return answerText;
    }

    public void setAnswerText(String answerText){
        this.answerText = answerText;
    }

    public void prettyPrintQuestionAndAnswer(){
        System.out.println("Question : \n" + questionText);
        System.out.println("Answer : " + answerText);
    }
}

class SingleOptionCorrectMCQ extends Question {
    /* DECLARE NO ADDITIONAL STATIC OR INSTANCE VARIABLES AND METHODS */
    public int optionIndex; // one of 1, 2, 3 and 4

    public SingleOptionCorrectMCQ(String questionText, int optionIndex){
        super(questionText);
        this.optionIndex = optionIndex;
    }
    
    @Override
    public void setAnswerText(String optionText) {
        /* override the method to print the answer for a question with only one correct option */
        String answerText = "";
        switch (this.optionIndex) {
            case 1:
                answerText += "(A) ";
                break;
            
            case 2:
                answerText += "(B) ";
                break;
            
            case 3:
                answerText += "(C) ";
                break;
            
            case 4:
                answerText += "(D) ";
                break;
        }
        
        answerText += optionText;
        
        super.setAnswerText(answerText);
    }
}

class MultipleOptionCorrectMCQ extends Question {
    /* DECLARE NO ADDITIONAL STATIC OR INSTANCE VARIABLES AND METHODS */
    public int[] optionIndices = null;

    public MultipleOptionCorrectMCQ(String questionText, int[] optionIndices){
        /* complete the constructor definition */
        super(questionText);
        this.optionIndices = optionIndices;
    }
    
    @Override
    public void setAnswerText(String correctOptions) {
        /* override the method to print the answer for a question with multiple correct options */
        String[] correctOptionsArray = correctOptions.split(";");
        
        String answerText = "";
        for(int i = 0; i < optionIndices.length; i++){
            int optionIndex = optionIndices[i];
            
            switch (optionIndex) {
                case 1:
                    answerText += "(A) ";
                    break;

                case 2:
                    answerText += "(B) ";
                    break;

                case 3:
                    answerText += "(C) ";
                    break;

                case 4:
                    answerText += "(D) ";
                    break;
            }
            
            answerText += correctOptionsArray[i];
            
            if(i < (optionIndices.length - 1)){
                answerText += "; ";
            }
        }
        super.setAnswerText(answerText);
    }
}

class QuestionParser {
    private static Question[] questions = null; // all parsed questions should be stored in this array 

    public void initializeQuestionArray(int n){
        questions = new Question[n];
    }

    public void parseQuestionFromRawQuestionText(int questionNumber, String rawQuestionAndOptionsText, String answerIndices){
        /* 
         *  parse the question data from the parameters `rawQuestionAndOptionsText` and `answerIndices`, 
         *  generate new questions and store them in the array `questions`. Some local variables have already been
         *  declared and defined for your help.
         */
      
      	String[] tokenizedQuestionText = rawQuestionAndOptionsText.split(";");
        
        boolean isQuestionSOC = tokenizedQuestionText.equals("S");

        String questionText = tokenizedQuestionText[1];
        String[] optionTexts = new String[4];
        for(int i = 0; i < 4; i++){
            optionTexts[i] = tokenizedQuestionText[2+i];
        }
        
        Question question = null;
        
      	if(isQuestionSOC){
            int optionIndex = Integer.parseInt(answerIndices);
            
            // create a new SOC question and handle it appropriately
            question = new SingleOptionCorrectMCQ(questionText, optionIndex);
            question.setAnswerText(optionTexts[optionIndex-1]);
        }else{
            
            String[] tempArray = answerIndices.split(";");
            int[] optionIndices = new int[tempArray.length];
            for(int i = 0; i < tempArray.length; i++){
                optionIndices[i] = Integer.parseInt(tempArray[i]);
            }
            
            String correctOptionsString = "";
            for(int i = 0; i < optionIndices.length; i++){
                correctOptionsString += optionTexts[optionIndices[i]-1];
                if(i < optionIndices.length - 1){
                    correctOptionsString += ";";
                }
            }
            
            // create a new MOC question and handle it appropriately
            question = new MultipleOptionCorrectMCQ(questionText, optionIndices);
            question.setAnswerText(correctOptionsString);
        }
        
        // add the new question to the array of questions
        questions[questionNumber] = question;
    }

    public void prettyPrintAllQuestionAnswers() {
        if(questions == null){
            return;
        }

        int n = questions.length;
        for(int i = 0; i < n; i++){
            /* write code to pretty print the question and answer for each question */
            questions[i].prettyPrintQuestionAndAnswer();
        }
    }
}

/* DO NOT MODIFY ANY CODE BELOW THIS LINE */
public class Solution {
    public static void main(String[] args){
        QuestionParser parser = new QuestionParser();

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        parser.initializeQuestionArray(n);

        for(int i = 0; i < n; i++){
            String questionAndOptions = sc.nextLine();
            String correctAnswerIndices = sc.nextLine();

            parser.parseQuestionFromRawQuestionText(i, questionAndOptions, correctAnswerIndices);
        }

        parser.prettyPrintAllQuestionAnswers();
    }
}