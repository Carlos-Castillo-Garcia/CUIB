package com.eep.CUIB.Component;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("AsignaturasComponent")
public class AsignaturasComponent {
    private static final Log LOG = LogFactory.getLog(AsignaturasComponent.class);

    public String errores(String mensaje){
        return "ERROR: " + mensaje;
    }
    public String info(String mensaje){
        return "INFO: " + mensaje;
    }

}
