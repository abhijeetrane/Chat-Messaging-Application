package rfly.sip.response;

import jroll.sip.SipEndPoint;
import rfly.sip.circuit.RfCircuit;
import rfly.sip.response.entry.RfLiveCircuitEntry;

// Referenced classes of package rfly.sip.response:
//            RfResponse

public class RfCircuitResponse extends RfResponse
{

    public RfCircuitResponse(SipEndPoint sipendpoint, Long long1, RfCircuit rfcircuit)
    {
        super(new RfLiveCircuitEntry(sipendpoint, long1, rfcircuit));
    }

    public RfCircuitResponse(RfLiveCircuitEntry rflivecircuitentry)
    {
        super(rflivecircuitentry);
    }

    public RfCircuit getCircuit()
    {
        return ((RfLiveCircuitEntry)entry).getCircuit();
    }
}
