package com.eep.CUIB.Services;

import com.eep.CUIB.Model.Asignaturas;

import java.util.ArrayList;
import java.util.List;

public interface AsignaturasService {
    public abstract String GuardarAsignaturas(ArrayList<Asignaturas> listado_asignaturas);
    public abstract List<Asignaturas> LeerAsignaturas();
    public abstract String buscarAsignaturas();
}
