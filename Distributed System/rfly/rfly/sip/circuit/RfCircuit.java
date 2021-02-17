package rfly.sip.circuit;

import java.io.Serializable;
import java.util.EnumMap;
import jroll.sip.SipException;

public class RfCircuit
    implements Serializable
{
    public static final class Port extends Enum
    {

        public static final Port SEND_TO;
        public static final Port SEND_FROM;
        public static final Port CONTROL_SEND_TO;
        public static final Port CONTROL_SEND_FROM;
        private static final Port $VALUES[];

        public static final Port[] values()
        {
            return (Port[])$VALUES.clone();
        }

        public static Port valueOf(String s)
        {
            return (Port)Enum.valueOf(rfly/sip/circuit/RfCircuit$Port, s);
        }

        static 
        {
            SEND_TO = new Port("SEND_TO", 0);
            SEND_FROM = new Port("SEND_FROM", 1);
            CONTROL_SEND_TO = new Port("CONTROL_SEND_TO", 2);
            CONTROL_SEND_FROM = new Port("CONTROL_SEND_FROM", 3);
            $VALUES = (new Port[] {
                SEND_TO, SEND_FROM, CONTROL_SEND_TO, CONTROL_SEND_FROM
            });
        }

        private Port(String s, int i)
        {
            super(s, i);
        }
    }


    private static int portNumber = 0;
    private EnumMap portMap;
    private int ports[];
    private String iphost;
    private int type;

    public RfCircuit(String s, int ai[])
        throws Exception
    {
        portMap = new EnumMap(rfly/sip/circuit/RfCircuit$Port);
        init();
        if(ai.length != portMap.size())
        {
            throw new SipException((new StringBuilder()).append("circuit expected ").append(portMap.size()).append(" ports").toString());
        } else
        {
            iphost = s;
            ports = ai;
            return;
        }
    }

    public int getPort(Port port)
    {
        return ports[((Integer)portMap.get(port)).intValue()];
    }

    public int[] getPorts()
    {
        return ports;
    }

    public String getIPHost()
    {
        return iphost;
    }

    boolean equals(RfCircuit rfcircuit)
    {
        if(rfcircuit.ports == null || rfcircuit.ports.length != ports.length)
        {
            return false;
        }
        for(int i = 0; i < ports.length; i++)
        {
            if(ports[i] != rfcircuit.ports[i])
            {
                return false;
            }
        }

        return iphost.equals(rfcircuit.iphost);
    }

    public String toString()
    {
        return (new StringBuilder()).append("[ ").append(iphost).append(", ").append(ports[0]).append(", ").append(ports[1]).append(", ").append(ports[2]).append(", ").append(ports[3]).append(" ]").toString();
    }

    public void setType(int i)
    {
        type = i;
    }

    public int getType()
    {
        return type;
    }

    protected void init()
    {
        if(portMap.size() != 0)
        {
            return;
        } else
        {
            int i = 0;
            portMap.put(Port.SEND_TO, new Integer(i));
            portMap.put(Port.SEND_FROM, new Integer(i++));
            portMap.put(Port.CONTROL_SEND_TO, new Integer(i++));
            portMap.put(Port.CONTROL_SEND_FROM, new Integer(i++));
            ports = new int[i];
            return;
        }
    }

}
