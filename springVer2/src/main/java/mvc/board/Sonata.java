package mvc.board;

public class Sonata {
	
	String carColor = "black";
	int speed = 0;
	int wheelNum =0;

	
	public Sonata() {}
	// herCar
	public Sonata(String carColor, int speed) {
		this.carColor = carColor;
		this.speed = speed;
	}
	// himCar
	public Sonata(String carColor, int speed, int wheelNum) {
		this.carColor = carColor;
		this.speed = speed;
		this.wheelNum = wheelNum;
	}
	
	@Override
	public String toString() {
		return "차동차 색상은 "+carColor+" 이고, 현재 속도는 "+speed+" km/h이고, 바퀴수는 "+wheelNum+" 개 입니다.";
	}
	

}
