package rfly.sip.request;

import jroll.sip.SipEndPoint;
import rfly.sip.request.entry.RfByeEntry;

// Referenced classes of package rfly.sip.request:
//            RfRequest

public class RfByeRequest extends RfRequest
{

    public RfByeRequest(SipEndPoint sipendpoint)
    {
        super(new RfByeEntry(sipendpoint));
    }

    public RfByeRequest(RfByeEntry rfbyeentry)
    {
        super(rfbyeentry);
    }
}
