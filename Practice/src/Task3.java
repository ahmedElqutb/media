import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Task3 {
	
	// we model the image's greyscale histogram as an array of length 256 where the index of the cell represents the corresponding
	//grey level and the value within this cell is the frequency of the level
	
public static int[] createImageHistogram(File in) throws IOException{
		
		BufferedImage img=ImageIO.read(in);
		int w=img.getWidth();
		int h=img.getHeight();
		int[][] imgMat=new int[w][h];
		
		for(int i=0;i<w;i++){
			
			for(int j=0;j<h;j++){
				
				Color c=new Color(img.getRGB(i, j));
				
				imgMat[i][j]=(int)(c.getRed()); //in grayscale images the values of red, green and blue are equal in the RGB Model
			
			}
			
		}
		
		int[] imageHistogram = new int[256];
		
		for (int i = 0; i < imageHistogram.length; i++) {
			
			imageHistogram[i] = 0;
		
		}
		
		for (int i = 0; i < imgMat.length; i++) {
		
			for(int j = 0; j < imgMat[i].length; j++){
			
				imageHistogram[imgMat[i][j]]++;
			
			}
		}
	
		return imageHistogram;
		
	}
	
	public static void main(String[] args) throws IOException {
		
		int[] imgHstgrm = createImageHistogram(new File("grayscale.jpg"));
		
		for(int i = 0; i < imgHstgrm.length; i++)
			System.out.println(imgHstgrm[i]);
		
	}
	
}
