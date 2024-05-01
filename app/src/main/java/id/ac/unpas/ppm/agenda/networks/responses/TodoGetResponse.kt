package id.ac.unpas.ppm.agenda.networks.responses

import id.ac.unpas.ppm.agenda.models.Todo

data class TodoGetResponse(
    val data: List<Todo>
)