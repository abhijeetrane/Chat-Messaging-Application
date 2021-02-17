package rfly.sip.response;

import jroll.sip.SipEndPoint;
import rfly.sip.response.entry.RfAllBusyEntry;

// Referenced classes of package rfly.sip.response:
//            RfResponse

public class RfAllBusyResponse extends RfResponse
{

    public RfAllBusyResponse(SipEndPoint sipendpoint, Long long1)
    {
        super(new RfAllBusyEntry(sipendpoint, long1));
    }

    public RfAllBusyResponse(RfAllBusyEntry rfallbusyentry)
    {
        super(rfallbusyentry);
    }
}
