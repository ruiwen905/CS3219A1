public class FilterWrapper implements Runnable{
	private Filter[] filters;
	
	public FilterWrapper(Filter[] filters){
		this.filters=filters;
		for(int i=0; i<filters.length-1;i++){
			Pipe p = new Pipe();
			filters[i].setOutput(p);
			filters[i+1].setInput(p);
		}
	}
	
	public void run(){
		for(int i=0;i<filters.length;i++){
			filters[i].run();
		}
	}
}