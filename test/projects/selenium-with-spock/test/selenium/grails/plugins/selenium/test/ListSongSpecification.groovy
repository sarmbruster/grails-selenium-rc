package grails.plugins.selenium.test

import grails.plugins.selenium.SeleniumTest
import spock.lang.Specification

@Mixin(SeleniumTest)
class ListSongSpecification extends Specification {

	void setupSpeck() {
		Song.build(title: "Myriad Harbor", artist: "The New Pornographers", album: "Challengers")
		Song.build(title: "Patty Lee", artist: "Les Savy Fav", album: "Let's Stay Friends")
		Song.build(title: "Hospital Beds", artist: "Cold War Kids", album: "Robbers and Cowards")
	}

	void cleanupSpeck() {
		Song.list()*.delete()
	}

	def "all songs are displayed in list"() {
		given: "some songs exist"
		
		when: "a user visits the song list page"
		def page = ListSongPage.open()
		
		then: "the songs are displayed in the list"
		page.rowCount == 3
		page.rows[0] == [Title: "Myriad Harbor", Artist: "The New Pornographers", Album: "Challengers"]
	}
}