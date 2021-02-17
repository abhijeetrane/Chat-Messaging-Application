package rfly.sip.request;

import jroll.sip.SipEndPoint;
import rfly.sip.request.entry.RfCircuitEntry;

// Referenced classes of package rfly.sip.request:
//            RfRequest

public class RfCircuitRequest extends RfRequest
{

    public RfCircuitRequest(SipEndPoint sipendpoint)
    {
        super(new RfCircuitEntry(sipendpoint));
    }

    public RfCircuitRequest(RfCircuitEntry rfcircuitentry)
    {
        super(rfcircuitentry);
    }
}
