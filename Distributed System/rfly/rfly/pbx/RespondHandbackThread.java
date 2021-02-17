package rfly.pbx;

import java.io.PrintStream;
import jroll.sip.SipEndPoint;
import jroll.sip.SipException;
import rfly.sip.RfSiplet;
import rfly.sip.circuit.RfCircuitFactory;
import rfly.sip.request.RfHandbackRequest;
import rfly.sip.response.RfOkResponse;
import space.nucleus.Logger;

// Referenced classes of package rfly.pbx:
//            RfServlet

class RespondHandbackThread extends Thread
{

    private RfHandbackRequest request;

    public RespondHandbackThread(RfHandbackRequest rfhandbackrequest)
    {
        request = rfhandbackrequest;
    }

    public void run()
    {
        try
        {
            RfSiplet rfsiplet = RfServlet.getSiplet();
            Logger logger = Logger.getInstance();
            SipEndPoint sipendpoint = new SipEndPoint(request.getSource().getURI());
            Long long1 = request.getSeqno();
            logger.write((new StringBuilder()).append("PBX sending Ok response to for handback request ").append(sipendpoint.getURI()).append(" seqno=").append(long1).toString());
            rfsiplet.respond(new RfOkResponse(sipendpoint, long1));
            rfly.sip.circuit.RfCircuit rfcircuit = request.getCircuit();
            if(rfcircuit == null)
            {
                logger.write("PBX got null circuit, not recycling.");
            } else
            {
                logger.write((new StringBuilder()).append("PBX recycling circuit ").append(rfcircuit).toString());
                RfCircuitFactory.handback(rfcircuit);
            }
        }
        catch(SipException sipexception)
        {
            System.err.println(sipexception);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
