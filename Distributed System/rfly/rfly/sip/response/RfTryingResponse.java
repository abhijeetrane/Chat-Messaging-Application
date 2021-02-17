package rfly.sip.response;

import jroll.sip.SipEndPoint;
import rfly.sip.response.entry.RfTryingEntry;

// Referenced classes of package rfly.sip.response:
//            RfResponse

public class RfTryingResponse extends RfResponse
{

    public RfTryingResponse(SipEndPoint sipendpoint, Long long1)
    {
        super(new RfTryingEntry(sipendpoint, long1));
    }

    public RfTryingResponse(RfTryingEntry rftryingentry)
    {
        super(rftryingentry);
    }
}
