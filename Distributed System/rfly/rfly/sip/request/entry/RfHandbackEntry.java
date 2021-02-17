package rfly.sip.request.entry;

import jroll.sip.SipEndPoint;
import rfly.sip.circuit.RfCircuit;

// Referenced classes of package rfly.sip.request.entry:
//            RfRequestEntry

public class RfHandbackEntry extends RfRequestEntry
{

    protected RfCircuit circuit;

    public RfHandbackEntry(SipEndPoint sipendpoint, RfCircuit rfcircuit)
    {
        super(sipendpoint);
        circuit = rfcircuit;
    }

    public RfCircuit getCircuit()
    {
        return circuit;
    }
}
