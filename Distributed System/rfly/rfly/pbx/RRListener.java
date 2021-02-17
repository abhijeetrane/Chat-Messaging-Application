package rfly.pbx;

import jroll.sip.*;
import rfly.sip.request.RfCircuitRequest;
import rfly.sip.request.RfHandbackRequest;
import space.nucleus.Logger;

// Referenced classes of package rfly.pbx:
//            RespondCircuitThread, RespondHandbackThread

class RRListener
    implements SipListener
{

    public RRListener()
    {
    }

    public void requestEvent(SipRequest siprequest)
    {
        Logger.getInstance().write((new StringBuilder()).append("PBX received ").append(siprequest.getClass().getName()).append(" from ").append(siprequest.getSource().getURI()).toString());
        if(siprequest instanceof RfCircuitRequest)
        {
            (new RespondCircuitThread((RfCircuitRequest)siprequest)).start();
        } else
        if(siprequest instanceof RfHandbackRequest)
        {
            (new RespondHandbackThread((RfHandbackRequest)siprequest)).start();
        }
    }

    public void responseEvent(SipResponse sipresponse)
    {
        Logger.getInstance().write((new StringBuilder()).append("PBX received ").append(sipresponse.getClass().getName()).append(" from ").append(sipresponse.getSource().getURI()).toString());
    }
}
