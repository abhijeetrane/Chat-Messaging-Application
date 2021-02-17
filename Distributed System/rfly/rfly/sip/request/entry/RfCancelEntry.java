package rfly.sip.request.entry;

import jroll.sip.SipEndPoint;

// Referenced classes of package rfly.sip.request.entry:
//            RfRequestEntry

public class RfCancelEntry extends RfRequestEntry
{

    protected Integer status;

    public RfCancelEntry(SipEndPoint sipendpoint)
    {
        super(sipendpoint);
    }

    public RfCancelEntry(SipEndPoint sipendpoint, SipEndPoint sipendpoint1, Long long1)
    {
        source = sipendpoint1;
        target = sipendpoint;
        seqno = long1;
    }
}
