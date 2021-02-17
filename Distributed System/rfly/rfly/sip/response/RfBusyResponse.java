package rfly.sip.response;

import jroll.sip.SipEndPoint;
import rfly.sip.response.entry.RfBusyEntry;

// Referenced classes of package rfly.sip.response:
//            RfResponse

public class RfBusyResponse extends RfResponse
{

    public RfBusyResponse(SipEndPoint sipendpoint, Long long1)
    {
        super(new RfBusyEntry(sipendpoint, long1));
    }

    public RfBusyResponse(RfBusyEntry rfbusyentry)
    {
        super(rfbusyentry);
    }
}
