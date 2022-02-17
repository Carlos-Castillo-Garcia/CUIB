package com.eep.CUIB.Services;

import com.eep.CUIB.Model.Asignaturas;

import java.util.ArrayList;
import java.util.List;

public interface AsignaturasService {
    String GuardarAsignaturas(ArrayList<Asignaturas> listado_asignaturas);

    String GuardarAsignaturas_BM(ArrayList<Asignaturas> lista_datos);

    List<Asignaturas> LeerAsignaturas();

    Asignaturas buscarAsignaturas(int id);

    String BajaAsignaturasId(int id);

    String ModificacionAsignaturas(Asignaturas asignaturas);

    void inicio();
}
