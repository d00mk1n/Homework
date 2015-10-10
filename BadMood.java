package homeworkFall2015;

import homeworkFall2015.Dog.BrainState;

class BadMood implements Dog.BrainState {

	/**
	 * 
	 */
	private final Dog BadMood;

	/**
	 * @param dog
	 */
	BadMood(Dog dog) {
		BadMood = dog;
	}

	@Override
	public void feed() {
		BadMood.eat();
		BadMood.brainState = new GoodMood(BadMood);
	}

	@Override
	public void stroke() {
		BadMood.bite();
	}
	
}