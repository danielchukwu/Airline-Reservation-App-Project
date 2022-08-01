import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class Main {
//    Requirements for Project:
//    Data Structures = [Array, ArrayList]
//    Swing UI
//    write data to disk
//    Exception Handling
//    Unique

    // 1ST PAGE
    public static void airlineHomeGUI(String groupName, String[] airways) {
        System.out.println("1st Page displayed.....");

        // frame for 1st page
        JFrame f = new JFrame(groupName);
        f.setLayout(new GridLayout(2, 1));
        f.setSize(600, 300);

        JLabel welcomeLabel = new JLabel("Welcome");                           // welcome label
        JButton reserveAirlineNowButton = new JButton("Reserve Airline Now");  // reserveAirlineNow button

        f.add(welcomeLabel);                                                        // add label
        f.add(reserveAirlineNowButton);                                             // add reserveAirlineNowButton

        // make frame visible
        f.setVisible(true);

        reserveAirlineNowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);                     // make frame invincible
                displayAirlinesGUI(airways);             // call function that holds next page
            }
        });
    }

    // 2ND PAGE
    static void displayAirlinesGUI (String [] airways) {
        System.out.println("2nd page displayed.....");

        // frame for 2nd page
        JFrame f = new JFrame("Make Reservation");
        f.setLayout(new GridLayout(4, 3));
        f.setSize(600, 900);

        for (int i = 0; i < airways.length; i++) {
            String airlineName = airways[i];                 // get airlines name from airways array (on each iteration)
            JButton button = new JButton(airlineName);       // create button for each airway name (on each iteration)
            f.add(button);                                   // add button

            button.addActionListener(new ActionListener() {  // if any button is clicked. go to 3rd page
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.setVisible(false);                     // make frame invisible
                    reservationMade(airlineName);            // call function that holds next page
                }
            });
        }

        // make frame visible
        f.setVisible(true);
    }

    // 3RD PAGE
    static void reservationMade (String airlineName) {
        System.out.println("3rd page displayed.....");

        // frame for 3rd page
        JFrame f = new JFrame("Reservation Made");
        f.setLayout(new GridLayout(1, 1));
        f.setSize(600, 300);

        String airlineNameInUpperCase = airlineName.toUpperCase();                          // change arlineName into Uppercase
        JButton done = new JButton("RESERVATION MADE FOR " + airlineNameInUpperCase);  // Create button with airline name
        f.add(done);

        // write to file
        try {
            FileWriter file = new FileWriter("new file.txt");                       // create file
            file.write("YOU MADE A RESERVATION WITH: " + airlineNameInUpperCase);       // write to file
            file.close();                                                                   // close file
        } catch (Exception e) {
            System.out.println(e);
        }

        // make frame visible
        f.setVisible(true);
    }

    public static void main(String [] args){
        // CITEX GROUP: Building an Airline Reservation App
        String[] airways = {"Aero", "Air Peace", "Allied Air", "Arik Air", "Azman Air", "Dana Air", "Dornier Aviation Nigeria", "Green Africa", "Kabo Air", "Matrix Air", "Nigerian Overland Airways", "TAT Nigeria"};

        String groupName = "CITEX GROUP";
        airlineHomeGUI(groupName, airways);
    }

}
