package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import contract.IModel;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {
	private int score;
	JToolBar scoreBar = new JToolBar();
	JLabel label = new JLabel("Score : ");
	private IModel world;
	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;

	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame, IModel model) throws IOException{
		this.world = model;
		this.setViewFrame(viewFrame);
		this.setSize(700, 520);
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());
		scoreBar.setPreferredSize(new Dimension(700, 20));
		scoreBar.add(label);
        this.add(scoreBar, BorderLayout.SOUTH);
		viewFrame.getModel().getObservable().addObserver(this);
	}

	/**
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		try {
			graphics.setColor(Color.GRAY);
			graphics.fillRect(0, 0, 192, 768);
			this.score = this.world.getScore();
			this.label.setText("Score : " + this.score);
			for (int x = 32; x < 672; x = x + 32) {
				for (int y = 32; y < 416; y = y + 32) {
					if (world.getElement((x / 32) - 1, (y / 32) - 1) != null) {
						graphics.drawImage(world.getElement((x / 32) - 1, (y / 32) - 1).getImage(), x, y, this);
					}
				}
			}
		} catch (IOException e) {
	}
	}
}
