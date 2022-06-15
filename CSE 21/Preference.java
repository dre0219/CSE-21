public class Preference {
	private int quietTime;
	private int music;
	private int reading;
	private int chatting;
	
	public Preference(int q, int m, int r, int c) {
		this.quietTime = q;
		this.music = m;
		this.reading = r;
		this.chatting = c;
		
	}
	
	public int compare(Preference pref) {
		int difference = Math.abs(pref.getQuietTime() - quietTime);
		difference += Math.abs(pref.getMusic() - music);
		difference += Math.abs(pref.getReading() - reading);
		difference += Math.abs(pref.getChatting() - chatting);
		
		return difference;		
	}
	
	public int getQuietTime() { return quietTime; }
	public int getMusic() { return music; }
	public int getReading() { return reading; }
	public int getChatting() { return chatting; }
}
