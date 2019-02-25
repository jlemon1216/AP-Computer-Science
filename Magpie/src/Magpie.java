public class Magpie
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		statement = statement.toLowerCase();
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if(statement.indexOf("cat") >= 0
				|| statement.indexOf("dog") >= 0) {
			response = "Tell me more about your pets.";
		}
		else if(statement.indexOf("mr.") >= 0)
			response = "He sounds like a good teacher.";
		else if(statement.indexOf("mrs.") >= 0)
			response = "She sounds like a good teacher.";
		else if(statement.indexOf("ms.") >= 0)
			response = "She sounsd like a good teacher.";
		else if(statement.indexOf("chewy") >= 0)
			response = "What a cool cat!";
		else if(statement.indexOf("laugh") >= 0
				|| statement.indexOf("joke") >= 0) {
			response = "Thats pretty funny.";
		}
		else if(statement.indexOf("movie") >= 0)
			response = "I don't think i've seen that one.";
		else if(statement.trim().length() < 1) {
			response = "Say something please.";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
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
		else if(whichResponse == 4) {
			response = "That's unbelievable.";
		}
		else if(whichResponse == 5) {
			response = "That's weird.";
		}

		return response;
	}

}
