package pe.edu.ucsp.oms.domain;

public class Promo implements BaseEntity<Integer>{
	
	Integer id;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id=id;
	}
	
}
