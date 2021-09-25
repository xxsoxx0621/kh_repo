package electronic;


// 정보은닉 규칙
// 외부로 보여질 필요가 없는 기능은 private 키워드로 감추고,
// 직접적인 접근을 차단해야하는 Field는 private으로 감춘 후 public method로 접근을 제한하는 방식
// 클래스 개발자의 안정성 및 클래스 사용자의 편의성을 취할 수 있음.
// 캡슐화 

// 접근제한자
// private / < default(package) / < protected  / < public
// package는 폴더를 부르는 다른 이름


public class Tv {

	private int channel;
	private int volume;
	
	
	// Setters / Getters 
	
	
	
	//set이라는 키워드가 붙여져 있으면, 매개변수가 반드시 있어야함
//	public void setChannel(int cha){
//		channel = cha;
//	}
//	
//	public int getChannel() {
//		return channel;
//	}
//	
//	public void setVolume(int vol){
//		volume = vol;
//	}
//	
//	public int getVolume() {
//		return volume;
//	}
	
	

//	public void channelUp() {
//		if(channel < 1000) {
//			channel++;
//		}
//	}
//
//	public void channelDown() {
//		if(channel > 0) {
//			channel --;	
//		}
//	}

	public void powerOn() {
		channel = 10;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		//this 는 변수 
		this.channel = channel;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public void powerOff() {}
}
