package com.hmtmcse.gcmpost;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Sending POST to GCM" );
        
        String apiKey = "AIzaSyBIKWp8lf7rtjNOjB2b-DslsTC8Y6_z4N8";
        Content content = createContent();
        
        POST2GCM.post(apiKey, content);
    }
    
    public static Content createContent(){
		
		Content c = new Content();
		
		c.addRegId("APA91bFom2RYnl4BGHW5fQjFXPztKezr6F70iyRdFJ6ebMEuP4K6jHTp1U_kOlOwzJRJGt_cEsfTeN0GiijeE3pQSRJ6pjIwcX30lli3Vaqjga0kaoY3pK_1kVmBgX84O3GG893zSMq3h-LYyYKtwwQxEALjYwD-wg");
		c.createData("Test Title", "Test Message");
		
		return c;
	}
}
