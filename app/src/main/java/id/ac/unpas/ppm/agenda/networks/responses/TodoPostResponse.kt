package id.ac.unpas.ppm.agenda.networks.responses

import id.ac.unpas.ppm.agenda.models.Todo

data class TodoPostResponse(
    val message: String,
    val success: Boolean,
    val data: Todo?
)