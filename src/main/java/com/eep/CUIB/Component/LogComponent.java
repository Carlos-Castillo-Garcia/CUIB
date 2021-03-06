package com.eep.CUIB.Component;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("AsignaturasComponent")
public class LogComponent {
    private static final Log LOG = LogFactory.getLog(LogComponent.class);

    public void errores(String mensaje) {
        LOG.error("ERROR: " + mensaje);
    }

    public void info(String mensaje) {
        LOG.info("INFO: " + mensaje);
    }

}
