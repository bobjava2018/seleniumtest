package cn.baibo.tetris;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
 
/**
* 
* 形状类
*/
public abstract class Shape {
   Cell []cells=new Cell[4];
   private BufferedImage img;
/**
 * 向右移动
 */
public void right(){
	Cell[] cells=getCells();
	   for(Cell cell:cells){
		   cell.moveRight();
	   }
   }
 
/**
 * 向左移动
 */
public void left(){
	Cell[] cells=getCells();
	   for(Cell cell:cells){
		   cell.moveLeft();
	   }
   }
   public void drop(){
	   for(Cell cell:cells){
		   cell.drop();
	   }
   }
/**
 * 向右旋转
 * @param cells
 */
public void rollRight(Cell[] cells){
	   int row=cells[1].getRow();
	   int col=cells[1].getCol();
	   for(Cell cell:cells){
		   int r=cell.getRow();
		   int c=cell.getCol();
		   //和同一行的情况
		   if(r==row&&c!=col&&c!=col+2){
			   if(c==col-1){
				   cell.setRow(row-1);
			   }else{   
				   cell.setRow(row+1);
			   }
			   cell.setCol(col);
		   }else if(c==col&&r!=row){//和圆点不同行但是和圆点同列
			   if(r==row-1){
				   cell.setCol(col+1);
			   }else{
				   cell.setCol(col-1);
			   }
			   cell.setRow(row);
		   }else if(r==row-1&&c!=col){//和圆点不同行不同列但是row为圆点的row-1
			   if(c==col-1){
				   cell.setRow(row-1);
			   }else{
				  
				   cell.setRow(row+1);
			   }
			   cell.setCol(col+1);
		   }else if(r==row+1&&c!=col){//和圆点不同行不同列但是row为圆点的row+1
			   if(c==col+1){
				   cell.setRow(row+1);
			   }else{
				   cell.setRow(row-1);
			   }
			   cell.setCol(col-1);
		   }else if(r==row&&c==col+2){//I的第最后一个格子
			   cell.setCol(col);
			   cell.setRow(row+2);
		   }
	   }
	   
   }
/**
 * 向左旋转
 * @param cells
 */
public void rollLeft(Cell[] cells){
	   int row=cells[1].getRow();
	   int col=cells[1].getCol();
	   for(Cell cell:cells){
		   int r=cell.getRow();
		   int c=cell.getCol();
		   //和同一行的情况
		   if(r==row&&c!=col){
			   if(c==col-1){
				   cell.setRow(row+1);
			   }else{   
				   cell.setRow(row-1);
			   }
			   cell.setCol(col);
		   }else if(c==col&&r!=row&&r!=row+2){//和圆点不同行但是和圆点同列
			   if(r==row-1){
				   cell.setCol(col-1);
			   }else{
				   cell.setCol(col+1);
			   }
			   cell.setRow(row);
		   }else if(r==row-1&&c!=col){//和圆点不同行不同列但是row为圆点的row-1
			   if(c==col-1){
				   cell.setRow(row+1);
			   }else{
				  
				   cell.setRow(row-1);
			   }
			   cell.setCol(col-1);
		   }else if(r==row+1&&c!=col){//和圆点不同行不同列但是row为圆点的row+1
			   if(c==col+1){
				   cell.setRow(row-1);
			   }else{
				   cell.setRow(row+1);
			   }
			   cell.setCol(col+1);
		   }else if(r==row+2&&c==col){
			   cell.setCol(col+2);
			   cell.setRow(row);
		   }
	   }
	   
   }
   public static BufferedImage getImage(String name){
	   try {
		   BufferedImage img=ImageIO.read(Shape.class.getResource(name));
		 	return img;
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException();
	}
   }
   public abstract Cell[] getCells();
   public abstract void RightRoll();
   public abstract void LeftRoll();
}
class T extends Shape{
    private static BufferedImage img;
    static{
    	img=getImage("T.png");
    	
    }
	public T(){
		cells[0]=new Cell(0,4,img);
		cells[1]=new Cell(0,5,img);
		cells[2]=new Cell(0,6,img);
		cells[3]=new Cell(1,5,img);
	}
	public void RightRoll(){
		Cell[]ce=this.getCells();
		rollRight(ce);
	}
	public void LeftRoll(){
		Cell[]ce=this.getCells();
		rollLeft(ce);
	}
	@Override
	public Cell[] getCells() {
		return this.cells;
	}
}
	class L extends Shape{
	    private static BufferedImage img;
	    static{
	    	img=getImage("L.png");
	    	
	    }
		public L(){
			cells[0]=new Cell(1,4,img);
			cells[1]=new Cell(1,5,img);
			cells[2]=new Cell(1,6,img);
			cells[3]=new Cell(0,6,img);
		}
		public void RightRoll(){
			Cell[]ce=this.getCells();
			rollRight(ce);
		}
		public void LeftRoll(){
			Cell[]ce=this.getCells();
			rollLeft(ce);
		}
		@Override
		public Cell[] getCells() {
			return this.cells;
		}
	  
}
	class J extends Shape{
		private static BufferedImage img;
		static{
			img=getImage("L.png");
			
		}
		public J(){
			cells[0]=new Cell(1,4,img);
			cells[1]=new Cell(1,5,img);
			cells[2]=new Cell(1,6,img);
			cells[3]=new Cell(0,4,img);
		}
		public void RightRoll(){
			Cell[]ce=this.getCells();
			rollRight(ce);
		}
		public void LeftRoll(){
			Cell[]ce=this.getCells();
			rollLeft(ce);
		}
		@Override
		public Cell[] getCells() {
			return this.cells;
		}
		
	}
	class Z extends Shape{
		private static BufferedImage img;
		static{
			img=getImage("Z.png");
			
		}
		public Z(){
			cells[0]=new Cell(0,4,img);
			cells[1]=new Cell(1,5,img);
			cells[2]=new Cell(0,5,img);
			cells[3]=new Cell(1,6,img);
		}
		public void RightRoll(){
			Cell[]ce=this.getCells();
			rollRight(ce);
		}
		public void LeftRoll(){
			Cell[]ce=this.getCells();
			rollLeft(ce);
		}
		@Override
		public Cell[] getCells() {
			return this.cells;
		}
		
	}
	class S extends Shape{
		private static BufferedImage img;
		static{
			img=getImage("Z.png");
			
		}
		public S(){
			cells[0]=new Cell(1,4,img);
			cells[1]=new Cell(1,5,img);
			cells[2]=new Cell(0,5,img);
			cells[3]=new Cell(0,6,img);
		}
		public void RightRoll(){
			Cell[]ce=this.getCells();
			rollRight(ce);
		}
		public void LeftRoll(){
			Cell[]ce=this.getCells();
			rollLeft(ce);
		}
		@Override
		public Cell[] getCells() {
			return this.cells;
		}
		
	}
	class O extends Shape{
		private static BufferedImage img;
		static{
			img=getImage("O.png");
			
		}
		public O(){
			cells[0]=new Cell(1,4,img);
			cells[1]=new Cell(1,5,img);
			cells[2]=new Cell(0,4,img);
			cells[3]=new Cell(0,5,img);
		}
		public void RightRoll(){
		
		}
		public void LeftRoll(){	
		}
		@Override
		public Cell[] getCells() {
			return this.cells;
		}
		
	}
	class I extends Shape{
		private static BufferedImage img;
		static{
			img=getImage("I.png");
			
		}
		private int flag=0;
		public I(){
			cells[0]=new Cell(1,4,img);
			cells[1]=new Cell(1,5,img);
			cells[2]=new Cell(1,6,img);
			cells[3]=new Cell(1,7,img);
		}
		public void RightRoll(){//I只设置两个状态
			Cell[]ce=this.getCells();
			 if(flag++%2==0){
				 rollRight(ce); 
			 }else{
				 rollLeft(ce);
			 }
			
		}
		public void LeftRoll(){
			Cell[]ce=this.getCells();
			rollLeft(ce);
		}
		@Override
		public Cell[] getCells() {
			return this.cells;
		}
		
	}
