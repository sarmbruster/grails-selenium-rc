package musicstore.auth

import musicstore.auth.User

/**
 * Authority domain class.
 */
class Role {

	static hasMany = [people: User]

	/** description */
	String description
	/** ROLE String */
	String authority

	static constraints = {
		authority(blank: false, unique: true)
		description()
	}

	static mapping = {
		people cascade: "all,delete-orphan"
	}
}
