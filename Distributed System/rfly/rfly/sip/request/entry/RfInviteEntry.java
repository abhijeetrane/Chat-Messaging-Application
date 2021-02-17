package rfly.sip.request.entry;

import jroll.sip.SipEndPoint;
import rfly.sip.circuit.RfCircuit;

// Referenced classes of package rfly.sip.request.entry:
//            RfRequestEntry

public class RfInviteEntry extends RfRequestEntry
{

    protected RfCircuit circuit;
    protected Boolean blockid;

    public RfInviteEntry(SipEndPoint sipendpoint, RfCircuit rfcircuit)
    {
        super(sipendpoint);
        circuit = rfcircuit;
        blockid = new Boolean(false);
    }

    public void setBlock(Boolean boolean1)
    {
        blockid = boolean1;
    }

    public RfCircuit getCircuit()
    {
        return circuit;
    }

    public boolean getBlock()
    {
        return blockid.booleanValue();
    }
}
