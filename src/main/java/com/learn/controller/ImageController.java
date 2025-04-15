package com.learn.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.client.gridfs.model.GridFSFile;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/images")
public class ImageController {
    @Autowired
    private GridFsTemplate gridFsTemplate;
    @Autowired
    private GridFsOperations gridFsOperations;

    @PostMapping("/upload")
    public ResponseEntity<Object> uploadImage(@RequestParam("file") MultipartFile file){
        ObjectId fileId = null;
        try {
            fileId = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType());
        } catch (IOException e) {
            ResponseEntity.status(400).body("File Not Transfered");
        }
        Map<String, String> result = new HashMap<>();
        String imageUrl = "/api/images"+fileId.toHexString();
        result.put("imageUrl", imageUrl);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public void getImage(@PathVariable String id, HttpServletResponse response) {
        GridFSFile file = gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(id)));
        if(file==null) {
            response.setStatus(HttpStatus.SC_NOT_FOUND);
            return;
        }

        try(InputStream inputStream = gridFsOperations.getResource(file).getInputStream()){
            response.setContentType(file.getMetadata().getString("_contentType"));
            StreamUtils.copy(inputStream, response.getOutputStream());
        } catch (IOException e) {
            response.setStatus(HttpStatus.SC_NOT_FOUND);
            return;
        }
    }

}
