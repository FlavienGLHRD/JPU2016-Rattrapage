package model;

import elements.Element;

public class Road {
	private int score;
	private Element[][] elementsTable;
	public Road() {
		this.setElementsTable(new Element[3][9]);
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Element[][] getElementsTable() {
		return elementsTable;
	}
	public void setElementsTable(Element[][] elementsTable) {
		this.elementsTable = elementsTable;
	}
}
