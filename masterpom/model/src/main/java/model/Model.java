package model;

import java.util.Hashtable;
import java.util.Observable;

import contract.IMobile;
import contract.IModel;
import contract.Permeability;
import elements.Element;
import mobile.*;
/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */

public class Model extends Observable implements IModel {
	private Element[][] elements;
	private Element element;
	Hashtable<String, IMobile> mobiles;

	public Model() {
		this.elements = new Element[3][9];
	}

	
	public Observable getObservable() {
		return this;
	}


	public Element getElement(int x, int y) {
		return this.elements[x][y];
	}


	public IMobile getMobile(IMobile mobile) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean isMovePossible(int x, int y, IMobile mobile) {
		if (this.getElement(x, y) == null){
			setChanged();
			notifyObservers();
			return true;
		}
		
		else if (this.getElement(x, y).getPermeability()==Permeability.BLOCKING){
			if (this.getElement(x, y).getPermeability() == this.getElement(mobile.getX(), mobile.getY()).getPermeability() ){
				setChanged();
				notifyObservers();
				return false;
			}
			this.setElement(this.mobiles.get("Lorann").getX(), this.mobiles.get("Lorann").getY(), null);
			this.mobiles.get("PlayerCar").setAlive(false);
			this.mobiles.remove("PlayerCar");
			setChanged();
			notifyObservers();
			return false;
		}
		return false;
	}


	public void removeElement(int x, int y) {
		// TODO Auto-generated method stub
		
	}


	public void addElement(int x, int y, char textTag) {
		switch (textTag) {
		case 'P':
			this.mobiles.put("PlayerCar", new PlayerCar(x, y));
			this.element = (Element) mobiles.get("PlayerCar");
			this.elements[x][y] = this.element;
			break;
		case 'E':
			this.mobiles.put("EnnemyCar", new EnnemyCar(x, y));
			this.element = (Element) mobiles.get("EnnemyCar");
			this.elements[x][y] = this.element;
			break;
			
			default:
				break;
		}
		
		
		// TODO Auto-generated method stub
		
	}


	public void setElements(int x, int y, IMobile mobile) {
		this.elements[x][y] = (Element) element;
		
	}
	
	 public void setElement(int x, int y, Element element) {
			this.elements[x][y] = element;
		}


	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setScore(int score) {
		// TODO Auto-generated method stub
		
	}
}
