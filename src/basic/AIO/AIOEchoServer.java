package basic.AIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author yiji
 * @version v1.0.0
 * @date 2018/7/26 下午9:39
 * @Description
 */

public class AIOEchoServer {

    private AsynchronousServerSocketChannel serverSocketChannel;

    public void init(int port) throws IOException {
        serverSocketChannel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(port));
    }

    public void start() {
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {
                System.out.println(Thread.currentThread().getName());
                Future<Integer> writeResult = null;
                try {
                    buffer.clear();
                    Integer count = result.read(buffer).get(100, TimeUnit.SECONDS);
                    buffer.flip();
                    System.out.println(new String(buffer.array(),0, count));
                    writeResult = result.write(buffer);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        serverSocketChannel.accept(null, this);
                        writeResult.get();
                        result.close();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("failed: " + exc);
            }
        });
    }

    public static void main(String[] args) throws IOException {
        AIOEchoServer aioEchoServer = new AIOEchoServer();
        aioEchoServer.init(8000);
        aioEchoServer.start();
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
