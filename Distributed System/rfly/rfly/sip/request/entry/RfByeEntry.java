package rfly.sip.request.entry;

import jroll.sip.SipEndPoint;

// Referenced classes of package rfly.sip.request.entry:
//            RfRequestEntry

public class RfByeEntry extends RfRequestEntry
{

    public RfByeEntry(SipEndPoint sipendpoint)
    {
        super(sipendpoint);
    }

    public RfByeEntry(SipEndPoint sipendpoint, SipEndPoint sipendpoint1, Long long1)
    {
        source = sipendpoint1;
        target = sipendpoint;
        seqno = long1;
    }
}
