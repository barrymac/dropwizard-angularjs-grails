package com.example.helloworld.core

import org.springframework.dao.DataIntegrityViolationException
import grails.converters.JSON
import static javax.servlet.http.HttpServletResponse.*

class PersonController {

    static final int SC_UNPROCESSABLE_ENTITY = 422

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() { }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		response.setIntHeader('X-Pagination-Total', Person.count())
		render Person.list(params) as JSON
    }

    def save() {
        def person = new Person(request.JSON)
        def responseJson = [:]
        if (person.save(flush: true)) {
            response.status = SC_CREATED
            responseJson.id = person.id
            responseJson.message = message(code: 'default.created.message', args: [message(code: 'person.label', default: 'Person'), person.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = person.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }
        render responseJson as JSON
    }

    def get() {
        def person = Person.get(params.id)
        if (person) {
			render person as JSON
        } else {
			notFound params.id
		}
    }

    def update() {
        def person = Person.get(params.id)
        if (!person) {
            notFound params.id
            return
        }

        def responseJson = [:]

        if (request.JSON.version != null) {
            if (person.version > request.JSON.version) {
				response.status = SC_CONFLICT
				responseJson.message = message(code: 'default.optimistic.locking.failure',
						args: [message(code: 'person.label', default: 'Person')],
						default: 'Another user has updated this Person while you were editing')
				cache false
				render responseJson as JSON
				return
            }
        }

        person.properties = request.JSON

        if (person.save(flush: true)) {
            response.status = SC_OK
            responseJson.id = person.id
            responseJson.message = message(code: 'default.updated.message', args: [message(code: 'person.label', default: 'Person'), person.id])
        } else {
            response.status = SC_UNPROCESSABLE_ENTITY
            responseJson.errors = person.errors.fieldErrors.collectEntries {
                [(it.field): message(error: it)]
            }
        }

        render responseJson as JSON
    }

    def delete() {
        def person = Person.get(params.id)
        if (!person) {
            notFound params.id
            return
        }

        def responseJson = [:]
        try {
            person.delete(flush: true)
            responseJson.message = message(code: 'default.deleted.message', args: [message(code: 'person.label', default: 'Person'), params.id])
        } catch (DataIntegrityViolationException e) {
            response.status = SC_CONFLICT
            responseJson.message = message(code: 'default.not.deleted.message', args: [message(code: 'person.label', default: 'Person'), params.id])
        }
        render responseJson as JSON
    }

    private void notFound(id) {
        response.status = SC_NOT_FOUND
        def responseJson = [message: message(code: 'default.not.found.message', args: [message(code: 'person.label', default: 'Person'), params.id])]
        render responseJson as JSON
    }
}
