package mobile;

import java.io.File;

import contract.Permeability;
import model.Model;

public class EnnemyCar extends Mobile{

	private static File ENNEMY_CAR = new File(Model.class.getResource(FILE + "ennemy_car.jpg").getFile());
	private static Permeability PERMEABILITY = Permeability.BLOCKING;
	
	public EnnemyCar(int x, int y) {
		super(ENNEMY_CAR, x, x, PERMEABILITY);
		this.setName("EnnemyCar");
	}

}
