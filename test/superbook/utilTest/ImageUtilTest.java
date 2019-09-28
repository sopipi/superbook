package superbook.utilTest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.junit.Test;

import superbook.util.ImageUtil;


public class ImageUtilTest {
@Test
public void change2jpg() throws IOException {
	File file = new File("C:/Users/再几何/Desktop/1.png");
	InputStream is = new FileInputStream(file);
	File folder = new File("C:/Users/再几何/Desktop");
	File src = new File(folder,"2.jpg");
	
	  try {
	        if(null!=is && 0!=is.available()){//available()这个方法可以在读写操作前先得知数据流里有多少个字节可以读取
	            try(FileOutputStream fos = new FileOutputStream(src)){
	                byte b[] = new byte[1024 * 1024];
	                int length = 0;
	                while (-1 != (length = is.read(b))) {
	                    fos.write(b, 0, length);
	                }
	                fos.flush();
	                //通过如下代码，把文件保存为jpg格式
	                BufferedImage img = ImageUtil.change2jpg(src);
	                ImageIO.write(img, "jpg", src);       
	            }
	            catch(Exception e){
	                e.printStackTrace();
	            }
	        }
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }  
}


@Test 
public void resizeImage() throws FileNotFoundException {
	File file = new File("C:/Users/再几何/Desktop/1.png");
	File folder = new File("C:/Users/再几何/Desktop");
	File src = new File(folder,"3.jpg");
	
	ImageUtil.resizeImage(file, 200, 200, src);
	
}
}
