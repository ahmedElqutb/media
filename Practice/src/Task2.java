
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Task2{
	
	//The following method shrinks the range of grayscale levels from 8 bits to just 3 bits by applying Integer division 
	//on the grayscale level of every pixel by 32, then multiplying the result by 32 again to have only 8 levels, quantization,
	//where the levels are the multiples of 32 in the range [0, 255]
	//The method takes as an input the file containing a grayscale image and the file to which it should write the processed one
	
	public static void shrinkRange(File in, File out){
		
		BufferedImage img=null;
		try {
			img = ImageIO.read(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int w=img.getWidth();
		int h=img.getHeight();
		int[][] imgMat=new int[w][h];
		
		for(int i=0;i<w;i++){
			
			for(int j=0;j<h;j++){
				Color c=new Color(img.getRGB(i, j));
				
				/*if(c.getRed()!=c.getBlue()||c.getRed()!=c.getGreen()||c.getGreen()!=c.getBlue()) //check if values of R, G & B are equal in grayscale image
					throw new IOException("111");*/
				
				imgMat[i][j]=(int)(c.getRed()/32)*32; //in grayscale images the values of red, green and blue are equal in the RGB Model
			}
			
			//Writing int values of 2D grayscale image matrix into .txt file
			/*try {
	            FileWriter fw = new FileWriter("pro"+".txt");

	            for(int k = 0; k < w; k++)
	           {
	               for(int l =0; l < imgMat[k].length; l++)
	               {
	                  if(imgMat[k][l]<10)
	            	   fw.write("00"+String.valueOf(imgMat[k][l])+" ");
	                  else
	                	  if(imgMat[k][l]<100)
	                		  fw.write("0"+String.valueOf(imgMat[k][l])+" ");
	                	  else
	                		  fw.write(String.valueOf(imgMat[k][l])+" ");
	               }
	               fw.write("\n");
	           }
	            fw.close();

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }*/

		}
		
		BufferedImage processedImage=new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
		
		for(int i=0;i<w;i++)
			for(int j=0;j<h;j++){
				Color nC=new Color(imgMat[i][j], imgMat[i][j], imgMat[i][j]);
				processedImage.setRGB(i, j, nC.getRGB());
			}
				
         try {
			ImageIO.write(processedImage, "jpg", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		
		//testing the shrinkRange method on attached image
		shrinkRange(new File("grayscale.jpg"), new File("proccessed Image.jpg"));
		
		
	}
	
}
