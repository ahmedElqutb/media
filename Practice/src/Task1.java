
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Task1{
	
	//The static method readGrayscale takes the file containing the image and the file to which it should write the Grayscale levels
	
	public static void readGrayscale(File in, File out) throws IOException{
		
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
		
		//Writing int values of 2D grayscale image matrix into .txt file
		try {
            FileWriter fw = new FileWriter(out+".txt");

            for(int i = 0; i < w; i++)
           {
               for(int j =0; j < imgMat[i].length; j++)
               {
                  if(imgMat[i][j]<10)
            	   fw.write("00"+String.valueOf(imgMat[i][j])+" ");
                  else
                	  if(imgMat[i][j]<100)
                		  fw.write("0"+String.valueOf(imgMat[i][j])+" ");
                	  else
                		  fw.write(String.valueOf(imgMat[i][j])+" ");
               }
               fw.write("\n");
           }
            fw.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
	
	}
	
	public static void main(String[] args) throws IOException{
		
		//testing readGrayscale method on attached image gs
		readGrayscale(new File("grayscale.jpg"), new File("grayscale Values.txt"));
			
		}
	
}
