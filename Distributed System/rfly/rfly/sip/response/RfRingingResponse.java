package rfly.sip.response;

import jroll.sip.SipEndPoint;
import rfly.sip.response.entry.RfRingingEntry;

// Referenced classes of package rfly.sip.response:
//            RfResponse

public class RfRingingResponse extends RfResponse
{

    public RfRingingResponse(SipEndPoint sipendpoint, Long long1)
    {
        super(new RfRingingEntry(sipendpoint, long1));
    }

    public RfRingingResponse(RfRingingEntry rfringingentry)
    {
        super(rfringingentry);
    }
}
