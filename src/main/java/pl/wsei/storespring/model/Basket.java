package pl.wsei.storespring.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "basket")
public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@Column(name = "items")
	List<Item> items;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Item> getItems(){
		return items;
	}

	public void setItems(List<Item> item) {
		this.items = item;
	}
}
