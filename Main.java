/*
Name: [REDACTED because I don't know if he wants his name here] and Joshua Persaud
Teacher Name: Ms. Krasteva
Date: January 29, 2021
Program Name: Theatre.java
Description: This program is a cinema ticket buying program. We create a face theatre called the WLAMC Cinema for this program.
             With this program, the user can buy tickets for the cinema for one of 5 days. They can choose if they want the tickets
             for any day between Monday to Friday. We have made this program so that no matter when the user runs this program,
             it will keep running until all the seats are eventually full. Since there is no real movie, we just pretend that the
             user is buying tickets for the next week. The user can also look at the seating chart for the cinema on any day. From there
             they can see which seats are available for purchase. They can also see who owns any seat. This is not a conventional thing
             that you see in real life but since this is meant to be a theatre for the school, the people buying tickets
             are local members of one neighborhood. This way, the user can see where their neighbors are sitting and can but tickets
             next to them. When the user does buy tickets, they can buy each seat individually, they can buy seats by sections of a row, or
             by sections of an aisle. There is another method that allows the user to enter a name, and they can see which seats the person
             of that name has bought.

    All of the sources we used can be found at this link (It is a google document):
    https://docs.google.com/document/d/16pDXyHIYVQfWk9ESnYfB0Pk5Kny_MsJou8v_VV-5Z-g/edit?usp=sharing
*/

//Import Libraries
import hsa.Console;     //Gives access to the hsa Console library
import hsa.Message;     //Gives access to the hsa.Message libraries

import java.util.*;     //Gives access to the java.util library

import java.awt.image.*;        //Gives access to the java.awt.image library
import javax.imageio.ImageIO;   //Gives access to the javax.imageio.ImageIO library

import java.awt.*;  //Gives access to the java.awt libraries

import java.io.*;   //Gives access to the java.io libraries

import javax.swing.JOptionPane; //Gives access to the javax.swing.JOptionPane

/*Global Variable Dictionary
_____________________________________________________________________________________________________________________________
Type    | Name              | Desription
________|___________________|________________________________________________________________________________________________
Instance| c                 | This is and instance varibale of the console class. We will use this instance variable to call
        |                   | certain methods that have to be displayed onto a console. This variable allows methods to
        |                   | interact with the console. We can send data to the user and recieve data through user input
________|___________________|________________________________________________________________________________________________
int     | userChoice        | This is used to let the main method know which method to display next. It is given a value
        |                   | through user input in the intro method. Based on that value, there is an if structure in main
        |                   | and that will control what happens next.
________|___________________|________________________________________________________________________________________________
int     | ROWS              | This final variable will be used to hold the value of 20, which is the amount of rows that the
        |                   | theatre has.
________|___________________|________________________________________________________________________________________________
int     | COLUMNS           | This final variable will be used to hold the value of 30, which is the amount of aisles that the
        |                   | theatre has.
________|___________________|________________________________________________________________________________________________
int     | amountOfTickets   | This variable will be used to hold the amount of tickets that the user wants to buy. Taken
        |                   | through input in askData.
________|___________________|________________________________________________________________________________________________
Instance| backgroundColor   | This variable is an instance of the Color class and it will be used to hold the RGB value of
        |                   | 136, 189, 255, which is the RGB color of the background (light blue).
________|___________________|________________________________________________________________________________________________
Instance| accentColor       | This variable is an instance of the Color class and it will be used to hold the RGB value of
        |                   | 16, 52, 166, which is the RGB color of the accents, such as the box that the title is inside of.
________|___________________|________________________________________________________________________________________________
String[]| actualCurrentNames| This variable is a String array of length 2 that will be used to hold the value of the user's
        |                   | first name (at index 0) and the last name (at index 1). This name is taken through input in askData()
________|___________________|________________________________________________________________________________________________
String[]| enteredLocation   | This variable is a String array that will be used to hold the locations that the user entered.
        |                   | This is done in askData()
________|___________________|________________________________________________________________________________________________
boolean | moveOn            | This variable will be used to see if the program should run display() after askData() or not
        |                   | If the user confirms their purchase and inputs all proper credit card information, then moveOn will
        |                   | be true and display will run. If they don't confirm the purchase and make mistakes with the credit
        |                   | card information, moveOn will be false and the display method will be skipped.
________|___________________|________________________________________________________________________________________________
String  | fileName          | This variable will be used to hold the .txt name of the file that the program will be using.
        |                   | The fileName is decided based on what day the user wants to check the theatre for. This is done
        |                   | in the intro() method
________|___________________|________________________________________________________________________________________________
String  | day               | This variable will be used to hold the value of the day that the user is choosing in the menu.
________|___________________|________________________________________________________________________________________________

Method Variables

Scope       Static or Non-Static        Return Type     Name            Parameters (if applicable)          Expected Data
public      Non-Static                  void            splashScreen                                        This method holds the splashScreen that will be called in the main method to run an animation about the theatre.
public      Non-Static                  void            intro                                               This method will hold the introduction and menu for the program. From here, the user can go to the actual program, exit the program, or go to the instructions.
public      Non-Static                  void            instructions                                        This method will hold the instructions that will tell the user how to use the program and get their tickets for the WLMAC theatre.
public      Non-Static                  void            seatingPlan                                         This method will be used to allow the user to see data on a certain seat. They will be able to see the amount of remaining seats, along with the location of the seat and the price of it. If the seat is owned, this method shows who owns it.
public      Non-Static                  void            display                                             This method will be used to display, to the user, many things about their purchase. First, the user will be given a thank you message for purchasing tickets to the WLMAC theatre. They will also be told the amount of tickets that they purchased and the locations of the seats that the user bought. The total price that the user paid for the seats is also shown. Lastly, the user is prompted to press a key to move on with the program by calling on the pause() method.
public      Non-Static                  void            searchByName                                        This method will be used to first ask the user to enter their name and then this method will return the amount of seats that the user owns, along with the total price that they paid, and a grid that shows the locations of the seats that they bought.
public      Non-Static                  void            goodbye                                             This method will allow the user to exit the program without any problems. It will use the close() method to close the program.
private     Non-Static                  void            pause                                               This method will be used as a way to pause the program until the user presses a key to continue. There will also be a prompt to tell the user to press a key. The prompt will be done so fillRect() to make a box, and setColor() to set the color of the box. setFont() will be used to change the font type and font size of the text. Lastly, drawString() will be used to actually display the prompt to the console for the user to see.
private     Non-Static                  void            thickLine       Console console                     This method will take in the 2 x- and y- coordinates for the line that wants to be drawn. It also takes in the thickness of the line (in pixels) and a boolean value, where "true" is if the line should be vertical, or "false" where the line should be horizontal. For the thickness, a for loop is used to repeat the lines one space apart.
                                                                        int xCoordinate1
                                                                        int yCoordinate1
                                                                        int xCoordinate2
                                                                        int yCoordinate2
                                                                        int thickness
                                                                        boolean vertical
private     Non-Static                  void            title                                               This method will hold the title that will be used in multiple methods. It will use a fillRect() method to create the box and also use the drawString() method to create the words for the title. setFont() will be used to change the font and setColor() will be used to change the color.
private     Non-Static                  double          ticketPrice     String seatLocation                 This method will take in the location of the seat and then return the price for that seat. It will do this by taking in the seat's location as a string and from that, it takes the first letter of that string. It will then take the ASCII value of the location, minus 65 from it (because it is uppercase and it has to get to 0), and then runs a for loop that starts at 0 and ends when the iteration is at whatever the row is (so i <= row). After every iteration, the price, which is at $25, has $0.75 subtracted from it. When the for loop is done, the new price is returned.
private     Non-Static                  void            borderMaker                                         This method will be used to create a white rectangle at the top and left side of the console. A black line is also created on the left and right sides. This helps stop any colours from the input from going past the borders and making the output screen look bad.
public      Non-Static                  N/A             Theatre                                             This is the class constructor for the program and it takes the variable "c" which was declared to a Console class, and initializes it with a new Console(); .
public      Static                      void            main            String[] args                       This is the main method for the program, and it is used to call on the other methods so that the program runs perfectly.
*/

public class Theatre
{
    Console c;

    int userChoice;

    final int ROWS = 20;
    final int COLUMNS = 30;

    int amountOfTickets;

    Color backgroundColor = new Color (136, 189, 255); // hex = #88bdff
    Color accentColor = new Color (16, 52, 166); // hex = #1034a6

    String[] actualCurrentNames = new String [2];
    String[] enteredLocation;

    boolean moveOn = true;

    String fileName = "";
    String day = "";


    /*  borderMaker Method:

        There are no variables used in this method

        This method is used to create a rectangle on the top and the left side of the console window. When we take input in askData(), we use
        textBackgroundColor to make a box behind the input. This is done to error trap so that if we need to take input again, the wrong input
        will get covered by the backgroundcolor. When we do this, we end up adding that colour all the way to the edges of the console window.
        For our design, we want to have a white border on all the edges with a black outline. So this method creates two white rectanges on the
        top and bottom of the console window. We also make 2 black lines on the left and right. This cleans up any messes that may happen.
        We call this method after we take input in askData so that no matter what, it always gets cleaned up. We set the colour back to white at the end.
    */
    private void borderMaker ()
    {
        c.setColor (Color.WHITE);
        c.fillRect (0, 0, 10, 600); //Box on the left of the console
        c.fillRect (0, 0, 904, 10); //Box on the top of the console

        c.setColor (Color.BLACK);
        thickLine (c, 10, 10, 10, 600, 2, true);    //Line on the left of the console
        thickLine (c, 902, 10, 902, 600, 2, true);  //Line on the right of the console

        c.setColor (Color.WHITE);
    }


    /*  title Method:
        Local Variable Dictionary
        ________|___________________|________________________________________________________________________________________________
        Type    | Name              | Desription
        ________|___________________|________________________________________________________________________________________________
        Instance| someImage         | This is an instance of the BufferedImage class. It will be used to take in the wlmacCrest.png
                |                   | picture from the computer and create an image in the top right corner using it.
        ________|___________________|________________________________________________________________________________________________
        Instance| e                 | This is an instance of the IOException class and it will be used to catch any errors in the try catch.
        ________|___________________|________________________________________________________________________________________________

        This method is used to clear the console and to display the title of the program "WLMAC Cinema - ". We use drawRect and setColour to make
        a darkblue (accentColor) box at the top of the console. Inside this box, we display the text. There is a dash because in other methods
        we display the name of those methods after the dash to add some detail to the program. We use thickLine in this method to make an outline
        around the blue box and near the bottom of the console. We also display the WLMAC Logo in the top right of the console to add some nice
        looking graphics. We use BufferedImage to do this. The image is called wlmacCrest.png. We run borderMaker() at the end of this method
        to complete the border around the console. We also make a light blue box which is the screen itself. We also make the textBackgroundColor
        light blue in this method so that it will apply to the text being inputted in askData().
    */
    private void title ()
    {
        c.clear ();
        c.setColor (backgroundColor);   //Makes the color the background color (light blue)
        c.fillRect (10, 10, 894, 590);  //This makes a large box which is actually the screen itself

        c.setColor (accentColor);   //Makes the color dark blue
        c.fillRect (10, 10, 894, 60);   //Makes the top box

        //Horizontal lines to make border
        c.setColor (Color.BLACK);
        thickLine (c, 10, 70, 904, 70, 2, false);
        thickLine (c, 10, 10, 904, 10, 2, false);
        thickLine (c, 10, 598, 904, 598, 2, false);

        c.setColor (Color.white);

        c.setFont (new Font ("Arial", 2, 30));
        c.drawString ("WLMAC Cinema -", 15, 50);

        c.setTextBackgroundColor (backgroundColor); //Sets the textbackground colour for the future input that will happen

        try
        {
            BufferedImage someImage = ImageIO.read (new File ("wlmacCrest.png"));
            c.drawImage (someImage, 830, 10, null);     //Shows the wlmac logo in the top right corner of the console
        }
        catch (IOException e)
        {
        }

        borderMaker ();
    }


    /*  splashScreen Method:
    Local Variable Dictionary
    -----------------------------------------------------------------------------------------------------------------------------
    Type    | Name              | Desription
    -----------------------------------------------------------------------------------------------------------------------------
    int     | rotationAngle     | This variable is declared and initialized in a for loop. It will be used to control the arc
            |                   | so that it looks like it is spinning to give that old school counter effect. In a fillArc() method,
            |                   | rotationAngle will be used as the final parameter which controls the final angle of the arc. It increments
            |                   | by 36 so that it takes 10 iterations of the loop to make one full circle. The thread.sleep() delays
            |                   | for one tenth of a second so this makes one full loop every second. There is an if structure that
            |                   | checks to see if rotationAngle is 360. If it is, then it sets rotationAngle back to 0 so that the
            |                   | the circle can form again. In the fillArc() we use negative rotationAngle so that the circle spins
            |                   | clockwise instead of counterclockwise
    -----------------------------------------------------------------------------------------------------------------------------
    int     | countdown         | This variable is a counter variable in the for loop and is used to make the countdown timer on the
            |                   | screen. It is declared and initialized in the for loop. It is used in the conditional statement of
            |                   | the loop. countdown makes the countdown timer by displaying countdown divided by 10. Basically we take
            |                   | advantage of the fact that when we divide an int by an int, the answer always gets rounded down.
            |                   | Since countdown starts at 59, 59/10 will produce 5 because of how integer division works. countdown
            |                   | decreases by 1 each iteration. So when countdown reachs 49, the timer will display 4. Again, since
            |                   | thread.sleep(100) delays the program by one tenth of a second, it takes 10 iterations (1 second)
            |                   | to get to get to the next method. The program ends once countdown is at 9. 9 is used because that is
            |                   | when the program would display 0. So we only get to see 0 for a split second and the splashscreen will end.
    -----------------------------------------------------------------------------------------------------------------------------
    String  | countdownNumber   | This string will hold the value for the timer. Since countdown is an integer and we can't display
            |                   | integers directly using drawString(), we added this variable. It hold the value of countdown / 10
            |                   | so that it gets the correct time (Explanation above). We do + "" when declaring the variable so
            |                   | that it can be recognized as a string. We display countdownNumber in the middle of the string
            |                   | so we can see the timer.
    -----------------------------------------------------------------------------------------------------------------------------
    Instance| e                 | This variable is an instance of the Exception class and it will be used to catch any errors that
            |                   | are thrown in the try catch that is used in.
    -----------------------------------------------------------------------------------------------------------------------------

    This method is like a loading screen that runs once before the program starts. It is like an old school movie
    countdown timer. It has a dark gray background and there is an arc that has its final arc value increase so
    that it looks like the circle is forming. Then the circle resets and repeats until the timer hits 0. This
    makes the cycle that gives it that old school countdown look. There are additional lines and circles just for
    detail. In total, this splashscreen should last for exactly 5 seconds.
    */
    public void splashScreen ()
    {
        for (int rotationAngle = 0, countdown = 59 ; countdown >= 9 ; rotationAngle += 36, countdown -= 1)
        {
            String countdownNumber = countdown / 10 + "";   //Declares the countdownNumber variable as explained in the dictionary
            c.setColour (new Color (116, 116, 116));    //This sets the colour to dark gray for the background
            c.fillRect (10, 10, 894, 590);

            c.setColor (new Color (183, 183, 183)); //Sets the colour to light gray which will be the moving arc
            c.fillArc (-450, -300, 1800, 1200, 90, -rotationAngle); //This is the moving arc

            if (rotationAngle >= 360)   //If the arc is complete
            {
                rotationAngle = 0;  //Set rotationAngle back to 0 so that the arc can reset
            }

            c.setColor (Color.WHITE);
            c.fillRect (0, 0, 10, 600);
            c.fillRect (0, 0, 904, 10);

            c.setColor (Color.white);   //Sets the colour to white
            //These circles add detail
            c.drawOval (280, 130, 340, 340);
            c.drawOval (300, 150, 300, 300);

            c.setColour (Color.black);  //Sets colour to black
            //These lines are for detail
            thickLine (c, 10, 300, 904, 300, 3, false);
            thickLine (c, 450, 10, 450, 600, 3, true);

            c.setFont (new Font ("ARIAL", Font.PLAIN, 200));    //Sets the font to arial size 200
            c.drawString (countdownNumber, 395, 370);   //Displays countdownNumber (the timer) in the center of the screen
            try
            {
                Thread.sleep (100); //thread.sleep adds delay so the animation can be shown. This delays the loop for 1/10 of a second
            }
            catch (Exception e)
            {
            }
        }
    }


    /*  intro Method:

    Local Variable Dictionary
    _____________________________________________________________________________________________________________________________
    Type    | Name              | Desription
    ________|___________________|________________________________________________________________________________________________
    String  | charstr           | This String variable will hold the value of the entered string from the user. It will then be
            |                   | converted into a character that will be stored in the "userChoice" variable.
    ________|___________________|________________________________________________________________________________________________
    int     | pointerPosition   | This integer variable will be used to hold the position of the pointer for the console's menu.
    ________|___________________|________________________________________________________________________________________________
    char    | menuMovement      | This char variable will be used to hold the value of the key that the user presses. This will
            |                   | also allow the program to know what the user pressed.
    ________|___________________|________________________________________________________________________________________________

    This method is used to create the menu of the program where the user can choose which part of the program they want to go to next.
    First, we call on title() to clear the screen and setup the console for use. We add the text "Main Menu" next to the title for detail.
    On the screen, we show 5 boxes with text inside them, and these are the 5 options the user has that they can pick from. The optins are
    to buy a ticket, to see the instructions, to see the seating chart, to search by name, and to leave the program. We draw a small circle
    about the size of the height of each option box, and the circle is drawn to the left of the options. The circle is aligned wiht the first
    option which is buy a ticket. The user can use the W and S keys on their keyboard to move the circle down the options. We give this
    instrution to the user by displaying it at the top of the screen. As the user moves the circle pointer, there is a message written below
    all the options which says "Your choice is: ____" and the blank is what ever option the user is hovering over at the moment. This just
    helps the user to see exactly what they are doing. We detect the keypress by using getChar() in a while loop that runs as long as the keypress
    isn't <ENTER>. If the user presses enter, that means they have selected that option. If the user picks buy a ticket, see seating chart, or
    search by name, they will be shown another menu. This menu will look exactly like the first except that the options will be the  days of
    the week from Monday - Friday. The user needs to pick which day they want to check the theatre for or to buy the tickets. It is done in
    the exact same way as the first meny using a circle and W and S key press. If the user chose instructions, they won't see this other menu,
    they go straight to instructions. If the user chooses to leave the program, it goes straight to the goodbye() method. The way we actually
    control which window will run next is using the userChoice variable. We use pointerPosition to see which option the user is hovering over.
    Then when the user presses enter, we add the value of pointerPosition to userChoice and that will give userChoice a value. Then everything
    is controlled in main as we already know.
    */

