package pattern.bike;

import pattern.bike.enums.Color;
import pattern.bike.enums.Feature;
import pattern.bike.enums.Type;

public class Bike {

	public Type bikeType;

	public Color bikeColor;

	public Feature bikeFeature;

	public void setBikeType(Type bikeType) {
		this.bikeType = bikeType;
	}

	public void setBikeColor(Color bikeColor) {
		this.bikeColor = bikeColor;
	}

	public void setBikeFeature(Feature bikeFeature) {
		this.bikeFeature = bikeFeature;
	}

	public Color getColor() {
		return bikeColor;
	}
}