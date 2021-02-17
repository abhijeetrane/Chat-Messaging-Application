package rfly.sip.circuit;


// Referenced classes of package rfly.sip.circuit:
//            RfCircuit

public static final class  extends Enum
{

    public static final CONTROL_SEND_FROM SEND_TO;
    public static final CONTROL_SEND_FROM SEND_FROM;
    public static final CONTROL_SEND_FROM CONTROL_SEND_TO;
    public static final CONTROL_SEND_FROM CONTROL_SEND_FROM;
    private static final CONTROL_SEND_FROM $VALUES[];

    public static final [] values()
    {
        return ([])$VALUES.clone();
    }

    public static t_3B_.clone valueOf(String s)
    {
        return (t_3B_.clone)Enum.valueOf(rfly/sip/circuit/RfCircuit$Port, s);
    }

    static 
    {
        SEND_TO = new <init>("SEND_TO", 0);
        SEND_FROM = new <init>("SEND_FROM", 1);
        CONTROL_SEND_TO = new <init>("CONTROL_SEND_TO", 2);
        CONTROL_SEND_FROM = new <init>("CONTROL_SEND_FROM", 3);
        $VALUES = (new .VALUES[] {
            SEND_TO, SEND_FROM, CONTROL_SEND_TO, CONTROL_SEND_FROM
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