    public void intro ()
    {
        int pointerPosition = 0;    //This just sets pointerPosition to the default value, which is the top option
        char menuMovement = 'w';    //Sees what the user is entering
        userChoice = 1;     //We set this to 1 so that we can properly give userChoice a value later on to be used in main

        // here is the line of code that calls on the title() method to clear the screen and create the title.
        title ();
        c.drawString ("Main Menu", 270, 50);    //This displays next to the title to add some detail

        //This makes the boxes on which the text will be displayed
        c.setColor (accentColor);
        c.fillRect (200, 180, 500, 40);
        c.fillRect (200, 240, 500, 40);
        c.fillRect (200, 300, 500, 40);
        c.fillRect (200, 360, 500, 40);
        c.fillRect (200, 420, 500, 40);

        c.setColor (Color.black);
        c.drawRect (200, 180, 500, 40);
        c.drawRect (200, 240, 500, 40);
        c.drawRect (200, 300, 500, 40);
        c.drawRect (200, 360, 500, 40);
        c.drawRect (200, 420, 500, 40);

        // here are the words for the boxes on the screen
        c.setColor (Color.white);
        c.setFont (new Font ("Arial", 0, 20));
        c.drawString ("Buy a Ticket", 390, 210);
        c.drawString ("Instructions", 395, 270);
        c.drawString ("Seating Chart", 385, 330);
        c.drawString ("Search by Name", 378, 390);
        c.drawString ("Leave the Program", 363, 450);

        // here is the words that tell the user what the program does and how to navigate through the menu.
        c.setColor (Color.black);
        c.setFont (new Font ("Arial", Font.PLAIN, 17));
        c.drawString ("Welcome to the main menu of the ticket seller. Please see the options below to use the program.", 120, 125);
        c.drawString ("Use the W and S keys to navigate the menu. Press enter on your desired option.", 170, 150);


        //While the key pressed doesn't have the ASCII value of 10 or 13, which is the enter value.
        while (menuMovement != 10 && menuMovement != 13)
        {
            //These boxes cover the path of the circle pointer and the line that says "Your choice is: ________"
            c.setColor (backgroundColor);
            c.fillRect (150, 180, 26, 410);
            c.fillRect (400, 461, 250, 50);

            //Makes the circle pointer
            c.setColor (accentColor);
            c.fillOval (150, 185 + pointerPosition * 60, 25, 25);   //The y position of the pointer is altered by  the pointerPosition variable * 60
            //As the pointer position changes, the pointer location will change by 60 pixels
            c.setColor (Color.black);
            c.drawArc (150, 185 + pointerPosition * 60, 25, 25, 0, 360);    //This makes a full outline

            c.setColor (Color.black);
            c.setFont (new Font ("Arial", 0, 25));

            //Makes the text at the bottom that tells the user what they are currently selecting
            c.drawString ("Your choice is: ", 225, 500);

            //This if structure checks where the pointer is by checking through all the positions of the pointerPositon variable
            //If the pointerPosition value is 0, that means the user is hovering over Buy a ticket, if the value is 1, they are
            //hovering over instructions and so on.
            if (pointerPosition == 0)
            {
                c.drawString ("Buy a ticket", 400, 500);
            }
            else if (pointerPosition == 1)
            {
                c.drawString ("Instructions", 400, 500);
            }
            else if (pointerPosition == 2)
            {
                c.drawString ("Seating Chart", 400, 500);
            }
            else if (pointerPosition == 3)
            {
                c.drawString ("Search by Name", 400, 500);
            }
            else if (pointerPosition == 4)
            {
                c.drawString ("Leave the program", 400, 500);
            }

            //This controls the movement of the cirlce and the value of the pointerPosition variable
            menuMovement = c.getChar ();
            if ((menuMovement == 'w' || menuMovement == 'W') && pointerPosition > 0)
                //If the keypress is w and the pointerPosition is currently more than 0 (it is not at the top-most option)
                {
                    pointerPosition--;  //We decrease the value of pointerPosition and this changes the position of the circle and the text at the bottom
                }
            else if ((menuMovement == 'w' || menuMovement == 'W') && pointerPosition == 0)
                //If the keypress is w and the pointer is at the top option
                {
                    pointerPosition = 4;    //Set pointerPosition to 4 which makes the pointer go to the bottom option. This makes a cool cycling effect
                }
            else if ((menuMovement == 's' || menuMovement == 'S') && pointerPosition < 4)
                //If the keypress is s and the pointerPosition value is less than 0 (not at the bottom option)
                {
                    pointerPosition++;  //We increase the pointerPosition value which will make the pointer go up and it changes the text at the bottom
                }
            else if ((menuMovement == 's' || menuMovement == 'S') && pointerPosition == 4)
                //If the keypress is s and the pointer is at the bottom option
                {
                    pointerPosition = 0;    //Set pointerPosition to 0 which puts the pointer to the top to make a cycling effect.
                }
            else if (menuMovement != 'w' && menuMovement != 'W' && menuMovement != 's' && menuMovement != 'S' && menuMovement != 10 && menuMovement != 13)
                //If the keypress isn't w or s
                {
                    new Message ("Please press either \"W\" to move up, \"S\" to move down, or \"ENTER\" to choose that option!");  //Error telling the user what to do
                }
        }
        userChoice += pointerPosition;  //Sets the userChoice variable by adding the pointerPosition value when the user hit enter

        //If the user picked instructions or if they chose to leave the program
        if (pointerPosition == 1 || pointerPosition == 4)
        {
            return; //Skips the rest of this method which is the dates menu
        }

        //Resetting the variables for the dates menu
        pointerPosition = 0;
        menuMovement = 'w';

        title ();
        c.drawString ("Which Day?", 270, 50);   //Adds some detail

        //Makes the boxes on which the text will go
        c.setColor (accentColor);
        c.fillRect (200, 180, 500, 40);
        c.fillRect (200, 240, 500, 40);
        c.fillRect (200, 300, 500, 40);
        c.fillRect (200, 360, 500, 40);
        c.fillRect (200, 420, 500, 40);

        c.setColor (Color.black);
        c.drawRect (200, 180, 500, 40);
        c.drawRect (200, 240, 500, 40);
        c.drawRect (200, 300, 500, 40);
        c.drawRect (200, 360, 500, 40);
        c.drawRect (200, 420, 500, 40);

        // here are the words for the boxes on the screen
        c.setColor (Color.white);
        c.setFont (new Font ("Arial", 0, 20));

        c.drawString ("Monday", 415, 210);
        c.drawString ("Tuesday", 413, 270);
        c.drawString ("Wednesday", 398, 330);
        c.drawString ("Thursday", 409, 390);
        c.drawString ("Friday", 423, 450);

        //Instructions for the user so they know what to do
        c.setColor (Color.black);
        c.setFont (new Font ("Arial", Font.PLAIN, 17));
        c.drawString ("Welcome to the main menu of the ticket seller. Please enter the day next week for which you want to check our cinema.", 30, 125);
        c.drawString ("Use the W and S keys to navigate the menu. Press enter on your desired option.", 170, 150);

        //While the keypress doesn't have ASCII value 10 or 13 which is the ENTER key
        while (menuMovement != 10 && menuMovement != 13)
        {
            //These boxes cover the pointer and the line that says "Your choice is: _______"
            c.setColor (backgroundColor);
            c.fillRect (150, 180, 26, 410);
            c.fillRect (400, 461, 250, 50);

            //This makes the cursor
            c.setColor (accentColor);
            c.fillOval (150, 185 + pointerPosition * 60, 25, 25);   //Uses pointerPosition * 60 to alter the position of the pointer depending on user input
            c.setColor (Color.black);
            c.drawArc (150, 185 + pointerPosition * 60, 25, 25, 0, 360);    //Outline for the pointer for asthetics

            c.setColor (Color.black);
            c.setFont (new Font ("Arial", 0, 25));

            /*
            This if structure checks where the pointer is by checking through all the positions of the pointerPositon variable
            If the pointerPosition value is 0, that means the user is hovering over Monday, if the value is 1, they are
            hovering over Tuesday and so on. It also sets the variables fileName and day to the correct values. If the user
            wants to buy tickets for monday, the file name needs to be monday.txt and this pattern repeats for all the other days.
            */
            c.drawString ("Your choice is: ", 225, 500);
            if (pointerPosition == 0)
            {
                c.drawString ("Monday", 400, 500);
                fileName = "monday.txt";
                day = "Monday"; //This variable helps us make a more detailed messagae in the display() method
            }
            else if (pointerPosition == 1)
            {
                c.drawString ("Tuesday", 400, 500);
                fileName = "tuesday.txt";
                day = "Tuesday";
            }
            else if (pointerPosition == 2)
            {
                c.drawString ("Wednesday", 400, 500);
                fileName = "wednesday.txt";
                day = "Wednesday";
            }
            else if (pointerPosition == 3)
            {
                c.drawString ("Thursday", 400, 500);
                fileName = "thursday.txt";
                day = "Thursday";
            }
            else if (pointerPosition == 4)
            {
                c.drawString ("Friday", 400, 500);
                fileName = "friday.txt";
                day = "Friday";
            }

            //This controls the movement of the cirlce and the value of the pointerPosition variable
            menuMovement = c.getChar ();
            if ((menuMovement == 'w' || menuMovement == 'W') && pointerPosition > 0)
                //If the keypress is w and the pointerPosition is currently more than 0 (it is not at the top-most option)
                {
                    pointerPosition--;  //We decrease the value of pointerPosition and this changes the position of the circle and the text at the bottom
                }
            else if ((menuMovement == 'w' || menuMovement == 'W') && pointerPosition == 0)
                //If the keypress is w and the pointer is at the top option
                {
                    pointerPosition = 4;    //Set pointerPosition to 4 which makes the pointer go to the bottom option. This makes a cool cycling effect
                }
            else if ((menuMovement == 's' || menuMovement == 'S') && pointerPosition < 4)
                //If the keypress is s and the pointerPosition value is less than 0 (not at the bottom option)
                {
                    pointerPosition++;  //We increase the pointerPosition value which will make the pointer go up and it changes the text at the bottom
                }
            else if ((menuMovement == 's' || menuMovement == 'S') && pointerPosition == 4)
                //If the keypress is s and the pointer is at the bottom option
                {
                    pointerPosition = 0;    //Set pointerPosition to 0 which puts the pointer to the top to make a cycling effect.
                }
            else if (menuMovement != 'w' && menuMovement != 'W' && menuMovement != 's' && menuMovement != 'S' && menuMovement != 10 && menuMovement != 13)
                //If the keypress isn't w or s
                {
                    new Message ("Please press either \"W\" to move up, \"S\" to move down, or \"ENTER\" to choose that option!");  //Error telling the user what to do
                }
        }
    }


    /*  instructions Method:

        Local Variable Dictionary
        _____________________________________________________________________________________________________________________________
        Type    | Name              | Desription
        ________|___________________|________________________________________________________________________________________________
        int     | pointerPosition   | This integer variable will be used to hold the value of the position of the current page when
                |                   | the user presses either "A" or "D". This variable lets us know what to display at what time based
                |                   | on what the user enters and how many times they have entered the characters
        ________|___________________|________________________________________________________________________________________________
        char    | menuMovement      | This character variable will be used to hold the value of the key that the user presses. This
                |                   | will be used to know which "direction" of the instructions pages the user wants to go to.
        ________|___________________|________________________________________________________________________________________________
        int     | i                 | This is a counter variable that is used in a for loop. It will go from 0 to 4 in the loop.
                |                   | It will be compared with the pointerPosition variable and once they have the same value, we will
                |                   | make the dot for that page number blue.
        ________|___________________|________________________________________________________________________________________________

        This method will give the user information on how to use this program. It will teach the user about what they will need to input,
        and when they will need to do it. This is a very detailed description so that the user doesn't need to worry about anything later on.
        Since there are a lot of instructions, they are split into several different pages. The user uses the A and D keys to switch between
        the "pages" of the instructions. There is a small diagram at the bottom of the screen that shows which page the user is on. It is a
        5 dot pattern with each dot representing a page. Depending on which page the user is currently on, that dot will be coloured blue
        while all the other bots will be coloured gray. The way we move through the pages is similar to the way we move the pointer in
        the intro() method. We have a loop that runs until the user input isn't the ENTER key. In that loop, we draw a box that covers the
        previous instructions page everytime the user pressed A or D to move to a different page. Each page has some different information.
    */
    public void instructions ()
    {
        int pointerPosition = 0;
        char menuMovement = 'a';
        title ();   //Clears the screen and sets it up for use

        c.drawString ("Instructions", 270, 50); //Displays next to the title for detail

        c.setColor (Color.black);   //Sets the colour to black

        c.setFont (new Font ("Arial", 0, 17));  //Makes the fonr Arial size 18

        c.drawString ("Welcome to the WLMAC Cinema!", 320, 105);

        //Tells the user how to use the program (how to switch through the pages)
        c.drawString ("Press A or D to navigate the instructions.", 550, 570);
        c.drawString ("Press ENTER to leave the instructions.", 550, 592);

        //While the keypress doesn't have the ASCII value 10 or 13 which is the ENTER key
        while (menuMovement != 10 && menuMovement != 13)
        {
            c.setColor (backgroundColor);
            c.fillRect (12, 106, 889, 450); //This box will cover all of the content on the previous screen so that we can show all the stuff on the next screen properly

            if (pointerPosition == 0)
                //If the user is on page 1
                {
                    //Rectangle on which the text will go
                    c.setColor (accentColor);   //Sets the colour to dark blue
                    c.fillRect (100, 200, 710, 120);  //Makes a rectangle on which the text will go

                    c.setColor (Color.black);   //Sets the colour to black
                    c.drawRect (100, 200, 710, 120);    //This makes an outline for the rectangle

                    //Instructions for page 1
                    c.setColor (Color.white);
                    c.drawString ("In this program, you will be able to buy a movie ticket for our theatre. When in the menu page,", 116, 230);
                    c.drawString ("go to one of the options using your W and S keys. Press enter to select an option. We", 126, 260);
                    c.drawString ("recommend you check the seating chart first.", 272, 290);

                }
            else if (pointerPosition == 1)
                //If the user is on page 2
                {
                    //Makes the box on which the text will display
                    c.setColor (accentColor);
                    c.fillRect (100, 150, 710, 220);

                    c.setColor (Color.black);
                    c.drawRect (100, 150, 710, 220);

                    //Page 2 instructions
                    c.setColor (Color.white);
                    c.drawString ("Once you select the seating chart, you will need to choose the day for which you want to", 126, 185);
                    c.drawString ("check the theatre as we have showings for 5 days of the week (Monday to Friday). In the", 126, 215);
                    c.drawString ("seating chart, you can use the WASD keys to navigate the chart. As you select different cells", 118, 245);
                    c.drawString ("in the chart, at the bottom of the screen you will be able to see the seat number, who owns that", 116, 275);
                    c.drawString ("seat, and the  price for that seat. Once you are done with the seating chart, press enter to", 119, 305);
                    c.drawString ("return to the menu.", 375, 335);
                }
            else if (pointerPosition == 2)
                //If the user is on page 3
                {
                    //Makes the box on which the text will display
                    c.setColor (accentColor);
                    c.fillRect (100, 130, 710, 400);

                    c.setColor (Color.black);
                    c.drawRect (100, 130, 710, 400);

                    //Page 3 instructions
                    c.setColor (Color.white);
                    c.drawString ("Now you can buy the tickets Go to the \"Buy a ticket\" option and press enter. Again, you need", 116, 150);
                    c.drawString ("to choose the day for which you want to buy tickets using the same method as before. Now you", 0, 0);
                    c.drawString ("just need to follow the prompts on the screen. You get the choice to go back to see the seating", 116, 180);
                    c.drawString ("chart. Just enter yes or no according to your decision. Then you need to enter your first and", 116, 210);
                    c.drawString ("last name. Now you have to pick how you want to buy your tickets. You can enter individual", 116, 240);
                    c.drawString ("seat numbers or you can choose to buy them by rows or aisles. If you pick individual seats,", 116, 270);
                    c.drawString ("you will be asked how many seats you want to purchase. Then you will need to enter an", 130, 300);
                    c.drawString ("alphanumeric seat number for as many seats as you chose to buy. The number is in format", 116, 330);
                    c.drawString ("row letter, aisle number (A10) where A is the row and 10 is the aisle. So A10 is the 10th seat", 116, 360);
                    c.drawString ("in the first row. There are 20 rows with 30 aisles in each. If you chose to purchase seats by", 123, 390);
                    c.drawString ("row or by aisle, you will need to enter 2 seat numbers and that will buy the seats between the", 116, 420);
                    c.drawString ("two aisle numbers you entered in that row. If you picked aisle, enter two seats with the same", 116, 450);
                    c.drawString ("aisle number and you get the seats between the two row numbers you entered in that aisle.", 128, 480);
                    c.drawString ("After this, you will be shown the cost of your purchase as well as the seats you entered.", 128, 510);
                }
            else if (pointerPosition == 3)
                //If the user is on page 4
                {
                    //Draws the rectangle on which the text will be displayed
                    c.setColor (accentColor);
                    c.fillRect (100, 130, 710, 330);

                    c.setColor (Color.black);
                    c.drawRect (100, 130, 710, 330);

                    //Page 4 instructions
                    c.setColor (Color.white);
                    c.drawString ("Next, you will need to confirm your purchase. Enter yes to confirm or no to decline. Saying no", 116, 160);
                    c.drawString ("will cancel your entire order and will bring you to the main menu. If you said yes, you need", 126, 190);
                    c.drawString ("to enter your credit card information First you enter your 16 digit card number with spaces", 126, 220);
                    c.drawString ("between every 4 digits. Then you need to entire you expiry date of the card. If your card is", 126, 250);
                    c.drawString ("expired, your order will be cancelled. The expiry date should be written in format month/year", 120, 280);
                    c.drawString ("(11/23 would be the 11th month (November) in the year 2023. Remember, if the year you enter", 116, 310);
                    c.drawString (" is more than 40, it will be considered as the year 1940 as no cards are made that will expire", 119, 340);
                    c.drawString ("after 2040. Then you need to enter your CVV code which is the 3 digit code on the back of", 123, 370);
                    c.drawString ("your card If everything is approved, your purchase will be complete. You will see a purchase", 116, 400);
                    c.drawString ("summary and then if you press enter, you will be sent back to the main menu at the end.", 130, 430);
                }
            else if (pointerPosition == 4)
                //If the user is on page 5
                {
                    //Makes the rectangle on which the text will display
                    c.setColor (accentColor);
                    c.fillRect (100, 150, 710, 220);

                    c.setColor (Color.black);
                    c.drawRect (100, 150, 710, 220);

                    //Page 5 instructions
                    c.setColor (Color.white);
                    c.drawString ("We also have a search by name method. Again, you enter the day you want to check the", 126, 180);
                    c.drawString (" theatre for. Next you need to enter a name. Then the computer will tell you which seats (if", 120, 210);
                    c.drawString ("any) that family owns. It will show you a seating chart with all the seats that family owns", 133, 240);
                    c.drawString ("selected. It also shows the total cost that family paid for tickets on that day. When you are", 124, 270);
                    c.drawString ("done, press enter and then you will be back into the menu. To completely exit the program,", 122, 300);
                    c.drawString ("hover over the leave program option in main menu, and select enter. ", 200, 330);
                }

            //This loop is used to make the dots diagram
            for (int i = 0 ; i < 5 ; i++)  //This loop will go from 0 to 4 because there are 5 pages of instructions
            {
                if (pointerPosition != i)   //When the pointerPosition is not the same as i (The user is not on page i)
                {
                    c.setColor (Color.GRAY);
                    c.fillOval (75 + i * 30, 575, 20, 20);  //Draw a gray circle. We do i * 30 so that every iteration draws the dot 30 pixels away
                }
                else    //If pointerPosition is equal to i (The user is on page i
                {
                    c.setColor (accentColor);
                    c.fillOval (75 + i * 30, 575, 20, 20);  //Make a blue dot
                }
            }

            menuMovement = c.getChar (); //Takes keypress

            //This controls which page the program moves to and the value of the pointerPosition variable
            if ((menuMovement == 'a' || menuMovement == 'A') && pointerPosition > 0)
                //If the keypress is A and the user is not on the first page
                {
                    pointerPosition--;  //Decerease pointerPosition by one which will make the program go one page to the left (Go back a page)
                }
            else if ((menuMovement == 'a' || menuMovement == 'A') && pointerPosition == 0)
                //If the keypress is A and user is on the first page
                {
                    pointerPosition = 4;    //Set pointer position to 4 which will display the last page of instruction, this makes a cycling effect.
                }
            else if ((menuMovement == 'd' || menuMovement == 'D') && pointerPosition < 4)
                //If the keypress is D and the user is not on the last page
                {
                    pointerPosition++;  //Increase pointerPosition by 1 which will make the program go one page to the right (The next page)
                }
            else if ((menuMovement == 'd' || menuMovement == 'D') && pointerPosition == 4)
                //If the keypress is D and the user is on the last page
                {
                    pointerPosition = 0;    //Set the pointerPosition to 0 which will display page 1 of the instructions, this makes  cycling effect
                }
            else if (menuMovement != 'a' && menuMovement != 'A' && menuMovement != 'd' && menuMovement != 'D' && menuMovement != 10 && menuMovement != 13)
                //If the user enters something other than A or D
                {
                    new Message ("Please press either \"A\" to go to the previous page, \"D\" to go to the next page, or \"ENTER\" to exit the instructions.!");    //Error message
                }
        }
    }


