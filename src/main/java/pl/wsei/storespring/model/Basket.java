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

	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "FK_Item")
	List<Item> items;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "promotion_id")
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
