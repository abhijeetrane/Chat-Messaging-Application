package rfly.sip.response.entry;

import java.net.URI;
import jroll.sip.SipEndPoint;

// Referenced classes of package rfly.sip.response.entry:
//            RfResponseEntry

public class RfRedirectEntry extends RfResponseEntry
{

    protected URI uri;

    public RfRedirectEntry(SipEndPoint sipendpoint, Long long1, URI uri1)
    {
        super(sipendpoint, long1);
        uri = uri1;
    }

    public URI getURI()
    {
        return uri;
    }
}
