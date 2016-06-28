package elements;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.IElement;
import contract.Permeability;

public abstract class Element implements IElement{
	BufferedImage image;
	Permeability permeability;
	protected static String FILE = "/sprites/";
	private File sprite;
	
	public Element(File SPRITE, Permeability PERMEABILITY) {
		this.sprite = SPRITE;
		this.permeability = PERMEABILITY;
	}

	public void setSprite(File sprite) {
		this.sprite = sprite;
	}

	public Permeability getPermeability() {
		return permeability;
	}

	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	public BufferedImage getImage() throws IOException{
		this.image = ImageIO.read(this.sprite);
		return this.image;
	}
}
