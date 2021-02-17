package rfly.sip.response;

import java.net.URI;
import jroll.sip.SipEndPoint;
import jroll.sip.SipException;
import rfly.sip.response.entry.RfRedirectEntry;

// Referenced classes of package rfly.sip.response:
//            RfResponse

public class RfRedirectResponse extends RfResponse
{

    public RfRedirectResponse(SipEndPoint sipendpoint, Long long1, URI uri)
    {
        super(new RfRedirectEntry(sipendpoint, long1, uri));
    }

    public RfRedirectResponse(RfRedirectEntry rfredirectentry)
    {
        super(rfredirectentry);
    }

    public URI getURI()
        throws Exception
    {
        if(!(entry instanceof RfRedirectEntry))
        {
            throw new SipException("redirect response internal error");
        } else
        {
            return ((RfRedirectEntry)entry).getURI();
        }
    }
}
