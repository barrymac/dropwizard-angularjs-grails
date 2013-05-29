package com.example.helloworld.core

class Saying {
	Long id
	String content

	Saying() {}

	Saying(long id, String content) {
		this.id = id
		this.content = content
	}

	@Override
	String toString() {
		"id: $id, content: $content"
	}
}
