package request;

import java.util.List;

public class productRequest {
	private String label;
	private String title;
	private String location;
    private int surface;
	private double price;
	private String discription;
	private boolean solde;
	private boolean verified;
	private String userId;
	private List<String> images;
	private entities.category category;
	private String sellerAddress;
	
	
	public productRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public productRequest(String label, String title, String location, int surface, double price, String discription,
			boolean solde, boolean verified, String userId, List<String> images, entities.category category,
			String sellerAddress) {
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
		this.images = images;
		this.category = category;
		this.sellerAddress = sellerAddress;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}



	
	public entities.category getCategory() {
		return category;
	}
	public void setCategory(entities.category category) {
		this.category = category;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getSurface() {
		return surface;
	}
	public void setSurface(int surface) {
		this.surface = surface;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public boolean isSolde() {
		return solde;
	}
	public void setSolde(boolean solde) {
		this.solde = solde;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	

}
