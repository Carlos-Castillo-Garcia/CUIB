window.onload = function () {
    const form = document.getElementById("listado");

    document.getElementById('update').onclick = function update() {
        form.setAttribute('action', 'updateasignaturasget')
        form.setAttribute('method', 'get')
    }

    document.getElementById('delete').onclick = function deletes() {
        form.setAttribute('action', 'delasignaturaspost')
        form.setAttribute('method', 'post')
    }
}