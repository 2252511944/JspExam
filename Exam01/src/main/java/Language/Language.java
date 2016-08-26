package Language;

import DBS.IdEntity;

public class Language extends IdEntity {

	private String language_id;
	private String name;

	public String getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(String language_id) {
		this.language_id = language_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Language [language_id=" + language_id + ", name=" + name + ", id=" + id + "]";
	}

}