    /*  askData() Method:

        Local Variable Dicitionary:
        _____________________________________________________________________________________________________________________________
        Type    | Name              | Desription
        ________|___________________|________________________________________________________________________________________________
        boolean | done              | This variable acts as a boolean switch. Whenever we take input for something, we do it in a loop
                |                   | with the condition !done. So then in that loop, once we get input, we check if it is good input
                |                   | through error trapping, and if it is, we set done to true. This breaks out of the input loop. If
                |                   | it is still false, then the loop will go again, making the user try to do input again. Right before
                |                   | we take input, we set done back to false so that the next input loop will run.
        ________|___________________|________________________________________________________________________________________________
        String  | temp              | This String variable will be used to hold temporary string values. This can be for reasons such
                |                   | as when reading a file or when we need to format a price. We use this variable to set the final
                |                   | variable with the proper value.
        ________|___________________|________________________________________________________________________________________________
        String  | userData          | This array stores all of the information that we need to store in the file. It holds absolutely
        [][][]  |                   | everything that we might need. It is a 3D String array with 6 layers. It holds seat number,
                |                   | user last name, price of that seat, credit card number, expiry date, and cvv code. It gets set
                |                   | at the beginning of the method by reading from a file. Depending on the date the user chose in intro()
                |                   | the file will be set in askData(). The program will read from that file and store everything from
                |                   | that file into this array.
        ________|___________________|________________________________________________________________________________________________
        boolean | seatIsTaken       | This array represents the theatre seating chart. It is 20X30 which is the same dimensions as the
        [][]    |                   | theatre. Every cell in this array is meant to be a seat. When the program is reading from the file
                |                   | at the beginning of the method, it looks for which seats are already bought, and then in this array
                |                   | it finds the cells representing those seats and sets them to true. If it is true, it means it's taken
                |                   | We later use this array to do error trapping so the user doesn't buy a ticket that someone else
                |                   | owns.
        ________|___________________|________________________________________________________________________________________________
        Instance| output            | This variable is an instance of the PrintWriter class and it will allow the program to write
                |                   | data to the specified file. It will be used to write all of the data that needs to be stored.
                |                   | This includes the seat number, user's last name, the price of that seat, the credit card number,
                |                   | the credit card expiry date, and the CVV code.
        ________|___________________|________________________________________________________________________________________________
        Instance| input1            | This variable is an instance of the BufferedReader class and it will be used to allow the
                |                   | program to read data from the specified file. It will be used to set the userData[][][] array
                |                   | and the seatIsTaken [][] array at the beginning of the program.
        ________|___________________|________________________________________________________________________________________________
        int     | seatsRemaining    | The value of this variable always starts at 600 which is the total number of seats in the theatre.
                |                   | In the loop where we read from the file, we see how many seats are already gone by reading every line, and then we
                |                   | subtract from seatRemaining once every iteration of the loop which will make it so that it ends with
                |                   | the correct value being the remaining number of seats.
        ________|___________________|________________________________________________________________________________________________
        String  | choice            | This String variable will be used to see what the user want's to do when they need to make decisions.
                |                   | When they are asked if they want to see the SeatingChart, we use this varibale to take input
                |                   | and we use it to see what they chose. We also use it when the user needs to pick between seat, row
                |                   | and aisle. It is also used when the user needs to confirm their order (Yes or No)
        ________|___________________|________________________________________________________________________________________________
        String  | conversion        | This String variable will be used as a way to convert . This is very useful in error trapping.
        ________|___________________|________________________________________________________________________________________________
        boolean | specialCharacters | When we take input, this is used in error trapping for the input of the name, and for the credit card number
                |                   | If there are any special characters, we determine this by checking ever character of the string
                |                   | and seeing if it is between the values of the ASCII table where it is a special character.
        ________|___________________|________________________________________________________________________________________________
        boolean | spaces            | Also used in error trapping to see if there are spaces when there shouldn't be. It is also used
                |                   | to make sure that there are at least a certain amoutn of spaces like in the name there needs to be one
        ________|___________________|________________________________________________________________________________________________ 
        String[]| names             | This variable is a String array that will be used to hold the value of the names entered by the 
                |                   | user. They will then be formatted and stored in the array actualCurrentNames.
        ________|___________________|________________________________________________________________________________________________
        int     | amountOfTickets   |This is entered by the user if they pick seat when buying tickets. They need to write how many 
                |                   | tickets they want to purchase. We use this in a loop so that the user is asked to enter seat numbers
                |                   | for thta many tickets.
        ________|___________________|________________________________________________________________________________________________
        boolean | seatsChosen       | This is a 2D boolean array that will be used to hold the value of the current seats that the 
        [][]    |                   | user entered. This is so that the program stops the user from buying the same seat over and over. 
                |                   | This also stops the program itself from writing data to the userData array, because there would 
                |                   | be errors if the user decides to not confirm their purchases, because the program would think 
                |                   | they did actaully buy those seats. Overall, this variable is needed.
        ________|___________________|________________________________________________________________________________________________ 
        String  | shownLocations    | This String variable will be used to hold the values of the locations that the user has purchased 
                |                   | tickets for. THis is used to display them all in a list.
        ________|___________________|________________________________________________________________________________________________
        int     | maxTicketsShown   | THis holds the value 15 and is compred to shownLocations.length. If the user bought more than 15
                |                   | tickets, then the display messages will be a little different.
        ________|___________________|________________________________________________________________________________________________        
        String  | creditCardNumber  | This String variable will be used to hold the entered credit card number, with spaces.
        ________|___________________|________________________________________________________________________________________________
        int     | amountOfSpaces    | This variable checks how many spaces there are in the string. there need to be a specific amoutn
                |                   | of spaces in some input like the cerdit card number which needs 3 spaces. This helps with
                |                   | errortrapping that.
        ________|___________________|________________________________________________________________________________________________
        boolean | stolenCard        | If the porgram detects that the credit card number the user has entered has already been used
                |                   | under another name, this variable will be true and the whole order will be cancelled. 
        ________|___________________|________________________________________________________________________________________________        
        String  | expiryDate        | This String variable will be used to hold the expiry date of the entered credit card, including the slash.
        ________|___________________|________________________________________________________________________________________________
        int     | amountAddToYear   | This variable is used to error trap the expiry date of the crdit card. If the user enters a year
                |                   | value grater than 40, the program needs to detect that year as 1940. This variable helps with that.
                |                   | In an if structure, it sees what the user has entered as the year value, and if the year value
                |                   | was more than 40, amountAddToYear will be set to 1900 and it will get added. If the year is less
                |                   | tahn 40, amountAddToYear will be set to 2000
        ________|___________________|________________________________________________________________________________________________
        int     | amountOfSlashes   | Checks how many slashes there are when errortrapping the expiry date
        ________|___________________|________________________________________________________________________________________________
        boolean | differentExpiry   | If the program found a record of the credit card number being used but with a different expiry date
                |                   | than the one the user has entered, this variabel will be set to true and the order will be cancelled
                |                   | due to incorrect credit card information.
        ________|___________________|________________________________________________________________________________________________
        String  | cvv               | This String variable will be used to hold the CVV number that the user enters.
        ________|___________________|________________________________________________________________________________________________
        int     | cvvTries          | There are a limited numebr of tries the usergets when trying to enter a cvv number. they get 3 tries
                |                   | If the user makes a mistake when entering the cvv code, this variable will increase by 1
                |                   | Once it reaches maxCVVTries, the program will delete the order
        ________|___________________|________________________________________________________________________________________________
        int     | maxCVVTries       | Used to error trap the CVV as explained previously
        ________|___________________|________________________________________________________________________________________________
        double  | totalPrice        | We use the blackbox return method price for each seat the user bought which is stored in enteredLocation [][
                |                   | In a loop, we go through each seat number and call the price() method. We add the price to totalPrice
                |                   | variabel so in the end, this variable holds the total cost of all the tickets the user bought.
        ________|___________________|________________________________________________________________________________________________        
        int     | currentMonth      | This variable will be used to hold the integer value of the current month. This value ranges 
                |                   | from 0 to 11, so a value of 1 is added to the value from Date.getMonth(). This value is stored 
                |                   | in the currentMonth variable.
        ________|___________________|________________________________________________________________________________________________
        int     | currentYear       | This variable will be used to hold the integer value of the current year. This value is the 
                |                   | current year MINUS 1900, and so 1900 is added to the value from Date.getYear(), and this 
                |                   | value is stored in the currentYear variable.
        ________|___________________|________________________________________________________________________________________________
        int     | i                 | This variable will be used to hold the value of the current iteration of the for loop that 
                |                   | it is used in.
        ________|___________________|________________________________________________________________________________________________
        int     | j                 | This variable will be used to hold the value of the current iteration of the for loop that 
                |                   | it is used in. This variable is mainly used in nested for loops.
        ________|___________________|________________________________________________________________________________________________
        int     | k                 | This variable will be used to hold the value of the current iteration of the for loop that 
                |                   | it is used in. This variable is also mainly used in nested for loops.
        ________|___________________|________________________________________________________________________________________________
        Instance| e                 | This is an instance of the Exception class and it will be used to catch any errors in the try 
                |                   | catch. This variable is also used in the IOException and NumberFormatException classes.
        ________|___________________|________________________________________________________________________________________________
        Instance| currentFile       | This variable is an instance of the File class and it will be used to see which of the 5 
                |                   | files ("monday.txt". "tuesday.txt", "wednesday.txt", "thursday.txt", "friday.txt") exist, 
                |                   | and from there, the program reads through the files that exist.
        ________|___________________|________________________________________________________________________________________________
        Instance| tempReader        | This variable is an instance of the BufferedReader class and it will be used to read the files 
                |                   | that exist. (The files are "monday.txt". "tuesday.txt", "wednesday.txt", "thursday.txt", and "friday.txt").
        ________|___________________|________________________________________________________________________________________________
        Instance| now               | This variable is an instance of the Date class and it will be used to get the current month and 
                |                   | current year using Date.getMonth() and Date.getYear() respectively.
        ________|___________________|________________________________________________________________________________________________

        This method is used to get the data from the user on what tickets they would like to buy in the theatre. Frist the user is asked
        if they want to see the seatingChart again. Since the user chose a date in intro() we use the file name set from there in this method
        After the user goes through the seatingChart, we ask them to enter their name. Then we ask them if they want to buy the seats by
        individual seats, by row, or by aisle. Depending on what they choose, we go through an if structure with different input required.
        If they picked individual seats, the user needs to enter how many seats they want to buy, and they will need to enter that many seat numbers.
        If the picked row or aisle, they will need enter 2 seat numbers with either the same row letter if they picked to buy by row, or with the
        same aisle number if the purchased by aisle. All of the seats the user bought are stored in an array. Then we display the array so the
        user sees a list of all the tickts thry bought. If they bought more than 15 tickets, there is a message saying that the program can't
        fit more than 15 tickets on the screen, so only the first 15 show up. But the other tickets they bought, are still theirs. Then the user
        is asked to confirm their purchase. They enter yes or no. If they pick no, the whole order is cancelled and they are sent back to menu
        If they pick yes, they enter their credit card information. They first need to enter the credit card number, then the expiry date and the CVV
        code. If everything works well, the purcahse wil lbe successful and their data will be inputted to the file and they move on to the display
        method. All of the input is error trapped so that there is no way for the user to make a mistake or crash the program. They can't buy
        alrady bought seats, their credit card has to not be stolen, their name needs to not have special chracters, and a lot more. We also show
        a pricing chart for all of the tickets.
        */


