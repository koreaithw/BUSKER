package com.example.teamprojeect.controller.recruit;

import com.example.teamprojeect.domain.vo.recruitment.RecruitmentFileVO;
import com.example.teamprojeect.domain.vo.work.WorkFileVO;
import com.example.teamprojeect.service.RecruitService;
import com.example.teamprojeect.service.WorkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/file/recruitment/*")
public class RecruitmentFileController {
    // 필드
    private final RecruitService recruitService;

    @PostMapping("/upload")
    @ResponseBody
    public List<RecruitmentFileVO> upload(MultipartFile[] uploadFiles) throws IOException {
        String uploadFolder = "C:/upload";
        ArrayList<RecruitmentFileVO> files = new ArrayList<>();

//        yyyy/MM/dd 경로 만들기
        File uploadPath = new File(uploadFolder, getFolder());
        if(!uploadPath.exists()){uploadPath.mkdirs();}

        for(MultipartFile file : uploadFiles){
            RecruitmentFileVO recruitmentFileVO = new RecruitmentFileVO();
            String uploadFileName = file.getOriginalFilename();

            UUID uuid = UUID.randomUUID();
            recruitmentFileVO.setFileName(uploadFileName);
            recruitmentFileVO.setUuid(uuid.toString());
            recruitmentFileVO.setUploadPath(getFolder());

            uploadFileName = uuid.toString() + "_" + uploadFileName;

            log.info("--------------------------------");
            log.info("Upload File Name : " + uploadFileName);
            log.info("Upload File Size : " + file.getSize());

//            WorkFileVO.setFileSize(file.getSize());

            File saveFile = new File(uploadPath, uploadFileName);
            file.transferTo(saveFile);

            if(checkImageType(saveFile)){
                FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
                Thumbnailator.createThumbnail(file.getInputStream(), thumbnail, 100, 100);
                thumbnail.close();
//                WorkFileVO.setImage(true);
            }
            files.add(recruitmentFileVO);
        }
        return files;
    }

    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException{
        File file = new File("C:/upload/", fileName);
        return FileCopyUtils.copyToByteArray(file);
    }

    private boolean checkImageType(File file) throws IOException{
        String contentType = Files.probeContentType(file.toPath());
        return contentType.startsWith("image");
    }

    private String getFolder(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return sdf.format(date);
    }

    @GetMapping("/download")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(String fileName) throws UnsupportedEncodingException {
        Resource resource = new FileSystemResource("C:/upload/" + fileName);
        HttpHeaders header = new HttpHeaders();
        String name = resource.getFilename();
        name = name.substring(name.indexOf("_") + 1);
        header.add("Content-Disposition", "attachment;filename="+ new String(name.getBytes("UTF-8"), "ISO-8859-1"));
        return new ResponseEntity<>(resource, header, HttpStatus.OK);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void delete(String fileName){
        File file = new File("C:/upload/", fileName);
        if(file.exists()){ file.delete(); }

        file = new File("C:/upload/", fileName.replace("s_", ""));
        if(file.exists()){ file.delete(); }
    }

    // find
    @GetMapping("/find")
    @ResponseBody
    public RecruitmentFileVO find(Long recruitmentNumber){
        log.info("get file find....... : " + recruitmentNumber);
        return recruitService.getFiles(recruitmentNumber);
    }

    @GetMapping("/find/{number}")
    @ResponseBody
    public RecruitmentFileVO getFile(@PathVariable("number") Long recruitmentNumber) {
        log.info("file " + recruitmentNumber);
        return recruitService.getFiles(recruitmentNumber);
    }

}
