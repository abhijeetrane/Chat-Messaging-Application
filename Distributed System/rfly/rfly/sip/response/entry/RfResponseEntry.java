package rfly.sip.response.entry;

import jroll.sip.SipCaller;
import jroll.sip.SipEndPoint;
import space.Entry;

public class RfResponseEntry
    implements Entry
{

    public Long seqno;
    public SipEndPoint target;
    public SipEndPoint source;

    public RfResponseEntry()
    {
        target = new SipEndPoint(SipCaller.getURI());
    }

    public RfResponseEntry(SipEndPoint sipendpoint, Long long1)
    {
        target = sipendpoint;
        source = new SipEndPoint(SipCaller.getURI(), SipCaller.getName());
        seqno = long1;
    }

    public RfResponseEntry(SipEndPoint sipendpoint, SipEndPoint sipendpoint1, Long long1)
    {
        target = sipendpoint;
        source = sipendpoint1;
        seqno = long1;
    }

    public String toString()
    {
        return (new StringBuilder()).append("tar =").append(target).append(" src=").append(source).append(" seqno=").append(seqno).toString();
    }
}
