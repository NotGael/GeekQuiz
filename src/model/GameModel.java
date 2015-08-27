package model;

public class GameModel {
	
	// String Table - each row contain : the questions, the different answers linked to this question and the number of the correct answer
	private static String tableQuestion[][] = {
			{"What science fiction writer introduced the three laws of robotics in the popular culture?", "Isaac Newton", "Isaac Asimov", "Copernic", "Albert Einstein", "2"},
			{"What is the name of the producer of the first science fiction film A Trip to the Moon?", "Georges Méliès", "Woody Allen", "Alfred Hitchcock", "Steven Speilberg", "1"},
			{"Who is the author of the book used by  Steven Spielberg to adapt Minority report?", "Jules Verne", "William Gibson", "Philip K. dick", "Douglas Adams", "3"},
			{"What's the value of the Avogadro’s number?", "6.02 * 10^23", "6.02 * 10^27", "3.27 * 10^23", "3.27 * 10^24", "1"},
			{"What's the real name of Dark Vador?", "Luc Skywalker", "Yoda", "Qui-Gon Jinn", "Anakin Skywalker", "4"},
			{"What's the 4th decimal of PI?", "2", "1", "5", "4", "3"},
			{"In the first version of Pokemon what’s the Pikachu Pokemon number?", "1", "8", "25", "42", "3"},
			{"What's the year of commercialisation of Windows NT?", "1991", "1992", "1993", "1994", "3"},
			{"What's the answer to life the universe and everything?", "Nobody knows", "42", "Is that a question", "There is no answer", "2"},
			{" What's the year of commercialisation of Mac OS X 10.0?", "1999", "2000", "2001", "2002", "3"},
			{"What's the year of commercialisation of the Apple II?", "1969", "1977", "1984", "1985", "2"},
			{"What’s the real name of Voldemort?", "Tom Marvolo Riddle", "Harry Potter", "James Potter", "Dumbledore", "1"},
			{"What’s the name of the Half-Blood Prince in Harry Potter?", "Harry Potter", "Dark Vador", "Dumbledore", "Severus Snape", "4"},
			{"Doppler effect is about?", "Pressure", "Wave", "Temperature", "Colour", "2"},
			{"What’s the value of the golden ratio?", "1,6180339887", "12.237332", "1.45678002", "0.31242323", "1"},
			{"What’s the frequency of the musical note of reference E?", "220Hz", "330Hz", "440Hz", "550Hz", "3"},
			{"What’s the number of nucleon for an atom?", "The sum of the neutron and the proton", "a synonym", "an opposite", "a mysterious and undiscovered particle", "1"},
			{"What’s the electricity?", "A power", "An electron displacement", "A heat displacement", "An unexpliqued phenomenon", "2"},
			{"What’s the most important discovery of Einstein?", "The law of relativity", "The Gravity", "The number PI", "The Earth moves around the sun", "1"},
			{"What disease suffers the actor who play Marty McFly in Back to the Future?", "AIDS", "Tuberculosis", "Parkinson", "Cancer", "3"}
		};

	public static String getTableQuestion(int x,int y) {
		return tableQuestion[x][y];
	}
}
