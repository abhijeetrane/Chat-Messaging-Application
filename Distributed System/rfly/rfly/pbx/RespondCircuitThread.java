package rfly.pbx;

import jroll.sip.SipEndPoint;
import rfly.sip.RfSiplet;
import rfly.sip.circuit.RfCircuitFactory;
import rfly.sip.request.RfCircuitRequest;
import rfly.sip.response.*;
import space.nucleus.Logger;

// Referenced classes of package rfly.pbx:
//            RfServlet

class RespondCircuitThread extends Thread
{

    private RfCircuitRequest request;

    public RespondCircuitThread(RfCircuitRequest rfcircuitrequest)
    {
        request = rfcircuitrequest;
    }

    public void run()
    {
        try
        {
            RfSiplet rfsiplet = RfServlet.getSiplet();
            Logger logger = Logger.getInstance();
            SipEndPoint sipendpoint = new SipEndPoint(request.getSource().getURI());
            Long long1 = request.getSeqno();
            logger.write((new StringBuilder()).append("PBX sending Ok response for circuit request to ").append(sipendpoint.getURI()).append(" seqno=").append(long1).toString());
            rfsiplet.respond(new RfOkResponse(sipendpoint, long1));
            rfly.sip.circuit.RfCircuit rfcircuit = RfCircuitFactory.getCircuit();
            if(rfcircuit != null)
            {
                logger.write((new StringBuilder()).append("PBX got circuit ").append(rfcircuit).append(" for ").append(sipendpoint.getURI()).append(" seqno=").append(long1).toString());
                rfsiplet.respond(new RfCircuitResponse(sipendpoint, long1, rfcircuit));
            } else
            {
                logger.write((new StringBuilder()).append("PBX all circuits busy for ").append(sipendpoint.getURI()).append(" seqno=").append(long1).toString());
                rfsiplet.respond(new RfAllBusyResponse(sipendpoint, long1));
            }
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
