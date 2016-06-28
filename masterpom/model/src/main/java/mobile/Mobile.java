package mobile;

import java.io.File;

import elements.Element;
import contract.IMobile;
import contract.Permeability;

public abstract class Mobile extends Element implements IMobile {
	private int x;
	private int y;
	private int savedX;
	private int savedY;
	private String name;
	private boolean Alive = true;
	
public Mobile(File SPRITE, int x, int y ,Permeability PERMEABILITY) {

	super(SPRITE, PERMEABILITY);
	this.setX(x);
	this.setY(y);
}


public void moveUp() {
	this.setY(this.getY() - 1);
}

public void moveLeft() {
	this.setX(this.getX() - 1);
}

public void moveDown() {
	this.setY(this.getY() + 1);
}

public void moveRight() {
	this.setX(this.getX() + 1);
}


public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public void savePosition() {
	this.savedX = getX();
	this.savedY = getY();
}

public int getSavedX() {
	return savedX;
}

public int getSavedY() {
	return savedY;
}
public boolean isAlive() {
	return Alive;
}

public void setAlive(boolean alive) {
	Alive = alive;
}
}
