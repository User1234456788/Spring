package pl.wsei.storespring.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "basket")
public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToMany()
	@JoinColumn(name = "fk_items")
	List<Item> items;

	@OneToOne(cascade = CascadeType.ALL)
	private Promotion promotion;

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

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
}
