package sun.ajaxJava.practice.fetchData;

public class Country {

	public long recNo;
	public String code;
	public String name;
	public String continent;
	public String region;
	public long population;
	public String capital;
	
	public Country() {
	}
	
	public Country(long recNo, String code, String name, String continent, String region, long population,
			String capital) {
		super();
		this.recNo = recNo;
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.population = population;
		this.capital = capital;
	}

	public long getRecNo() {
		return recNo;
	}
	public void setRecNo(long recNo) {
		this.recNo = recNo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
}
