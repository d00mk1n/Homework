package homeworkFall2015;

import homeworkFall2015.Dog.BrainState;

class GoodMood implements Dog.BrainState {

	/**
	 * 
	 */
	private Dog GoodMood;

	/**
	 * @param dog
	 */
	GoodMood(Dog dog) {
		GoodMood = dog;
	}

	private static final int MAX_STROKES = 3;
	int count;
	
	@Override
	public void feed() {
		GoodMood.eat();
		GoodMood.wag();
	}

	@Override
	public void stroke() {
		GoodMood.wag(); GoodMood.bark();
		count++;
		if (count >= MAX_STROKES) {
			GoodMood.brainState = new BadMood(GoodMood);
		}
	}
}