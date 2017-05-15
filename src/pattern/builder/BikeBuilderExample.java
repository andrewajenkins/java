package pattern.builder;

import pattern.bike.Bike;
import pattern.bike.enums.Color;
import pattern.bike.enums.Feature;
import pattern.bike.enums.Type;

public class BikeBuilderExample {

	public static void main(String args) {

		// Create a red mountain bike with reflectors
		BikeBuilder builderA = new BikeBuilder();
		builderA.setType(Type.MOUNTAINBIKE);
		builderA.setColor(Color.RED);
		builderA.setFeature(Feature.REFLECTORS);
		Bike mountainBike = builderA.getBike();

		// Create a blue road bike with headlights
		BikeBuilder builderB = new BikeBuilder();
		builderB.setType(Type.ROADBIKE);
		builderB.setColor(Color.BLUE);
		builderB.setFeature(Feature.HEADLIGHTS);
		Bike roadBike = builderB.getBike();

		// Create a yellow beach cruiser with no extra features
		BikeBuilder builderC = new BikeBuilder();
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
}