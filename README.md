# JetsProject

# Description
This project creates a variety of types of "Jet" objects that implement different characteristics and behaviors using abstract classes and interfaces. The jets all fly out of an airfield, an object that contains and controls the jets.

# Technologies Used
Java, git

# Challenges
- figuring out which code should go in app file and which should be contained in airfield
- avoiding repeated code
- originally had jet generating code in the app file. Changed it to the airfield as it seemed more appropriate since the airfield handles all the different jets and the app required a bunch of imports and the app shouldn't really see that anyway. But this negated returning a list as I passed the data to the airfield to construct each jet and add to its fleet.

# Lessons Learned
- for the longest time fleet initialization was creating two instances of each of the passenger jets. One of these instances was a fighter! Took a while but I finally figured out that my switch statement that handles jet instantiation was dropping through from PASSENGER and then creating a FIGHTER version of each jet because there was no BREAK statement.
- using multiple interfaces allows some jets to change their purpose. So the cargo jets can be configured for research or cargo, just like they might in real life as the use of the plane changes throughout its life. Fighters and attack aircraft on the other hand are unlikely to change their use much.

# To Do
- didn't do any stretch goals. I would like to try these this week if I have time.
- need more error checking on user input when they are adding/subtracting a jet
