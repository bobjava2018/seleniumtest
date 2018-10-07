package cn.baibo.tetris;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 
 * 每个图形的一小格
 * @author Administrator
 *
 */
public class Cell {
	private int width=29;
	private int height=29;
   private int row;
   private int col;
   private BufferedImage img;
   public Cell(int row,int col,BufferedImage img){
	   this.row=row;
	   this.col=col;
	   this.img=img;
   }
   public void moveRight(){
	   col++;
   }
   public void moveLeft(){
	   col--;
   }
   public void drop(){
	   row++;
   }
public int getRow() {
	return row;
}
public void setRow(int row) {
	this.row = row;
}
public int getCol() {
	return col;
}
public void setCol(int col) {
	this.col = col;
}
public BufferedImage getImg() {
	return img;
}
public void setImg(BufferedImage img) {
	this.img = img;
}
public void paint(Graphics g){
	   g.drawImage(this.img,this.getCol()*29,this.getRow()*29, null);
}  

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + col;
	result = prime * result + row;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cell other = (Cell) obj;
	if (col != other.col)
		return false;
	if (row != other.row)
		return false;
	return true;
}
public String toString(){
	return "("+row+","+col+")";
}
}
