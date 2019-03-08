/**
 * 参考：
 * http://blog.csdn.net/jiangxinyu/article/details/7885518/
 */
package basic.fileio;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

/**
 * 字符文件的读写
 * @author  yiji
 * @version v1.0
 * @date    2017年5月8日 上午9:17:22
 * @Description 
 * 一、与文件相关的直接创建操作均是由字节流创立的:
 * 		FileInputStream(String fileName);在封装为字符流的时候可设置字符集编码
 * 		FileReader(String fileName);只是对FileInputStream的一层封装:好处简单，坏处不能设置编码集
 * 
 * 
 * {Reader}: (abstract 抽象类)
 * 		1.其为抽象类，不能直接实例化，只提供给别人继承使用。
 * {InputStream}: (abstract 抽象类)
 * 		1.其为抽象类，不能直接实例化，只提供给别人继承使用。
 * 
 * 
 * BufferedReader: extends Reader
 * 		public BufferedReader(Reader in);
 * 		1.继承自Reader,并【实现其抽象方法】,它的<实现不是调用底层实现而是调用Reader方法>
 * 		2.其构造参数传入的是Reader类，因此它又是InputStreamReader或者FileReader的封装
 * 		3.内部封装了读取一行的字符串方法readLine(),使用了缓冲区,读的效率较好
 * 
 * InputStreamReader: extends Reader
 * 		public InputStreamReader(InputStream in);
 * 		1.继承自Reader,并【实现其抽象方法】,<实现是调用底层nio类StreamDecoder>
 * 		2.是字节流与字符流转换的桥梁，因此可以设置 【编码类型】,其他方法没有此设置。
 * 				 |
 * 				 V
 * 	  FileReader: extends InputStreamReader
 * 		  1.继承自InputStreamReader,且完全没有新的方法实现，
 * 		  2.就是构造函数super(new FileInputStream(fileName)),
 * 		  	  也就是封装了文件名成文件流，传入InputStream中。
 * 
 * 
 * FileInputStream: extends InputStream  ==> 通常作为InputStream的参数传入字符流(InputStreamReader)
 * 		public FileInputStream(String fileName);
 * 		1.继承自InputStream,并【实现其抽象方法】,其<内部实现为native方法>
 * 		2.在抽象方法里的所有实现均为native方法，应该是由底层C语言实现文件的读入。
 * 
 * RandomAccessFile:实现多种接口，可以任意随意
 * 		public RandomAccessFile(String fileName, String mode);
 * 		public RandomAccessFile(File fileName, String mode);
 * 		1.mode为模式: "r":为只读; "rw":为读写;rws...
 * 		2.public void seek(long pos);//将游标移动到指定位置
 * 		3.public int read(byte b[]);
 * 
 */
