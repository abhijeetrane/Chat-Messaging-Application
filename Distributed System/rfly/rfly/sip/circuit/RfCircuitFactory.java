package rfly.sip.circuit;

import java.io.*;
import java.util.*;
import jroll.sip.SipException;

// Referenced classes of package rfly.sip.circuit:
//            RfCircuit

public class RfCircuitFactory
{

    public static final String CIRCUIT_BASE = "circuits.db";
    public static final int CIRCUIT_FIELDS = 5;
    protected static Stack rack;
    protected static Stack used;

    public RfCircuitFactory()
    {
    }

    public static synchronized RfCircuit getCircuit()
    {
        if(rack == null)
        {
            init();
        }
        if(rack.empty())
        {
            return null;
        } else
        {
            RfCircuit rfcircuit = (RfCircuit)rack.pop();
            used.push(rfcircuit);
            return rfcircuit;
        }
    }

    public static synchronized void handback(RfCircuit rfcircuit)
        throws Exception
    {
        if(rack == null)
        {
            throw new SipException("circuit factory appears uninitialized");
        }
        if(rfcircuit == null)
        {
            throw new SipException("null circuit not recycled");
        }
        boolean flag = false;
        Iterator iterator = used.iterator();
        do
        {
            if(!iterator.hasNext())
            {
                break;
            }
            RfCircuit rfcircuit1 = (RfCircuit)iterator.next();
            if(!rfcircuit1.equals(rfcircuit))
            {
                continue;
            }
            add(rfcircuit);
            flag = true;
            break;
        } while(true);
        if(!flag)
        {
            throw new SipException((new StringBuilder()).append("handback circuit ").append(rfcircuit).append(" not checked out").toString());
        } else
        {
            return;
        }
    }

    protected static void init()
    {
        rack = new Stack();
        used = new Stack();
        try
        {
            BufferedReader bufferedreader = new BufferedReader(new FileReader("circuits.db"));
            String s;
            while((s = bufferedreader.readLine()) != null) 
            {
                loadCircuit(s);
            }
        }
        catch(IOException ioexception)
        {
            System.err.println("WARNING circuit factory circuits.db not found.");
            loadDefault();
        }
        catch(Exception exception)
        {
            System.err.println(exception);
            exception.printStackTrace();
        }
    }

    protected static void loadCircuit(String s)
        throws Exception
    {
        StringTokenizer stringtokenizer = new StringTokenizer(s);
        String s1 = null;
        int ai[] = new int[4];
        int i;
        for(i = 0; stringtokenizer.hasMoreTokens(); i++)
        {
            if(i > 5)
            {
                throw new SipException("field overflow in circuit base");
            }
            String s2 = stringtokenizer.nextToken();
            if(i == 0)
            {
                s1 = s2;
                continue;
            }
            try
            {
                ai[i - 1] = Integer.parseInt(s2);
            }
            catch(Exception exception)
            {
                throw new SipException("bad port in circuit database");
            }
        }

        if(i != 5)
        {
            throw new SipException("field underflow in circuit base");
        } else
        {
            add(new RfCircuit(s1, ai));
            return;
        }
    }

    protected static void loadDefault()
    {
        int ai[] = {
            8000, 8051, 8001, 8052
        };
        ai[0] = 8000;
        ai[1] = 8051;
        ai[2] = 8001;
        ai[3] = 8052;
        String s = "234.5.6.7";
        try
        {
            RfCircuit rfcircuit = new RfCircuit(s, ai);
            add(rfcircuit);
        }
        catch(Exception exception)
        {
            System.err.println(exception);
            exception.printStackTrace();
        }
    }

    protected static void add(RfCircuit rfcircuit)
    {
        rack.push(rfcircuit);
    }
}
