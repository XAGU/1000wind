package top.kwind.rlfz.fileupload.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.kwind.rlfz.common.constant.MessageConstants;
import top.kwind.rlfz.common.web.base.BaseController;
import top.kwind.rlfz.common.web.domain.ResuBean;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLDecoder;
import java.util.UUID;

/**
 * @author xagu
 * Created on 2020/6/11
 * Email:xagu_qc@foxmail.com
 * Describe: TODO
 */
@RestController
public class FileUploadController extends BaseController {

    @Value("${web.upload-path}")
    private String path;

    @PostMapping("/upload")
    public ResuBean fileUpLoad(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws FileNotFoundException, UnsupportedEncodingException {
        //判断文件是否为空
        if (file.isEmpty()) {
            return failure(MessageConstants.FILE_EMPTY);
        }
        //使用fileupload组件完成文件上传
        //上传的位置
        //String uploadPath = ResourceUtils.getURL("classpath:").getPath() + "static/upload";
        String uploadPath = path + "/upload";
        String filePath = "/file";
        //获取ContentType
        String contentType = file.getContentType();
        if ("image/jpeg".equals(contentType) || "image/jpg".equals(contentType)) {
            filePath = "/img";
        } else if ("video/avi".equals(contentType) || "video/mpeg4".equals(contentType) || "video/mp4".equals(contentType)) {
            filePath = "/video";
        }
        String realPath = uploadPath + filePath;
        realPath = URLDecoder.decode(realPath, "UTF-8");
        //判断该路径是否存在
        File dir = new File(realPath);
        if (!dir.exists()) {
            //创建文件夹
            if (!dir.mkdirs()) {
                return failure(MessageConstants.UPLOAD_FAILURE);
            }
        }
        //文件名
        String fileName = UUID.randomUUID().toString().replace("-", "");
        String originalFilename = file.getOriginalFilename();
        if (originalFilename.lastIndexOf('.') > 0) {
            fileName += "." + originalFilename.split("\\.")[1];
        }
        //完成文件上传
        try {
            file.transferTo(new File(realPath, fileName));
        } catch (IOException e) {
            e.printStackTrace();
            return failure(MessageConstants.UPLOAD_FAILURE);
        }
        ResuBean resuBean = success(MessageConstants.UPLOAD_SUCCESS);
        resuBean.setData("/upload" + filePath + "/" + fileName);
        return resuBean;
    }
}
