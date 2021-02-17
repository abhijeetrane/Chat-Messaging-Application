package rfly.sip.request;

import jroll.sip.SipEndPoint;
import rfly.sip.circuit.RfCircuit;
import rfly.sip.request.entry.RfInviteEntry;

// Referenced classes of package rfly.sip.request:
//            RfRequest

public class RfInviteRequest extends RfRequest
{

    public RfInviteRequest(SipEndPoint sipendpoint, RfCircuit rfcircuit)
    {
        super(new RfInviteEntry(sipendpoint, rfcircuit));
    }

    public RfInviteRequest(RfInviteEntry rfinviteentry)
    {
        super(rfinviteentry);
    }

    public RfCircuit getCircuit()
    {
        return ((RfInviteEntry)entry).getCircuit();
    }

    public void setBlock(boolean flag)
    {
        ((RfInviteEntry)entry).setBlock(Boolean.valueOf(flag));
    }

    public boolean getBlock()
    {
        return ((RfInviteEntry)entry).getBlock();
    }
}
