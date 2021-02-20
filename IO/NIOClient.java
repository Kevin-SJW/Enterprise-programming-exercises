package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Classname NIOClient
 * @Description TODO
 * @Date 2019/4/22 10:08
 * @Created by 14241
 */
public class NIOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes());
        out.close();
    }
}
