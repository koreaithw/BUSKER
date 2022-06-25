package com.example.teamprojeect.controller.show;

import com.example.teamprojeect.domain.vo.show.ShowFileVO;
import com.example.teamprojeect.service.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
@RequiredArgsConstructor
@RequestMapping("/file/concert/*")
@Controller
public class ShowFileController {
    @Autowired
    private ShowService showService;

    // upload
    // 기본 파일 저장경로 설정
    @PostMapping("/upload")
    @ResponseBody
    public List<ShowFileVO> upload(MultipartFile[] uploadFiles) throws IOException {
        String uploadFolder = "C:/upload";
        ArrayList<ShowFileVO> files = new ArrayList<>();

//        yyyy/MM/dd 경로 만들기
        File uploadPath = new File(uploadFolder, getFolder());
        if(!uploadPath.exists()){uploadPath.mkdirs();}

        for(MultipartFile file : uploadFiles){
            ShowFileVO showFileVO = new ShowFileVO();
            // 화면으로 데이터를 보내주기 위함. for문안에 써주어야 함
            String uploadFileName = file.getOriginalFilename();

            // uuid
            UUID uuid = UUID.randomUUID(); // 네트워크 상에서 각각의 객체들을 식별하기 위해서 사용
            showFileVO.setFileName(uploadFileName); // 중복될 가능성이 거의 없다고 인정되기 때문에 많이 사용됨
            showFileVO.setUuid(uuid.toString());
            showFileVO.setUploadPath(getFolder());
            uploadFileName = uuid.toString() + "_" + uploadFileName;

            log.info("--------------------------------");
            log.info("Upload File Name : " + uploadFileName);
            log.info("Upload File Size : " + file.getSize());

//            showFileVO.setFileSize(file.getSize());

            File saveFile = new File(uploadPath, uploadFileName);
            file.transferTo(saveFile);

            if(checkImageType(saveFile)){
                FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
                Thumbnailator.createThumbnail(file.getInputStream(), thumbnail, 100, 100);
                thumbnail.close(); // close 메서드가 플러쉬?를 써준다.
            }
            files.add(showFileVO);
        }
        return files;
    }

    // display
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

    // download
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

    // delete
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
    public ShowFileVO find(Long showNumber){
        log.info("get file find....... : " + showNumber);
        return showService.find(showNumber);
    }

    @GetMapping("/file")
    @ResponseBody
    public ShowFileVO getFile(Long showNumber) {
        log.info("file " + showNumber);
        return showService.find(showNumber);
    }
}