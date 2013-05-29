

class Album {

    String artist
    String title
    String year
    boolean compilation

    static constraints = {
        artist blank: false
        title blank: false, unique: 'artist'
        year blank: true, matches: /\d{4}/
        compilation()

    }

    static embedded = ['review']

    static mapping = {
        sort 'artist'
    }
}
