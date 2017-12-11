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
        c.addRegId("APA91bG3SSZcYSX31mvPfeBJNdyo1CJKx5dWCefq99ZFUO5Aq_NYsvGGP8y_PGlCbAtvDQ_hDx3Q2JhORr_7mydJMSB2wdAXUEbKordA0Gx4JKFVtZf9xvWxx2KFJVCMzR0dCKNy18oT");
        c.createData("BUBT", "I Love You janu");

        return c;
    }
}
