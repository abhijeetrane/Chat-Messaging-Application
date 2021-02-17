package rfly.sip.response;

import jroll.sip.SipException;
import rfly.sip.response.entry.RfAllBusyEntry;
import rfly.sip.response.entry.RfBusyEntry;
import rfly.sip.response.entry.RfLiveCircuitEntry;
import rfly.sip.response.entry.RfOkEntry;
import rfly.sip.response.entry.RfResponseEntry;
import rfly.sip.response.entry.RfRingingEntry;
import rfly.sip.response.entry.RfTryingEntry;

// Referenced classes of package rfly.sip.response:
//            RfOkResponse, RfRingingResponse, RfTryingResponse, RfCircuitResponse, 
//            RfBusyResponse, RfAllBusyResponse, RfResponse

public class RfResponseFactory
{

    public RfResponseFactory()
    {
    }

    public static RfResponse getResponse(RfResponseEntry rfresponseentry)
        throws Exception
    {
        if(rfresponseentry instanceof RfOkEntry)
        {
            return new RfOkResponse((RfOkEntry)rfresponseentry);
        }
        if(rfresponseentry instanceof RfRingingEntry)
        {
            return new RfRingingResponse((RfRingingEntry)rfresponseentry);
        }
        if(rfresponseentry instanceof RfTryingEntry)
        {
            return new RfTryingResponse((RfTryingEntry)rfresponseentry);
        }
        if(rfresponseentry instanceof RfLiveCircuitEntry)
        {
            return new RfCircuitResponse((RfLiveCircuitEntry)rfresponseentry);
        }
        if(rfresponseentry instanceof RfBusyEntry)
        {
            return new RfBusyResponse((RfBusyEntry)rfresponseentry);
        }
        if(rfresponseentry instanceof RfAllBusyEntry)
        {
            return new RfAllBusyResponse((RfAllBusyEntry)rfresponseentry);
        } else
        {
            throw new SipException("response factory invalid entry");
        }
    }
}
