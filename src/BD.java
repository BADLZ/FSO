
public class BD {
	
	private String nomeRobot;
	private int raio, angulo, distancia;
	private String consola;
	private boolean onOff, debug;
	private RobotLegoEV3 robot;
	
	public BD() {
		nomeRobot = new String("jh");
		raio = 10;
		angulo = 90;
		distancia = 20;
		onOff = false;
		debug = true;
		robot = new RobotLegoEV3();
	}

	public RobotLegoEV3 getRobot() {
		return robot;
	}

	public String getNomeRobot() {
		return nomeRobot;
	}

	public void setNomeRobot(String nomeRobot) {
		this.nomeRobot = nomeRobot;
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

	public int getAngulo() {
		return angulo;
	}

	public void setAngulo(int angulo) {
		this.angulo = angulo;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public String getConsola() {
		return consola;
	}

	public void setConsola(String consola) {
		this.consola = consola;
	}

	public boolean isOnOff() {
		return onOff;
	}

	public void setOnOff(boolean onOff) {
		this.onOff = onOff;
	}

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

}
