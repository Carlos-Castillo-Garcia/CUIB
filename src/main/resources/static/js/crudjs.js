
window.onload = function () {
    const form = document.getElementById('botones');
    document.getElementById('AlumnoAdd').onclick = function addalumnos() {
        form.setAttribute('action', '/addalumnosget');
    }

    document.getElementById('ListAlumnos').onclick = function listalumnos() {
        form.setAttribute('action', '/listalumnosget');
    }

    document.getElementById('ListAlumnosu').onclick = function listalumnos() {
        form.setAttribute('action', '/listalumnosget');
    }

    document.getElementById('AsignaturaAdd').onclick = function addasignaturas() {
        form.setAttribute('action', 'addasignaturasget');
    }

    document.getElementById('ListAsignaturas').onclick = function listasignaturas() {
        form.setAttribute('action', 'listasignaturasget');
    }

    document.getElementById('ListAsignaturasu').onclick = function listasignaturas() {
        form.setAttribute('action', 'listasignaturasget');
    }

    document.getElementById('UsuariosAdd').onclick = function addusers() {
        form.setAttribute('action', 'addusuariosget');
    }

    document.getElementById('ListUsuarios').onclick = function listusers() {
        form.setAttribute('action', 'listusuariosget');
    }
}