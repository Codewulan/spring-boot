package com.paige.sbaop.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 文件上传和解析
 *
 * @author paige
 * @create 2021-01-04 15:15
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    /**
     * 先获取servlet请求，再从中解析获取 key=file的文件
     * @param multipartRequest
     */
    @PostMapping("/file")
    public void uploadFile(MultipartHttpServletRequest multipartRequest) {
        if (null != multipartRequest) {
            MultipartFile uploadFile = multipartRequest.getFile("file");
            if (null != uploadFile) {
                System.out.println("FileName: " + uploadFile.getOriginalFilename());
                return;
            }
        }

        System.out.println("Failed to upload file!");
    }

    /**
     * 更简洁的版本，使用@RequestParam注解，直接获取文件
     * @param file  上传的文件
     */
    @PostMapping("/simple-file")
    public void uploadSimpleFile(@RequestParam("file") MultipartFile file) {
        if (null != file) {
            System.out.println("Succeed to upload! FileName: " + file.getOriginalFilename());
            return;
        }

        System.out.println("Failed to upload file!");
    }
}