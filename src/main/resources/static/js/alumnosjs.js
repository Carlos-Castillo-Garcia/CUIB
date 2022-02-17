window.onload = function () {
    const form = document.getElementById("listado");

    document.getElementById('update').onclick = function update() {
        form.setAttribute('action', 'updatealumnosget')
        form.setAttribute('method', 'get')
    }

    document.getElementById('delete').onclick = function deletes() {
        form.setAttribute('action', 'delalumnospost')
        form.setAttribute('method', 'post')
    }

    document.getElementById('asignaturas').onclick = function list_asignaturas() {
        form.setAttribute('action', 'asig_x_alumnos')
        form.setAttribute('method', 'get')
    }
}