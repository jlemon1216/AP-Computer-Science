/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 *     	Uses advanced search for keywords
 *</li><li>
 *     	Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
 *
 */
public class Magpie4
{
	public String likes = "";
	public String dislikes = "";
	public String favorites = "";
	public String favoriteSubject = "";
	public String favoriteTvShow = "";
	public String favoriteColor = "";
	public String favoriteMovie = "";
	public String favoriteSportsTeam = "";
	/**
 	* Get a default greeting	 
 	* @return a greeting
 	*/    
	public String getGreeting()
	{
    	return "Hello, let's talk.";
	}
	public void getLikes() {
    	int commaCounter = 0;
    	for(int i = 0; i < likes.length(); i++) {
        	if(likes.charAt(i) == ',') {
            	commaCounter++;
            	System.out.print("\n" + commaCounter);
        	} else {
            	System.out.print(likes.charAt(i));
        	}    
        	}
        	}
	public void getDislikes() {
    	int commaCounter = 0;
    	for(int i = 0; i < dislikes.length(); i++) {
        	if(dislikes.charAt(i) == ',') {
            	commaCounter++;
            	System.out.print("\n" + commaCounter);
        	} else {
            	System.out.print(dislikes.charAt(i));
        	}
    	}
	}
	public String transformFavoriteSubjectStatement(String statement) {
  	  statement = statement.trim();
    	String lastChar = statement.substring(statement
            	.length() - 1);
    	if (lastChar.equals("."))
    	{
        	statement = statement.substring(0, statement
                	.length() - 1);
    	}

    	int psnOfYou = findKeyword (statement, "My favorite subject is", 0);
   	 

    	String restOfStatement = statement.substring(psnOfYou + 22, statement.length()-1).trim();
    	if(findKeyword(likes, restOfStatement, 0) >= 0) {
  		  return "I already know you like " + restOfStatement + "!";
    	} else {
  		  likes = likes.concat(restOfStatement);
  		  System.out.println("Hi");
  		  return "I didn't know you like " + restOfStatement + "!";
    	}
  	 
   }
    

	/**
 	* Gives a response to a user statement
 	*
 	* @param statement
 	*        	the user statement
 	* @return a response based on the rules given
 	*/
	public String getResponse(String statement)
	{    
    	String response = "";
    	String likelist = "";    
    
    	if (statement.length() == 0)
    	{
        	response = "Say something, please.";
    	}

    	else if (findKeyword(statement, "no") >= 0)
    	{
        	response = "Why so negative?";
    	}
    	else if (findKeyword(statement, "mother") >= 0
            	|| findKeyword(statement, "father") >= 0
            	|| findKeyword(statement, "sister") >= 0
            	|| findKeyword(statement, "brother") >= 0)
    	{
        	response = "Tell me more about your family.";
    	}

    	// Responses which require transformations
    	else if (findKeyword(statement, "I want to", 0) >= 0)
    	{
        	response = transformIWantToStatement(statement);
    	}
    	else if (findKeyword(statement, "I want", 0) >= 0) {
        	response = transformIWantStatement(statement);
    	}else if(findKeyword(statement, "What do I like", 0) >= 0) {
        	getLikes();
    	} else if(findKeyword(statement, "What don't I like", 0) >= 0) {
        	getDislikes();
    	}
    	else if (findKeyword(statement, "I like", 0) >= 0) {
       	 
        	System.out.println("thats cool I guess");
        	likes = likes.concat(", " + statement.substring(7, statement.length()));
       	 
       	 
    	} else if (findKeyword(statement, "I don't like", 0) >= 0) {
        	System.out.println("cool");
        	dislikes = dislikes.concat(", " + statement.substring(13, statement.length()));
    	}   else if(findKeyword(statement, "What is my favorite", 0) >= 0) {
   		 if(findKeyword(statement, "subject", 0) >= 0) {
   			 response = "Your favorite subject is" + favoriteSubject;
   		 } else if(findKeyword(statement, "TV show", 0) >= 0) {
   			 response = "Your favorite TV show is" + favoriteTvShow;
   		 } else if(findKeyword(statement, "Color", 0) >= 0) {
   			 response = "Your favorite Color is" + favoriteColor;
   		 } else if(findKeyword(statement, "Team", 0) >= 0) {
   			 response = "Your favorite team is" + favoriteSportsTeam;
   		 } else if(findKeyword(statement, "Movie", 0) >= 0) {
   			 response = "Your favorite Movie is" + favoriteMovie;
   		 }
    	}
    	else if (findKeyword(statement, "My favorite", 0) >= 0) {
   		 if(findKeyword(statement, "subject is", 11) >= 0) {
   			 favoriteSubject = statement.substring(23,(statement.length()));
   		 } else if(findKeyword(statement, "TV show is", 11) >= 0) {
   			 favoriteTvShow = statement.substring(22, (statement.length()));
   		 } else if(findKeyword(statement, "Movie is", 11) >= 0) {
   			 favoriteMovie = statement.substring(20, (statement.length()));
   		 } else if(findKeyword(statement, "Color is", 11) >= 0) {
   			 favoriteColor = statement.substring(20, (statement.length()));
   		 } else if(findKeyword(statement, "Team is", 11) >= 0) {
   			 favoriteSportsTeam = statement.substring(19, (statement.length()));
   		 }
   		 response = "Thats neat";
    	}
   	 
    	else if (findKeyword(statement, "Television", 0) >= 0 || findKeyword(statement, "TV", 0) >= 0) {
   		 response = "My favorite show is Family Guy. What's your favorite TV show?";
   		 
    	}
    	else if (findKeyword(statement, "Color", 0) >= 0) {
   		 response = "My favorite color is green. What's your favorite color?";
    	}
    	else if(findKeyword(statement, "movie", 0) >= 0) {
   		 response = "My favorite movie is Elf. What's your favorite movie?";
    	}
    	else if(findKeyword(statement, "Sports Team", 0) >= 0) {
   		 response = "My favorite sports team is the Yankees. What's your favorite sports team?";
    	}
    	else if(findKeyword(statement, "subject", 0) >= 0) {
   		 response = "My favorite subject is Computer Science. What's your favorite school subject?";
    	}
   	 
    	else
    	{
        	// Look for a two word (you <something> me)
        	// pattern
        	int psn = findKeyword(statement, "you", 0);
        	int psn2 = findKeyword(statement, "I", 0);

        	if (psn >= 0 && findKeyword(statement, "me", psn) >= 0)
        	{
            	response = transformYouMeStatement(statement);
        	}
        	else if(psn >= 0 && findKeyword(statement, "you", psn) >= 0) {
            	response = transformIYouStatement(statement);
        	}
        	else
        	{
            	response = getRandomResponse();
        	}
    	}
    	return response;
	}

