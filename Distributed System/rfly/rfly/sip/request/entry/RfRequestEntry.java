package rfly.sip.request.entry;

import jroll.sip.SipCaller;
import jroll.sip.SipEndPoint;
import space.Entry;

public class RfRequestEntry
    implements Entry
{

    public Long seqno;
    public SipEndPoint target;
    public SipEndPoint source;
    protected static long transid = 0L;

    public RfRequestEntry()
    {
        target = new SipEndPoint(SipCaller.getURI());
    }

    public RfRequestEntry(SipEndPoint sipendpoint)
    {
        source = new SipEndPoint(SipCaller.getURI(), SipCaller.getName());
        seqno = new Long(transid++);
        target = sipendpoint;
    }

    public RfRequestEntry(SipEndPoint sipendpoint, SipEndPoint sipendpoint1, Long long1)
    {
        target = sipendpoint;
        source = sipendpoint1;
        seqno = long1;
    }

}
