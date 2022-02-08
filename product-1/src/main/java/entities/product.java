package entities;

import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="product")
public class product {
	
	@Id
	private String id;
	
	
	private String label ;
	private String title ;
	private String location ;
	private int surface;
	private double price ;
	private String discription ;
	private boolean solde;
	private boolean verified;
	private String userId;
	private String sellerAddress;
	private List<String> images;
	

	
	@DBRef
	private category category;







	@Override
	public String toString() {
		return "product [id=" + id + ", label=" + label + ", title=" + title + ", location=" + location + ", surface="
				+ surface + ", price=" + price + ", discription=" + discription + ", solde=" + solde + ", verified="
				+ verified + ", userId=" + userId + ", images=" + images + ", category=" + category + "]";
	}



	public product(String label, String title, String location, int surface, double price, String discription,
			boolean solde, boolean verified, String userId, String sellerAddress, List<String> images,
			entities.category category) {
		super();
		this.label = label;
		this.title = title;
		this.location = location;
		this.surface = surface;
		this.price = price;
		this.discription = discription;
		this.solde = solde;
		this.verified = verified;
		this.userId = userId;
		this.sellerAddress = sellerAddress;
		this.images = images;
		this.category = category;
	}

	
	
	



	


	

}