	/**
 	* Take a statement with "I want to <something>." and transform it into
 	* "What would it mean to <something>?"
 	* @param statement the user statement, assumed to contain "I want to"
 	* @return the transformed statement
 	*/
	private String transformIWantToStatement(String statement)
	{
    	//  Remove the final period, if there is one
    	statement = statement.trim();
    	String lastChar = statement.substring(statement
            	.length() - 1);
    	if (lastChar.equals("."))
    	{
        	statement = statement.substring(0, statement
                	.length() - 1);
    	}
    	int psn = findKeyword (statement, "I want to", 0);
    	String restOfStatement = statement.substring(psn + 9).trim();
    	return "What would it mean to " + restOfStatement + "?";
	}
	private String transformIWantStatement(String statement) {
    	statement = statement.trim();
    	String lastChar = statement.substring(statement.length() -1);
    	if(lastChar.equals(".")) {
        	statement = statement.substring(0, statement.length() -1);
    	}
    	int psn = findKeyword(statement, "I want", 0);
    	String restOfStatement = statement.substring(psn + 6).trim();
    	return "Would you really be happy if you had " + restOfStatement + "?";
	}



	/**
 	* Take a statement with "you <something> me" and transform it into
 	* "What makes you think that I <something> you?"
 	* @param statement the user statement, assumed to contain "you" followed by "me"
 	* @return the transformed statement
 	*/
	private String transformYouMeStatement(String statement)
	{
    	//  Remove the final period, if there is one
    	statement = statement.trim();
    	String lastChar = statement.substring(statement
            	.length() - 1);
    	if (lastChar.equals("."))
    	{
        	statement = statement.substring(0, statement
                	.length() - 1);
    	}

    	int psnOfYou = findKeyword (statement, "you", 0);
    	int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);

    	String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
    	return "What makes you think that I " + restOfStatement + " you?";
	}
    
	private String transformIYouStatement(String statement) {
    	statement = statement.trim();
    	String lastChar = statement.substring(statement.length() - 1);
    	if(lastChar.equals(".")) {
        	statement = statement.substring(0, statement.length() -1);
    	}
    	int psnOfYou = findKeyword(statement, "I", 0);
    	int psnOfMe = findKeyword(statement, "you", psnOfYou + 2);
   	 
    	String restOfStatement = statement.substring(psnOfYou + 2, psnOfMe).trim();
    	return "Why do you " + restOfStatement + " me?";
	}




	/**
 	* Search for one word in phrase.  The search is not case sensitive.
 	* This method will check that the given goal is not a substring of a longer string
 	* (so, for example, "I know" does not contain "no").  
 	* @param statement the string to search
 	* @param goal the string to search for
 	* @param startPos the character of the string to begin the search at
 	* @return the index of the first occurrence of goal in statement or -1 if it's not found
 	*/
	private int findKeyword(String statement, String goal, int startPos)
	{
    	String phrase = statement.trim();
    	//  The only change to incorporate the startPos is in the line below
    	int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

    	//  Refinement--make sure the goal isn't part of a word
    	while (psn >= 0)
    	{
        	//  Find the string of length 1 before and after the word
        	String before = " ", after = " ";
        	if (psn > 0)
        	{
            	before = phrase.substring (psn - 1, psn).toLowerCase();
        	}
        	if (psn + goal.length() < phrase.length())
        	{
            	after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
        	}

        	//  If before and after aren't letters, we've found the word
        	if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
                	&& ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
        	{
            	return psn;
        	}

        	//  The last position didn't work, so let's find the next, if there is one.
        	psn = phrase.indexOf(goal.toLowerCase(), psn + 1);

    	}

    	return -1;
	}

	/**
 	* Search for one word in phrase.  The search is not case sensitive.
 	* This method will check that the given goal is not a substring of a longer string
 	* (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
 	* @param statement the string to search
 	* @param goal the string to search for
 	* @return the index of the first occurrence of goal in statement or -1 if it's not found
 	*/
	private int findKeyword(String statement, String goal)
	{
    	return findKeyword (statement, goal, 0);
	}



	/**
 	* Pick a default response to use if nothing else fits.
 	* @return a non-committal string
 	*/
	private String getRandomResponse()
	{
    	final int NUMBER_OF_RESPONSES = 4;
    	double r = Math.random();
    	int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
    	String response = "";

    	if (whichResponse == 0)
    	{
        	response = "Interesting, tell me more.";
    	}
    	else if (whichResponse == 1)
    	{
        	response = "Hmmm.";
    	}
    	else if (whichResponse == 2)
    	{
        	response = "Do you really think so?";
    	}
    	else if (whichResponse == 3)
    	{
        	response = "You don't say.";
    	}

    	return response;
	}

}
