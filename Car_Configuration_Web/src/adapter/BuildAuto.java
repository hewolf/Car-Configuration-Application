package adapter;

import java.io.Serializable;

/* This class does nothing inside but it extends the proxy and implements the CreateAuto and UpdateAuto classes */

public class BuildAuto extends ProxyAutomobile implements CreateAuto,
		UpdateAuto, ReturnAutomobile, Serializable {
}
