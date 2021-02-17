package rfly.pbx;

import java.io.PrintStream;
import java.net.InetAddress;
import java.net.URI;
import jroll.sip.SipCaller;
import rfly.sip.RfSiplet;
import space.nucleus.Logger;
import space.remote.RemoteSpace;

// Referenced classes of package rfly.pbx:
//            RRListener

public class RfServlet
{

    public static boolean DEBUG = true;
    private static final String SPACEOBJ = "spacesip";
    private static final String SIP_CONFIG = "sip.config";
    private static RfSiplet siplet;

    public RfServlet()
    {
        try
        {
            InetAddress inetaddress = InetAddress.getLocalHost();
            String s = inetaddress.getHostName().toLowerCase();
            String s1 = (new StringBuilder()).append("rmi://").append(s).append("/").append("spacesip").toString();
            if(DEBUG)
            {
                System.out.println((new StringBuilder()).append("launching spacesip url = ").append(s1).toString());
            }
            RemoteSpace remotespace = new RemoteSpace(s1);
            Thread.sleep(1000L);
            java.io.InputStream inputstream = getClass().getResourceAsStream("sip.config");
            if(inputstream != null)
            {
                System.out.println("servlet sip config file = sip.config");
                SipCaller.setConfig(inputstream);
            }
            URI uri = new URI((new StringBuilder()).append("sip:spacesip@").append(s).toString());
            Logger.getInstance().write((new StringBuilder()).append("acquiring PBX siplet uri = ").append(uri).toString());
            siplet = new RfSiplet(uri);
            if(DEBUG)
            {
                System.out.println((new StringBuilder()).append("pbx uri = ").append(SipCaller.getURI()).toString());
            }
            siplet.addListener(new RRListener());
            siplet.start();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            System.exit(1);
        }
    }

    public static RfSiplet getSiplet()
    {
        return siplet;
    }

    public static void main(String args[])
    {
        RfServlet rfservlet = new RfServlet();
    }

}
