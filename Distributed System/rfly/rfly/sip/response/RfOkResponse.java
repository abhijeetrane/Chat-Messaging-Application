package rfly.sip.response;

import jroll.sip.SipEndPoint;
import rfly.sip.response.entry.RfOkEntry;

// Referenced classes of package rfly.sip.response:
//            RfResponse

public class RfOkResponse extends RfResponse
{

    public RfOkResponse(SipEndPoint sipendpoint, Long long1)
    {
        super(new RfOkEntry(sipendpoint, long1));
    }

    public RfOkResponse(RfOkEntry rfokentry)
    {
        super(rfokentry);
    }
}
