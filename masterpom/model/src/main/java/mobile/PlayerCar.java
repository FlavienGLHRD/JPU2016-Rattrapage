package mobile;

import java.io.File;

import contract.Permeability;
import model.Model;

public class PlayerCar extends Mobile {
	
	private static File PLAYER_CAR = new File(Model.class.getResource(FILE + "player_car.jpg").getFile());
	private static Permeability PERMEABILITY = Permeability.BLOCKING;

	
	public PlayerCar(int x, int y) {
		super(PLAYER_CAR, x, x, PERMEABILITY);
		this.setName("PlayerCar");
	}

	

}
