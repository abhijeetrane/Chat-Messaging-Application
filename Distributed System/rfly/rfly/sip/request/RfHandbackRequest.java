package rfly.sip.request;

import jroll.sip.SipEndPoint;
import rfly.sip.circuit.RfCircuit;
import rfly.sip.request.entry.RfHandbackEntry;

// Referenced classes of package rfly.sip.request:
//            RfRequest

public class RfHandbackRequest extends RfRequest
{

    public RfHandbackRequest(SipEndPoint sipendpoint, RfCircuit rfcircuit)
    {
        super(new RfHandbackEntry(sipendpoint, rfcircuit));
    }

    public RfHandbackRequest(RfHandbackEntry rfhandbackentry)
    {
        super(rfhandbackentry);
    }

    public RfCircuit getCircuit()
    {
        return ((RfHandbackEntry)entry).getCircuit();
    }
}
