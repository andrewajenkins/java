package pattern.builder;

import pattern.bike.Bike;
import pattern.bike.enums.Color;
import pattern.bike.enums.Feature;
import pattern.bike.enums.Type;

public class BikeBuilder {

	Bike bike;

	public BikeBuilder() {
		this.bike = new Bike();
	}

	public void setType(Type bikeType) {
		bike.setBikeType(bikeType);
	}

	public void setColor(Color bikeColor) {
		bike.setBikeColor(bikeColor);
	}

	public void setFeature(Feature bikeFeature) {
		bike.setBikeFeature(bikeFeature);
	}

	public Bike getBike() {
		return bike;
	}
}