package rfly.sip.request;

import jroll.sip.SipException;
import rfly.sip.request.entry.RfAckEntry;
import rfly.sip.request.entry.RfByeEntry;
import rfly.sip.request.entry.RfCancelEntry;
import rfly.sip.request.entry.RfCircuitEntry;
import rfly.sip.request.entry.RfHandbackEntry;
import rfly.sip.request.entry.RfInviteEntry;
import rfly.sip.request.entry.RfRequestEntry;

// Referenced classes of package rfly.sip.request:
//            RfInviteRequest, RfAckRequest, RfCancelRequest, RfByeRequest, 
//            RfCircuitRequest, RfHandbackRequest, RfRequest

public class RfRequestFactory
{

    public RfRequestFactory()
    {
    }

    public static RfRequest getRequest(RfRequestEntry rfrequestentry)
        throws Exception
    {
        if(rfrequestentry instanceof RfInviteEntry)
        {
            return new RfInviteRequest((RfInviteEntry)rfrequestentry);
        }
        if(rfrequestentry instanceof RfAckEntry)
        {
            return new RfAckRequest((RfAckEntry)rfrequestentry);
        }
        if(rfrequestentry instanceof RfCancelEntry)
        {
            return new RfCancelRequest((RfCancelEntry)rfrequestentry);
        }
        if(rfrequestentry instanceof RfByeEntry)
        {
            return new RfByeRequest((RfByeEntry)rfrequestentry);
        }
        if(rfrequestentry instanceof RfCircuitEntry)
        {
            return new RfCircuitRequest((RfCircuitEntry)rfrequestentry);
        }
        if(rfrequestentry instanceof RfHandbackEntry)
        {
            return new RfHandbackRequest((RfHandbackEntry)rfrequestentry);
        } else
        {
            throw new SipException("request factory invalid entry");
        }
    }
}
