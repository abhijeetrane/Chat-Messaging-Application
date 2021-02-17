package rfly.sip.request.entry;

import jroll.sip.SipEndPoint;

// Referenced classes of package rfly.sip.request.entry:
//            RfRequestEntry

public class RfAckEntry extends RfRequestEntry
{

    protected Integer status;

    public RfAckEntry(SipEndPoint sipendpoint, Integer integer)
    {
        super(sipendpoint);
        status = integer;
    }

    public RfAckEntry(SipEndPoint sipendpoint, SipEndPoint sipendpoint1, Long long1)
    {
        source = sipendpoint1;
        target = sipendpoint;
        seqno = long1;
        status = new Integer(0);
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer integer)
    {
        status = integer;
    }
}
