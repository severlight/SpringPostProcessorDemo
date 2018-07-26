package postprocessordemo.jmx;

import lombok.Getter;
import lombok.Setter;

public class ProfilingController implements ProfilingControllerMBean {
    @Getter @Setter
    private boolean enabled;
}
