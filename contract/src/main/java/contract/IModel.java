package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

public IElement getElement(int x, int y);
	
	public IMobile getMobile(IMobile mobile);
	
	public boolean isMovePossible(int x, int y, IMobile mobile);
	
	public void removeElement(int x, int y);
	
	public void addElement(int x, int y, char textTag);
	
	public void setElements(int x, int y, IMobile mobile);	

	public Observable getObservable();
	
	public int getScore();

	public void setScore(int score);
}
