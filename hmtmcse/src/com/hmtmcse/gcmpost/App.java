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
		
		c.addRegId("APA91bGNYv-DyWleeJv3Y4K1Gm2Q_yLdq3A2HeCzZDg9npXuc483IUJBiVvJrV7T14AUOIIGcjdHnZ1HbQiqAT0r7F5CgMsXXciX6DYUSkIWI07RbWGXrShb5F5xyvgai2jN3CzzSrqv1mhj5gOiD30AZkYZCHiJf6RFibxKzAb3225tfRZvCXE");
		c.createData("Test Title", "Test Message");
		
		return c;
	}
}