    public void askData ()
    {
        //Variable Declaration
        boolean done = false;
        moveOn = true;

        String temp = "";

        String[] [] [] userData = new String [ROWS] [COLUMNS] [6];
        boolean[] [] seatIsTaken = new boolean [ROWS] [COLUMNS];

        PrintWriter output;
        BufferedReader input1;

        int seatsRemaining = ROWS * COLUMNS;

        String choice = "";

        String conversion = "";

        boolean specialCharacters = false;
        boolean spaces = false;

        String[] names;

        amountOfTickets = 0;
        boolean[] [] seatsChosen = new boolean [ROWS] [COLUMNS];

        String shownLocations = "";
        int maxTicketsShown = 15;

        String creditCardNumber = "";
        int amountOfSpaces = 0;
        boolean stolenCard = false;

        String expiryDate = "";
        int amountToAddToYear = 0;
        int amountOfSlashes = 0;
        boolean differentExpiry = true;

        String cvv = "";
        int cvvTries = 0;
        int maxCVVTries = 3;

        double totalPrice = 0;

        // here is the title for the program. It is created by calling on the title() method
        title ();

        // here are lines of code that count how many seats for ticket purchasing are remaining.
        try
        {
            input1 = new BufferedReader (new FileReader (fileName));

            // this while loop checks to see how many lines there are in the file, and it stops at the end, when the line is blank. It also sets the values for the global array takenSeats to true if a certain cell in the file is written
            while ((temp = input1.readLine ()) != null)
            {
                seatIsTaken [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1] = true;
                userData [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1] [0] = temp.split (",") [0];
                userData [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1] [1] = temp.split (",") [1];
                userData [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1] [2] = temp.split (",") [2];
                userData [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1] [3] = temp.split (",") [3];
                userData [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1] [4] = temp.split (",") [4];
                userData [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1] [5] = temp.split (",") [5];
                seatsRemaining--;
            }
        }


        catch (Exception e)
        {
        }


        // this if statement checks to see if the entire theatre is sold out. If it is, then the code inside of this if statement runs.
        if (seatsRemaining == 0)
        {
            // here is a line of code that adds to the title, which makes it more specific to the output screen.
            c.setColor (accentColor);
            c.fillRect (275, 20, 400, 40);
            c.drawString ("Full House!", 260, 40);

            // here are the lines of code that create a box that the display information will be put inside. It will be the color of the accentColor variable, and the box will have 20 pixels of space around it.
            c.setColor (accentColor);
            c.fillRect (20, 70, 760, 410);

            // here are the lines of code that actually display the output to the user.
            c.setColor (Color.black);

            // here are the lines of code that tell the user that the
            c.drawString ("We are very sorry to say this, but the entire theatre is full!", 30, 240);
            c.drawString ("Please go to wlmac.ca to see our upcoming events that you can be a part of!", 30, 270);


            pause ();
            moveOn = false;
            return;
        }


        // here adds a piece to the title that makes it more specific
        c.setColor (Color.white);
        c.drawString ("Ticket Purchase", 275, 50);

        // here asks the user if they want to see the seating plan before they buy their ticket
        c.setFont (new Font ("Arial", 0, 17));
        c.setColor (Color.black);
        c.drawString ("Would you like to see the seating plan before you purchase tickets? (\"Yes\" or \"No\")", 20, 95);

        // here are lines of code that help with error trapping for when the user wants to see the seating plan or not
        while (!done)
        {
            try
            {
                c.setCursor (5, 80);
                c.print (' ', 100);
                c.println ();
                c.setCursor (5, 80);
                done = false;

                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                choice = c.readLine ();

                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                if (!choice.equalsIgnoreCase ("yes") && !choice.equalsIgnoreCase ("no"))
                {
                    new Message ("You were told to enter either \"yes\" or \"no\" into the program! So, do that!");
                }
                else
                {
                    done = true;
                }
            }
            catch (Exception e)  // catches any error thrown by the try command
            {
                new Message ("Please enter \"yes\" or \"no\" into the program!");
            }
        }


        // here are lines of code that reset the values on the screen if the seating plan is called on.
        if (choice.equalsIgnoreCase ("yes"))
        {
            seatingPlan ();
            title ();
            c.setColor (Color.white);
            c.drawString ("Ticket Purchase", 270, 50);
            c.setColor (Color.black);
            c.setFont (new Font ("Arial", 0, 17));
            c.drawString ("Would you like to see the seating plan before you purchase tickets? (\"Yes\" or \"No\")", 20, 95);
            c.setCursor (5, 80);

            // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
            borderMaker ();
            cost ();

            c.println (choice);

            // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
            borderMaker ();
        }


        c.setColor (Color.black);
        // here is a line of code that tells the user how many seats are remaining for ticket purchasing
        c.drawString ("Note: there are " + seatsRemaining + " seats remaining for ticket purchasing. Hurry up!", 20, 115);

        // here is a line of code that asks the user to enter their first and last name.
        c.drawString ("Can you please enter your first and last name?", 20, 137);

        // here are lines of code that help with the error trapping after the user enters their first and last name
        done = false;
        while (!done)
        {
            try
            {
                c.setCursor (7, 47);
                c.print (' ', 33);
                c.println ();
                c.setCursor (7, 47);
                specialCharacters = false;
                spaces = false;
                done = false;

                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                conversion = c.readLine ();

                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                for (int i = 0 ; i < conversion.length () ; i++)
                {
                    if (conversion.charAt (i) == 32)
                    {
                        spaces = true;
                        break;
                    }
                }


                if (spaces && conversion.charAt (0) != 32 && conversion.charAt (conversion.length () - 1) != 32)
                {
                    names = conversion.split (" ");
                    if (names.length == 2)
                    {
                        for (int i = 0 ; i < names.length ; i++)
                        {
                            for (int j = 0 ; j < names [i].length () ; j++)
                            {
                                if (!specialCharacters && ((names [i].charAt (j) <= 64) || (names [i].charAt (j) >= 91 && names [i].charAt (j) <= 96) || (names [i].charAt (j) >= 123)))
                                {
                                    specialCharacters = true;
                                }
                            }
                            if (!specialCharacters && names [i].length () > 1)
                            {
                                // here are lines of code that take in the name and converts the first letter to uppercase and the other letters to lowercase
                                names [i] = names [i].substring (0, 1).toUpperCase () + names [i].substring (1).toLowerCase ();
                                actualCurrentNames [i] = names [i];
                                done = true;
                            }
                            else if (!specialCharacters && names [i].length () <= 1)
                            {
                                new Message ("Please enter your first and last name and ensure that they are more than one letter in length because who has a name that is one letter?!?!");
                                done = false;
                                break;
                            }
                            else
                            {
                                new Message ("Please enter your first and last name and ensure that there are no special characters inside of it!");
                                done = false;
                                break;
                            }
                        }
                    }
                    else
                    {
                        new Message ("Please enter only your first and last name into the program! This means there must be 1 space!");
                    }
                }
                else if (!spaces) // spaces && conversion.charAt (0) != 32 && conversion.charAt (conversion.length () - 1) != 32
                {
                    new Message ("Please enter only your first and last name into the program! This means there must be 1 space!");
                }

                else if (conversion.charAt (0) == 32)
                {
                    new Message ("Please enter only your first and last name into the program! Make sure there are no spaces at the start!");
                }

                else if (conversion.charAt (conversion.length () - 1) == 32)
                {
                    new Message ("Please enter only your first and last name into the program! Make sure there are no spaces at the end!");
                }
            }
            catch (Exception e)  // catches any error thrown by the try command
            {
                new Message ("Please enter your first and last name into the program!");
            }
        }


        // here is a line of code that asks the user to enter the amount of tickets they want to buy.
        c.setColor (Color.black);
        c.drawString ("You can buy tickets by individual seats, by rows, or by aisles.", 20, 175);
        c.drawString ("Enter \"seat\", \"row\", or \"aisle\" accordingly:", 20, 195);

        // here are lines of code that help with the error trapping after the user enters the amount of seats that they want
        done = false;
        while (!done)
        {
            try
            {
                c.setCursor (10, 42);
                c.print (' ', 50);
                c.println ();
                c.setCursor (10, 42);

                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                choice = c.readLine ();

                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                if (!choice.equalsIgnoreCase ("seat") && !choice.equalsIgnoreCase ("row") && !choice.equalsIgnoreCase ("aisle"))
                {
                    JOptionPane.showMessageDialog (null, "Please enter \"seat\" if you want to buy each individual seat,\n\"row\" if you want to buy a row of seats,\nor \"aisle\" if you want to buy an aisle of seats, into the program!", "Wrong Choice!", JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    done = true;
                }
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog (null, "Please enter \"seat\" if you want to buy each individual seat,\n\"row\" if you want to buy a row of seats,\nor \"aisle\" if you want to buy an aisle of seats, into the program!", "Wrong Choice!", JOptionPane.ERROR_MESSAGE);

            }
        }

        if (choice.equalsIgnoreCase ("seat"))
        {
            // here is a line of code that asks the user to enter the amount of tickets they want to buy.
            c.setColor (Color.black);
            c.drawString ("Can you please enter the amount of tickets that you would like to buy?", 20, 235);


            // here are lines of code that help with the error trapping after the user enters the amount of seats that they want
            amountOfTickets = -1;
            while (amountOfTickets < 0 || amountOfTickets > seatsRemaining)
            {
                try
                {
                    c.setCursor (12, 68);
                    c.print (' ', 16);
                    c.println ();
                    c.setCursor (12, 68);

                    // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                    borderMaker ();
                    cost ();

                    conversion = c.readLine ();

                    // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                    borderMaker ();
                    cost ();

                    amountOfTickets = Integer.parseInt (conversion);
                    if (amountOfTickets < 0 || amountOfTickets > seatsRemaining)
                    {
                        new Message ("Please enter the amount of tickets that is a whole number above or equal to 0 and less than or equal to the amount of tickets remaining!");
                    }
                }
                catch (NumberFormatException e)
                {
                    new Message ("Please enter the amount of tickets you want to buy into the program! It must be a whole number above or equal to 0 and less than or equal to the amount of tickets remaining!");
                }
            }

            if (amountOfTickets == 0)
            {
                moveOn = false;
                return;
            }

            c.setColor (Color.black);
            // here are some lines of code that prompt the user to enter the location of the seat that they want.
            c.setFont (new Font ("Arial", 0, 13));

            c.drawString ("Note: The format for seats should be (Row Letter)(Aisle Number).", 20, 255);
            c.drawString ("An example would be \"A01\" if you want a seat in the first aisle in the first row.", 20, 275);

            c.setFont (new Font ("Arial", 0, 17));
            c.drawString ("Please enter the location of seat #", 20, 295);

            // here are lines of code that actually take in the locations of the wanted seats
            enteredLocation = new String [amountOfTickets];

            for (int i = 0 ; i < amountOfTickets ; i++)
            {
                done = false;
                while (!done)
                {
                    try
                    {
                        c.setCursor (15, 35);
                        c.print (' ', 50);
                        c.println ();
                        c.setCursor (15, 35);
                        c.print ((i + 1) + ":");
                        c.setCursor (15, 38);
                        c.print (' ', 50);
                        c.println ();
                        c.setCursor (15, 38);
                        done = false;

                        // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                        borderMaker ();
                        cost ();

                        enteredLocation [i] = c.readLine ();

                        // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                        borderMaker ();
                        cost ();

                        // this if statement checks to see if the location entered is more than 3 characters big
                        if (enteredLocation [i].length () == 3 && ((enteredLocation [i].charAt (0) >= 65 && enteredLocation [i].charAt (0) <= 84) || (enteredLocation [i].charAt (0) >= 97 && enteredLocation [i].charAt (0) <= 116)))
                        {
                            // this try catch catches any errors in the second and third characters (like if they enter "A-0")
                            try
                            {
                                // this if statement checks to see if the number is between 1 and 30, inclusive, because there are 30 columns the user can choose from.
                                if (Integer.parseInt (enteredLocation [i].substring (1)) >= 1 && Integer.parseInt (enteredLocation [i].substring (1)) <= 30)
                                {
                                    // here are lines of code that take in the location and converts the first letter to uppercase and the other letters to lowercase
                                    enteredLocation [i] = enteredLocation [i].substring (0, 1).toUpperCase () + enteredLocation [i].substring (1);
                                    if (!seatIsTaken [enteredLocation [i].charAt (0) - 65] [Integer.parseInt (enteredLocation [i].substring (1)) - 1] && !seatsChosen [enteredLocation [i].charAt (0) - 65] [Integer.parseInt (enteredLocation [i].substring (1)) - 1])
                                    {

                                        seatsChosen [enteredLocation [i].charAt (0) - 65] [Integer.parseInt (enteredLocation [i].substring (1)) - 1] = true;
                                        done = true;
                                    }
                                    else
                                    {
                                        new Message ("Oh no! This seat is taken already! This means that you have to purchase a ticket for another seat!");
                                    }
                                }
                                else
                                {
                                    new Message ("The second and third characters of the location are supposed to be a number between 1 and 30 that represents the aisle that you want! An example would be \"E17\".");
                                }
                            }
                            catch (NumberFormatException e)
                            {
                                new Message ("The second and third characters of the location are supposed to be a number that represents the aisle that you want! An example would be \"G25\".");
                            }
                        }
                        else if (enteredLocation [i].length () != 3) // enteredLocation [i].length () == 3 && ((enteredLocation [i].charAt (0) >= 65 && enteredLocation [i].charAt (0) <= 90) || (enteredLocation [i].charAt (0) >= 97 && enteredLocation [i].charAt (0) <= 122)) && ((enteredLocation [i].charAt (0) >= 65 && enteredLocation [i].charAt (0) <= 84) || (enteredLocation [i].charAt (0) >= 97 && enteredLocation [i].charAt (0) <= 116))
                        {
                            new Message ("The location is supposed to be a maximum amount of 3 characters! So why does your entered location have more than 3 characters?!? An example would be \"A01\".");
                        }

                        else if (!((enteredLocation [i].charAt (0) >= 65 && enteredLocation [i].charAt (0) <= 90) || (enteredLocation [i].charAt (0) >= 97 && enteredLocation [i].charAt (0) <= 122)))
                        {
                            new Message ("The first character of the location is supposed to start with a letter for the row that you want! So why doesn't yours start with a letter?!? An example would be \"A10\".");
                        }

                        else if (!((enteredLocation [i].charAt (0) >= 65 && enteredLocation [i].charAt (0) <= 84) || (enteredLocation [i].charAt (0) >= 97 && enteredLocation [i].charAt (0) <= 116)))
                        {
                            new Message ("The first character of the location is supposed to start with a letter from \"A\" to \"T\" that represents the row that you want! So why doesn't yours start with one of those letters? An example would be \"J10\".");
                        }

                    }
                    catch (Exception e)
                    {
                        new Message ("Please enter the location of the seat into the program! An example would be \"A01\".");

                    }
                }
            }
        }


        else if (choice.equalsIgnoreCase ("row"))
        {
            // here is a line of code that asks the user to enter the amount of tickets they want to buy.
            c.setColor (Color.black);
            c.setFont (new Font ("Arial", 0, 13));
            c.drawString ("Note: The format for seats should be (Row Letter)(Aisle Number).", 20, 230);
            c.drawString ("An example would be \"A01\" if you want a seat in the first aisle in the first row.", 20, 250);

            c.setFont (new Font ("Arial", 0, 17));
            c.drawString ("Can you please enter the locations of the points of the row you would like to buy?", 20, 275);
            c.drawString ("An example would be \"A01 A10\". Make sure they are separated by a space.", 20, 295);
            done = false;
            while (!done)
            {
                try
                {
                    c.setCursor (15, 73);
                    c.print (' ', 50);
                    c.println ();
                    c.setCursor (15, 73);
                    done = false;

                    borderMaker ();
                    cost ();

                    conversion = c.readLine ();

                    borderMaker ();
                    cost ();

                    if (
                            conversion.length () == 7 &&
                            conversion.charAt (0) != 32 &&
                            conversion.charAt (conversion.length () - 1) != 32 &&
                            ((conversion.charAt (0) >= 65 && conversion.charAt (0) <= 84) || (conversion.charAt (0) >= 97 && conversion.charAt (0) <= 116)) &&
                            ((conversion.charAt (4) >= 65 && conversion.charAt (4) <= 84) || (conversion.charAt (4) >= 97 && conversion.charAt (4) <= 116)) &&
                            conversion.charAt (3) == 32 &&
                            conversion.charAt (0) == conversion.charAt (4) &&

                            ((conversion.charAt (1) == 48 && conversion.charAt (2) > 48 && conversion.charAt (2) < 58) || (conversion.charAt (1) >= 49 && conversion.charAt (1) <= 50 && conversion.charAt (2) > 47 && conversion.charAt (2) < 58) || (conversion.charAt (1) == 51 && conversion.charAt (2) == 48)) &&
                            ((conversion.charAt (5) == 48 && conversion.charAt (6) > 48 && conversion.charAt (6) < 58) || (conversion.charAt (5) >= 49 && conversion.charAt (5) <= 50 && conversion.charAt (6) > 47 && conversion.charAt (6) < 58) || (conversion.charAt (5) == 51 && conversion.charAt (6) == 48)) &&
                            (conversion.charAt (1) != conversion.charAt (5) ||
                                conversion.charAt (2) != conversion.charAt (6))
                            )
                    {
                        if (Integer.parseInt (conversion.substring (1, 3)) > Integer.parseInt (conversion.substring (5)))
                        {
                            conversion = conversion.substring (4) + " " + conversion.substring (0, 3);
                        }
                        conversion = conversion.substring (0, 1).toUpperCase () + conversion.substring (1, 3) + " " + conversion.substring (4, 5).toUpperCase () + conversion.substring (5);
                        for (int i = Integer.parseInt (conversion.substring (1, 3)) ; i <= Integer.parseInt (conversion.substring (5)) ; i++)
                        {
                            amountOfTickets++;
                        }
                        enteredLocation = new String [amountOfTickets];
                        for (int i = 0 ; i < amountOfTickets ; i++)
                        {
                            temp = conversion.substring (1, 3);
                            if (Integer.parseInt (temp) + i < 10)
                            {
                                temp = "0" + (Integer.parseInt (temp) + i);
                            }
                            else
                            {
                                temp = (Integer.parseInt (temp) + i) + "";
                            }
                            if (!seatIsTaken [conversion.charAt (0) - 65] [Integer.parseInt (temp) - 1])
                            {
                                enteredLocation [i] = conversion.substring (0, 1) + temp;
                            }
                            else if (seatIsTaken [conversion.charAt (0) - 65] [Integer.parseInt (temp) - 1])
                            {
                                JOptionPane.showMessageDialog (null, "Please make sure to enter a row that doesn't have a seat taken in it!", "Seat Is Taken!", JOptionPane.ERROR_MESSAGE);
                                done = false;
                                break;
                            }
                            done = true;
                        }
                    }
                    else if (conversion.length () != 7)
                    {
                        new Message ("Please enter the first location and the second location of the row of seats you want to buy!");
                    }
                    else if (conversion.charAt (0) == 32)
                    {
                        new Message ("Please make sure to not have a space at the start of the locations!");
                    }
                    else if (conversion.charAt (conversion.length () - 1) == 32)
                    {
                        new Message ("Please make sure to not have a space at the end of the locations!");
                    }
                    else if (!((conversion.charAt (0) >= 65 && conversion.charAt (0) <= 90) || (conversion.charAt (0) >= 97 && conversion.charAt (0) <= 122)))
                    {
                        new Message ("Please make sure the row of the first location is a letter!");
                    }
                    else if (!((conversion.charAt (0) >= 65 && conversion.charAt (0) <= 84) || (conversion.charAt (0) >= 97 && conversion.charAt (0) <= 116)))
                    {
                        new Message ("Please make sure the row of the first location is a letter that is inbetween \"A\" and \"T\"!");
                    }
                    else if (!((conversion.charAt (4) >= 65 && conversion.charAt (4) <= 90) || (conversion.charAt (4) >= 97 && conversion.charAt (4) <= 122)))
                    {
                        new Message ("Please make sure the row of the second location is a letter!");
                    }
                    else if (!((conversion.charAt (4) >= 65 && conversion.charAt (4) <= 84) || (conversion.charAt (4) >= 97 && conversion.charAt (4) <= 116)))
                    {
                        new Message ("Please make sure the row of the second location is a letter that is inbetween \"A\" and \"T\"!");
                    }
                    else if (conversion.charAt (3) != 32)
                    {
                        new Message ("Please make sure that there is a space inbetween the entered locations!");
                    }
                    else if (conversion.charAt (0) != conversion.charAt (4))
                    {
                        new Message ("Please make sure that you entered locations that have the same row!");
                    }

                    else if ((conversion.charAt (1) <= 47 || conversion.charAt (1) >= 58) || (conversion.charAt (2) <= 47 || conversion.charAt (2) >= 58))
                    {
                        new Message ("Please make sure that the number for the aisle in the first location entered is a whole number!");
                    }
                    else if ((conversion.charAt (5) <= 47 || conversion.charAt (5) >= 58) || (conversion.charAt (6) <= 47 || conversion.charAt (6) >= 58))
                    {
                        new Message ("Please make sure that the number for the aisle in the second location entered is a whole number!");
                    }

                    else if (!((conversion.charAt (1) == 48 && conversion.charAt (2) > 48 && conversion.charAt (2) < 58) || (conversion.charAt (1) >= 49 && conversion.charAt (1) <= 50 && conversion.charAt (2) > 47 && conversion.charAt (2) < 58) || (conversion.charAt (1) == 51 && conversion.charAt (2) == 48)))
                    {
                        new Message ("Please make sure that the number for the aisle in the first location entered is inbetween \"01\" and \"30\"!");
                    }
                    else if (!((conversion.charAt (5) == 48 && conversion.charAt (6) > 48 && conversion.charAt (6) < 58) || (conversion.charAt (5) >= 49 && conversion.charAt (5) <= 50 && conversion.charAt (6) > 47 && conversion.charAt (6) < 58) || (conversion.charAt (5) == 51 && conversion.charAt (6) == 48)))
                    {
                        new Message ("Please make sure that the number for the aisle in the second location entered is inbetween \"01\" and \"30\"!");
                    }

                    else if ((conversion.charAt (1) == conversion.charAt (5) && conversion.charAt (2) == conversion.charAt (6)))
                    {
                        new Message ("Please make sure that the number for the aisle in the first location entered is different than the aisle for the second location entered!");
                    }

                }
                catch (Exception e)
                {
                    new Message ("Please enter the first location and the second location of the row of seats that you want to buy!");
                }
            }
        }

        else if (choice.equalsIgnoreCase ("aisle"))
        {
            // here is a line of code that asks the user to enter the amount of tickets they want to buy.
            c.setColor (Color.black);
            c.setFont (new Font ("Arial", 0, 13));
            c.drawString ("Note: The format for seats should be (Row Letter)(Aisle Number).", 20, 230);
            c.drawString ("An example would be \"A01\" if you want a seat in the first aisle in the first row.", 20, 250);

            c.setFont (new Font ("Arial", 0, 17));
            c.drawString ("Can you please enter the locations of the points of the aisle you would like to buy?", 20, 275);
            c.drawString ("An example would be \"A01 D01\". Make sure they are separated by a space.", 20, 295);

            done = false;
            while (!done)
            {
                try
                {
                    c.setCursor (15, 73);
                    c.print (' ', 50);
                    c.println ();
                    c.setCursor (15, 73);
                    done = false;

                    borderMaker ();
                    cost ();

                    conversion = c.readLine ();

                    borderMaker ();
                    cost ();

                    if (
                            conversion.length () == 7 &&
                            conversion.charAt (0) != 32 &&
                            conversion.charAt (conversion.length () - 1) != 32 &&
                            ((conversion.charAt (0) >= 65 && conversion.charAt (0) <= 84) || (conversion.charAt (0) >= 97 && conversion.charAt (0) <= 116)) &&
                            ((conversion.charAt (4) >= 65 && conversion.charAt (4) <= 84) || (conversion.charAt (4) >= 97 && conversion.charAt (4) <= 116)) &&
                            conversion.charAt (3) == 32 &&
                            conversion.charAt (0) != conversion.charAt (4) &&

                            ((conversion.charAt (1) == 48 && conversion.charAt (2) > 48 && conversion.charAt (2) < 58) || (conversion.charAt (1) >= 49 && conversion.charAt (1) <= 50 && conversion.charAt (2) > 47 && conversion.charAt (2) < 58) || (conversion.charAt (1) == 51 && conversion.charAt (2) == 48)) &&
                            ((conversion.charAt (5) == 48 && conversion.charAt (6) > 48 && conversion.charAt (6) < 58) || (conversion.charAt (5) >= 49 && conversion.charAt (5) <= 50 && conversion.charAt (6) > 47 && conversion.charAt (6) < 58) || (conversion.charAt (5) == 51 && conversion.charAt (6) == 48)) &&
                            (conversion.charAt (1) == conversion.charAt (5) &&
                                conversion.charAt (2) == conversion.charAt (6))
                            )
                    {
                        conversion = conversion.substring (0, 1).toUpperCase () + conversion.substring (1, 3) + " " + conversion.substring (4, 5).toUpperCase () + conversion.substring (5);

                        if (conversion.charAt (0) > conversion.charAt (4))
                        {
                            conversion = conversion.substring (4) + " " + conversion.substring (0, 3);
                        }

                        for (int i = conversion.charAt (0) ; i <= conversion.charAt (4) ; i++)
                        {
                            amountOfTickets++;
                        }
                        enteredLocation = new String [amountOfTickets];
                        for (int i = 0 ; i < amountOfTickets ; i++)
                        {
                            temp = ((char) (conversion.charAt (0) + i)) + conversion.substring (1, 3);
                            if (!seatIsTaken [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1])
                            {
                                enteredLocation [i] = temp;
                            }
                            else if (seatIsTaken [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1])
                            {
                                JOptionPane.showMessageDialog (null, "Please make sure to enter a aisle that doesn't have a seat taken in it!", "Seat is Taken!", JOptionPane.ERROR_MESSAGE);
                                done = false;
                                break;
                            }
                            done = true;
                        }
                    }
                    else if (conversion.length () != 7)
                    {
                        new Message ("Please enter the first location and the second location of the aisle of seats you want to buy!");
                    }
                    else if (conversion.charAt (0) == 32)
                    {
                        new Message ("Please make sure to not have a space at the start of the locations!");
                    }
                    else if (conversion.charAt (conversion.length () - 1) == 32)
                    {
                        new Message ("Please make sure to not have a space at the end of the locations!");
                    }
                    else if (!((conversion.charAt (0) >= 65 && conversion.charAt (0) <= 90) || (conversion.charAt (0) >= 97 && conversion.charAt (0) <= 122)))
                    {
                        new Message ("Please make sure the aisle of the first location is a letter!");
                    }
                    else if (!((conversion.charAt (0) >= 65 && conversion.charAt (0) <= 84) || (conversion.charAt (0) >= 97 && conversion.charAt (0) <= 116)))
                    {
                        new Message ("Please make sure the aisle of the first location is a letter that is inbetween \"A\" and \"T\"!");
                    }
                    else if (!((conversion.charAt (4) >= 65 && conversion.charAt (4) <= 90) || (conversion.charAt (4) >= 97 && conversion.charAt (4) <= 122)))
                    {
                        new Message ("Please make sure the aisle of the second location is a letter!");
                    }
                    else if (!((conversion.charAt (4) >= 65 && conversion.charAt (4) <= 84) || (conversion.charAt (4) >= 97 && conversion.charAt (4) <= 116)))
                    {
                        new Message ("Please make sure the aisle of the second location is a letter that is inbetween \"A\" and \"T\"!");
                    }
                    else if (conversion.charAt (3) != 32)
                    {
                        new Message ("Please make sure that there is a space inbetween the entered locations!");
                    }
                    else if (conversion.charAt (0) == conversion.charAt (4))
                    {
                        new Message ("Please make sure that you entered locations that have the same row!");
                    }

                    else if ((conversion.charAt (1) <= 47 || conversion.charAt (1) >= 58) || (conversion.charAt (2) <= 47 || conversion.charAt (2) >= 58))
                    {
                        new Message ("Please make sure that the number for the aisle in the first location entered is a whole number!");
                    }
                    else if ((conversion.charAt (5) <= 47 || conversion.charAt (5) >= 58) || (conversion.charAt (6) <= 47 || conversion.charAt (6) >= 58))
                    {
                        new Message ("Please make sure that the number for the aisle in the second location entered is a whole number!");
                    }

                    else if (!((conversion.charAt (1) == 48 && conversion.charAt (2) > 48 && conversion.charAt (2) < 58) || (conversion.charAt (1) >= 49 && conversion.charAt (1) <= 50 && conversion.charAt (2) > 47 && conversion.charAt (2) < 58) || (conversion.charAt (1) == 51 && conversion.charAt (2) == 48)))
                    {
                        new Message ("Please make sure that the number for the aisle in the first location entered is inbetween \"01\" and \"30\"!");
                    }
                    else if (!((conversion.charAt (5) == 48 && conversion.charAt (6) > 48 && conversion.charAt (6) < 58) || (conversion.charAt (5) >= 49 && conversion.charAt (5) <= 50 && conversion.charAt (6) > 47 && conversion.charAt (6) < 58) || (conversion.charAt (5) == 51 && conversion.charAt (6) == 48)))
                    {
                        new Message ("Please make sure that the number for the aisle in the second location entered is inbetween \"01\" and \"30\"!");
                    }

                    else if ((conversion.charAt (1) != conversion.charAt (5) && conversion.charAt (2) != conversion.charAt (6)))
                    {
                        new Message ("Please make sure that the number for the aisle in the first location entered is the same as the aisle for the second location entered!");
                    }


                }
                catch (Exception e)
                {
                    new Message ("Please enter the first location and the second location of the aisle of seats that you want to buy!");
                }
            }
        }



        // here is a line of code that tells the user what tickets they bought.
        c.setColor (Color.black);
        c.setFont (new Font ("Arial", 0, 17));
        c.drawString ("Here are the seats whose tickets you purchased:", 20, 320);

        // here are lines of code that display the actual locations to the screen. If the amount of tickets the user bought is over the maximum, then it displays the first few tickets
        if (enteredLocation.length > maxTicketsShown)
        {
            c.setFont (new Font ("Arial", 0, 13));
            c.drawString ("Note: Since you purchased so many tickets, only the first " + maxTicketsShown + " are shown. However, the other tickets not shown are still yours", 20, 340);

            for (int i = 0 ; i < maxTicketsShown - 1 ; i++)
            {
                shownLocations += enteredLocation [i] + ", ";
            }
            shownLocations += "and " + enteredLocation [maxTicketsShown - 1];
        }
        else if (amountOfTickets == 1)
        {
            shownLocations += enteredLocation [enteredLocation.length - 1];
        }


        else
        {
            for (int i = 0 ; i < enteredLocation.length - 1 ; i++)
            {
                shownLocations += enteredLocation [i] + ", ";
            }
            shownLocations += "and " + enteredLocation [enteredLocation.length - 1];
        }

        // here are the lines of code that actually show the locations
        c.setFont (new Font ("Arial", 0, 17));
        c.drawString (shownLocations, 20, 365);

        // here are the lines of code that display the total price to the user. It finds the total price by calling on the ticketPrice() method and passing each location into that method.
        for (int i = 0 ; i < enteredLocation.length ; i++)
        {
            totalPrice += ticketPrice (enteredLocation [i]);
        }


        conversion = totalPrice + "";
        if (conversion.length () - conversion.indexOf (".") == 2)
        {
            conversion += "0";
        }


        // here is the actual line that displays the total price to the user
        c.drawString ("The total cost for the tickets you purchased is: $" + conversion, 20, 390);


        // here asks the user if they want to see the seating plan before they buy their ticket
        c.drawString ("Would you like to confirm your purchase of these tickets? (\"Yes\" or \"No\")", 20, 415);


        // here are the error traps for the entered message from the user (either "yes" or "no")
        done = false;
        while (!done)
        {
            try
            {
                c.setCursor (21, 72);
                c.print (' ', 50);
                c.println ();
                c.setCursor (21, 72);
                done = false;

                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                choice = c.readLine ();

                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                if (!choice.equalsIgnoreCase ("yes") && !choice.equalsIgnoreCase ("no"))
                {
                    new Message ("Please enter \"Yes\" or \"No\"");
                }
                else if (choice.equalsIgnoreCase ("yes"))
                {
                    done = true;
                }
                else
                {
                    moveOn = false;
                    return;
                }
            }
            catch (Exception e)  // catches any error thrown by the try command
            {
                new Message ("Please enter \"yes\" or \"no\" into the program!");
            }
        }

        // here asks the user for their credit card number
        c.setColor (Color.black);
        c.drawString ("Can you please enter your credit card number?", 20, 455);
        c.drawString ("Note: it has to be 16 digits long and it must have spaces inbetween each 4 digits.", 20, 475);
        c.drawString ("Credit Card Number: ", 20, 495);

        // here are the error traps for the entered message from the user (either "yes" or "no")
        done = false;
        while (!done)
        {
            try
            {
                c.setCursor (25, 24);
                c.print (' ', 50);
                c.println ();
                c.setCursor (25, 24);
                specialCharacters = false;
                done = false;

                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                conversion = c.readLine ();

                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                if (conversion.length () == 19 && conversion.charAt (0) != 32 && conversion.charAt (conversion.length () - 1) != 32)
                {
                    for (int i = 0 ; i < conversion.length () ; i++)
                    {
                        if (conversion.charAt (i) == 32)
                        {
                            amountOfSpaces++;
                        }
                    }
                    if (amountOfSpaces == 3)
                    {
                        for (int i = 0 ; i < conversion.length () ; i++)
                        {
                            if ((i + 1) % 5 == 0 && conversion.charAt (i) == 32)
                            {
                                continue;
                            }
                            else if ((i + 1) % 5 == 0)
                            {
                                new Message ("You are supposed to have spaces inbetween each four numbers, so do so! Don't have any other character!");
                                specialCharacters = true;
                                break;
                            }
                            if (!specialCharacters && ((conversion.charAt (i) <= 47) || (conversion.charAt (i) >= 58)))
                            {
                                specialCharacters = true;
                            }
                        }
                        if (!specialCharacters)
                        {
                            File currentFile;
                            BufferedReader tempReader;
                            temp = "";
                            try
                            {
                                currentFile = new File ("monday.txt");
                                if (!stolenCard && currentFile.exists ())
                                {
                                    tempReader = new BufferedReader (new FileReader ("monday.txt"));
                                    while ((temp = tempReader.readLine ()) != null)
                                    {
                                        if (!temp.split (",") [1].equals (actualCurrentNames [1]) && temp.split (",") [3].equals (conversion))
                                        {
                                            stolenCard = true;
                                        }
                                    }
                                }
                                currentFile = new File ("tuesday.txt");
                                if (!stolenCard && currentFile.exists ())
                                {
                                    tempReader = new BufferedReader (new FileReader ("tuesday.txt"));
                                    while ((temp = tempReader.readLine ()) != null)
                                    {
                                        if (!temp.split (",") [1].equals (actualCurrentNames [1]) && temp.split (",") [3].equals (conversion))
                                        {
                                            stolenCard = true;
                                        }
                                    }
                                }
                                currentFile = new File ("wednesday.txt");
                                if (!stolenCard && currentFile.exists ())
                                {
                                    tempReader = new BufferedReader (new FileReader ("wednesday.txt"));
                                    while ((temp = tempReader.readLine ()) != null)
                                    {
                                        if (!temp.split (",") [1].equals (actualCurrentNames [1]) && temp.split (",") [3].equals (conversion))
                                        {
                                            stolenCard = true;
                                        }
                                    }
                                }
                                currentFile = new File ("thursday.txt");
                                if (!stolenCard && currentFile.exists ())
                                {
                                    tempReader = new BufferedReader (new FileReader ("thursday.txt"));
                                    while ((temp = tempReader.readLine ()) != null)
                                    {
                                        if (!temp.split (",") [1].equals (actualCurrentNames [1]) && temp.split (",") [3].equals (conversion))
                                        {
                                            stolenCard = true;
                                        }
                                    }
                                }
                                currentFile = new File ("friday.txt");
                                if (!stolenCard && currentFile.exists ())
                                {
                                    tempReader = new BufferedReader (new FileReader ("friday.txt"));
                                    while ((temp = tempReader.readLine ()) != null)
                                    {
                                        if (!temp.split (",") [1].equals (actualCurrentNames [1]) && temp.split (",") [3].equals (conversion))
                                        {
                                            stolenCard = true;
                                        }
                                    }
                                }
                            }
                            catch (Exception e)
                            {
                            }
                            if (!stolenCard)
                            {
                                done = true;
                            }
                            else
                            {

                                JOptionPane.showMessageDialog (null, "It seems like you have entered a credit card number that is already in use by someone else.\nIf you feel that our records are wrong, please go to wlmac.ca to voice your complaint.\n(And if this card is truly stolen, then LOL, you are such a bad thief)", "Stolen Card!", JOptionPane.ERROR_MESSAGE);
                                moveOn = false;
                                return;
                            }
                        }
                        else
                        {
                            new Message ("Why did you enter a credit card number that contains special characters other than a space?! An example of a credit card number is: \"0000 0000 0000 0000\", so follow that!");
                        }
                    }
                    else
                    {
                        new Message ("Why aren't there 3 spaces in what you entered?!? There is supposed to be a space inbetween every four numbers! An example is: \"0000 0000 0000 0000\".");
                    }
                }
                else if (conversion.length () != 19) // conversion.length () == 19 && conversion.charAt (0) != 32 && conversion.charAt (conversion.length () - 1) != 32
                {
                    new Message ("You were told to enter your credit card number, with spaces inbetween each four numbers! That means whatever you enter should be 19 characters long! An example is: \"0000 0000 0000 0000\".");
                }

                else if (conversion.charAt (0) == 32)
                {
                    new Message ("Please do not have a space at the start of the credit card numbers!! An example is: \"0000 0000 0000 0000\".");
                }

                else if (conversion.charAt (conversion.length () - 1) == 32)
                {
                    new Message ("Please do not have a space at the end of the credit card numbers!! An example is: \"0000 0000 0000 0000\".");
                }
            }
            catch (NullPointerException e)  // catches any error thrown by the try command
            {
                new Message ("Please enter your credit card number into the program! An example is: \"0000 0000 0000 0000\".");
            }
        }

        // here are lines of code that clear the credit card number for security reasons.
        c.setCursor (25, 24);
        c.print (' ', 50);
        c.println ();

        // here are lines of code that generates the credit card number to show, along with asterisks at the start to cover the first 12 numbers.
        creditCardNumber = "**** **** **** ";
        creditCardNumber += conversion.substring (15);
        c.setCursor (25, 24);
        c.println (creditCardNumber);

        creditCardNumber = conversion;


        // here asks the user to enter the exipry date of their credit card
        c.setColor (Color.black);
        c.drawString ("Please enter the expiry date of your credit card (Month number)(Last 2 digits of the year):", 20, 517);

        // here are the error traps for the entered expiry date from the user
        done = false;
        while (!done)
        {
            try
            {
                c.setCursor (26, 86);
                c.print (' ', 50);
                c.println ();
                c.setCursor (26, 86);
                specialCharacters = false;
                done = false;

                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                conversion = c.readLine ();

                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                if (conversion.length () == 5 && conversion.charAt (0) >= 48 && conversion.charAt (0) <= 57 && conversion.charAt (conversion.length () - 1) >= 48 && conversion.charAt (conversion.length () - 1) <= 57)
                {
                    for (int i = 0 ; i < conversion.length () ; i++)
                    {
                        if (conversion.charAt (i) == 47)
                        {
                            amountOfSlashes++;
                        }
                    }
                    if (amountOfSlashes == 1)
                    {
                        for (int i = 0 ; i < conversion.length () ; i++)
                        {
                            if (i == 2 && conversion.charAt (i) == 47)
                            {
                                continue;
                            }
                            else if (i == 2)
                            {
                                new Message ("You are supposed to have slash inbetween the month and the year, so do so! Don't have any other character there!");
                                break;
                            }
                            if (!specialCharacters && ((conversion.charAt (i) <= 47) || (conversion.charAt (i) >= 58)))
                            {
                                specialCharacters = true;
                            }
                        }
                        if (!specialCharacters)
                        {
                            try
                            {
                                if (Integer.parseInt (conversion.substring (0, 2)) >= 1 && Integer.parseInt (conversion.substring (0, 2)) <= 12)
                                {
                                    Date now = new Date ();
                                    int currentMonth = now.getMonth () + 1;
                                    int currentYear = now.getYear () + 1900;
                                    if (Integer.parseInt (conversion.substring (3)) < 40)
                                    {
                                        amountToAddToYear = currentYear - (currentYear % 100);
                                    }
                                    else
                                    {
                                        amountToAddToYear = currentYear - (currentYear % 100) - 100;
                                    }
                                    if (Integer.parseInt (conversion.substring (3)) + amountToAddToYear > currentYear || (Integer.parseInt (conversion.substring (0, 2)) >= currentMonth && Integer.parseInt (conversion.substring (3)) + amountToAddToYear == currentYear))
                                    {
                                        differentExpiry = false;
                                        File currentFile;
                                        BufferedReader tempReader;
                                        temp = "";
                                        try
                                        {
                                            currentFile = new File ("monday.txt");
                                            if (!differentExpiry && currentFile.exists ())
                                            {
                                                tempReader = new BufferedReader (new FileReader ("monday.txt"));
                                                while ((temp = tempReader.readLine ()) != null)
                                                {
                                                    if (temp.split (",") [3].equals (creditCardNumber) && !temp.split (",") [4].equals (conversion))
                                                    {
                                                        differentExpiry = true;
                                                    }
                                                }
                                            }
                                            currentFile = new File ("tuesday.txt");
                                            if (!differentExpiry && currentFile.exists ())
                                            {
                                                tempReader = new BufferedReader (new FileReader ("tuesday.txt"));
                                                while ((temp = tempReader.readLine ()) != null)
                                                {
                                                    if (temp.split (",") [3].equals (creditCardNumber) && !temp.split (",") [4].equals (conversion))
                                                    {
                                                        differentExpiry = true;
                                                    }
                                                }
                                            }
                                            currentFile = new File ("wednesday.txt");
                                            if (!differentExpiry && currentFile.exists ())
                                            {
                                                tempReader = new BufferedReader (new FileReader ("wednesday.txt"));
                                                while ((temp = tempReader.readLine ()) != null)
                                                {
                                                    if (temp.split (",") [3].equals (creditCardNumber) && !temp.split (",") [4].equals (conversion))
                                                    {
                                                        differentExpiry = true;
                                                    }
                                                }
                                            }
                                            currentFile = new File ("thursday.txt");
                                            if (!differentExpiry && currentFile.exists ())
                                            {
                                                tempReader = new BufferedReader (new FileReader ("thursday.txt"));
                                                while ((temp = tempReader.readLine ()) != null)
                                                {
                                                    if (temp.split (",") [3].equals (creditCardNumber) && !temp.split (",") [4].equals (conversion))
                                                    {
                                                        differentExpiry = true;
                                                    }
                                                }
                                            }
                                            currentFile = new File ("friday.txt");
                                            if (!differentExpiry && currentFile.exists ())
                                            {
                                                tempReader = new BufferedReader (new FileReader ("friday.txt"));
                                                while ((temp = tempReader.readLine ()) != null)
                                                {
                                                    if (temp.split (",") [3].equals (creditCardNumber) && !temp.split (",") [4].equals (conversion))
                                                    {
                                                        differentExpiry = true;
                                                    }
                                                }
                                            }
                                        }
                                        catch (Exception e)
                                        {
                                        }
                                        if (!differentExpiry)
                                        {
                                            expiryDate = conversion;
                                            done = true;
                                        }
                                        else
                                        {
                                            JOptionPane.showMessageDialog (null, "It seems like you have entered a credit card expiry date that is wrong then what our records say.\nIf you feel that our records are wrong, please go to wlmac.ca to voice your complaint.\n(And if this card is truly wrong, then come on, check your card again and make sure you enter the right expiry date!)", "Wrong Expiry Date!", JOptionPane.ERROR_MESSAGE);
                                            moveOn = false;
                                            return;
                                        }
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog (null, "It seems like you have entered a credit card expiry date that is expired.\nIf you feel that our records are wrong, please go to wlmac.ca to voice your complaint.\n(And if this card is truly expired, then come on, get a new card!)", "Expired Card!", JOptionPane.ERROR_MESSAGE);
                                        moveOn = false;
                                        return;
                                    }
                                }
                                else
                                {
                                    new Message ("You do realize that there are only 12 months in a year? Please enter a month from \"01\" to \"12\".");
                                }
                            }
                            catch (NumberFormatException e)
                            {
                                new Message ("You are supposed to enter the month and last two digits of the year, separated by a slash! So why do you have characters that aren't numbers there?!?");
                            }
                        }
                        else
                        {
                            new Message ("Why did you enter a credit card expiry date that contains special characters other than a slash?! An example of a credit card expiry date is: \"03/25\", so follow that!");
                        }
                    }
                    else
                    {
                        new Message ("Why isn't there 1 slash in what you entered?!? There is supposed to be a slash inbetween the month and last two digits of the year! An example is: \"03/25\".");
                    }
                }
                else if (conversion.length () != 5) // conversion.length () == 5 && conversion.charAt (0) >= 48 && conversion.charAt (conversion.length () - 1) <= 57
                {
                    JOptionPane.showMessageDialog (null, "Please enter your credit card's expiry date, separated by a slash!\nAn example would be \"03/25\", where 03 is the month and 25 is the last two numbers of the year (in this example, the 25 means 2025).\nNote: if the month for your credit card's expiry date starts with a \"0\", then put that 0!", "Bad Entry!", JOptionPane.ERROR_MESSAGE);
                }

                else if (conversion.charAt (0) < 48 || conversion.charAt (0) > 57)
                {
                    new Message ("Please do not have a special character at the start of the credit card expiry date!! An example is: \"03/25\".");
                }

                else if (conversion.charAt (conversion.length () - 1) < 48 || conversion.charAt (conversion.length () - 1) > 57)
                {
                    new Message ("Please do not have a special character at the end of the credit card expiry date!! An example is: \"03/25\".");
                }
            }
            catch (Exception e)  // catches any error thrown by the try command
            {
                new Message ("Please enter your credit card's expiry date into the program, separated by a slash! An example would be \"03/25\", where 03 is the month and 25 is the last two numbers of the year (in this example, the 25 means 2025)");
            }
        }

        // here prompts the user to enter their CVV number for their credit card
        c.setColor (Color.black);
        c.drawString ("Please enter your CVV number (3 digit number on the back of your card):", 20, 537);

        // here are the error traps for the entered CVV from the user
        done = false;
        while (!done)
        {
            try
            {
                c.setCursor (27, 73);
                c.print (' ', 50);
                c.println ();
                c.setCursor (27, 73);
                done = false;

                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                conversion = c.readLine ();

                cvv = Integer.parseInt (conversion) + "";
                cvv = conversion; // Note, this line was originally added to the program. My partner didn't understand why it was here, as he thought that the previous line was sufficient, so it was deleted (I had signed off on it because my IQ is 3). We had to then ask our teacher if it was alright that she added this line to the program (because we had already handed it in). This line is useful because it allows the program to handle cvv numbers that are 3 digits long and start with a 0.
                // here is a line of code that calls on the borderMaker() method to create white rectangles on the left and top, and also create the black borders on the left and right sides.
                borderMaker ();
                cost ();

                if (cvv.length () == 3)
                {
                    stolenCard = true;
                    File currentFile;
                    BufferedReader tempReader;
                    temp = "";
                    try
                    {
                        currentFile = new File ("monday.txt");
                        if (currentFile.exists ())
                        {
                            tempReader = new BufferedReader (new FileReader ("monday.txt"));
                            while ((temp = tempReader.readLine ()) != null)
                            {
                                if (temp.split (",") [3].equals (creditCardNumber))
                                {
                                    conversion = temp.split (",") [5];
                                }
                            }
                        }
                        currentFile = new File ("tuesday.txt");
                        if (currentFile.exists ())
                        {
                            tempReader = new BufferedReader (new FileReader ("tuesday.txt"));
                            while ((temp = tempReader.readLine ()) != null)
                            {
                                if (temp.split (",") [3].equals (creditCardNumber))
                                {
                                    conversion = temp.split (",") [5];
                                }
                            }
                        }
                        currentFile = new File ("wednesday.txt");
                        if (currentFile.exists ())
                        {
                            tempReader = new BufferedReader (new FileReader ("wednesday.txt"));
                            while ((temp = tempReader.readLine ()) != null)
                            {
                                if (temp.split (",") [3].equals (creditCardNumber))
                                {
                                    conversion = temp.split (",") [5];
                                }
                            }
                        }
                        currentFile = new File ("thursday.txt");
                        if (currentFile.exists ())
                        {
                            tempReader = new BufferedReader (new FileReader ("thursday.txt"));
                            while ((temp = tempReader.readLine ()) != null)
                            {
                                if (temp.split (",") [3].equals (creditCardNumber))
                                {
                                    conversion = temp.split (",") [5];
                                }
                            }
                        }
                        currentFile = new File ("friday.txt");
                        if (currentFile.exists ())
                        {
                            tempReader = new BufferedReader (new FileReader ("friday.txt"));
                            while ((temp = tempReader.readLine ()) != null)
                            {
                                if (temp.split (",") [3].equals (creditCardNumber))
                                {
                                    conversion = temp.split (",") [5];
                                }
                            }
                        }
                    }
                    catch (Exception e)
                    {
                    }
                    if (cvvTries < maxCVVTries && conversion.equals (cvv))
                    {
                        stolenCard = false;
                        break;
                    }
                    else if (cvvTries < maxCVVTries && !conversion.equals (cvv))
                    {
                        cvvTries++;
                        if ((maxCVVTries - cvvTries) > 1)
                        {
                            new Message ("Please make sure that you correctly entered your credit card's CVV number. You have " + (maxCVVTries - cvvTries) + " tries left.");
                        }
                        else if ((maxCVVTries - cvvTries) == 1)
                        {
                            new Message ("Please make sure that you correctly entered your credit card's CVV number. You have " + (maxCVVTries - cvvTries) + " try left.");
                        }
                    }
                    if (!stolenCard && cvvTries < maxCVVTries)
                    {
                        done = true;
                    }
                    else if (stolenCard && cvvTries >= maxCVVTries)
                    {
                        JOptionPane.showMessageDialog (null, "It seems like you have entered a credit card CVV number different than the one we have on record.\nIf you feel that our records are wrong, please go to wlmac.ca to voice your complaint.\n(And if this card is truly stolen, then come on, become a better thief!)", "Stolen Card!", JOptionPane.ERROR_MESSAGE);
                        moveOn = false;
                        return;
                    }
                }
                else
                {
                    new Message ("Please enter your credit card's 3 digit CVV number into the program! Make sure that it contains 3 digits!");
                }
            }
            catch (NumberFormatException e)  // catches any error thrown by the try command
            {
                new Message ("Please enter your credit card's 3 digit CVV number into the program! Make sure that it contains no special characters!");
            }
        }

        for (int i = 0 ; i < enteredLocation.length ; i++)
        {
            seatIsTaken [enteredLocation [i].charAt (0) - 65] [Integer.parseInt (enteredLocation [i].substring (1)) - 1] = true;
            userData [enteredLocation [i].charAt (0) - 65] [Integer.parseInt (enteredLocation [i].substring (1)) - 1] [0] = enteredLocation [i];
            userData [enteredLocation [i].charAt (0) - 65] [Integer.parseInt (enteredLocation [i].substring (1)) - 1] [1] = actualCurrentNames [1];
            userData [enteredLocation [i].charAt (0) - 65] [Integer.parseInt (enteredLocation [i].substring (1)) - 1] [2] = ticketPrice (enteredLocation [i]) + "";
            userData [enteredLocation [i].charAt (0) - 65] [Integer.parseInt (enteredLocation [i].substring (1)) - 1] [3] = creditCardNumber;
            userData [enteredLocation [i].charAt (0) - 65] [Integer.parseInt (enteredLocation [i].substring (1)) - 1] [4] = expiryDate;
            userData [enteredLocation [i].charAt (0) - 65] [Integer.parseInt (enteredLocation [i].substring (1)) - 1] [5] = cvv + "";
        }


        // here are lines of code that prints the tickets bought to the .txt file
        try
        {
            output = new PrintWriter (new FileWriter (fileName));
            for (int i = 0 ; i < ROWS ; i++)
            {
                for (int j = 0 ; j < COLUMNS ; j++)
                {
                    if (seatIsTaken [i] [j])
                    {
                        for (int k = 0 ; k < userData [i] [j].length - 1 ; k++)
                        {
                            output.print (userData [i] [j] [k] + ",");
                        }
                        output.println (userData [i] [j] [userData [i] [j].length - 1]);
                    }
                }
            }
            output.close ();
        }


        catch (Exception e)
        {
        }
    }


    /*
        Local Variable Dictionary
        Type            Name                        Expected Data
        String          thankYouMessage             This variable will be used to hold the String value of the thank you message that will be displayed to the user.
        String          shownLocations              This variable will be used to hold the String value of all of the locations that the user purchased. If there are more than the maximum tickets shown, then not all of the tickets are shown to the user.
        String          format                      This variable will be used to format parts of the output, such as the total price paid by the user.
        String          creditCardNumber            This variable will be used to hold the number of the credit card that was entered by the user as a String.
        int             maximumLastNameLength       This variable will be used to hold the maximum length of the last name. This will be useful in formatting the last name, like if it is really long. This value will be stored as an integer.
        int             maximumFirstNameLength      This variable will be used to hold the maximum length of the first name. This will be useful in formatting the first name, like if it is really long. This value will be stored as an integer.
        int             maxTicketsShown             This variable will be used to hold the maximum amount of tickets that will be shown to the user as an integer.
        double          totalPrice                  This variable will be used to hold the total price that the user paid for the tickets.
        int             i                           This variable will be used to hold the value of the current iteration of the for loop that it is used in.

        This method will be used to create a screen that will show the user what they have purchased.
        This method first calls on the title to clear the screen and also create the title for the program. After that, the drawString() method is used to make the title more specific, as it tells the user that they are in the "Purchase Summary" part of the program.
        After that, the color is set to the accent color using setColor() and accentColor, and the fillRect() command is used to create the background for the screen.
        After that, the color is set to white and the font is set to "Arial", plain, size 20, using setFont(). After that, there is an if statement that checks to see if the length of the names are longer than the maximum name lengths.

        if (actualCurrentNames [0].length () > maximumFirstNameLength && actualCurrentNames [1].length () > maximumLastNameLength)          This if statement checks to see if the first name and the last name are longer than their maximum limits.
        else if (actualCurrentNames [0].length () > maximumFirstNameLength && actualCurrentNames [1].length () <= maximumLastNameLength)    This else if statement checks to see if the first name is longer than the maximum length but the last name is less or equal to the maximum length.
        else if (actualCurrentNames [0].length () <= maximumFirstNameLength && actualCurrentNames [1].length () > maximumLastNameLength)    This else if statement checks to see if the first name is less or equal to the maximum length and the last name is greater than the maximum length.
        else                                                                                                                                This else runs if the first name and last names are less or equal to the maximum length of the names

        Depending on each if statement, then the thankYouMessage variable will be changed accordingly. Using drawString(), the thank you message is shown to the user.
        The program is also told the amount of tickets that the user bought. Plus, the user is shown the locations of the seat tickets that they bought. Using if statements, the locations are shown.

        if (amountOfTickets > maxTicketsShown)          This if statement runs if the amount of tickets that the user owns is greater than the maximum number of tickets that the program will display.
        else if (amountOfTickets == 1)                  This else if statement runs if the user owns 1 ticket.
        else                                            This else statement runs if the user owns an amount of tickets that is less or equal to the maximum amount of tickets and greater than 1 tickets.

        Depending on whatever the amount of tickets the user bought, the shownLocations variable is modified accordingly.

        After that, the font is set to "Arial", plain, size 20 using setFont(). drawString() is used to show the shownLocations variable to the user.
        Next, using a for loop, the program goes through the enteredLocation array (it increments up by 1). Each location is then taken, passed through to the ticketPrice() method, and the returned price is added to the totalPrice variable.
        After that, the format variable is set to the String value of the totalPrice's value and it is used to see if the price only goes up to the tenth place, and if it does, then a zero is added onto the format variable. After that, a drawString() is used to output the formatted price.

        Also, there is a for loop that starts at 0 and ends right before 12 (it increments up by 1). Inside this for loop, the variable creditCardNumber gets an asterisk added on to the end of it each time. After that, the last 4 digits of the credit card number (using the substring() method to get it) are added to the creditCardNumber variable. Then, drawString() is used to display the value to the user.

        After that, the program shows the user the expiry date of their card and their CVV number using drawString().
        Lastly, the pause() method is called to tell the user to press a key for the program to move on.

    */


    public void display ()
    {
        // here are the local variable declarations for the display() method.
        String thankYouMessage = "";
        String shownLocations = "";
        String format = "";
        String creditCardNumber = "";
        int maximumLastNameLength = 15;
        int maximumFirstNameLength = 15;
        int maxTicketsShown = 15;
        double totalPrice = 0;

        // here is a line of code that calls on the title() method to run, which clears the screen and creates the upper box for the title.
        title ();

        // here is a line of code that adds to the title, which makes it more specific to the output screen.
        c.drawString ("Purchase Summary", 270, 50);

        // here are the lines of code that create a box that the display information will be put inside. It will be the color of the accentColor variable, and the box will have 20 pixels of space around it.
        c.setColor (accentColor);
        c.fillRect (75, 120, 760, 160);

        c.setColor (Color.black);
        c.drawRect (75, 120, 760, 160);

        // here are the lines of code that actually display the output to the user.
        c.setColor (Color.WHITE);
        c.setFont (new Font ("Arial", 0, 20));

        if (amountOfTickets == 1)
        {
            // here are the if statements that determine if the user's name is too long and if it is, then it changes the thankYouMessage variable accordingly
            if (actualCurrentNames [0].length () > maximumFirstNameLength && actualCurrentNames [1].length () > maximumLastNameLength)
            {
                thankYouMessage = "Thank you for buying this ticket!";
            }


            else if (actualCurrentNames [0].length () > maximumFirstNameLength && actualCurrentNames [1].length () <= maximumLastNameLength)
            {
                thankYouMessage = "Thank you, " + actualCurrentNames [0].charAt (0) + ". " + actualCurrentNames [1] + " for buying this ticket!";
            }


            else if (actualCurrentNames [0].length () <= maximumFirstNameLength && actualCurrentNames [1].length () > maximumLastNameLength)
            {
                thankYouMessage = "Thank you, " + actualCurrentNames [0] + " " + actualCurrentNames [1].charAt (0) + ". for buying this ticket!";
            }


            else
            {
                thankYouMessage = "Thank you, " + actualCurrentNames [0] + " " + actualCurrentNames [1] + " for buying this ticket!";
            }

            format = "You have successfully bought tickets for " + amountOfTickets + " seats on " + day + "!";
        }
        else
        {
            // here are the if statements that determine if the user's name is too long and if it is, then it changes the thankYouMessage variable accordingly
            if (actualCurrentNames [0].length () > maximumFirstNameLength && actualCurrentNames [1].length () > maximumLastNameLength)
            {
                thankYouMessage = "Thank you for buying these tickets!";
            }


            else if (actualCurrentNames [0].length () > maximumFirstNameLength && actualCurrentNames [1].length () <= maximumLastNameLength)
            {
                thankYouMessage = "Thank you, " + actualCurrentNames [0].charAt (0) + ". " + actualCurrentNames [1] + " for buying these tickets!";
            }


            else if (actualCurrentNames [0].length () <= maximumFirstNameLength && actualCurrentNames [1].length () > maximumLastNameLength)
            {
                thankYouMessage = "Thank you, " + actualCurrentNames [0] + " " + actualCurrentNames [1].charAt (0) + ". for buying these tickets!";
            }


            else
            {
                thankYouMessage = "Thank you, " + actualCurrentNames [0] + " " + actualCurrentNames [1] + " for buying these tickets!";
            }

            format = "You have successfully bought tickets for " + amountOfTickets + " seats on " + day + "!";
        }

        // here are the actual lines of code that create the output.
        c.drawString (thankYouMessage, 100, 155);
        c.drawString (format, 100, 180);

        // here is a line of code that tells the user what tickets they bought.
        c.setFont (new Font ("Arial", 0, 20));
        c.drawString ("Here are the seat numbers whose tickets you purchased:", 100, 205);

        // here are lines of code that display the actual locations to the screen. If the amount of tickets the user bought is over the maximum, then it displays the first few tickets
        if (amountOfTickets > maxTicketsShown)
        {
            c.setFont (new Font ("Arial", 0, 15));
            c.drawString ("Because you purchased so many tickets, only the first " + maxTicketsShown + " are shown. The other tickets are still yours", 100, 225);
            for (int i = 0 ; i < maxTicketsShown - 1 ; i++)
            {
                shownLocations += enteredLocation [i] + ", ";
            }
            shownLocations += "and " + enteredLocation [maxTicketsShown - 1];
        }


        else if (amountOfTickets == 1)
        {
            shownLocations += enteredLocation [enteredLocation.length - 1];
        }


        else
        {
            for (int i = 0 ; i < enteredLocation.length - 1 ; i++)
            {
                shownLocations += enteredLocation [i] + ", ";
            }
            shownLocations += "and " + enteredLocation [enteredLocation.length - 1];
        }


        // here are the lines of code that actually show the locations of the tickets they purchased
        c.setFont (new Font ("Arial", 0, 20));
        c.drawString (shownLocations, 100, 245);

        // here are the lines of code that display the total price to the user. It finds the total price by calling on the ticketPrice() method and passing each location into that method.
        for (int i = 0 ; i < enteredLocation.length ; i++)
        {
            totalPrice += ticketPrice (enteredLocation [i]);
        }


        format = totalPrice + "";
        if (format.length () - format.indexOf (".") == 2)
        {
            format += "0";
        }


        // here is the actual line that displays the total price to the user
        c.drawString ("The total cost for the tickets you purchased is: $" + format, 100, 265);

        try
        {
            BufferedImage popcorn = ImageIO.read (new File ("popcorn.png"));
            c.drawImage (popcorn, 340, 300, null);
        }
        catch (IOException e)
        {
        }

        pause ();
    }


    /*
        Local Variable Dictionary
        Type            Name                    Expected Data
        Instance        input1                  This variable will be used to create an instance variable of the BufferedReader class, and it will be used to read the data in the given .txt file.
        String[][][]    seatData                This variable will be used to create a 3D String variable to hold the data of each seat after reading the file. The index 0 is the location, index 1 is the last name of the owner, index 2 is the price of the seat, and index 3 is the credit card number of that seat.
        String          temp                    This variable will be used to create a temporary String variable.
        String          format                  This variable will be used to create a way to format parts of the program, such as the credit card with asterisks or the price of the seat's ticket.
        int             remainingSeats          This variable will be used to hold the integer value of the amount of seats that are remaining. It starts at 600, which is the amount of seats in the theatre, and then goes down for the amount of
        boolean[][]     takenSeats              This variable will be used to hold the value of a 2D boolean array that will be used to tell if the seat is taken by someone or not. It has 20 rows and 30 columns.
        int             pointerPositionX        This variable will be used to hold the x-coordinate of the pointer's position in the grid as an integer.
        int             pointerPositionY        This variable will be used to hold the y-coordinate of the pointer's position in the grid as an integer.
        int             maximumLastNameLength   This variable will be used to hold the maximum length of the last name that will be displayed.
        char            menuMovement            This variable will be used to hold the value of the key pressed from the user.
        int             i                       This variable will be used to hold the value of the current iteration of the for loop that it is used in.
        int             j                       This variable will be used to hold the value of the current iteration of the for loop that it is used in. This variable is mainly used in nested for loops.

        This method will be used to create a grid that will allow the user to see the data on each seat by moving the cursor to whatever seat they want to see.
        First, there is a while loop that runs as long as the choice from the user isn't 10 or 13, which are the ASCII values of the ENTER key.
        It also sets the remainingSeats variable to the amount of rows multiplied by the amount of columns, which is 20 x 30, which is 600. This is so that program resets the amount to that value every time.
        After that, the color is set to white and the font is set to "Arial", bold, size 16. Then, a grid is created and its axises are labelled using for loops.
        Using drawString(), the program tells the user how many seats there are remaining for sale. Also, it tells the user the location of the seat and who owns that seat, if it is owned. by searching in the seatData array. If the name is over the maximum amount of characters, then the name is shortened to the first letter , and this is done using an if block. The seat's price is also relayed to the user.
        This is all if someone owns that seat. If no one owns that seat, then the user is told the price of the seat and they are also prompted to buy a ticket for a seat.
        Next, the color is set to black using setColor() and Color.BLACK, and the lines for the pointer for the grid are drawn using the drawLine() method. Also, there is an if block:

        if ((menuMovement == 'w' || menuMovement == 'W') && pointerPositionY > 0)                   This if statement runs if the key that the user pressed was W and the y position of the pointer is greater than 1. If this is true, then the value of pointerPositionY goes down by 1.
        else if ((menuMovement == 'w' || menuMovement == 'W') && pointerPositionY == 0)             This else if statement runs if the key that the user pressed was W and the y position of the pointer is equal to 1. If this is true, then the value of pointerPositionY is set to the amount of rows there are minus 1.
        else if ((menuMovement == 's' || menuMovement == 'S') && pointerPositionY < ROWS - 1)       This else if statement runs if the key that the user pressed was S and the y position of the pointer is less than the amount of rows minus 1. If this is true, then the value of pointerPositionY goes up by 1.
        else if ((menuMovement == 's' || menuMovement == 'S') && pointerPositionY == ROWS - 1)      This else if statement runs if the key that the user pressed was S and the y position of the pointer is equal to the amount of rows minus 1. If this is true, then the value of pointerPositionY is set to 0.
        else if ((menuMovement == 'a' || menuMovement == 'A') && pointerPositionX > 0)              This else if statement runs if the key that the user pressed was A and the x position of the pointer is greater than 0. If this is true, then the value of pointerPositionX goes down by 1.
        else if ((menuMovement == 'a' || menuMovement == 'A') && pointerPositionX == 0)             This else if statement runs if the key that the user pressed was A and the x position of the pointer is equal to 0. If this is true, then the value of pointerPositionX is set to the amount of columns there are minus 1.
        else if ((menuMovement == 'd' || menuMovement == 'D') && pointerPositionX < COLUMNS - 1)    This else if statement runs if the key that the user pressed was D and the x position of the pointer is less than the amount of columns minus 1. If this is true, then the value of pointerPositionX goes up by 1.
        else if ((menuMovement == 'd' || menuMovement == 'D') && pointerPositionX == COLUMNS - 1)   This else if statement runs if the key that the user pressed was D and the x position of the pointer is equal to the amount of columns minus 1. If this is true, then the value of pointerPositionX is set to 0.
        else if (menuMovement != 'w' && menuMovement != 'W' && menuMovement != 's' && menuMovement != 'S' && menuMovement != 'a' && menuMovement != 'A' && menuMovement != 'd' && menuMovement != 'D' && menuMovement != 10 && menuMovement != 13)
        ^ This else if statement checks to see if the user presses a key other than W, A, S, D, or ENTER, and if this is true, then the program gives the user an error message using hsa.Message.

        and these if statements are used to change the value of the pointerPositionX and pointerPositionY variables. If the user presses a key other than W, A, S, D, or ENTER, then the program gives the user an error message using hsa.Message.

    */

    /*
        Local Variable Dictionary
        Type            Name                    Expected Data
        String          fileName                This variable will be used to hold the name of the .txt file that the program needs to access.
        Instance        input1                  This variable will be used to create an instance variable of the BufferedReader class, and it will be used to read the data in the given .txt file.
        String[][][]    seatData                This variable will be used to create a 3D String variable to hold the data of each seat after reading the file. The index 0 is the location, index 1 is the last name of the owner, index 2 is the price of the seat, and index 3 is the credit card number of that seat.
        String          temp                    This variable will be used to create a temporary String variable.
        String          format                  This variable will be used to create a way to format parts of the program, such as the credit card with asterisks or the price of the seat's ticket.
        int             remainingSeats          This variable will be used to hold the integer value of the amount of seats that are remaining. It starts at 600, which is the amount of seats in the theatre, and then goes down for the amount of
        boolean[][]     takenSeats              This variable will be used to hold the value of a 2D boolean array that will be used to tell if the seat is taken by someone or not. It has 20 rows and 30 columns.
        int             pointerPositionX        This variable will be used to hold the x-coordinate of the pointer's position in the grid as an integer.
        int             pointerPositionY        This variable will be used to hold the y-coordinate of the pointer's position in the grid as an integer.
        int             maximumLastNameLength   This variable will be used to hold the maximum length of the last name that will be displayed.
        char            menuMovement            This variable will be used to hold the value of the key pressed from the user.

        This method will be used to create a grid that will allow the user to see the data on each seat by moving the cursor to whatever seat they want to see.
        First, there is a while loop that runs as long as the choice from the user isn't 10 or 13, which are the ASCII values of the ENTER key.
        It also sets the remainingSeats variable to the amount of rows multiplied by the amount of columns, which is 20 x 30, which is 600. This is so that program resets the amount to that value every time.
        After that, the color is set to white and the font is set to "Arial", bold, size 16. Then, a grid is created and its axises are labelled using for loops.
        Using drawString(), the program

    */



    public void seatingPlan ()
    {
        // here are the local variables that will be used in this method
        //String fileName = "TheatreSeatingPlan.txt";
        BufferedReader input1;
        String[] [] [] seatData = new String [ROWS] [COLUMNS] [4];
        // String temp; is used to help read the lines at the start of the program to figure out how many lines there are. It also tells the program which seats are taken and which aren't. lastly, it is used to help create the labels for the x- and y-axises for the grid.
        String temp = "";
        String format = "";
        int remainingSeats = ROWS * COLUMNS;
        boolean[] [] takenSeats = new boolean [ROWS] [COLUMNS];
        // int i is used as a counting variable in the for loop and it holds the value of the current iteration of the for loop.
        // int j is used as a counting variable in the nested for loop and it holds the value of the current iteration of the nested for loop.

        // here is the variable declaration for the local variable charstr. This line also sets its value to an empty string.
        int pointerPositionX = 0;
        int pointerPositionY = 0;
        int maximumLastNameLength = 15;
        char menuMovement = 'w';

        title ();

        // here adds a piece to the title that makes it more specific
        c.drawString ("Seating Plan", 270, 50);

        // here is the words that tell the user how to navigate through the seating plan
        c.setColor (Color.black);
        c.setFont (new Font ("Arial", Font.PLAIN, 12));
        c.drawString ("This seating plan tells you which seats are taken and which of your neighbors bought them. Use the WASD keys to navigate the plan, and press ENTER to leave.", 20, 95);
        c.drawString ("Note: Row \"A\" is closest to the movie screen and row \"T\" is the farthest.", 240, 110);
        // here is a try catch for reading to a file
        try
        {
            input1 = new BufferedReader (new FileReader (fileName));

            // this while loop checks to see how many lines there are in the file, and it stops at the end, when the line is blank
            while ((temp = input1.readLine ()) != null)
            {
                takenSeats [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1] = true;
                seatData [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1] [0] = temp.split (",") [0];
                seatData [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1] [1] = temp.split (",") [1];
                seatData [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1] [2] = temp.split (",") [2];
                seatData [temp.charAt (0) - 65] [Integer.parseInt (temp.substring (1, 3)) - 1] [3] = temp.split (",") [3];
                remainingSeats--;
            }
        }
        catch (Exception e)
        {
        }

        c.setColor (Color.BLACK);
        c.setFont (new Font ("Arial", 1, 16));
        // here is an if statement block that returns the values from the file on information on the seat the pointer is on. The color is also set to white.
        c.drawString ("There are " + remainingSeats + " seats remaining.", 340, 565);

        // here is an if statement that runs as long as the key pressed doesn't have the ASCII value of 13, which is the enter key value.
        while (menuMovement != 10 && menuMovement != 13)
        {
            remainingSeats = ROWS * COLUMNS;


            // here sets the font type to "Arial", the font to bold, and the font size to 16.
            c.setColor (Color.WHITE);

            // here are lines of code that help create the horizontal lines for the grid, along with the letters as labels for the rows.
            for (int i = -1 ; i <= ROWS ; i++)
            {
                if (i >= 0 && i < ROWS)
                {
                    temp = ((char) (i + 65)) + "";
                    c.drawString (temp, 68, 155 + i * 20);
                }
                c.drawLine (63, 140 + i * 20, 838, 140 + i * 20);
            }

            // here are lines of code that help create the vertical lines for the grid, along with the numbers as labels for the columns.
            for (int i = -1 ; i <= COLUMNS ; i++)
            {
                if (i >= 0 && i < COLUMNS)
                {
                    if (i >= 0 && i < 9)
                    {
                        temp = "0" + (i + 1) + "";
                    }
                    else
                    {
                        temp = (i + 1) + "";
                    }
                    c.drawString (temp, 90 + i * 25, 135);
                }
                c.drawLine (86 + i * 25, 120, 86 + i * 25, 540);
            }

            // here are lines of code that cover the cells of the grid that are false (which means that seat's ticket wasn't bought yet) with a white box. Here are also lines of code that store the values of the local array in the main array.
            for (int i = 0 ; i < ROWS ; i++)
            {
                for (int j = 0 ; j < COLUMNS ; j++)
                {
                    if (!takenSeats [i] [j])
                    {
                        c.fillRect (88 + j * 25, 142 + i * 20, 22, 17);
                    }
                    else
                    {
                        takenSeats [i] [j] = true;
                    }
                }
            }


            c.setColor (backgroundColor);
            c.fillRect (12, 570, 890, 28);

            c.setColor (Color.black);

            if (takenSeats [pointerPositionY] [pointerPositionX])
            {
                c.drawString ("This seat location is: " + seatData [pointerPositionY] [pointerPositionX] [0] + ".", 30, 585);

                // here are the if statements that determine if the user's name is too long and if it is, then it changes the displayed message accordingly
                if (seatData [pointerPositionY] [pointerPositionX] [1].length () > maximumLastNameLength)
                {
                    temp = "This seat is owned by the " + seatData [pointerPositionY] [pointerPositionX] [1].charAt (0) + ". family.";
                }
                else
                {
                    temp = "This seat is owned by the " + seatData [pointerPositionY] [pointerPositionX] [1] + " family.";
                }
                c.drawString (temp, 230, 585);
                format = seatData [pointerPositionY] [pointerPositionX] [2] + "";

                if (format.length () - format.indexOf (".") == 2)
                {
                    format += "0";
                }
                c.drawString ("This seat's price was: $" + format, 680, 585);
            }
            else
            {
                String seatNumber = (char) (pointerPositionY + 65) + "";
                temp = (char) (pointerPositionY + 65) + "";
                if (pointerPositionX < 9)
                {
                    format = "0" + (pointerPositionX + 1);
                }
                else
                {
                    format = (pointerPositionX + 1) + "";
                }
                seatNumber += format;
                temp += format;
                format = ticketPrice (temp) + "";
                if (format.length () - format.indexOf (".") == 2)
                {
                    format += "0";
                }
                c.drawString ("Seat number " + seatNumber + " isn't owned by anyone. You can purchase a ticket for it for the price of $" + format + ".", 100, 585);
            }

            // here are lines of code that create a border around the box to show where the pointer is on the seating plan.
            c.drawRect (86 + pointerPositionX * 25, 140 + pointerPositionY * 20, 25, 20);

            // here is a line of code that gets the user's choice from the user, which comes from the console.
            menuMovement = c.getChar ();

            // here is an if statement block that checks to see what key the user presses and adds one or subtracts one to pointerPositionX or pointerPositionY accordingly. It also error traps if the user enters a key that isn't W, A, S, D, or ENTER.
            if ((menuMovement == 'w' || menuMovement == 'W') && pointerPositionY > 0)
            {
                pointerPositionY--;
            }
            else if ((menuMovement == 'w' || menuMovement == 'W') && pointerPositionY == 0)
            {
                pointerPositionY = ROWS - 1;
            }
            else if ((menuMovement == 's' || menuMovement == 'S') && pointerPositionY < ROWS - 1)
            {
                pointerPositionY++;
            }
            else if ((menuMovement == 's' || menuMovement == 'S') && pointerPositionY == ROWS - 1)
            {
                pointerPositionY = 0;
            }
            else if ((menuMovement == 'a' || menuMovement == 'A') && pointerPositionX > 0)
            {
                pointerPositionX--;
            }
            else if ((menuMovement == 'a' || menuMovement == 'A') && pointerPositionX == 0)
            {
                pointerPositionX = COLUMNS - 1;
            }
            else if ((menuMovement == 'd' || menuMovement == 'D') && pointerPositionX < COLUMNS - 1)
            {
                pointerPositionX++;
            }
            else if ((menuMovement == 'd' || menuMovement == 'D') && pointerPositionX == COLUMNS - 1)
            {
                pointerPositionX = 0;
            }
            else if (menuMovement != 'w' && menuMovement != 'W' && menuMovement != 's' && menuMovement != 'S' && menuMovement != 'a' && menuMovement != 'A' && menuMovement != 'd' && menuMovement != 'D' && menuMovement != 10 && menuMovement != 13)
            {
                new Message ("Please press either \"W\" to move up, \"S\" to move down, \"A\" to move left, \"D\" to move right, or \"ENTER\" to exit the seating plan!");
            }
        }
    }


    /*
    Local Variable Dictionary
    Type            Name                Expected Data
    Instance        input1              This variable will be an instance variable of the BufferedReader class, and it will be used to read the data in the given .txt file.
    String          temporary           This variable will be used as a temporary variable for a string value.
    String          creditCardNumber    This variable will be used to hold the value of the credit card number for that person.
    int             seatsOwned          This variable will be used to hold the integer value of the amount of seats owned by the person who's name is entered.
    int             totalSeatsLeft      This variable will be used to hold the integer variable of the amount of seats that are taken overall.
    String[]        names               This variable will be used to hold the name that is entered by the user before being converted into the actualCurrentNames array.
    double          totalPrice          This variable will be used to hold the total price that the person who's name was entered paid.
    boolean[][]     ownedSeats          This variable will be used to hold the boolean value true in each cell whose seat is bought by the user, or false if it isn't owned by the person whose name was entered.
    boolean         specialCharacters   This variable will be used to hold the boolean value of true if the string the program is checking contains special characters, or false if it doesn't.
    boolean         spaces              This variable will be used to hold the boolean value of true if the string the program is checking contains spaces, or false if it doesn't.
    boolean         done                This variable will be used to hold the boolean value of true if the loop it is in is done, or false if it isn't done.
    Instance        e                   This is an instance of the Exception class and it will be used to catch any errors in the try catch. Note: this variable is also used as an instance of the IOException class.
    int             i                   This variable will be used to hold the value of the current iteration of the for loop that it is used in.
    int             j                   This variable will be used to hold the value of the current iteration of the for loop that it is used in. This variable is mainly used in nested for loops.


    This method is used to create the method that will take in the name of the person the user wants to see tickets for, and the program returns the amount of tickets owned.
    This program calls on the title() method to clear the screen and then create the title of the program. Also, the drawString() method will be used to tell the user that they are in the "Search By Name" part of the program.
    Then, the font is set to "Arial", plain, size 18 using setFont(). Then, the user is prompted, using drawString() to enter their first and last name. After that, there is error trapping for the name:

    while (!done)                                                                                               This while loop will run as long as the done variable is false
        try                                                                                                     This try catch is used to catch any errors thrown while taking in the input.
            if (spaces && temporary.charAt (0) != 32 && temporary.charAt (temporary.length () - 1) != 32)       This if statement is used to see if what the user entered contains spaces and if it doesn't have a space at the start or then end. If this is true, then the entered value from the user is then splitted by the spaces and the values are stored in the names[] array.
                if (names.length == 2)                                                                          This if statement is used to see if the amount of names entered is 2. This is figured out by taking the input, splitting it by spaces using the split() command, and then storing that into the names array.
                        if (!specialCharacters && names [i].length () > 1)                                      This if statement is used to see if there are no special characters in what the user inputted and that the first name and last name have more than one letter in them.
                        else if (!specialCharacters && names [i].length () <= 1)                                This else if statement is used to see if there are no special characters but the user entered a name with a single letter.
                        else                                                                                    This else statement is used to run after all the other options, which is if there are special characters.
                else                                                                                            This else statement is used to run if there amount of names entered is not equal to 2.
            else if (!spaces)                                                                                   This else if statement is used to run if the entered name don't contain any spaces.
            else if (temporary.charAt (0) == 32)                                                                This else if statement is used to run if the first character of the name is a space.
            else if (temporary.charAt (temporary.length () - 1) == 32)                                          This else if statement is used to run if the last character of the name is a space.
        catch (Exception e)                                                                                     This catch is used to catch any errors thrown while the while loop is running.


    These statements are used to see if the entered name is valid, and if it isn't, then there is a specialized error message for each problem.
    After that, there is a try catch that creates an instance of the BufferedReader class, called input1.
    After that, inside of the try catch, there is a while loop that runs while there are lines to be read in the program.
    For every iteration, the variable totalSeatsLeft goes down by one.
    There is an if statement inside of the while loop that checks to see if the name of the current line is the name of the last name of the entered name.
    If the names matches, then the program stores that seat's credit card number in the creditCardNumber variable, the price of that seat (it takes the price and adds it to the totalPrice variable), and sets ownedSeat's cell whose location is the one in the line to true.
    Next, the total price is formatted, so if the number only goes up to the tenth place, then the program adds a zero onto the end of the total price.
    After that, the title() method is called to clear the screen and create the title. drawString() is used to tell the user that they are in the "Search By Name" parto of the program.
    Then, there is an if block:

    if (seatsOwned != 0)
    else

    and this if block is used to see if the user owns any seats. If the user owns any seats, then the first part of the if block is urn.
    In this block, it checks to see if the amount of seats owned is 1 or more than 1, and depending on whichever it is, it sets the temporary String variable to either "This person owns 1 seat." or "This person owns (seatsOwned) seats.".
    After that, the font is set to "Arial", bold, size 18 using setFont() and then drawString() is used to tell the user what the amount of owned seats are.
    Next, the font is set to "Arial", bold, size 15, and then the user is also told what the total price they paid was.
    Then, the font is set to "Arial", bold, size 18. Using a for loop that starts at 0 and ends right before 12 (it increments up by 1), asterisks are added to the temporary variable (which was set to a blank String to clear it).
    After 12 asterisks are added to the temporary variable, then the last 4 digits of the credit card number are added onto the end of temporary, and that value is put inside of creditCardNumber. A drawString() is sued to display it to the user.
    Then, the font is set to "Arial", bold, size 16, and then, using for loops, a grid is drawn and its axises are labelled. Lastly, there is a for loop and a nested for loop that is used to read through the ownedSeats 2D array and if the seat isn't taken, then a white rectangle is drawn in that cell (using fillRect()), and this helps tell the user what seats they own.


    If the amount of seats owned is 0, then the program tells the user that they should buy some seat tickets.
    First, the color is set to the accent color using setColor() and accentColor. Also, a rectangle is drawn using fillRect() that creates a box to the text.
    After that, the color is set to white using setColor() and Color.WHITE. Plus, the font is set to "Arial", plain, size 20.
    drawString() is used to tell the user that they don't own any seats.
    The font is then set to "Arial", plain, size 15, and drawString() is used to prompt the user that they should buy some tickets because this is a very important event and they don't want to miss it. They are also pressured to do so because the program tells them how many seats are left.
    Lastly, the pause() method is called to tell the user to press a key to move on with the program.

    */


    public void searchByName ()
    {
        // here are the local variables that will be used in this method
        //String fileName = "TheatreSeatingPlan.txt";
        BufferedReader input1;
        // String temp; is used to help read the lines at the start of the program to figure out how many lines there are. It also tells the program which seats are taken and which aren't. Lastly, it is used to help create the labels for the x- and y-axises for the grid.
        String temporary = "";
        String creditCardNumber = "";
        int seatsOwned = 0;
        int totalSeatsLeft = ROWS * COLUMNS;
        String[] names;
        double totalPrice = 0;
        boolean[] [] ownedSeats = new boolean [ROWS] [COLUMNS];
        boolean specialCharacters = false;
        boolean spaces = false;
        boolean done = false;
        // int i is used as a counting variable in the for loop and it holds the value of the current iteration of the for loop.
        // int j is used as a counting variable in the nested for loop and it holds the value of the current iteration of the nested for loop.

        // here is a line of code that calls on the title() method
        title ();

        // here adds a piece to the title that makes it more specific
        c.drawString ("Search By Name", 270, 50);

        // here is a line of code that sets the font to Arial, plain, and size 18.
        c.setFont (new Font ("Arial", 0, 17));
        c.setColor (Color.black);
        // here is a line of code that asks the user to enter their first and last name.
        c.drawString ("Can you please enter your first and last name?", 20, 137);

        // here are lines of code that help with the error trapping after the user enters their first and last name
        done = false;
        while (!done)
        {
            try
            {
                c.setCursor (7, 48);
                c.print (' ', 50);
                c.println ();
                c.setCursor (7, 48);
                specialCharacters = false;
                done = false;

                borderMaker ();

                temporary = c.readLine ();

                borderMaker ();
                for (int i = 0 ; i < temporary.length () ; i++)
                {
                    if (temporary.charAt (i) == 32)
                    {
                        spaces = true;
                        break;
                    }
                }

                if (spaces && temporary.charAt (0) != 32 && temporary.charAt (temporary.length () - 1) != 32) // --------------this line gives an error--------------this line gives an error--------------this line gives an error--------------this line gives an error--------------this line gives an error--------------this line gives an error--------------this line gives an error--------------this line gives an error--------------this line gives an error--------------this line gives an error--------------this line gives an error--------------this line gives an error--------------this line gives an error
                {
                    names = temporary.split (" ");
                    if (names.length == 2)
                    {
                        for (int i = 0 ; i < names.length ; i++)
                        {
                            for (int j = 0 ; j < names [i].length () ; j++)
                            {
                                if (!specialCharacters && ((names [i].charAt (j) >= 0 && names [i].charAt (j) <= 64) || (names [i].charAt (j) >= 91 && names [i].charAt (j) <= 96) || (names [i].charAt (j) >= 123 && names [i].charAt (j) <= 127)))
                                {
                                    specialCharacters = true;
                                }
                            }
                            if (!specialCharacters && names [i].length () > 1)
                            {
                                // here are lines of code that take in the name and converts the first letter to uppercase and the other letters to lowercase
                                names [i] = names [i].substring (0, 1).toUpperCase () + names [i].substring (1).toLowerCase ();
                                actualCurrentNames [i] = names [i];
                                done = true;
                            }
                            else if (!specialCharacters && names [i].length () <= 1)
                            {
                                new Message ("Please enter your first and last name and ensure that they are more than one letter in length because who has a name that is one letter?!?!");
                                done = false;
                                break;
                            }
                            else
                            {
                                new Message ("Please enter your first and last name and ensure that there are no special characters inside of it!");
                                done = false;
                                break;
                            }
                        }
                    }
                    else
                    {
                        new Message ("Please enter only your first and last name into the program! This means there must be 1 space!");
                    }
                }
                else if (!spaces) // spaces && temporary.charAt (0) != 32 && temporary.charAt (temporary.length () - 1) != 32
                {
                    new Message ("Please enter only your first and last name into the program! This means there must be 1 space!");
                }
                else if (temporary.charAt (0) == 32)
                {
                    new Message ("Please enter only your first and last name into the program! Make sure there are no spaces at the start!");
                }
                else if (temporary.charAt (temporary.length () - 1) == 32)
                {
                    new Message ("Please enter only your first and last name into the program! Make sure there are no spaces at the end!");
                }
            }
            catch (Exception e)  // catches any error thrown by the try command
            {
                new Message ("Please enter your first and last name into the program!");
            }
        }



        // here is a try catch for reading to a file. It takes in the values from the file and also checks to see which seats are owned by the user.
        try
        {
            input1 = new BufferedReader (new FileReader (fileName));

            // this while loop checks to see how many lines there are in the file, and it stops at the end, when the line is blank
            while ((temporary = input1.readLine ()) != null)
            {
                totalSeatsLeft--;
                if (actualCurrentNames [1].equals (temporary.split (",") [1]))
                {
                    ownedSeats [temporary.charAt (0) - 65] [Integer.parseInt (temporary.substring (1, 3)) - 1] = true;
                    totalPrice += Double.parseDouble (temporary.split (",") [2]);
                    creditCardNumber = temporary.split (",") [3];
                    creditCardNumber = creditCardNumber.substring (0, 4) + creditCardNumber.substring (5, 9) + creditCardNumber.substring (10, 14) + creditCardNumber.substring (15);
                    seatsOwned++;
                }
            }
        }


        catch (IOException e)
        {
        }

        // here is a line of code that calls on the title() method again to clear the screen
        title ();

        // here adds a piece to the title that makes it more specific
        c.drawString ("Search By Name", 270, 50);

        // here is an if statement that checks to see if the user owns any seats. If they do, then a grid is shown. Or else, the user is told to buy tickets (because we need some nice money)
        if (seatsOwned != 0)
        {
            // here is a line of code that tells the user how many seats they own. It also tells them the total price that they paid. It also tells them their credit card info.
            if (seatsOwned == 1)
            {
                temporary = "The " + actualCurrentNames [1] + " family owns " + seatsOwned + " seat.";
            }
            else
            {
                temporary = "The " + actualCurrentNames [1] + " family owns " + seatsOwned + " seats.";
            }
            c.setFont (new Font ("Arial", 1, 17));
            c.setColor (Color.black);
            c.drawString (temporary, 100, 530);

            // here are the lines of code that take the price and format it.
            temporary = totalPrice + "";
            if (temporary.length () - temporary.indexOf (".") == 2)
            {
                temporary += "0";
            }

            c.drawString ("The total cost paid was $" + temporary + ".", 400, 530);

            // here sets the font type to "Arial", the font to bold, and the font size to 16.
            c.setFont (new Font ("Arial", 1, 16));
            c.setColor (Color.white);
            // here are lines of code that help create the horizontal lines for the grid, along with the letters as labels the rows.
            for (int i = -1 ; i <= ROWS ; i++)
            {
                if (i >= 0 && i < ROWS)
                {
                    temporary = ((char) (i + 65)) + "";
                    c.drawString (temporary, 68, 115 + i * 20);
                }
                c.drawLine (63, 100 + i * 20, 838, 100 + i * 20);
            }

            // here are lines of code that help create the vertical lines for the grid, along with the numbers as labels for the columns.
            for (int i = -1 ; i <= COLUMNS ; i++)
            {
                if (i >= 0 && i < COLUMNS)
                {
                    if (i >= 0 && i < 9)
                    {
                        temporary = "0" + (i + 1) + "";
                    }
                    else
                    {
                        temporary = (i + 1) + "";
                    }
                    c.drawString (temporary, 90 + i * 25, 95);
                }
                c.drawLine (86 + i * 25, 80, 86 + i * 25, 500);
            }

            // here are lines of code that cover the cells of the grid that are false (which means that seat's ticket wasn't bought yet) with a white box.
            for (int i = 0 ; i < ROWS ; i++)
            {
                for (int j = 0 ; j < COLUMNS ; j++)
                {
                    if (!ownedSeats [i] [j])
                    {
                        c.fillRect (88 + j * 25, 102 + i * 20, 22, 17);
                    }
                }
            }
        }


        else
        {
            // here are the lines of code that create a box that the display information will be put inside. It will be the color of the accentColor variable, and the box will have 20 pixels of space around it.
            c.setColor (accentColor);
            c.fillRect (70, 120, 760, 170);

            c.setColor (Color.black);
            c.drawRect (70, 120, 760, 170);

            // here are the lines of code that actually display the output to the user.
            c.setColor (Color.WHITE);
            c.setFont (new Font ("Arial", 0, 20));

            // here are the lines of code that actually tell the user what to do since they have no tickets
            c.drawString ("Wow, you seem to own no tickets, huh? What a shame...", 80, 150);
            // here is a line of code that sets the font to "Arial", plain, and font size 15
            c.drawString ("You know what, why don't you buy some tickets for the WLMAC Cinema by going", 80, 175);
            c.drawString ("back to the menu and following the prompts?", 80, 200);
            c.drawString ("Trust us, you do NOT want to miss this event, which is why you should hurry up", 80, 235);
            c.drawString ("because there are only " + totalSeatsLeft + " seats left!", 80, 260);

            try
            {
                BufferedImage someImage = ImageIO.read (new File ("clock.png"));
                c.drawImage (someImage, 275, 250, null);
            }
            catch (IOException e)
            {
            }
        }
        pause ();
    }


    /*
        Local Variable Dictionary
        Type        Name            Expected Data
        Instance    e               This is an instance of the IOException class and it will be used to catch any errors in the try catch.

        This method is used to create the goodbye screen for the program.
        This method first calls on the title() method to clear the console and also create the title. Also, the drawString() method is used to make the title more specific, by telling the user that they are in the goodbye part of the program.
        After that, the color is set to the accent color using setColor() and accentColor. From there, fillRect() is used to create a rectangle where the words on the screen will be printed.
        After that, the color is set to black using setColor() and Color.black. Then, drawRect() is used to create the border aroung the rectangle created before.
        Next, the color is set to white using setColor() and Color.white. Also, the font is set to "Arial", plain, size 20 using setFont(). Then, through drawString() methods, the user is told where to look for upcoming events.
        Then, a try catch is used to hold the declaration and initialization of the instance variable someImage which is an instance of the BufferedImage class. This instance reads the wlmacCrestLarge.png and then uses the drawImage() method to display the image to the screen.
        After that, the pause() method is called to tell the user that they have to press a key to move on, and lastly, the close() method is called to close the program.
    */

    public void goodbye ()
    {
        title ();
        c.drawString ("Goodbye", 270, 50);

        c.setColor (accentColor);   //Sets the colour to dark blue
        c.fillRect (150, 100, 600, 80);  //Makes a rectangle on which the text will go
        c.fillRect (830, 12, 70, 58);

        c.setColor (Color.black);
        c.drawRect (150, 100, 600, 80);

        c.setColor (Color.white);
        c.setFont (new Font ("Arial", 0, 20));  //Makes the fonr Arial size 18
        c.drawString ("Thank you for visiting the WLMAC Cinema webpage. To see dates", 155, 130);
        c.drawString ("for upcoming events, please visit our website - wlmac.ca.", 155, 160);

        try
        {
            BufferedImage someImage = ImageIO.read (new File ("wlmacCrestLarge.png"));
            c.drawImage (someImage, 250, 200, null);
        }


        catch (IOException e)
        {
        }


        pause ();
        c.close ();
    }


    /*
        Local Variable Dictionary
        Type        Name            Expected Data
        int         i               This is a counter variable used to go down the list of letters from A to T

        This method displays a small pricing chart to the user in askData() so the user can see how much each seat costs.
        We have a for loop that increments until the counter reaches 20 because there are 20 rows. Depending on the row, the
        program will print the appropriate letter corresponding to the row by doing (char) (i + 65). Then we also
        call on the ticketPrice() method to find the price for each row. Then we display the right price next to it's row letter
        all on top of a dark blue box.
    */

        private void cost ()
    {
        c.setColor (accentColor);
        c.fillRect (750, 90, 130, 460);

        c.setColor (Color.black);
        c.drawRect (750, 90, 130, 460);

        c.setColor (Color.white);
        c.drawString ("  ROW   Price", 752, 110);

        for (int i = 0 ; i < ROWS ; i++)
        {
            if ((char) (i + 65) == 'I')
            {
                String format = ticketPrice (((char) (i + 65)) + "01") + "";
                if (format.length () - format.indexOf (".") == 2)
                {
                    format += "0";
                }

                c.drawString (((char) (i + 65)) + "        $" + format, 763, 150 + i * 20);
            }
            else
            {
                String format = ticketPrice (((char) (i + 65)) + "01") + "";
                if (format.length () - format.indexOf (".") == 2)
                {
                    format += "0";
                }

                c.drawString (((char) (i + 65)) + "       $" + format, 763, 150 + i * 20);
            }
        }
    }


    private void pause ()
    {
        c.setColor (accentColor);
        c.fillRect (100, 550, 700, 40);

        c.setColor (Color.black);
        c.drawRect (100, 550, 700, 40);

        c.setColor (Color.white);
        c.setFont (new Font ("Arial", 2, 20));
        c.drawString ("Press any key to continue", 320, 580);
        c.getChar ();
    }


    /*
        Local Variable Dictionary
        Type        Name            Expected Data
        String      seatLocation    This String variable will be used to hold the value of the entered location of the seat.
        double      price           This double variab;e will be used to hold the value of the price of the ticket for that seat. Note: This price is the value that will be returned from this method.
        int         i               This variable will be used to hold the value of the current iteration of the for loop that it is used in.

        This method will be used to tell the program what the price of the entered seat is. As long as the correct seat location is entered, then the program works perfectly.
        This program works by first setting the double variable price to 25.0. Then it runs a for loop that starts at zero and ends right before the integer value of the row (which is the first letter of the location) - 65 (it increments up by 1).
        For every iteration run, the price loses 0.75 each time.
        After the for loop is done running, the price is returned.
    */

    private double ticketPrice (String seatLocation)
    {
        double price = 25.0;
        for (int i = 0 ; i < (int) seatLocation.charAt (0) - 65 ; i++)
        {
            price -= 0.75;
        }


        return price;
    }


    /*
        Local Variable Dictionary
        Type        Name            Expected Data
        Instance    console         This variable will hold the Console variable that will be used to display the line to the console.
        int         xCoordinate1    This integer variable will hold the value of the x position of the first point of the line - its starting point
        int         yCoordinate1    This integer variable will hold the value of the y position of the first point of the line - its starting point
        int         xCoordinate2    This integer variable will hold the value of the x position of the second point of the line - its ending point
        int         yCoordinate2    This integer variable will hold the value of the y position of the second point of the line - its ending point
        int         thickness       This integer variable will hold the thickness of the line (in pixels)
        boolean     vertical        This boolean variable will hold the value of whichever way the line will go. This variable will be "true" if the line is vertical, or "false" if the line is horizontal.
        int         i               This variable will be used to hold the value of the current iteration of the for loop that it is used in.


        This method will be used to create thick lines wherever it is called. As long as the parameters are passed into this method, then this method creates the specified lines.
        This program works by checking to see if the user wants a vertical line or not. After that, a for loop is used that starts at 0 and ends right before the thickness wanted (it increments up by 1). Here is that if block:

        if (vertical)
        else

        After that, using the drawLine() method, lines are drawn one after the other to create the thick lines.
    */
    private void thickLine (Console console, int xCoordinate1, int yCoordinate1, int xCoordinate2, int yCoordinate2, int thickness, boolean vertical)
    {
        if (vertical)
        {
            for (int i = 0 ; i < thickness ; i++)
            {
                console.drawLine (xCoordinate1 + i, yCoordinate1, xCoordinate2 + i, yCoordinate2);
            }
        }


        else
        {
            for (int i = 0 ; i < thickness ; i++)
            {
                console.drawLine (xCoordinate1, yCoordinate1 + i, xCoordinate2, yCoordinate2 + i);
            }
        }
    }


    /*
        Local Variable Dictionary
        This method doesn't have any local variables.

        This is the class constructor of the Theatre class.
        This method will be used to initialize the instance variable c to a new Console.
    */

    public Theatre ()
    {
        c = new Console (30, 113, "This is the Theatre Ticket Program");
    }


    /*
        Local Variable Dictionary
        Type        Name            Expected Data
        Instance    theatre         This is an instance of the Theatre class and it will be used to call on other methods inside of the main method so that the program can run perfectly.

        This is the main method of the program. It is used to call on the other methods and allow the program to function properly.
        First, an instance of the Theatre class called theatre is declared and initialized.
        After that, the splashScreen() method is called on using the instance variable theatre. This is so that the splash screen can run properly.
        Then, there is a while loop with a conditional statement of (theatre.userChoice != 5). This makes the loop run as long as the user doesn't want to exit the program (which is choice #5 in the menu). There are also if statements inside of main(). Overall, the code looks like this:

        while (theatre.userChoice != 5)
            if (theatre.userChoice == 1)
                if (theatre.moveOn)
            else if (theatre.userChoice == 2)
            else if (theatre.userChoice == 3)
            else if (theatre.userChoice == 4)

        Inside of the while loop, the program calls on the intro() method to run, which allows the user to choose where they want to go in the program (like buy the ticket or seeing the seating plan).
        After that, there is an if block that calls on the respective methods that the user chooses to run inside of the program. For example, if the userChoice variable is 2, then the program calls on the instructions() method so that the user can see the instructions.
        Note: there is an if statement inside of the first if statement in the if block that checks to see if the program wants to move on or not. This is because there are certain times when the program does not want to move on and call display() after askData(). Case in point, if the user doesn't want to confirm their purchase of the seat tickets, then inside of askData(), sets moveOn = false and does return; , which makes the program instantly leave askData() and skip display().
        If the user decides to leave the program, then the conditional statement of the while loop will be false. This makes the program leave the while loop, which will then allow the program to call on the goodbye() method, which closes the program.
    */

    public static void main (String[] args)
    {
        Theatre theatre = new Theatre ();
        theatre.splashScreen ();
        while (theatre.userChoice != 5)
        {
            theatre.intro ();
            if (theatre.userChoice == 1)
            {
                theatre.askData ();
                if (theatre.moveOn)
                {
                    theatre.display ();
                }
            }
            else if (theatre.userChoice == 2)
            {
                theatre.instructions ();
            }
            else if (theatre.userChoice == 3)
            {
                theatre.seatingPlan ();
            }
            else if (theatre.userChoice == 4)
            {
                theatre.searchByName ();
            }
        }
        theatre.goodbye ();

    } // main method
} // Theatre class


// So, uh, do you think we can get a solid 100% on this? We spent a lot of time on it, and it would be very nice to get great marks on it :)