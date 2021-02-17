package rfly.sip.request;

import jroll.sip.SipEndPoint;
import jroll.sip.SipException;
import rfly.sip.request.entry.RfAckEntry;

// Referenced classes of package rfly.sip.request:
//            RfRequest

public class RfAckRequest extends RfRequest
{

    public RfAckRequest(SipEndPoint sipendpoint, Integer integer)
    {
        super(new RfAckEntry(sipendpoint, integer));
    }

    public RfAckRequest(RfAckEntry rfackentry)
    {
        super(rfackentry);
    }

    public Integer getStatus()
        throws SipException
    {
        if(!(entry instanceof RfAckEntry))
        {
            throw new SipException("ack request internal error");
        } else
        {
            return ((RfAckEntry)entry).getStatus();
        }
    }
}
