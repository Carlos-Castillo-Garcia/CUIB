package com.eep.CUIB.Services;

import com.eep.CUIB.Model.Asignaturas;

import java.util.ArrayList;
import java.util.List;

public interface AsignaturasService {
    public abstract String GuardarAsignaturas(ArrayList<Asignaturas> listado_asignaturas);
    public abstract String GuardarAsignaturas_BM(ArrayList<Asignaturas> lista_datos);
    public abstract List<Asignaturas> LeerAsignaturas();
    public abstract Asignaturas buscarAsignaturas(int id);
    public abstract String BajaAsignaturasId(int id);
    public abstract String ModificacionAsignaturas(Asignaturas asignaturas);
}
