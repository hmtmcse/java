import com.xensource.xenapi.*;
import org.apache.xmlrpc.XmlRpcException;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Touhid Mia on 29/12/2015.
 */
public class Main extends TestBase{


    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = new Connection(new URL("http://13.0.40.150"));
            Session.loginWithPassword(connection, "root", "hmtmcse", APIVersion.latest().toString());
            VM.getByUuid(connection,"afd4d4a4-a6a5-b232-2e67-4d24a0add8cc");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (XmlRpcException e) {
            e.printStackTrace();
        } catch (Types.BadServerResponse badServerResponse) {
            badServerResponse.printStackTrace();
        } catch (Types.SessionAuthenticationFailed sessionAuthenticationFailed) {
            sessionAuthenticationFailed.printStackTrace();
        } catch (Types.HostIsSlave hostIsSlave) {
            hostIsSlave.printStackTrace();
        } catch (Types.XenAPIException e) {
            e.printStackTrace();
        }


    }






}
