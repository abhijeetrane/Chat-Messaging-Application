package rfly.sip.request;

import jroll.sip.SipEndPoint;
import rfly.sip.request.entry.RfCancelEntry;

// Referenced classes of package rfly.sip.request:
//            RfRequest

public class RfCancelRequest extends RfRequest
{

    public RfCancelRequest(SipEndPoint sipendpoint)
    {
        super(new RfCancelEntry(sipendpoint));
    }

    public RfCancelRequest(RfCancelEntry rfcancelentry)
    {
        super(rfcancelentry);
    }
}
