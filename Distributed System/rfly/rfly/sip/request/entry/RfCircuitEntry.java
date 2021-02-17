package rfly.sip.request.entry;

import jroll.sip.SipEndPoint;

// Referenced classes of package rfly.sip.request.entry:
//            RfRequestEntry

public class RfCircuitEntry extends RfRequestEntry
{

    public RfCircuitEntry(SipEndPoint sipendpoint)
    {
        super(sipendpoint);
    }

    public RfCircuitEntry(SipEndPoint sipendpoint, SipEndPoint sipendpoint1, Long long1)
    {
        super(sipendpoint, sipendpoint1, long1);
    }
}
