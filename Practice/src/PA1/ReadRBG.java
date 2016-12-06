package PA1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.*;

class Triple{
	int r;
	int b;
	int g;
	Triple(int r, int b, int g){
		this.r=r;
		this.b=b;
		this.g=g;
	}
}

public class ReadRBG{
	
	public static void main(String[] args){
		BufferedImage img=null;
		try {
			img=ImageIO.read(new File("C:\\Users\\ashraf\\Desktop\\C.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		int h=img.getHeight();
		int w=img.getWidth();
		Triple[][] imgMat=new Triple[w][h];
		int[][]imgM=new int[w][h];
		for(int i=0;i<w;i++){
			for(int j=0;j<h;j++){
				Color c=new Color(img.getRGB(i, j));
				imgMat[i][j]=new Triple(c.getRed(), c.getBlue(), c.getGreen());
			}
		}
		
		/*for(int i=0;i<w;i++){
			for(int j=0;j<h;j++)
				System.out.print("("+imgMat[i][j].r+", "+imgMat[i][j].b+", "+imgMat[i][j].g+") ");
			System.out.println();
		}*/
		
		for(int i=0;i<w;i++){
			for(int j=0;j<h;j++){
				Color c=new Color(img.getRGB(i, j));
				imgM[i][j]=(int)(c.getRed()*.299 + c.getBlue()*.587 + c.getGreen()*.114);
			}
		}
		
		for(int i=0;i<w;i++){
			for(int j=0;j<h;j++)
				System.out.print(imgM[i][j]+" ");
			System.out.println();
		}
		
			BufferedImage gs=new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
			
			for(int i=0;i<w;i++)
				for(int j=0;j<h;j++){
					Color nC=new Color(imgM[i][j], imgM[i][j], imgM[i][j]);
					gs.setRGB(i, j, nC.getRGB());
				}
					
			File ouptut = new File("C:\\Users\\ashraf\\Desktop\\gs.jpg");
	         try {
				ImageIO.write(gs, "jpg", ouptut);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
