/**
 * 
 */
package basic.fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;

/**
 * @author  yiji
 * @version v1.0
 * @date    2017年5月8日 下午12:10:09
 * @Description 
 * 
 * {Writer}: (abstract 抽象类)
 * 		1.抽象类，不能实例化，只供其他类继承使用
 * {OutputStream}: (abstract 抽象类)
 * 		1.抽象类，不能实例化，只供其他类继承使用
 * 
 * BufferedWriter: extends Writer
 * 		public BufferedWriter(Writer out)
 * 		1.继承自Writer,并【实现其抽象方法】,它的<实现不是调用底层实现而是调用Writer>
 * 		2.其构造参数传入的是Reader类，因此它又是InputStreamReader或者FileReader的封装
 * 		3.内部封装了读取一行的字符串方法readLine(),使用了缓冲区,读的效率较好
 * 
 * OutputStreamWriter: extends Writer
 * 		public OutputStreamWriter(OutputStream out);
 * 		1.继承自Writer,并【实现其抽象方法】,<实现使用底层nio类StreamEncoder>
 * 		2.是字节流与字符流转换的桥梁，因此可以设置 【编码类型】,其他方法没有此设置。
 * 				 |
 * 				 V
 * 	  FileWriter: extends OutputStreamWriter(当传入的文件没有时会自动创建)
 * 	      1.继承自OutputStreamWriter，且完全没有新的方法实现
 * 		  2.其构造函数内:super(new FileOutputStream(fileName));
 * 			封装了文件名成文件流,传入OutputStream
 * 
 * FileOutputStream: extends OutputStream
 * 		public FileOutputStream(String name)
 * 		1.继承自OutputStream,并【实现其抽象方法】,其<内部实现为native方法>
 * 		2.在抽象方法里的所有实现均为native方法，应该是由底层C语言实现文件的读入。
 * 
 * RandomAccessFile:实现多种接口，可以任意随意(当传入的文件没有时会自动创建)
 * 		public RandomAccessFile(String fileName, String mode);
 * 		public RandomAccessFile(File fileName, String mode);
 * 		1.mode为模式: "r":为只读; "rw":为读写;rws...
 * 		2.public void seek(long pos);//将游标移动到指定位置
 * 		3.public final void writeChars(String s);//
 * 		4.public final void writeBytes(String s) //deprecation
 * 
 */
public class FileWrite {
	
	/**
	 * readByByte(String fileName);         //按字节读(单字节/多字节:使用:FileInputStream)
	 * readByOneCharReader(String fileName);//按字符读(使用:FileReader)
	 * readByOneCharStream(String fileName,String charsetName);//按字符读(单/多:使用:InputStreamReader)
	 * readByOneLine(String fileName,String charsetName);      //按行读(使用:BufferedReader)
	 * readFileByRandomAccess(String fileName);                //随机自由读(使用:RandomAccessFile)
	 * 
	 * 
	 * [省略]用FileOutputStream 写入字符串的
	 * writeFile(String fileName,boolean append,String content);//写入字符串(使用:FileWriter)
	 * [省略]用OutputStreamWriter 写入字符串的
	 * writeByString(String fileName,boolean append,String content);//写入字符串(使用:BufferedWriter)
	 * writeFileByRandomAccess(String fileName, String content);//随机自由写(使用:RandomAccessFile)
	 * 
	 */
	
	
	/**
	 * 写文件:使用 FileWriter
	 * 字符串 最终转化为 字符数组 写入
	 * @param fileName
	 * @param append   是否追加写:false:覆盖写，每次都会覆盖文件中的原有内容
	 * 							 true:追加写，每次都会在文件原有内容之后写
	 * @param content
	 * 
	 */
	public static void writeFile(String fileName,boolean append,String content){
		FileWriter fw=null;
		try {
			//文件不存在则自动创建
			File file=new File(fileName);
//			if(!file.exists()){
//				try {   
//		            file.createNewFile();   
//		        } catch (IOException e) {
//		        	//创建文件失败
//		            e.printStackTrace();   
//		        }   
//			}
			//FileWriter继承了OutputStreamWriter,并且没有增加新的实现方法，
			// 因此下面的write方法均是 OutputStreamWriter中的方法
			//为true则是追加，false则覆盖
			fw=new FileWriter(file,append);
			fw.write(content);//最终都是通过write(char cbuf[], int off, int len)方法实现的
			fw.flush();
			System.out.println("写入成功!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 写字符串:使用 BufferedWriter,可写入一个回车
	 * @param fileName 文件名
	 * @param append   是否追加
	 * @param content  内容
	 */
	public static void writeByString(String fileName,boolean append,String content){
		BufferedWriter bufferedWriter=null;
		try {
			//文件不存在则自动创建
			File file=new File(fileName);
			//FileWriter继承了OutputStreamWriter,并且没有增加新的实现方法，
			// 因此下面的write方法均是 OutputStreamWriter中的方法
			//为true则是追加，false则覆盖
			bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,append)));
			bufferedWriter.write(content);
//			bufferedWriter.newLine();//写入一个回车
			bufferedWriter.flush();
			bufferedWriter.close();
			System.out.println("写入成功!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bufferedWriter!=null){
				try {
					bufferedWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 随机自定义写入文件
	 * 这里Append文件内容后
	 * @param fileName  文件名 若没有此文件则会自动创建
	 * @param content   内容
	 */
	public static void writeFileByRandomAccess(String fileName, String content) {
		RandomAccessFile randomFile=null;
        try {
            // 打开一个随机访问文件流，按读写方式
            randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
            System.out.println("写入成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
			if(randomFile!=null){
				try {
					randomFile.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
    }

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//覆盖写文件，文件不存在会自动创建
		writeFile("charwrite.txt",false,"Hello World!\njiyiren!");
		//append写
//		writeFile("charwrite.txt",true,"Hello World!\njiyiren吉!");
		
		//覆盖写
//		writeByString("charwriteLine.txt",false,"Hello World!\njiyiren!");
		//追加写
//		writeByString("charwriteLine.txt",true,"Hello World!\njiyiren!\nappend!");
		
		//随机写
//		writeFileByRandomAccess("charwriteRandom.txt","Hello World!\njiyiren!\nrandom");
	}

}
