package com.taotao.Test;

import com.taotao.common.utils.FtpUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FtpTest {

    @Test
    public void ftpTest() throws IOException {
        //创建ftp对象
        FTPClient ftpClient = new FTPClient();
        //链接服务器
        ftpClient.connect("192.168.25.133",21);
        //登录服务器
        ftpClient.login("ftpuser","ftpuser");
        //上传文件
        //读取本地文件
        FileInputStream inputStream =
                new FileInputStream(new File("C:\\Users\\董传珂\\Desktop\\123.jpg"));
        //制订上传目录
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        //2）指定文件类型
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        ftpClient.storeFile("123.jpg",inputStream);
        ftpClient.logout();

    }
    @Test
    public void ftpTestUtils() throws FileNotFoundException {
        //读取本地文件
        FileInputStream inputStream =
                new FileInputStream(new File("C:\\Users\\董传珂\\Desktop\\123.jpg"));
        FtpUtil.uploadFile("192.168.25.133",21,"ftpuser","ftpuser","/home/ftpuser/www/images","/2018/10/11","001.jpg",inputStream);
    }
}
