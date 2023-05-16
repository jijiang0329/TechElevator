package com.techelevator;

public class Tutorial {
        public static void main(String[] args) {

                /* *********** Logical Branching Tutorial ***********
                 * In this tutorial, you will write some boolean expressions and use them to
                 * control the flow of your program using if / else statements.
                 * This program tells the user how to prepare for their day based on weather conditions.
                 * *************************************************/

                // Step One: Greet the user
                System.out.println("**************************************");
                System.out.println("*** Welcome to the Weather Station ***");
                System.out.println("**************************************");

                // Step Two: Declare and initialize Weather Station variables
                int highTenperatureF = 55;
                boolean precipitationExpected = true;
                final int FREEZING_TEMPERATURE_F = 32;


                // Step Three: Report today's expected conditions to the user.
                if (precipitationExpected)
                        System.out.println("The chance of precipitation is high.");
                else
                        System.out.println("Today is a nice day!");


                // Step Four: Determine if the user should bring a coat. (when the temperature < 65°F)
                if (highTenperatureF < 65)
                        System.out.println("Don't forget to bring a coat today");


                // Step Five: Determine if the user should bring an umbrella
                boolean isAboveFreezing = highTenperatureF > FREEZING_TEMPERATURE_F;
                if (precipitationExpected && isAboveFreezing)
                        System.out.println("Be sure to pack an umbrella!");


                // Step Six: Advise the user on the type of jacket they should be wearing. (<= 0°F, <= freezing, < 65°F)
                if (highTenperatureF <= 0)
                        System.out.println("Wear everyhting you have!");
                else if (!isAboveFreezing)
                        System.out.println("It is freezing!");
                else if (highTenperatureF < 65)
                        System.out.println("Take a jacket");
                else
                        System.out.println("Have a good day!");


                // Step Seven: If the temperature delta for the day is more than 20°F, advise the user to dress in layers.
                int lowTemperatureF = 34;
                if (highTenperatureF - lowTemperatureF > 20)
                        System.out.println("Dresses in layers today!");
                
        }
}
