package com.example;

// Janet Weber    9/8/2015
// Decoder assignment: Week 4 In-class Lab :
// Write a program that reads characters and converts it from an everyday phrase
// like "What a nice day it is." to "We need to blow up the bridge at 9pm." using
// unicode characters

// I chose to look for 2 secret words (fun or money) in a phrase that would
// signal a different mission for the recipient.  The phrases are initialized
// within the code (would be more interesting if input was received from user).
// More secret words and unicode missions can be created at a later date.

public class decoderClass {
    public static void main(String[] args){

        // Create some possible phrases using the 2 secret words.  Load them into an array.
        String[] everydayPhrase = new String[12];
        everydayPhrase[0] = "Are we having fun yet!";
        everydayPhrase[1] = "We'll have fun, fun, fun 'til daddy takes the T-bird away!";
        everydayPhrase[2] = "Let's do it for the fun of it!";
        everydayPhrase[3] = "Time flies when you're having fun!";
        everydayPhrase[4] = "It was fun while it lasted.";
        everydayPhrase[5] = "That was more fun than a barrel of monkeys!";

        everydayPhrase[6] = "I hope you get your money's worth!";
        everydayPhrase[7] = "He really gave you a run for your money!";
        everydayPhrase[8] = "Money doesn't grow on trees.";
        everydayPhrase[9] = "Money talks!";
        everydayPhrase[10] = "Put your money where your mouth is.";
        everydayPhrase[11] = "Time is money.";

        // set up secret word #1 fun
        CharSequence bombWord = "fun";
        CharSequence bombWord2 = "Fun";
        final int BOMB_CODE = 1;               // constant to be used Switch statement later

        // set up secret word #2
        CharSequence gunWord = "money";
        CharSequence gunWord2 = "Money";
        final int GUN_CODE = 2;                // constant to be used in Switch statement later

        //  set up remaining necessary variables
        final int SAFE_CODE = 0;               // code used in Switch statement if no secret words are found
        int missionCode;                       // will hold either BOMB_CODE, GUN_CODE or SAFE_CODE
        int numPhrases = everydayPhrase.length;// holds the number of phrases (ideally we'd get
                                               //     input from user, but this is for now)
        String missionObjective;               // holds the output (or mission) unicode string
        String missionEnglish;                 // holds English translation of unicode string

        // Check if codewords are in any of the phrases
        for (int i = 0; i<numPhrases; i++) {    // loop thru all the phrases

            // check if the phrase contains either of secret words (all lowercase or beginning w/upper case)
            //    then assign the appropriate missionCode
            if (everydayPhrase[i].contains(bombWord) || (everydayPhrase[i].contains(bombWord2))) {
                missionCode = BOMB_CODE;
            } else if (everydayPhrase[i].contains(gunWord) || (everydayPhrase[i].contains(gunWord2))) {
                missionCode = GUN_CODE;
            } else {
                missionCode = SAFE_CODE;
            } // end of if block

            // based on the missionCode, create the correct output string
            switch(missionCode){

                // No secret words included in phrase so no mission
                case SAFE_CODE : missionObjective = "Mission post-poned until tomorrow!";
                    missionEnglish = "No secret words found. Carry on!"; break;

                // bomb mission => unicode translates to "At pre-set time tonight, bomb
                //     the airplane, then meet at coffee shop.  Good luck"
                case BOMB_CODE : missionObjective = "Unicode Mission: " +
                        "\u23F0 \u263E \u279F \u25C9 \u279F \u03E6" +
                        "\u014F\u019C\u03E6 \u279F \u2708 \u279F \u2615 \u279F \u2618";
                     missionEnglish = "English translation => At pre-set time tonight, bomb " +
                             "the airplane, then meet at coffee shop.  Good luck"; break;

                // gun mission => unicode translates to "In the morning after the phone rings, use
                //      the gun to kill the man in the church. Cut him up and bury him." Weird faces
                //      for fun.
                case GUN_CODE : missionObjective = "Unicode Mission: " +
                        "\u263C \u279F \u260E \u279F \u0260\u0172\u24C3 " +
                        "\u279F \u2642 \u279F \u26EA \u279F \u2701 \u279F \u0253\u0172\u027e\u028E " +
                        "\u279F \u2368\u263A";
                    missionEnglish = "English translation => In the morning after the phone rings, use " +
                            "the gun to kill the man in the church. Cut him up and bury him. " +
                            "(Weird faces for fun.)"; break;

                // shouldn't get here so there's been a mistake
                default: missionObjective = "Warning!  Warning!";
                         missionEnglish = "We messed up!";
            }

            // Print output to terminal
            System.out.println(missionObjective);
            System.out.println(missionEnglish);
            System.out.println("This message will self destruct in 45 seconds!!");
            System.out.println("");
        }  // end of for loop


    }   // end of main()
}  // end of decoderClass
