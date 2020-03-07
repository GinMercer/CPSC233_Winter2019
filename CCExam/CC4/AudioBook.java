public class AudioBook extends Book{
	private int sizeInKB;
	private double playbackRatio;
	
	public AudioBook(String title, int numOfWords, int sizeInKB){
		super(title,numOfWords);
		if(sizeInKB >= 0)
			this.sizeInKB = sizeInKB;
		else
			this.sizeInKB = 0;
		if(playbackRatio >= 1.0)
			this.playbackRatio = playbackRatio;
		else
			this.playbackRatio = 1.0;
						
	}
	public AudioBook(AudioBook a){
		super(a);
		this.sizeInKB = a.sizeInKB;
		this.playbackRatio = a.playbackRatio;
	}
	
	public int getSizeInKB(){
		return this.sizeInKB;
	}
	
	public double getPlaybackRatio(){
		return this.playbackRatio;
	}
	public void setPlaybackRatio(double ratio){
		if(ratio >= 1.0)
			this.playbackRatio = ratio;
		else
			this.playbackRatio = 1.0;
	}
	
	public int minutesToConsume(){
		int c;
		c = (int)((sizeInKB / 1920) / playbackRatio);
		return c;
	}
	
	public String toString(){
		return super.toString() + " Size: " + this.getSizeInKB() + " Ratio: " + this.getPlaybackRatio();
	}
}