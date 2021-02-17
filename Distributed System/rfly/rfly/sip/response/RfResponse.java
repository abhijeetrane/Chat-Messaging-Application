package rfly.sip.response;

import jroll.sip.SipEndPoint;
import jroll.sip.SipResponse;
import rfly.sip.response.entry.RfResponseEntry;

public abstract class RfResponse
    implements SipResponse
{

    protected RfResponseEntry entry;

    public RfResponse(RfResponseEntry rfresponseentry)
    {
        entry = rfresponseentry;
    }

    public RfResponseEntry getEntry()
    {
        return entry;
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
}
