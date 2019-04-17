package com.taotao.service.impl;

import com.taotao.common.utils.FtpUtil;
import com.taotao.common.utils.IDUtils;
import com.taotao.service.PictureService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PictureServiceImpl implements PictureService {
  /*  @Value("FTP_ADDRESS")
    private String FTP_ADDRESS;
    @Value("FTP_POST")
    private Integer FTP_POST;
    @Value("FTP_USERNAME")
    private String FTP_USERNAME;
    @Value("FTP_PASSWORD")
    private String FTP_PASSWORD;
    @Value("FTP_BASE_PATH")
    private String FTP_BASE_PATH;
    @Value("FTP_BASE_URL")
    private String FTP_BASE_URL;*/
    @Override
    public Map uploadPicture(MultipartFile uploadFile) {
        Map resoltMap = new HashMap();
        try {
            //获取文件名称
            String oldName=uploadFile.getOriginalFilename();
            //截取后缀
            String ext = oldName.substring(oldName.lastIndexOf("."));
            //获取新名字
            String newName = IDUtils.genImageName();
            newName = newName + ext;
            //filePath
            DateTime dateTime = new DateTime();
            String fileName = dateTime.toString("/yyyy/MM/dd");
            //进行图片上传
            boolean result = FtpUtil.uploadFile("192.168.25.133", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images",
                    fileName, newName, uploadFile.getInputStream());
            if(!result){
                resoltMap.put("error",1);
                resoltMap.put("message","上传失败");
                return resoltMap;
            }
            resoltMap.put("error",0);
            resoltMap.put("url","http://192.168.25.133/images"+fileName+"/"+newName);
            return resoltMap;
        } catch (IOException e) {
            resoltMap.put("error",1);
            resoltMap.put("message","上传异常");
            return resoltMap;
        }

    }
}
