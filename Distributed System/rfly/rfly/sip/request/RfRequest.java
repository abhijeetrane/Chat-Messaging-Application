package rfly.sip.request;

import jroll.sip.SipEndPoint;
import jroll.sip.SipRequest;
import rfly.sip.request.entry.RfRequestEntry;

public abstract class RfRequest
    implements SipRequest
{

    protected RfRequestEntry entry;

    public RfRequest(RfRequestEntry rfrequestentry)
    {
        entry = rfrequestentry;
    }

    public Long getSeqno()
    {
        return entry.seqno;
    }

    public SipEndPoint getSource()
    {
        return entry.source;
    }

    public SipEndPoint getTarget()
    {
        return entry.target;
    }

    public RfRequestEntry getEntry()
    {
        return entry;
    }
}
