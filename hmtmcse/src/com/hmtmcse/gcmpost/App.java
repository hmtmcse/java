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
		
		c.addRegId("APA91bGkk7eTbDOzOHY6KCrAMwr-eHq9FiBJxYuiSiELdEROZaJgJ-fixO4Ml3AFqLwxNxhoxL_TbBjxuKu8G16xK1YzHvjYCl7U_QfA3hJinSeGaqUSZ8uEeyEg7AkbxS4WvBHjgWESAWdRYH0Gu5GUm7XZiWPvdw");
		c.createData("Test Title", "Test Message");
		
		return c;
	}
}
