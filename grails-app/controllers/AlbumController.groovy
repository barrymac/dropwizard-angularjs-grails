import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON
import static javax.servlet.http.HttpServletResponse.*

class AlbumController {

    static final int SC_UNPROCESSABLE_ENTITY = 422

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		response.setIntHeader('X-Pagination-Total', Album.count())
		render Album.list(params) as JSON
    }

    def save() {
        def album = new Album(request.JSON)
        def responseJson = [:]
        if (album.save(flush: true)) {
            response.status = SC_CREATED
            responseJson.id = album.id
            responseJson.message = message(code: 'default.created.message', args: [message(code: 'album.label', default: 'Album'), album.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = album.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }
        render responseJson as JSON
    }

    def get() {
        def album = Album.get(params.id)
        if (album) {
			render album as JSON
        } else {
			notFound params.id
		}
    }

    def update() {
        def album = Album.get(params.id)
        if (!album) {
            notFound params.id
            return
        }

        def responseJson = [:]

        if (request.JSON.version != null) {
            if (album.version > request.JSON.version) {
				response.status = SC_CONFLICT
				responseJson.message = message(code: 'default.optimistic.locking.failure',
						args: [message(code: 'album.label', default: 'Album')],
						default: 'Another user has updated this Album while you were editing')
				cache false
				render responseJson as JSON
				return
            }
        }

        album.properties = request.JSON

        if (album.save(flush: true)) {
            response.status = SC_OK
            responseJson.id = album.id
            responseJson.message = message(code: 'default.updated.message', args: [message(code: 'album.label', default: 'Album'), album.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = album.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }

        render responseJson as JSON
    }

    def delete() {
        def album = Album.get(params.id)
        if (!album) {
            notFound params.id
            return
        }

        def responseJson = [:]
        try {
            album.delete(flush: true)
            responseJson.message = message(code: 'default.deleted.message', args: [message(code: 'album.label', default: 'Album'), params.id])
        } catch (DataIntegrityViolationException e) {
            response.status = SC_CONFLICT
            responseJson.message = message(code: 'default.not.deleted.message', args: [message(code: 'album.label', default: 'Album'), params.id])
        }
        render responseJson as JSON
    }

    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'album.label', default: 'Album'), params.id])]
        render responseJson as JSON
    }
}
