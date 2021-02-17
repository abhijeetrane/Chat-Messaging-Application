package rfly.sip.response.entry;

import jroll.sip.SipEndPoint;
import rfly.sip.circuit.RfCircuit;

// Referenced classes of package rfly.sip.response.entry:
//            RfResponseEntry

public class RfLiveCircuitEntry extends RfResponseEntry
{

    protected RfCircuit circuit;

    public RfLiveCircuitEntry(SipEndPoint sipendpoint, Long long1, RfCircuit rfcircuit)
    {
        super(sipendpoint, long1);
        circuit = rfcircuit;
    }

    public RfCircuit getCircuit()
    {
        return circuit;
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append(" circuit=").append(circuit).toString();
    }
}
