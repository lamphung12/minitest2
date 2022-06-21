package com.example.baitapproduct.controller;

import com.example.baitapproduct.mode.OderDetail;
import com.example.baitapproduct.service.OrderDetailIpl;
import com.example.baitapproduct.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/order")

public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping()
    public ResponseEntity<Iterable<OderDetail>> findAllOrderDetail() {
        List<OderDetail> posts = (List<OderDetail>) orderDetailService.findAll();
        if (posts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OderDetail> findOrderDetailById(@PathVariable Long id) {
        Optional<OderDetail> optionalOderDetail = orderDetailService.findById(id);
        if (!optionalOderDetail.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalOderDetail.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OderDetail> saveOrderDetail (@RequestBody OderDetail oderDetail) {
        return new ResponseEntity<>(orderDetailService.save(oderDetail), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OderDetail> updateOrderDetail (@PathVariable Long id, @RequestBody OderDetail oderDetail) {
        Optional<OderDetail> oderDetail1l = orderDetailService.findById(id);
        if (!oderDetail1l.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        oderDetail.setId(oderDetail1l.get().getId());
        return new ResponseEntity<>(orderDetailService.save(oderDetail), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OderDetail> deleteOrderDetail(@PathVariable Long id) {
        Optional<OderDetail> optionalOderDetail = orderDetailService.findById(id);
        if (!optionalOderDetail.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderDetailService.remove(id);
        return new ResponseEntity<>(optionalOderDetail.get(), HttpStatus.NO_CONTENT);
    }

//
//    @GetMapping(value = "/searchtitle")
//    public ResponseEntity<List<Post>> searchName (@RequestParam String title) {
//        List<Post> posts = (List<Post>) postService.findAllByTitleContaining(title);
//        if (posts == null) {
//            return new ResponseEntity<List<Post>>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
//    }



}
