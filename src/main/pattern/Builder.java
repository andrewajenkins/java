package pattern;

public class Builder {

	public static void main(String args) {

		Builder pat = new Builder();

		// Create a red mountain bike with reflectors
		BikeBuilder builderA = pat.new BikeBuilder();
		builderA.setType(Type.MOUNTAINBIKE);
		builderA.setColor(Color.RED);
		builderA.setFeature(Feature.REFLECTORS);
		Bike mountainBike = builderA.getBike();

		// Create a blue road bike with headlights
		BikeBuilder builderB = pat.new BikeBuilder();
		builderB.setType(Type.ROADBIKE);
		builderB.setColor(Color.BLUE);
		builderB.setFeature(Feature.HEADLIGHTS);
		Bike roadBike = builderB.getBike();

		// Create a yellow beach cruiser with no extra features
		BikeBuilder builderC = pat.new BikeBuilder();
		builderC.setType(Type.BEACHBIKE);
		builderC.setColor(Color.YELLOW);
		Bike beachBike = builderC.getBike();

		// Use bikes to get rid of warnings
		if(mountainBike.getColor().equals(Color.YELLOW) ||
				roadBike.getColor().equals(Color.YELLOW) ||
				beachBike.getColor().equals(Color.YELLOW)) {
			System.out.println("We have a yellow bike!");
		}
	}

	class BikeBuilder {

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

	class Bike {

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

	enum Type {
		MOUNTAINBIKE, BEACHBIKE, ROADBIKE
	}

	enum Feature {
		REFLECTORS, HEADLIGHTS
	}

	enum Color {
		YELLOW, BLUE, RED
	}
}