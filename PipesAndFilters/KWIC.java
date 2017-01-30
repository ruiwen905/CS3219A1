public class KWIC {

	public static void main(String[] args) {
		// This is the driver class, to start the KWIC

		Filter[] filters={new Pump(), new CircularShifter(), new Alphabetizer(), new Sink()};
		
		(new FilterWrapper(filters)).run();

	}

}