package PA2;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class pA3 {
	
	public static void main(String[] args) throws IOException{
		File in = null;
		BufferedImage img=ImageIO.read(in);
		int w=img.getWidth();
		int h=img.getHeight();
		int[][] imgMat=new int[w][h];
		
		for(int i=0;i<w;i++){
			
			for(int j=0;j<h;j++){
				Color c=new Color(img.getRGB(i, j));
				
				/*if(c.getRed()!=c.getBlue()||c.getRed()!=c.getGreen()||c.getGreen()!=c.getBlue()) //check if values of R, G & B are equal in grayscale image
					throw new IOException("111");*/
				
				imgMat[i][j]=(int)(c.getRed()); //in grayscale images the values of red, green and blue are equal in the RGB Model
			}
			
		}
		
		int[] img1=new int[w*h];
		int k=0;
		for(int i=0;i<w;++i){
			for(int j=0;j<h;++j){
				img1[k]=img.getRGB(i,j);
			}
		}
		int a=1;
		ArrayList<Integer> zig=new ArrayList<Integer>();
		for(int i=1;i<img1.length;++i){
			if(img1[i]==img1[i-1]){
				a++;
			}
			else{
				zig.add(a);
				a=1;
			}
		}
	}
}
