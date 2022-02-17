package com.eep.CUIB.ServicesImpl;

import com.eep.CUIB.Component.LogComponent;
import com.eep.CUIB.Model.Asignaturas;
import com.eep.CUIB.Services.AsignaturasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service("AsignaturasServiceImpl")
public class AsignaturasServiceImpl implements AsignaturasService {
    File AsignaturasFile = new File("src\\main\\java\\com\\eep\\CUIB\\Repository\\Asignaturas.txt");

    FileReader fr = null;
    BufferedReader br = null;
    FileWriter fw = null;
    BufferedWriter bw = null;

    ArrayList <Asignaturas> datos = new ArrayList();

    @Autowired
    @Qualifier("AsignaturasComponent")
    private LogComponent logComponent;

    @Override
    public List<Asignaturas> LeerAsignaturas() {
        List<Asignaturas> list_asignaturas = new ArrayList();
        String content;
        try {
            fr = new FileReader(AsignaturasFile);
            br = new BufferedReader(fr);
            while ((content = br.readLine()) != null) {
                String[] asignaturas = content.split("#");
                Asignaturas test = new Asignaturas(Integer.parseInt(asignaturas[0]), asignaturas[1],
                        Integer.parseInt(asignaturas[2]), Integer.parseInt(asignaturas[3]),
                        Integer.parseInt(asignaturas[4]));
                list_asignaturas.add(test);
            }
        } catch (FileNotFoundException e) {
            logComponent.errores("Archivo no encontrado");
        } catch (IOException e) {
            logComponent.errores("Lectura del Archivo incorrecta");
        } finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                logComponent.errores("Error en el cierre del BufferWriter y el FileReader de la lectura de los Camioneros");
            }
        }
        return list_asignaturas;
    }

    @Override
    public String GuardarAsignaturas(ArrayList<Asignaturas> listado_asignaturas) {
        String mensaje = "";
        int ultimo_id;
        int nuevo_id;
        if(LeerAsignaturas().size()>0){
            ultimo_id = LeerAsignaturas().get(LeerAsignaturas().size() - 1).getId();
            nuevo_id = ultimo_id+1;
        }else{
            nuevo_id = 1;
        }
        listado_asignaturas.get(0).setId(nuevo_id);
        try {
            if(listado_asignaturas.size()>0) {
                fw = new FileWriter(AsignaturasFile, true);
                bw = new BufferedWriter(fw);
                for (int i = 0; i < listado_asignaturas.size(); i++) {
                    String datos = listado_asignaturas.get(i).toString();
                    bw.write(datos + "\n");
                }
                mensaje = "Asignaturas Guardadas";
                bw.flush();
            } else {
                logComponent.errores("No hay ningun dato a guardar");
            }
        } catch (FileNotFoundException e) {
            logComponent.errores("Archivo AsignaturaFile no encontrado");
        } catch (IOException e) {
            logComponent.errores("Fallo en la lectura del archivo AsignaturaFile");
        } finally {
            try {
                fw.close();
                bw.close();
            } catch (IOException e) {
                logComponent.errores("Error en el cierre del Writer");
            }
        }
        return mensaje;
    }

    @Override
    public String GuardarAsignaturas_BM(ArrayList<Asignaturas> lista_datos) {
        BufferedWriter bw = null;
        try {
            if(lista_datos.size()>0) {
                bw = new BufferedWriter(new FileWriter(AsignaturasFile));
                for (int i = 0; i < lista_datos.size(); i++) {
                    String datos = lista_datos.get(i).toString();
                    bw.write(datos + "\n");
                }
            }else{
                System.out.println("prubeas");
            }
            bw.close();
        } catch (IOException e) {
            logComponent.errores("Error en el cierre del BufferWriter y el FileReader de la lectura de los Camioneros");
        }
        return "Camionero guardado con exito";
    }

    @Override
    public String BajaAsignaturasId(int id){
        BufferedWriter bw;
        String mensaje = null;
        datos = (ArrayList<Asignaturas>) this.LeerAsignaturas();
        if(datos.size() > 10){
            for (int i = 0; i < datos.size(); i++){
                if(datos.get(i).getId() == id){
                    datos.remove(i);
                    mensaje = "Asignatura dado de baja";
                    break;
                }else {
                    mensaje = "No se ha encontrado ninguna Asignatura.";
                }
            }
            this.GuardarAsignaturas_BM(datos);
        }else {
            mensaje = "No hay Asignatura suficientes para el borrado de ella";
        }
        return mensaje;
    }

    @Override
    public String ModificacionAsignaturas(Asignaturas asignatura) {
        this.datos = (ArrayList<Asignaturas>) this.LeerAsignaturas();
        String mensaje = null;
        for (int i = 0; i < datos.size(); i++){
            if(datos.get(i).getId() == asignatura.getId()){
                datos.get(i).setId(asignatura.getId());
                datos.get(i).setNombre(asignatura.getNombre());
                datos.get(i).setCurso(asignatura.getCurso());
                datos.get(i).setHoras(asignatura.getHoras());
                datos.get(i).setCuatrimestre(asignatura.getCuatrimestre());
                mensaje = "Asignatura modificado correctamente";
                break;
            }else{
                mensaje = "No se ha encontrado ninguna Asignatura";
            }
        }
        this.GuardarAsignaturas_BM(datos);
        return mensaje;
    }

    @Override
    public Asignaturas buscarAsignaturas(int id) {
        Asignaturas encontrada = new Asignaturas();
        datos = (ArrayList<Asignaturas>) this.LeerAsignaturas();

        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).getId() == id) {
                encontrada = datos.get(i);
                break;
            }
        }
        return encontrada;
    }

    @Override
    public void inicio() {
        if (this.LeerAsignaturas().size() <= 0) {
            ArrayList<Asignaturas> inicio = new ArrayList<>();
            inicio.add(new Asignaturas(1, "Matematicas", 1, 35, 2));
            inicio.add(new Asignaturas(2, "Lengua", 1, 90, 1));
            inicio.add(new Asignaturas(3, "Ciencias", 3, 0, 2));
            inicio.add(new Asignaturas(4, "Programacion", 4, 82, 2));
            inicio.add(new Asignaturas(5, "Arimetica", 2, 71, 1));
            inicio.add(new Asignaturas(6, "Educacion Fisica", 1, 80, 1));
            inicio.add(new Asignaturas(7, "Sociales", 2, 20, 2));
            inicio.add(new Asignaturas(8, "Bases de Datos", 3, 10, 1));
            inicio.add(new Asignaturas(9, "Lenguaje de Marcas", 4, 45, 2));
            inicio.add(new Asignaturas(10, "Sistemas de Gestion Empresarial", 1, 50, 1));
            this.GuardarAsignaturas(inicio);
        }
    }
}