public class FileRead {
	
	
	/**
	 * 
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
	 * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
	 * FileInputStream
	 * @param fileName
	 */
	public static void readByByte(String fileName){
		FileInputStream fiStream=null;
		try {
			System.out.println("以字节为单位读取文件内容，一次读一个字节："); 
			fiStream=new FileInputStream(fileName);
			int tempByte=0;
			while((tempByte=fiStream.read())!=-1){
				System.out.write(tempByte);
			}
			fiStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fiStream!=null){
				try {
					fiStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		////////////////////////////////////////////////////////////////
		System.out.println();
		////////////////////////////////////////////////////////////////
		try {
			System.out.println("以字节为单位读取文件内容，一次读多个字节："); 
			fiStream=new FileInputStream(fileName);
			byte[] tempBytes=new byte[100];
			int byteTotal=0;
			while((byteTotal=fiStream.read(tempBytes))!=-1){
				System.out.write(tempBytes, 0, byteTotal);
			}
			fiStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fiStream!=null){
				try {
					fiStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

	/**
	 * 单个字符读,全封装
	 * 比较耗费时间
	 * Reader: FileReader
	 * @param fileName
	 */
	public static void readByOneCharReader(String fileName){
		FileReader fileReader=null;//这个实际上就是InputStreamReader
		int ch=0;
		try {
			fileReader = new FileReader("charread.txt");
			//下面的一个一个的读的方法也是InputStreamReader里的方法
			
			//一个一个字符的读取
			while((ch=fileReader.read())!=-1){
				System.out.print((char)ch);
			}
			
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fileReader!=null){
				try {
					fileReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 以字符为单位读取文件，常用于读文本，数字等类型的文件
	 * 
	 * 单个字符读,自封装
	 * 比价耗时
	 * Reader:InputStreamReader
	 * @param fileName	   文件名
	 * @param charsetName  字符集编码，如没有则默认使用当前系统编码
	 */
	public static void readByOneCharStream(String fileName,String charsetName){
		InputStreamReader isReader=null;
		try {
			System.out.println("以字符为单位读取文件内容，一次读一个字符：");
			int tempchar=0;
			if(charsetName!=null){
				isReader=new InputStreamReader(new FileInputStream(fileName),charsetName);
			}else{
				isReader=new InputStreamReader(new FileInputStream(fileName));
			}
			//上面两句可以写成:isReader=new InputStreamReader(new FileInputStream(fileName));
			//       也等同于:fileReader = new FileReader("charread.txt");
			
			//一个一个字符的读取
			while((tempchar=isReader.read())!=-1){
				// 对于windows下，rn这两个字符在一起时，表示一个换行。  
                // 但如果这两个字符分开显示时，会换两次行。  
                // 因此，屏蔽掉r，或者屏蔽n。否则，将会多出很多空行。  
                if (((char) tempchar) != 'r') {  
                    System.out.print((char) tempchar);  
                }  
			}
			isReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(isReader!=null){
				try {
					isReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		////////////////////////////////////////////////////////////////
		System.out.println();
		////////////////////////////////////////////////////////////////
		try {
			System.out.println("以字符为单位读取文件内容，一次读多个字符：");
			char[] tempChars=new char[30];
			int charTotal=0;
			if(charsetName!=null){
				isReader=new InputStreamReader(new FileInputStream(fileName),charsetName);
			}else{
				isReader=new InputStreamReader(new FileInputStream(fileName));
			}
			//上面两句可以写成:isReader=new InputStreamReader(new FileInputStream(fileName));
			//       也等同于:fileReader = new FileReader("charread.txt");
			
			//一个一个字符的读取
			while((charTotal=isReader.read(tempChars))!=-1){
				// 同样屏蔽掉r不显示  
				// 如果读到的长度等于数组长度，则直接打印，否则过滤r
                if ((charTotal == tempChars.length)  
                        && (tempChars[tempChars.length - 1] != 'r')) {  
                    System.out.print(tempChars);  
                } else {  
                    for (int i = 0; i < charTotal; i++) {  
                        if (tempChars[i] == 'r') {  
                            continue;  
                        } else {  
                            System.out.print(tempChars[i]);  
                        }  
                    }  
                }   
			}
			isReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(isReader!=null){
				try {
					isReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * 以行为单位读取文件，常用于读面向行的格式化文件 
	 * 
	 * 行字符串读,自封装(注释里有全封装)
	 * 缓存读比较高效
	 * @param fileName
	 * @param charsetName  字符集编码，如没有则默认使用当前系统编码
	 */
	public static void readByOneLine(String fileName,String charsetName){
		BufferedReader br=null;
		try {
			System.out.println("以行为单位读取文件内容，一次读一整行：");
			String line=null;
			//下面这句话等价于全封装: 但不能指定字符集编码
			//br=new BufferedReader(new FileReader(fileName));
			if(charsetName!=null){
				br=new BufferedReader(new InputStreamReader(new FileInputStream(fileName),charsetName));
			}else{
				br=new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			}
			
			//按行读，会省略掉每行后面的回车符。而按单个字符读则不会省略。
			//因此按行读，需要自己控制回车
			while((line=br.readLine())!=null){
				//自己控制回车，用带有回车的输出接口
				System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/** 
     * 随机读取文件内容 
     *  移动到4位置再读，为了说明可自定义读的位置
     * @param fileName 
     *            文件名 
     */  
    public static void readFileByRandomAccess(String fileName) {  
        RandomAccessFile randomFile = null;  
        try {  
            System.out.println("随机读取一段文件内容：");  
            // 打开一个随机访问文件流，按只读方式  
            randomFile = new RandomAccessFile(fileName, "r");  
            // 文件长度，字节数  
            long fileLength = randomFile.length();  
            // 读文件的起始位置  
            int beginIndex = (fileLength > 4) ? 4 : 0;  
            // 将读文件的开始位置移到beginIndex位置。  
            randomFile.seek(beginIndex);  
            byte[] bytes = new byte[10];  
            int byteread = 0;  
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。  
            // 将一次读取的字节数赋给byteread  
            while ((byteread = randomFile.read(bytes)) != -1) {  
                System.out.write(bytes, 0, byteread);  
            }  
            randomFile.close();
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (randomFile != null) {  
                try {  
                    randomFile.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
  
    /** 
     * 显示输入流中还剩的字节数 
     * @param in 
     */  
    private static void showAvailableBytes(InputStream in) {  
        try {  
            System.out.println("当前字节输入流中的字节数为:" + in.available());  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//单字节或多字节读
		readByByte("charread.txt");
		
		//单个字符读,全封装
//		readByOneCharReader("charread.txt");
		
		//单个字符读,自封装
//		readByOneCharStream("charread.txt","UTF-8");
//		readByOneCharStream("charread.txt",null);
		
		//行字符串读,自封装(注释里有全封装)
//		readByOneLine("charread.txt","UTF-8");
//		readByOneLine("charread.txt",null);
		
//		readFileByRandomAccess("charread.txt");
		
	}

}
